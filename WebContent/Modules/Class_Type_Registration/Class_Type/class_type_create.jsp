<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

</head>
<body>

	
	<div class="titleBottomBorder" style="margin-bottom: 10px;">
	
		<div style="cursor: pointer; color: #3d6e9f" onclick="backToClassList()"> Back to List </div>
		
	</div>
			
	<div class="panel panel-default" style="width: 50%">
		<div class="panel-heading">
			<h4 class="panel-title" style="color: #1c75bc;">
				Class Type Registration Form
			</h4>
		</div>
		<div class="panel-body" align="right" style="padding-right: 30px;">
					
			<div class="form-group form-inline">
				<label for="class_name"> class Name </label>					
				<input id="class_name" type="text" value="" class="form-control">
			</div>
						
			<button type="submit" class="btn btn-default" onclick="saveClass('${loader}')"> SAVE </button>
					
		</div>
	</div>
</body>
</html>