<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>两病筛查汇总表</title>
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
    function window_onload() {
	/*	if (_gr_platform.indexOf("64") > 0)
		    alert("报表插件不能运行在64位浏览器中，相关报表与打印功能将无法正常运新，请改用32位浏览器！");
    	else{
			var Installed = Install_Detect();
			if ( Installed )
			{	 
		    	var date_satrt = document.getElementById("date_satrt").value;
		    	var date_end = document.getElementById("date_end").value;
		    	var institution = document.getElementById("institution").value;
		    	//var hospital=document.getElementById("hospital").value;
		    	var chargetype=document.getElementById("chargetype").value;
		    	var checktype=document.getElementById("checktype").value;
		    	var date_status=document.getElementById("date_status").value;
		    	CreateDisplayViewerEx("100%", "100%", "../grf/lbzh.grf", "../data/xmlCustomer_23.jsp?institution="+institution+"&date_satrt="
		    				+date_satrt+"&date_end="+date_end+"&chargetype="+chargetype+"&checktype="+checktype+"&date_status="+date_status, true, "");
		    				
		    	 //设置报表的ShowProgressUI属性，开启报表生成进度条显示
				ReportViewer.Report.ShowProgressUI = true;
			}	*/
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
    		
    			var date_satrt = document.getElementById("date_satrt").value;
		    	var date_end = document.getElementById("date_end").value;
		    	var institution = document.getElementById("institution").value;
		    	//var hospital=document.getElementById("hospital").value;
		    	var chargetype=document.getElementById("chargetype").value;
		    	var checktype=document.getElementById("checktype").value;
		    	var date_status=document.getElementById("date_status").value;
   				 //BatchStartRecNo指定本批次数据的起始记录号
  			    //BatchWantRecords指定一个批次希望获取的记录数
				ReportViewer.Report.LoadDataFromURL("../data/xmlCustomer_23.jsp?StartNo=" + ReportViewer.BatchNo + "&WantRecords=" 
					+ ReportViewer.BatchWantRecords +"&institution="+institution+"&date_end="+date_end+"&date_satrt="
		    				+date_satrt+"&chargetype="+chargetype+"&checktype="+checktype+"&date_status="+date_status);
		}
	</script>
</head>
<body onload="return window_onload()">
	<!-- <input type="hidden" id="hospital" value="${param.hospital}"/> -->
	<input type="hidden" id="date_satrt" value="${param.date_satrt}"/>
	<input type="hidden" id="date_end" value="${param.date_end}"/>
	<input type="hidden" id="institution" value="${param.institution}"/>
	<input type="hidden" id="chargetype" value="${param.chargetype}"/>
	<input type="hidden" id="checktype" value="${param.checktype}"/>
	<input type="hidden" id="date_status" value="${param.date_status}"/>
	<script type="text/javascript">
		var date_satrt = document.getElementById("date_satrt").value;
		var date_end = document.getElementById("date_end").value;
		var institution = document.getElementById("institution").value;
		    	//var hospital=document.getElementById("hospital").value;
		var chargetype=document.getElementById("chargetype").value;
		var checktype=document.getElementById("checktype").value;
		var date_status=document.getElementById("date_status").value;
		CreateDisplayViewerEx("100%", "100%", "../grf/lbzh.grf", "", false, "<param name=RowsPerPage value=20>" +
          "<param name=BatchGetRecord value=true>" +
          "<param name=BatchWantRecords value=100>" +
          "<param name=OnBatchFetchRecord value='OnBatchFetchRecord'>");
          
           //设置报表的ShowProgressUI属性，开启报表生成进度条显示
			ReportViewer.Report.ShowProgressUI = true;
	</script>
</body>
</html>
