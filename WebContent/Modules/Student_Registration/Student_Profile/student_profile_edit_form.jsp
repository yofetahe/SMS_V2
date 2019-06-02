<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

	<script>		   
		$(document).ready(function() {

			$("#dob").datepicker({
				//minDate: 0, 
				maxDate: "-1096D",//to limit registration below 3 years old children
				dateFormat : "yy-mm-dd",
				numberOfMonths : 1,
				onSelect : function(selected) {
					//$("#date_to").datepicker("option", "minDate", selected);
				}
			});
		});
	</script>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<table align="center" width="100%">		
		<tr>
			<td id="info_updateform" colspan="2">
				<div id="errMsg" style="color: red; text-align: center; width: 50%;"></div>
			</td>
		</tr>
	</table>
	<table width="100%"><tr><td>
		
		<c:set var="stud_edit_status" value="stud_edit_status"/>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc;">
					Students Information Update Form
				</h4>
			</div>
			<div class="panel-body" align="right" style="padding-right: 30px;">
				
				<div class="form-group form-inline">
					<label for="fname"> First Name </label>					
					<input id="fname" type="text" value="${stud_info.fname}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="mname"> Middle Name </label>
					<input id="mname" type="text" value="${stud_info.mname}" class="form-control"> 	
				</div>
							
				<div class="form-group form-inline">
					<label for="gname"> Grand Father Name </label>
					<input id="gname" type="text" value="${stud_info.gname}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="sex"> Sex </label>
					<form:select path="studReg.studentInformation.sex" class="form-control" style="width: 196px;">
						<form:option value="M">Male</form:option>
						<form:option value="F">Female</form:option>
					</form:select>
				</div>
							
				<div class="form-group form-inline">
					<label for="dob"> Date of Birth </label>
					<input id="dob" type="text" readonly="readonly" value="${stud_info.dob}" class="form-control">
				</div>
							
				<div class="form-group form-inline">
					<label for="pob"> Place of Birth </label>
					<input id="pob" type="text" value="${stud_info.pob}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="mother_name"> Mother Name </label>
					<input id="mother_name" type="text" value="${stud_info.mother_name}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="nationality"> Nationality </label>
					<input id="nationality" type="text" value="${stud_info.nationality}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="idno"> ID Number </label>
					<input id="idno" type="text" readonly="readonly" value="${stud_info.id_no}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="status"> Status </label>
					<form:select path="studReg.studentInformation.si_status" class="form-control" style="width: 196px;">
						<form:option value="A">Active</form:option>
						<form:option value="I">Inactive</form:option>
					</form:select>
				</div>
				
				<button type="submit" class="btn btn-default" onclick="updateStudentInfo('${loader}', '${siid}', '${stud_edit_status}')"> UPDATE </button>
						
			</div>
		</div>
								
	</td></tr></table>

</body>
</html>