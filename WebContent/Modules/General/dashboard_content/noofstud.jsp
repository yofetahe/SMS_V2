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
	
<script type="text/javascript">
	
$(document).ready(function(){
	$(function () { 
		
		var y_list = [	<c:forEach var="studentNum" items="${studentNumPerYear}" varStatus="stat">
						<c:if test="${stat.index > 0}">,</c:if>
						'<c:out value="studentNum[0]/>'                 
						</c:forEach>]
		var m_list = [	<c:forEach var="studentNum" items="${studentNumPerYear}" varStatus="stat">
						<c:if test="${stat.index > 0}">,</c:if>
						'<c:out value="studentNum[1]/>'                 
						</c:forEach>]
		var f_list = [	<c:forEach var="studentNum" items="${studentNumPerYear}" varStatus="stat">
						<c:if test="${stat.index > 0}">,</c:if>
						'<c:out value="studentNum[2]/>'                 
						</c:forEach>]
			
		var ylist = y_list + "";
		var year_list = ylist.split(",");	
		
		var mlist = m_list + "";
	 	var male_list = mlist.split(",").map(Number);
	
	 	var flist = f_list + "";
	 	var female_list= flist.split(",").map(Number);
		
	    $('#db_content').highcharts({
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: 'Number of Students per Year'
	        },
	        xAxis: {
	            categories: year_list
	        },
	        yAxis: {
	            title: {
	                text: 'Students Number'
	            }
	        },
	        series: [{
	            name: 'Male',
	            data: male_list
	        }, {
	            name: 'Female',
	            data: female_list
	        }]
	    });
	});
});
	
</script>
	
</head>
<body>

	<div id="db_content" style="width: 100%; min-height: 400px">
	
	</div>
</body>
</html>