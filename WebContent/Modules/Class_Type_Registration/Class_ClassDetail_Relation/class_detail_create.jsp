<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>
	<s:set var="cl_id" value="cl_id"/>
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="height: 50px">
				<div class="menu_shadow" style="height: 35px; padding-top: 15px; background-position: bottom;">
				<s:div style="color: #3d6e9f; cursor: pointer;" onclick="ClassDetailList('%{#cl_id}')"><img alt="click" src="images/next.gif" width="8px"> Back to Detail List</s:div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="padding-top: 10px">
				<div class="content_background" style="min-height: 380px">
					<s:fielderror id="classDtlError"/>
					<div id="errMsg" style="color: red; text-align: center; width: 50%;"></div>
					<table align="left"><tr><td>
					
						<s:set var="cl_id" value="cl_id"/>
						<s:select id="cd_id" label="Class Detial" required="true" headerValue="Select class detial" headerKey="0" list="cdetaillist" listKey="cd_id" listValue="cd_name" style="height: 25px; width: 206px" />
						<s:textfield id="cl_capacity" label="Class Capacity" required="true" style="height: 25px; width: 200px"/>
						
						<s:submit onclick="saveClCdRel('%{#cl_id}')" value="Save"/>
						
					</td></tr></table>
				</div>
				
			</td>
		</tr>
	</table>

</body>
</html>