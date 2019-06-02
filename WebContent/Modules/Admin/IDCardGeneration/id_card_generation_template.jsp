<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div id="btbgrelpage" style="padding-top: 10px;">

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td style="width: 15%; padding-left: 5px;" valign="top">
			
				<div class="form-group" style="width: 100%;">
					<button type="submit" class="btn btn-default" onclick="generateIdCardForRemaining('${loader}')"> Generate Over-all ID Card </button>
				</div>
				
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
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
								<div class="menu_button" id="${clid}" onclick="getClassDetailListForIDCardByClassId('${loader}', '${clid}', '${grade_list.class_name}')">
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
			<td style="width: 2%">&nbsp;</td>
			<td valign="top" id="student_list">
			
			</td>
		</tr>
	</table>
	</div>

</body>
</html>