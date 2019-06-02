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
	
	<style type="text/css">
	.separator{
		border-bottom: thin; border-bottom-color: #e5e5e5; border-bottom-style: solid; border-bottom-width: thin; 
		width: 100%; line-height: 30px; padding-top: 5px; margin-bottom: 10px;
	}
	</style>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

	<div id="studSaveForm">
	
		<c:url var="actionUrl" value="/student/saveStudentProfileInformation"></c:url>
		
		<form:form modelAttribute="studentInformation" action="${actionUrl}" enctype="multipart/form-data" method="POST">
		
			<table width="100%" cellpadding="0" cellspacing="0">
	<!-- 			<tr> -->
	<!-- 				<td style="background-color: #f5f5f5; height: 50px; cursor: pointer;"> -->
	<!-- 					<img alt="click" src="images/next.gif" width="8px"> <span onclick="addStudPersonalInfoFromExcel()">Adding Students Personal Information From Excel</span>				 -->
	<!-- 				</td> -->
	<!-- 			</tr> -->
				<tr>
					<td id="info_saveform">
											
						<table width="100%"><tr><td width="24%" valign="top">
						
							<div class="separator" >
								<b>Students Profile Information</b>
							</div>
							
							<div style="min-height: 40px; padding-top: 10px; width: 100%; margin-bottom: 10px;" align="center">							
								<div id="photo_display" align="center">
									<c:url var="default_photo" value="/Resources/images/default.jpg"/>
									<img alt="Student Photo" src="${default_photo}" width="100px">
								</div>
								<a href="#">UPLOAD</a>								
							</div>
													
							<table width="100%"><tr><td align="right">
							
								<div class="form-group">
									<form:input id="fname" path="fname" placeholder="First Name" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:input id="mname" path="mname" placeholder="Middle Name" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:input id="gname" path="gname" placeholder="Grand Father Name" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:input id="mothername" path="mother_name" placeholder="Mother Name" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:select id="sex" path="sex" cssClass="form-control">
										<form:option value="-">- Sex -</form:option>
										<form:option value="M">Male</form:option>
										<form:option value="F">Female</form:option>
									</form:select>
								</div>
								
								<div class="form-group">
									<form:input id="dob" path="dob" placeholder="Date of Birth" readonly="readonly" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:input id="pob" path="pob" placeholder="Place of Birth" cssClass="form-control"/>
								</div>
								
								<div class="form-group">
									<form:input id="nat" path="nationality" placeholder="Nationality" cssClass="form-control"/>
								</div>				
							
							</td></tr></table>
												
						</td><td>&nbsp;</td><td width="29%" valign="top">
						
							<div>
								<div class="separator">
									<b>Does the student has a brother or sister in the school?</b>
								</div>
								
