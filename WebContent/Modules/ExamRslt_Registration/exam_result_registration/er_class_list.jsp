<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

<div class="form-group form-inline">						
	<form:select id="cl_id" path="examResult.studentRegistration.clcdRelation.cl_id" cssClass="form-control" onchange="gradeDetailListForExamResult(this.value, '${loader2}')" style="width: 160px;">
		<form:option value="0">-Class-</form:option>
		<form:options itemLabel="class_name" itemValue="cl_id" items="${class_list}"/>
	</form:select>
</div>
