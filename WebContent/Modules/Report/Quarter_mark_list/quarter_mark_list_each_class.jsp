<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
	<style type="text/css">
	.report_title{
		font-weight: bold;
		padding-bottom: 5px;
		padding-top: 5px;
	}
	</style>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

	<div id="markList">
	
		<c:set var="at_id" value="at_id"/>
		<c:set var="cl_id" value="class_bean.cl_id"/>
		<c:set var="cd_id" value="cdetail_bean.cd_id"/>
		<c:set var="sub_id" value="sub_bean.sub_id"/>
		<c:set var="ac_year" value="stud_bean.ac_year"/>
	
		<div class="save_update_btn" onclick="generateStudentMarkList('${at_id}', '${cl_id}', '${cd_id}', '${sub_id}', '${ac_year}')" style="height: 30px; width: 210px; padding-top: 1px; padding-left: 25px; cursor: pointer; text-align: center;">
			<table><tr><td>
				<img alt="PDF" src="images/pdf.gif" height="25px">
			</td><td valign="middle">
				Generate Mark List
			</td></tr></table>
		</div>
	
		<table id="studMarkList" width="100%" cellpadding="0" cellspacing="1">
			<thead style="background-color: #f5f5f5; text-align: center;">
				<tr style="height: 30px;">
					<th>No</th>
					<th>Student Name</th>
					<th>Sex</th>
					<th>Exam 1</th>
					<th>Exam 2</th>
					<th>Work Sheet</th>
					<th>Activity</th>
					<th>Total</th>
					<th>Final</th>
					<th>Total</th>
				</tr>
			</thead>
			<c:forEach var="quarter_mark_list" varStatus="stat" items="${quarter_mark_list}">
				<tr style="height: 30px">
					<td align="center"> <c:out value="${stat.index + 1}"/> </td>
					<td> <c:out value="quarter_mark_list[#stat.index].stud_bean.fname"/> <c:out value="quarter_mark_list[#stat.index].stud_bean.mname"/> <c:out value="quarter_mark_list[#stat.index].stud_bean.gname"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].stud_bean.sex"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].exam_one"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].exam_two"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].worksheet"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].activity"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].sub_total"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].finalExam"/> </td>
					<td align="center"> <c:out value="quarter_mark_list[#stat.index].grand_total"/> </td>
				</tr>
			</c:forEach>
		</table>
		<div style="height: 20px;">&nbsp;</div>
	</div>

</body>
</html>