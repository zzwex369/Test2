<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>河南省3-6岁儿童眼保健及视力检查报告单</title>
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
			var e70201 = document.getElementById("e70201").value;
			CreatePrintViewerEx("100%", "100%", "../../grf/etbj/etsl/etsljkjcb.grf",
					"../../data/etbj/etsl/xmlCustomer_etcz.jsp?e70201="
							+ e70201,true,"");
							
			ReportViewer.Report.ShowProgressUI = true;
		}
	}1
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="e70201" value="${param.e70201}" />
	</body>
</html>