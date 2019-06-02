<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TMS</title>

<c:url value="/Resources/bootstrap/css/bootstrap.min.css" var="bcssURL"/>
<c:url value="/Resources/css/sys_css.css" var="cssURL"/>
<link href="${bcssURL}"  rel="stylesheet" type="text/css">
<link href="${cssURL}"  rel="stylesheet" type="text/css">

</head>
<body style="margin: 0; padding-top: 150px;">
<div style="width: 100%;" align="center">
	<div class="alert alert-info" style="width: 400px; height: 200px; padding-top: 30px; font-size: 20px; text-align: center;">
		<c:url value="/Resources/images/msg_information.jpeg" var="info"/>
		<img alt="warning" src="${info}" width="60px;"> <br/><br/>
		&#4845;&#4613;&#4757;&#4757; &#4872;&#4933; &#4616;&#4632;&#4896;&#4672;&#4637; &#4768;&#4621;&#4720;&#4936;&#4672;&#4848;&#4622;&#4725;&#4637;:: <br/> &#4773;&#4707;&#4782;&#4757; &#4840;&#4658;&#4661;&#4720;&#4633;&#4757; &#4768;&#4661;&#4720;&#4851;&#4848;&#4653; &#4845;&#4896;&#4845;&#4673;:: 
	</div>
</div>
</body>
</html>