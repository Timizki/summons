package io.vksn.summons.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.vksn.summons.entity.Event;
import io.vksn.summons.entity.Table;
import io.vksn.summons.qualifier.Repository;
import io.vksn.summons.repository.SummonsRepository;
import io.vksn.summons.rest.model.SeatingPlan;

@Path("/seatingPlan")
@RequestScoped
public class SeatingPlanResource {

	@Inject
	@Repository
	private SummonsRepository repository;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(SeatingPlan seatingPlan) {
		Event event = repository.saveSeatingPlan(seatingPlan.getEventIdentifier(), seatingPlan.getTables());
		return Response.ok(event.getId()).build();
	}


	@GET
	@Path("/{identifier}")
	// SECURITY_WEAKNESS: weakness_2: path does not use regexp to validate input
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSeatingPlan(@PathParam("identifier") String eventIdentifier) {
		List<Table> seatingPlan = repository.loadEventSeatingPlane(eventIdentifier);
		return Response.ok(seatingPlan).build();
	}
	
	@GET
	// SECURITY_WEAKNESS: weakness_12: @Path annotated method is private
	@Path("/{identifier}")
	private Response resetSeatingPlan(@PathParam("identifier") String eventIdentifier)  {
		//TODO: reset events seating plan
		return Response.ok().build();
	}
}
