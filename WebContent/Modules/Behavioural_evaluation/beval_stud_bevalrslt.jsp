<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>
	
<c:set var="cl_id" value="cl_id"/>
<c:set var="si_id" value="si_id"/>
<c:set var="qr_id" value="qr_id"/>
<c:set var="ac_year" value="ac_year"/>
<c:set var="at_name" value="at_name"/>
<c:set var="fname" value="fname"/>
<c:set var="mname" value="mname"/>
<c:set var="gname" value="gname"/>

<div id="studRsltList">
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div style="border-bottom-color: silver; border-bottom-style: solid; border-bottom-width: thin; height: 40px; padding-top: 10px;">
					<table><tr><td>
					Student Name: <span style="color: #3d6e9f;"> <c:out value="${student_info.fname}"/> <c:out value="${student_info.mname}"/> <c:out value="${student_info.gname}"/> </span> &nbsp;&nbsp;&nbsp;&nbsp;
					Academic Year: <span style="color: #3d6e9f;"> <c:out value="${academic_year}"/></span>
					</td></tr></table>
				</div>
			</td>
		</tr>
		<tr>
			<td style="padding-top: 10px;">
			
				<table width="100%" cellpadding="0" cellspacing="0"><tr><td width="59%" valign="top">
				
				<table id="bevalRsl" width="100%" cellpadding="0" cellspacing="1">
					<thead style="background-color: #f5f5f5;">
						<tr>
							<td width="10%" style="height: 35px;" align="center">No</td>
							<td width="50%" align="center">Trait Name</td>
							<td width="20%" align="center">Result Given</td>
							<td width="20%" align="center">Status</td>
						</tr>
					</thead>
					<c:forEach varStatus="stat" var="stud_bevalrslt_list" items="${stud_evaluation_rslt}">
						<tr style="height: 40px;">
							<td align="center">
							
								<c:out value="${stat.index + 1}"/>
								<c:set var="bsr_id" value="${stud_bevalrslt_list[0]}"/>
								<c:set var="bsr_status" value="${stud_bevalrslt_list[8]}"/>
								<c:set var="bt_id" value="${stud_bevalrslt_list[1]}"/>
								<c:set var="bg_id" value="${stud_bevalrslt_list[3]}"/>
								
							</td>
							<td style="color: #3d6e9f;">
								<div style="cursor: pointer" onclick="bevalRsltEditForm('${bsr_id}', '${cl_id}', '${si_id}', '${qr_id}', '${bt_id}', '${bsr_status}', '${bg_id}')">
									<c:out value="${stud_bevalrslt_list[2]}"/> <!-- bt_title -->
								</div>
							</td>
							<td align="center">
								<c:out value="${stud_bevalrslt_list[4]}"/> <!-- bg_name -->							
							</td>
							<td align="center">
								<c:set var="bsr_status" value="${stud_bevalrslt_list[8]}"/>
								<c:choose>
									<c:when test="${bsr_status == \"A\"}">Active</c:when>
									<c:otherwise>Inactive</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</td></tr>			
			<tr><td valign="top" style="padding-right: 5px; padding-top: 20px;">				
											
					<div id="saveEditForm" class="formboarder">
					
						<div class="panel panel-default" style="width: 100%">
							<div class="panel-heading">
								<h1 class="panel-title" style="color: #1c75bc; font-size: 14px;">
									SAVE FORM
								</h1>
							</div>
							<div class="panel-body" align="left">
							
								<c:set var="counter" value="0"/>
								
								<c:forEach varStatus="stat" var="btrait_list" items="${btrait_list}">
									
									<c:set var="bt_id" value="${btrait_list[0]}"/>
									
									<div style="background-color: #f5f5f5; padding-left: 10px; min-height: 20px; padding-top: 5px; padding-bottom: 5px;"> 
										#&nbsp;<c:out value="${btrait_list[1]}"/> <!-- bt_title -->
									</div>
									
									<table width="70%"><tr>
										<c:forEach var="bgrade" items="${btrait_list[2]}">
											<td style="padding-left: 10px;">
											<input type="radio" name="${bt_id}" value="${bgrade.bg_id}" onchange="assignBevalResult(this.value, '${bt_id}', '${cl_id}', '${si_id}', '${qr_id}')"><c:out value="${bgrade.bg_name}"/>
											</td>
										</c:forEach>
									</tr></table>
									
									<c:set var="counter" value="${counter + 1}"/>
									
								</c:forEach>
								
								<div>
									<button type="submit" class="btn btn-default" onclick="saveBevalResultFromJSArray('${loader}', '${counter}', '${cl_id}', '${si_id}', '${qr_id}', '${fname}', '${mname}', '${gname}', '${at_name}', '${ac_year}')"> SAVE </button>
								</div>
								
							</div>
						</div>
						
					
					
<!-- 						<table align="center"><tr><td> -->
<!-- 							<div class="formtitle">  </div> -->
<!-- 							<div id="errMsg" style="color: #ff0000; width: auto; text-align: center;">&nbsp;</div> -->
<!-- 						</td></tr></table> -->
						
					</div>


				</td></tr></table>
			
			</td>
		</tr>
	</table>
</div>
</body>
</html>