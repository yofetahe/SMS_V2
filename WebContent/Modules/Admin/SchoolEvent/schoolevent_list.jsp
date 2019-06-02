<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%"><tr><td width="60%" valign="top">
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="schoolEventList" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td width="5%">No</td>
					<td width="15%">School Event</td>
					<td width="30%">Description</td>
					<td width="15%">Date <br/>(Ethiopian Calendar)</td>
					<td width="15%">Date <br/>(Gregorian Calendar)</td>				
					<td width="10%">Status</td>
					<td width="10%">&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="seblist" items="${schoolEventList}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>
						</td>
						<td>
							<c:out value="${seblist.se_name}"/>
						</td>
						<td>
							<c:out value="${seblist.se_description}"/>
						</td>
						<td>
							<c:out value="${seblist.se_ethio_date}"/>
						</td>
						<td>
							<c:out value="${seblist.se_greg_date}"/>
						</td>
						<td>
							<c:set var="status" value="${seblist.se_status}"/>
							<c:choose>
								<c:when test="${status == \"A\"}">Active</c:when>
								<c:otherwise>Inactive</c:otherwise>
							</c:choose>
						</td>
						<td align="center" style="color: #3d6e9f;">
							<div style="cursor: pointer;" onclick="editSchoolEvent('${seblist.se_id}')">Edit</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</td><td width="2%">&nbsp;</td><td valign="top" align="center">
	
		<jsp:include page="schoolevent_create.jsp"/>
	
	</td></table>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#schoolEventList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>