<!-- 								<div> -->
<!-- 									<div class="form-group"> -->
<!-- 										<input id="broSisNumber" type="text" placeholder="Number of brother and sister" class="form-control"> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								<table width="100%"><tr><td width="49%">
								
									<div class="form-group">							
										<select id="cl_id" class="form-control" onchange="getClassDetailForBrotherSisterSearch(this.value, '${loader2}')">
											<option value="0">- Class List -</option>
											<c:forEach var="class_type" items="${class_type_list}">
												<option value="${class_type.cl_id}">${class_type.class_name}</option>
											</c:forEach>
										</select>
									</div>
									
								</td><td>&nbsp;</td><td width="49%">
								
									<div class="form-group" id="class_detail_list">
										<select id="cd_id" class="form-control">
											<option value="0">- Class Detail List -</option>									
										</select>
									</div>
									
								</td></tr></table>
								
								<div class="form-group">
									<input id="searchName" type="text" placeholder="Brother/Sister Name begining letters" class="form-control">
								</div>
								
								<div class="form-group" align="center" style="width: 100%; cursor: pointer;" onclick="searchBrotherSisterByName('${loader}')">
									SEARCH
								</div>
								
								<div id="searchResult" class="headerTitleBottomBorder" style="padding-top: 10px; padding-bottom: 10px;">
								
								</div>
								
								<div id="selectedStudentList" class="form-group" style="padding-top: 10px">
									
								</div>
								
								<input type="text" name="selectedBroSisIdList" id="selectedStudIdList" style="display: none;">
								<form:input id="selectedStudIdList" path="selectedBroSisIdList" style="display: none;"/>
							</div>
												
						</td><td>&nbsp;</td><td width="26%" valign="top">
		
							<div style="margin-bottom: 10px;">
								<div class="separator">
									<b>Student's Parent/Guardian/Emergency Contact (1)</b>
								</div>
								<div>
									<table width="100%"><tr><td align="right">
									
										<div class="form-group">
											<form:input id="contact_name" path="studentEmergencyContact.cont_name" placeholder="Full Name" cssClass="form-control"/>
										</div>
										
										<div class="form-group">
											<form:select id="relationship" path="studentEmergencyContact.relationship" name="relationship_1" class="form-control">
												<form:option value="-">- Relationship -</form:option>
												<form:option value="Father">Father</form:option>
												<form:option value="Mother">Mother</form:option>
												<form:option value="Guardian">Guardian</form:option>
											</form:select>
										</div>
										
										<div class="form-group">
											<form:input id="mob_no" path="studentEmergencyContact.mob_no" placeholder="Mobile Number" cssClass="form-control"/> 	
										</div>
										
										<div class="form-group">
											<form:input id="offphone_no" path="studentEmergencyContact.office_phone_no" placeholder="Office Phone Number" cssClass="form-control"/>
										</div>
										
										<div class="form-group">
											<form:input id="homephone_no" path="studentEmergencyContact.home_phone_no" placeholder="Home Phone Number" cssClass="form-control"/>
										</div>
										
									</td></tr></table>
								</div>
							</div>
							
							<div>
								<div class="separator">
									<b>Student's Parent/Guardian/Emergency Contact (2)</b>
								</div>
								<div>
									<table width="100%"><tr><td align="right">
									
										<div class="form-group">
											<form:input id="contact_name" path="studentEmergencyContact.cont_name_2" placeholder="Full Name" cssClass="form-control"/>
										</div>
										
										<div class="form-group">
											<form:select id="relationship" path="studentEmergencyContact.relationship_2" name="relationship_1" class="form-control">
												<form:option value="-">- Relationship -</form:option>
												<form:option value="Father">Father</form:option>
												<form:option value="Mother">Mother</form:option>
												<form:option value="Guardian">Guardian</form:option>
											</form:select>
										</div>
										
										<div class="form-group">
											<form:input id="mob_no" path="studentEmergencyContact.mob_no_2" placeholder="Mobile Number" cssClass="form-control"/> 	
										</div>
										
										<div class="form-group">
											<form:input id="offphone_no" path="studentEmergencyContact.office_phone_no_2" placeholder="Office Phone Number" cssClass="form-control"/>
										</div>
										
										<div class="form-group">
											<form:input id="homephone_no" path="studentEmergencyContact.home_phone_no_2" placeholder="Home Phone Number" cssClass="form-control"/>
										</div>
										
									</td></tr></table>
								</div>
							</div>
						
						</td><td>&nbsp;</td><td width="17%" valign="top">
							
							<div style="margin-top: 10px;">
								<div class="separator">
									<b>Does the student needs special medical attention?</b>
								</div>
								<div>
									<table width="100%"><tr><td align="right">				
										
										<textarea id="specialAttentionInfo" name="special_attention_info" rows="10" cols="40" class="form-control"></textarea>
										
									</td></tr></table>
								</div>
							</div>
				
						</td></tr></table>
						
						<div class="separator">&nbsp;</div>
						
						<div align="center" style="width: 100%; padding-bottom: 10px;">
							
							<button id="saveButton" type="submit" class="btn btn-default" onclick="hideSaveButton()"> SAVE STUDENT PROFILE INFORMATION </button>				
							
						</div>
					
					</td>
				</tr>
			</table>
		
		</form:form>
	</div>
	
</body>
</html>