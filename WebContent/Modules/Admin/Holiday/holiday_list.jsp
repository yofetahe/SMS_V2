<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%"><tr><td width="60%" valign="top"> 
	
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="holidayListTbl" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td width="5%">No</td>
					<td width="30%">Holiday Name</td>				
					<td width="15%">Date <br/>(Ethiopian Calendar)</td>
					<td width="15%">Date <br/>(Gregorian Calendar)</td>
					<td width="15%">Working Status</td>				
					<td width="10%">Status</td>
					<td width="10%">&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="holidayList" items="${holidayList}">
					<tr style="height: 30px">
						<td align="center">
							<c:out value="${stat.index + 1}"/>
						</td>
						<td>
							<c:out value="${holidayList.h_name}"/>
						</td>
						<td>
							<c:out value="${holidayList.h_ethio_date}"/>
						</td>
						<td>
							<c:out value="${holidayList.h_greg_date}"/>
						</td>
						<td>
							<c:out value="${holidayList.work_status}"/>
						</td>
						<td>
							<c:set var="status" value="${holidayList.h_status}"/>
							<c:choose>
								<c:when test="${status == \"A\"}">Active</c:when>
								<c:otherwise>Inactive</c:otherwise>
							</c:choose>
						</td>
						<td align="center" style="color: #3d6e9f;">
							<div style="cursor: pointer;" onclick="editHoliday('${holidayList.h_id}')">Edit</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</td><td width="2%">&nbsp;</td><td valign="top" align="center">
	
		<jsp:include page="holiday_create.jsp"/>
	
	</td></tr></table>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#holidayListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>