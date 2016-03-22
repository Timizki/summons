package io.vksn.summons.ui.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import io.vksn.summons.entity.Invitation;

@Named
@ApplicationScoped
public class ApplicationStateBean {

	private Invitation invitation = null;
	
	public void setCurrent(Invitation invitation) {
		this.invitation = invitation;
	}
	
	public Invitation getCurrent() {
		return invitation;
	}
	
}
