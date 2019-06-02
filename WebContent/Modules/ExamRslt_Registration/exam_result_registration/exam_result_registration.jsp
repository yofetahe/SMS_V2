<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

</head>
<body>
			
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td width="49%" valign="top">
			
				<div class="titleWithBackgroundColor">
					Exam Result Registration Form
				</div>
				<div id="studrsltFrm" style="padding-top: 5px">
					
					<div id="examrsltcreatetable">
						<jsp:include page="exam_result_registration_form.jsp"/>
					</div>
							
				</div>
			
			</td>
			<td>&nbsp;</td>
			<td width="49%" valign="top">
				
				<div class="titleWithBackgroundColor">
					Registered Exam Result List
				</div>
				<div id="rsltEditForm" style="padding-top: 5px">
					 
					<jsp:include page="exam_result_registered_list.jsp"/>
					
				</div>
			
			</td>
		</tr>
	</table>
	
</body>
</html>