<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

</head>
<body>

	<c:set var="cl_id" value="cl_id"/>
	<c:set var="cd_id" value="cd_id"/>
	<c:set var="exsub_id" value="exsub_id"/>
	<c:set var="subcl_id" value="subcl_id"/>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div style="color: GREEN; width: 100%; text-align: center;">  </div>
		
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
				
	<table id="studRegResultList" class="table table-striped table-bordered">
		<thead>
			<tr>
				<td width="5%">No</td>
				<td width="40%">Student Name</td>
				<td width="15%">Mark</td>
				<td width="15%">&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="stat" var="studRsltList" items="${filledStudentResultList}">
				<tr height="30px">
					<td align="center">
						<c:out value="${stat.index + 1}"/>						
						<c:set var="maxRslt" value="${studRsltList[7]}"/>									
					</td>
					<td>
						<c:out value="${studRsltList[2]}"/> <c:out value="${studRsltList[3]}"/> <c:out value="${studRsltList[4]}"/>
					</td>
					<td>
						<c:out value="${studRsltList[5]}"/>/<c:out value="${studRsltList[7]}"/>
					</td>
					<td style="color: #3d6e9f; text-align: center;">
						<div style="cursor: pointer;" onclick="getStudentSubjectMarkEditForm('${loader}', '${studRsltList[0]}', '${studRsltList[1]}')">
							Edit
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#studRegResultList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>