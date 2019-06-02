<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<table id="examScheduleListTbl" class="table table-striped table-bordered">
		<thead>
			<tr>
				<td width="5%">No</td>
				<td width="12%">Grade</td>
				<td width="12%">Subject</td>
				<td width="12%">Exam Type</td>				
				<td width="12%">Date <br/>(Ethiopian Calendar)</td>
				<td width="12%">Date <br/>(Gregorian Calendar)</td>	
				<td width="12%">Exam Hour</td>
				<td>Term</td>			
				<td width="7%">Status</td>
				<td width="7%">&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="stat" var="exSchList" items="${examScheduleList}">
				<tr>
					<td align="center">
						<c:out value="${stat.index + 1}"/>
					</td>
					<td>
						<c:out value="${exSchList[7]}"/>
					</td>
					<td>
						<c:out value="${exSchList[10]}"/>
					</td>
					<td>
						<c:out value="${exSchList[8]}"/>
					</td>
					<td>
						<c:out value="${exSchList[3]}"/>
					</td>
					<td>
						<c:out value="${exSchList[4]}"/>
					</td>
					<td align="center">
						<c:out value="${exSchList[11]}"/> - <c:out value="${exSchList[12]}"/>
					</td>
					<td align="center">
						<c:out value="${exSchList[5]}"/>
					</td>
					<td>
						<c:set var="status" value="${exSchList[6]}"/>
						<c:choose>
							<c:when test="${status == \"A\"}">Active</c:when>
							<c:otherwise>Inactive</c:otherwise>
						</c:choose>
					</td>
					<td align="center" style="color: #3d6e9f;">
						<div style="cursor: pointer;" onclick="editExamSchedule('${loader}', '${stat.index}', '${exSchList[2]}')">Edit</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#examScheduleListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>