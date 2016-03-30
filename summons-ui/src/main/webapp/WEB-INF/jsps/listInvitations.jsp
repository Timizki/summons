<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
		<%-- SECURITY_WEAKNESS: weakness-19:  HTML comment in JSP will expose implementation bug --%>
		<!-- ListInvitation Servlet does not validate event identifier from GET param!! -->
    	<c:forEach var="invitation" items="${invitations}">
         	<p>Password: ${invitation.token}</p>
         	<p>
				<b>Invitation's persons</b>
			</p>
         	<c:forEach var="person" items="${invitation.persons}">
         		<p>${person.firstName} ${person.lastName} ${person.participate}</p>
         	</c:forEach>
         </c:forEach>
    </jsp:body>
</t:template>