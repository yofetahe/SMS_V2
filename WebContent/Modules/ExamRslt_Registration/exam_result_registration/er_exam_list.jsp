<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/Resources/images/loader.gif" var="loader"/>

<div class="form-group form-inline">
	<select id="cl_id" class="form-control" onchange="getStudentExamResultRegistration(this.value, '${loader}')" style="width: 160px;">
		<option value="0">-Exam Type-</option>
		<c:forEach var="et_list" items="${exam_type_list}">
			<option value="${et_list[1]}">${et_list[2]}</option>
		</c:forEach>
	</select>
</div>