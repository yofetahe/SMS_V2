<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

	<style type="text/css">
		#textRotate{
			width: 15px; 
			color: #3d6e9f; 
			-webkit-transform: rotate(-90deg); 	
			-moz-transform: rotate(-90deg); 
			-ms-transform: rotate(-90deg); 
			-o-transfrom: rotate(-90deg); 
			transform: rotate(-90deg);	
			filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083); 
			text-align: center; 
			height: 100px;
		}
	</style>
	
</head>
<body>
	
	<s:set var="at_id" value="at_id"/>
	<s:set var="cl_id" value="class_bean.cl_id"/>
	<s:set var="cd_id" value="cdetail_bean.cd_id"/>
	<s:set var="ac_year" value="stud_bean.ac_year"/>

	<s:div cssClass="save_update_btn" onclick="generateRoster('%{#at_id}', '%{#cl_id}', '%{#cd_id}', '%{#ac_year}')" style="height: 30px; width: 210px; padding-top: 1px; padding-left: 25px; cursor: pointer; text-align: center;">
		<table><tr><td>
			<img alt="PDF" src="images/pdf.gif" height="25px">
		</td><td valign="middle">
			Generate Roster
		</td></tr></table>
	</s:div>

	<table id="studroster" width="100%" cellpadding="0" cellspacing="1">
		<thead style="background-color: #f5f5f5; text-align: center;">
			<tr style="height: 30px; text-align: center;">
				<th width="5%">Rank</th>
				<th>Student Name</th>
				<th>Sex</th>
				<s:iterator status="stat" value="subject_list">
					<th style="width: 15px; color: #3d6e9f; -webkit-transform: rotate(-90deg); 	-moz-transform: rotate(-90deg); 
								-ms-transform: rotate(-90deg); -o-transfrom: rotate(-90deg); transform: rotate(-90deg);	
								filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083); text-align: center; height: 100px;">
	
						<s:property value="subject_list[#stat.index].sub_bean.sub_name"/>
						
					</th>
				</s:iterator>
				<th style="color: #3d6e9f; -webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg); 
								-ms-transform: rotate(-90deg); -o-transfrom: rotate(-90deg); transform: rotate(-90deg);	
								filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083); text-align: center;	height: 100px;"> 
						Total 
				</th>
				<th style="color: #3d6e9f; -webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg); 
								-ms-transform: rotate(-90deg); -o-transfrom: rotate(-90deg); transform: rotate(-90deg);	
								filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083); text-align: center;	height: 100px;"> 
						Average 
				</th>
			</tr>
		</thead>
		<s:iterator status="stat" value="quarter_stud_roster">
			<tr style="height: 30px;">
				<td align="center">
					<s:property value="quarter_stud_roster[#stat.index].ex_rslt_bean.stud_rank"/>
				</td>
				<td>
					<s:property value="quarter_stud_roster[#stat.index].stud_bean.fname"/> <s:property value="quarter_stud_roster[#stat.index].stud_bean.mname"/> <s:property value="quarter_stud_roster[#stat.index].stud_bean.gname"/>
				</td>
				<td align="center">
					<s:property value="quarter_stud_roster[#stat.index].stud_bean.sex"/> 
				</td>
				<s:iterator status="st" value="quarter_stud_roster[#stat.index].subject_total">
					<td align="center">
						<s:property value="quarter_stud_roster[#stat.index].subject_total[#st.index]"/>						
					</td>
				</s:iterator>
				<td align="center">
					<s:set var="total_mark" value="quarter_stud_roster[#stat.index].ex_rslt_bean.total_mark"/>
					<fmt:formatNumber maxIntegerDigits="3" pattern="##.#" value="${total_mark}"/>
				</td>
				<td align="center">
					<s:set var="qrt_avg" value="quarter_stud_roster[#stat.index].ex_rslt_bean.average_mark"/>
					<fmt:formatNumber maxIntegerDigits="3" pattern="##.#">${qrt_avg}</fmt:formatNumber>
				</td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>