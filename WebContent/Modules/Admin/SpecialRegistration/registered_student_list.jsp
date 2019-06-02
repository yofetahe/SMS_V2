<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:set var="cl_id" value="${classTypeClassDetailRel.cl_id}"/>
	<c:set var="cd_id" value="${classTypeClassDetailRel.cd_id}"/>
	
	<div class="titleBottomBorder" style="width: 100%; text-align: center; font-weight: bold; margin-bottom: 10px;">
		Specially Registered Student List
	</div>
		
	<div style="color: GREEN; text-align: center;">${successMessage}</div>
	
	<div id="reg_student_list_pergrade">
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="registered_stud_list" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="10%">No</th>
					<th>Student Name</th>
					<th width="15%">&nbsp;</th>
				</tr>
			</thead>
			<c:forEach varStatus="stat" var="registered_stud_rslt" items="${registered_student_list}">
				<tr>
					<td align="center">
						<c:out value="${stat.index + 1}"/>
						<c:set var="si_id" value="${registered_stud_rslt[0]}"/>						
					</td>
					<td>
						<div style="color: #3d6e9f; cursor: pointer">
							<c:out value="${registered_stud_rslt[1]}"/> <c:out value="${registered_stud_rslt[2]}"/> <c:out value="${registered_stud_rslt[3]}"/>
						</div>									
					</td>
					<td align="center" id="${si_id}_id">
						<div onclick="selectRegisteredStudent('${si_id}')">
							<img alt="add" src="images/check_box.png" style="width: 16px;">
						</div>
					</td>			
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div align="center" class="form-group" style="width: 100%"> 
		 <button type="submit" class="btn btn-default" onclick="removeStudentFromSpecialRegistration('${loader}', '${cl_id}', '${cd_id}')"> UPDATE </button>
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#registered_stud_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>