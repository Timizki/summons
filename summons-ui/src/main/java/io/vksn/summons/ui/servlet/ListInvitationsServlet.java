package io.vksn.summons.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;
import io.vksn.summons.summonsservice.model.ListInvitationsResponse;

@WebServlet(urlPatterns = "/listInvitation")
public class ListInvitationsServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    	String event = request.getParameter("eventId");
    	if(event != null) {
    		long eventId = Long.parseLong(event);
    		ListInvitationsResponse invitations = service.listInvitations(eventId);
    		request.setAttribute("invitations",invitations.getInvitations());
    		request.getRequestDispatcher("/WEB-INF/jsps/listInvitations.jsp").forward(request, response);
    	}
        request.getRequestDispatcher("/WEB-INF/jsps/error.jsp").forward(request, response);
    }
 
}
