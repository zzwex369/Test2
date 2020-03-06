<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>听力筛查汇总表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../CreateControl.js" type="text/javascript"></script>
	<script src="../GRInstall.js" type="text/javascript"></script>
	<script type="text/javascript">
		Install_InsertReport();
	</script>
    <style type="text/css">
        html,body {
            margin:0;
            height:100%;
        }
    </style>
    <script type="text/javascript">
    function window_onload() {
		if (_gr_platform.indexOf("64") > 0)
		    alert("报表插件不能运行在64位浏览器中，相关报表与打印功能将无法正常运新，请改用32位浏览器！");
    	else{
			var Installed = Install_Detect();
			if ( Installed )
			{	 
		    	var date_satrt = document.getElementById("date_satrt").value;
		    	var date_end = document.getElementById("date_end").value;
		    	var institution = document.getElementById("institution").value;
		    	var hospital=document.getElementById("hospital").value;
		    	var chargetype=document.getElementById("chargetype").value;
		    	var sczt=document.getElementById("sczt").value;
		    	var scjg=document.getElementById("scjg").value;
		    	var date_status=document.getElementById("date_status").value;
		    	CreateDisplayViewerEx("100%", "100%", "../grf/tlhz.grf", "../data/xmlCustomer_22.jsp?institution="+institution+"&date_satrt="+date_satrt+"&date_end="+date_end+"&hospital="+hospital+"&chargetype="+chargetype+"&date_status="+date_status+"&sczt="+sczt+"&scjg="+scjg, true, "");
		    
			}	
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="hospital" value="${param.hospital}"/>
	<input type="hidden" id="date_satrt" value="${param.date_satrt}"/>
	<input type="hidden" id="date_end" value="${param.date_end}"/>
	<input type="hidden" id="institution" value="${param.institution}"/>
	<input type="hidden" id="chargetype" value="${param.chargetype}"/>
	<input type="hidden" id="sczt" value="${param.sczt}"/>
	<input type="hidden" id="scjg" value="${param.scjg}"/>
	<input type="hidden" id="date_status" value="${param.date_status}"/>
</body>
</html>
