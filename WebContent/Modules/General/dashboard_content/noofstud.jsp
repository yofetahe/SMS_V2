<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<link rel="stylesheet" type="text/css" href="css/sms_css.css">

<c:url value="/Resources/js/jquery-1.6.1.js" var="JqJS"/>
	<script type="text/javascript" src="${JqJS}"></script>
<c:url value="/Resources/bootstrap/js/bootstrap.min.js" var="BsJS"/>
	<script type="text/javascript" src="${BsJS}"></script>
<c:url value="/Resources/js/highcharts.js" var="HighChartJS"/>
	<script type="text/javascript" src="${HighChartJS}"></script>
	

	
</head>
<body>

	<div id="db_content" style="width: 100%; min-height: 400px">
	
	</div>
</body>
</html>