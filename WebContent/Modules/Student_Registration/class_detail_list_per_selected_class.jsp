<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" cellpadding="0" cellspacing="0" style="padding-top: 0px;">		
		<tr>
			<td style="vertical-align: top;">
			
				<c:set var="classid" value="${studReg.clcdRelation.classType.cl_id}"/>
				<c:set var="clname" value="${studReg.clcdRelation.classType.class_name}"/>
								
				<c:if test="${num_of_class_detail > 0}">
					<table border="0" width="100%" style="border-bottom-style: solid; border-bottom-width: thin; border-bottom-color: #3d6e9f;" cellpadding="0" cellspacing="0"><tr><td>
						<table border="0" cellpadding="0" cellspacing="0" >
							<tr>
								<c:forEach var="class_detail" items="${class_detail}" varStatus="stat">
									<td height="25px" align="center">
										<c:set var="cdid" value="${class_detail[0]}"/>
										<div class="header_btn_inactive" id="${cdid}_cd" onclick="getStudentListPerClassDetail('${loader}', '${studReg.clcdRelation.classType.cl_id}', '${cdid}', '${studReg.academic_year}')">
											<c:out value="${class_detail[2]}"/> - <c:out value="${class_detail[1]}"/>
										</div>
									</td>
									<td>&nbsp;</td>
								</c:forEach>
								<c:if test="${registrationTime == \"ON\"}">
									<td align="center">
										<div onclick="getStudentRegistrationForm('${loader}', '${studReg.clcdRelation.classType.cl_id}', '${clname}')" class="header_btn_inactive">
											<b>Registration</b>
										</div>
									</td>
								</c:if>
							</tr>
						</table>
					</td></tr></table>
					<br/>
				</c:if>
			
				<!-- Student list -->				
				<div id="student_list_perdetial">
				
					<jsp:include page="student_male_female_num_per_cdetail.jsp"/>
					
				</div>
				<!-- Student list -->
				
			</td>
		</tr>
	</table>
</body>
</html>