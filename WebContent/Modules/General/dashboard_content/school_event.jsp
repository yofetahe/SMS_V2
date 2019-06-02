<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>
<!-- Datatable -->
        <style type="text/css" title="currentStyle">
            @import "datatable/datatable_2/media/css/demo_page.css";
            @import "datatable/datatable_2/media/css/demo_table.css";
            @import "media/css/TableTools.css";
        </style>
        <script type="text/javascript" charset="utf-8" src="datatable/datatable_2/media/js/jquery.js"></script>
        <script type="text/javascript" charset="utf-8" src="datatable/datatable_2/media/js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf-8" src="media/js/ZeroClipboard.js"></script>
        <script type="text/javascript" charset="utf-8" src="media/js/TableTools.js"></script>
        <script type="text/javascript" charset="utf-8">
            $(document).ready( function () {
                $('#schoolEventList').dataTable( {
                    "": 'T<"clear">lfrtip'
                } );
            } );
        </script>
<!-- Datatable -->
</head>
<body>

	<table id="schoolEventList" cellpadding="0" cellspacing="1" width="100%" style="padding-top: 30px">
		<thead style="background-color: #3d6e9f; color: #fff; height: 30px; text-align: center;">
			<tr>
				<td width="5%">No</td>
				<td width="15%">School Event</td>
				<td width="30%">Description</td>
				<td width="15%">Date <br/>(Ethiopian Calendar)</td>
				<td width="15%">Date <br/>(Gregorian Calendar)</td>
			</tr>
		</thead>
		<s:iterator status="stat" value="seblist">
			<tr style="height: 30px">
				<td align="center">
					<s:property value="%{#stat.index + 1}"/>
				</td>
				<td>
					<s:property value="seblist[#stat.index].se_name"/>
				</td>
				<td>
					<s:property value="seblist[#stat.index].se_description"/>
				</td>
				<td>
					<s:property value="seblist[#stat.index].se_ethio_date"/>
				</td>
				<td>
					<s:property value="seblist[#stat.index].se_greg_date"/>
				</td>
			</tr>
		</s:iterator>
	</table>
	<div style="height: 30px;">&nbsp;</div>
</body>
</html>