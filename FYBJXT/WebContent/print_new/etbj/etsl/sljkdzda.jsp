<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>河南省0-6岁儿童视力健康电子档案</title>
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
			var e70119 = document.getElementById("e70119").value;
			CreatePrintViewerEx( "100%", "100%", "../../grf/etbj/etsl/sljkdzda.grf",
					"../../data/etbj/etsl/xmlCustomer_sljkdzda.jsp?e70119="
							+ e70119,true,"");
			
			ReportViewer.Report.ShowProgressUI = true;
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="e70119" value="${param.e70119}" />
	</body>
</html>