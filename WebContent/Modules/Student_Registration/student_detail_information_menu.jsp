<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
										
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<tr height="30px">
			<td align="left">
				<div onclick="get_student_profile_edit_form('${loader}', '${studReg.si_id}', '${studReg.clcdRelation.cl_id}', '${studReg.clcdRelation.cd_id}')" id="si" class="menu_button" style="background-color: #f5f5f5">
					Student Profile
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
<!-- 		<tr height="30px"> -->
<!-- 			<td align="left"> -->
<%-- 				<s:div onclick="student_family_info_edit('%{#idno}', '%{#siid}', '%{#fname}', '%{#mname}', '%{#gname}', '%{#sex}', '%{#dob}', '%{#pob}', '%{#sistatus}', '%{#mothername}')" id="si" cssClass="menu_button"> --%>
<!-- 					Family Info -->
<%-- 				</s:div> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td style="line-height: 5px">&nbsp;</td> -->
<!-- 		</tr> -->
		<tr height="25px">
			<td align="left">
				<div onclick="getStudentCurrentAddress('${loader}', '${studReg.si_id}')" id="ca" class="menu_button">
					Current Address
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="getStudentBrotherSisterList('${loader}', '${studReg.si_id}')" id="bs" class="menu_button">
					Brother/Sisters List
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="getStudentEmergencyContact('${loader}', '${studReg.si_id}')" id="ec" class="menu_button">
					Emergency Contact
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
<!-- 		<tr height="25px"> -->
<!-- 			<td align="left"> -->
<%-- 				<s:div onclick="grade_history('%{#siid}')" id="gh" cssClass="menu_button"> --%>
<!-- 					Grade History -->
<%-- 				</s:div> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td style="line-height: 5px">&nbsp;</td> -->
<!-- 		</tr> -->
		<tr height="25px">
			<td align="left">
				<div onclick="getStudentReward('${loader}', '${studReg.si_id}')" id="r" class="menu_button">
					Reward
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="getStudentDisciplinaryAction('${loader}', '${studReg.si_id}')" id="da" class="menu_button">
					Disciplinary action
				</div>
			</td>
		</tr>
	</table>
</body>
</html>