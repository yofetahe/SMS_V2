<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<script src="js/sms_teacher_registration.js" type="text/javascript"></script>

</head>
<body>

<div id="teachFroms">
	<s:set var="ti_id" value="ti_id"/>
	<div style="background-color: #f5f5f5; height: 35px; padding-top: 15px;">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td align="left">
					<s:div style="color: #3d6e9f;"> <img src="images/next.gif" width="8px"/> New Teacher Education Background Add Form</s:div>
				</td>
				<td width="120px">
					&nbsp;
				</td>
				<td align="left">
					&nbsp;
				</td>
			</tr>
		</table>
	</div>
	
	<br/>
	
	<div id="errMsg" style="color: #ff0000"></div>
	<table>
		<tr>
			<td>
			
				<s:textfield label="Institute Name" id="institute_name" required="true" style="height: 25px; width: 200px"/>
				<s:textfield label="Job Title" id="job_title" required="true" style="height: 25px; width: 200px"/>
				<s:textfield label="Date From" id="date_from" required="true" style="height: 25px; width: 200px"/>
				<s:textfield label="Date To" id="date_to" required="true" style="height: 25px; width: 200px"/>
				
				<s:submit label="Save" onclick="saveWorkExp('%{#ti_id}')"/>
			
			</td>
		</tr>
	</table>
		
</div>

</body>
</html>