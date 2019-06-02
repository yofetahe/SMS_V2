<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body style="margin: 0">

	<div class="content_background" style="min-height: 434px">
	
		<table width="100%" cellpadding="0" cellspacing="0">		
			<tr>
				<td style="padding-top: 10px" valign="top">
					
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
					
					<table id="examtypelist" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>Exam Type</th>
								<th>Status</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="examtype_rslt" items="${examtype_list}">
							<tr>
								<td align="center">
									<c:out value="${stat.index + 1}"/>
									<c:set var="et_id" value="${examtype_rslt.et_id}"/>
								</td>
								<td>
									<c:out value="${examtype_rslt.et_name}"/>
								</td>
								<td>								
									<c:set var="et_status" value="${examtype_rslt.et_status}"/>
									<c:choose>
										<c:when test="${et_status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td align="center" style="color: #3d6e9f;">
									<div style="cursor: pointer;" onclick="editExamType('${et_id}')">Edit</div>
								</td>
							</tr>
						</c:forEach>
					</table>
					
				</td><td width="5%">&nbsp;</td>
				<td style="padding-top: 10px" valign="top">
					
					<div id="examTypeForms">
					
						<jsp:include page="examtype_create.jsp"/>
						
					</div>
						
				</td>
			</tr>
		</table>
		
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#examtypelist').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
			

</body>
</html>