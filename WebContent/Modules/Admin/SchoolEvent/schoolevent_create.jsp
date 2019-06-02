<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="panel panel-default" style="width: 80%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Annual Term Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="se_name"> School Event Name </label>					
				<input id="se_name" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="se_desc"> Event Description </label>					
				<textarea id="se_desc" rows="5" cols="22" class="form-control"></textarea>
			</div>
			
			<div class="form-group form-inline">
				<label for="se_greg_date"> School Event Date </label>					
				<input id="se_greg_date" type="text" value="" class="form-control">
			</div>
						
			<button type="submit" class="btn btn-default" onclick="saveSchoolEvent('${loader}')"> SAVE </button>
					
		</div>
	</div>


</body>
</html>