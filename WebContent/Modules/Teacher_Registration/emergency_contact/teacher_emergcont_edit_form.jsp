<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<div id="emergcontFrm" style="padding-top: 10px;">

		<div class="panel panel-default" style="width: 55%">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc;">
					Teacher's Emergency Contact	
				</h4>
			</div>
			<div class="panel-body" align="right" style="padding-right: 100px;">
				
				<div class="form-group form-inline">
					<label for="contname"> Contact Name </label>					
					<input id="contname" type="text" value="${emergency_contant.cont_name}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="rship"> Relationship </label>
					<input id="rship" type="text" value="${emergency_contant.relationship}" class="form-control"> 	
				</div>
							
				<div class="form-group form-inline">
					<label for="mobileno"> Mobile Number </label>
					<input id="mobileno" type="text" value="${emergency_contant.mobile_no}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="homephone"> Home Phone Number </label>
					<input id="homephone" type="text" value="${emergency_contant.home_phone_no}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="officephone"> Office Phone Number </label>
					<input id="officephone" type="text" value="${emergency_contant.office_phone_no}" class="form-control">
				</div>
				
				<c:choose>
					<c:when test="${formType == \"update\" }">
						<button type="submit" class="btn btn-default" onclick="updateTeachCurrAdd('${loader}', '${emergency_contant.tec_id}')"> UPDATE </button>
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