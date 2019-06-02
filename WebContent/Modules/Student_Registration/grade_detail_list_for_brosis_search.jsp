<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select id="cd_id" class="form-control">
	<option value="0">- Class Detail List -</option>
	<c:forEach var="class_detail_list" items="${class_detail_list}">
		<option value="${class_detail_list[0]}">${class_detail_list[1]}</option>
	</c:forEach>
</select>