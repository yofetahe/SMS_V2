<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

<s:set var="clname" value=""/>
<s:set var="cd_name" value="top_five_stud_per_class[0].ex_rslt_bean.cd_name"/>

<table id="topRankStud" cellpadding="0" cellspacing="1" width="100%">
	<thead style="background-color: #f5f5f5; text-align: center;">
		<tr style="height: 30px;">
			<th> Grade </th>
			<th> Rank </th>
			<th> Student Name </th>
			<th> Quarter Total Mark </th>
			<th> Quarter Average </th>
		</tr>
	</thead>
	<s:iterator status="st" value="grade_rslt">
		<s:set var="class_name" value="grade_rslt[#st.index].class_name"/>
		<s:set var="pre_cd_name" value="%{#cd_name}"/>
		<s:iterator status="stat" value="top_five_stud_per_class">			
			
			<s:set var="cd_name" value="top_five_stud_per_class[#stat.index].ex_rslt_bean.cd_name"/>
			
			<s:set var="cl_name" value="top_five_stud_per_class[#stat.index].ex_rslt_bean.cl_name"/>						
			
			<s:if test="%{#cl_name == #class_name}">
				<s:if test="%{#cd_name != #pre_cd_name}">
					<s:set var="pre_cd_name" value="%{#cd_name}"/>
				</s:if>				
				<tr>
					<td height="30px;">
						<s:property value="grade_rslt[#st.index].class_name"/> <s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.cd_name"/>
					</td>
					<td align="center">
						<s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.stud_rank"/>
					</td>
					<td>
						<s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.fname"/> <s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.mname"/> <s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.gname"/>
					</td>					
					<td style="padding-left: 20px;">
						<s:property value="top_five_stud_per_class[#stat.index].ex_rslt_bean.total_mark"/>
					</td>
					<td style="padding-left: 20px;">
						<s:set var="stud_avg" value="top_five_stud_per_class[#stat.index].ex_rslt_bean.average_mark"/>
						<fmt:formatNumber maxIntegerDigits="3" pattern="##.#">${stud_avg}</fmt:formatNumber>
					</td>
				</tr>		
			</s:if>
			
		</s:iterator>
	</s:iterator>
</table>

<div style="height: 15px;">&nbsp;</div>

</body>
</html>