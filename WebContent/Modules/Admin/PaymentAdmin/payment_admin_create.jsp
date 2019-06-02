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
	
	<div class="panel panel-default" style="width: 80%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Payment Amount Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="cl_id"> Class Type </label>					
				<form:select path="homeroomAssign.cl_id" id="cl_id" class="form-control" style="width: 196px;">
					<form:option value="0">-</form:option>
					<form:options itemLabel="class_name" itemValue="cl_id" items="${classTypeList}"/>
				</form:select>
			</div>
			
			<div class="form-group form-inline">
				<label for="pt_id"> Payment Type </label>					
				<form:select path="homeroomAssign.cl_id" id="pt_id" class="form-control" style="width: 196px;">
					<form:option value="0">-</form:option>
					<form:options itemLabel="pt_name" itemValue="pt_id" items="${paymentTypeList}"/>
				</form:select>
			</div>
			
			<div class="form-group form-inline">
				<label for="pay_amount"> Payment Amount </label>					
				<input id="pay_amount" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="penality_max_date"> Days for Penalty </label>					
				<input id="penality_max_date" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="penality_percent"> Penalty Rate </label>					
				<input id="penality_percent" type="text" value="" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="academic_year"> Academic Year </label>					
				<input id="academic_year" type="text" value="" class="form-control">
			</div>
					
			<button type="submit" class="btn btn-default" onclick="savePaymentInfo('${loader}')"> SAVE </button>
					
		</div>
	</div>
						
			
</body>
</html>