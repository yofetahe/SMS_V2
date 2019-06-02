<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<div class="panel panel-default" style="width: 80%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Holiday Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="h_name"> Holiday Name </label>					
				<input id="h_name" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="h_greg_date"> Holiday Date </label>					
				<input id="h_greg_date" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="work_status"> Work Status </label>					
				<select id="work_status" class="form-control" style="width: 196px;">
					<option>Off</option>
					<option>On</option>
				</select>
				
			</div>
						
			<button type="submit" class="btn btn-default" onclick="saveHoliday('${loader}')"> SAVE </button>
					
		</div>
	</div>
	

</body>
</html>