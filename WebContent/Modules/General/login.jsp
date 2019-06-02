<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>SMS</title>
	
	<c:url value="/Resources/bootstrap/css/bootstrap.min.css" var="bcssURL"/>
	<c:url value="/Resources/css/sys_css.css" var="cssURL"/>
	<c:url value="/Resources/images/fidel_logo.png" var="iconURL"/>
	<link href="${bcssURL}"  rel="stylesheet" type="text/css">
	<link href="${cssURL}"  rel="stylesheet" type="text/css">
	<link href="${iconURL}" rel="icon" type="image/ico">
	
	<style type="text/css">
		.errors{
			color: RED;
		}
	 	.verSeparator{
			border-right-color: #fff;
			border-right-style: solid;
			border-right-width: thin;
	 	}
	 	.loginform{ 
	 		padding-left: 40px;
		} 
		.loginBackground{
			width: 100%; 
			box-shadow: 0px -4px 15px #e5e5e5;			 
			min-height: 200px; 
			vertical-align: middle;
			padding-top: 18px;
			padding-bottom: 18px;
		}
	</style>

</head>
<body style="margin: 0px; padding-top: 150px;">

	<c:url var="bg" value='/Resources/images/new_bg_2.png'/>	
	<div class="loginBackground" style="background-repeat: repeat; background-image: url('${bg}');" align="center">
	
		<table style="width: 100%" ><tr><td align="right" width="46%" class="sysname"> 
		
			<table><tr><td>
				<div style="width: 100%; text-align: center;" align="center">
					<c:url value="/Resources/images/fidel_logo.png" var="smsLogo"/>
					<img alt="Logo" src="${smsLogo}" style="width: 100px;">
				</div>
			</td></tr><tr><td style="font-size: 20px; font-family:Arial, cursive; text-align: center; font-weight: bold; color: #8BD948;">
				FIDEL<br/>SCHOOL MANAGEMENT SYSTEM
			</td></tr></table>
			
		</td><td width="2%" class="verSeparator"> &nbsp; </td><td width="48%" class="loginform" >
		 
		 	<table><tr><td>
				<div style="width: 350px; padding-top: 20px;">
				
					<c:if test="${not empty input_error}">
						<div class="alert alert-danger">${input_error}</div>
					</c:if>
					
					<div class="successMessage">${successMessage}</div>
					<div class="errorMessage">${errorMessage}</div>
					
					<form class="form-horizontal" action="/SMS/admin/validateLoginForm.html" role="form" method="post">
						<div class="form-group">
							<span class="errors">${username_error}</span>
							<input type="text" class="form-control" id="username" name="user_name" placeholder="Username">
						</div>
						<div class="form-group">
							<span class="errors">${password_error}</span>
							<input type="password" class="form-control" id="password" name="password" placeholder="Password">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default" style="width: 100px;">Login</button>
						</div>
					</form>		
					<!-- www.servivorsoftourcher.com -->
				</div>
			</td></tr></table>
			
		</td></tr></table>
	
	</div>

	<table style="width: 100%;">
		<tr>
			<td height="10px" align="center">
				<div style="width: 1220px; height: 10px;">
					<!-- footer part -->
					<table style="width: 100%; height: 10px;">
						<tr>
							<td style="font-size: 14px; color: #549C15; padding-top: 8px" align="center">
							    &copy;&nbsp;Copyright 2013 - <span id="copyright"> <script > document.getElementById('copyright').appendChild(document.createTextNode(new Date().getFullYear())); </script> </span>, Powered by YamGet IT Solution. Version 2.0.0.1
							</td>
						</tr>					
						<tr>
							<td style="color: #549C15; font-size: 14px;" align="center">
								System Support - Call us: +251 91 166 2766/+251 912 19 5853, Email us: support@yamget.com
							</td>
						</tr>
						<tr>
							<td style="color: #549C15; font-size: 14px;" align="center">
								<a href="http://www.yamget.com" target="_blank" style="text-decoration: none;">www.yamget.com</a>
							</td>
						</tr>
					</table>
					<!-- footer part -->
				</div>				
			</td>
		</tr>
		<tr>
			<td height="30px">
				&nbsp;
			</td>
		</tr>
	</table>

	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>