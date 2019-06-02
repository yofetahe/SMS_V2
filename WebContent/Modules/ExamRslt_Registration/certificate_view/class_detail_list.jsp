<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>
	
	<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td>
				<table width="100%" style="border-bottom-style: solid; border-bottom-width: thin; border-bottom-color: #3d6e9f;" cellpadding="0" cellspacing="0"><tr><td>
				
					<table cellpadding="0" cellspacing="0" >
						<tr>
							<c:forEach var="class_detail" items="${class_detail}" varStatus="stat">
								<td width="80px" height="25px" align="center">
									<c:set var="cdid" value="${class_detail[0]}"/>
									<div class="header_btn_inactive" id="${cdid}_cd" onclick="classDetailExamResult('${loader}', '${cl_id}', '${cdid}')">
										<c:out value="${class_detail[2]}"/> - <c:out value="${class_detail[1]}"/>
									</div>
								</td>
								<td>&nbsp;</td>
							</c:forEach>
						</tr>
					</table>
				
				</td></tr></table>
			</td>
		</tr>
		<tr>
			<td>
				<div id="exam_studlist" style="padding-top: 4px">
				
				</div>
			</td>
		</tr>
	</table>
</body>
</html>