<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table>
		<thead>
			<tr><th>Student Name</th></tr>
		</thead>
		<tbody>
			<c:forEach var="stud_name" items="${student_search_result}">
				<tr>
					<td>${stud_name[1]} ${stud_name[2]} ${stud_name[3]} [<span style="color: #3d6e9f; cursor: pointer;" onclick="selectStudentAsBrotherSister('${loader}', '${stud_name[0]}', '${stud_name[1]} ${stud_name[2]} ${stud_name[3]}')"> ADD </span>]</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>