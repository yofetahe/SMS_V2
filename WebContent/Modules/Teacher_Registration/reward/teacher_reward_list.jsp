<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<div class="titleBottomBorder" style="padding-top: 5px;">
			
		<button type="submit" class="btn btn-default" onclick="addNewReward('${loader}', '${teacherInfo.ti_id}')"> Add New Reward </button>
		
	</div>
	
	<br/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>

	<div id="container">
		<table id="teachreward_list" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>Reward Type</th>
					<th>Reward Reason</th>
					<th>Date</th>
					<th>Status</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reward_rslt" varStatus="stat" items="${reward_list}">
					<tr height="30px">
						<td>
							<c:out value="${stat.index + 1}"/>
						</td>
						<td>
							<c:out value="${reward_rslt.tr_type}"/>
						</td>
						<td>
							<c:out value="${reward_rslt.tr_reason}"/>
						</td>
						<td>
							<c:out value="${reward_rslt.tr_date}"/>
						</td>
						<td>
							<c:set var="trstatus" value="${reward_rslt.tr_status}"/>
							<c:if test="${trstatus == \"A\"}">Active</c:if>
							<c:if test="${trstatus == \"I\"}">Inactive</c:if>
						</td>
						<td style="color: #3d6e9f" align="center">
							<div style="cursor: pointer;" onclick="editReward('${reward_rslt.tr_id}')">Edit</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#teachreward_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>