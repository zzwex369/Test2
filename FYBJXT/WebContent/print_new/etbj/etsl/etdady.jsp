<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>儿童档案</title>
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
			var e70101 = document.getElementById("e70101").value;
			CreatePrintViewerEx("100%", "100%", "../../grf/etbj/etsl/etdady.grf",
					"../../data/etbj/etsl/xmlCustomer_etda.jsp?e70101="
							+ e70101,true,"");
							
			ReportViewer.Report.ShowProgressUI = true;
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="e70101" value="${param.e70101}" />
	</body>
</html>