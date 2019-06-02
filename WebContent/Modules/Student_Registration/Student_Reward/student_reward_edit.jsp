<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

	<script>		   
		$(document).ready(function() {

			$("#rw_date").datepicker({
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

	<div id="reward_saveform">
					
	<c:url value="/Resources/images/loader.gif" var="loader"/>
								
	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Students Reward Add Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="rw_type"> Reward Type </label>					
				<input id="rw_type" type="text" value="${studentReward.sr_type}" class="form-control">
			</div>
							
			<div class="form-group form-inline">
				<label for="rw_reason"> Reward Reason </label>
				<textarea id="rw_reason" rows="3" cols="22" class="form-control">${studentReward.sr_reason}</textarea> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="rw_date"> Reward Date </label>
				<input id="rw_date" type="text" readonly="readonly" value="${studentReward.sr_date}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="sec_status"> Reward Status </label>
				<form:select id="sec_status" path="studReward.sr_status" class="form-control" style="width: 196px;">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateReward('${loader}', '${studentReward.sr_id}', '${studReward.si_id}')"> UPDATE </button>
					
		</div>
	</div>
							
	</div>

</body>
</html>