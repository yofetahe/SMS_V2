<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>

	<div style="padding-top: 20px;">
	
		<table id="absStudentList" class="table table-striped table-bordered">
		 	<thead>
			 	<tr>
			 		<td width="1%" style="height: 30px">No.</td>
			 		<td>Student Name</td>
			 		<td>&nbsp;</td>
			 	</tr>
		 	</thead>
		 	<tbody>
			 	<c:forEach varStatus="stat" var="abstStu_list" items="${absent_studnet_list}">
			 		<tr>
			 			<td align="center" style="height: 35px">
			 				<c:out value="#stat.index + 1"/>
			 				<c:set var="att_id" value="${abstStu_list[0]}"/>
			 			</td>
			 			<td width="25%">
			 				 <c:out value="${abstStu_list[2]}"/> <c:out value="${abstStu_list[3]}"/> <c:out value="${abstStu_list[4]}"/>
			 			</td>
			 			<td>
			 				<div id="reason_${stat.index}">
				 				<c:set var="att_reason" value="${abstStu_list[6]}"/>
				 				<c:choose>
					 				<c:when test="${att_reason == \"N\"}">
					 				
					 					<div id="msg_${stat.index}" style="color: #ff0000"></div> 					
					 					
					 					<table cellpadding="0" cellspacing="0"><tr><td>
					 						<input type="text" id="rs_${stat.index}" class="form-control"/>
					 					</td><td >
					 						<button type="submit" class="btn btn-default" onclick="AddAbsentReason('${loader}', '${att_id}', '${stat.index}')"> Add Reason </button>
					 					</td></tr></table>	 					
					 					
					 				</c:when>
					 				<c:otherwise>		 					
					 					Reason:- <c:out value="${abstStu_list[6]}"/>
					 				</c:otherwise>
				 				</c:choose>
			 				</div>
			 			</td>
			 		</tr>
			 	</c:forEach>
		 	</tbody>
		</table>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#absStudentList').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>