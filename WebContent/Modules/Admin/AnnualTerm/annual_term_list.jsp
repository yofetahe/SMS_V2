<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="annualTermInfo">

		<table width="100%">
			<tr>
				<td width="55%" valign="top">
					
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
			
					<table id="annual_term_list" class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>No</td>
								<td>Name</td>
								<td>Date From</td>
								<td>Date To</td>
								<td>Status</td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="stat" var="annualTermList" items="${annualTermList}">
								<tr>
									<td align="center">
										<c:out value="${stat.index + 1}"/>
									</td>
									<td>
										<c:out value="${annualTermList.at_name}"/>
									</td>
									<td>
										<c:out value="${annualTermList.at_date_from}"/>
									</td>
									<td>
										<c:out value="${annualTermList.at_date_to}"/>
									</td>
									<td>
										<c:set var="status" value="${annualTermList.at_status}"/>
										<c:choose>
											<c:when test="${status == \"A\"}">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose>
									</td>
									<td align="center" style="color: #3d6e9f;">
										<div style="cursor: pointer;" onclick="editAnnualTerm('${annualTermList.at_id}')">Edit</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			
				</td>
				<td width="5%">&nbsp;</td>
				<td valign="top">
					
					<jsp:include page="annual_term_create.jsp"/>
					
				</td>
			</tr>
		</table>
	
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#annual_term_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>