<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>儿童视力检查统计表</title>
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
			ReportViewer.Stop();
		    var Report = ReportViewer.Report;
		  
		    Report.ParameterByName("institution").AsString = decodeURIComponent(document.getElementById("institution").value);
		    Report.ParameterByName("e70208").AsString = decodeURIComponent(document.getElementById("e70208").value);
		    Report.ParameterByName("e70273").AsString = decodeURIComponent(document.getElementById("e70273").value);
		    Report.ParameterByName("e70204").AsString = decodeURIComponent(document.getElementById("e70204").value);
		    Report.ParameterByName("e70260").AsString = decodeURIComponent(document.getElementById("e70260").value);
		    Report.ParameterByName("e70261").AsString = decodeURIComponent(document.getElementById("e70261").value);
		    Report.ParameterByName("e70209").AsString = decodeURIComponent(document.getElementById("e70209").value);
		    
		    Report.ParameterByName("timeStr").AsString = decodeURIComponent(document.getElementById("timeStr").value);
		    Report.ParameterByName("timeEnd").AsString = decodeURIComponent(document.getElementById("timeEnd").value);

		
		    ReportViewer.Start();
		}
	}	
		
		function OnBatchFetchRecord(){
			var institution = document.getElementById("institution").value;
			var e70208 = document.getElementById("e70208").value;
			var timeStr = document.getElementById("timeStr").value;
			var timeEnd = document.getElementById("timeEnd").value;
			var e70273 = document.getElementById("e70273").value;
			var e70204 = document.getElementById("e70204").value;
			var e70260 = document.getElementById("e70260").value;
			var e70261 = document.getElementById("e70261").value;
			var e70209 = document.getElementById("e70209").value;
			
			ReportViewer.Report.LoadDataFromURL("../../../data/etbj/et/xmlCustomer_etsljcdjb.jsp?StartNo=" + ReportViewer.BatchNo + "&WantRecords=" 
					+ ReportViewer.BatchWantRecords +"&institution="+ institution + "&e70208=" + e70208 + "&e70273=" + e70273 + "&e70204=" + e70204 + "&e70260=" 
					+ e70260 + "&e70209=" + e70209+ "&e70261=" + e70261 + "&timeStr=" + timeStr +"&timeEnd="+timeEnd);
		}
	
</script>
	</head>
	<body onload="return window_onload()">
		<input type="hidden" id="institution" value="${param.institution}" />
		<input type="hidden" id="e70208" value="${param.e70208}" />
		<input type="hidden" id="timeStr" value="${param.timeStr}" />
		<input type="hidden" id="timeEnd" value="${param.timeEnd}" />
		<input type="hidden" id="e70273" value="${param.e70273}" />
	 	<input type="hidden" id="e70204" value="${param.e70204}" /> 
	 	<input type="hidden" id="e70260" value="${param.e70260}" /> 
	 	<input type="hidden" id="e70261" value="${param.e70261}" /> 
	 	<input type="hidden" id="e70209" value="${param.e70209}" /> 
	 	
	 	<script type="text/javascript">
	 		var institution = document.getElementById("institution").value;
			var e70208 = document.getElementById("e70208").value;
			var timeStr = document.getElementById("timeStr").value;
			var timeEnd = document.getElementById("timeEnd").value;
			var e70273 = document.getElementById("e70273").value;
			var e70204 = document.getElementById("e70204").value;
			var e70260 = document.getElementById("e70260").value;
			var e70261 = document.getElementById("e70261").value;
			var e70209 = document.getElementById("e70209").value;
			
			CreateDisplayViewerEx( "100%","100%","../../../grf/etbj/et/etsljcdjb.grf","", false,"<param name=RowsPerPage value=20>" +
          "<param name=BatchGetRecord value=true>" +
          "<param name=BatchWantRecords value=100>" +
          "<param name=OnBatchFetchRecord value='OnBatchFetchRecord'>");
          
          
          //设置报表的ShowProgressUI属性，开启报表生成进度条显示
			ReportViewer.Report.ShowProgressUI = true;
	 	</script>
	</body>
</html>