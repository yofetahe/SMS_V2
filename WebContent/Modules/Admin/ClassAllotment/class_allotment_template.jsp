<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td width="60%" valign="top">
			
				<div class="titleBottomBorder" style="margin-bottom: 5px;">
					<div class="form-group form-inline">
						<label for="academic_year"> Academic Year </label>
						<select class="form-control" style="width: 196px;" onchange="getGeneralPeriodAssignmentList(this.value)">
							<c:forEach var="acyear" varStatus="stat" items="${acadmicYearList}">
								<option> <c:out value="${acyear}"/> </option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
				<script type="text/javascript" src="${JqJS1123}"></script>
			
				<table id="periodPerWeek" class="table table-striped table-bordered">
					<thead>
						<tr style="height: 30px;">
							<th>No.</th>
							<th>Class Name</th>
							<th>Subject Name</th>
							<th>Period Per Week</th>
							<th>Academic Year</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="stat" var="assignPeriodList" items="${assignPeriodList}">
							<tr>
								<td align="center"> <c:out value="${stat.index + 1}"/> </td>
								<td> <c:out value="${assignPeriodList[1]}"/> </td>
								<td> <c:out value="${assignPeriodList[2]}"/> </td>
								<td> <c:out value="${assignPeriodList[3]}"/> </td>
								<td> <c:out value="${assignPeriodList[4]}"/> </td>
								<td align="center">
									<div style="color: #3d6e9f; cursor: pointer;" onclick="editAllotedNumOfPeriod('${assignPeriodList[0]}')"> Edit </div> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</td>
			<td>&nbsp;</td>
			<td width="35%" valign="top" id="periodAllotmentForm">
				
				<table width="100%">
					<tr>
						<td align="right" class="titleBottomBorder" style="padding-right: 100px;">
							
							<c:set var="ac_year" value="academic_year"/>
							<div class="form-group form-inline">
								<label for="academic_year"> Academic Year </label>					
								<input id="academic_year" type="text" value="${academic_year}" class="form-control">
							</div>
							<div class="form-group form-inline">
								<label for="academic_year"> Grade </label>
								<form:select path="subjectAllotment.cl_id" class="form-control" style="width: 196px;" onchange="getSubjectListPerClass(this.value, '${loader}')">
									<form:option value="0">-</form:option>
									<form:options itemLabel="class_name" itemValue="cl_id" items="${classTypeList}"/>
								</form:select>
							</div>
							
						</td>
					</tr>
					<tr>
						<td align="center">							
							<div id="subjectPeriodList">
								<div class="successMessage"> ${successMessage} </div>
							</div>
						</td>
					</tr>
				</table>
				
			</td>			
		</tr>
	</table>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#periodPerWeek').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>