<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="grd">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="50%" valign="top">
				
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
			
					<table id="gradingList" class="table table-striped table-bordered">
						<thead>
							<tr>
								<td width="10%">No</td>
								<td width="30%">Grade</td>
								<td width="35%">Description</td>
								<td>Status</td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="gradingList" items="${gradingList}">
							<tr>
								<td align="center">
									<c:out value="${stat.index + 1}"/>
								</td>
								<td>
									<c:out value="${gradingList.eg_value}"/>
								</td>			
								<td>
									<c:out value="${gradingList.eg_desc}"/>
								</td>
								<td align="center">
									<c:set var="eg_status" value="${gradingList.eg_status}"/>
									<c:choose>
										<c:when test="${eg_status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td style="color: #3d6e9f;" align="center">
									<div onclick="editGrading('${loader}', '${gradingList.eg_id}')" style="cursor: pointer">
										Edit
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				
				</td>
				<td>&nbsp;</td>
				<td width="50%" valign="top" style="padding-left: 35px;" align="center">
					
					<div id="saveEditForm">	
					
						<div class="panel panel-default" style="width: 80%">
							<div class="panel-heading">
								<h4 class="panel-title" style="color: #1c75bc;">
									Grading Registration Form
								</h4>
							</div>
							<div class="panel-body" align="right" style="padding-right: 30px;">
										
								<div class="form-group form-inline">
									<label for="eg_value"> Grade </label>					
									<input id="eg_value" type="text" value="" class="form-control">
								</div>
								
								<div class="form-group form-inline">
									<label for="eg_desc"> Grade Description </label>					
									<input id="eg_desc" type="text" value="" class="form-control">
								</div>
											
								<button type="submit" class="btn btn-default" onclick="saveGrade('${loader}')"> SAVE </button>
										
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
		    $('#gradingList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>