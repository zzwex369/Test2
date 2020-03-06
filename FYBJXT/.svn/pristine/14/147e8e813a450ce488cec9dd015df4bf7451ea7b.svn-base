<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》废证销毁申请表</title>
<style type="text/css">
	table
	{
		width:1000px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
		border-collapse:collapse;
	}
</style>
<body>
	<div>
		<table id="excel" borderColor="#000000" cellSpacing="0" align="center"  border="0">
			<tr>
				<td align="left">
					<h3 align="center" style="margin-bottom:0px;">《出生医学证明》废证销毁申请表</h3>
					<p align="center" style="margin-top:0px;">年度</p>
					单位名称（盖章）：　　　　　　　　　　　　　　主管领导审核签字：  　　　　　　　日期：
				</td>
			</tr>
			<tr>
				<td>
					<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
						<thead>
							<tr>
								<td nowrap="nowrap">导致废证的助产机<br>构全称</td>
								<td>废证数量</td>
								<td>废证编号</td>
								<td nowrap="nowrap">废证时间</td>
								<td nowrap="nowrap">废证原因</td>
								<td>废证责任人</td>
								<td>审核人</td>
								<td>助产机构负责人</td>
							</tr>
						</thead>
						<tr>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
							<td nowrap="nowrap">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table borderColor="#000000" cellSpacing="0" align="center"  border="0">
			<tr>
				<td align="left">注：1、废证原件及销毁申请表一并交省辖市卫生局《出生医学证明》管理人员。<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					2、此申请表一式两份，省辖市和县（市、区）卫生局各存档一份。
				</td>
			</tr>
			<tr>
				<td align="left">县（市、区）卫生局《出生医学证明》管理人员签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					申请日期：<br>
					省辖市卫生局《出生医学证明》管理人员接收签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					接受日期：
				</td>
			</tr>
			<tr>
				<td align="center"><br>
					<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
					<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
					<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
					<input type="button" onClick="return AutomateExcel();"value="导出EXCEL"  align="middle" /> 
				</td>
			</tr>
		</table>
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