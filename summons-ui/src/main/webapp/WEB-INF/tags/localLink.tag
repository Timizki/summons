<%@tag description="Prints link with server address" pageEncoding="UTF-8"%>
<%@attribute name="pageName" type="java.lang.String" required="true" %>
<%@attribute name="linkText" type="java.lang.String" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}${pageName}">${linkText}</a>