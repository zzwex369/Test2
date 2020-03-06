<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>宫颈癌HPV检测试点地区HPV筛查完成情况统计表</title>
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
		  
		    Report.ParameterByName("code").AsString = decodeURIComponent(document.getElementById("code").value);
		    Report.ParameterByName("L302_62").AsString = decodeURIComponent(document.getElementById("L302_62").value);
		    Report.ParameterByName("L301_29").AsString = decodeURIComponent(document.getElementById("L301_29").value);
		    Report.ParameterByName("L301_30").AsString = decodeURIComponent(document.getElementById("L301_30").value);
		    
		    Report.ParameterByName("dateStr").AsString = decodeURIComponent(document.getElementById("dateStr").value);
		    Report.ParameterByName("dateEnd").AsString = decodeURIComponent(document.getElementById("dateEnd").value);
		  //  Report.ParameterByName("dateStr").AsString = document.getElementById("dateStr").value;
		   // Report.ParameterByName("dateEnd").AsString = document.getElementById("dateEnd").value;

		
		    ReportViewer.Start();
		
		/*	var code = document.getElementById("code").value;
			var dateStr = document.getElementById("dateStr").value;
			var dateEnd = document.getElementById("dateEnd").value;
			var L302_62 = document.getElementById("L302_62").value;
			var L301_29 = document.getElementById("L301_29").value;
			var L301_30 = document.getElementById("L301_30").value;
			CreateDisplayViewer( "../../grf/fnbj/gjahpv/gjahpvjcsddqscwcqktjb.grf",
					"../../data/fnbj/gjahpv/xmlCustomer_gjadqscwcqktjb.jsp?code="
								+ code + "&L302_62=" + L302_62 + "&L301_29=" + L301_29 + "&L301_30=" + L301_30
								+ "&dateStr=" + dateStr +"&dateEnd="+dateEnd, true, "<param name=BorderStyle value=1>");*/
		}
	}
</script>
	</head>
	<body onload="window_onload()">
		<input type="hidden" id="code" value="${param.code}" />
		<input type="hidden" id="dateStr" value="${param.dateStr}" />
		<input type="hidden" id="dateEnd" value="${param.dateEnd}" />
		<input type="hidden" id="L302_62" value="${param.L302_62}" />
		<input type="hidden" id="L301_29" value="${param.L301_29}" />
		<input type="hidden" id="L301_30" value="${param.L301_30}" />
		
		<script type="text/javascript">
			var code = document.getElementById("code").value;
			var dateStr = document.getElementById("dateStr").value;
			var dateEnd = document.getElementById("dateEnd").value;
			var L302_62 = document.getElementById("L302_62").value;
			var L301_29 = document.getElementById("L301_29").value;
			var L301_30 = document.getElementById("L301_30").value;
		CreateDisplayViewer( "../../grf/fnbj/gjahpv/gjahpvjcsddqscwcqktjb.grf",
					"../../data/fnbj/gjahpv/xmlCustomer_gjadqscwcqktjb.jsp?code="
								+ code + "&L302_62=" + L302_62 + "&L301_29=" + L301_29 + "&L301_30=" + L301_30
								+ "&dateStr=" + dateStr +"&dateEnd="+dateEnd, true, "<param name=BorderStyle value=1>");
		</script>
	</body>
</html>