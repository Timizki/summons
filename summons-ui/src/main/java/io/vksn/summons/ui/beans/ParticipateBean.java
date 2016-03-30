package io.vksn.summons.ui.beans;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.entity.Invitation;
import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;
import io.vksn.summons.summonsservice.model.Login;
import io.vksn.summons.summonsservice.model.LoginResponse;
import io.vksn.summons.summonsservice.model.Participate;

@Named("participateBean")
@ConversationScoped
public class ParticipateBean {
	
	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;
	private Conversation conversation;
	private String username;
	private String password;
	private Invitation invitation;
	
	@Inject
	private FacesContext context;
	
	public Invitation getInvitations() {
		return this.invitation;
	}
	
	public void setInvitation(Invitation invitations) {
		this.invitation = invitations;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return null;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//SECURITY_WEAKNESS: weakness_25: Accessing component's value through component tree
	private String getPasswordThroughComponentTree() {
		UIInput input = (UIInput)	FacesContext.getCurrentInstance().getViewRoot().findComponent("participateForm:ogin_password");
		return input.getValue().toString();
	}
	
	public String login() {
		Login login = new Login();
		login.setUsername(getUsername());

		login.setPassword(getPasswordThroughComponentTree());
		
		LoginResponse response = service.login(login);		
		Set<String> roles = new HashSet<>();
		roles.addAll(response.getRoles());
		if(roles.contains("MANAGER")) {
			setCookieForRole("MANAGER");
			return "listEvents";
		}
		else {
			conversation.begin();
			this.invitation = response.getInvitation();
			setCookieForRole("PARTICIPANT");
			addInvitationToSession();
			return "participate.xhtml";
		}
	}
	//SECURITY_WEAKNESS: weakness-20: Users invitation is exposed to attackers which contains password other sensitive data	
	//SECURITY_WEAKNESS: weakness-16: Invitation is not serializable so session cannot be replicated
	private void addInvitationToSession() {
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("invitation", this.invitation);
	}

	//SECURITY_WEAKNESS: weakness-17: Cookie is added without calling setSecure(true)
	private void setCookieForRole(String role) {
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		//SECURITY_WEAKNESS: weakness-20: Users role is exposed to attackers
		Cookie cookie = new Cookie("ROLE", role);
		response.addCookie(cookie);
	}

	public String save() {
		Participate participate = new Participate();
		participate.setInvitation(this.invitation);
		this.service.participate(participate);
		
		conversation.end();
		return "index";
	}
}
