<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div class="formboarder" style="padding-top: 10px; padding-bottom: 10px;">
	
	    <c:choose>
			<c:when test="${stud_info.studRegistration.stud_status == \"DropOut\"}">
				<table align="center" width="100%">
					<tr>
						<td align="center" style="height: 40px;">							
							Enrollment Status: Leave/Drop Out						
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<table align="center" width="100%">
					<tr>
						<td align="center" style="height: 40px;">							
							Enrollment Status: Active				
						</td>
					</tr>
					<tr>
						<td align="center">
							<button type="submit" class="btn btn-default" onclick="studentDropOut('${loader}', '${studReg.si_id}', '${stud_info.studRegistration.stud_status}')"> Drop Out </button>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>