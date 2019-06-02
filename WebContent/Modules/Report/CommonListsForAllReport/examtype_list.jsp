<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

<form:select path="examSubRel.et_id" cssClass="form-control" style="width: 160px;">
	<form:option value="0">- Exam Type -</form:option>
	<form:options itemLabel="et_name" itemValue="et_id" items="${exam_type_list}"/>
</form:select>
