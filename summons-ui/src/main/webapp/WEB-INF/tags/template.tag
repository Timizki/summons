<!DOCTYPE html>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
	<link rel="stylesheet"  href="resources/css/main.css" />
</head>
<body>
	<div id="menu">
		<ul>
			<li><t:localLink pageName="/createEvent.xhtml" linkText="New event"/></li>
			<li><t:localLink pageName="/listEvents" linkText="List events"/></li>
			<li><t:localLink pageName="/exit.xhtml" linkText="Exit"/></li>
		</ul>
	</div>
	<div id="body">
		<jsp:doBody />
	</div>

</body>
</html>