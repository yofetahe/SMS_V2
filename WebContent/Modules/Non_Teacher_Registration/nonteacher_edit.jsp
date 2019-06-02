<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="panel panel-default" style="width: 80%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Non-Teacher's Profile Update Form
			</h4>
		</div>
		<div class="panel-body" align="right">
								
			<div class="form-group form-inline">
				<label for="fname"> First Name </label>					
				<input id="fname" type="text" value="${nonteacher_info.nti_fname}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="mname"> Middle Name </label>
				<input id="mname" type="text" value="${nonteacher_info.nti_mname}" class="form-control"> 	
			</div>
												
			<div class="form-group form-inline">
				<label for="gname"> Grand Father Name </label>
				<input id="gname" type="text" value="${nonteacher_info.nti_gname}" class="form-control">
			</div>
												
			<div class="form-group form-inline">
				<label for="sex"> Sex </label>
				<form:select path="nonteacherInfo.nti_sex" class="form-control" style="width: 196px;">											
					<form:option value="M">Male</form:option>
					<form:option value="F">Female</form:option>
				</form:select>
			</div>
												
			<div class="form-group form-inline">
				<label for="email"> Email </label>
				<input id="email" type="text" value="${nonteacher_info.nti_email}" class="form-control">
			</div>
												
			<div class="form-group form-inline">
				<label for="pos"> Position </label>
				<input id="pos" type="text" value="${nonteacher_info.nti_position}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="status"> Status </label>
				<form:select id="status" path="nonteacherInfo.nti_status" class="form-control" style="width: 196px;">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
									
			<button type="submit" class="btn btn-default" onclick="updateNonTeacher('${loader}', '${nonteacher_info.nti_id}')"> UPDATE </button>
											
		</div>
	</div>

</body>
</html>