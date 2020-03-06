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
			var l40201 = document.getElementById("l40201").value;

			CreateDisplayViewer("../../grf/msbb/fkk.grf",
					"../../data/msbb/xmlCustomer_la.jsp?l40201=" + l40201);
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="l40201" value="${param.l40201}" />
	</body>
</html>