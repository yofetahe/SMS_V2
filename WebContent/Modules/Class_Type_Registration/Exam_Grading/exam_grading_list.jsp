<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="grdListCont">
	
		<div class="titleBottomBorder" style="margin-bottom: 10px;">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td style="height: 50px">
						Exam Grading for <b><c:out value="${subClassRel.subjectType.sub_name}"/></b> Subject
					</td>
					<td style="padding-left: 20px;" align="right">
						<button type="submit" class="btn btn-default" onclick="backToSubjectList('${loader}', '${subClassRel.cl_id}')"> Back to subject list </button>
					</td>
					<td style="padding-left: 20px;" align="right">
						<button type="submit" class="btn btn-default" onclick="addGradeFrm('${loader}', '${subClassRel.subcl_id}')"> Add Grading Mark </button>
					</td>
				</tr>
			</table>		
		</div>
					
		<div id="subjectGradingForms" class="content_background" style="min-height: 440px">
						
			<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
			<script type="text/javascript" src="${JqJS1123}"></script>
		
			<table id="examGradingListTbl" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>No</th>
						<th>Grade</th>
						<th>From</th>
						<th>To</th>
						<th>Status</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="stat" var="related_grading_list" items="${related_examgrading_list}">
						<tr>
							<td align="center"> 
								<c:out value="${stat.index + 1}"/>
								<c:set var="escg_id" value="${related_grading_list[0]}"/>								
							</td>
							<td> <c:out value="${related_grading_list[3]}"/> </td>
							<td align="center"> <c:out value="${related_grading_list[4]}"/> </td>
							<td align="center"> <c:out value="${related_grading_list[5]}"/> </td>
							<td align="center">
								<c:set var="escg_status" value="${related_grading_list[6]}"/>
								<c:choose>
									<c:when test="${escg_status == \"A\"}"> Active </c:when>
									<c:otherwise>Inactive</c:otherwise>
								</c:choose>
							</td>
							<td align="center"> 
								<div style="cursor: pointer; color: #3d6e9f;" onclick="updateGradeFrm('%{#subcl_id}', '%{#sub_name}', '%{#escg_id}', '%{#eg_value}', '%{#grade_from}', '%{#grade_to}', '%{#escg_status}')">
									Edit 
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
					
		</div>
			
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#examGradingListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>