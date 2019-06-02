<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


	<jsp:include page="/Modules/General/header_resource.jsp"/>

	<script>		   
		$(document).ready(function() {

			$("#at_date").datepicker({
				//minDate: 0, 
				maxDate: "0",
				dateFormat : "yy-mm-dd",
				numberOfMonths : 1,
				onSelect : function(selected) {
					//$("#date_to").datepicker("option", "minDate", selected);
				}
			});
		});
	</script>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:set var="rNum" value="${rowNum}"/>
	<c:set var="studCount" value="0"/>	
	<c:set var="listSize" value="${listSize}"/>
	<c:set var="classSize" value="${classSize}"/>
	<c:set var="cl_id" value="${classDetailRel.cl_id}"/>
	<c:set var="cd_id" value="${classDetailRel.cd_id}"/>
	
	<div class="titleBottomBorder" style="background-color: #f5f5f5; padding-top: 15px;">
	
		<div id="errMsg" style="color:red; padding-left: 190px;"></div>
		
		<table>
			<tr>
				<td>
				
					<div class="form-group form-inline">
						<input id="at_date" type="text" readonly="readonly" placeholder="Attendance Date" value="" class="form-control">
					</div>
					
				</td>
				<td style="padding-left: 5px;">
										
					<div class="form-group form-inline">
						<select id="at_type" class="form-control" style="width: 196px;">
							<option value="-">Attendance Type</option>
							<c:forEach var="at_type" items="${attendance_type_list}">
								<option value="${at_type.attype_id}">${at_type.attype_description}</option>
							</c:forEach>
						</select>
					</div>
					
				</td>
				<td style="padding-left: 5px;">
				
					<div class="form-group form-inline">
						<select id="at_id" class="form-control" style="width: 196px;">
							<option value="-">Annual Terms</option>
							<c:forEach var="sem_list" items="${quarter_list}">
								<option value="${sem_list.at_id}">${sem_list.at_name}</option>
							</c:forEach>
						</select>
					</div>
					
				</td>
				<td style="padding-left: 50px;">
					<div class="form-group form-inline">
					<button type="submit" class="btn btn-default" onclick="getAbsentReasonAddForm('${loader}', '${classDetailRel.cl_id}', '${classDetailRel.cd_id}')"> Absent Reason Add Form </button>
					</div>
				</td>
				<td style="padding-left: 5px;">
					<div class="form-group form-inline">
					<button type="submit" class="btn btn-default" onclick="getStudentsAggregateAbsentList('${loader}', '${classDetailRel.cl_id}', '${classDetailRel.cd_id}')"> Students Absent List </button>
					</div>
				</td>
			</tr>
		</table>
			
	</div>
	
	<div id="attendanceListContent" style="padding-top: 5px;">
	
		<jsp:include page="student_attendance_form.jsp"/>
		
	</div>
	
</body>
</html>