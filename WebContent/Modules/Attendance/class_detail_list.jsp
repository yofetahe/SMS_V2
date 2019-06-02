<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body style="margin: 0">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" style="border-bottom-style: solid; border-bottom-width: thin; border-bottom-color: #3d6e9f;" cellpadding="0" cellspacing="0"><tr><td>
		<table cellpadding="0" cellspacing="0" >
			<tr>
				<c:forEach var="class_detail" varStatus="stat" items="${class_detail}">
					<td width="80px" height="25px" align="center">
						<c:set var="cdid" value="${class_detail.cd_id}"/>
						<div class="header_btn_inactive" id="${cdid}_cd" onclick="getStudentListPerClassDetailForAttendance('${loader}', '${classType.cl_id}', '${cdid}')">
							<c:out value="${classType.class_name}"/> - <c:out value="${class_detail.cd_name}"/>
						</div>
					</td>
					<td>&nbsp;</td>
				</c:forEach>								
			</tr>
		</table>
	</td></tr></table>
		
	<div id="attendanceStudentList">
		
	</div>
					
</body>
</html>