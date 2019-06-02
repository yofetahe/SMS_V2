<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="background-color: #f5f5f5; height: 50px">
				<div class="menu_shadow" style="background-color: #f5f5f5; height: 35px; padding-top: 15px;  background-position: bottom;">
				<div style="color: #3d6e9f; cursor: pointer;" onclick="backToCDList()"><img alt="click" src="images/next.gif" width="8px"> Back to List</div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="padding-top: 10px">
				<div class="content_background" style="min-height: 380px">
					<s:fielderror id="cDtlError"/>
					<div id="errMsg" style="color: red; text-align: center; width: 50%;"></div>
					<table align="left"><tr><td>
					
						<s:set var="cd_id" value="cd_id"/>
						<s:textfield id="cd_name" label="Detail Name" required="true" key="cd_name" style="height: 25px; width: 200px"/>
						<s:select id="cd_status" label="Status" list="#{'Active':'Active', 'Inactive':'Inactive'}" key="cd_status" style="height: 30px; width: 206px"/>
						
						<s:submit onclick="updateCDetail('%{#cd_id}')" value="Update"/>
						
					</td></tr></table>
				</div>
			
			</td>
		</tr>
	</table>

</body>
</html>