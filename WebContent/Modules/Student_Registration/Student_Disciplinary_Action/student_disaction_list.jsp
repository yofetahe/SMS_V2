<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<c:url value="/Resources/images/loader.gif" var="loader"/>
	
<div id="disact_container">
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="background-color: #f5f5f5; height: 50px; cursor: pointer; color: #3d6e9f; padding-left: 10px;">
				<div onclick="addNewStudentDisciplinaryAction('${loader }', '${studDisAction.si_id}')" >
					Add New Disciplinary Action
				</div>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				
					<table id="disact_list" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>Action Type</th>
								<th>Action Reason</th>
								<th>Action Date</th>
								<th>Status</th>
							</tr>
						</thead>
						<c:forEach varStatus="stat" var="disact_rslt" items="${studentDisAction}">
							<tr style="height: 30px">
								<td align="center">
									<c:out value="${stat.index + 1}"/>
								</td>
								<td style="cursor: pointer; color: #3d6e9f">
									<div onclick="disaction_edit('${disact_rslt.sda_id}', '${disact_rslt.si_id}')">
										<c:out value="${disact_rslt.sda_type}"/>
									</div>
								</td>
								<td>
									<c:out value="${disact_rslt.sda_reason}"/>
								</td>
								<td>
									<c:out value="${disact_rslt.sda_date}"/>
								</td>
								<td>
									<c:set var="disact" value="${disact_rslt.sda_status}"/>
									<c:choose>
										<c:when test="${disact == \"A\"}">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>			
				
			</td>
		</tr>
	</table>
</div>

</body>
</html>