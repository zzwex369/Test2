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
<title>《出生医学证明》换发申请表</title>
<style type="text/css">
* {
	padding: 0; /*清空浏览器边距*/
	margin: 0;
}

body {
	font-family: '微软雅黑', '宋体'; /*统一浏览器字体*/
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

#tableId {
	width: 800px;
	height: 1032px;
	margin: 8px auto;
}

#tableId2 {
	width: 473px;
	height: 151px;
}

table {
	align: center;
	border-collapse: collapse; /*边框合并*/
    table-layout:fixed;/*固定宽度*/
	cellspacing: "0"; /*指定相邻单元格边框的间距；*/
	cellpadding: "2"; /*指定表格单元格与内容之间的间距；*/
}

tr,td {
	border: solid 1px #000000;
	font-size: 16px;
	vertical-align: middle; /*把此元素放置在父元素的中部。*/
	line-height: 18px; /*设置行高 浏览器统一*/
}

tr {
	height: 60px;
}

.tdClass span {
	width: 200px;
	border-bottom: 1px solid #333;
	display: Inline-Block;
	/*text-decoration: underline;
	*/margin-left: 10px;
	margin-top: 3px;
	font-size:14px;
}

.tdClass {
	border-bottom: solid 0px;
	border-top: solid 0px;
	text-align: left;
	padding-left: 10px;
	font-family: '文泉驿正黑 ';
}

.tdClass1 {
	font-size: 18px;
	font-weight: bolder;
}

.tdClass2 {
	border-bottom: solid 0px;
	text-align: left;
	padding-left: 10px;
	font-family: '文泉驿正黑 '
}

.tdClass3 {
	height: 125px;
	border: solid 0px;
}

.tdClass4 {
	border-right: solid 0px;
}

.tdClass5 {
	border: solid 0px;
}

.tdClass6 {
	border-top: solid 0px;
	border-bottom: solid 0px;
	font-family: '宋体';
	text-align: left;
	padding-bottom: 10px;
	padding-left: 10px;
	font-weight: bold;
	padding-top: 20px;
	height: 50px;
}

.tdClass7 {
	text-align: left;
	padding-left: 13px;
}

.tdClass8 {
	text-align: left;
	padding-left: 20px;
}

.tdClass9 {
	border-left: solid 0px;
}

.tdClass10 {
	text-align: left;
	padding-left: 15px;
}

.trClass {
	border-top: solid 0px;
	border-bottom: solid 0px;
}

.trClass1 {
	border-bottom: solid 0px;
}

.trClass2 {
	border-top: solid 0px;
	border-bottom: solid 0px;
}

.trClass3 {
	border-right: solid 0px;
	border-left: solid 0px;
}

.trClass4 {
	border-right: solid 0px;
	border-bottom: solid 0px;
}

.colClass {
	width: 192px;
}

label {
	cursor: pointer;
}

.ie6 #tableId2,.ie6 #tableId {
	text-align: center;
}

.ie7 .colClass,.ie6 .colClass {
	width: 129px;
}

.ie7 .tdClass10,.ie6 .tdClass10,.ie7 .tdClass3,.ie6 .tdClass3,.ie7 .tdClass7,.ie6 .tdClass7
	{
	border-left-width: 1px;
}

.ie7 .tdClass8,.ie6 .tdClass8,.ie7 .tdClass7,.ie6 .tdClass7 {
	border-bottom-width: 1px;
}

.ie7 #tableId2,.ie6 #tableId2 {
	width: 470px;
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
		var div = document.getElementById("divId");
		var tbody1 = document.getElementById("tbody1");
		var tbody2 = document.getElementById("tbody2");
		var body = document.body;
		var divId2 = document.getElementById("divId2");
		var divId3 = document.getElementById("divId3");
		var divId4 = document.getElementById("divId4");
		var ol = document.getElementById("olId");
		var tr = document.getElementsByTagName("tr");
		if (cssStyle == 'BackCompat') {// CSS1Compat 标准    BackCompat  怪异模式
			div.style.paddingTop = "1px";
			table.style.textAlign = "center";
			table2.style.textAlign = "center";
			body.style.overflow = "auto";
		}/*
		            if(isIE=="7"&&document.documentMode>"7"){
		            	divId4.style.height="300px";
		            	divId4.style.marginBottom="20px";
		             }
		            if(isIE!="7"&&document.documentMode=="7"){
		            	ol.style.marginLeft="0px";
		            	ol.style.paddingBottom="10px";
		            	div.style.marginTop="20px";
		            	divId2.style.marginBottom="-23px";
		            	divId4.style.marginTop="20px";
		            	for(var i=0;i<tr.length;i++){
		            		tr[i].style.height="17px";
		            	}
		            }
		            if(isIE=="7"&&document.documentMode=="7"){
		            	divId4.style.marginTop="20px";
		            }
		 */
	}
