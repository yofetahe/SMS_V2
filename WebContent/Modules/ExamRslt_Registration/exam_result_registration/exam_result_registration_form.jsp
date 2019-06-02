<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

</head>
<body>

	<c:set var="cl_id" value="cl_id"/>
	<c:set var="exsub_id" value="exsub_id"/>
	<c:set var="subcl_id" value="subcl_id"/>

	<c:set var="rwcount" value="0"/>
	
	<div>
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="studExamRsltRegForm" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td width="10%">No</td>
					<td width="50%">Student Name</td>
					<td>Exam Mark</td>
					<td>Out Of</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="clstudlist_rslt" items="${unfilledStudentResultList}">
					<tr height="30px">
					 	<td align="center">
					 		<c:out value="${stat.index + 1}"/>
					 	</td>
					 	<td>
					 		<c:out value="${clstudlist_rslt[1]}"/> <c:out value="${clstudlist_rslt[2]}"/> <c:out value="${clstudlist_rslt[3]}"/>
					 		<c:set var="si_id" value="${clstudlist_rslt[0]}"/>
					 		<c:set var="total_mark" value="${clstudlist_rslt[4]}"/>
					 	</td>
					 	<td align="center">
					 		<div id="strslt_${stat.index}"></div>					 		
					 										 		
					 		<div id="rsltFrm_${stat.index}">					 						 		
				 				<input id="rslt_${stat.index}" value="" onchange="checkStudExamRslt(this.value, '${si_id}', '${exsub_id}', '${stat.index}', '${total_mark}')" class="form-control">				 											 			
				 			</div>	
						</td>
						<td align="center">
							<c:out value="${clstudlist_rslt[4]}"/>								
						</td>
					</tr>
					<c:set var="rwcount" value="${rwcount + 1}"/>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<c:if test="${rwcount > 0 && examDateStatus == \"true\"}">		
		<div align="center" style="width: 100%; padding-top: 10px;">
			<button id="saveButton" type="submit" class="btn btn-default" onclick="saveExamRslt('%{#cl_id}', '%{#rwcount}', '%{#exsub_id}', '%{#totalMark}')"> SAVE EXAM RESULT </button>
		</div>			
	</c:if>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#studExamRsltRegForm').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>