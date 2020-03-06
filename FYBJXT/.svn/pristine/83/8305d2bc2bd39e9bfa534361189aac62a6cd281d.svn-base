<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@media print {
   .Noprint {display:none;}
}
td {
	text-align:center;
	height:30px;
}
thead {
	font-size:15px;
	font-weight:bold;
	background:#ccc;
}
</style>
<title>分娩情况统计</title>
</head>
<body>
<div>
	<table id="excel" width="75%" align="center" style="font-size: 14px">
		
		<tr>
			<td colspan="12">
				<h3 align="center">${institution}住院分娩情况统计表</h3>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<table border="2" width="100%" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
					<thead>
						<tr>
							<td rowspan="2">地区</td>
							<td colspan="3">住院分娩数</td>
							<td colspan="2">第一产次</td>
							<td colspan="2">第二产次</td>
							<td colspan="2">第三产次</td>
							<td colspan="2">其它产次</td>
						</tr>
						<tr>
							<td>总数</td>
							<td>男婴数</td>
							<td>女婴数</td>
							<td>男婴数</td>
							<td>女婴数</td>
							<td>男婴数</td>
							<td>女婴数</td>
							<td>男婴数</td>
							<td>女婴数</td>
							<td>男婴数</td>
							<td>女婴数</td>
						</tr> 
					</thead>
					<c:forEach var="fmqktj" items="${fmqktjs}" varStatus="i">
						<tr height="20">
							<td>${fmqktj.aredCodeZh }</td>
							<td>${fmqktj.total }</td>
							<td>${fmqktj.total_boy }</td>
							<td>${fmqktj.total_girl }</td>
							<td>${fmqktj.first_boy }</td>
							<td>${fmqktj.first_girl }</td>
							<td>${fmqktj.second_boy }</td>
							<td>${fmqktj.second_girl }</td>
							<td>${fmqktj.third_boy }</td>
							<td>${fmqktj.third_girl }</td>
							<td>${fmqktj.other_boy }</td>
							<td>${fmqktj.other_girl }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>         
	</table>
</div>
<br><br>
<script language="javascript">  
       function AutomateExcel(){  
       	  var elTable = document.getElementById("excel"); //要导出的table id。  
            	var oRangeRef = document.body.createTextRange();   
             oRangeRef.moveToElementText(elTable);   
             oRangeRef.execCommand("Copy");  
             var appExcel = new ActiveXObject("Excel.Application");  
             appExcel.Workbooks.Add().Worksheets.Item(1).Paste();   
             appExcel.Visible = true;   
             appExcel = null;  
       }
 </script>
<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
		<input type="button" onClick="AutomateExcel();" value="导出EXCEL" class="Noprint"/> 
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
	
</body>
</html>