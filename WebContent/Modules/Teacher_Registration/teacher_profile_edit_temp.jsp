<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div class="content_background">
					<table cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td width="28%" valign="top">
								
								<div id="teachFroms">
									<jsp:include page="teacher_profile_edit_form.jsp"/>
								</div>
								
							</td>
							<td width="2%">
								&nbsp;
							</td>
							<td valign="top">
							
								<jsp:include page="teacher_profile_detail_temp.jsp"/>
								
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>