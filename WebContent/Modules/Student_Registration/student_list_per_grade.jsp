<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<b><c:out value="${headerTitle}"/></b>
	</div>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
		
	<div id="student_list_pergrade" >
	
		<table id="student_info_list" class="table table-striped table-bordered">
			<thead>
				<tr style="text-align: center;">
					<th width="5%">No</th>
					<th width="20%">Student Name</th>
					<th width="8%">ID No</th>
					<th width="8%">Sex</th>
					<th width="12%">Date of Birth</th>
					<th width="12%">Place of Birth</th>
					<th width="10%">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stud_rslt" varStatus="stat" items="${stud_list}">
					<tr height="35px">
						<td align="center">
							<c:out value="${stat.index + 1}"/>						
						</td>
						<td>
							<div style="color: #3d6e9f; cursor: pointer" onclick="getStudentDetailInformationForm('${loader}', '${stud_rslt[0]}', '${studReg.clcdRelation.cl_id}', '${studReg.clcdRelation.cd_id}')">
								<c:out value="${stud_rslt[1]}"/> &nbsp; <c:out value="${stud_rslt[2]}"/> &nbsp; <c:out value="${stud_rslt[3]}"/>
							</div>									
						</td>
						<td>
							<c:out value="${stud_rslt[9]}"/>									
						</td>
						<td>
							<c:set var="sex" value="${stud_rslt[5]}"/>
							<c:choose>
								<c:when test="${stud_rslt[5] == \"F\"}">Female</c:when>
								<c:otherwise>Male</c:otherwise>
							</c:choose>									
						</td>
						<td>
							<c:out value="${stud_rslt[6]}"/>
						</td>
						<td>
							<c:out value="${stud_rslt[7]}"/>
						</td>								
						<td>
							<c:set var="sistatus" value="${stud_rslt[10]}"/>
							<c:choose>
								<c:when test="${stud_rslt[10] == \"A\"}">Active</c:when>
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
		    $('#student_info_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>