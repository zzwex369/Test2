<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>血清随访报告单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../../../CreateControl.js" type="text/javascript"></script>
	<script src="../../../GRInstall.js" type="text/javascript"></script>
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
	 		var f60301 = document.getElementById("f60301").value;
	    	CreatePrintViewer( "../../../grf/fnbj/sf/xqsf.grf",
	    	 "../../../data/fnbj/sf/xmlCustomer_xqsf.jsp?f60301="+f60301);
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="f60301" value="${param.f60301}"/>
</body>
</html>