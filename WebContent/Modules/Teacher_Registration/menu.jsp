<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>
<link rel="stylesheet" type="text/css" href="css/sms_css.css">

</head>
<body>

	<c:set var="ti_id" value="${teacherInfo.ti_id}"/>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
				<div id="photo_display">
										
					<img alt="<c:out value="${teacher_info.fname}"/> photo" src="getTeacherPhoto?ti_id=${teacher_info.ti_id}" width="154px" />
																
					<div onclick="upload_photo('${teacherInfo.ti_id}')" style="width: auto; text-align: center; background-color: #3d6e9f; width: auto; color: #fff; cursor: pointer; min-height: 30px;">
						<c:out value="${teacher_info.fname}"/> <c:out value="${teacher_info.mname}"/> <c:out value="${teacher_info.gname}"/>
					</div>
										
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 25px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="personal_info('%{#tiid}')" id="pi" class="menu_button" style="background-color: #f5f5f5">
					Personal Information
				</div>
			</td>
		</tr>		
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="education_background('%{#tiid}')" id="eb" class="menu_button">
					Edu. Background
				</div>
			</td>
		</tr>		
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="work_experience('%{#tiid}')" id="we" class="menu_button">
					Work Experience
				</div>
			</td>
		</tr>		
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>		
		<tr height="25px">
			<td align="left">
				<div onclick="current_address('%{#tiid}')" id="ca" class="menu_button">
					Current Address
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="emergency_contact('%{#tiid}')" id="ec" class="menu_button">
					Emergency Contact
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="reward('%{#tiid}')" id="r" class="menu_button">
					Reward
				</div>
			</td>
		</tr>
		<tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="disciplinary_action('%{#tiid}')" id="da" class="menu_button">
					Disciplinary action
				</div>
			</td>
		</tr><tr>
			<td style="line-height: 5px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td align="left">
				<div onclick="assign_to_subject('%{#tiid}')" id="at" class="menu_button">
					Class/Subject History
				</div>
			</td>
		</tr>
	</table>

</body>
</html>