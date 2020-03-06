<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>儿童档案登记本</title>
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
		    	var date_start = document.getElementById("date_start").value;
		    	var date_end = document.getElementById("date_end").value;
		    	var institution = document.getElementById("institution").value;
		    	var date_status = document.getElementById("date_status").value;
		    	var address_status = document.getElementById("address_status").value;
		    	var address_code = document.getElementById("address_code").value;
		    	CreateDisplayViewerEx("100%", "100%", "../grf/record_11.grf", "../data/xmlCustomer_11.jsp?address_code="+address_code+"&address_status="+address_status+"&date_status="+date_status+"&date_start="+date_start+"&date_end="+date_end+"&institution="+institution, true, "");
		    }	
		}
	}
	</script>
</head>
<body onload="window_onload()">

	<input type="hidden" id="date_start" value="${param.date_start}"/>
	<input type="hidden" id="date_end" value="${param.date_end}"/>
	<input type="hidden" id="institution" value="${param.institution}"/>
	<input type="hidden" id="date_status" value="${param.date_status}"/>
	<input type="hidden" id="address_status" value="${param.address_status}"/>
	<input type="hidden" id="address_code" value="${param.address_code}"/>
</body>
</html>