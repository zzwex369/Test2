<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生医学证明打印错误登记本</title>
<style type="text/css">
	table
	{
		width:940px;
		border-collapse:collapse;
	}
	thead tr
	{
		background-color:#CCC;
	}
	p
	{
		text-align:left;
	}
	td
	{
		text-align:center; 
	}
	@media print {
   		.Noprint {display:none;}
	}
</style>
</head>
<body>
	<div>
	<table id="excel" align="center">
		<tr>
			<td colspan="7"><h3>《出生医学证明》打印错误登记本</h3></td>
		</tr>
		
		<tr>
			<td><div align="left">单位名称：<span style="border-bottom:1px solid #000">${requestScope.institutionLabel }</span></div></td>
			<td colspan="6">
				<div align="right">
					起始时间：<span style="border-bottom:1px solid #000">${requestScope.date_start }</span>
					终止时间：<span style="border-bottom:1px solid #000">${requestScope.date_end }</span>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<table  border="2" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
					<thead>
						<tr>
							<td rowspan="2" nowrap="nowrap">序号</td>
							<td rowspan="2" nowrap="nowrap">单位名称</td>
							<td rowspan="2" nowrap="nowrap">打印错误<br>的出生证<br>编号</td>
							<td rowspan="2" nowrap="nowrap">打印错<br>误时间</td>
							<td rowspan="2" nowrap="nowrap">经办人<br>签名</td>
							<td rowspan="2" nowrap="nowrap">审核人<br>签名</td>
							<td colspan="2" nowrap="nowrap">作废处理结果</td>
							<td rowspan="2" nowrap="nowrap">签发机<br>构负责<br>人签名</td>
							<td rowspan="2" nowrap="nowrap">省辖市<br>销毁时<br>间</td>
						</tr>
						<tr>
							<td nowrap="nowrap">废证编<br>号永久<br>存档</td>
							<td nowrap="nowrap">废证交<br>省辖市<br>卫生局<br>按程序<br>销毁</td>
						</tr>
					</thead>
					<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
						<tr>
							<td nowrap="nowrap">${i.count }</td>
							<td align="center">${vd401.d40110Zh }</td>
							<td align="center" nowrap="nowrap">${vd401.d40105 }</td>
							<td align="center" nowrap="nowrap">${vd401.d40108 }</td>
							<td align="center" nowrap="nowrap">${vd401.d40109 }</td>
							<td align="center" nowrap="nowrap">${vd401.d40111 }</td>
							<td align="center">${vd401.d40120 }</td>
							<td align="center">${vd401.d40121 }</td>
							<td align="center" nowrap="nowrap">${vd401.d40122 }</td>
							<td align="center" nowrap="nowrap">${vd401.d40123 }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		
	</table>
			
	</div><br/><br/>
	<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
		<input type="button" onClick="AutomateExcel();" value="导出EXCEL" class="Noprint"/> 
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
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
</body>
</html>