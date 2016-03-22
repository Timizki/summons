package io.vksn.summons.ui.beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;
import io.vksn.summons.summonsservice.model.GetSessionStartTime;

@Named("loginTime")
@RequestScoped
public class LoginTimeBean {
	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;
	
	public Date getTime() {
		return service.getSessionStartTime(new GetSessionStartTime());
	}
}
