<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>胎儿染色体产前诊断服务转诊单</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../CreateControl.js" type="text/javascript"></script>
		<script src="../../GRInstall.js" type="text/javascript"></script>
		<script type="text/javascript">
	Install_InsertReport();
</script>
		<style type="text/css">
html,body {
	margin: 0;
	height: 100%;
}
</style>
		<script type="text/javascript">
	function window_onload() {
		var Installed = Install_Detect();
		if (Installed) {
			 ReportViewer.Stop();
    
		    var Report = ReportViewer.Report;
		  
		    Report.ParameterByName("f60505").AsString = decodeURIComponent(document.getElementById("f60505").value);
		    Report.ParameterByName("f60507").AsString = decodeURIComponent(document.getElementById("f60507").value);
		    Report.ParameterByName("f60543").AsString = decodeURIComponent(document.getElementById("f60543").value);
		    Report.ParameterByName("f60542").AsString = document.getElementById("f60542").value;
		    Report.ParameterByName("f60531").AsString = decodeURIComponent(document.getElementById("f60531").value);
		    Report.ParameterByName("f60541").AsString = decodeURIComponent(document.getElementById("f60541").value);

		
		    ReportViewer.Start();
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="f60505" value="${param.f60505}" />
		<input type="hidden" id="f60507" value="${param.f60507}" />
		<input type="hidden" id="f60543" value="${param.f60543}" />
		<input type="hidden" id="f60542" value="${param.f60542}" />
		<input type="hidden" id="f60531" value="${param.f60531zh}" />
		<input type="hidden" id="f60541" value="${param.f60541zh}" />
		 <script type="text/javascript"> 
			 CreatePrintViewerEx("100%", "100%", "../../grf/msbb/cqzd/czzzd.grf", "", false, "<param name=BorderStyle value=1>");
        </script>
	</body>
</html>