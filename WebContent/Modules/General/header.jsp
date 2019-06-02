<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

<style type="text/css">
		
	#header_tab{
		cursor: pointer;
		width: 150px;
		height: 30px; 
		padding-top: 5px;
		background-color: rgba(255, 255, 255, 0.5);
		-moz-border-radius-topleft: 5px;
	    border-top-left-radius: 5px;
	    -moz-border-radius-topright: 5px;
	    border-top-right-radius: 5px;	    
	    -moz-border-radius-bottomleft: 5px;
	    border-bottom-left-radius: 5px;
	    -moz-border-radius-bottomright: 5px;
	    border-bottom-right-radius: 5px;
	}
	
	.header_background{
		color: #000000; 
		border-top-style: solid; 
		border-top-width: 0px; 
		border-bottom-style: solid; 
		border-bottom-width: thin; 
		border-color: #ffffff; 
		color: #ffffff; 
		height: 120px;		
	}
</style>
<script type="text/javascript" >
	function logout(){		
		$.ajax({
			type : "POST",
			url : "logout.action",				
			data : "",
			success : function(response) {
				$('#indexContent').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function changeProfile(){
		$("#index_cont").html("<div style=\"width: auto\" align=\"center\"><img src=\"images/loader.gif\"/></div>");
		$.ajax({
			type : "POST",
			url : "chang_profile.action",				
			data : "",
			success : function(response) {				
				$('#index_cont').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
</script>

</head>
<body>
<!-- box-shadow: 0 0 15px #d7d7d7; -moz-box-shadow: 0 0 5px #595959; -webkit-box-shadow: 0 0 5px #595959; -->
	
	<c:set var="sysURLInitial" value="/SMS"/>
	
	<table width="100%" cellpadding="0" cellspacing="0"> 
		<tr bgcolor="#8BD948">
			<td class="header-background" align="center">
				
				<div style="width: 98%; height: 60px; padding-top: 15px;">
										
					<c:set var="dbStatus" value="dashboardStatus"/>
					
					<table align="right" width="100%">
						<tr>
							<td align="left" style="height: 20px; color: #fff; font-size: 15px; font-weight: bold;">
								EVEREST YOUTH ACADEMY
							</td>
							<td align="center" width="10px">
								&nbsp;
							</td>
							<td align="right" style="min-width: 130px">
								Login as - <%= session.getAttribute("loggedInUser") %>
							</td>
							<td align="center" width="10px">
								&nbsp;
							</td>
							<td align="center" width="150px">
								<a href="${sysURLInitial}/admin/index" style="color: #fff; text-decoration: none;" onmouseover="this.style.color = '#3d6e9f'" onmouseout="this.style.color = '#ffffff'">
									<div id="header_tab">
										Home
									</div>
								</a>
							</td>
							<td align="center" width="10px">
								&nbsp;
							</td>
							<td align="center" width="150px">
								<a href="${sysURLInitial}/admin/logout" style="color: #fff; text-decoration: none" onmouseover="this.style.color = '#3d6e9f'" onmouseout="this.style.color = '#ffffff'">
									<div id="header_tab">
										Logout
									</div>
								</a>
							</td>
							<td align="center" width="10px">
								&nbsp;
							</td>
							<td align="center" width="150px">
								<s:div onclick="changeProfile()" style="color: #fff; text-decoration: none;" onmouseover="this.style.color = '#3d6e9f'" onmouseout="this.style.color = '#ffffff'">
									<div id="header_tab">
										Change Profile
									</div>
								</s:div>
							</td>
						</tr>
					</table>				
					
				</div>
			</td>
		</tr>
		<tr>
			<td style="background-color: #e5e5e5; line-height: 6px;">
				&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>