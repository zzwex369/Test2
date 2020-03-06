<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>血清申请单</title>
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
	 		var param="";
	 		var f60129 = document.getElementById("f60129").value;
	 		var f60141 = document.getElementById("f60141").value;
	 		var f60144 = document.getElementById("f60144").value;
	 		var f60156 = document.getElementById("f60156").value;
	 		var f60163 = document.getElementById("f60163").value;
	 		var timeStr = document.getElementById("timeStr").value;
	 		var timeEnd = document.getElementById("timeEnd").value;
	 		var timeTag = document.getElementById("timeTag").value;
	 		var status = document.getElementById("status").value;
	 		var trisomy_21 = document.getElementById("trisomy_21").value;
	 		var NTD = document.getElementById("NTD").value;
	 		var Age_risk = document.getElementById("Age_risk").value;
	 		var unit = document.getElementById("unit").value;
	 		var hospital = document.getElementById("hospital").value;
	 		var address_status = document.getElementById("address_status").value;
	 		
	 			param="f60129="+f60129+"&f60163="+f60163+"&f60144="+f60144+"&f60156="+f60156+
	 				 "&f60141="+f60141+"&timeStr="+timeStr+"&timeEnd="+timeEnd+"&timeTag="+timeTag+
	 				 "&timeTag="+timeTag+"&status=1"+"&trisomy_21="+trisomy_21+"&NTD="+NTD+"&Age_risk="+Age_risk+"&unit="+unit+"&hospital="+hospital+"&address_status="+address_status;
	 		
	 		CreateDisplayViewerEx("100%", "100%", "../../grf/fnbj/xqmxb.grf", "../../data/fnbj/xmlCustomer_cqsc.jsp?"+param, true, "");
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="f60129" value="${param.f60129}"/>
	<input type="hidden" id="f60141" value="${param.f60141}"/>
	<input type="hidden" id="f60144" value="${param.f60144}"/>
	<input type="hidden" id="f60156" value="${param.f60156}"/>
	<input type="hidden" id="f60163" value="${param.f60163}"/>
	<input type="hidden" id="timeStr" value="${param.timeStr}"/>
	<input type="hidden" id="timeEnd" value="${param.timeEnd}"/>
	<input type="hidden" id="timeTag" value="${param.timeTag}"/>
	<input type="hidden" id="status" value="${param.status}"/>
	<input type="hidden" id="trisomy_21" value="${param.trisomy_21}"/>
	<input type="hidden" id="NTD" value="${param.NTD}"/>
	<input type="hidden" id="Age_risk" value="${param.Age_risk}"/>
	<input type="hidden" id="unit" value="${param.unit}"/>
	<input type="hidden" id="hospital" value="${param.hospital}"/>
	<input type="hidden" id="address_status" value="${param.address_status}"/>
</body>
</html>