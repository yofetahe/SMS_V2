<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:set var="cl_id" value="cl_id"/>
	<c:set var="cd_id" value="cd_id"/>
	<c:set var="at_id" value="at_id"/>
	<c:set var="si_id" value="si_id"/>
	<c:set var="ac_year" value="ac_year"/>
	
	<div class="titleWithBackgroundColor" align="left" style="padding-left: 10px;">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
					Student Name: <c:out value="${full_name}"/>
				</td>
				<td style="padding-left: 30px;">
					Class: <c:out value="${class_name}"/> - <c:out value="${class_detail_name}"/>
				</td>
				<td style="padding-left: 30px;">
					Academic Year: <c:out value="${examResult.fiscal_year}"/>
				</td>
			</tr>
		</table>
	</div>
				
	<div style="padding-top: 10px; padding-left: 10px;">

		<div class="panel panel-default" style="width: 500px;">
			<div class="panel-heading">
				<h4 class="panel-title" style="color: #1c75bc; font-size: 14px;">
					Teacher's Comment Registration Form
				</h4>
			</div>
			<div class="panel-body" align="left" style="padding-right: 30px;">
						
				<div class="form-group form-inline">
					<label for="tchrcomm"> Give your comment here </label>					
					<textarea id="tchrcomm" rows="5" cols="60" class="form-control"></textarea>
				</div>
										
				<button type="submit" class="btn btn-default" onclick="saveTeachersComment('${loader}', '${si_id}', '${cl_id}', '${cd_id}', '${at_id}', '${ac_year}')"> SAVE </button>
						
			</div>
		</div>
		
	</div>


</body>
</html>