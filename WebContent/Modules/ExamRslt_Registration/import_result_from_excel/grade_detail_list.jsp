<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

<s:select label="Grade" id="cd_id" headerValue="Select grade" headerKey="0" list="gradeDetail" listValue="cd_name" onchange="subjectListForImportFromExcel(this.value)" listKey="cd_id" style="height: 25px; width: 204px;"/>

</body>
</html>