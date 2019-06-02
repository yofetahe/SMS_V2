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
	
	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Annual Term Update Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="annTermName"> Annual Term Name </label>					
				<input id="annTermName" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="at_date_from"> Date From </label>					
				<input id="at_date_from" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="at_date_to"> Date To </label>					
				<input id="at_date_to" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="at_status"> Date To </label>					
				<form:select id="at_status" path="annualTerms.at_status" class="form-control">
					<form:option value="Active">Active</form:option>
					<form:option value="Inactive">Inactive</form:option>
				</form:select>
			</div>
						
			<button type="submit" class="btn btn-default" onclick="updateAnnualTerm('${loader}', '#{at_id}')"> UPDATE </button>
					
		</div>
	</div>
	
	
</body>
</html>