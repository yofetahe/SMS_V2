<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<c:set var="cl_id" value="cl_id"/>
	
	<div style="background-color: #f5f5f5; width: auto; padding: 10px;">
		<table><tr><td>
			
			<select id="at_id" class="form-control" style="width: 196px;" onchange="refreshStudentEvalResultView()">
				<option value="-">Annual Terms</option>
				<c:forEach var="sem_list" items="${quarter_list}">
					<option value="${sem_list.at_id}">${sem_list.at_name}</option>
				</c:forEach>
			</select>
					
		</td><td width="20px;">&nbsp;</td><td>
		
			<div id="errMsg" style="color: #ff0000">&nbsp;</div>
			
		</td></tr></table>	 
	</div>
	
	<div style="height: 5px;">&nbsp;</div>
		
	<table width="100%" cellpadding="0" cellspacing="0"><tr><td width="50%" valign="top">
	
		<table id="studList" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td align="center">#</td>
					<td align="center">Student Name</td>
					<td align="center">Sex</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="stud_rslt" items="${student_list}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>
						</td>
						<td style="color: #3d6e9f; padding-left: 5px;">
						
							<c:set var="si_id" value="${stud_rslt[0]}"/>
													
							<div style="cursor: pointer;" onclick="getStudentEvaluationResult('${loader}', '${classDetailRel.cl_id}', '${si_id}')">
								<c:out value="${stud_rslt[1]}"/> <c:out value="${stud_rslt[2]}"/> <c:out value="${stud_rslt[3]}"/>
							</div>
							
						</td>
						<td align="center">
							<c:out value="${stud_rslt[5]}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</td><td width="5%">&nbsp;</td><td valign="top">
	
		<div id="student_side_list_pergrade"> </div>
	
	</td></tr></table>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#studList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>