<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<div class="titleBottomBorder">
		Subject - <c:out value="sub_name"/>
	</div>
		
	<div id="rsltEditForm" style="padding-top: 10px;">
	
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="subject_rslt_detail" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="5%">#</th>
					<th width="35%">Exam Type</th>
					<th width="10%">Result</th>
					<th width="10%">Pass Mark</th>
					<th width="10%">Status</th>
					<th width="10%">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="markPerExamType" items="${markPerExamType}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>
							<c:set var="er_id" value="${markPerExamType[0]}"/>
						</td>
						<td>
							<c:out value="${markPerExamType[5]}"/>
							<c:set var="et_id" value="${markPerExamType[4]}"/>
						</td>
						<td>
							<c:set var="rslt" value="${markPerExamType[1]}"/>
							<c:set var="maxRslt" value="${markPerExamType[3]}"/>
							<c:out value="${markPerExamType[1]}"/>/<c:out value="${markPerExamType[3]}"/>
						</td>
						<td>
							<c:out value="${markPerExamType[2]}"/>
						</td>
						<td>
							<%-- <c:out value="markPerExamType[#stat.index].submark_status"/> --%>
						</td>
						<td align="center" style="color: #3d6e9f">
							<div style="cursor: pointer;" onclick="editSubRslt('${er_id}', '${rslt}', '${maxRslt}')">
								Edit
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
				
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#subject_rslt_detail').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>