package io.vksn.summons.summonsservice;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import io.vksn.summons.ejb.AuditLogger;
import io.vksn.summons.entity.Event;
import io.vksn.summons.entity.Invitation;
import io.vksn.summons.qualifier.Repository;
import io.vksn.summons.repository.ListEventsRepository;
import io.vksn.summons.repository.SummonsRepository;
import io.vksn.summons.summonsservice.model.CreateEvent;
import io.vksn.summons.summonsservice.model.CreateEventResponse;
import io.vksn.summons.summonsservice.model.GetSessionStartTime;
import io.vksn.summons.summonsservice.model.ListEvents;
import io.vksn.summons.summonsservice.model.ListEventsResponse;
import io.vksn.summons.summonsservice.model.ListInvitationsResponse;
import io.vksn.summons.summonsservice.model.Login;
import io.vksn.summons.summonsservice.model.LoginResponse;
import io.vksn.summons.summonsservice.model.Participate;
import io.vksn.summons.summonsservice.model.ParticipateResponse;

@Stateless
@javax.jws.WebService (endpointInterface="io.vksn.summons.summonsservice.SummonsServiceWS", targetNamespace="http://vksn.io/summons/summonsService/", serviceName="SummonsService", portName="SummonsService")
public class SummonsServiceSOAPBindingImpl {


	private Date userSessionStarted;
	
	@Inject
	@Repository
	private SummonsRepository summonsRepository;
	
	@EJB
	private ListEventsRepository listEventsRepository;
	
	@EJB
	private AuditLogger audit;
	
	@PostConstruct
	public void setUserName() {
		//SECURITY_WEAKNESS: weakness_3: setting client state to Singleton EJB member variable
		audit.setUser(this.toString());
		//SECURITY_WEAKNESS: weakness_5: setting client state to Stateless EJB member variable
		this.userSessionStarted = new Date();
	}

	public ListInvitationsResponse listInvitations(long listInvitations) {
		audit.addEntryLog("SummonsServiceSOAPBindingImpl.listInvitations");
		Event event = summonsRepository.findEvent(listInvitations);
		ListInvitationsResponse response = new ListInvitationsResponse();
		response.getInvitations().addAll(event.getInvitations());
		return response;
	}

	public CreateEventResponse createEvent(CreateEvent createEvent) {
		audit.addEntryLog("SummonsServiceSOAPBindingImpl.createEvent");
		Event event = summonsRepository.store(createEvent.getEvent());
		CreateEventResponse response = new CreateEventResponse();
		response.setEvent(event);
		return response;
	}

    public Event fetchEvent(long fetchEvent) {
    	audit.addEntryLog("SummonsServiceSOAPBindingImpl.fetchEvent");
    	return summonsRepository.findEvent(fetchEvent);
    }

	public ListEventsResponse listEvents(ListEvents listEvents) {
		audit.addEntryLog("SummonsServiceSOAPBindingImpl.listEvents");
		ListEventsResponse response = new ListEventsResponse();
		response.getEvents().addAll(listEventsRepository.listEvents());
        return response;
    }

	public Date getSessionStartTime(GetSessionStartTime getSessionStartTime) {
        return this.userSessionStarted;
    }

	private boolean isBlank(String value) {
		if(value == null || value.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public LoginResponse login(Login login) {
		if(isBlank(login.getUsername()) || isBlank(login.getPassword()) )  {
			return new LoginResponse();
		}
		
		Event event = summonsRepository.findEvent(login.getUsername());
		if(isParticipant(event, login.getPassword())) {
			return createResponseForRoles("PARTICIPANT");
		}
		return createResponseForRoles("MANAGER");
    }
	
	private LoginResponse createResponseForRoles(String... roles) {
		LoginResponse response = new LoginResponse();
		for(String role : roles) {
			response.getRoles().add(role);
		}
		return response;
		
	}
	
	private boolean isParticipant(Event event, String password) {
		if(event != null) {
			for(Invitation invitation : event.getInvitations()) {
				if(password.equals(invitation.getToken())) {
					return true;
				}
			}
		}
		return false;
	}

	public ParticipateResponse participate(Participate participate) {
		Invitation invitation = summonsRepository.update(participate.getInvitation());
		ParticipateResponse response = new ParticipateResponse();
		response.setInvitation(invitation);
        return response;
    }

}