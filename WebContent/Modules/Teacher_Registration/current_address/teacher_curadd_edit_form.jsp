<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	<div id="curaddFrm" style="padding-top: 10px;">
	
		<div class="panel panel-default" style="width: 55%">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc;">
					Teacher's Current Address	
				</h4>
			</div>
			<div class="panel-body" align="right" style="padding-right: 100px;">
				
				<div class="form-group form-inline">
					<label for="subcity"> Subcity </label>					
					<input id="subcity" type="text" value="${current_address.sub_city}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="kebele"> Kebele </label>
					<input id="kebele" type="text" value="${current_address.kebele}" class="form-control"> 	
				</div>
							
				<div class="form-group form-inline">
					<label for="houseno"> House Number </label>
					<input id="houseno" type="text" value="${current_address.house_no}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="housephoneno"> Home Phone Number </label>
					<input id="housephoneno" type="text" value="${current_address.house_phone_no}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="mobileno"> Mobile Number </label>
					<input id="mobileno" type="text" value="${current_address.mobile_no}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="email"> Email Address </label>
					<input id="email" type="text" value="${current_address.email}" class="form-control">
				</div>
				
				<c:choose>
					<c:when test="${formType == \"update\" }">
						<button type="submit" class="btn btn-default" onclick="updateTeachCurrAdd('${loader}', '${current_address.tca_id}')"> UPDATE </button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-default" onclick="saveTeachCurrAdd('${loader}', '${teacherInfo.ti_id}')"> SAVE </button>
					</c:otherwise>
				</c:choose>
						
			</div>
		</div>
		
	</div>

</body>
</html>