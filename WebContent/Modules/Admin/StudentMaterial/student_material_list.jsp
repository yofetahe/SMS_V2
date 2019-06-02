<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="matListPage">
	
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">
					
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
			
					<table id="materialList" class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>No</td>
								<td>Material Name</td>
								<td>Material Description</td>
								<td>Status</td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="materialList" items="${materialList}">
							<tr>
								<td align="center"> <c:out value="${stat.index + 1}"/> </td>
								<td> <c:out value="${materialList.ptm_name}"/> </td>
								<td> <c:out value="${materialList.ptm_desc}"/> </td>
								<td> 
									<c:set var="status" value="${materialList.ptm_status}"/>
									<c:choose>
										<c:when test="${status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td align="center">
									<div style="color: #3d6e9f; cursor: pointer;" onclick="editStudentMaterial('${materialList.ptm_id}')">
										Edit
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				
				</td>
				<td>&nbsp;</td>
				<td width="40%" valign="top" align="center">
					
					<div id="saveEditForm">
					
						<div class="panel panel-default" style="width: 80%">
							<div class="panel-heading">
								<h4 class="panel-title" style="color: #1c75bc;">
									Material Registration Form
								</h4>
							</div>
							<div class="panel-body" align="right" style="padding-right: 30px;">
										
								<div class="form-group form-inline">
									<label for="ptm_name"> Material Name </label>					
									<input id="ptm_name" type="text" value="" class="form-control">
								</div>
								
								<div class="form-group form-inline">
									<label for="ptm_desc"> Material Description </label>					
									<input id="ptm_desc" type="text" value="" class="form-control">
								</div>
											
								<button type="submit" class="btn btn-default" onclick="saveMaterial('${loader}')"> SAVE </button>
										
							</div>
						</div>	
						
					</div>
					
				</td>
			</tr>
		</table>	
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#materialList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>