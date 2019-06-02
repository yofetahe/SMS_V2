<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<s:set var="bg_id" value="bg_id"/>
	<table align="center"><tr><td>
		<div class="formtitle">Save Form</div>
		<br/>
		Grade Name
		<table cellpadding="0" cellspacing="0">
			<s:textfield id="bg_name" name="bg_name" style="width: 200px; height: 30px;"/>
		</table>
		Grade Description
		<table cellpadding="0" cellspacing="0">
			<s:textarea id="bg_desc" name="bg_desc" rows="10px" style="width: 200px;"/>
		</table>
		Status
		<table cellpadding="0" cellspacing="0">
			<s:select id="bg_status" name="bg_status" list="#{'A':'Active', 'I':'Inactive'}" rows="10px" style="width: 205px;"/>
		</table>
		<table cellpadding="0" cellspacing="0" style="padding-top: 5px;">
			<s:submit onclick="updateBevalGrade('%{#bg_id}')" value="Update" style="width: 205px; height: 30px;"/>
		</table>
	</td></tr></table>

</body>
</html>