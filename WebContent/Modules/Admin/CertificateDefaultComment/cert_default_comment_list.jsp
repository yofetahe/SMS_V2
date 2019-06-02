<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>

	<div id="defCom">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="65%" valign="top">
				
					<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
					<script type="text/javascript" src="${JqJS1123}"></script>
			
					<table id="defaultCommentTbl" class="table table-striped table-bordered">
						<thead>
							<tr>
								<td width="7%">No</td>
								<td>Comment Content</td>
								<td width="15%">Rank From</td>
								<td width="15%">Rank To</td>
								<td width="10%">Status</td>
								<td width="10%">&nbsp;</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="stat" var="defCommentList" items="${defaultCommentList}">
								<tr>
									<td align="center">
										<c:out value="${stat.index + 1}"/>
									</td>
									<td>
										<c:out value="${defCommentList.edc_content}"/>
									</td>			
									<td align="center">
										<c:out value="${defCommentList.rank_from}"/>
									</td>
									<td align="center">
										<c:out value="${defCommentList.rank_to}"/>
									</td>
									<td align="center">
										<c:set var="edc_status" value="${defCommentList.edc_status}"/>
										<c:choose>
											<c:when test="${edc_status == \"A\"}">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose>
									</td>
									<td style="color: #3d6e9f;" align="center">
										<div onclick="editDefaultComment('${loader}', '${defCommentList.edc_id}')" style="cursor: pointer">
											Edit
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</td>
				<td>&nbsp;</td>
				<td width="33%" valign="top" style="padding-right: 5px;" align="center">
				
					<div class="panel panel-default" style="width: 90%">
						<div class="panel-heading">
							<h4 class="panel-title" style="color: #1c75bc;">
								Default Comment Registration Form
							</h4>
						</div>
						<div class="panel-body" align="right" style="padding-right: 30px;">
									
							<div class="form-group form-inline">
								<label for="edc_com"> Comment </label>					
								<textarea id="edc_com" rows="5" cols="22" class="form-control"></textarea>
							</div>
							
							<div class="form-group form-inline">
								<label for="rank_from"> Rank From </label>					
								<input id="rank_from" type="text" value="" class="form-control">
							</div>
							
							<div class="form-group form-inline">
								<label for="rank_to"> Rank To </label>					
								<input id="rank_to" type="text" value="" class="form-control">
							</div>
										
							<button type="submit" class="btn btn-default" onclick="saveDefaultComment('${loader}')"> SAVE </button>
									
						</div>
					</div>
						
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#defaultCommentTbl').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>

</body>
</html>