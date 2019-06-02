<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>
</head>
<body>

	<c:set var="rNum" value="${rowNum}"/>
	<c:set var="studCount" value="0"/>	
	<c:set var="listSize" value="${listSize}"/>
	<c:set var="classSize" value="${classSize}"/>
	<c:set var="cl_id" value="${classDetailRel.cl_id}"/>
	<c:set var="cd_id" value="${classDetailRel.cd_id}"/>

	<table cellpadding="0" cellspacing="0" width="100%" style="padding-top: 5px;" border="0">
	
		<c:forEach begin="0" varStatus="stat1" end="${rNum-1}">
			<tr>
				<c:forEach begin="0" varStatus="stat2" end="5">
					<c:set var="row" value="${stat1.index}"/>
					<c:set var="col" value="${stat2.index}"/>					
					<td>												
						<c:if test="${classSize > studCount}">
							<div  style="border: 2px; border-color: silver; border-style: solid; width: 120px; height: 150px;">
								<div style="margin-top: 0px; padding-left: 5px;" align="left">
									<c:out value="${studCount + 1}"/>
								</div>
								<c:if test="${listSize > studCount}">
									<table cellpadding="0" cellspacing="0" align="center" style="padding-top: 5px;">
										<tr>
											<td align="center">
												<%-- <c:set var="photo_path" value="stud_list[#studCount].photo_path"/> --%>
												<c:url var="default_photo" value="/Resources/images/default.jpg"></c:url>
												<img alt="photo" src="${default_photo}" width="40px">
											</td>
										</tr>
										<tr>
											<td align="center">												
												<c:out value="${student_list[studCount][1]}"/>
											</td>
										</tr>
										<tr>
											<td align="center">
												<c:out value="${student_list[studCount][2]}"/>
											</td>
										</tr>
									</table>
									<c:set var="si_id" value="${student_list[studCount][0]}"/>
									<div onclick="studAbsent('${si_id}', '${row}', '${col}', '${cl_id}', '${cd_id}')" style="background-color: #3d6e9f; color: #fff; text-align: center; height: 25px; cursor: pointer">
										Absent
									</div>
									<div id="${row}${col}" style="width: auto; text-align: center;"></div>
								</c:if>
							</div>
						</c:if>
					</td>
					<td>&nbsp;</td>					
					<c:set var="studCount" value="${studCount + 1}"/>
				</c:forEach>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</c:forEach>
	</table>

</body>
</html>