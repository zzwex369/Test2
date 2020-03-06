<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>分娩信息登记本</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script src="../CreateControl.js" type="text/javascript"></script>
	<script src="../GRInstall.js" type="text/javascript"></script>
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
		function window_onload(){
			var Installed = Install_Detect();
			if ( Installed )
			{
			
			/*	var timeStr = document.getElementById("timeStr").value;
				var timeEnd = document.getElementById("timeEnd").value;
				var institution = document.getElementById("institution").value;
				CreateDisplayViewer("../grf/fmxxdjb.grf", "../data/fmxxdjb.jsp?timeStr="+timeStr+"&timeEnd="+timeEnd+"&institution="+institution, true, "");*/
			}
			
			ReportViewer.Start();
		}
		
		function OnBatchFetchRecord(){
    		//在 GRDisplayViewer 的 BatchFetchRecord 事件上向服务器请求每一批次的数据
    
    		//找出已取数据最后一条记录的关键字段值，作为下一批取数的筛选条件
    		//var OrderID = 0;
    	/*	if ( !ReportViewer.Report.DetailGrid.Recordset.Eof() ){
        		ReportViewer.Report.DetailGrid.Recordset.Last();
        		OrderID = ReportViewer.Report.FieldByName("D601_03").AsInteger;
    		}
        	    var OrderID = ReportViewer.BatchNo;*/
    			//OrderID = OrderID + 40;
    		
    			var timeStr = document.getElementById("timeStr").value;
				var timeEnd = document.getElementById("timeEnd").value;
				var institution = document.getElementById("institution").value;
				var time = document.getElementById("time").value;
   				 //BatchStartRecNo指定本批次数据的起始记录号
  			    //BatchWantRecords指定一个批次希望获取的记录数
				ReportViewer.Report.LoadDataFromURL("../data/fmxxdjb.jsp?StartNo=" + ReportViewer.BatchNo + "&WantRecords=" 
					+ ReportViewer.BatchWantRecords +"&timeStr="+timeStr+"&timeEnd="+timeEnd+"&institution="+institution+"&time="+time);
		}
		</script>

	
    
</head>
<body onload="return window_onload()">
	<input type="hidden" id="timeStr" value="${param.timeStr}"/>
	<input type="hidden" id="timeEnd" value="${param.timeEnd}"/>
	<input type="hidden" id="institution" value="${param.institution}"/>
	<input type="hidden" id="time" value="${param.time}"/>
	<script type="text/javascript">
		var timeStr = document.getElementById("timeStr").value;
		var timeEnd = document.getElementById("timeEnd").value;
		var institution = document.getElementById("institution").value;
		var time = document.getElementById("time").value;
		CreateDisplayViewerEx("100%","100%","../grf/fmxxdjb.grf", "", false, "<param name=RowsPerPage value=20>" +
          "<param name=BatchGetRecord value=true>" +
          "<param name=BatchWantRecords value=100>" +
          "<param name=OnBatchFetchRecord value='OnBatchFetchRecord'>");
          
           //设置报表的ShowProgressUI属性，开启报表生成进度条显示
			ReportViewer.Report.ShowProgressUI = true;
	</script>
</body>
</html>