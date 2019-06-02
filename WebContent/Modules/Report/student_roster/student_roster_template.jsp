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
	
	<div class="report_title">
		STUDENT ROSTER
	</div>

	<div class="headerTitleBottomBorder" style="background-color: #fff; height: 45px; padding-top: 6px; padding-left: 5px;">
		<table><tr>
			<td>
				
				<input type="text" value="${academic_year}" id="ac_year" class="form-control" readonly="readonly" style="width: 120px;"/>
				
			</td><td>&nbsp;</td>
			<td>
			
				<form:select id="at_id" path="annualTerms.at_id" cssClass="form-control" onchange="ckexamrslt_classRoomList(this.value, '${loader2}')">
					<form:option value="0">- Annual Term List -</form:option>
					<form:options itemLabel="at_name" itemValue="at_id" items="${term_list}"/>
				</form:select>
				
			</td><td>&nbsp;</td>
			<td>
				
				<div id="classList">
						
					<select id="cl_id" class="form-control">
						<option value="0">- Class List -</option>
					</select>
					
				</div>
				
			</td><td>&nbsp;</td>
			<td>
				
				<div id="grdList">
					
					<select id="cd_id" class="form-control">
						<option value="0">- Class Detail List -</option>
					</select>
						
				</div>
				
			</td><td>&nbsp;</td>
			<td>
			
				<div id="officeUse"> <img alt="check" src="images/check_box.png" onclick="filterStudentForOffice()" style="cursor: pointer;" width="16px"> </div>
			
			</td><td>&nbsp;</td>
			<td>
			
				<div onclick="generateStudentRoster()" class="adminHeaderButton" style="cursor: pointer; width: 100px;">GENERATE</div>
			
			</td><td>&nbsp;</td>
		</tr></table>	
	</div>
	<br/>
	<div id="studRoster">
	
	</div>

</body>
</html>