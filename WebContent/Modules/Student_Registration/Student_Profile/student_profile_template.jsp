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
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>
	
	<table width="100%" cellpadding="0" cellspacing="0" border="0">	
		<tr>
			<td style="background-color: #f5f5f5; height: 50px; padding-left: 5px;" colspan="2">
				Student Profile		
			</td>
		</tr>
		<tr>
			<td width="55%" style="padding-top: 10px; padding-right: 20px;" valign="top">
				
				<jsp:include page="student_profile_edit_form.jsp"/>
				
			</td>
			<td align="center" valign="top" style="padding-top: 10px;">
			
				<c:if test="${ChangeAllowed != \"NO\"}">
				
					<div id="dropout_div">
						
						<jsp:include page="../Student_Dropout/student_dropout_form.jsp"/>
						
					</div>
					
					<br/>
					
					<div class="formboarder" id="class_change" style="padding-top: 10px; padding-bottom: 10px;">
						
						<div class="form-group">
							Class Room Change Form
						</div>
						
						<div id="cdErrMsg" style="color: GREEN"></div>
	
						<div class="form-group">
							<form:select id="newClassId" path="studReg.clcdRelation.cl_id" class="form-control inputlistboxsize" onchange="getClassDetailListByClassId(this.value, '${loader2}')">
								<form:option value="0">-</form:option>
								<form:options itemLabel="class_name" itemValue="cl_id" items="${class_list}"/>
							</form:select>
						</div>
						
						<div class="form-group" id="classDetailListDiv">
							<form:select id="newClassDetailId" path="studReg.clcdRelation.cd_id" class="form-control inputlistboxsize">
								<form:option value="0">-</form:option>
							</form:select>
						</div>
						
						<button type="submit" class="btn btn-default" onclick="changeStudentToOtherClass('${loader}', '${studReg.si_id}', '${studReg.clcdRelation.cl_id}', '${studReg.clcdRelation.cd_id }')"> CHANGE </button>
						
					</div>
					
					<br/>
					
					<div class="formboarder" id="class_detail_change" style="padding-top: 10px; padding-bottom: 10px;">
						
						<div class="form-group">
							Class Room Detail Change Form
						</div>
						
						<div id="cdErrMsg" style="color: RED"></div>
	
						<div class="form-group">
							<form:select id="newClassDetailId" path="studReg.clcdRelation.cd_id" class="form-control inputlistboxsize">
								<form:option value="0">-</form:option>
								<form:options itemLabel="cd_name" itemValue="cd_id" items="${class_detail}"/>
							</form:select>
						</div>
						
						<button type="submit" class="btn btn-default" onclick="changeClassDetail('${loader}', '${studReg.si_id}', '${studReg.clcdRelation.cl_id}', '${studReg.clcdRelation.cd_id}')"> CHANGE </button>
						
					</div>
					
					<br/>
					
					<div class="formboarder" id="specialNeed" style="padding-top: 10px; padding-bottom: 10px;">
										
						<div id="errMsg" style="color: RED"></div>
						
						<div class="form-group">
							Special payment reference required?
							<label class="radio-inline"> 
								<input type="radio" name="optionsRadiosinline" id="atid" value="1" onclick="specialNeedRequired(this.value)"> YES								
							</label>
							<label class="radio-inline"> 
								<input type="radio" name="optionsRadiosinline" id="atid" value="2" onclick="specialNeedRequired(this.value)"> NO
							</label>
						</div>
	
						<div class="form-group">
							<form:select path="studReg.studentSpecialNeedRequired.ssnr_id" class="form-control inputlistboxsize">
								<form:option value="0">-</form:option>
								<form:options itemLabel="snc_name" itemValue="snc_id" items="${specialNeedsCategoryList}"/>
							</form:select>
						</div>
						
						<c:set var="need_status" value="${stud_special_need_status}"/>
						
						<c:choose>
							<c:when test="${need_status == \"1\"}">
								<c:set var="ssnr_id" value="${studReg.studentSpecialNeedRequired.ssnr_id}"/>
								<button type="submit" class="btn btn-default" onclick="updateSpecialNeedRequirement('${loader}', '${studReg.si_id}', '${studentSpecialNeedStatus[0]}')"> UPDATE </button>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-default" onclick="saveSpecialNeedRequirement('${loader}', '${studReg.si_id}')"> SAVE </button>
							</c:otherwise>
						</c:choose>
						
					</div>
					
				</c:if>
				
			</td>
		</tr>
	</table>	
	
</body>
</html>