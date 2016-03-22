package io.vksn.summons.ui.beans;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.entity.Event;
import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;

@Named("viewEvent")
@RequestScoped
public class ViewEventBean {
	private static final Logger log = Logger.getLogger(ViewEventBean.class.getName());
	private Event event;
	private Long eventId;
	
	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public void loadEvent() {
		log.severe("Fetching event for id " + this.eventId);
		this.event = service.fetchEvent(this.eventId);
	}
	
	
}
