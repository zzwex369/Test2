<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>儿童视力机构统计表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../../CreateControl.js" type="text/javascript"></script>
	<script src="../../GRInstall.js" type="text/javascript"></script>
	<script type="text/javascript">
		Install_InsertReport();
	</script>
    <style type="text/css">
        html,body {
            margin:0;
            height:100%;
        }
    </style>
    <script type="text/javascript">
    function window_onload() {
		if (_gr_platform.indexOf("64") > 0)
		    alert("报表插件不能运行在64位浏览器中，相关报表与打印功能将无法正常运新，请改用32位浏览器！");
    	else{
			var Installed = Install_Detect();
			if ( Installed )
			{	 
		    	var code = document.getElementById("code").value;
		    	var dateStr = document.getElementById("dateStr").value;
		    	var dateEnd = document.getElementById("dateEnd").value;
		    	var time = document.getElementById("time").value;
		    	var person = document.getElementById("person").value;
		    	CreateDisplayViewerEx("100%", "100%", "../../grf/etbj/etsl/0-6slhzb.grf", 
		    	"../../data/etbj/etsl/xmlCustomer_0-6slhzb.jsp?code="+code+
		    	"&dateStr="+dateStr+"&dateEnd="+dateEnd+"&time="+time+"&person="+person,
		    	 true, "");
		    	
		    	 //设置报表的ShowProgressUI属性，开启报表生成进度条显示
				ReportViewer.Report.ShowProgressUI = true;
			}	
		}
	}
	</script>
</head>
<body onload="window_onload()">
	<input type="hidden" id="code" value="${param.code}"/>
	<input type="hidden" id="dateStr" value="${param.dateStr}"/>
	<input type="hidden" id="dateEnd" value="${param.dateEnd}"/>
	<input type="hidden" id="time" value="${param.time}"/>
	<input type="hidden" id="person" value="${param.person}"/>
	
	
</body>
</html>
