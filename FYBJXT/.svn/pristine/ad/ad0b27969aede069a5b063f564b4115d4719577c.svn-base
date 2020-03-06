<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>转诊单打印</title>
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
		    var e50502 = document.getElementById("e50502").value;
		     CreateDisplayViewer("../../grf/etbj/tlzzd.grf", 
		     "../../data/etbj/xmlCustomer_tlzzd.jsp?e50502="+e50502);
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="e50502" value="${param.e50502}"/>
</body>
</html>