<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td>
				<table width="100%" style="border-bottom-style: solid; border-bottom-width: thin; border-bottom-color: #3d6e9f;" cellpadding="0" cellspacing="0"><tr><td>
				
					<table cellpadding="0" cellspacing="0" >
						<tr>
							<td>&nbsp;</td>
							<td width="180px" height="25px" align="center">
								<div id="matList" class="header_btn_inactive" style="width: 100%" onclick="getMaterialList('${loader}')">
									Material List
								</div>
							</td>							
							<td>&nbsp;</td>							
							<td width="180px" height="25px" align="center">
								<div id="matClassRel" class="header_btn_inactive" style="width: 100%" onclick="getMaterialClassRelation('${loader}')">
									Material Class Relation
								</div>
							</td>
							<td>&nbsp;</td>
							<td width="180px" height="25px" align="center">
								
							</td>
							<td>&nbsp;</td>													
						</tr>
					</table>
				
				</td></tr></table>
			</td>
		</tr>
		<tr>
			<td>
				<div id="materialInformationList" style="padding-top: 10px;">
				
					
				</div>
			</td>
		</tr>
	</table>

</body>
</html>