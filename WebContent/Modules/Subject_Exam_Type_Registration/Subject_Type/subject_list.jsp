<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body style="margin-top: 0">

	<div class="content_background"  style="min-height: 434px">
	
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td style="padding-top: 10px" valign="top" width="45%">
				
					<!-- subject list -->
					
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
									
					<table id="subjectTypeList" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>Subject</th>
								<th>Status</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="stat" var="subject_rslt" items="${subject_list}">				
								<tr>
									<td align="center">
										<c:out value="${stat.index + 1}"/>
										<c:set var="sub_id" value="${subject_rslt.sub_id}"/>
									</td>
									<td>
										<c:out value="${subject_rslt.sub_name}"/>
									</td>
									<td>
										<c:set var="sub_status" value="${subject_rslt.sub_status}"/>
										<c:choose>
											<c:when test="${sub_status == \"A\"}">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose>
									</td>
									<td align="center">
										<div style="color: #3d6e9f; cursor: pointer;" onclick="editSubject('${sub_id}')">Edit</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<!-- subject list -->
							
				</td><td width="5%">&nbsp;</td>
				<td style="padding-top: 10px" valign="top">
					
					<div id="subjectTypeForms">
					
						<jsp:include page="subject_create.jsp"/>
						
					</div>
					
				</td>
			</tr>
		</table>
	
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#subjectTypeList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
			
</body>
</html>