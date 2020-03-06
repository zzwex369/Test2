<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>免费乳腺癌筛查反馈卡</title>
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
			var l30101 = document.getElementById("l30101").value;
			var status = document.getElementById("status").value;
			var grf    = status=="1"?"gjady":"rxady";
			CreateDisplayViewer("../../grf/msbb/la/"+grf+".grf",
					"../../data/msbb/la/xmlCustomer_lada.jsp?l30101=" + l30101);
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="l30101" value="${param.l30101}" />
		<input type="hidden" id="status" value="${param.status}" />
	</body>
</html>