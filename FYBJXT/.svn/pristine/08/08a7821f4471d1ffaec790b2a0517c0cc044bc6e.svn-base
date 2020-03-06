<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>血卡编号打印</title>
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
		    var f60101 = document.getElementById("f60101").value;
		    var size = document.getElementById("size").value;
		    var grf=size=='big'?"xkbh":"xkbh2";
		     CreatePrintViewerEx("100%", "100%", "../../grf/fnbj/"+grf+".grf", "../../data/fnbj/xmlCustomer_xkbh.jsp?f60101="+f60101, true, "");
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="f60101" value="${param.f60101}"/>
	<input type="hidden" id="size" value="${param.size}"/>
</body>
</html>