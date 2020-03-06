<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<html lang="en">
<head>
<!--会强制浏览器按照最新的标准去渲染-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--强制用ie8标准模式-->
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>助产机构外出人员出生医学证明首次签发申请表</title>
<style type="text/css">
* {
	padding: 0; /*清空浏览器边距*/
	margin: 0;
}

body {
	font-family: '文泉驿正黑', '宋体'; /*统一浏览器字体*/
	padding: 0; /*清空浏览器边距*/
	margin: 0;
	/* overflow: auto;/*页面滚动条*/
}

.div {
	width: 1000px;
}

div { /*自动居中*/
	margin: auto;
	height: auto;
	text-align: center;
	zoom: 1;
}

#divId2 {
	width: 800px;
	margin: 20px auto;
}

#tableId { /* height:1032px;
          */
	margin: 8px auto;
}

#tableId2 tr {
	height: 30px;
}

table {
	width: 800px;
	align: center;
	/*white-space:nowrap;
            */
	border-collapse: collapse; /*边框合并*/
	table-layout:fixed;/*固定宽度*/
	cellspacing: "0"; /*指定相邻单元格边框的间距；*/
	cellpadding: "2"; /*指定表格单元格与内容之间的间距；*/
}

.trClass {
	height: 30px;
	border: none;
}

.trClass1 {
	height: 50px;
}

.trClass2 {
	height: 70px;
}

.trClass3 {
	height: 30px;
}

.trClass4 {
	height: 332px;
}

.trClass5 {
	border-bottom-width: 0px;
	height: 24px;
}

.trClass6 {
	height: 113px;
	border-bottom-width: 0px;
	border-top-width: 0px;
}

.trClass1 td {
	font-weight: bold;
}

.trClass5 td {
	font-weight: bold;
	border-bottom-width: 0px;
	padding-top: 5px;
}

.trClass6 td {
	padding-top: 10px;
	font-family: '宋体';
	border-bottom-width: 0px;
	border-top-width: 0px;
}

.trClass7 {
	text-align: left;
	height: 30px;
	border: none;
}

.trClass8 {
	text-align: left;
	height: 30px;
	border-right-width: 0px;
}

.trClass9 {
	height: 120px;
	border: none;
}

.trClass6 td .spanClass1 {
	padding-left: 23px;
	display: Inline-Block;
}

.trClass6 td .spanClass2 {
	padding-left: 5px;
	display: Inline-Block;
	padding: 5px 0px;
}

.trClass6 td .spanClass3 {
	display: Inline-Block;
	float: left;
	padding-left: 17px
}

.trClass6 td .spanClass4 {
	display: Inline-Block;
	padding: 10px 0px;;
}

.tdClass {
	vertical-align: top;
	padding-top: 8px;
}

.tdClass1 {
	text-align: left;
}

.tdClass2,.spanClass2 {
	padding-left: 120px;
}

.tdClass3 {
	line-height: 25px;
	border-left: solid 0px;
	border-top: solid 0px;
}

.tdClass4 {
	border-top: solid 0px;
}

.tdClass5 {
	border-top-width: 0px;
	border-right-width: 0px;
}

.tdClass6 {
	text-align: left;
	border-right-width: 0px;
}

.tdClass6 label {
	padding-left: 20px;
}

.tdClass6 label input,.input {
	margin-left: 5px;
}

.tdClass6 .span {
	width: 200px;
	border-bottom: 1px solid #333;
	display: Inline-Block;
	/*text-decoration: underline;
	*/margin-left: 10px;
	margin-top: 3px;
	vertical-align: bottom;
	margin-left: 0px;
	font-size:14px;
}

.tdClass7 {
	border-right-width: 0px;
}

.tdClass8 {
	line-height: 25px;
	border-left: solid 0px;
}

.tdClass9 {
	line-height: 25px;
	border-left: solid 0px;
	border-bottom-width: 0px;
}

.tdClass10 {
	border-bottom-width: 0px;
}

.tdClass11 {
	border-bottom-width: 0px;
	border-right-width: 0px;
}

.tdClass12 {
	text-align: right;
	border-top-width: 0px;
	border-right-width: 0px;
}

