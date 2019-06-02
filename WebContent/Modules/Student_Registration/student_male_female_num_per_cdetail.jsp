<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<c:url value="/Resources/images/loader.gif" var="loader"/>

<table width="100%" class="titleBottomBorder" style="margin-bottom: 10px;">
	<tr>
		<td style="height: 15px;">
			<div style="color: #3d6e9f; cursor: pointer;" onclick="getStudentsListPerSelectedGrade('${loader}', '${studReg.clcdRelation.classType.cl_id}', '${studReg.clcdRelation.classType.class_name}')">
				<c:url var="nextIcon" value="/Resources/images/next.gif"/>
				<img alt="arrow" src="${nextIcon}" style="width: 6px;"> List All <c:out value="${studReg.clcdRelation.classType.class_name}"/> Students
			</div>
		</td>
	</tr>
</table>

<c:set var="cd" value="${0}"/>
<c:set var="num" value="${num_of_class_detail}"/>

<table cellpadding="0" cellspacing="14">
	<c:forEach begin="1" end="3">
		<tr>
			<c:forEach begin="1" end="5">
				<td>
				
					<c:if test="${cd < num}">
						<div class="formboarder" style="width: 190px; height: 150px;">
						
							<table width="100%" cellpadding="0" cellspacing="0">
								<tr><td colspan="2" align="center" height="60px;">
								
									<div class="menu_shadow">
									<span style="color: #3d6e9f; font-weight: bold;"><c:out value="${studReg.clcdRelation.classType.class_name}"/> - <c:out value="${class_detail[cd][1]}"/></span> <br/>
									Total Number: <c:out value="${stud_rslt[cd][2] + stud_rslt[cd][3]}"/>
									</div>
									
								</td></tr>
								<tr><td align="center" style="padding-top: 10px;">
								
									<c:url var="maleIcon" value="/Resources/images/sex_icon/male_default.jpeg"/>
									<img alt="male" src="${maleIcon}" width="55px"> <br/>
									<c:set var="male" value="${stud_rslt[cd][2]}"/>
									<c:out value="${male}"/>
									
								</td><td align="center" style="padding-top: 10px;">
									
									<c:url var="femaleIcon" value="/Resources/images/sex_icon/female_default.jpeg"/>
									<img alt="female" src="${femaleIcon}" width="55px"> <br/>
									<c:set var="female" value="${stud_rslt[cd][3]}"/>
									<c:out value="${female}"/>
									
								</td></tr>
							</table>
							
						</div>
					</c:if>
					
				</td>
				<td style="width: 20px;">&nbsp;</td>
				<c:set var="cd" value="${cd+1}"/>
			</c:forEach>
		</tr>
		<tr><td colspan="4">&nbsp;</td></tr>
	</c:forEach>
</table>

</body>
</html>