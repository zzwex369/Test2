<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>助产机构分娩记录统计表</title>
<style type="text/css">
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

.ie7 .tbodyClass1 {
	height: 19px;
}

.trClass1 {
	height: 30px;
}

tr td {
	border: solid 1px #000000;
	font-size: 13px;
	line-height: 18px;
	valign: middle;
}

table {
	width: 887px;
	margin: 8px auto;
	text-align: center;
	border-collapse: collapse;
	table-layout: fixed; /*固定宽度*/
	/* cellspacing:"0";指定相邻单元格边框的间距；*/

	/* cellpadding:10;指定表格单元格与内容之间的间距；*/
}
</style>
<script type="text/javascript">
	/*判断浏览器*/
	function getOs() {
		if (window.ActiveXObject != undefined) {
			var ieVersion = "";
			if (navigator.userAgent.indexOf("MSIE 6.0;") > 0) {
				return ieVersion = "6";
			}
			if (navigator.userAgent.indexOf("MSIE 7.0;") > 0) {
				return ieVersion = "7";
			}
			if (navigator.userAgent.indexOf("MSIE 8.0;") > 0) {
				return ieVersion = "8";
			}
			if (navigator.userAgent.indexOf("MSIE 9.0;") > 0) {
				return ieVersion = "9";
			}
			if (navigator.userAgent.indexOf("MSIE 10.0;") > 0) {
				return ieVersion = "10";
			}
			if (navigator.userAgent.indexOf("MSIE 11.0;") > 0) {
				return ieVersion = "11";
			} else {
				return ieVersion = "未知";
			}
			return ieVersion;
		}
		if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
			return "Firefox";
		}
		if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
			return "Safari";
		}
		if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
			return "Camino";
		}
		if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
			return "Gecko";
		}
	}
	var isIE = getOs();
	//alert(isIE);
	//console.log(navigator.userAgent);
	window.onload = function() {
		var cssStyle = document.compatMode;//得到浏览器的渲染模式
		var div = document.getElementById("divId");
		var divId2 = document.getElementById("divId2");
		var divId4 = document.getElementById("divId4");
		var table = document.getElementById("tableId");
		var tbody = document.getElementById("tbodyId");
		var ol = document.getElementById("olId");
		if (cssStyle == 'BackCompat') {
			div.style.paddingTop = "1px";
			table.style.textAlign = "center";
			tbody.style.height = "80px";
		}
		if (isIE == "7" && document.documentMode > "7") {
			divId4.style.height = "150px";
			divId4.style.marginBottom = "20px";
		}
		if (isIE != "7" && document.documentMode == "7") {
			ol.style.marginLeft = "0px";
			ol.style.paddingBottom = "10px";
			div.style.marginTop = "20px";
			tbody.style.height = "80px";
			divId2.style.marginBottom = "-23px";
		}
		if (isIE == "7" && document.documentMode == "7") {
			divId4.style.marginTop = "20px";
			divId4.style.marginBottom = "30px";
		}
	}
</script>
</head>
<body>
	<table id="excel" class="div">
		<tr>
			<td style="border: solid 0px #000000;">
				<div class="div" id="divId">
					<h2 style="text-align: center;">${requestScope.year}年${requestScope.tj}月助产机构分娩记录统计表</h2>
				</div>
				<table id="tableId" width="100%" cellspacing="0" cellpadding="2">
					<colgroup>
						<col style="width: 60px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 60px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
					</colgroup>
					<tbody class="tbodyClass1">
						<tr class="trClass1">
							<td>单位</td>
							<td>月</td>
							<td>男</td>
							<td>女</td>
							<td>有证</td>
							<td>无证</td>
							<td>单位</td>
							<td>月</td>
							<td>男</td>
							<td>女</td>
							<td>有证</td>
							<td>无证</td>
						</tr>
						<c:if test="${!empty requestScope.listDeliveryTemp}">
							<c:forEach items="${requestScope.listDeliveryTemp}"
								var="listDeliveryTemp" varStatus="i">
								<tr class="trClass1">
									<td>${listDeliveryTemp.institonZh}</td>
									<td>${listDeliveryTemp.t04}</td>
									<td>${listDeliveryTemp.t09 + listDeliveryTemp.t13}</td>
									<td>${listDeliveryTemp.t10 + listDeliveryTemp.t14}</td>
									<td>${listDeliveryTemp.t07}</td>
									<td>${listDeliveryTemp.t06}</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty requestScope.listDeliveryTemp}">
							<tr class="trClass1" height="22px">
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
						<tr class="trClass1">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>合计</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="trClass1">
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
					</tbody>
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