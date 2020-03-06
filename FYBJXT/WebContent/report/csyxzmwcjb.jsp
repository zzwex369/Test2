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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>围产儿数季报表</title>
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
	height: 43px;
	text-align: center;
}

tr td {
	border: solid 1px #000000;
	font-size: 13px;
	line-height: 18px;
	valign: middle;
	width: 910px
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
					<h2 style="text-align: center;">围产儿数季报表</h2>
					<p style="width: 100%; text-align: center;">${year}&nbsp;年第${quarter}&nbsp;季度
					</p>
					<span style="float: left;">${sheng}省${shi}市</span> <span
						style="padding-left: 60px">${quXian}区县</span> <span
						style="padding-left: 120px">${institutionName}医院（保健院、所）</span> <span
						style="padding-left: 40px">医院编码：${institution}</span>
				</div>
				<table id="tableId" width="100%" cellspacing="0" cellpadding="2">
					<colgroup>
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 50px">
						<col style="width: 70px">
						<col style="width: 70px">
					</colgroup>
					<tbody class="tbodyClass1">
						<c:if test="${!empty requestScope.listDeliveryTemp}">
							<c:forEach items="${requestScope.listDeliveryTemp}"
								var="listDeliveryTemp" varStatus="i">
								<tr class="trClass1">
									<td rowspan="2">月份</td>
									<td rowspan="2">产妇年龄（岁）</td>
									<td colspan="3">城镇（例）</td>
									<td colspan="3">乡村（例）</td>
									<td rowspan="2">合计</td>
									<td colspan="2">围产儿情况</td>
									<td>城镇（例）</td>
									<td>乡村（例）</td>
								</tr>
								<tr class="trClass1">
									<td>男</td>
									<td>女</td>
									<td>性别不明</td>
									<td>男</td>
									<td>女</td>
									<td>性别不明</td>
									<td colspan="2">出生缺陷</td>
									<td>${listDeliveryTemp.t51}</td>
									<td>${listDeliveryTemp.t52}</td>
								</tr>
								<tr class="trClass1">
									<td rowspan="6">${listDeliveryTemp.t04}</td>
									<td>小于20</td>
									<td>${listDeliveryTemp.t10}</td>
									<td>${listDeliveryTemp.t11}</td>
									<td>${listDeliveryTemp.t12}</td>
									<td>${listDeliveryTemp.t13}</td>
									<td>${listDeliveryTemp.t14}</td>
									<td>${listDeliveryTemp.t15}</td>
									<td>${listDeliveryTemp.t40}</td>
									<td rowspan="4">围产儿死亡</td>
									<td rowspan="2">死胎死产</td>
									<td rowspan="2">${listDeliveryTemp.t53}</td>
									<td rowspan="2">${listDeliveryTemp.t54}</td>
								</tr>
								<tr class="trClass1">
									<td>20~</td>
									<td>${listDeliveryTemp.t16}</td>
									<td>${listDeliveryTemp.t17}</td>
									<td>${listDeliveryTemp.t18}</td>
									<td>${listDeliveryTemp.t19}</td>
									<td>${listDeliveryTemp.t20}</td>
									<td>${listDeliveryTemp.t21}</td>
									<td>${listDeliveryTemp.t41}</td>
								</tr>
								<tr class="trClass1">
									<td>25~</td>
									<td>${listDeliveryTemp.t22}</td>
									<td>${listDeliveryTemp.t23}</td>
									<td>${listDeliveryTemp.t24}</td>
									<td>${listDeliveryTemp.t25}</td>
									<td>${listDeliveryTemp.t26}</td>
									<td>${listDeliveryTemp.t27}</td>
									<td>${listDeliveryTemp.t42}</td>
									<td>7天内死亡</td>
									<td>${listDeliveryTemp.t55}</td>
									<td>${listDeliveryTemp.t56}</td>
								</tr>
								<tr class="trClass1">
									<td>30~</td>
									<td>${listDeliveryTemp.t28}</td>
									<td>${listDeliveryTemp.t29}</td>
									<td>${listDeliveryTemp.t30}</td>
									<td>${listDeliveryTemp.t31}</td>
									<td>${listDeliveryTemp.t32}</td>
									<td>${listDeliveryTemp.t33}</td>
									<td>${listDeliveryTemp.t43}</td>
									<td>合计</td>
									<td>${listDeliveryTemp.t57 + listDeliveryTemp.t51}</td>
									<td>${listDeliveryTemp.t58 + listDeliveryTemp.t52}</td>
								</tr>
								<tr class="trClass1">
									<td>35~</td>
									<td>${listDeliveryTemp.t34}</td>
									<td>${listDeliveryTemp.t35}</td>
									<td>${listDeliveryTemp.t36}</td>
									<td>${listDeliveryTemp.t37}</td>
									<td>${listDeliveryTemp.t38}</td>
									<td>${listDeliveryTemp.t39}</td>
									<td>${listDeliveryTemp.t44}</td>
									<td rowspan="2">胎数</td>
									<td>双胎</td>
									<td colspan="2">三胎及以上</td>
								</tr>
								<tr class="trClass1">
									<td>合计</td>
									<td>${listDeliveryTemp.t45}</td>
									<td>${listDeliveryTemp.t46}</td>
									<td>${listDeliveryTemp.t47}</td>
									<td>${listDeliveryTemp.t48}</td>
									<td>${listDeliveryTemp.t49}</td>
									<td>${listDeliveryTemp.t50}</td>
									<td>${listDeliveryTemp.t64}</td>
									<td>${listDeliveryTemp.t59}（胞）</td>
									<td colspan="2">${listDeliveryTemp.t60}（胞）</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty requestScope.listDeliveryTemp}">
							<tr class="trClass1">
								<td rowspan="2">月份</td>
								<td rowspan="2">产妇年龄（岁）</td>
								<td colspan="3">城镇（例）</td>
								<td colspan="3">乡村（例）</td>
								<td rowspan="2">合计</td>
								<td colspan="2">围产儿情况</td>
								<td>城镇（例）</td>
								<td>乡村（例）</td>
							</tr>
							<tr class="trClass1">
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td colspan="2">出生缺陷</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td rowspan="6"></td>
								<td>小于20</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="4">围产儿死亡</td>
								<td rowspan="2">死胎死产</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
							</tr>
							<tr class="trClass1">
								<td>20~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>25~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>7天内死亡</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>30~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>合计</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>35~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="2">胎数</td>
								<td>双胎</td>
								<td colspan="2">三胎及以上</td>
							</tr>
							<tr class="trClass1">
								<td>合计</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>（胞）</td>
								<td colspan="2">（胞）</td>
							</tr>

							<tr class="trClass1">
								<td rowspan="2">月份</td>
								<td rowspan="2">产妇年龄（岁）</td>
								<td colspan="3">城镇（例）</td>
								<td colspan="3">乡村（例）</td>
								<td rowspan="2">合计</td>
								<td colspan="2">围产儿情况</td>
								<td>城镇（例）</td>
								<td>乡村（例）</td>
							</tr>
							<tr class="trClass1">
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td colspan="2">出生缺陷</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td rowspan="6"></td>
								<td>小于20</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="4">围产儿死亡</td>
								<td rowspan="2">死胎死产</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
							</tr>
							<tr class="trClass1">
								<td>20~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>25~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>7天内死亡</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>30~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>合计</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>35~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="2">胎数</td>
								<td>双胎</td>
								<td colspan="2">三胎及以上</td>
							</tr>
							<tr class="trClass1">
								<td>合计</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>（胞）</td>
								<td colspan="2">（胞）</td>
							</tr>

							<tr class="trClass1">
								<td rowspan="2">月份</td>
								<td rowspan="2">产妇年龄（岁）</td>
								<td colspan="3">城镇（例）</td>
								<td colspan="3">乡村（例）</td>
								<td rowspan="2">合计</td>
								<td colspan="2">围产儿情况</td>
								<td>城镇（例）</td>
								<td>乡村（例）</td>
							</tr>
							<tr class="trClass1">
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td>男</td>
								<td>女</td>
								<td>性别不明</td>
								<td colspan="2">出生缺陷</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td rowspan="6"></td>
								<td>小于20</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="4">围产儿死亡</td>
								<td rowspan="2">死胎死产</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
							</tr>
							<tr class="trClass1">
								<td>20~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>25~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>7天内死亡</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>30~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>合计</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="trClass1">
								<td>35~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td rowspan="2">胎数</td>
								<td>双胎</td>
								<td colspan="2">三胎及以上</td>
							</tr>
							<tr class="trClass1">
								<td>合计</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>（胞）</td>
								<td colspan="2">（胞）</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<div class="div" style="padding-top: 20px">
					<span style="float: left;">填 表 人：</span> <span
						style="padding-left: 235px">职称：</span> <span
						style="padding-left: 208px">填表日期：</span>
				</div>
				<div class="div" style="padding-top: 20px">
					<span style="float: left;">医院审表人：</span> <span
						style="padding-left: 210px">职称：</span> <span
						style="padding-left: 210px">填表日期：</span>
				</div>
				<div class="div" style="padding-top: 20px">
					<span style="float: left;">省级审表人：</span> <span
						style="padding-left: 210px">职称：</span> <span
						style="padding-left: 210px">填表日期：</span>
				</div>
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
