<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td style="height: 50px">
					Subject list for - <c:out value="${classType.class_name}"/>
				</td>
				<td style="padding-left: 20px;" align="right">
					<button type="submit" class="btn btn-default" onclick="addClassSubRel('${loader}', '${classType.cl_id}', '${classType.class_name}')"> Add Subject </button>
				</td>
			</tr>
		</table>		
	</div>
	
	<div id="classSubjectRelForms" class="content_background" style="min-height: 345px">
			
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
								
		<table id="classSubjectRelListTbl" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>Subject</th>
					<th>Status</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<c:forEach varStatus="stat" var="classsub_rslt" items="${related_subject_list}">
				<tr>
					<td align="center">
						<c:out value="${stat.index + 1}"/>
						<c:set var="subcl_id" value="${classsub_rslt[0]}"/>
					</td>
					<td>
						<c:out value="${classsub_rslt[1]}"/>
						<c:set var="sub_name" value="${classsub_rslt[1]}"/>
						<c:set var="sub_id" value="${classsub_rslt[4]}"/>
						<c:set var="add_to_total" value="${classsub_rslt[3]}"/>						
					</td>
					<td>
						<c:set var="rel_status" value="${classsub_rslt[6]}"/>
						<c:choose>
							<c:when test="%{#rel_status == \"A\"}">Active</c:when>
							<c:otherwise>Inactive</c:otherwise>
						</c:choose>
					</td>
					<td align="center">
						<div style="cursor: pointer; color: #3d6e9f" onclick="editClSubRel('${subcl_id}', '%{#rel_status}', '%{#cl_id}', '%{#cl_name}', '%{#sub_name}', '%{add_to_total}', '%{con_to_grade}')"> Edit </div>
					</td>
					<td align="center">
						<div style="cursor: pointer; color: #3d6e9f" onclick="getRelatedExamTypeList('${loader}', '${subcl_id}', '${sub_name}', '${cl_id}', '${sub_id}')"> Exam Type </div>
					</td>
					<td align="center" width="80px;">
						<c:set var="con_to_grade" value="${classsub_rslt[3]}"/>
						<c:if test="${con_to_grade == \"YES\"}">
							<div style="cursor: pointer; color: #3d6e9f" onclick="getRelatedExamGradingList('${loader}', '${subcl_id}', '${sub_name}', '${cl_id}', '${sub_id}', '${cl_name}')"> Grading </div>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#classSubjectRelListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
			
</body>
</html>