<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div class="titleBottomBorder" style="margin-bottom: 10px;">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td style="height: 50px">
					Class detail of - <c:out value="${classType.class_name}"/>
				</td>
				<td style="padding-left: 20px;" align="right">
					<button type="submit" class="btn btn-default" onclick="addClassDetail('${loader}', '${classType.cl_id}')"> Add New Class Detail </button>
				</td>
			</tr>
		</table>		
	</div>
	
	<div class="content_background" style="min-height: 345px">
			
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
		
		<table id="classDetailTbl" class="table table-striped table-bordered">
			<thead >
				<tr>
	 				<td>No</td>
					<td>Class Detail</td>
					<td>Class Capacity</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="classdetail_list" items="${related_classdetail_list}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>
							<c:set var="clcd_id" value="${classdetail_list[0]}"/>
						</td>
						<td>
							<c:out value="${classdetail_list[1]}"/>
						</td>
						<td>
							<c:out value="${classdetail_list[2]}"/>
						</td>
						<td>
							<c:out value="${classdetail_list[3]}"/>
						</td>
						<td align="center">
							<div style="cursor: pointer; color: #3d6e9f" onclick="editClassDetail('${loader}', '${classType.cl_id}', '${clcd_id}')"> Edit </div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
		
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#classDetailTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
			
</body>
</html>