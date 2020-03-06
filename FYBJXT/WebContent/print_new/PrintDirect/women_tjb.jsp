<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>女性婚前体检表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../CreateControl.js" type="text/javascript"></script>
	
    <style type="text/css">
        html,body {
            margin:0;
            height:100%;
        }
    </style>
    <script type="text/javascript">
    function window_onload() {
    	var f40101 = document.getElementById("f40101").value;
    	 CreatePrintViewerEx("100%", "100%", "../grf/women_tjb.grf", "../data/xmlCustomer_women_tjb.jsp?f40101="+f40101, true, "");
    }
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="f40101" value="${param.f40101}"/>
</body>
</html>