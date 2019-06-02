<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:set var="cd_id" value="cd_id"/>

	<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td style="padding-top: 10px">
									
				<div class="content_background">
					
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top" width="15%">
								
								
								<div align="left" style="width: 100%;">
								
									<div id="photo_display" style="width: 100%;" align="center">
										
										<img alt="<c:out value="${stud_info.fname}"/> photo" src="getStudentPhoto?si_id=${studReg.si_id}" width="154px" />
																
										<div onclick="upload_photo('${studReg.si_id}', '${studReg.clcdRelation.cl_id}')" style="width: auto; text-align: center; background-color: #3d6e9f; width: auto; color: #fff; cursor: pointer; min-height: 30px;">
											<c:out value="${stud_info.fname}"/> <c:out value="${stud_info.mname}"/> <c:out value="${stud_info.gname}"/>
										</div>
										
									</div>
									
								</div>
								
								<div align="left" style="width: 100%; padding-top: 20px;">
									<jsp:include page="student_detail_information_menu.jsp"/>
								</div>
																
							</td>
							<td width="2%">
								&nbsp;
							</td>
							<td valign="top">
							
								<div id="student_additionalinfo">
									<jsp:include page="Student_Profile/student_profile_template.jsp"/>
								</div>
								
							</td>
						</tr>
					</table>
				
				</div>
			</td>
		</tr>
	</table>
</body>
</html>