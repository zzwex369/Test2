<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.xyw.medical.fnbj.print.model.Items"%>
<%@page import="com.xyw.medical.fnbj.model.VF401"%>
<%@page import="com.xyw.medical.xzjgwh.model.VD201"%>
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
   <!--强制用ie8标准模式-->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
							<!--会强制浏览器按照最新的标准去渲染-->
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>婚前医学检查证明</title>
<style type="text/css">
	html {
              overflow:hidden;    /*这个可以去掉IE6,7的滚动*/
        }
        body{
            font-family:'微软雅黑', '宋体';/*统一浏览器字体*/
            padding: 0;/*清空浏览器边距*/
            margin: 0;
           /* overflow: auto;/*ie5及其他版本页面滚动条*/
        }
        div{
			/*自动居中*/
            margin: auto;
            height: auto;
            text-align:center;
            zoom:1;
        }
        .div{
            width: 910px;
        }
        tr,td{
            border:solid 1px #000000;
            font-size: 15px;
            line-height:18px;
        }
        table{
            width:887px;
            height:600px;
            margin: 8px auto;
            align: center;
            border-collapse: collapse;
            table-layout:fixed;/*固定宽度*/
            /* cellspacing:"0";指定相邻单元格边框的间距；*/

            /* cellpadding:10;指定表格单元格与内容之间的间距；*/
        }
	  /*ie7 ol bug*/
        .ie7 ol{
            float:left;
            margin-left:0px;
        }
        .ie7  .div1{
            margin-top:20px;
            margin-bottom:-23px;
        }
       /* .ie7 .div2{
            padding-top:15px;
        }*/
        .ie7 .tbodyClass1{
            height:19px;
        }
        .ie7 .tbodyClass2{
            height:70px;
        }
        .ie7 tr{
        	height:33px;
        }
</style>
	<script type="text/javascript">
	/*判断浏览器*/
    function getOs() {
        if(window.ActiveXObject!=undefined) {
        	var ieVersion="";
        	if(navigator.userAgent.indexOf("MSIE 6.0;")>0){
        		return ieVersion="6";
        	}
        	if(navigator.userAgent.indexOf("MSIE 7.0;")>0){
        		return ieVersion="7";
        	}
        	if(navigator.userAgent.indexOf("MSIE 8.0;")>0){
        		return ieVersion="8";
        	}
        	if(navigator.userAgent.indexOf("MSIE 9.0;")>0){
        		return ieVersion="9";
        	}
        	if(navigator.userAgent.indexOf("MSIE 10.0;")>0){
        		return ieVersion="10";
        	}
        	if(navigator.userAgent.indexOf("MSIE 11.0;")>0){
        		return ieVersion="11";
        	}else{
        		return ieVersion="未知";
        	}
            return ieVersion;
        }
        if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){
            return "Firefox";
        }
        if(isSafari=navigator.userAgent.indexOf("Safari")>0) {
            return "Safari";
        }
        if(isCamino=navigator.userAgent.indexOf("Camino")>0){
            return "Camino";
        }
        if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){
            return "Gecko";
        }
    }
    var isIE=getOs();
    //alert(isIE);
   //console.log(navigator.userAgent);
    //console.log(isIE);
    var cssStyle = document.compatMode;//得到浏览器的文档模式
    ///console.log(cssStyle)
    window.onload = function() {
        var table=document.getElementById("tableId");
        var div = document.getElementById("divId");
        var tbody1 = document.getElementById("tbody1");
        var tbody2 = document.getElementById("tbody2");
        var divId2 =document.getElementById("divId2");
        var divId3 =document.getElementById("divId3");
        var divId4 =document.getElementById("divId4");
        var tr=document.getElementsByTagName("tr");
        var td=document.getElementsByTagName("td");
        var ol=document.getElementById("olId");
        if (cssStyle == 'BackCompat') {// CSS1Compat 标准    BackCompat  怪异模式
            document.body.style.overflow="hidden";
            div.style.paddingTop = "1px";
            table.style.textAlign="center";
        }
      	 if(isIE=="7"&&document.documentMode>"7"){
      	 	document.body.style.overflow="hidden";
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
        		tr[i].style.height="35px";
        		tr[i].style.margin="0px";
        	}
        }
        if(isIE=="7"&&document.documentMode=="7"){
        	divId4.style.marginTop="20px";
        	divId4.style.marginBottom="30px";
        }
    }
	</script>
