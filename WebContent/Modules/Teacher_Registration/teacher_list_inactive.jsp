<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body style="padding-top: 10px;">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<div class="content_background" style="padding-top: 10px;">
	<table id="teach_list" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>No</th>
				<th width="30%">Name</th>
				<th width="10%">Sex</th>
				<th width="20%">Place of Birth</th>
				<th width="15%">Date of Birth</th>
				<th width="15%">Nationality</th>
				<th width="10%">ID No</th>
				<th width="10%">Status</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<c:forEach var="tchr_rslt" varStatus="stat" items="${teacher_list}">
			<tr height="30px">
				<td align="center">
					<c:out value="${stat.index + 1}"/>									
				</td>
				<td>
					<%-- onclick="getTeacherProfileEditForm('${loader}', '${tchr_rslt.ti_id}')" --%>
					<div style="cursor: pointer; color: #3d6e9f">
						<c:out value="${tchr_rslt.fname}"/> <c:out value="${tchr_rslt.mname}"/> <c:out value="${tchr_rslt.gname}"/>
					</div> 
				</td>
				<td>
					<c:set var="sex" value="${tchr_rslt.sex}"/>
					<c:choose>
						<c:when test="${sex == \"M\"}">Male</c:when>
						<c:otherwise>Female</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:out value="${tchr_rslt.pob}"/> 
				</td>
				<td>
					<c:out value="${tchr_rslt.dob}"/> 
				</td>
				<td>
					<c:out value="${tchr_rslt.nationality}"/> 
				</td>
				<td>
					<c:out value="${tchr_rslt.id_no}"/> 
				</td>
				<td>
					<c:set var="ti_status" value="${tchr_rslt.ti_status}"/>
					<c:choose>
						<c:when test="${ti_status == \"A\"}">Active</c:when>
						<c:otherwise>Inactive</c:otherwise>
					</c:choose>
				</td>
				<td align="center">
					<div style="cursor: pointer; color: #3d6e9f">
						Activate
					</div> 
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#teach_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>								

</body>
</html>