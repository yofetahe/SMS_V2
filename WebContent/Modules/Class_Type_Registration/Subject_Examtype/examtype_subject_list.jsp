<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<c:set var="subcl_id" value="subcl_id"/>
	<c:set var="sub_name" value="sub_name"/>
	<c:set var="cl_id" value="cl_id"/>
	<c:set var="sub_id" value="sub_id"/>
	
	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td style="height: 50px">
					Exam type list for - <c:out value="${subClassRel.subjectType.sub_name}"/> subject
				</td>
				<td style="padding-left: 20px;" align="right">					
					<button type="submit" class="btn btn-default" onclick="addSubjectRel('${loader}', '${cl_id}')"> Back to Subject list </button>
				</td>
				<td style="padding-left: 10px;" align="right">
					<button type="submit" class="btn btn-default" onclick="addSubExamTypeRel('${loader}', '${cl_id}', '${subcl_id}', '${sub_id}')"> Add Exam type </button>
				</td>
			</tr>
		</table>		
	</div>
	
	<div id="classSubjectExamTypeRelForms" class="content_background" style="min-height: 380px">
					
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
								
		<table id="examTypeListTbl" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td>No</td>
					<td>Exam Type</td>
					<td>Total Mark</td>
					<td>Pass Mark</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="examtype_subrel_rslt" items="${related_examtype_list}">
					<tr>
						<td>
							<c:out value="${stat.index + 1}"/>
							<c:set var="exsub_id" value="${examtype_subrel_rslt[0]}"/>
						</td>
						<td>
							<c:out value="${examtype_subrel_rslt[2]}"/>
						</td>
						<td>
							<c:out value="${examtype_subrel_rslt[4]}"/>
							<c:set var="total_mark" value="${examtype_subrel_rslt[4]}"/>
						</td>
						<td>
							<c:out value="${examtype_subrel_rslt[5]}"/>
							<c:set var="pass_mark" value="${examtype_subrel_rslt[5]}"/>
						</td>
						<td>								
							<c:set var="rel_status" value="${examtype_subrel_rslt[6]}"/>
							<c:choose>
								<c:when test="${rel_status == \"A\"}">Active</c:when>
								<c:otherwise>Inactive</c:otherwise>
							</c:choose>
						</td>
						<td align="center" style="color: #3d6e9f;">
							<div style="cursor: pointer;" onclick="editClSubExamRel('${exsub_id}', '${cl_id}', '${sub_id}')">Edit</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#examTypeListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>