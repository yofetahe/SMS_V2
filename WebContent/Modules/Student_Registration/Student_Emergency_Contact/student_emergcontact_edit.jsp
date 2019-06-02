<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
<div id="cadd_saveform">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
								
	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Students Emergency Contact Address Update Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="contact_name"> Contact Name </label>					
				<input id="contact_name" type="text" value="${emergencyContact.cont_name}" class="form-control">
			</div>
							
			<div class="form-group form-inline">
				<label for="relationship"> Relationship </label>
				<input id="relationship" type="text" value="${emergencyContact.relationship}" class="form-control"> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="mob_no"> Mobile Number </label>
				<input id="mob_no" type="text" value="${emergencyContact.mob_no}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="offphone_no"> Office Phone Number </label>
				<input id="offphone_no" type="text" value="${emergencyContact.office_phone_no}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="homephone_no"> Home Phone Number </label>
				<input id="homephone_no" type="text" value="${emergencyContact.home_phone_no}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="sec_status"> Emergency Contact Status </label>
				<form:select id="sec_status" path="studEmerg.sec_status" class="form-control" style="width: 196px;">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateEmergContact('${loader}', '${sec_id}', '${studReg.si_id}')"> UPDATE </button>
					
		</div>
	</div>
			
</div>
</body>
</html>