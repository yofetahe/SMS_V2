<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<script type="text/javascript">
		function examList(subcl_id){			
			document.getElementById('markList').innerHTML = "";
		}
	</script>
				
	<c:url value="/Resources/images/loader_2.gif" var="loader2"/>

	<select id="cl_id" class="form-control" onchange="ckexamrslt_examTypeList(this.value, '${loader2}')" style="width: 160px;">
		<option value="0">- Subject List -</option>
		<c:forEach var="sub_list" items="${subject_list}">
			<option value="${sub_list[0]}">${sub_list[1]}</option>
		</c:forEach>
	</select>