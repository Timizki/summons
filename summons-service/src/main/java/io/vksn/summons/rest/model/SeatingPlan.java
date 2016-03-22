package io.vksn.summons.rest.model;

import java.util.List;

import io.vksn.summons.entity.Table;

public class SeatingPlan {

	private String eventIdentifier;
	
	private List<Table> tables;
	
	public String getEventIdentifier() {
		return eventIdentifier;
	}
	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}
	
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
}
