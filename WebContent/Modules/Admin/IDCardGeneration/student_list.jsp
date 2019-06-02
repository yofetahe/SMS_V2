<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:set var="cl_id" value="${classTypeClassDetailRel.cl_id}"/>
	<c:set var="cd_id" value="${classTypeClassDetailRel.cd_id}"/>
	
	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<table><tr><td>
		
			<div style="color: #3d6e9f; cursor: pointer;" onclick="getStudentListDontHavePhoto('${loader}', '${cl_id}', '${cd_id}')">
				List Students don't have photo
			</div>
			
		</td><td width="50px;">&nbsp;</td><td>
		
			<div style="color: #3d6e9f; cursor: pointer;" onclick="getStudentListDontHaveContactInfo('${loader}', '${cl_id}', '${cd_id}')">
				List Students don't have Contact Info
			</div>
			
		</td></table>
	</div>
		
	<div id="studentListPerGrade">
	
		<table cellpadding="0" cellspacing="0" width="100%"><tr><td width="48%" valign="top">
			
			<jsp:include page="student_without_id_list.jsp"/>
			
		</td><td>&nbsp;</td>
		<td width="48%" valign="top" id="registered_list">
		
			<jsp:include page="student_with_id_list.jsp"/>
			
		</td></tr></table>
	
	</div>

</body>
</html>