<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<div style="padding-top: 20px;">
	
		<table id="totalStudentAbsent" class="table table-striped table-bordered">
			<thead>
				<tr>
					<td width="2%">No.</td>
					<td width="30%">Student Name</td>
					<td width="50%">Date List</td>
					<td width="15%">No of Days</td>
				</tr>
			</thead>
			<c:forEach varStatus="stat" var="aggStudAbsent_list" items="${aggStudAbsent_list}">
				<tr>
					<td align="center" style="height: 30px;">
						<c:out value="${stat.index + 1}"/>
					</td>
					<td>
						<c:out value="${aggStudAbsent_list[1]}"/> <c:out value="${aggStudAbsent_list[2]}"/> <c:out value="${aggStudAbsent_list[3]}"/>
					</td>
					<td>
						<c:out value="${aggStudAbsent_list[4]}"/>
					</td>
					<td>
						<c:out value="${aggStudAbsent_list[4]}"/> day(s)
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#totalStudentAbsent').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>