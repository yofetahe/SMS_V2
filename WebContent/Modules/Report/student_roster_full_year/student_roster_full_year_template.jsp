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
	
	<div style="width: 100%; background-color: #f5f5f5;">
		<table><tr>
			<td>
				<table>
				<s:set var="ac_year" value="stud_bean.ac_year"/>
<%-- 				<s:textfield label="Year" id="ac_year" value="%{#ac_year}" readonly="true" style="width: 50px; height: 20px"/> --%>
					<s:select label="Year" id="ac_year" list="acyear_list" style="width: 76px; height: 25px;"/>
				</table>
			</td><td>&nbsp;</td>
			<td>
				<div id="qrtListError" style="color: RED;"></div>
				<table>
					<s:select label="Select Class" id="cl_id" headerValue="Select class" headerKey="0" list="grdList_rslt" listValue="class_name" listKey="cl_id" onchange="gradeDetailList(this.value)" style="width: 110px; height: 25px"/>
				</table>
			</td><td>&nbsp;</td>			
			<td>
				<table><tr><td>
					<div id="clGrdListError" style="color: RED;"></div>
					<div id="grdList">
									
					</div>
				</td></tr></table>
			</td><td>&nbsp;</td>
			<td>
				<div id="officeUse"> <img alt="check" src="images/check_box.png" onclick="filterStudentForOffice()" style="cursor: pointer;" width="16px"> </div>
			</td><td>&nbsp;</td>
			<td>
				<div onclick="generateFullYearStudentRoster()" class="adminHeaderButton" style="cursor: pointer; width: 100px;">GENERATE</div>
			</td><td>&nbsp;</td>
		</tr></table>	
	</div>
	<br/>
	<div id="studRoster">
	
	</div>

</body>
</html>