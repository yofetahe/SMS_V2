<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<table width="100%" cellpadding="0" cellspacing="0" style="padding-top: 5px;">
		<tr>
			<td width="15%" valign="top">											
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" style="padding-top: 10px;">							
							
							<select id="academicYear" class="form-control" onchange="getStudentListPerSelectedAcadmicYear(this.value, '${loader}')">
								<c:forEach var="acyear" items="${acyear_list}">
									<option>${acyear}</option>
								</c:forEach>
							</select>
							
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td style="background-color: #3d6e9f; color: #ffffff; height: 35px; text-align: center;">
							Class Category
						</td>
					</tr>
					<tr>
						<td style="line-height: 3px">&nbsp;</td>
					</tr>
					<c:forEach varStatus="stat" var="grade_list" items="${class_list}">
						<tr>
							<td align="center" onmouseover="this.style.color = '#3d6e9f'" onmouseout="this.style.color = '#000000'">
								<c:set var="clid" value="${grade_list.cl_id}"/>
								<c:set var="clname" value="${grade_list.class_name}"/>
								<div class="menu_button" id="${clid}" onclick="getGradeDetailListPerSelectedClass('${loader}', '${clid}', '${clname}')">
									<c:out value="${grade_list.class_name}"/>
								</div>
							</td>
						</tr>
						<tr>
							<td style="line-height: 3px">&nbsp;</td>
						</tr>														
					</c:forEach>
				</table>
								
			</td>																		
			<td width="2%">&nbsp;</td>		
			<td valign="top">																			
				<div id="studpergrade">

					<jsp:include page="student_male_female_num_per_class.jsp"/>
					
				</div>
			</td>
		</tr>
	</table>

</body>
</html>