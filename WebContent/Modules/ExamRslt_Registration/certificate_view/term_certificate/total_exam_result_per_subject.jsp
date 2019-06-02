<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div class="titleBottomBorder">
		Name - <span style="color: #3d6e9f"> <c:out value="${full_name}"/> </span> &nbsp;&nbsp;
		Student Rank - <span style="color: #3d6e9f"> <c:out value="${examResult.stud_rank}"/> </span>
	</div>
		
	<div style="padding-top: 10px;">
			
		<table width="100%"><tr><td width="50%">
								
			<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
			<script type="text/javascript" src="${JqJS1123}"></script>
			
			<table id="subjectMarkList" class="table table-striped table-bordered">
				<thead >
					<tr>
						<th width="5%">#</th>
						<th width="30%">Subject</th>
						<th width="10%">Mark</th>
						<th width="10%">Pass Mark</th>
						<th width="10%">Status</th>
						<th width="10%">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="stat" var="studentMarkList" items="${studentMarkList}">				
						<tr>
							<td align="center">
								<c:out value="${stat.index + 1}"/>
								<c:set var="exsub_id" value="${studentMarkList[6]}"/>
							</td>
							<td>
								<c:out value="${studentMarkList[1]}"/>
							</td>
							<td>
								<c:out value="${studentMarkList[2]}"/>/<c:out value="${studentMarkList[4]}"/>
							</td>
							<td>
							<c:out value="${studentMarkList[3]}"/>
							</td>
							<td>
	<%--								<c:out value="${studentMarkList[#stat.index].mark_status}"/>  --%>
							</td>
							<td style="text-align: center">
								<div style="color: #3d6e9f; width: 100%; cursor: pointer;" onclick="getSubjectResultPerExamDetail('${loader}', '${examResult.studentRegistration.clcdRelation.cl_id}', '${examResult.si_id}', '${studentMarkList[0]}', '${studentMarkList[6]}')">
									Detail
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>				
			</table>
				
		</td><td style="padding-left: 10px;" id="subject_detail" valign="top">
		
			
		
		</td></tr></table>
	
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#subjectMarkList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>