<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>儿童眼保健及视力检查覆盖率统计表</title>
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
			CreateDisplayViewer("../../../grf/etbj/et/etybjsljcfgl.grf",
					"../../../data/etbj/et/xmlCustomer_etybjsljcfgl.jsp?"
								+ "&timeStr=" + timeStr +"&timeEnd="+timeEnd+"&institution="+institution, true, "");
								
			ReportViewer.Report.ShowProgressUI = true;
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="timeStr" value="${param.timeStr}" />
		<input type="hidden" id="timeEnd" value="${param.timeEnd}" />
		<input type="hidden" id="institution" value="${param.institution}" />
	</body>
</html>