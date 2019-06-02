<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
<script type="text/javascript" src="${JqJS1123}"></script>
	
</head>
<body>

	<c:set var="prev_name"  value=""/>
	<c:set var="rowNum" value="1"/>
	
	<table id="stud_contact_info" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th width="1%">-</th>
				<th width="30%">Student Name</th>
				<th >Sex</th>
				<th >Relationship</th>
				<th >Contact Name</th>
				<th >Phone</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stud_rslt" varStatus="stat" items="${contactInfo}">
				<tr>
					<td align="center" style="font-size: 1px;">
						<c:out value="${stat.index + 1}"/>					
						<c:set var="fullname" value="${stud_rslt[1]} ${stud_rslt[2]} ${stud_rslt[3]}"/>					
					</td>
					<td>
						<c:if test="${prev_name != fullname}">													
							<div style="color: #3d6e9f;">
							 	<c:out value="${rowNum}"/> - <c:out value="${stud_rslt[1]} ${stud_rslt[2]} ${stud_rslt[3]}"/>
							</div>
							<c:set var="rowNum" value="${rowNum + 1}"/>
						</c:if>							
					</td>
					<td>
						<c:set var="sex" value="${stud_rslt[4]}"/>
						<c:if test="${prev_name != fullname}">
							<c:if test="${sex == \"F\"}">Female</c:if>
							<c:if test="${sex == \"M\"}">Male</c:if>
						</c:if>										
					</td>
					<td>
						<c:out value="${stud_rslt[6]}"/>
					</td>
					<td>
						<c:out value="${stud_rslt[5]}"/>
					</td>								
					<td>
						<c:out value="${stud_rslt[7]}"/>
					</td>							
				</tr>
				<c:set var="prev_name"  value="${fullname}"/>
			</c:forEach>
		</tbody>
	</table>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#stud_contact_info').DataTable();
		});
	</script>

</body>
</html>