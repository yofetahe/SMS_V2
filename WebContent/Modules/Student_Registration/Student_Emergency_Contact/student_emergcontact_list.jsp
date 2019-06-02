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
	
	<div id="emergcont_list">
	
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td style="background-color: #f5f5f5; height: 50px; color: #3d6e9f; padding-left: 10px;">
					<div onclick="addNewStudentEergencyContact('${loader}', '${studReg.si_id}')" style="cursor: pointer">
						Add New Emergency Contact Address
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
					
					<div class="successMessage">${successMessage}</div>
					<div class="errorMessage">${errorMessage}</div>
					
					<table id="contact_list" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>Contact Person</th>
								<th>Relationship</th>
								<th>Mobile No</th>
								<th>Office Phone No</th>
								<th>Home Phone No</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="stat" var="emergcont_rslt" items="${studEmergencyContact}">
								<tr style="height: 30px">
									<td align="center">
										<c:out value="${stat.index+1}"/>								  
									</td>
									<td>
										<div onclick="getStudentEmergencyContactEditForm('${loader}', '${studReg.si_id}', '${emergcont_rslt.sec_id}')" style="color: #3d6e9f; cursor: pointer">
											<c:out value="${emergcont_rslt.cont_name}"/>
										</div>
									</td>
									<td>
										<div onclick="getStudentEmergencyContactEditForm('${loader}', '${studReg.si_id}', '${emergcont_rslt.sec_id}')" style="color: #3d6e9f; cursor: pointer">
											<c:out value="${emergcont_rslt.relationship}"/>
										</div>
									</td>
									<td>
										<c:out value="${emergcont_rslt.mob_no}"/>
									</td>
									<td>
										<c:out value="${emergcont_rslt.office_phone_no}"/>
									</td>
									<td>
										<c:out value="${emergcont_rslt.home_phone_no}"/>
									</td>
									<td>
										<c:set var="status" value="${emergcont_rslt.sec_status}"/>
										<c:choose>
											<c:when test="${status == \"A\" }">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose>								
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>			
				
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
</body>
</html>