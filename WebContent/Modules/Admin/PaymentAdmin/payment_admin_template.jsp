<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="padding-top: 1px" valign="top">
								
				<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
				<script type="text/javascript" src="${JqJS1123}"></script>
									
				<table id="payAmountListTbl" class="table table-striped table-bordered">
					<thead>
						<tr>
							<td width="5%">No</td>
							<td width="15%">Class</td>
							<td width="15%">Payment Type</td>
							<td width="15%">Payment Amount</td>
							<td width="15%">Days for Penalty</td>
							<td width="10%">Penalty Rate</td>
							<td width="10%">Status</td>
							<td width="5%">-</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="stat" var="payment_info" items="${paymentAmountList}">
							<tr>
								<td>
									<c:out value="${stat.index + 1}"/>
								</td>
								<td>
									<c:out value="${payment_info[2]}"/>
								</td>
								<td>
									<c:out value="${payment_info[4]}"/>
								</td>
								<td>
									<c:out value="${payment_info[5]}"/>
								</td>
								<td>
									<c:out value="${payment_info[6]}"/>
								</td>
								<td>
									<c:out value="${payment_info[7]}"/>
								</td>
								<td>
									<c:set var="status" value="${payment_info[9]}"/>
									<c:choose>
										<c:when test="${status == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
								<td>
									<div onclick="paymentInfo_edit('${payment_info[0]}')" style="cursor: pointer; color: #3d6e9f; text-align: center;">Edit</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</td>
			<td>&nbsp;</td>
			<td style="padding-top: 10px" valign="top" align="center">
				
				<jsp:include page="payment_admin_create.jsp"/>
				
			</td>
		</tr>
	</table>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#payAmountListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>