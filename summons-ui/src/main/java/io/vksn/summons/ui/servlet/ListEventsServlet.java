package io.vksn.summons.ui.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import io.vksn.summons.summonsservice.SummonsService;
import io.vksn.summons.summonsservice.SummonsServiceWS;
import io.vksn.summons.summonsservice.model.ListEvents;
import io.vksn.summons.summonsservice.model.ListEventsResponse;
import io.vksn.summons.ui.servlet.exception.RequestHandlingException;

@WebServlet(urlPatterns = "/listEvents")
public class ListEventsServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ListEventsServlet.class.getName());
	private static final long serialVersionUID = 1L;

	@WebServiceRef(SummonsService.class)
	private SummonsServiceWS service;

	@Override
	//SECURITY_WEAKNESS: weakness_9:Servlet's service method is marked synchronized which can cause performance issues.
	public synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		ListEventsResponse events = service.listEvents(new ListEvents());
		log.severe(String.format("Found %d events", events.getEvents().size()));
		request.setAttribute("events", events.getEvents());
		request.getRequestDispatcher("/WEB-INF/jsps/listEvents.jsp").forward(request, response);
		}
		catch(Exception e) {
			//SECURITY_WEAKNESS: weakness_11: Exception is thrown instead of calling response.sendError(...)
			throw new RequestHandlingException();
		}
		
	}

}
