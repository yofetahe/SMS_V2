<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div class="titleBottomBorder" style="cursor: pointer; color: #3d6e9f;">
		Back to list
	</div>
	
	<div style="width: 100%; padding-top: 5px;" align="center">
	
		<div class="panel panel-default" style="width: 70%">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc;">
					Student Exam Result Update Form
				</h4>
			</div>
			<div class="panel-body" align="right" style="padding-right: 30px;">
						
				<div class="form-group form-inline">
					<label for="studentName"> Student Full Name </label>
					<c:set var="studentFullName" value="${exam_result.get(0)[2]} ${exam_result.get(0)[3]} ${exam_result.get(0)[4]}"/>	
					<input id="studentName" type="text" value="${studentFullName}" readonly="readonly" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="studentMark"> Student Mark </label>					
					<input id="studentMark" type="text" value="${exam_result.get(0)[1]}" class="form-control">
				</div>
				
				<div class="form-group form-inline">
					<label for="maximumMark"> Exam Type Maximum Mark </label>					
					<input id="maximumMark" type="text" value="${exam_result.get(0)[5]}" readonly="readonly" class="form-control">
				</div>
								
				<button type="submit" class="btn btn-default" onclick="updateResult('${loader}', '${exam_result.get(0)[0]}')"> UPDATE </button>
						
			</div>
		</div>
	
	</div>
	
	
</body>
</html>