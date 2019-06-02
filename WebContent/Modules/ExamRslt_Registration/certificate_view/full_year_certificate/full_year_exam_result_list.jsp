<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<!-- 	<s:set var="cl_id" value="cl_id"/> -->
<!-- 	<s:set var="cd_id" value="cd_id"/> -->
<!-- 	<s:set var="cl_name" value="cl_name"/> -->
<!-- 	<s:set var="cd_name" value="cd_name"/> -->

	<div style="padding-bottom: 5px; padding-top: 5px;">
		<table cellpadding="0" cellspacing="0"><tr><td align="left">
		
			<button id="saveButton" type="submit" class="btn btn-default" onclick="generalStudentResultDecision('${cl_id}', '${cd_id}', '${cl_name}', '${cd_name}')" style="height: 40px;"> 
				<table align="center"><tr><td>	
					General Student's Result Decision
				</td></tr></table>
			</button>
					
		</td><td style="width: 50px;">&nbsp;</td><td align="center">
			
			<button id="saveButton" type="submit" class="btn btn-default" onclick="generateAllStudentFullYearCertificate('${cl_id}', '${cd_id}', '${cl_name}', '${cd_name}')"> 
				<table><tr><td>
					<c:url value="/Resources/images/pdf.gif" var="pdf"/>
					<img alt="PDF" src="${pdf}" height="25px">
				</td><td valign="middle">	
					Generate All Student Certificate Content
				</td></tr></table>
			</button>
					
		</td><td style="width:50px;">&nbsp;</td><td align="right">
		
			<button id="saveButton" type="submit" class="btn btn-default" onclick="generateAllStudentFullYearCertificateCover('${cl_id}', '${cd_id}', '${cl_name}', '${cd_name}')"> 
				<table><tr><td>
					<c:url value="/Resources/images/pdf.gif" var="pdf"/>
					<img alt="PDF" src="${pdf}" height="25px">
				</td><td valign="middle">	
					Generate All Student Certificate Cover 
				</td></tr></table>
			</button>
						
		</td></tr></table>
	</div>

	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<div id="certView">		
		
		<table id="stud_rslt_list" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="6%">Rank</th>
					<th width="32%">Student Name</th>
					<th width="10%">1st<br/>Quarter</th>
					<th width="10%">2nd<br/>Quarter</th>
					<th width="10%">3rd<br/>Quarter</th>
					<th width="10%">4th<br/>Quarter</th>
					<th width="12%">Average</th>					
					<th> Decision </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="studMark" varStatus="stat" items="${studFullYearMark}">			
					<tr height="35px">
						<td align="center">
						
							<c:set var="year_avg_rank" value="%{#stat.index + 1}"/>
							
							<c:out value="${studMark.student_rank}"/>
																									
						</td>
						<td>
						
							<table width="100%" border="0"><tr><td>
								<div style="color: #3d6e9f; cursor: pointer" onclick="certificateResult('${siid}', '${cl_id}', '${cl_name}', '${cd_id}', '${cd_name}', '${fname}', '${mname}', '${gname}', '${year_avg_rank}')">
									<c:out value="${studMark.studentInformation.fname}"/>&nbsp;<c:out value="${studMark.studentInformation.mname}"/>&nbsp;<c:out value="${studMark.studentInformation.gname}"/>
								</div>
							</td><td align="right" width="60px">
								<div style="color: #3d6e9f; cursor: pointer; width: 60px; text-align: right;" onclick="certificateResultCoverPage('${siid}', '${cl_id}', '${cl_name}', '${cd_id}', '${cd_name}', '${fname}', '${mname}', '${gname}', '${year_avg_rank}')">
									[ Cover ]
								</div>
							</td></tr></table>
										
						</td>
						<td align="center">
							<c:out value="${studMark.quarter_one_total}"/>								
						</td>
						<td align="center">
							<c:out value="${studMark.quarter_two_total}"/>				
						</td>
						<td align="center">
							<c:out value="${studMark.quarter_three_total}"/>									
						</td>
						<td align="center">
							<c:out value="${studMark.quarter_four_total}"/>									
						</td>
						<td align="center">
							<c:set var="fullYearAvg" value="${studMark.average_quarter_mark}"/>
							<c:if test="${fullYearAvg != \"NaN\"}">
								<fmt:formatNumber maxIntegerDigits="3" pattern="##.##">${fullYearAvg}</fmt:formatNumber>
							</c:if>
						</td>
						<td align="center">
						
							<c:set var="studrslt_status" value="${studMark.studentResultStatus}"/>
							
							<c:if test="${fullyearAvg != \"--\"}">
								<c:choose>
									<c:when test="${studrslt_status == \"Active\"}">
										<table><tr><td>
											
											<select onchange="SaveFinalStudentAnnualRsltDecision('${siid}', this.value, '${cl_id}', '${cl_name}', '${cd_id}', '${cd_name}')">
												<option>---</option>
												<option>Passed</option>
												<option>Failed</option>
												<option>Repeat</option>
												<option>Back</option>
											</select>
											
										</td></tr></table>
									</c:when>
									<c:otherwise>
										<table><tr><td>
											
											<select onchange="SaveFinalStudentAnnualRsltDecision('${siid}', this.value, '${cl_id}', '${cl_name}', '${cd_id}', '${cd_name}')">
												<option>---</option>
												<option>Passed</option>
												<option>Failed</option>
												<option>Repeat</option>
												<option>Back</option>
											</select>
											
										</td></tr></table>
									</c:otherwise>
								</c:choose>
							</c:if>
						</td>							
					</tr>
				</c:forEach>
			</tbody>
		</table>
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