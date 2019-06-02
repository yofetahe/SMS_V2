<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<div id="assignContainer">
			
		<div class="titleBottomBorder" style="padding-top: 5px;">
			
			<button type="submit" class="btn btn-default" onclick="teacherAssignment('${loader}', '${teacherInfo.ti_id}')"> Add Teacher Assignment </button>
			
		</div>
		
		<br/>
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
					
		<div id="container">
			<table id="assignList" class="table table-striped table-bordered">
				<thead>
					<tr>
						<td>No</td>
						<td>Grade</td>
						<td>Subject</td>
						<td>Status</td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="assign_rslt" varStatus="stat" items="${assign_list}">
						<tr height="30px">
							<td align="center">
								<c:out value="${stat.index + 1}"/>								
							</td>
							<td>
								<c:out value="${assign_rslt[4]}"/>
							</td>
							<td>
								<c:out value="${assign_rslt[2]}"/>
							</td>
							<td>
								<c:set var="ta_status" value="${assign_rslt[6]}"/>
								<c:choose>
									<c:when test="${ta_status == \"A\"}">Active</c:when>
									<c:otherwise>Inactive</c:otherwise>
								</c:choose>
							</td>
							<td align="center">
								<div style="color: #3d6e9f; cursor: pointer;" onclick="editTeacherAssignment('${teacherInfo.ti_id}', '${assign_rslt[0]}')">
									Edit
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
	</div>

	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#teach_workexp').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>