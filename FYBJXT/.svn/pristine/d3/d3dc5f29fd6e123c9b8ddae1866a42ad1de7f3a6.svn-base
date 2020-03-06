<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河南省计划生育相关情况季报表</title>
<style type="text/css">
#fm {
	border-bottom: 1px solid #333;
	border-left: 1px solid #333;
	text-align: center;
}

#fm td {
	padding: 3px;
	border-top: 1px solid #333;
	border-right: 1px solid #333;
}

td {
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 11.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	text-align: general;
	vertical-align: middle;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}

div { /*自动居中*/
	margin: auto;
	height: auto;
	text-align: center;
	zoom: 1;
}

.div {
	width: 910px;
	margin: auto;
	height: auto;
}
</style>
</head>
<body>
	<table id="excel" class="div">
		<tr>
			<td style="text-align: center;"><h1>河南省计划生育相关情况季报表</h1></td>
		</tr>
		<tr>
			<td style="text-align: center;"><span style="float: left;">填报单位（盖章）${institutionName}</span>
				<span style="padding-left: 580px">${year}&nbsp;年第${quarter}&nbsp;季度</span></td>
		</tr>
		<tr>
			<td>
				<table align="center" width="1000" cellspacing="0" cellpadding="0"
					style="text-align: center" id="fm">
					<tr height="54" style='height: 40.50pt;'>
						<td></td>
						<td></td>
						<td></td>
						<td>有准生证</td>
						<td>无准生证</td>
						<td colspan="4">活产数（人）</td>
						<td colspan="4">死胎死产数（人）</td>
					</tr>
					<tr>
						<td>单位名称</td>
						<td>月份</td>
						<td>产妇数</td>
						<td>产妇数</td>
						<td>产妇数</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
					</tr>
					<c:if test="${!empty requestScope.listDeliveryTemp}">
						<c:forEach items="${requestScope.listDeliveryTemp}"
							var="listDeliveryTemp" varStatus="i">
							<tr>
								<td>${listDeliveryTemp.institonZh}</td>
								<td>${listDeliveryTemp.t04}</td>
								<td>${listDeliveryTemp.t07 + listDeliveryTemp.t06}</td>
								<td>${listDeliveryTemp.t07}</td>
								<td>${listDeliveryTemp.t06}</td>
								<td>${listDeliveryTemp.t08}</td>
								<td>${listDeliveryTemp.t09}</td>
								<td>${listDeliveryTemp.t10}</td>
								<td>${listDeliveryTemp.t11}</td>
								<td>${listDeliveryTemp.t12}</td>
								<td>${listDeliveryTemp.t13}</td>
								<td>${listDeliveryTemp.t14}</td>
								<td>${listDeliveryTemp.t15}</td>
							</tr>
						</c:forEach>
						<tr>
								<td>合计</td>
								<td></td>
								<td>${requestScope.deliveryTemp.t07 + requestScope.deliveryTemp.t06}</td>
								<td>${requestScope.deliveryTemp.t07}</td>
								<td>${requestScope.deliveryTemp.t06}</td>
								<td>${requestScope.deliveryTemp.t08}</td>
								<td>${requestScope.deliveryTemp.t09}</td>
								<td>${requestScope.deliveryTemp.t10}</td>
								<td>${requestScope.deliveryTemp.t11}</td>
								<td>${requestScope.deliveryTemp.t12}</td>
								<td>${requestScope.deliveryTemp.t13}</td>
								<td>${requestScope.deliveryTemp.t14}</td>
								<td>${requestScope.deliveryTemp.t15}</td>
							</tr>
					</c:if>
					<c:if test="${empty requestScope.listDeliveryTemp}">
						<tr height="22px">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr height="22px">
							<td>合计</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
	</table>

	<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)"
			class="Noprint" /> <input type="button" value="打印页面设置..."
			onclick="wb.execwb(8,1)" class="Noprint" /> <input type="button"
			value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint" /> <input
			type="button" onClick="AutomateExcel()" value="导出EXCEL" />
	</div>

	<OBJECT id="wb" height="0" width="0"
		classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
	<script language="javascript">
		function AutomateExcel() {
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