<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分娩信息登记本</title>
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

@media print {
	.Noprint {
		display: none;
	}
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
	mso-number-format: "\@";
	text-align: general;
	vertical-align: middle;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}
</style>
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
</head>
<body>

	<table id="excel">
		<tr>
			<td>河南省分娩登记</td>
		</tr>
		<tr>
			<td>


				<table id="fm" align="center" width="3000" cellspacing="0"
					cellpadding="0" style="text-align: center">
					<tr>
						<td rowspan="4" nowrap="nowrap">序号</td>
						<td rowspan="4" nowrap="nowrap">助产机构名称</td>
						<td colspan="21">孕产妇基本情况</td>
						<td colspan="21">分娩情况</td>
						<td colspan="28">婴儿情况</td>
						<td colspan="2" nowrap="nowrap">并发症、合并症及死因</td>
						<td rowspan="4" nowrap="nowrap">孕产妇死亡</td>
						<td rowspan="4" nowrap="nowrap">接生者</td>
						<td colspan="9">产妇其他情况</td>
						<td colspan="6">丈夫情况</td>
						<td colspan="7">孕产妇感染</td>
					</tr>
					<tr>
						<td rowspan="3">分娩日期</td>
						<td rowspan="3" nowrap="nowrap">住院号</td>
						<td rowspan="3">产妇姓名</td>
						<td rowspan="3" nowrap="nowrap">文化程度</td>
						<td rowspan="3">年龄</td>
						<td rowspan="3" nowrap="nowrap">职业</td>
						<td rowspan="3" nowrap="nowrap">民族</td>
						<td colspan="2" nowrap="nowrap">家族史</td>
						<td rowspan="3">末次月经</td>
						<td rowspan="3">建卡日期</td>
						<td rowspan="3" nowrap="nowrap">建卡<br />孕周
						</td>
						<td colspan="2" nowrap="nowrap">孕产保健</td>
						<td colspan="2">高危孕产妇</td>
						<td rowspan="3">乙肝表面抗原</td>
						<td rowspan="3" nowrap="nowrap">孕次</td>
						<td rowspan="3" nowrap="nowrap">产次</td>
						<td rowspan="3" nowrap="nowrap">孕周</td>
						<td rowspan="3" nowrap="nowrap">胎位</td>

						<td rowspan="3">分娩时间</td>
						<td colspan="2" nowrap="nowrap">引产</td>
						<td colspan="4">分娩方式</td>
						<td rowspan="3" nowrap="nowrap">剖宫产指征</td>
						<td colspan="4">产程时间</td>
						<td colspan="2" nowrap="nowrap">胎盘</td>
						<td colspan="2" nowrap="nowrap">会阴</td>
						<td colspan="3" nowrap="nowrap">出血量(ml)</td>
						<td colspan="2" nowrap="nowrap">羊水</td>

						<td colspan="3" nowrap="nowrap">性别</td>
						<td colspan="2" nowrap="nowrap">评分</td>
						<td rowspan="3">出生体重(g)</td>
						<td rowspan="3" nowrap="nowrap">身长(cm)</td>
						<td rowspan="3" nowrap="nowrap">卡介苗</td>
						<td rowspan="3" nowrap="nowrap">乙肝疫苗</td>
						<td rowspan="3" nowrap="nowrap">早吸吮</td>
						<td rowspan="3" nowrap="nowrap">死胎</td>
						<td rowspan="3" nowrap="nowrap">死产</td>
						<td rowspan="3">七天内死亡</td>
						<td colspan="5" nowrap="nowrap">胎数</td>
						<td colspan="4" nowrap="nowrap">胎儿畸形</td>
						<td colspan="6">出生医学证明</td>

						<td rowspan="3" nowrap="nowrap">产妇</td>
						<td rowspan="3" nowrap="nowrap">婴儿</td>


						<td rowspan="3">身份证号</td>
						<td rowspan="3" nowrap="nowrap">现住地址</td>
						<td rowspan="3" nowrap="nowrap">户口地址</td>
						<td rowspan="3" nowrap="nowrap">生育证</td>
						<td rowspan="3" nowrap="nowrap">联系电话</td>
						<td colspan="2" nowrap="nowrap">孕妇户籍</td>
						<td colspan="2" nowrap="nowrap">孕妇户口</td>

						<td rowspan="3" nowrap="nowrap">姓名</td>
						<td rowspan="3" nowrap="nowrap">年龄</td>
						<td rowspan="3" nowrap="nowrap">名族</td>
						<td rowspan="3" nowrap="nowrap">身份证号</td>
						<td rowspan="3" nowrap="nowrap">现住地址</td>
						<td rowspan="3" nowrap="nowrap">国籍</td>

						<td rowspan="3">孕期是否检测艾滋病</td>
						<td rowspan="3">孕期是否检梅毒</td>
						<td rowspan="3">孕期是否检乙肝表面抗原</td>
						<td rowspan="3">是否感染艾滋病</td>
						<td rowspan="3">是否梅毒感染</td>
						<td rowspan="3">是否血红蛋白检测</td>
						<td rowspan="3">是否重度贫血</td>
					</tr>
					<tr>
						<td rowspan="2" nowrap="nowrap">遗传疾病</td>
						<td rowspan="2" nowrap="nowrap">近亲<br />结婚
						</td>
						<td rowspan="2">≥5</td>
						<td rowspan="2">≥1</td>
						<td rowspan="2">是</td>
						<td rowspan="2">否</td>

						<td rowspan="2">计划内治疗</td>
						<td rowspan="2">计划外</td>
						<td rowspan="2">平产</td>
						<td rowspan="2">剖宫产</td>
						<td rowspan="2">臀产</td>
						<td rowspan="2">其他</td>
						<td rowspan="2">总产程</td>
						<td rowspan="2">第一产程</td>
						<td rowspan="2">第二产程</td>
						<td rowspan="2">第三产程</td>
						<td rowspan="2">完整</td>
						<td rowspan="2">残留</td>
						<td rowspan="2">侧切</td>
						<td rowspan="2" nowrap="nowrap">裂伤<br />分度
						</td>
						<td rowspan="2">总出血量</td>
						<td rowspan="2">产时</td>
						<td rowspan="2">产后2小时</td>
						<td rowspan="2">性状</td>
						<td rowspan="2">羊水量</td>

						<td rowspan="2">男</td>
						<td rowspan="2">女</td>
						<td rowspan="2">不明</td>
						<td rowspan="2">1分钟</td>
						<td rowspan="2">5分钟</td>
						<td rowspan="2">单胎</td>
						<td colspan="2">双胎</td>
						<td colspan="2">三胎及以上</td>
						<td rowspan="2">单发</td>
						<td rowspan="2">多发</td>
						<td rowspan="2">畸形种类部位</td>
						<td rowspan="2">畸形名称</td>
						<td rowspan="2">婴儿姓名</td>
						<td rowspan="2">编号</td>
						<td rowspan="2" nowrap="nowrap">签发机构</td>
						<td rowspan="2" nowrap="nowrap">签发人员</td>
						<td rowspan="2" nowrap="nowrap">领证人员</td>
						<td rowspan="2" nowrap="nowrap">签发日期</td>

						<td rowspan="2">本地</td>
						<td rowspan="2">非本地</td>
						<td rowspan="2">农业</td>
						<td rowspan="2">非农业</td>
					</tr>

					<tr>
						<td>同卵</td>
						<td>异卵</td>
						<td>同卵</td>
						<td>异卵</td>
					</tr>

					<c:forEach items="${requestScope.vd601s}" var="vd601" varStatus="i">
						<tr>
							<td nowrap="nowrap">${i.count}</td>
							<td nowrap="nowrap">${vd601.d60102ZH}</td>
							<td nowrap="nowrap">${vd601.d60103}</td>
							<td nowrap="nowrap">${vd601.d60104}</td>
							<td nowrap="nowrap">${vd601.d60105}</td>
							<td nowrap="nowrap">${vd601.d60106ZH}</td>
							<td nowrap="nowrap">${vd601.d60107}</td>
							<td nowrap="nowrap">${vd601.d60108ZH}</td>
							<td nowrap="nowrap">${vd601.d60109ZH}</td>
							<td nowrap="nowrap">${vd601.d60110}</td>
							<td nowrap="nowrap">${vd601.d60111ZH}</td>
							<td nowrap="nowrap">${vd601.d60112}</td>
							<td nowrap="nowrap">${vd601.d60113}</td>
							<td nowrap="nowrap">${vd601.d60114}</td>
							<c:choose>
								<c:when test="${vd601.d60116 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60116 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60117 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60117 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>

							<td nowrap="nowrap">${vd601.d60118ZH}</td>
							<td nowrap="nowrap">${vd601.d60119}</td>
							<td nowrap="nowrap">${vd601.d60120}</td>
							<td nowrap="nowrap">${vd601.d60121}</td>
							<td nowrap="nowrap">${vd601.d60123ZH}</td>
							<td>${vd601.d60124}</td>
							<c:choose>
								<c:when test="${vd601.d60125 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60125 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60126 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60126 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60126 == 3}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60126 == 4}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<td nowrap="nowrap">${vd601.d60127}</td>
							<td nowrap="nowrap">${vd601.d60128}</td>
							<td nowrap="nowrap">${vd601.d60129}</td>
							<td nowrap="nowrap">${vd601.d60130}</td>
							<td nowrap="nowrap">${vd601.d60131}</td>
							<c:choose>
								<c:when test="${vd601.d60132 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60132 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<td>${vd601.d60133ZH}</td>
							<td nowrap="nowrap">${vd601.d60134ZH}</td>
							<td nowrap="nowrap">${vd601.d60135}</td>
							<td nowrap="nowrap">${vd601.d60136}</td>
							<td nowrap="nowrap">${vd601.d60137}</td>
							<td nowrap="nowrap">${vd601.d60138ZH}</td>
							<td nowrap="nowrap">${vd601.d60139}</td>
							<c:choose>
								<c:when test="${vd601.d60140 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60140 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60140 == 3}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<td nowrap="nowrap">${vd601.d60141}</td>
							<td nowrap="nowrap">${vd601.d60142}</td>
							<td nowrap="nowrap">${vd601.d60143}</td>
							<td nowrap="nowrap">${vd601.d60144}</td>
							<td nowrap="nowrap">${vd601.d60145ZH}</td>
							<td nowrap="nowrap">${vd601.d60146ZH}</td>
							<td nowrap="nowrap">${vd601.d60147ZH}</td>
							<c:choose>
								<c:when test="${vd601.d60148 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60148 == 3}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60148 == 4}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60151 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60151 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60151 == 3}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60151 == 4}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60151 == 5}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60152 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60152 == 3}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<td nowrap="nowrap">${vd601.d60153}</td>
							<td nowrap="nowrap">${vd601.d60154}</td>
							<td nowrap="nowrap">${vd601.d60155}</td>
							<td nowrap="nowrap">${vd601.d60156}</td>
							<td nowrap="nowrap">${vd601.d60157ZH}</td>
							<td nowrap="nowrap">${vd601.d60158}</td>
							<td nowrap="nowrap">${vd601.d60159}</td>
							<td nowrap="nowrap">${vd601.d60160}</td>
							<td nowrap="nowrap">${vd601.d60161}</td>
							<td nowrap="nowrap">${vd601.d60162}</td>
							<td nowrap="nowrap">${vd601.d60163}</td>
							<td nowrap="nowrap">${vd601.d60164}</td>
							<td nowrap="nowrap" class="txt">${vd601.d60165}</td>
							<td nowrap="nowrap">${vd601.d60166ZH}</td>
							<td nowrap="nowrap">${vd601.d60167}</td>
							<td nowrap="nowrap">${vd601.d60168ZH}</td>
							<td nowrap="nowrap">${vd601.d60169}</td>
							<c:choose>
								<c:when test="${vd601.d60170 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60170 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60171 == 1}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd601.d60171 == 2}">
									<td nowrap="nowrap">√</td>
								</c:when>
								<c:otherwise>
									<td nowrap="nowrap">&nbsp;</td>
								</c:otherwise>
							</c:choose>

							<td nowrap="nowrap">${vd601.d60172}</td>
							<td nowrap="nowrap">${vd601.d60173}</td>
							<td nowrap="nowrap">${vd601.d60174ZH}</td>
							<td nowrap="nowrap">${vd601.d60175}</td>
							<td nowrap="nowrap">${vd601.d60176}</td>
							<td nowrap="nowrap">${vd601.d60177ZH}</td>
							<td nowrap="nowrap">${vd601.d60178ZH}</td>
							<td nowrap="nowrap">${vd601.d60179ZH}</td>
							<td nowrap="nowrap">${vd601.d60180ZH}</td>
							<td nowrap="nowrap">${vd601.d60181ZH}</td>
							<td nowrap="nowrap">${vd601.d60182ZH}</td>
							<td nowrap="nowrap">${vd601.d60183ZH}</td>
							<td nowrap="nowrap">${vd601.d60184ZH}</td>

						</tr>
					</c:forEach>

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