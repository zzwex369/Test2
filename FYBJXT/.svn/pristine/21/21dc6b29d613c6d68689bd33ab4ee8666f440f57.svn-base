<%@ page language="java" contentType="application/msexcel; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@media print {
   .Noprint {display:none;}
}
</style>
<title>《出生医学证明》管理使用情况年度统计表</title>
</head>
<body>
	<div>
		<h3 align="center">《出生医学证明》管理使用情况年度统计表</h3>
		<table width="80%" align="center" style="font-size: 14px">
			<tr>
				<td colspan="19">
					<p align="left">报表年度：<u>&nbsp;&nbsp;&nbsp;${requestScope.listReportTemp[0].year}&nbsp;&nbsp;&nbsp;</u>年</p>
				</td>
			</tr>
		</table>
		<table id="excel" border="2" borderColor="#000000"  align="center"
			style="font-size: 14px; border: gray2px; border-collapse: collapse"
			cellspacing="0" cellpadding="1">
			<tr>
				<td colspan="1" rowspan="3"><p align="center">省辖市</p></td>
				<td colspan="1" rowspan="3"><p align="center">上一年<br/>底库存<br/>数</p></td>
				<td colspan="1" rowspan="3"><p align="center">当年申<br/>领数</p></td>
				<td colspan="12"><p align="center">当年使用情况</p></td>
				<td colspan="1" rowspan="3"><p align="center">当年<br/>年底<br/>库存数</p></td>
				<td colspan="1" rowspan="3"><p align="center">当年医<br/>疗保健<br/>机构内<br/>活产数</p></td>
				<td colspan="1" rowspan="3"><p align="center">上报分娩<br/>登记数</p></td>
				<td colspan="1" rowspan="3"><p align="center">漏报分娩<br/>登记数</p></td>
			</tr>
			<tr>
				<td colspan="4"><p align="center">医疗保健机构内出生的签发数</p></td>
				<td colspan="3"><p align="center">医疗保健机构外出生的签发数</p></td>
				<td colspan="4"><p align="center">废证数</p></td>
				<td colspan="1" rowspan="2" nowrap="nowrap"><p align="center">合计</p></td>
			</tr>
			<tr>
				<td colspan="1"><p align="center">首次<br/>签发数</p></td>
				<td colspan="1"><p align="center">换发数</p></td>
				<td colspan="1"><p align="center">补发数</p></td>
				<td colspan="1"><p align="center">小计</p></td>
				<td colspan="1"><p align="center">家庭接生<br/>员接生的<br/>签发数</p></td>
				<td colspan="1"><p align="center">其它情<br/>况的签<br/>发数</p></td>
				<td colspan="1"><p align="center">小计</p></td>
				<td colspan="1"><p align="center">因打印或填写错误数</p></td>
				<td colspan="1"><p align="center">遗失数</p></td>
				<td colspan="1"><p align="center">其它原因数</p></td>
				<td colspan="1"><p align="center">小计</p></td>
			</tr>
			<c:forEach var="reportTemp" items="${requestScope.listReportTemp}" varStatus="i">
				<tr height="20">
					<td colspan="1" nowrap="nowrap"><p align="center">${reportTemp.institutionZh }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t01 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t02 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t03 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t04 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t05 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t06 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t07 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t08 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t09 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t10 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t11 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t12 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t19 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t20 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t21 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t22 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t23 }</p></td>
					<td colspan="1"><p align="center">${reportTemp.t24 }</p></td>
				</tr>
			</c:forEach>
		</table>
		<table width="75%" align="center" style="font-size: 14px">
			<tr>
				<td colspan="19"><p align="left">注：本统计表的《出生医学证明》数量为内芯数量，单位均为“枚”。</p></td>
			</tr>
		</table><br/><br/>
		<table width="75%" align="center" style="font-size: 14px">
			<tr>
				<td colspan="19">单位名称(盖章)&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td>
			</tr>
		</table>
		<table width="75%" align="center" style="font-size: 14px">
			<tr>
				<td colspan="4">
					负责人&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
				</td>
				<td colspan="4">
					填表人&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
				</td>
				<td colspan="6">
					填表日期&nbsp;&nbsp;：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>年
					<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>月
					<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>日
				</td>
			</tr>
		</table>
	</div><br/><br/>
</body>
</html>