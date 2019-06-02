<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<s:select label="Select Class" id="cl_id" headerValue="Class Category" headerKey="0" list="#{'1':'Class 1-4', '2':'Class 5-6', '3':'Class 7-8', '4':'Class 9-10'}" onchange="showAdvanceFilterButton(this.value)" style="width: 110px; height: 25px"/>

</body>
</html>