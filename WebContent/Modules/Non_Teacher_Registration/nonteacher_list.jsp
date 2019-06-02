<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="/Modules/General/header_resource.jsp"/>

</head>
<body>
	
	<c:url value="/Resources/images/loader.gif" var="loader"/>
	
	<c:url value="/Resources/js/jquery-1.12.3.js" var="JqJS1123"/>
	<script type="text/javascript" src="${JqJS1123}"></script>
	
	<div class="content_background"  style="min-height: 434px">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="60%" valign="top">
					
					<table id="nonteach_list" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="5%">No</th>
								<th width="35%">Name</th>
								<th width="25%">Position</th>
								<th width="10%">Sex</th>
								<th width="15%">ID No</th>
								<th width="10%">Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="nontchr_list" varStatus="stat" items="${nontchr_list}">
								<tr height="30px">
									<td align="center">
										<c:out value="${stat.index + 1}"/>
									</td>
									<td style="color: #3d6e9f">
										<div onclick="getNonTeacherInfoUpdateForm('${loader}', '${nontchr_list.nti_id}')" style="cursor: pointer">
											<c:out value="${nontchr_list.nti_fname}"/> <c:out value="${nontchr_list.nti_mname}"/> <c:out value="${nontchr_list.nti_gname}"/>
										</div> 
									</td>
									<td>
										<c:out value="${nontchr_list.nti_position}"/> 
									</td>
									<td>
										<c:set var="sex" value="${nontchr_list.nti_sex}"/>
										<c:if test="${sex == \"M\"}">Male</c:if>
										<c:if test="${sex == \"F\"}">Female</c:if>
									</td>
									<td>
										<c:out value="${nontchr_list.nti_id_no}"/> 
									</td>
									<td>
										<c:set var="status" value="${nontchr_list.nti_status}"/>
										<c:if test="${status == \"A\"}">Active</c:if>
										<c:if test="${status == \"I\"}">Inactive</c:if> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</td>
				<td width="1%"></td>
				<td width="39%" valign="top" align="center">
				
					<div id="saveUpdateForm">
						
						<div style="padding-left: 10px;">
							
							<div class="panel panel-default" style="width: 80%">
								<div class="panel-heading">
									<h4 class="panel-title" style="color: #1c75bc;">
										Non-Teacher's Profile Registration Form
									</h4>
								</div>
								<div class="panel-body" align="right">
								
									<div class="form-group form-inline">
										<label for="fname"> First Name </label>					
										<input id="fname" type="text" class="form-control">
									</div>
												
									<div class="form-group form-inline">
										<label for="mname"> Middle Name </label>
										<input id="mname" type="text" class="form-control"> 	
									</div>
												
									<div class="form-group form-inline">
										<label for="gname"> Grand Father Name </label>
										<input id="gname" type="text" class="form-control">
									</div>
												
									<div class="form-group form-inline">
										<label for="sex"> Sex </label>
										<select class="form-control" style="width: 196px;">
											<option value="-">-</option>
											<option value="M">Male</option>
											<option value="F">Female</option>
										</select>
									</div>
												
									<div class="form-group form-inline">
										<label for="email"> Email </label>
										<input id="email" type="text" class="form-control">
									</div>
												
									<div class="form-group form-inline">
										<label for="pos"> Position </label>
										<input id="pos" type="text" class="form-control">
									</div>
									
									<button type="submit" class="btn btn-default" onclick="saveNonTeacher('${loader}')"> SAVE </button>
											
								</div>
							</div>
							
						</div>
					</div>
				</td>
			</tr>
		</table>
					
	</div>
						
	<jsp:include page="/Modules/General/footer_resource.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#nonteach_list').DataTable({
		    	buttons: ['pdf']
		    });
		});
	</script>	

</body>
</html>