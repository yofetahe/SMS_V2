<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS</title>

<link rel="stylesheet" type="text/css" href="css/sms_css.css">

<c:url value="/Resources/js/jquery-1.6.1.js" var="JqJS"/>
	<script type="text/javascript" src="${JqJS}"></script>
<c:url value="/Resources/bootstrap/js/bootstrap.min.js" var="BsJS"/>
	<script type="text/javascript" src="${BsJS}"></script>
<c:url value="/Resources/js/highcharts.js" var="HighChartJS"/>
	<script type="text/javascript" src="${HighChartJS}"></script>

<style type="text/css">
	#dbButton{
		cursor: pointer;
		height: 50px; 
		width: auto; 
		text-align: center; 
		font-size: 20px; 
		padding-top: 25px; 
		color: #3d6e9f;
		border-color: #e5e5e5;
		border-style: solid;
		border-width: thin;
	}
	
	#dbActiveButton{
		cursor: pointer;
		height: 50px; 
		width: auto; 
		text-align: center; 
		font-size: 20px; 
		padding-top: 25px; 
		color: #3d6e9f;
		border-color: #e5e5e5;
		border-style: solid;
		border-width: thin;
		border-bottom-color: #3d6e9f;
	}
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	$(function () { 

			var cur_eth_year = ['<c:out value="${academic_year}"/>']
		
			var c_list = [	<c:forEach var="studNum" items="${db_stud_persex}" varStatus="stat">
							<c:if test="${stat.index > 0}">,</c:if>
							'<c:out value="${studNum[0]}"/>'                 
							</c:forEach> ]
		
			var m_list = [	<c:forEach var="studNum" items="${db_stud_persex}" varStatus="stat">
							<c:if test="${stat.index > 0}">,</c:if>
							'<c:out value="${studNum[1]}"/>'                 
							</c:forEach> ]
		
			var f_list = [	<c:forEach var="studNum" items="${db_stud_persex}" varStatus="stat">
							<c:if test="${stat.index > 0}">,</c:if>
							'<c:out value="${studNum[2]}"/>'                 
							</c:forEach> ]
			
			var clist = c_list + "";
			var cat_list = clist.split(",");	
		
			var mlist = m_list + "";
			var male_list = mlist.split(",").map(Number);
		
			var flist = f_list + "";
			var female_list= flist.split(",").map(Number);
			
			var total_male = 0;
			for(a in male_list){
				total_male = parseInt(total_male) + parseInt(male_list[a]);
			}
			
			var total_female = 0;
			for(a in female_list){
				total_female = parseInt(total_female) + parseInt(female_list[a]);
			}
		
			var total_num_student = parseInt(total_male) + parseInt(total_female);
			
		$('#db_content').highcharts({
		    chart: {
		        type: 'line'
		    },
		    title: {
		        text: cur_eth_year + ' E.C - Number of Students per Grade (Total Number of Students are ' + total_num_student + ')'
		    },
		    xAxis: {
		        categories: cat_list
		    },
		    yAxis: {
		        title: {
		            text: 'Students Number'
		        }
		    },
		    series: [{
		        name: 'Male',
		        data: male_list
		    }, {
		        name: 'Female',
		        data: female_list
		    }]
		});
	});
});

	function totalNoOfStudentsPerGrade(){
		
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_noofstudpergrd.action",				
			data : "",
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_activebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "block";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function totalNoOfStudents(){
		
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_noofstud.action",				
			data : "",
			success : function(response) {
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_activebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "block";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function totalNoOfTeachers(){
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_noofteacher.action",				
			data : "",
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_activebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "block";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});		
	}
	
	function teacherScheduleInfo(ti_id){
		
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_teacherschedule.action",				
			data : "ti_id=" + ti_id,
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_activebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "block";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function schoolEvent(){
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_schoolevent.action",				
			data : "",
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_activebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "block";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function holidayList(){
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_holidaylist.action",				
			data : "",
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_activebtn";
				document.getElementById("exmSch").className = "dashboard_inactivebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "block";
				document.getElementById("examSchedule").style.display = "none";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function examSchedule(){
		$("#db_content").html("<img align=\"center\" src=\"images/loader.gif\"/>");		
		$.ajax({
			type : "POST",
			url : "dbcontent_examschedule.action",				
			data : "",
			success : function(response) {
				
				$('#db_content').html(response);
				
				document.getElementById("stdpergrd").className = "dashboard_inactivebtn";
				document.getElementById("studno").className = "dashboard_inactivebtn";
				document.getElementById("tchrno").className = "dashboard_inactivebtn";
				document.getElementById("tchSchedule").className = "dashboard_inactivebtn";
				document.getElementById("schEvent").className = "dashboard_inactivebtn";
				document.getElementById("hldList").className = "dashboard_inactivebtn";
				document.getElementById("exmSch").className = "dashboard_activebtn";
				
				document.getElementById("studpergrd").style.display = "none";
				document.getElementById("noofstud").style.display = "none";
				document.getElementById("noofteacher").style.display = "none";
				document.getElementById("teacherschedule").style.display = "none";
				document.getElementById("schoolEvent").style.display = "none";
				document.getElementById("holidayList").style.display = "none";
				document.getElementById("examSchedule").style.display = "block";
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<body>

	<c:set var="dbStatus" value="dashboardStatus"/>
	
	<c:set var="ti_id" value="ti_id"/>
	
	<div style="padding-top: 10px;">
	
		<table width="100%" style="padding-top: 15px; padding-left: 20px" cellpadding="0" cellspacing="0" border="0">		
			<tr>		
				<td width="14%">
					<div class="dashboard_activebtn" id="stdpergrd" onclick="totalNoOfStudentsPerGrade()">
						Students per Grade
					</div>
				</td>
				<td>&nbsp;</td>
				<td width="14%">
					<div class="dashboard_inactivebtn" id="studno" onclick="totalNoOfStudents()">
						Students per Year				
					</div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%">
					<div class="dashboard_inactivebtn" id="tchrno" onclick="totalNoOfTeachers()">
						No. of Teachers
					</div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%">
					<div class="dashboard_inactivebtn" id="schEvent" onclick="schoolEvent()">
						School Events
					</div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%">
					<div class="dashboard_inactivebtn" id="hldList" onclick="holidayList()">
						Holiday's
					</div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%">
					<div class="dashboard_inactivebtn" id="exmSch" onclick="examSchedule()">
						Exam Schedule
					</div>
				</td>				
				<td>&nbsp;</td>
				<td width="14%">					
					<c:choose>
						<c:when test="${dbStatus == \"teacher\"}">
							<div class="dashboard_inactivebtn" id="tchSchedule" onclick="teacherScheduleInfo('${ti_id}')">
								Teachers Schedule
							</div>
						</c:when>
						<c:otherwise>
<!-- 							<div class="dashboard_inactivebtn" id="tchSchedule"> -->
<!-- 								&nbsp; -->
<!-- 							</div> -->
						</c:otherwise>
					</c:choose>
				</td>				
			</tr>
			<tr>
				<td width="14%" valign="top" align="center">
					<c:url value="/Resources/images/down.png" var="downIcon"/>
					<div id="studpergrd" style="display: block"><img alt="" src="${downIcon}" width="40px"></div>
				</td>		
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<div id="noofstud" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
				</td>		
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<div id="noofteacher" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<div id="schoolEvent" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<div id="holidayList" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
				</td>
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<div id="examSchedule" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
				</td>				
				<td>&nbsp;</td>		
				<td width="14%" valign="top" align="center">
					<c:choose>
						<c:when test="${dbStatus == \"teacher\"}">
							<div id="teacherschedule" style="display: none"><img alt="" src="${downIcon}" width="40px"></div>
						</c:when>
						<c:otherwise>
							<div style="display: none;" id="teacherschedule" style="display: none"><img alt="" src="${downIcon}" width="50px"></div>
						</c:otherwise>
					</c:choose>
				</td>				
			</tr>
			<tr>
				<td colspan="13">
					<div class="content_background" style="width: auto; padding-left: 8px; padding-right: 8px; min-height: 444px; padding-top: 35px;">
						
						<div id="db_content" style="width: 100%; height: 100%;">
							
						</div>
						
					</div>
				</td>
			</tr>
		</table>
		
	</div>
	
<!-- 	<script type="text/javascript"> -->
<!-- // 	$(function () { -->
<!-- // 		$("tspan:contains('Highcharts.com')").hide(); -->
<!-- // 	}); -->
<!-- 	</script> -->

</body>
</html>