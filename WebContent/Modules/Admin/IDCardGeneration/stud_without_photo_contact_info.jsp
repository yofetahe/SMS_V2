<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:set var="prev_name"  value=""/>
	<c:set var="rowNum" value="1"/>
	
	<div class="content_background">
	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<c:out value="${pageTitle}"/>
	</div>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
			
	<table id="stud_contact_info_list" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th width="1%">&nbsp;</th>
				<th width="30%">Student Name</th>
				<th width="">Sex</th>
				<th width="">Relationship</th>
				<th width="">Contact Name</th>
				<th width="">Phone</th>				
			</tr>
		</thead>
		<c:forEach varStatus="stat" var="stud_rslt" items="${stud_without_photo_contact_rslt}">
			<tr>
				<td align="center" style="font-size: 1px;">					
					<c:set var="siid" value="${stud_rslt[0]}"/>
					<c:set var="sex" value="${stud_rslt[2]}"/>
					<c:set var="fullname" value="${stud_rslt[1]}"/>					
				</td>
				<td>
					<c:if test="${prev_name != fullname}">													
						<div style="color: #3d6e9f;">
						 	<c:out value="${rowNum}"/> - <c:out value="${fullName}"/>
						</div>
						<c:set var="rowNum" value="${rowNum + 1}"/>
					</c:if>							
				</td>
				<td>
					<c:if test="${prev_name != fullname}">
						<c:choose>
							<c:when test="${sex == \"F\"}">Female</c:when>
							<c:otherwise>Male</c:otherwise>
						</c:choose>
					</c:if>										
				</td>
				<td>
					<c:out value="${stud_rslt[4]}"/>
				</td>
				<td>
					<c:out value="${stud_rslt[3]}"/>
				</td>								
				<td>
					<c:out value="${stud_rslt[5]}"/>
				</td>							
			</tr>
			<c:set var="prev_name"  value="${fullname}"/>
		</c:forEach>
	</table>
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#stud_contact_info_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>