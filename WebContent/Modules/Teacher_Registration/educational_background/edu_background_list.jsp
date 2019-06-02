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
			
			<button type="submit" class="btn btn-default" onclick="addNewTeacherEduBackground('${loader}', '${teacherInfo.ti_id}')"> Add New Teacher Education Background </button>
			
		</div>
		
		<br/>
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
	
		<table id="teach_eduback" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>Name of Institute</th>
					<th>Field of Study</th>
					<th>Graduation Date</th>
					<th>Award</th>
					<th>Status</th>
				</tr>
			</thead>
			<c:forEach var="edubackground_list" varStatus="stat" items="${edubackground_list}">
				<tr>
					<td align="center">
						<c:out value="${stat.index + 1}" /> 
					</td>
					<td>
						<div onclick="editTeacherEduBackground('${edubackground_list.teb_id}')" style="cursor: pointer; color: #3d6e9f;">
							<c:out value="${edubackground_list.name_of_institiute}" />
						</div>
					</td>
					<td>
						<c:out value="${edubackground_list.field_of_study}" />
					</td>
					<td>
						<c:out value="${edubackground_list.graduation_date}" />
					</td>
					<td>
						<c:out value="${edubackground_list.award}" />
					</td>
					<td>
						<c:set var="teb_status" value="${edubackground_list.teb_status}"/>
						<c:choose>
							<c:when test="${teb_status == \"A\"}">Active</c:when>
							<c:otherwise>Inactive</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#teach_eduback').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>