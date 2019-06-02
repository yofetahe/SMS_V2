<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<script src="js/sms_teacher_registration.js" type="text/javascript"></script>

</head>
<body>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="background-color: #f5f5f5; height: 50px">
				<div style="cursor: pointer; color: #3d6e9f"><img src="images/next.gif" width="8px"/> Back to DisAct List</div>
			</td>
		</tr>
		<tr>
			<td id="reward_saveform">
				<div id="errMsg" style="color: red; text-align: center; width: 40%"></div>
			</td>
		</tr>
		<tr>
			<td style="padding-top: 10px">
				
				<div style="width: 500px">
					<table align="left">
						<tr><td>
							<table><s:set var="tda_id" value="tda_id"/></table>
							<table style="padding-left: 18px;"><s:textfield id="tda_type" label="Disciplinary Action Type" required="true" key="tda_type" style="height: 25px; width: 200px"/></table>
							<table><s:textfield id="tda_reason" label="Disciplinary Action Reason" required="true" key="tda_reason" style="height: 25px; width: 200px"/></table>							
							<table><tr><td style="font-style: italic; width: 192px; text-align: right;">Disciplinary Action Date<span style="color:red">*</span>: </td>
								<td><sj:datepicker id="tda_date" name="tda_date"
										displayFormat="yy-mm-dd" readonly="true" 
										maxDate="today" changeMonth="true" 
										changeYear="true" style="height: 25px; width: 200px"></sj:datepicker></td></tr></table>
							<table style="padding-left: 148px;">
							<s:select id="tda_status" label="Status" headerValue="Select status" headerKey="0" list="#{'A':'Active', 'I':'Inactive'}" key="tda_status" style="height: 30px; width: 206px"/>
							</table>
							
							<table style="padding-left: 194px;">
							<s:submit onclick="updateDisAct('%{#ti_id}', '%{#tda_id}')" align="right" value="Update"/>
							</table>					
						</td></tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	
</body>
</html>