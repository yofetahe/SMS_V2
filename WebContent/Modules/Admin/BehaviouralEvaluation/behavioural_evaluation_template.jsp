<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<ul class="nav nav-tabs">
		<li id="subjectTypeListTab" class="active" onclick="traitsList('${loader}')"> <a href="#"> Evaluate On </a> </li>
		<li id="examTypeListTab" class="" onclick="evalGradeList('${loader}')"> <a href="#"> Evaluation Grade </a> </li>
		<li id="examTypeListTab" class="" onclick="classTraitRelationship('${loader}')"> <a href="#"> Class and Evaluation-On Relation </a> </li>
	</ul>
										
	<div id="infoList" style="padding-top: 10px;">
									
		
												
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>

</body>
</html>