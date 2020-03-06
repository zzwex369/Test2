<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>出生医学证明</title>
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
					var d30110 = document.getElementById("d30110").value;
					var code = document.getElementById("code").value;
    				CreatePrintViewerEx("100%", "100%", "../grf/specialPrint/BIRTH_PRINTINFO_NEW_"+code+".grf", "../data/xmlCustomer.jsp?d30110="+d30110, true, "");
			}
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="d30110" value="${param.d30110}"/>
	<input type="hidden" id="code" value="${param.userCode}"/>
</body>
</html>