</script>
</head>
<body>
	<center>
		<div class="div" id="divId">
			<div id="divId2">
				<h1>《出生医学证明》换发申请表</h1>
			</div>
			<table id="tableId" width="100%"  cellspacing="0" cellpadding="2">
				<colgroup>
					<col class="colClass">
					<col style="width: 282px;">
					<col style="width: 142px;">
					<col style="width: 183px;">
				</colgroup>
				<tbody>
					<tr>
						<td>原证编号</td>
						<td colspan="3">${requestScope.vd306.d30603 }</td>
					</tr>
					<tr>
						<td>新生儿姓名</td>
						<td>${requestScope.vd306.d30604 }</td>
						<td>新生儿性别</td>
						<td>${requestScope.vd306.d30605Zh }</td>
					</tr>
					<tr>
						<td rowspan="3">新生儿母亲</td>
						<td>姓名</td>
						<td colspan="2">${requestScope.vd306.d30606 }</td>
					</tr>
					<tr>
						<td>有效身份证件类型</td>
						<td colspan="2">${requestScope.vd306.d30607Zh }</td>
					</tr>
					<tr>
						<td>有效身份证件号码</td>
						<td colspan="2">${requestScope.vd306.d30608 }</td>
					</tr>
					<tr>
						<td colspan="2">申请换发原因</td>
						<td colspan="2">${requestScope.vd306.d30613Zh }</td>
					</tr>
					<tr>
						<td colspan="2">原证正副页交回情况</td>
						<td style="border-right: solid 0px;"><label>正页 <c:choose><c:when test="${requestScope.vd306.d30614 == 1}">☑</c:when>
                        <c:otherwise>☐</c:otherwise></c:choose>
						</label>
                       
                        </td>
						<td style="border-left: solid 0px;"><label>正页和副页  <c:choose><c:when test="${requestScope.vd306.d30614 == 2}">☑</c:when>
                        <c:otherwise>☐</c:otherwise></c:choose>
						</label>
                       
                        </td>
					</tr>
					<tr>
						<td colspan="2" class="tdClass1">领证人需提供和提交的证明材料</td>
						<td rowspan="11" colspan="2" nowrap="nowrap">换发后《出生医学证明》存根、原证的正页<br>或正、副页及相关材料粘贴处
						</td>
					</tr>
					<tr class="trClass1">
						<td colspan="2" class="tdClass2">1. 新生儿父母的书面申请（ ${requestScope.vd306.d30615Zh }）</td>
					</tr>
					<tr class="trClass2">
						<td colspan="2" class="tdClass">2.原签发机构提供的住院分娩病历、病历签发记录或出生证存根<br>页复印件（${requestScope.vd306.d30616Zh }
							）
						</td>
					</tr>
					<tr class="trClass">
						<td colspan="2" class="tdClass">3. 户口登记机关出具的无法入户的证明材料（${requestScope.vd306.d30617Zh } ）</td>
					</tr>
					<tr class="trClass">
						<td colspan="2" class="tdClass">4. 新生儿父母有效身份证件原件和复印件（${requestScope.vd306.d30618Zh } ）</td>
					</tr>
					<tr class="trClass">
						<td colspan="2" class="tdClass">5. 领证人的有效身份证件原件和复印件（${requestScope.vd306.d30619Zh } ）</td>
					</tr>
					<tr class="trClass">
						<td colspan="2" class="tdClass">6. 其他 <span>${requestScope.vd306.d30620 }</span>
						</td>
					</tr>
					<tr class="trClass" style="border-right: solid 1px;">
						<td colspan="2" class="tdClass3">
							<table id="tableId2">
								<colgroup>
									<col style="width: 65px;">
									<col style="width: 66px;">
									<col style="width: 110px;">
									<col style="width: 66px;">
									<col style="width: 160px;">
								</colgroup>
								<tr class="trClass3">
									<td class="tdClass9" rowspan="3">领<br>证<br>人
									</td>
									<td>姓名</td>
									<td>${requestScope.vd306.d30609 }</td>
									<td>与新生<br>儿关系
									</td>
									<td class="tdClass4">${requestScope.vd306.d30610Zh }</td>
								</tr>
								<tr class="tdClass4">
									<td colspan="2">有效身份证件类型</td>
									<td class="tdClass4" colspan="2">${requestScope.vd306.d30611Zh }</td>
								</tr>
								<tr class="trClass4">
									<td colspan="2">有效身份证件号码</td>
									<td class="tdClass4" colspan="2">${requestScope.vd306.d30612 }</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr class="tdClass5">
						<td class="tdClass6" colspan="2">以上内容由领证人填写和提交，请核对正确无误后签字确认<br>，并承担相应法律责任.
						</td>
					</tr>
					<tr class="trClass">
						<td class="tdClass5 tdClass10">领证人签字：</td>
						<td class="tdClass5"></td>
					</tr>
					<tr style="border-top: solid 0px;">
						<td class="tdClass5 tdClass7">填报日期：</td>
						<td class="tdClass5 tdClass8">${requestScope.nian }年<span
							style="padding-left: 30px;"></span><span
							style="padding-left: 20px;">${requestScope.yue }月</span><span
							style="padding-left: 50px;"></span>${requestScope.ri }日
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</center>
</body>
</html>