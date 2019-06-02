<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:set var="cl_id" value="${subjectAllotment.cl_id}"/>
	<c:set var="sub_counter" value="0"/>
	
	<div id="errorMessage" class="errorMessage"></div>

	<table>
		<c:forEach varStatus="stat" var="assignPeriodList" items="${subjectList}">
			<tr>
				<td valign="middle" style="padding: 5px;"> <c:out value="${assignPeriodList[1]}"/> </td>
				<td valign="middle" style="padding: 5px;">
					<c:set var="sub_id" value="${assignPeriodList[0]}"/>
					<c:set var="subname" value="${assignPeriodList[1]}"/>
					<c:set var="periodperweek" value="${assignPeriodList[4]}"/>
					<c:set var="period" value=""/>
					<c:if test="${periodperweek != \"0\"}"><c:set var="period" value="${periodperweek}"/></c:if>
					<input id="${subname}" value="${periodperweek}" onchange="addSubjectPeriodAllotment(this.value, '${sub_id}')" class="form-control">
				</td>
			</tr>
			<c:set var="sub_counter" value="${sub_counter + 1}"/>
		</c:forEach>
		
		<c:set var="ppw" value=""/>
		<c:if test="${sub_counter != \"0\"}">
			<c:set var="ppw" value="${subjectList[0][4]}"/>
		</c:if>
		
		<c:if test="${empty ppw}">
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-default" onclick="saveClassPeriodAllotment('${loader}', '${sub_counter}', '${cl_id}')"> SAVE </button>
				</td>
			</tr>
		</c:if>
	</table>

</body>
</html>