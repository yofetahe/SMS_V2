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
				
					<table id="attendanceTypeListTbl" class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>No</td>
								<td>Attendance Type</td>
								<td>Attendance Code</td>
								<td>Status</td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="attypeList" items="${attendanceTypeList}">
							<tr>
								<td align="center"> 
									<c:out value="${stat.index + 1}"/>
								</td>
								<td> <c:out value="${attypeList.attype_description}"/> </td>
								<td> <c:out value="${attypeList.attype_code}"/> </td>
								<td> 
									<c:set var="status" value="${attypeList.attype_status}"/>
									<c:choose>
										<c:when test="${status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td align="center">
									<div style="color: #3d6e9f; cursor: pointer;" onclick="editAttendanceType('${loader}', '${attypeList.attype_id}')">
										Edit
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				
				</td>
				<td>&nbsp;</td>
				<td width="40%" valign="top" align="center">
				
					<div class="panel panel-default" style="width: 80%">
						<div class="panel-heading">
							<h4 class="panel-title" style="color: #1c75bc;">
								Attendance Type Registration Form
							</h4>
						</div>
						<div class="panel-body" align="right" style="padding-right: 30px;">
									
							<div class="form-group form-inline">
								<label for="attype_description"> Attendance Type Name </label>					
								<input id="attype_description" type="text" value="" class="form-control">
							</div>
							
							<div class="form-group form-inline">
								<label for="attype_code"> Attendance Type Code </label>					
								<input id="attype_code" type="text" value="" class="form-control">
							</div>
																
							<button type="submit" class="btn btn-default" onclick="saveAttendanceType('${loader}')"> SAVE </button>
									
						</div>
					</div>
									
				</td>
			</tr>
		</table>	
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#attendanceTypeListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>


</body>
</html>