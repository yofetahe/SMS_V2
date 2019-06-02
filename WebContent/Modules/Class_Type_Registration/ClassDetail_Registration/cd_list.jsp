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
	
	<div id="cdtlList" class="content_background" style="min-height: 440px">
	
		<div class="titleBottomBorder" style="margin-bottom: 10px;">		
			<button type="submit" class="btn btn-default" onclick="addCDetail('${loader}')"> Add Class Detail </button>
		</div>
						
		<table id="cdetailListTbl" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>No</th>
					<th>Detail Name</th>
					<th>Status</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="cd_rslt" items="${class_detail_list}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>
							<c:set var="cd_id" value="${cd_rslt.cd_id}"/>
						</td>
						<td>
							<c:out value="${cd_rslt.cd_name}"/>
						</td>
						<td>
							<c:out value="${cd_rslt.cd_status}"/>
						</td>
						<td align="center">
							<div style="color: #3d6e9f; cursor: pointer;" onclick="editCDetail('%{#cd_id}', '%{#cd_name}', '%{#cd_status}')">
								Edit
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
		    $('#cdetailListTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>