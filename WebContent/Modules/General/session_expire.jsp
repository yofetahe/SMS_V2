<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="header_resource.jsp"/>

</head>
<body style="padding-top: 20px;">

	<div style="width: 100%" align="center">
		<div class="alert alert-info" style="width: 30%;">
			<c:url value="/Resources/images/msg_information.jpeg" var="info"/>
			<img alt="Info"  src="${info}" width="60px;"><br/><br/>
			Session Expire. Please login again.<br/><br/>
			<a href="login.html">Login</a>			
		</div>
	</div>
	<jsp:include page="footer_resource.jsp"/>

</body>
</html>