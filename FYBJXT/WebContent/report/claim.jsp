<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@media print {
   .Noprint {display:none;}
}
</style>
<title>年度出生医学证明申领计划</title>
</head>
<body>
	<div>
		<h3 align="center"><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;</u>年度出生医学证明申领计划表</h3>
		<table width="940" align="center" style="font-size: 14px">
			<tr>
				<td>
					<p align="left">上报单位(盖章):</p>
				</td>
			</tr>
		</table>
		<table id="excel" border="2" borderColor="#000000"  align="center"
			style="font-size: 14px; border: gray2px; border-collapse: collapse"
			cellspacing="0" cellpadding="1">
			<tr height="40" bgcolor="#D4D4D4">
				<td width="94"><p align="center">证件名称</p></td>
				<td width="94"><p align="center">年度计划<br/>（套）</p></td>
				<td width="188"><p align="center">第一季度计划<br/>（套）</p></td>
				<td width="188"><p align="center">第二季度计划<br/>（套）</p></td>
				<td width="188"><p align="center">第三季度计划<br/>（套）</p></td>
				<td width="188"><p align="center">第四季度计划<br/>（套）</p></td>
			</tr>
			<tr height="40">
				<td><p align="center">出生医学证明</p></td>
				<td><p align="center"></p></td>
				<td><p align="center"></p></td>
				<td><p align="center"></p></td>
				<td><p align="center"></p></td>
				<td><p align="center"></p></td>
			</tr>
		</table><br/><br/>
		<table width="940" align="center" style="font-size: 14px">
			<tr>
				<td>
					负责人&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
				</td>
				<td>
					填表人&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
				</td>
				<td>
					填表日期&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>年
					<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>月
					<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>日
				</td>
			</tr>
		</table>
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
</body>
</html>