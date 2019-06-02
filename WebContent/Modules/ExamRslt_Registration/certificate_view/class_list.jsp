<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<div>
		<form:select path="" cssClass="form-control" onchange="examrslt_gradeSelectedList(this.value)">
			<form:option value="0">Class List</form:option>
			<form:options itemLabel="class_name" itemValue="cl_id" items="${grade_rslt}"/>
		</form:select>
	</div>

</body>
</html>