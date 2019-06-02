<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
	<style type="text/css">
	.report_title{
		font-weight: bold;
		padding-bottom: 5px;
		padding-top: 5px;
	}
	</style>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

	<div style="width: 100%; background-color: #f5f5f5;">
		<table><tr>
			<td>
				<table>
					<s:set var="ac_year" value="stud_bean.ac_year"/>
					<s:select label="Year" id="ac_year" list="acyear_list" style="width: 76px; height: 25px;"/>
				</table>
			</td><td>&nbsp;</td>
			<td>
				<div id="clListError" style="color: RED;"></div>
				<table>
					<s:select label="Select Class" id="cl_id" headerValue="Select class" headerKey="0" list="grdList_rslt" listValue="class_name" listKey="cl_id" onchange="gradeDetailListForTranscript(this.value)" style="width: 110px; height: 25px"/>
				</table>
			</td><td>&nbsp;</td>			
			<td>
				<table><tr><td>
					<div id="clGrdListError" style="color: RED;"></div>
					<div id="grdList">
					
						<table cellpadding="0" cellspacing="0"><tr>
						<td> <i>Grade: &nbsp;</i> </td>
						<td>
							<select id="cd_id" style="width: 110px; height: 25px">
								<option value="0">Select grade</option>
							</select>
						</td></tr></table>
						
					</div>
				</td></tr></table>
			</td><td>&nbsp;</td>
			<td>
				<div id="officeUse"> <img alt="check" src="images/check_box.png" onclick="filterStudentForOffice()" style="cursor: pointer;" width="16px"> </div>
			</td><td>&nbsp;</td>
			<td>
				<div onclick="getStudentLisPerClassDetailForTranscript()" class="adminHeaderButton" style="cursor: pointer; width: 150px;">GET STUD LIST</div>
			</td><td>&nbsp;</td>
			<td>
				<div onclick="generateAllStudentTransacript()" class="adminHeaderButton" style="cursor: pointer; width: 200px;">GENERATE FOR ALL</div>
			</td><td>&nbsp;</td>
		</tr></table>	
	</div>
	<br/>
	<div id="studTranscriptContent">
	
	</div>

</body>
</html>