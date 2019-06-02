<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td valign="top">
				
				<div class="titleBottomBorder" style="margin-bottom: 5px;">
					Assigned Home Room Teacher List of <b><c:out value="${academic_year}"/> Academic Year</b>
				</div>
				
				<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
				<script type="text/javascript" src="${JqJS1123}"></script>
			
				<table id="hrtAssign" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>No</th>
							<th>Teacher Name</th>
							<th>Grade</th>
							<th>Section</th>
							<th>Status</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="stat" var="assignTeacherList" items="${teachersAssignment}">
							<tr>
								<td align="center">
									<c:out value="${stat.index + 1}"/>
								</td>
								<td>
									<c:out value="${assignTeacherList[2]}"/>
								</td>
								<td>
									<c:out value="${assignTeacherList[4]}"/>
								</td>								
								<td align="center">
									<c:out value="${assignTeacherList[6]}"/>
								</td> 
								<td>
									<c:set var="assignStatus" value="${assignTeacherList[7]}"/>
									<c:choose>
										<c:when test="${assignStatus == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td align="center">
									<div style="color: #3d6e9f; cursor: pointer;" onclick="tassignEditForm('${assignTeacherList[0]}')">
										Edit
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</td>
			<td style="width: 2%">&nbsp;</td>
			<td style="width: 38%; padding-left: 5px; vertical-align: top;" align="center">
			
				<div id="saveEditForm">
				
					<div class="panel panel-default" style="width: 80%">
						<div class="panel-heading">
							<h4 class="panel-title" style="color: #1c75bc;">
								New Assignment Registration Form
							</h4>
						</div>
						<div class="panel-body" align="right" style="padding-right: 30px;">
						
							<div class="form-group form-inline">
								<label for="tiid"> Academic Year </label>
								<input type="text" id="academic_year" readonly="readonly" value="${academic_year}" class="form-control">
							</div>
									
							<div class="form-group form-inline">
								<label for="tiid"> Teachers </label>					
								<form:select path="homeroomAssign.ti_id" id="tiid" class="form-control" style="width: 196px;">
									<form:option value="0">-</form:option>
									<form:options itemLabel="fname" itemValue="ti_id" items="${teachersList}"/>
								</form:select>
							</div>
							
							<div class="form-group form-inline">
								<label for="clid"> Class Type </label>					
								<form:select path="homeroomAssign.cl_id" id="clid" class="form-control" style="width: 196px;">
									<form:option value="0">-</form:option>
									<form:options itemLabel="class_name" itemValue="cl_id" items="${classTypeList}"/>
								</form:select>
							</div>
							
							<div class="form-group form-inline">
								<label for="cdid"> Class Detail Type </label>					
								<select id="cdid" class="form-control" style="width: 196px;">
									<option>-</option>
								</select>
							</div>
										
							<button type="submit" class="btn btn-default" onclick="saveAssignment('${loader}')"> SAVE </button>
									
						</div>
					</div>
					
				</div>
			
			</td>
		</tr>
	</table>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#hrtAssign').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>