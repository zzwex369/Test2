<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>超声综合查询</title>
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
	 		var chargetype = document.getElementById("chargetype").value;
	 		var date_status = document.getElementById("date_status").value;
	 		var address_status = document.getElementById("address_status").value;
	 		var address = document.getElementById("address").value;
	 		var institution = document.getElementById("institution").value;
	 		CreateDisplayViewerEx("100%", "100%", "../../grf/msbb/csbg.grf", "../../data/msbb/xmlCustomer_csxqbg.jsp?dateStr="+dateStr
	    	+"&dateEnd="+dateEnd
	    	+"&chargetype="+chargetype+"&date_status="+date_status+"&address_status="+address_status+"&address="
	    	+address+"&institution="+institution, true, "");
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="dateStr" value="${param.date_start}"/>
	<input type="hidden" id="dateEnd" value="${param.date_end}"/>
	<input type="hidden" id="chargetype" value="${param.chargetype}"/>
	<input type="hidden" id="date_status" value="${param.date_status}"/>
	<input type="hidden" id="address_status" value="${param.address_status}"/>
	<input type="hidden" id="address" value="${param.address}"/>
	<input type="hidden" id="institution" value="${param.institution}"/>
</body>
</html>