<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
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