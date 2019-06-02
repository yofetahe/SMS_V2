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
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="panel panel-default" style="width: 100%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Teacher's Profile
			</h4>
		</div>
		<div class="panel-body" align="right">
		
			<div id="photo_display" class="form-group" align="center">
										
				<img alt="<c:out value="${teacher_info.fname}"/> photo" src="getTeacherPhoto?ti_id=${teacher_info.ti_id}" width="154px" />
																
				<div onclick="upload_photo('${loader}', '${teacherInfo.ti_id}')" style="text-align: center; background-color: #3d6e9f; width: auto; color: #fff; cursor: pointer; min-height: 30px; padding-top: 5px;">
					UPLOAD/CHANGE PHOTO
				</div>										
			</div>
			
			<div id="photoUploadForm"></div>
			
			<div class="form-group form-inline">
				<label for="fname"> First Name </label>					
				<input id="fname" type="text" value="${teacher_info.fname}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="mname"> Middle Name </label>
				<input id="mname" type="text" value="${teacher_info.mname}" class="form-control"> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="gname"> Grand Father Name </label>
				<input id="gname" type="text" value="${teacher_info.gname}" class="form-control">
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
				<input id="dob" type="text" readonly="readonly" value="${teacher_info.dob}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="pob"> Place of Birth </label>
				<input id="pob" type="text" value="${teacher_info.pob}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="nationality"> Nationality </label>
				<input id="nationality" type="text" value="${teacher_info.nationality}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="idno"> ID Number </label>
				<input id="idno" type="text" readonly="readonly" value="${teacher_info.id_no}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="status"> Status </label>
				<form:select path="teacherInfo.ti_status" class="form-control" style="width: 196px;">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateTeacher('${loader}', '${ti_id}')"> UPDATE </button>
					
		</div>
	</div>

</body>
</html>