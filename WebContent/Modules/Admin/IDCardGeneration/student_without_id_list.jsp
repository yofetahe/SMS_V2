<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<%-- 	<c:set var="cl_id" value="class_bean.cl_id"/> --%>
<%-- 	<c:set var="cd_id" value="cdetail_bean.cd_id"/> --%>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div id="stud_with_out_id" class="content_background">
	
		<div class="titleBottomBorder" style="width: 100%; text-align: center; font-weight: bold; margin-bottom: 10px;">
			Student without ID Card
		</div>
		
		<div style="color: GREEN; text-align: center;"> ${successMessage} </div>
		
		<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
		<script type="text/javascript" src="${JqJS1123}"></script>
			
		<table id="stud_with_out_id_rslt" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="5%">No</th>
					<th>Student Name</th>
					<th>ID No.</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="stat" var="stud_with_out_id_rslt" items="${stud_with_out_id_rslt}">
					<tr>
						<td align="center">
							<c:out value="${stat.index + 1}"/>					
						</td>
						<td>
							<div style="color: #3d6e9f;">
								<c:out value="${stud_with_out_id_rslt[1]}"/> <c:out value="${stud_with_out_id_rslt[2]}"/> <c:out value="${stud_with_out_id_rslt[3]}"/>
							</div>									
						</td>
						<td align="left">
							<c:out value="${stud_with_out_id_rslt[9]}"/>
						</td>			
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="form-group" style="width: 100%;" align="center">
			<button type="submit" class="btn btn-default" onclick="generateIDCardForStudent('${loader}', '${cl_id}', '${cd_id}')"> Generate ID Card  </button>
		</div>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#stud_with_out_id_rslt').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
</body>
</html>