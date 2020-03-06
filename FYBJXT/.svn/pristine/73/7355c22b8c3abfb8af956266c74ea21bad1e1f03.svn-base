<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>分娩情况统计</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../CreateControl.js" type="text/javascript"></script>
	<script src="../GRInstall.js" type="text/javascript"></script>
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
		function window_onload(){
			var Installed = Install_Detect();
		if (Installed) {
			var date_start = document.getElementById("date_start").value;
			var date_end = document.getElementById("date_end").value;
			var areaCode = document.getElementById("areaCode").value;
			var sexFlag = document.getElementById("sexFlag").value;
			var areaFlag = document.getElementById("areaFlag").value;
			var timeFlag = document.getElementById("timeFlag").value;
			CreateDisplayViewerEx("100%","100%","../grf/fmqktjb.grf", "../data/xmlCustomer_fmqktjb.jsp?date_start="+date_start+"&date_end="+
												date_end+"&areaCode="+areaCode+"&sexFlag="+sexFlag+"&areaFlag="+areaFlag+"&timeFlag="+timeFlag, true, "");
          
          		 //设置报表的ShowProgressUI属性，开启报表生成进度条显示
				ReportViewer.Report.ShowProgressUI = true;
			}
		}
		</script>

</head>
<body onload="return window_onload()">
	<input type="hidden" id="date_start" value="${param.date_start}"/>
	<input type="hidden" id="date_end" value="${param.date_end}"/>
	<input type="hidden" id="areaCode" value="${param.areaCode}"/>
	<input type="hidden" id="sexFlag" value="${param.sexFlag}"/>
	<input type="hidden" id="areaFlag" value="${param.areaFlag}"/>
	<input type="hidden" id="timeFlag" value="${param.timeFlag}"/>
	
</body>
</html>