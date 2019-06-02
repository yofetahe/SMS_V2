<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div id="studPerGrade" class="content_background">
	
		<!-- this student list include only those students who take at lease one exam type and have mark  -->
		<c:set var="cl_id" value="${examResult.studentRegistration.clcdRelation.cl_id}"/>
		<c:set var="cd_id" value="${examResult.studentRegistration.clcdRelation.cd_id}"/>
		<c:set var="at_id" value="${examResult.at_id}"/>
		<c:set var="academic_year" value="${examResult.fiscal_year}"/>
		
		<table><tr><td style="padding-left: 5px;">
		
			<div class="save_update_btn" onclick="emailQuarterResultToAllStudentParents('${cl_id}', '${cd_id}', '${at_id}')" style="height: 40px; width: 100%; padding-top: 5px; padding-left: 10px; padding-right: 10px; cursor: pointer; text-align: center;">
				<table><tr><td>
					<c:url value="/Resources/images/email.png" var="email"/>
					<img alt="email" src="${email}" height="30px">
				</td><td valign="middle">	
					Email to All <c:out value="${class_name}"/>-<c:out value="${class_detail_name}"/> Students Parent
				</td></tr></table>
			</div>
		
		</td><td style="width: 100px;">&nbsp;</td><td>
		
			<div class="save_update_btn" onclick="generateAllStudentCertificate('${cl_id}', '${cd_id}', '${at_id}', '${academic_year}')" style="height: 40px; width: 100%; padding-top: 7px; padding-left: 10px; padding-right: 10px; cursor: pointer; text-align: center;">
				<table><tr><td>
					<c:url value="/Resources/images/pdf.gif" var="pdf"/>
					<img alt="PDF" src="${pdf}" height="25px">
				</td><td valign="middle">
					Generate All Student Certificate
				</td></tr></table>
			</div>
			
		</td></tr></table>
		
		<div class="successMessage"> ${successMessage} </div>
		
		<div style="padding-top: 10px;" id="studentMarkList">
				
			<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
			<script type="text/javascript" src="${JqJS1123}"></script>
					
			<table id="stud_rslt_list" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="7%">Rank</th>
						<th width="35%">Student Name</th>
						<th width="10%">Total Mark</th>
						<th width="10%">Average</th>
						<th>Teachers Comment</th>
						<th>Quarter Certificate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="stat" var="studTotalMark" items="${studTotalMark}">
						<tr height="30px">
							<td align="center">
							
								<c:out value="${studTotalMark.stud_rank}"/>			
																				
							</td>
							<td>
								<div style="color: #3d6e9f; cursor: pointer" onclick="getStudentResultDetail('${loader}', '${studTotalMark.studentInformation.si_id}', '${studTotalMark.stud_rank}')">
									<c:out value="${studTotalMark.studentInformation.fname}"/> <c:out value="${studTotalMark.studentInformation.mname}"/> <c:out value="${studTotalMark.studentInformation.gname}"/>
								</div>									
							</td>
							<td>
								<c:out value="${studTotalMark.result}"/>							
							</td>
							<td>
								<c:set var="avgMark" value="${studTotalMark.average_result}"/>
								<fmt:formatNumber maxIntegerDigits="3" pattern="#.#">${avgMark}</fmt:formatNumber>									
							</td>
							<td align="center">
							
								<table><tr><td>
									<div style="cursor: pointer; color: #3d6e9f;" onclick="getTeachersCertificateCommentAddForm('${loader}', '${studTotalMark.studentInformation.si_id}', '${at_id}', '${cl_id}', '${cd_id}')"> Add </div>							
								</td><td style="width: 50px;">&nbsp;</td><td>
									<div style="cursor: pointer; color: #3d6e9f;" onclick="getTeachersCertificateCommentEditForm('${loader}', '${studTotalMark.studentInformation.si_id}', '${at_id}', '${cl_id}', '${cd_id}')"> Edit </div>							
								</td></tr></table>
								
							</td>
							<td align="center">
								<div style="cursor: pointer; color: #3d6e9f;" onclick="getTermReportCardFormat('${loader}', '${studTotalMark.studentInformation.si_id}', '${at_id}', '${cl_id}', '${cd_id}', '${studTotalMark.stud_rank}', '${academic_year}')"> Generate </div>
							</td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		
	</div>
			
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#stud_rslt_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>