<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="/Modules/General/header_resource.jsp"/>
	
	<style type="text/css">
		#evaluation_content{
			background-color: rgba(255, 255, 255, 0.7);
		}
	</style>
	
</head>
<body id="sessionExpire" background="<c:url value='/Resources/images/new_bg_2.png'/>" style="margin: 0; background-repeat: repeat; ">

	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<div id="fullPageContent">
	
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="menu_shadow">
						<jsp:include page="../General/header.jsp"/>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" style="padding-top: 3px;">
				
					<!-- body part -->
					<div style="width: 98%; min-height: 450px">
									
						<table width="100%" height="450px" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td valign="top" style="padding-top: 0px">
								
									<div class="menu_shadow" style="height: 50px; padding: 10px; margin-bottom: 10px;">
										
										<table><tr>
											<td> 
											
												<jsp:include page="../General/header_menu_list.jsp"/>
												  
											</td>
											<td style="padding-left: 10px;"> <a href="/SMS/behaviouraleval/getBeheviouralEvaluationTemplate"><button id="studInformationBtn" type="submit" class="btn btn-default active"> Behavioral Evaluation Information </button></a> </td>
										</tr></table>
																				
									</div>
									
									<div id="evaluation_content">  
										
										<jsp:include page="beval_class_category_list.jsp"/>
													
									</div>
								</td>
							</tr>
							<tr><td colspan="2">&nbsp;</td></tr>
						</table>					
					</div>
					<!-- body part -->
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="../General/footer.jsp"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>