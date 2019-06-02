<%@ page language="java" contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<c:url value="/Resources/bootstrap/css/bootstrap.min.css" var="bcssURL"/>
<c:url value="/Resources/css/sys_css.css" var="cssURL"/>
<link href="${bcssURL}"  rel="stylesheet" type="text/css">
<link href="${cssURL}"  rel="stylesheet" type="text/css">

</head>
<body style="margin: 0; padding-top: 150px;">
<div style="width: 100%;" align="center">
	<div class="alert alert-danger" style="width: 600px; height: 200px; padding-top: 30px; font-size: 20px; text-align: center;">
		<c:url value="/resources/images/msg_error.jpeg" var="error"/>
		<img alt="warning" src="${error}" width="60px;"> <br/><br/> Access Denied. Please talk to system Administrator.
	</div>
</div>
</body>
</html>