</head>
<body>
	<% 
	VF401 vf401 = (VF401)request.getAttribute("vf401");
	Items items = (Items)request.getAttribute("items");
	VD201 Vd201 = (VD201)request.getAttribute("vd201");
	String birth[] = vf401.getF40104().toString().split("-");//出生日期
	String birthYear = birth[0];
	String birthMonth = birth[1];
	String birthDay = birth[2];
	String check[] = vf401.getF40193Str().split("-");//检查日期
	String checkYear = check[0];
	String checkMonth = check[1];
	String checkDay = check[2];
	%>
	<div class="div" id="divId">
		
			<h2>婚前医学检查证明</h2>
			单位名称：<span style="text-align: left;">${vd201.d20105}</span>
			<span style="margin-left:120px;"></span>编号：${vf401.f40116 }
		
		  <table id="tableId"; width="100%";  cellspacing="0" cellpadding="2">
		  	<colgroup>
		  		<col style="width:80px;">
		  		<col style="width:80px;">
		  		<col style="width:80px;">
		  		<col style="width:150px;">
		  		<col style="width:80px;">
		  	</colgroup>
		  	<tbody class="tbodyClass1">
		  		<tr>
		  			<td>姓名</td>
		  			<td>${vf401.f40102}</td>
		  			<td>出生日期</td>
		  			<td>
		  				<span><%=birthYear%></span>年
		  				<span><%=birthMonth%></span>月
		  				<span><%=birthDay%></span>日
		  			</td>
		  			<td rowspan='3'>照片粘贴处</td>
		  		</tr>
		  		<tr>
		  			<td>性别</td>
		  			<td>${vf401.f40103Zh}</td>
		  			<td>民族</td>
		  			<td>${vf401.f40107Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>身份证号</td>
		  			<td colspan='3'>${vf401.f40106}</td>
		  		</tr>
		  		<tr>
		  			<td>职业或职位</td>
		  			<td colspan='4'>${vf401.f40114Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>现住址</td>
		  			<td colspan='4'>${vf401.f40110Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>对方姓名</td>
		  			<td colspan='4'>${vf401.f40113}</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">直系、三代内旁系血亲关系
		  				<label style="margin-left:120px;">
		  					无
		  					<c:choose>
		  						<c:when test="${items.f40130_01=='1' || items.f40130_01==''}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  					有<c:choose>
		  						<c:when test="${items.f40130_02=='2' || items.f40130_03=='3' || items.f40130_04=='4'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">
		  				婚前检查结果：
		  				<c:choose>
		  					<c:when test="${vf401.f40186=='1'}">正常</c:when>
		  					<c:otherwise>异常：${vf401.f40187}</c:otherwise>
		  				</c:choose>
		  				<br><br>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">
		  				医学意见：
		  				<label style="padding-left:60px;">
		  					①建议不宜结婚
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='4'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:60px;">
		  					②建议不宜生育
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='3'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:60px;">
		  					③建议暂缓结婚
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='2'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<br>
		  				<label style="padding-left:130px;">
		  					④未发现医学上不宜结婚的情况
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='1'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:30px;">
		  					⑤建议采取医学措施，尊重受检者意愿
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='5'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>主治医师
		  				<br>签&nbsp;&nbsp;&nbsp;字
		  			</td>
		  			<td colspan='2'>${vf401.f40192 }</td>
		  			<td>检查单位
		  			<br>专用章
		  			</td>
		  			<td></td>
		  		</tr>
		  	</tbody>
		  </table>
		   <div style="text-align:left;">
		  	注：1、本证明有效期为三个月
		  	<label style="margin-left:30px">
		  	2、对上述结果如何异议，可申请医学技术鉴定
		  	</label>
		  </div>
		  <div style="text-align:left;margin-left:30px"><b>此联交婚姻登记部门</b></div>
		  <div  style="text-align:right;">
		  	<span><%=checkYear%></span>年
		  	<label"><span><%=checkMonth%></span>月</label>
		  	<label><span><%=checkDay%></span>日</label>
		  </div>
		  <div style="page-break-before:always;">
		  	<h2>婚前医学检查证明存根</h2>
			单位名称：<span style="text-align: left;">${vd201.d20105}</span>
			<span style="margin-left:120px;"></span>编号：${vf401.f40116 }
		  </div>
		   <table id="tableId"; width="100%";  cellspacing="0" cellpadding="2">
		  	<colgroup>
		  		<col style="width:80px;">
		  		<col style="width:80px;">
		  		<col style="width:80px;">
		  		<col style="width:150px;">
		  		<col style="width:80px;">
		  	</colgroup>
		  	<tbody class="tbodyClass1">
		  		<tr>
		  			<td>姓名</td>
		  			<td>${vf401.f40102}</td>
		  			<td>出生日期</td>
		  			<td>
		  				<span><%=birthYear%></span>年
		  				<span><%=birthMonth%></span>月
		  				<span><%=birthDay%></span>日
		  			</td>
		  			<td rowspan='3'>照片粘贴处</td>
		  		</tr>
		  		<tr>
		  			<td>性别</td>
		  			<td>${vf401.f40103Zh}</td>
		  			<td>民族</td>
		  			<td>${vf401.f40107Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>身份证号</td>
		  			<td colspan='3'>${vf401.f40106}</td>
		  		</tr>
		  		<tr>
		  			<td>职业或职位</td>
		  			<td colspan='4'>${vf401.f40114Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>现住址</td>
		  			<td colspan='4'>${vf401.f40110Zh}</td>
		  		</tr>
		  		<tr>
		  			<td>对方姓名</td>
		  			<td colspan='4'>${vf401.f40113}</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">直系、三代内旁系血亲关系
		  				<label style="margin-left:120px;">
		  					无
		  					<c:choose>
		  						<c:when test="${items.f40130_01=='1' || items.f40130_01==''}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  					有<c:choose>
		  						<c:when test="${items.f40130_02=='2' || items.f40130_03=='3' || items.f40130_04=='4'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">
		  				婚前检查结果：
		  				<c:choose>
		  					<c:when test="${vf401.f40186=='1'}">正常</c:when>
		  					<c:otherwise>异常：${vf401.f40187}</c:otherwise>
		  				</c:choose>
		  				<br><br>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan='5' style="text-align:left;padding-left:50px;">
		  				医学意见：
		  				<label style="padding-left:60px;">
		  					①建议不宜结婚
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='4'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:60px;">
		  					②建议不宜生育
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='3'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:60px;">
		  					③建议暂缓结婚
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='2'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<br>
		  				<label style="padding-left:130px;">
		  					④未发现医学上不宜结婚的情况
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='1'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  				<label style="padding-left:30px;">
		  					⑤建议采取医学措施，尊重受检者意愿
		  					<c:choose>
		  						<c:when test="${vf401.f40189=='5'}">☑</c:when>
		  						<c:otherwise>☐</c:otherwise>
		  					</c:choose>
		  				</label>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>主治医师
		  				<br>签&nbsp;&nbsp;&nbsp;字
		  			</td>
		  			<td colspan='2'>${vf401.f40192 }</td>
		  			<td>检查单位
		  			<br>专用章
		  			</td>
		  			<td></td>
		  		</tr>
		  	</tbody>
		  </table>
		 <div style="text-align:left;"><b>此联留婚前医学检查单位</b></div>
		  <div  style="text-align:right;">
		  	<span><%=checkYear%></span>年
		  	<label><span><%=checkMonth%></span>月</label>
		  	<label><span><%=checkDay%></span>日</label>
		  </div>
	</div>
</body>
</html>