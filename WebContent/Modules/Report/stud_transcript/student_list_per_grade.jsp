<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>
	
	<s:set var="class_id" value="class_id"/>
	<s:set var="cd_id" value="cd_id"/>
	
<!-- 	<div id="gradeList" style="padding-bottom: 10px; border-bottom-color: #f5f5f5; border-bottom-style: solid; border-bottom-width: thin;"> -->
<!-- 		<table width="100%" cellpadding="0" cellspacing="0"><tr> -->
<%-- 			<s:iterator status="stat" value="grdList_rslt"> --%>
<%-- 				<s:set var="cl_id" value="grdList_rslt[#stat.index].cl_id"/> --%>
<%-- 				<td align="center"> <input type="checkbox" onclick="selectClassForTrascript('${cl_id}')"> <s:property value="grdList_rslt[#stat.index].class_name"/> </td><td>&nbsp;</td> --%>
<%-- 			</s:iterator> --%>
<!-- 		</tr></table>		 -->
<!-- 	</div> -->
	
	<table cellpadding="0" cellspacing="0" width="100%"><tr><td width="30%" valign="top">
		
		<div id="student_list_pergrade" style="padding-top: 10px;">
					
			<table id="stud_list" width="100%" cellpadding="0" cellspacing="2">
				<thead>
					<tr style="background-color: #f5f5f5; font-size: 14px; height: 30px">
						<th width="10%">No</th>
						<th>Student Name</th>
					</tr>
				</thead>
				<s:iterator status="stat" value="stud_rslt">
					<tr height="35px">
						<td align="center">
							<s:property value="%{#stat.index + 1}"/>
							<s:set var="siid" value="si_id"/>
						</td>
						<td>
							<s:div style="color: #3d6e9f; cursor: pointer" onclick="getStudentTranscript('%{#siid}')">
								<s:property value="stud_rslt[#stat.index].fname"/>&nbsp;<s:property value="mname"/>&nbsp;<s:property value="gname"/>
							</s:div>									
						</td>												
					</tr>
				</s:iterator>
			</table>
		</div>
	
	</td><td width="20px">&nbsp;</td><td valign="top">
	
		<div id="transcriptContent" style="width: 100%;"> </div>
		
	</td></tr></table>
</body>
</html>