.tdClass13 {
	border-top-width: 0px;
	border-left-width: 0px;
}

.tdClass14 {
	text-align: left;
	padding-left: 20px;
	font-weight: bold;
}

.tdClass15 {
	text-align: center;
	line-height: 25px;
	border-left-width: 0px;
	border-top-width: 0px;
}

.tdClass16 {
	text-indent: 10px;
	border-top-width: 0px;
}

.tdClass17 {
	text-indent: 10px;
}

.tdClass18 {
	border-right-width: 0px;
}

.tdClass19 {
	font-size: 20px;
	border-bottom-width: 0px;
	border-left-width: 0px;
	border-right-width: 0px;
}

.tdClass13 span {
	padding-left: 40px;
}

#tdId1 span {
	padding-left: 18px;
}

tr,td {
	border: solid 1px #000000;
	font-size: 16px;
	vertical-align: middle; /*把此元素放置在父元素的中部。*/
	line-height: 18px; /*设置行高 浏览器统一*/
}

.label {
	cursor: pointer;
}

.label2 {
	padding-left: 50px;
}

.label3 {
	padding-left: 30px;
}

.spanClass {
	font-size: 12px;
}
/*   .label:hover{
        	background-color:#E2D8D8;
        }*/
.divClass3 {
	width: 800px;
	height: 120px;
}

.divClass3 ul {
	list-style-type: none;
	padding-left: 0px;
}

.divClass3 ul {
	list-style-type: none;
	padding-left: 0px;
}

.liClass {
	text-align: left;
	padding-left: 70px;
	padding-top: 10px;
}

.liClass1 {
	text-align: left;
	padding-left: 50px;
}

.liClass2 {
	text-align: left;
	padding-left: 60px;
	padding-top: 10px
}

.ie7 .span,.ie6 .span {
	width: 175px;
}

