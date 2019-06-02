<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body id="sessionExpire" background="<c:url value='/Resources/images/new_bg_2.png'/>" style="margin: 0; background-repeat: repeat; ">

	<div id="fullPageContent">
	
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="menu_shadow">
						<jsp:include page="header.jsp"/>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" id="testid">
				
					<!-- body part -->
					<div style="width: 98%; min-height: 450px">
							
						<table width="100%" height="450px" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="13%" valign="top" style="padding-top: 5px;">
									<div>
										<jsp:include page="menu.jsp"/>
									</div>
								</td>
								<td valign="top" style="padding-top: 10px; padding-left: 10px;">
								
									<div id="index_cont"> 
										
										<jsp:include page="dashboard.jsp"/>
													
									</div>
								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
						</table>
											
					</div>
					<!-- body part -->
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="footer.jsp"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>