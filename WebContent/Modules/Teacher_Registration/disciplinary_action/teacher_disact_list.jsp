<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<div class="titleBottomBorder" style="padding-top: 5px;">
		
		<button type="submit" class="btn btn-default" onclick="addDisAct('${loader}', '${teacherInfo.ti_id}')"> Add Disciplinary Action </button>
		
	</div>
	
	<br/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<div id="container">
			
		<table id="teachdisact_list" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>DisAct Type</th>
					<th>DisAct Reason</th>
					<th>DisAct Date</th>
					<th>DisAct Status</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="disact_rslt" items="${disaction_list}">
					<tr style="height: 30px">
						<td>
							<c:out value="${stat.index + 1}"/>
						</td>
						<td>
							<c:out value="${disact_rslt.tda_type}"/>
						</td>
						<td>
							<c:out value="${disact_rslt.tda_reason}"/>
						</td>
						<td>
							<c:out value="${disact_rslt.tda_date}"/>
						</td>
						<td>							
							<c:set var="tda_status" value="${disact_rslt.tda_status}"/>
							<c:if test="${tda_status == \"A\"}">Active</c:if>
							<c:if test="${tda_status == \"I\"}">Inactive</c:if>
						</td>
						<td align="center" style="color: #3d6e9f">
							<div style="cursor: pointer" onclick="editDisact('${disact_rslt.tda_id}')">Edit</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
					
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#teachdisact_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>