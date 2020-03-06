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
	 		var f60103 = document.getElementById("f60103").value;
	 		var f60104 = document.getElementById("f60104").value;
	 		var f60109 = document.getElementById("f60109").value;
	 		var f60129 = document.getElementById("f60129").value;
	 		var f60141 = document.getElementById("f60141").value;
	 		var f60144 = document.getElementById("f60144").value;
	 		var f60155 = document.getElementById("f60155").value;
	 		var f60156 = document.getElementById("f60156").value;
	 		var f60163 = document.getElementById("f60163").value;
	 		var timeStr = document.getElementById("timeStr").value;
	 		var timeEnd = document.getElementById("timeEnd").value;
	 		var timeTag = document.getElementById("timeTag").value;
	 		var status = document.getElementById("status").value;
	 		var a = document.getElementById("a").value;
	 		var b = document.getElementById("b").value;
	 		var c = document.getElementById("c").value;
	 		if(status=="2")
	 				param="f60103="+f60103+"&f60104="+f60104+"&f60109="+f60109+"&f60155="+f60155+"&status=2";
	 		else{
	 			param="f60129="+f60129+"&f60163="+f60163+"&f60144="+f60144+"&f60156="+f60156+
	 				 "&f60141="+f60141+"&timeStr="+timeStr+"&timeEnd="+timeEnd+"&timeTag="+timeTag+
	 				 "&timeTag="+timeTag+"&status=1"+"&a="+a+"&b="+b+"&c="+c;
	 		}
	 		CreateDisplayViewerEx("100%", "100%", "../../grf/fnbj/xqmxb.grf", "../../data/fnbj/xmlCustomer_xqmxb.jsp?"+param, true, "");
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="f60103" value="${param.f60103}"/>
	<input type="hidden" id="f60104" value="${param.f60104}"/>
	<input type="hidden" id="f60109" value="${param.f60109}"/>
	<input type="hidden" id="f60129" value="${param.f60129}"/>
	<input type="hidden" id="f60141" value="${param.f60141}"/>
	<input type="hidden" id="f60144" value="${param.f60144}"/>
	<input type="hidden" id="f60155" value="${param.f60155}"/>
	<input type="hidden" id="f60156" value="${param.f60156}"/>
	<input type="hidden" id="f60163" value="${param.f60163}"/>
	<input type="hidden" id="timeStr" value="${param.timeStr}"/>
	<input type="hidden" id="timeEnd" value="${param.timeEnd}"/>
	<input type="hidden" id="timeTag" value="${param.timeTag}"/>
	<input type="hidden" id="status" value="${param.status}"/>
	<input type="hidden" id="a" value="${param.a}"/>
	<input type="hidden" id="b" value="${param.b}"/>
	<input type="hidden" id="c" value="${param.c}"/>
</body>
</html>