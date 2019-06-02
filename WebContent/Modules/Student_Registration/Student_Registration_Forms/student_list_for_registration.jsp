<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
<script type="text/javascript" src="${JqJS1123}"></script>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3" class="titleBottomBorder" style="height: 50px;">
				<b> Student Registration for <c:out value="${studReg.clcdRelation.classType.class_name}"/>  </b>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td width="49%" valign="top">
				<!-- student list for registration -->
				
				<div id="container">
					<table id="studListForReg" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th align="center">No</th>
								<th>Student Name</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="studList" items="${stud_list}">
							<tr>
								<td align="center">
									<c:out value="${stat.index + 1}"/>
								</td>
								<td>
									<c:out value="${studList[1]}"/> <c:out value="${studList[2]}"/> <c:out value="${studList[3]}"/>
								</td>
								<td>
									<c:out value="${studList[4]}"/>
								</td>
								<td align="center" >
<%-- 									<div id="${stud_id}_add" onclick="selectStudent('${studList[0]}', '${stud_name}', '${studReg.clcdRelation.classType.cl_id}')" style="color: #3d6e9f; cursor: pointer;"> --%>
<!-- 										Add -->
<!-- 									</div> -->
									<input type="checkbox"  onclick="selectStudentsForRegistration('${studList[0]}', '${studReg.clcdRelation.classType.cl_id}', '${studList[1]}', '${studList[2]}', '${studList[3]}')">
								</td>
							</tr>
						</c:forEach>
					</table>
					<div style="width: 100%;" align="center">
						<button type="submit" class="btn btn-default" onclick="addSelectedStudentsForRegistration('${loader}')"> ADD SELECTED STUDENTS </button>
					</div>
				</div>
				
				<!-- student list for registration -->
			</td>
			<td>&nbsp;</td>
			<td width="48%" valign="top">
				<!-- student selected for registration -->
				
				<div id="selStudList">
				
				</div>
				
				<!-- student selected for registration -->
			</td>
		</tr>
	</table>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#studListForReg').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>
	
</body>
</html>