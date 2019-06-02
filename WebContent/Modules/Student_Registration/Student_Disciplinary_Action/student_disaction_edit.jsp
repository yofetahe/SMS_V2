<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

	<script>		   
		$(document).ready(function() {

			$("#da_date").datepicker({
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

	<div id="disact_saveform">
				
	<c:url value="/Resources/images/loader.gif" var="loader"/>
								
	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Students Disciplinary Action Update Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="da_type"> Disciplinary Action Type </label>					
				<input id="da_type" type="text" value="${studentDisAction.sda_type}" class="form-control">
			</div>
							
			<div class="form-group form-inline">
				<label for="da_reason"> Disciplinary Action Reason </label>
				<textarea id="da_reason" rows="3" cols="22" class="form-control">${studentDisAction.sda_reason}</textarea> 	
			</div>
						
			<div class="form-group form-inline">
				<label for="da_date"> Disciplinary Action Date </label>
				<input id="da_date" type="text" readonly="readonly" value="${studentDisAction.sda_date}" class="form-control">
			</div>
			
			<div class="form-group form-inline">
				<label for="da_status"> Disciplinary Action Status </label>
				<form:select id="da_status" path="studDisAction.sda_status" class="form-control" style="width: 196px;">
					<form:option value="A">Active</form:option>
					<form:option value="I">Inactive</form:option>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default" onclick="updateDisAct('${loader}', '${studDisAction.si_id}', '${studentDisAction.sda_id}')"> UPDATE </button>
					
		</div>
	</div>			
			
	</div>

</body>
</html>