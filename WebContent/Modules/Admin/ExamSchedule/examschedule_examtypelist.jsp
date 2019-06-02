<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <s:select list="examList" id="et_id" headerValue="----" headerKey="0" listKey="et_id" listValue="et_name" style="width: 206px; height: 30px;"/> --%>

<div id="errMsg" style="color: RED"></div>
<s:iterator status="stat" value="examList">
	<div style="padding-bottom: 10px; border-bottom: thin; border-bottom-color: gray; border-bottom-style: solid; border-bottom-width: thin;">
		<s:set var="et_name" value="examList[#stat.index].et_name"/>
		<s:set var="et_id" value="examList[#stat.index].et_id"/>
		<div>
			<table><tr><td>
				<table>
				<s:textfield label="Time From" id="from_hour_%{#stat.index+1}" style="width: 15px; height: 20px;"/>
				</table>
			</td><td>
				<table>
				<s:textfield label="" id="from_min_%{#stat.index+1}" style="width: 25px; height: 20px;"/>
				</table>
			</td><td>
				<table>
				<s:textfield label="Time To" id="to_hour_%{#stat.index+1}" style="width: 15px; height: 20px;"/>
				</table>
			</td><td>
				<table>
				<s:textfield label="" id="to_min_%{#stat.index+1}" style="width: 25px; height: 20px;"/>
				</table>
			</td><td valign="top" style="padding-top: 3px; font-style: italic;">Date:</td><td>
				<div> 
					<table cellpadding="0" cellspacing="0" ><tr><td>
					<sj:datepicker id="exdate_%{#stat.index+1}" displayFormat="dd-MM-yy" readonly="true" minDate="today" changeMonth="true" changeYear="true" style="width: 100px; height: 20px;"></sj:datepicker>
					</td></tr></table> 
				</div>
			</td></tr></table>
		</div>
	<!-- 	<div>  -->
	<!-- 		<table cellpadding="0" cellspacing="0" ><tr><td> -->
	<%-- 		<sj:datepicker id="exdate_%{#stat.index+1}" displayFormat="dd-MM-yy" readonly="true" minDate="today" changeMonth="true" changeYear="true" style="width: 200px"></sj:datepicker> --%>
	<!-- 		</td></tr></table>  -->
	<!-- 	</div> -->
		<s:div id="extype_%{#stat.index+1}">
			<s:div style="cursor: pointer;" onclick="selectExamType('%{#stat.index+1}', '%{#et_name}', '%{#et_id}')"> 
				<table cellpadding="0" cellspacing="0" ><tr><td style="vertical-align: middle;">
				<img alt="check" src="images/check_box.png" width="17px;"> </td><td> <s:property value="examList[#stat.index].et_name"/> 
				</td></tr></table> 
			</s:div>
		</s:div>
	</div>
	
</s:iterator>
