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

	<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top">
			
				<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
				<script type="text/javascript" src="${JqJS1123}"></script>
						
				<table id="materialClassRelList" class="table table-striped table-bordered">
					<thead>
						<tr>
							<td>No</td>
							<td>Class Name</td>
							<td>Material Name</td>
							<td>Amount</td>
							<td>Status</td>
							<td>&nbsp;</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="stat" var="materialClassRelList" items="${materialClassRelList}">
							<tr>
								<td align="center"> 
									<c:out value="${stat.index + 1}"/>
								</td>
								<td> <c:out value="${materialClassRelList[1]}"/> </td>
								<td> <c:out value="${materialClassRelList[3]}"/> </td>
								<td> <c:out value="${materialClassRelList[6]}"/> </td>
								<td> 
									<c:set var="status" value="${materialClassRelList[5]}"/>
									<c:choose>
										<c:when test="${status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td align="center">
									<div style="color: #3d6e9f; cursor: pointer;" onclick="editMaterialClassRel('${materialClassRelList[4]}')">
										Edit
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			</td>
			<td>&nbsp;</td>
			<td width="40%" valign="top" align="center">
				
				<div id="saveEditForm" style="width: 100%;">
				
					<div class="panel panel-default" style="width: 80%">
						<div class="panel-heading">
							<h4 class="panel-title" style="color: #1c75bc;">
								Class-Material Relation Registration Form
							</h4>
						</div>
						<div class="panel-body" align="right" style="padding-right: 30px;">
										
							<div class="form-group form-inline">
								<label for="cl_id"> Class Type </label>
								<form:select path="materialClassRel.cl_id" id="ptm_name"  class="form-control" style="width: 196px;">
									<form:option value="0">-</form:option>
									<form:options itemLabel="class_name" itemValue="cl_id" items="${classTypeList}"/>
								</form:select>
							</div>
							
							<div class="form-group form-inline">
								<label for="ptm_id"> Material Name </label>
								<form:select path="materialClassRel.ptm_id" id="ptm_desc" class="form-control" style="width: 196px;">
									<form:option value="0">-</form:option>
									<form:options itemLabel="ptm_name" itemValue="ptm_id" items="${materialList}"/>
								</form:select>
							</div>
							
							<div class="form-group form-inline">
								<label for="pay_amount"> Payment Amount </label>					
								<input id="pay_amount" type="text" value="" class="form-control">
							</div>
										
							<button type="submit" class="btn btn-default" onclick="saveMaterialClassRel('${loader}')"> SAVE </button>
									
						</div>
					</div>
					
				</div>
				
			</td>
		</tr>
	</table>	
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#materialClassRelList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>