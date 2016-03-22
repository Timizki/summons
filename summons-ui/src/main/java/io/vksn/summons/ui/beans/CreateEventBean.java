package io.vksn.summons.ui.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.entity.Event;
import io.vksn.summons.entity.Invitation;
import io.vksn.summons.entity.Person;
import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;
import io.vksn.summons.summonsservice.model.CreateEvent;
import io.vksn.summons.summonsservice.model.CreateEventResponse;

@Named("createEvent")
@ConversationScoped
public class CreateEventBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversion;
	

	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;
	
	@Model
	private Event event = new Event();
	
	public Event getEvent() {
		return this.event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public void addInvitation(AjaxBehaviorEvent event) {
		Invitation inv = new Invitation();
		inv.getPersons().add(new Person());
		getEvent().getInvitations().add(inv);
	}
	
	public void addPerson(Invitation inv) {
		Person person = new Person();
		inv.getPersons().add(person);
	}
	
	public void deletePerson(Invitation inv,  Person person) {
		
		List<Person> persons = inv.getPersons();
		for(Iterator<Person> i = persons.iterator(); i.hasNext();) {
			Person p = i.next();
			if(p.equals(person)) {
				i.remove();
				break;
			}
		}
	}
	
	public String moveToInvitations() {
		conversion.begin();
		return "addInvitation?faces-redirect=true";
	}
	
	public String moveToSeatingPlanCreation() {
		CreateEvent createEvent = new CreateEvent();
		createEvent.setEvent(event);
		CreateEventResponse response = service.createEvent(createEvent);
		this.event = response.getEvent();
		conversion.end();
		return "editSeatingPlan?faces-redirect=true&eventId="+event.getSign();
	}
	
	public String save() {
		CreateEvent createEvent = new CreateEvent();
		createEvent.setEvent(event);
		CreateEventResponse response = service.createEvent(createEvent);
		this.event = response.getEvent();
		if(!conversion.isTransient()) {
			conversion.end();
		}
		return "event?faces-redirect=true&eventId="+event.getId();
	}
}
