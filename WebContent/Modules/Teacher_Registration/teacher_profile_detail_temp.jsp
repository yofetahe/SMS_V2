<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:set var="ti_id" value="${teacherInfo.ti_id}"/>

	<ul class="nav nav-tabs">
		<li id="eduBackgroundTab" class="" onclick="getEducationBackgroundList('${loader}', '${ti_id}')"> <a href="#"> Educational<br/>Background </a> </li>
		<li id="workExpTab" class="" onclick="getTeacherWorkExperienceList('${loader}', '${ti_id}')"> <a href="#"> Work<br/>Experience </a> </li>
		<li id="currentAddressTab" class="" onclick="getTeacherCurrentAddress('${loader}', '${ti_id}')"> <a href="#"> Current<br/>Address </a> </li>
		<li id="emergencyContactTab" class="" onclick="getTeacherEmergencyContactList('${loader}', '${ti_id}')"> <a href="#"> Emergency<br/>Contact </a> </li>
		<li id="rewardInfoTab" class="" onclick="getTeacherRewardList('${loader}', '${ti_id}')"> <a href="#"> Reward<br/>Information </a> </li>
		<li id="disciplinaryTab" class="" onclick="getTeacherDisciplinaryActionList('${loader}', '${ti_id}')"> <a href="#"> Disciplinary<br/>Action </a> </li>
		<li id="subjectAssignTab" class="" onclick="getTeacherClassSubjectAssignment('${loader}', '${ti_id}')"> <a href="#"> Class-Subject<br/>Assign </a> </li>
	</ul>
		
	<div id="teachersProfileDetailContent">
				
		
			
	</div>

</body>
</html>