.ie8 table {
	white-space: normal;
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
	//console.log(isIE);
	//console.log(document.documentMode);//得到浏览器的文档模式  ..ie7 8 9 10 ...
	var cssStyle = document.compatMode;//得到浏览器的文档模式 俩种 CSS1Compat 标准    BackCompat  怪异模式
	///console.log(cssStyle)
	window.onload = function() {
		var table = document.getElementById("tableId");
		var table2 = document.getElementById("tableId2");
		var table3 = document.getElementById("tableId3");
		var div = document.getElementById("divId");
		var body = document.body;
		var divId2 = document.getElementById("divId2");
		var divId3 = document.getElementById("divId3");
		var divId4 = document.getElementById("divId4");
		var ol = document.getElementById("olId");
		if (cssStyle == 'BackCompat') {// CSS1Compat 标准    BackCompat  怪异模式
			div.style.paddingTop = "1px";
			table.style.textAlign = "center";
			table2.style.textAlign = "center";
			table3.style.textAlign = "center";
			table.style.whiteSpace = "normal";
			body.style.overflow = "auto";
		}
	}
</script>
</head>
<body>
	<center>
		<div class="div" id="divId">
			<div id="divId2">
				<h1>助产机构外出人员出生医学证明首次签发申请表</h1>
			</div>
			<table id="tableId"; class="table1" width="100%"; >
				<colgroup>
					<col style="width: 90px" />
					<col style="width: 110px" />
					<col style="width: 71px" />
					<col style="width: 71px" />
					<col style="width: 120px" />
					<col style="width: 338px" />
				</colgroup>
				<tr class="trClass1">
					<td colspan="6">分娩信息、婴儿姓名及其父母相关信息</td>
				</tr>
				<tr class="trClass2">
					<td class="tdClass">婴儿姓名<br /> <span class="spanClass">(应与亲子鉴<br />定证明一致)
					</span>
					</td>
					<td>${requestScope.vd307.d30702 }</td>
					<td>性别</td>
					<td>${requestScope.vd307.d30703Zh }</td>
					<td class="tdClass">出生时间<br /> <span class="spanClass">(应与出生情况说明<br />一致)
					</span></td>
					<td id="tdId1" class="tdClass1"><span>${requestScope.nian
							}年</span> <span>${requestScope.yue }月</span> <span>${requestScope.ri
							}日</span> <span>${requestScope.hourTime }时</span> <span>${requestScope.minuteTime
							}分</span></td>
				</tr>
				<tr class="trClass3">
					<td colspan="2">出生地点</td>
					<td colspan="4" class="tdClass1 tdClass2"><span>${requestScope.sheng }省</span> <span
						class="spanClass2">${requestScope.shi }市</span> <span class="spanClass2">${requestScope.quXian }县（区）</span></td>
				</tr>
				<tr class="trClass4">
					<td colspan="6">
						<table id="tableId2" ; class="table2" width="100%">
							<colgroup>
								<col style="width: 40px" />
								<col style="width: 100px" />
								<col style="width: 172px" />
								<col style="width: 100px" />
								<col style="width: 142px" />
								<col style="width: 101px" />
								<col style="width: 142px" />
							</colgroup>
							<tr class="trClass">
								<td class="tdClass3" rowspan="4">母<br />亲<br />信<br />息
								</td>
								<td class="tdClass4">姓名</td>
								<td class="tdClass4">${requestScope.vd307.d30706 }</td>
								<td class="tdClass4">国籍</td>
								<td class="tdClass4">${requestScope.vd307.d30709Zh }</td>
								<td class="tdClass4">名族</td>
								<td class="tdClass5">${requestScope.vd307.d30710Zh }</td>
							</tr>
							<tr class="trClass">
								<td colspan="2">有效身份证件类别</td>
								<td class="tdClass6" colspan="4"><label class="label">居民身份证
										<c:choose>
											<c:when test="${requestScope.vd307.d30707 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label">护照 <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 3}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label>其他
								</label> <span class="span"> <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 2}">${requestScope.vd307.d30707Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 4}">${requestScope.vd307.d30707Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 5}">${requestScope.vd307.d30707Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 6}">${requestScope.vd307.d30707Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30707 == 9}">${requestScope.vd307.d30707Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose></span></td>
							</tr>
							<tr class="trClass">
								<td colspan="2">有效身份证件号码</td>
								<td class="tdClass7" colspan="4">${requestScope.vd307.d30708 }</td>
							</tr>
							<tr class="trClass">
								<td colspan="2">家庭住址</td>
								<td colspan="4" class="tdClass7">${requestScope.vd307.d30711 }</td>
							</tr>
							<tr class="trClass">
								<td class="tdClass8" rowspan="4">父<br />亲<br />信<br />息
								</td>
								<td>姓名</td>
								<td>${requestScope.vd307.d30712 }</td>
								<td>国籍</td>
								<td>${requestScope.vd307.d30715Zh }</td>
								<td>名族</td>
								<td class="tdClass7">${requestScope.vd307.d30716Zh }</td>
							</tr>
							<tr class="trClass">
								<td colspan="2">有效身份证件类别</td>
								<td class="tdClass6" colspan="4"><label class="label">居民身份证
										<c:choose>
											<c:when test="${requestScope.vd307.d30713 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label">护照 <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 3}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label>其他
								</label> <span class="span">
								       <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 2}">${requestScope.vd307.d30713Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 4}">${requestScope.vd307.d30713Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 5}">${requestScope.vd307.d30713Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 6}">${requestScope.vd307.d30713Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30713 == 9}">${requestScope.vd307.d30713Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose></span></td>
							</tr>
							<tr class="trClass">
								<td colspan="2">有效身份证件号码</td>
								<td class="tdClass7" colspan="4">${requestScope.vd307.d30714 }</td>
							</tr>
							<tr class="trClass">
								<td colspan="2">家庭住址</td>
								<td colspan="4" class="tdClass7">${requestScope.vd307.d30717 }</td>
							</tr>
							<tr class="trClass">
								<td class="tdClass9" rowspan="4">领<br />证<br />人
								</td>
								<td>姓名</td>
								<td>${requestScope.vd307.d30718 }</td>
								<td>与婴儿关系</td>
								<td>${requestScope.vd307.d30719Zh }</td>
								<td>联系电话</td>
								<td class="tdClass7">${requestScope.vd307.d30722 }</td>
							</tr>
							<tr class="trClass">
								<td colspan="2">有效身份证件类别</td>
								<td class="tdClass6" colspan="4"><label class="label">居民身份证
										<c:choose>
											<c:when test="${requestScope.vd307.d30720 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label">护照 <c:choose>
											<c:when test="${requestScope.vd307.d30720 == 3}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label>其他
								</label> <span class="span"><c:choose>
											<c:when test="${requestScope.vd307.d30720 == 2}">${requestScope.vd307.d30720Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30720 == 4}">${requestScope.vd307.d30720Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30720 == 5}">${requestScope.vd307.d30720Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30720 == 6}">${requestScope.vd307.d30720Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> <c:choose>
											<c:when test="${requestScope.vd307.d30720 == 9}">${requestScope.vd307.d30720Zh }</c:when>
											<c:otherwise></c:otherwise>
										</c:choose></span></td>
							</tr>
							<tr class="trClass">
								<td class="tdClass10" colspan="2">有效身份证件号码</td>
								<td class="tdClass11" colspan="4">${requestScope.vd307.d30721 }</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="trClass5">
					<td colspan="6">承诺书（必填）</td>
				</tr>
				<tr class="trClass6">
					<td colspan="6"><span class="spanClass1">申请人承诺所提供的上述所有资料信息真实、有效，经核对正确无误，并以详细阅读《出生医学证明》申领</span><br>
						<span class="spanClass2">须知。如提供虚假材料或存在虚假信息，申请人本人愿意承担相应的后果和法律责任。《出生医学证明》一经</span><br>
						<span class="spanClass3">签发，证件上的各项信息原则上不予变更。</span><br> <span
						class="spanClass4">申请人（本人或监护人）签字（手印）：</span></td>
				</tr>
				<tr class="trClass">
					<td class="tdClass12" colspan="3">联系电话：</td>
					<td class="tdClass13" colspan="3"><span>年</span> <span>月</span>
						<span>日</span></td>
				</tr>
				<tr class="trClass3">
					<td class="tdClass14" colspan="6">以下信息签发机构填写：</td>
				</tr>
				<tr>
					<td colspan="6">
						<table id="tableId3" ; class="table3" width="100%";">
							<colgroup>
								<col style="width: 30px;" />
								<col style="width: 558px;" />
								<col style="width: 211px" />
							</colgroup>
							<tr class="trClass7">
								<td class="tdClass15" rowspan="6">材<br />料<br />审<br />核
								</td>
								<td class="tdClass16">1.亲子鉴定证明（交原件）</td>
								<td class="tdClass5"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30725 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30725 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass8">
								<td class="tdClass17">2.出生情况说明（验原件）</td>
								<td class="tdClass18"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30726 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30726 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass8">
								<td class="tdClass17">3.新生儿母亲的有效身份证件（验原件，交复印件）</td>
								<td class="tdClass18"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30727 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30727 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass8">
								<td class="tdClass17">4.新生儿父亲的有效身份证件（验原件，交复印件）</td>
								<td class="tdClass18"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30728 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30728 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass8">
								<td class="tdClass17">5.领证人有效身份证件（验原件，交复印件）</td>
								<td class="tdClass18"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30729 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30729 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass8">
								<td class="tdClass17">6.证明领证人监护关系身份的相关材料（验原件，交复印件）</td>
								<td class="tdClass18"><label class="label label2">有
										<c:choose>
											<c:when test="${requestScope.vd307.d30730 == 1}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label> <label class="label label3">无 <c:choose>
											<c:when test="${requestScope.vd307.d30730 == 0}">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
								</label></td>
							</tr>
							<tr class="trClass9">
								<td class="tdClass19" colspan="3">《出生医学证明》存根联粘帖处</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="divClass3" id="divId3">
				<ul>
					<li class="liClass1">注：</li>
					<li class="liClass">1.填写首次签发登记表时，需提供婴儿父母有效身份证件原件并提交复印件；</li>
					<li class="liClass">
						2.表中的分娩信息婴儿姓名及父母相关信息有领证人填写，所有项目要字迹清除，若出现涂改，相应内</li>
					<li class="liClass2">容须由领证人签字确认。</li>
				</ul>
			</div>
		</div>
	</center>
</body>
</html>