<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>围产儿数季报表</title>
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
</style>
</head>

<body>
	<table id="excel">
		<tr>
			<td style="text-align: center;"><h2 style="text-align: center;">围产儿数季报表</h2></td>
		</tr>
		<tr>
			<td>
				<table id="fm" align="center" width="4104" cellpadding="0"
					cellspacing="0" style="text-align: center">
					<tr>
						<td rowspan="3" nowrap="nowrap">医院名称
							${requestScope.ErrorMessage}</td>
						<td rowspan="3" nowrap="nowrap">报表月份</td>
						<td colspan="7" nowrap="nowrap">年龄&lt;20岁产妇分娩儿童数</td>
						<td colspan="7" nowrap="nowrap">20-&lt;25岁产妇分娩儿童数</td>
						<td colspan="7" nowrap="nowrap">25-&lt;30岁产妇分娩儿童数</td>
						<td colspan="7" nowrap="nowrap">30-&lt;35岁产妇分娩儿童数</td>
						<td colspan="7" nowrap="nowrap">年龄&gt;=35岁产妇分娩儿童数</td>
						<td colspan="12">围产儿情况</td>
						<td colspan="6" rowspan="2">填报情况</td>
					</tr>
					<tr>
						<td colspan="3">城镇</td>
						<td colspan="3">乡村</td>
						<td rowspan="2">合计</td>
						<td colspan="3">城镇</td>
						<td colspan="3">乡村</td>
						<td rowspan="2">合计</td>
						<td colspan="3">城镇</td>
						<td colspan="3">乡村</td>
						<td rowspan="2">合计</td>
						<td colspan="3">城镇</td>
						<td colspan="3">乡村</td>
						<td rowspan="2">合计</td>
						<td colspan="3">城镇</td>
						<td colspan="3">乡村</td>
						<td rowspan="2">合计</td>
						<td colspan="2">出生缺陷</td>
						<td colspan="2">死胎</td>
						<td colspan="2">死产</td>
						<td colspan="2">7天内死亡</td>
						<td colspan="2">死亡合计</td>
						<td colspan="2">多胎数</td>
					</tr>
					<tr>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>男</td>
						<td>女</td>
						<td>性别不明</td>
						<td>城镇</td>
						<td>乡村</td>
						<td>城镇</td>
						<td>乡村</td>
						<td>城镇</td>
						<td>乡村</td>
						<td>城镇</td>
						<td>乡村</td>
						<td>城镇</td>
						<td>乡村</td>
						<td>双胎</td>
						<td>三胎及以上</td>
						<td>填表单位</td>
						<td>填表人</td>
						<td>填表时间</td>
						<td>录入单位</td>
						<td>录入人</td>
						<td>录入时间</td>
					</tr>

					<c:if test="${!empty requestScope.listDeliveryTemp}">
						<c:forEach items="${requestScope.listDeliveryTemp}" var="listDeliveryTemp" varStatus="i">
							<tr>
								<td>${listDeliveryTemp.institonZh}</td>
								<td>${listDeliveryTemp.t04}</td>
								<td>${listDeliveryTemp.t10}</td>
								<td>${listDeliveryTemp.t11}</td>
								<td>${listDeliveryTemp.t12}</td>
								<td>${listDeliveryTemp.t13}</td>
								<td>${listDeliveryTemp.t14}</td>
								<td>${listDeliveryTemp.t15}</td>
								<td>${listDeliveryTemp.t40}</td>
								<td>${listDeliveryTemp.t16}</td>
								<td>${listDeliveryTemp.t17}</td>
								<td>${listDeliveryTemp.t18}</td>
								<td>${listDeliveryTemp.t19}</td>
								<td>${listDeliveryTemp.t20}</td>
								<td>${listDeliveryTemp.t21}</td>
								<td>${listDeliveryTemp.t41}</td>
								<td>${listDeliveryTemp.t22}</td>
								<td>${listDeliveryTemp.t23}</td>
								<td>${listDeliveryTemp.t24}</td>
								<td>${listDeliveryTemp.t25}</td>
								<td>${listDeliveryTemp.t26}</td>
								<td>${listDeliveryTemp.t27}</td>
								<td>${listDeliveryTemp.t42}</td>
								<td>${listDeliveryTemp.t28}</td>
								<td>${listDeliveryTemp.t29}</td>
								<td>${listDeliveryTemp.t30}</td>
								<td>${listDeliveryTemp.t31}</td>
								<td>${listDeliveryTemp.t32}</td>
								<td>${listDeliveryTemp.t33}</td>
								<td>${listDeliveryTemp.t43}</td>
								<td>${listDeliveryTemp.t34}</td>
								<td>${listDeliveryTemp.t35}</td>
								<td>${listDeliveryTemp.t36}</td>
								<td>${listDeliveryTemp.t37}</td>
								<td>${listDeliveryTemp.t38}</td>
								<td>${listDeliveryTemp.t39}</td>
								<td>${listDeliveryTemp.t44}</td>
								<td>${listDeliveryTemp.t51}</td>
								<td>${listDeliveryTemp.t52}</td>
								<td>${listDeliveryTemp.t65}</td>
								<td>${listDeliveryTemp.t66}</td>
								<td>${listDeliveryTemp.t67}</td>
								<td>${listDeliveryTemp.t68}</td>
								<td>${listDeliveryTemp.t55}</td>
								<td>${listDeliveryTemp.t56}</td>
								<td>${listDeliveryTemp.t57}</td>
								<td>${listDeliveryTemp.t58}</td>
								<td>${listDeliveryTemp.t59}</td>
								<td>${listDeliveryTemp.t60}</td>
								<td>${listDeliveryTemp.institonZh}</td>
								<td></td>
								<td></td>
								<td>${listDeliveryTemp.institonZh}</td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
						<tr>
								<td>合计</td>
								<td></td>
								<td>${requestScope.deliveryTemp.t10}</td>
								<td>${requestScope.deliveryTemp.t11}</td>
								<td>${requestScope.deliveryTemp.t12}</td>
								<td>${requestScope.deliveryTemp.t13}</td>
								<td>${requestScope.deliveryTemp.t14}</td>
								<td>${requestScope.deliveryTemp.t15}</td>
								<td>${requestScope.deliveryTemp.t40}</td>
								<td>${requestScope.deliveryTemp.t16}</td>
								<td>${requestScope.deliveryTemp.t17}</td>
								<td>${requestScope.deliveryTemp.t18}</td>
								<td>${requestScope.deliveryTemp.t19}</td>
								<td>${requestScope.deliveryTemp.t20}</td>
								<td>${requestScope.deliveryTemp.t21}</td>
								<td>${requestScope.deliveryTemp.t41}</td>
								<td>${requestScope.deliveryTemp.t22}</td>
								<td>${requestScope.deliveryTemp.t23}</td>
								<td>${requestScope.deliveryTemp.t24}</td>
								<td>${requestScope.deliveryTemp.t25}</td>
								<td>${requestScope.deliveryTemp.t26}</td>
								<td>${requestScope.deliveryTemp.t27}</td>
								<td>${requestScope.deliveryTemp.t42}</td>
								<td>${requestScope.deliveryTemp.t28}</td>
								<td>${requestScope.deliveryTemp.t29}</td>
								<td>${requestScope.deliveryTemp.t30}</td>
								<td>${requestScope.deliveryTemp.t31}</td>
								<td>${requestScope.deliveryTemp.t32}</td>
								<td>${requestScope.deliveryTemp.t33}</td>
								<td>${requestScope.deliveryTemp.t43}</td>
								<td>${requestScope.deliveryTemp.t34}</td>
								<td>${requestScope.deliveryTemp.t35}</td>
								<td>${requestScope.deliveryTemp.t36}</td>
								<td>${requestScope.deliveryTemp.t37}</td>
								<td>${requestScope.deliveryTemp.t38}</td>
								<td>${requestScope.deliveryTemp.t39}</td>
								<td>${requestScope.deliveryTemp.t44}</td>
								<td>${requestScope.deliveryTemp.t51}</td>
								<td>${requestScope.deliveryTemp.t52}</td>
								<td>${requestScope.deliveryTemp.t65}</td>
								<td>${requestScope.deliveryTemp.t66}</td>
								<td>${requestScope.deliveryTemp.t67}</td>
								<td>${requestScope.deliveryTemp.t68}</td>
								<td>${requestScope.deliveryTemp.t55}</td>
								<td>${requestScope.deliveryTemp.t56}</td>
								<td>${requestScope.deliveryTemp.t57}</td>
								<td>${requestScope.deliveryTemp.t58}</td>
								<td>${requestScope.deliveryTemp.t59}</td>
								<td>${requestScope.deliveryTemp.t60}</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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