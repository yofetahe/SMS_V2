<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>

	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="padding-top: 1px">
				<div style="background-color: #f5f5f5; height: 35px; padding-top: 15px;">
					<s:div style="cursor: pointer; color: #3d6e9f;" onclick="paymentAdmin()"><img alt="click" src="images/next.gif" width="8px"> &nbsp;Back to Payment Info List</s:div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="padding-top: 10px">
				
					<s:fielderror fieldName="errMsg" name="errMsg" id="errMsg"/>
					<table>
						<tr>
							<td>
								<s:set var="pc_id" value="pc_id"/>
								<s:select label="Grade" id="cl_id" list="grade_rslt" key="class_id" listValue="class_name" listKey="class_id" style="height: 25px; width: 206px;"/>
								<s:select label="Payment Type" id="pt_id" list="payment_type_list" key="pt_id" listValue="pt_name" listKey="pt_id" style="height: 25px; width: 206px;"/>
								<s:textfield label="Payment Amount" id="pay_amount" key="pay_amount" style="height: 25px; width: 200px;"/>
								<s:textfield label="Days for Penalty" id="penality_max_date" key="penality_max_date" style="height: 25px; width: 200px;"/>
								<s:textfield label="Penalty Rate" id="penality_percent" key="penality_percent" style="height: 25px; width: 200px;"/>
								<s:textfield label="Academic Year" id="academic_year" key="academic_year" style="height: 25px; width: 200px;"/>
								<s:select label="Status" id="pc_status" list="#{'A':'Active', 'I':'Inactive'}" key="pc_status" style="height: 25px; width: 206px;"/>
								
								<s:submit onclick="updatePaymentInfo('%{#pc_id}')" value="Update"/>
							</td>
						</tr>
					</table>					
				
			</td>
		</tr>
	</table>

</body>
</html>