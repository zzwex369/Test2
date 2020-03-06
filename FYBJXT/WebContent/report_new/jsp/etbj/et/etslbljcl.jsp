<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>儿童视力不良检出率统计表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../../../CreateControl.js" type="text/javascript"></script>
		<script src="../../../GRInstall.js" type="text/javascript"></script>
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
			var timeStr = document.getElementById("timeStr").value;
			var timeEnd = document.getElementById("timeEnd").value;
			var institution = document.getElementById("institution").value;
			var date = document.getElementById("date").value;
			CreateDisplayViewer("../../../grf/etbj/et/etslbljcl.grf",
					"../../../data/etbj/et/xmlCustomer_etslbljcl.jsp?timeStr="
								 + timeStr +"&timeEnd="+timeEnd +"&institution="+institution+"&date="+date, true, "");
			
			 //设置报表的ShowProgressUI属性，开启报表生成进度条显示
			ReportViewer.Report.ShowProgressUI = true;
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="timeStr" value="${param.timeStr}" />
		<input type="hidden" id="timeEnd" value="${param.timeEnd}" />
		<input type="hidden" id="institution" value="${param.institution}" />
		<input type="hidden" id="date" value="${param.date}" />
	</body>
</html>