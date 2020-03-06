<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Web报表(B/S报表)演示 - 将从服务器获得的XML数据提供给图表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style type="text/css">
        html,body {
            margin:0;
            height:100%;
        }
    </style>
	<script src="../CreateControl.js" type="text/javascript"></script>
	<script src="../GRInstall.js" type="text/javascript"></script>
	<script src="../GRUtility.js" type="text/javascript"></script>
	<script type="text/javascript">
		Install_InsertReport();
	</script>
	<script type="text/javascript">
		function window_onload() {
		if (_gr_platform.indexOf("64") > 0)
		    alert("报表插件不能运行在64位浏览器中，相关报表与打印功能将无法正常运新，请改用32位浏览器！");
    	else{
			var Installed = Install_Detect();
			if ( Installed )
			{
				ReportViewer.Stop();
				var Report = ReportViewer.Report;
				//关联报表事件
				Report.OnChartRequestData = OnChartRequestData;
				ReportViewer.Start();
			}
		}
	}
		}
		function OnChartRequestData(Chart) {
			var Report = ReportViewer.Report;
			var f303_07 = document.getElementById("f30307").value;
			var f303_04 = document.getElementById("f30304").value;
			var xml = Report.ExtractXMLFromURL("../data/xmlCustomer_gestation.jsp?f303_07="+ f303_07+"&f303_04="+ f303_04);
			Chart.LoadXYDataFromXML(xml, true);
		}
	</script>
</head>
<body style="margin:0" onload="return window_onload()">
    <script type="text/javascript"> 
	    CreatePrintViewerEx("100%", "100%", "../grf/gestation.grf", "", false, "");
	    //CreateDisplayViewerEx("100%", "100%", "../grf/gestation.grf", "", false, "");
    </script>
    <input type="hidden" id="f30307" value="${param.f303_07}"/>
    <input type="hidden" id="f30304" value="${param.f303_04}"/>
</body>
</html>
 