<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
		<p>Events</p>
		<c:forEach var="event" items="${events}">
			<div>
				<p>${event.name}</p>
				<p>Login token: ${event.sign}</p>
				<div id="actions">
						<a href="/summons-ui/editSeatingPlan.xhtml?eventId=${event.sign}">Edit seating plan</a>
						<a href="/summons-ui/listInvitation?eventId=${event.id}">View invitations</a>
					</div>
			</div>
		</c:forEach>
	</jsp:body>
</t:template>