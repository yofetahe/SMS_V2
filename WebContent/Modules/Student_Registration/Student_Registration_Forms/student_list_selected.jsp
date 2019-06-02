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
	
	<div id="regSuccuss">
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" style="border-bottom-style: solid; border-bottom-width: thin; border-top-style: solid; border-top-width: thin; border-color: silver; background-color: #f5f5f5;">
				<div id="errMsg" style="color: red; width: auto; text-align: center;"></div>
				<table cellpadding="5">
					<tr><td>						
						<div class="form-group form-inline">
							<label for="status"> Please select the section </label>
							<form:select id="" path="studReg.clcdRelation.cd_id" class="form-control" onchange="sectionSelected( this.value )">
								<form:option value="0">Section List</form:option>
								<form:options itemLabel="sec_name" itemValue="sec_id" items="${section_list}"/>
							</form:select>
						</div>
						
						<div class="form-group form-inline">
							<label for="status"> Academic Year </label>
							<input type="text" id="acYear" value="${academic_year}" readonly="readonly" class="form-control"/>
						</div>
					</td></tr>
				</table>
				 
			</td>
		</tr>		
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
			
				<c:set var="rawcount" value="0"/>
				
				<div id="container">
					<table width="100%" id="selStud">
						<thead>
							<tr>
								<td align="center">No</td>
								<td>Student Name</td>
								<td></td>
							</tr>
						</thead>
						<c:forEach var="selStud_rslt" varStatus="stat" items="${selStud_rslt}">
							<tr>
								<td align="center">
									<c:out value="#stat.index + 1"/>
									<c:set var="inde" value="${stat.index}"/>
								</td>
								<td>
									<c:out value="selStud_rslt[#stat.index].selstud_name"/>									
								</td>
								<td align="center" style="color: #3d6e9f; cursor: pointer;">
									<div onclick="removeSelectedStud('${inde}', '${si_id}', '${selclid}')">
										Remove
									</div>
								</td>			
							</tr>
							<c:set var="rawcount" value="%{#rawcount + 1}"/>
						</c:forEach>
					</table>	
				</div>
				
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="background-color: #f5f5f5; cursor: pointer; color: #3d6e9f; height: 30px" align="center">
				<div onclick="registerStudent('${selclid}', '${rawcount}')">
					Register
				</div>
			</td>
		</tr>
	</table>
	
	</div>
</body>
</html>