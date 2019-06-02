<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="student_list">

		<table border="0" width="100%" cellpadding="0" cellspacing="0" style="border-bottom: thin; border-bottom-color: silver; border-bottom-style: solid; border-bottom-width: thin;">
			<tr>
				<td style="height: 50px;" width="20%">
					<div style="color: #3d6e9f; cursor: pointer;" onclick="getAllStudentsListPerSelectedYear('${loader}')">
						<c:url var="nextIcon" value="/Resources/images/next.gif"/>
						<span class="glyphicon glyphicon-chevron-right">&nbsp;</span>
						<img alt="arrow" src="${nextIcon}" style="width: 6px;"> List All Students
					</div>
				</td>
				<td align="center">&nbsp;</td>
				<td style="height: 35px;" width="25%">
					<div style="color: #3d6e9f; cursor: pointer;" onclick="getInactiveStudentsListPerSelectedYear('${loader}')">
						<c:url var="nextIcon" value="/Resources/images/next.gif"/>
						<img alt="arrow" src="${nextIcon}" style="width: 6px;"> List All Inactive Students
					</div>
				</td>
				<td align="center" width="10px;">&nbsp;</td>
				<td style="height: 35px;">
					<div style="color: #3d6e9f; cursor: pointer;" onclick="getNewCandidateStudentsList('${loader}')">
						<c:url var="nextIcon" value="/Resources/images/next.gif"/>
						<img alt="arrow" src="${nextIcon}" style="width: 6px;"> New Candidate Students List
					</div>
				</td>
		<!-- 		<td align="center" width="10px;">&nbsp;</td> -->
		<!-- 		<td style="height: 35px;"> -->
		<!-- 			<div style="color: #3d6e9f; cursor: pointer;" onclick="dropoutStudentsList()"> -->
		<!-- 			<img alt="arrow" src="images/next.gif" style="width: 6px;"> Dropout Students List -->
		<!-- 			</div> -->
		<!-- 		</td> -->
			</tr>
		</table>
		<br/>
		<table cellpadding="0" cellspacing="4">
		
			<c:set var="num_of_class" value="${num_of_class}"/>
			
			<c:set var="counter" value="${0}"/>
			
			<c:forEach begin="1" end="3" varStatus="st">
				<tr>
					<c:forEach begin="1" end="5" varStatus="stat">
						<td>
							<c:if test="${counter < num_of_class}">
							
								<div class="formboarder" style="width: 190px; height: 150px;">
									
									<table width="100%" cellpadding="0" cellspacing="0">
										<tr><td colspan="2" align="center" height="60px;">
										
											<div class="menu_shadow">
												<c:set var="total" value="${studnum_perclass[counter][2]+studnum_perclass[counter][3]}"/>
												<span style="color: #3d6e9f"><b> <c:out value="${class_list.get(counter).class_name}"/> </b></span> <br/>
												Total Number: <c:out value="${total}"/>
											</div>
											
										</td></tr>
										<tr><td align="center" style="padding-top: 10px;">
										
											<c:url var="maleIcon" value="/Resources/images/sex_icon/male_default.jpeg"/>
											<img alt="male" src="${maleIcon}" width="55px"> <br/>
											<c:set var="male" value="${studnum_perclass[counter][2]}"/>
											<c:out value="${male}"/>
											
										</td><td align="center" style="padding-top: 10px;">
										
											<c:url var="femaleIcon" value="/Resources/images/sex_icon/female_default.jpeg"/>
											<img alt="female" src="${femaleIcon}" width="55px"> <br/>
											<c:set var="female" value="${studnum_perclass[counter][3]}"/>
											<c:out value="${female}"/>
											
										</td></tr>
									</table>
										
								</div>
							
							</c:if>			
						</td>
						<td style="width: 20px;">&nbsp;</td>
						<c:set var="counter" value="${counter + 1}"/>
					</c:forEach>
				</tr><tr><td height="2px;">&nbsp;</td></tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>