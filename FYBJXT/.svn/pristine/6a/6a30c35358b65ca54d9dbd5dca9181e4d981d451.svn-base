<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》遗失及其它废证处理情况登记</title>
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
		<h3 align="center">《出生医学证明》遗失及其它废证处理情况登记</h3>
		<p align="center"><u>南阳市</u>省辖市卫生局（签章）</p>
		<table id="excel" border="2" borderColor="#000000"  align="center"
			style="font-size: 14px; border: gray2px; border-collapse: collapse"
			cellspacing="0" cellpadding="1">
			<tr>
				<td rowspan="2">序号</td>
				<td rowspan="2">单位名称</td>
				<td rowspan="2">遗失(其它废证)出生证编号</td>
				<td rowspan="2">遗失(其它)时间</td>
				<td rowspan="2">遗失(其它)原因</td>
				<td rowspan="2">经办人签名</td>
				<td rowspan="2">审核人签名</td>
				<td colspan="2">遗失(其它废证)作废声明</td>
				<td colspan="2">处理情况</td>
			</tr>
			<tr>
				<td>时间</td>
				<td>报刊名称</td>
				<td>对单位</td>
				<td>对人员</td>
			</tr>
			<c:forEach var="" items="${requestScope }" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
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