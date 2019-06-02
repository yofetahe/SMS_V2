<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div id="school_information" style="width: 100%;" align="center">
	
		<div class="panel panel-default" style="width: 32%">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc;">
					School Information Registration Form
				</h4>
			</div>
			<div class="panel-body" align="right" style="padding-right: 30px;">
			
				<div id="photo_display" style="width: 100%; padding-bottom: 10px;" align="center">
														
					<img alt="<c:out value="${schoolInformation.school_name}"/>" src="getOrganizationLogo?sch_inf_id=${schoolInformation.sch_inf_id}" width="154px" />
																
					<div onclick="upload_photo('${schoolInformation.sch_inf_id}')" style="width: auto; text-align: center; background-color: #f5f5f5; color: #000; cursor: pointer; padding-top: 5px; min-height: 30px;">
						UPLOAD SCHOOL LOGO
					</div>							
				</div>
				
				<div id="upload_form"></div>
						
				<div class="form-group form-inline">
					<label for="sch_name"> School Name </label>					
					<input id="sch_name" type="text" value="${schoolInformation.school_name}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="sch_slogan"> School Slogan </label>					
					<input id="sch_slogan" type="text" value="${schoolInformation.slogan}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="tin_num"> TIN Number </label>					
					<input id="tin_num" type="text" value="${schoolInformation.tin_num}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="telephone"> Telephone </label>					
					<input id="telephone" type="text" value="${schoolInformation.telephone}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="fax"> Fax </label>					
					<input id="fax" type="text" value="${schoolInformation.fax}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="web"> Web </label>					
					<input id="web" type="text" value="${schoolInformation.web}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="email"> E-mail </label>					
					<input id="email" type="text" value="${schoolInformation.email}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="pobox"> P.O.Box </label>					
					<input id="pobox" type="text" value="${schoolInformation.pobox}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="fiscal_machine_no"> Fiscal Machine Number </label>					
					<input id="fiscal_machine_no" type="text" value="${schoolInformation.fiscal_machine_no}" class="form-control">
				</div>
				
				<c:choose>
					<c:when test="${formType == \"update\"}">
						<button type="submit" class="btn btn-default" onclick="updateSchoolInformation('${loader}', '${schoolInformation.sch_inf_id}')"> UPDATE </button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-default" onclick="saveSchoolInformation('${loader}')"> SAVE </button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
	</div>

</body>
</html>