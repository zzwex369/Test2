<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>免费宫颈癌筛查反馈卡</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../../CreateControl.js" type="text/javascript"></script>
	<script src="../../GRInstall.js" type="text/javascript"></script>
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
		var Installed = Install_Detect();
		if ( Installed ){
	 		var l30101 = document.getElementById("l30101").value;
	 		var isL301 = document.getElementById("isL301").value;
	 		CreatePrintViewerEx("100%", "100%", "../../grf/msbb/gjady.grf", "../../data/msbb/xmlCustomer_gjady.jsp?l30101="+l30101+"&isL301="+isL301, true, "");
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="l30101" value="${param.l30101}"/>
	<input type="hidden" id="isL301" value="${param.isL301}"/>
</body>
</html>