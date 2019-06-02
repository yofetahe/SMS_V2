<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<div id="teachFroms">
			
		<div class="titleBottomBorder" style="padding-top: 5px;">
			
			<button type="submit" class="btn btn-default" onclick="addNewTeacherWorkExp('${loader}', '${teacherInfo.ti_id}')"> Add New Teacher Work Experience </button>
			
		</div>
		
		<br/>
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
		
		<table id="teach_workexp" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>Name of Institute</th>
					<th>Job Title</th>
					<th>Date From</th>
					<th>Date To</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="workexp_list" varStatus="stat" items="${workexp_list}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}" />
						</td>
						<td>
							<div onclick="editTeacherWorkExp('${workexp_list.twe_id}')" style="cursor: pointer; color: #3d6e9f;">
								<c:out value="${workexp_list.name_of_institute}" />
							</div>
						</td>
						<td>
							<c:out value="${workexp_list.job_title}" />
						</td>
						<td>
							<c:out value="${workexp_list.date_from}" />
						</td>
						<td>
							<c:out value="${workexp_list.date_to}" />
						</td>
						<td>
							<c:set var="twe_status" value="${twe_status}"/>
							<c:choose>
								<c:when test="${twe_status == \"A\"}">Active</c:when>
								<c:otherwise>Inactive</c:otherwise>
							</c:choose>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
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