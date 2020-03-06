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
	 		var l30201 = document.getElementById("l30201").value;
	 		var status = document.getElementById("status").value;
	 		var suffix=status=='1'?"fkk":"zzk";
	 		CreateDisplayViewer("../../grf/msbb/gja"+suffix+".grf", "../../data/msbb/xmlCustomer_gja.jsp?l30201="+l30201);
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="l30201" value="${param.l30201}"/>
	<input type="hidden" id="status" value="${param.status}"/>
</body>
</html>