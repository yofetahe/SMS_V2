<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
	<script>
		$(document).ready(function(){
			$('#dob').calendarsPicker({
				calendar: $.calendars.instance('ethiopian'), 
				dateFormat: "yyyy-mm-dd",
				maxDate: "-7280D"
			});		
		});
	</script>

</head>
<body>

	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Teacher's Profile Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 130px;">
			
			<div class="form-group form-inline">
				<label for="fname"> First Name </label>					
				<input id="fname" type="text" value="" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="mname"> Middle Name </label>
				<input id="mname" type="text" value="" class="form-control"> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="gname"> Grand Father Name </label>
				<input id="gname" type="text" value="" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="sex"> Sex </label>
				<form:select path="teacherInfo.sex" class="form-control" style="width: 196px;">
					<form:option value="M">Male</form:option>
					<form:option value="F">Female</form:option>
				</form:select>
			</div>
						
			<div class="form-group form-inline">
				<label for="dob"> Date of Birth </label>
				<input id="dob" type="text" readonly="readonly" value="" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="pob"> Place of Birth </label>
				<input id="pob" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="nationality"> Nationality </label>
				<input id="nationality" type="text" value="" class="form-control">
			</div>
						
			<button type="submit" class="btn btn-default" onclick="saveTeacher('${loader}')"> REGISTER </button>
					
		</div>
	</div>

</body>
</html>