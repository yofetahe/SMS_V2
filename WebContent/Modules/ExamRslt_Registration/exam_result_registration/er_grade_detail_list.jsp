<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

<div class="form-group form-inline">						
	<form:select id="cd_id" path="examResult.studentRegistration.clcdRelation.cd_id" cssClass="form-control" onchange="subjectListForExamResult(this.value, '${loader2}')" style="width: 160px;">
		<form:option value="0">-Class Detail-</form:option>
		<form:options itemLabel="cd_name" itemValue="cd_id" items="${class_detail}"/>
	</form:select>
</div>
