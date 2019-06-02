<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body style="padding-top: 10px;">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<ul class="nav nav-tabs">
		<li id="activeTeacherListTab" class="active" onclick="getActiveTeachersList('${loader}')"> <a href="#"> Active Teacher List </a> </li>
		<li id="inactiveTeacherListTab" class="" onclick="getInactiveTeachersList('${loader}')"> <a href="#"> Inactive Teacher List </a> </li>
	</ul>
		
	<div id="teachersListContent">
		
		<jsp:include page="teacher_list.jsp"/>
			
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
</body>
</html>