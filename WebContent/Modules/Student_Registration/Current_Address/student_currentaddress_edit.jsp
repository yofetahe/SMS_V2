<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				Students Current Address Update Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
		
			<div id="errMsg" style="color: red; text-align: center; width: 40%;"></div>
			
			<div class="form-group form-inline">
				<label for="sub_city"> Sub City </label>					
				<input id="sub_city" type="text" value="${studCurrentAddress.get(0).sub_city}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="kebele"> Kebele </label>
				<input id="kebele" type="text" value="${studCurrentAddress.get(0).kebele}" class="form-control"> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="house_no"> House Number </label>
				<input id="house_no" type="text" value="${studCurrentAddress.get(0).house_no}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="house_phone"> Home Phone Number </label>
				<input id="house_phone" type="text" value="${studCurrentAddress.get(0).home_phone_no}" class="form-control">
			</div>
						
			<div class="form-group form-inline">
				<label for="email"> Email (1) </label>
				<input id="email" type="text" value="${studCurrentAddress.get(0).email}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="email_2"> Email (2) </label>
				<input id="email_2" type="text" value="${studCurrentAddress.get(0).email_2}" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateCurAddress('${loader}', '${si_id}', '${sca_id}')"> UPDATE </button>
					
		</div>
	</div>
	
</body>
</html>