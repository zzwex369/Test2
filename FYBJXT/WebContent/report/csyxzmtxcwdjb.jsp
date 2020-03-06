<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印及填写错误登记</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
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
	@media print {
   		.Noprint {display:none;}
	}
</style>
</head>
<body>
	<div>
		<h3 align="center">打印及填写错误登记</h3>
		<table borderColor="#FFFFFF" cellSpacing="0" align="center"  border="0" height="40">
			<tr>
				<td align="center"><u>南阳市</u>省辖市卫生局（签章）</td>
			</tr>
		</table>
			<table id="excel" border="2" borderColor="#000000"  align="center"
				style="font-size: 14px; border: gray2px; border-collapse: collapse"
				cellspacing="0" cellpadding="1">
				<tr>
					<td rowspan="2">序号</td>
					<td rowspan="2">单位名称</td>
					<td rowspan="2">打印及填写错误的出生证编号</td>
					<td rowspan="2">打印及填写错误的时间</td>
					<td rowspan="2">经办人签名</td>
					<td rowspan="2">审核人签名</td>
					<td colspan="2">作废处理结果</td>
					<td rowspan="2">签发机构负责人签名</td>
					<td rowspan="2">省辖市销毁时间</td>
				</tr>
				<tr>
					<td>废证编号永久存档</td>
					<td>废证交省辖市卫生局按程序销毁</td>
				</tr>
		</table>
	</div><br/><br/>
	<div align="center">
	<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
	<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
	<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
</div>
<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
</body>
</html>