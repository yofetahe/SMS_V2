<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>
	<s:set var="attype_id" value="attype_id"/>
	<div id="eMsg" style="color: #ff0000; width: 100%; text-align: center;"></div>
		<div id="saveEditForm" class="formboarder" style="width: 250px">					
			<table align="center"><tr><td>
			
				<div class="formtitle">Save Form</div>
				<br/>
				
				Attendance Type Name
				<table cellpadding="0" cellspacing="0">
					<s:textfield id="attype_description" name="attype_description" style="width: 200px; height: 30px;"/>
				</table>
				
				Attendance Type Code
				<table cellpadding="0" cellspacing="0">
					<s:textarea id="attype_code" name="attype_code" rows="5px" style="width: 200px;"/>
				</table>
				
				Attendance Type Status
				<table cellpadding="0" cellspacing="0">
					<s:select list="#{'A':'Active', 'I':'Inactive'}" id="attype_status" name="attype_status" rows="10px" style="width: 205px; height: 30px;"/>
				</table>
				
				<table cellpadding="0" cellspacing="0" style="padding-top: 5px;">
					<s:submit onclick="updateAttendanceType('%{#attype_id}')" value="Update" style="width: 205px; height: 30px;"/>
				</table>
				
			</td></tr></table>
		</div>

</body>
</html>