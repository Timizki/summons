package io.vksn.summons.ui;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;

public class Producers {
	
	@WebServiceRef(SummonsService.class)
	private SummonsService summonsService;
	
	@Produces
	public SummonsServiceWS getSummonsService() {
		BindingProvider provider = (BindingProvider)summonsService;
		Map<String, Object> properties = provider.getRequestContext();
		//SECURITY_WEAKNESS: weakness_7: Hard coding username and password for web service client
		properties.put(BindingProvider.USERNAME_PROPERTY, "Username");
		properties.put(BindingProvider.PASSWORD_PROPERTY, "Password");
		
		return this.summonsService.getSummonsService();
	}

}
