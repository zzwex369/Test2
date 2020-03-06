<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>永城市各县区统计</title>
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
}
</style>
</head>
<body>
	<table id="excel" class="div">
		<tr>
			<td style="text-align: center;"><h2 style="text-align: center;">永城市各县区统计数字</h2></td>
		</tr>
		<tr>
			<td>
				<table id="fm" align="center" width="3000" cellpadding="0"
					cellspacing="0" style="text-align: center">
					<tr>
						<td rowspan="3">医疗机构</td>
						<td rowspan="3">月份</td>
						<td colspan="4">各县区活产总数统计</td>
						<td colspan="40">其中筛查后属于各区县户籍数</td>
					</tr>
					<tr>
						<td rowspan="2">活产总数</td>
						<td rowspan="2">活产男婴总数</td>
						<td rowspan="2">活产女婴总数</td>
						<td rowspan="2">性别不明总数</td>
						<td colspan="4">梁园区</td>
						<td colspan="4">宁陵县</td>
						<td colspan="4">睢阳区</td>
						<td colspan="4">民权县</td>
						<td colspan="4">睢县</td>
						<td colspan="4">柘城县</td>
						<td colspan="4">虞城县</td>
						<td colspan="4">夏邑县</td>
						<td colspan="4">永城</td>
						<td colspan="4">其他</td>
					</tr>
					<tr>
						<td>总数<br /></td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
						<td>总数</td>
						<td>男</td>
						<td>女</td>
						<td>不明</td>
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
						<c:forEach items="${requestScope.listDeliveryTemp}" var="listDeliveryTemp" varStatus="i">
							<tr>
								<!-- 医院 -->
								<td>${listDeliveryTemp.institonZh}</td>
								<!-- 月份 -->
								<td>${listDeliveryTemp.t04}</td>
								<!-- 各县区活产总数统计    1活产总数   2男  3女   4不明 -->
								<td>${listDeliveryTemp.t08}</td>
								<td>${listDeliveryTemp.t09}</td>
								<td>${listDeliveryTemp.t10}</td>
								<td>${listDeliveryTemp.t11}</td>
								<!--梁园区-->
								<td>${listDeliveryTemp.t15}</td>
								<td>${listDeliveryTemp.t16}</td>
								<td>${listDeliveryTemp.t17}</td>
								<td>${listDeliveryTemp.t18}</td>
								<!--宁陵县-->
								<td>${listDeliveryTemp.t19}</td>
								<td>${listDeliveryTemp.t20}</td>
								<td>${listDeliveryTemp.t21}</td>
								<td>${listDeliveryTemp.t22}</td>
								<!--睢阳区-->
								<td>${listDeliveryTemp.t23}</td>
								<td>${listDeliveryTemp.t24}</td>
								<td>${listDeliveryTemp.t25}</td>
								<td>${listDeliveryTemp.t26}</td>
								<!--民权县-->
								<td>${listDeliveryTemp.t27}</td>
								<td>${listDeliveryTemp.t28}</td>
								<td>${listDeliveryTemp.t29}</td>
								<td>${listDeliveryTemp.t30}</td>
								<!--睢县-->
								<td>${listDeliveryTemp.t31}</td>
								<td>${listDeliveryTemp.t32}</td>
								<td>${listDeliveryTemp.t33}</td>
								<td>${listDeliveryTemp.t34}</td>
								<!--柘城县-->
								<td>${listDeliveryTemp.t35}</td>
								<td>${listDeliveryTemp.t36}</td>
								<td>${listDeliveryTemp.t37}</td>
								<td>${listDeliveryTemp.t38}</td>
								<!--虞城县-->
								<td>${listDeliveryTemp.t39}</td>
								<td>${listDeliveryTemp.t40}</td>
								<td>${listDeliveryTemp.t41}</td>
								<td>${listDeliveryTemp.t42}</td>
								<!--夏邑县-->
								<td>${listDeliveryTemp.t43}</td>
								<td>${listDeliveryTemp.t44}</td>
								<td>${listDeliveryTemp.t45}</td>
								<td>${listDeliveryTemp.t46}</td>
								<!--永城-->
								<td>${listDeliveryTemp.t47}</td>
								<td>${listDeliveryTemp.t48}</td>
								<td>${listDeliveryTemp.t49}</td>
								<td>${listDeliveryTemp.t50}</td>
								<!--其他-->
								<td>${listDeliveryTemp.t51}</td>
								<td>${listDeliveryTemp.t52}</td>
								<td>${listDeliveryTemp.t53}</td>
								<td>${listDeliveryTemp.t54}</td>
							</tr>
						</c:forEach>
						<tr>
								<!-- 医院 -->
								<td>合计</td>
								<!-- 月份 -->
								<td></td>
								<!-- 各县区活产总数统计    1活产总数   2男  3女   4不明 -->
								<td>${requestScope.deliveryTemp.t08}</td>
								<td>${requestScope.deliveryTemp.t09}</td>
								<td>${requestScope.deliveryTemp.t10}</td>
								<td>${requestScope.deliveryTemp.t11}</td>
								<!--梁园区-->
								<td>${requestScope.deliveryTemp.t15}</td>
								<td>${requestScope.deliveryTemp.t16}</td>
								<td>${requestScope.deliveryTemp.t17}</td>
								<td>${requestScope.deliveryTemp.t18}</td>
								<!--宁陵县-->
								<td>${requestScope.deliveryTemp.t19}</td>
								<td>${requestScope.deliveryTemp.t20}</td>
								<td>${requestScope.deliveryTemp.t21}</td>
								<td>${requestScope.deliveryTemp.t22}</td>
								<!--睢阳区-->
								<td>${requestScope.deliveryTemp.t23}</td>
								<td>${requestScope.deliveryTemp.t24}</td>
								<td>${requestScope.deliveryTemp.t25}</td>
								<td>${requestScope.deliveryTemp.t26}</td>
								<!--民权县-->
								<td>${requestScope.deliveryTemp.t27}</td>
								<td>${requestScope.deliveryTemp.t28}</td>
								<td>${requestScope.deliveryTemp.t29}</td>
								<td>${requestScope.deliveryTemp.t30}</td>
								<!--睢县-->
								<td>${requestScope.deliveryTemp.t31}</td>
								<td>${requestScope.deliveryTemp.t32}</td>
								<td>${requestScope.deliveryTemp.t33}</td>
								<td>${requestScope.deliveryTemp.t34}</td>
								<!--柘城县-->
								<td>${requestScope.deliveryTemp.t35}</td>
								<td>${requestScope.deliveryTemp.t36}</td>
								<td>${requestScope.deliveryTemp.t37}</td>
								<td>${requestScope.deliveryTemp.t38}</td>
								<!--虞城县-->
								<td>${requestScope.deliveryTemp.t39}</td>
								<td>${requestScope.deliveryTemp.t40}</td>
								<td>${requestScope.deliveryTemp.t41}</td>
								<td>${requestScope.deliveryTemp.t42}</td>
								<!--夏邑县-->
								<td>${requestScope.deliveryTemp.t43}</td>
								<td>${requestScope.deliveryTemp.t44}</td>
								<td>${requestScope.deliveryTemp.t45}</td>
								<td>${requestScope.deliveryTemp.t46}</td>
								<!--永城-->
								<td>${requestScope.deliveryTemp.t47}</td>
								<td>${requestScope.deliveryTemp.t48}</td>
								<td>${requestScope.deliveryTemp.t49}</td>
								<td>${requestScope.deliveryTemp.t50}</td>
								<!--其他-->
								<td>${requestScope.deliveryTemp.t51}</td>
								<td>${requestScope.deliveryTemp.t52}</td>
								<td>${requestScope.deliveryTemp.t53}</td>
								<td>${requestScope.deliveryTemp.t54}</td>
							</tr>
					</c:if>
					<c:if test="${empty requestScope.listDeliveryTemp}">
						<tr height="22px">
							<!-- 医院 -->
							<td></td>
							<!-- 月份 -->
							<td></td>
							<!-- 各县区活产总数统计    1活产总数   2男  3女   4不明 -->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--梁园区-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--宁陵县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--睢阳区-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--民权县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--睢县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--柘城县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--虞城县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--夏邑县-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--永城-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--其他-->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
						<td colspan="2">合计：</td>
						<!-- 各县区活产总数统计    1活产总数   2男  3女   4不明 -->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--梁园区  1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--宁陵县  1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--睢阳区 1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--民权县 1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!-- 睢县  1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!-- 柘城县  1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!-- 虞城县 1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!-- 夏邑县 1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--永城  1活产总数   2男  3女   4不明-->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--其他  1活产总数   2男  3女   4不明-->
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