<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<div id="teachFroms">
	
	<div style="background-color: #f5f5f5; height: 35px; padding-top: 15px;">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td align="left">
					<div style="color: #3d6e9f;"> <img src="images/next.gif" width="8px"/> Update Teacher Education Background </div>
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
			
				<s:textfield label="Institute Name" id="institute_name" name="name_of_institiute" required="true" style="height: 25px; width: 200px"/>
				<s:textfield label="Feild of Study" id="field_of_study" name="field_of_study" required="true" style="height: 25px; width: 200px"/>
				<s:textfield label="Graduation Date" id="graduation_date" name="graduation_date" required="true" style="height: 25px; width: 200px"/>
				<s:select label="Award" id="award" headerValue="---" name="award" headerKey="0" list="#{'Phd':'Phd', 'MA':'Masters', 'Bsc':'Degree', 'Dip':'Diploma', 'Cer':'Certificate'}" required="true" style="height: 25px; width: 205px"/>
				<s:select label="Status" id="teb_status" headerValue="---" name="teb_status" headerKey="0" list="#{'A':'Active', 'I':'Inactive'}" required="true" style="height: 25px; width: 205px"/>
				
				<s:submit label="Update" onclick="updateEduBackground('%{#ti_id}', '%{#teb_id}')"/>
			
			</td>
		</tr>
	</table>
		
</div>

</body>
</html>