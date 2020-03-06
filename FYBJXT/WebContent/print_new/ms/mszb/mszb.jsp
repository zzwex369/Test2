<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>民生周报表</title>
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
		    var dateStr = document.getElementById("dateStr").value;
		    var dateEnd = document.getElementById("dateEnd").value;
		    var code = document.getElementById("code").value;
		    var addType = document.getElementById("addType").value;
		     CreateDisplayViewer("../../grf/msbb/zbb.grf", "../../data/msbb/xmlCustomer_mszb.jsp?dateStr="
		     +dateStr+"&dateEnd="+dateEnd+"&code="+code+"&addType="+addType);
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="dateStr" value="${param.dateStr}"/>
	<input type="hidden" id="dateEnd" value="${param.dateEnd}"/>
	<input type="hidden" id="code" value="${param.code}"/>
	<input type="hidden" id="addType" value="${param.addType}"/>
</body>
</html>