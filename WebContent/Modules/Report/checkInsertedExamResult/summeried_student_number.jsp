<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<div class="content_background">

	<div style="width: 50%">
	
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
	
		<table id="checkStudMarkInsert" class="table table-striped table-bordered">
			<thead>
				<tr style="height: 30px;">
					<th> No </th>
					<th> Subject </th>
					<th> No. of Students </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="studNum" varStatus="stnum" items="${summerized_studmark_number}">						
					<tr>
						<td height="30px;">
							<c:out value="${stnum.index + 1}"/>
						</td>
						<td height="30px;">
							<c:out value="${studNum[1]}"/>
						</td>
						<td align="center">
							<c:out value="${studNum[2]}"/>
						</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
		
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#checkStudMarkInsert').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>