<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
			<!--会强制浏览器按照最新的标准去渲染-->
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
.d2{
      padding-top: 10px; 
}
.spanAll {
	text-align: center;
	display: Inline-Block;
	vertical-align: bottom;
}

 body{
  			font-size: 19px;
            font-family: '宋体', '微软雅黑'; /*统一浏览器字体*/
            padding: 0; /*清空浏览器边距*/
            margin: 0;
            /* overflow: auto;/*页面滚动条*/
}
 div { /*自动居中*/
            margin: auto;
            height: auto;
            zoom: 1;
}
@media print {
   			.Noprint {display:none;}
		}

.div {
	width: 800px;
}
 input {
            vertical-align: middle;
            font-weight: bold;
            width: 20px;
            height: 25px;
}
.w40{
	width:40px;
}
.w60{
	width:60px;
}
.w120{
	width:120px;
}
.w200{
	width:200px;
}
.w70{
	width:70px;
}
.line {
	border-bottom: solid 3px black;
	width: 763px;
	margin-left: 1px;
	padding-top: 10px
}
.Pall{
	margin-top: 20px;
	padding-left: 120px;
}
/*ie7 ol bug*/
.ie7 .lineP {
	margin-left: 0px;
	padding-top: 0px;
}

.ie7 .divAll {
	padding-top: 10px;
}

.ie7 .divEnd {
	margin-bottom: 30px;
}

.ie9 .lineP {
	margin-left: 20px;
	padding-top: 0px;
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
       //console.log(document.documentMode);//得到浏览器的文档模式  ..ie7 8 9 10 ...
        var cssStyle = document.compatMode;//得到浏览器的文档模式 俩种 CSS1Compat 标准    BackCompat  怪异模式
        ///console.log(cssStyle)
        window.onload = function() {
            var div = document.getElementById("divId");
            var body=document.body;
            if (cssStyle == 'BackCompat') {// CSS1Compat 标准    BackCompat  怪异模式      
                body.style.overflow="auto";
            }
            if(isIE=="7"&&document.documentMode>"7"){
             }
            if(isIE!="7"&&document.documentMode=="7"){
            }
            if(isIE=="7"&&document.documentMode=="7"){
            }
        }
    </script>
</head>

<body>
	<center>
		<h1 style="text-align:center;">河南省免费产前超声筛查报告样本</h1>
		<h2 style="text-align:center;">（孕 11~13 周）</h2>
		<div class="d2">
			<div class="div" id="divId">
				<div>
					<p colspan='2' class='line'></p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>姓名：</span>
						<span class="spanAll w60">${requestScope.vf502.f50203}</span>
						<span style="margin-left:260px;">性别：</span>
							
						<span class="spanAll w40">${requestScope.vf502.f50205Zh}</span>
						</label>
						
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
							<span>年龄：</span>
							<span class="spanAll w40">${requestScope.vf502.f50206}</span>
							<span style="margin-left:280px;">超声号：</span>
							<span style="width:300px">${requestScope.vf502.f50209}</span>
						</label>	
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>临床诊断：</span>
						<span class="spanAll w120">${requestScope.vf502.f50208}</span>
							<span style="margin-left:160px;">电话：</span>
							<span style="width:300px">${requestScope.vf502.f50207}</span>
					</p>
				</div>
				<div>
					<p class='line'></p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>头臀径（CRL）：</span>
							<span class="spanAll w40">${requestScope.vf502.f50210}</span>mm
							<span style="margin-left:130px;">双顶径（BPD）：</span>
							<span class="spanAll w40">${requestScope.vf502.f50211}</span>mm
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
							<span>孕周：</span>
						<span class="spanAll w40" style="width:60px">${requestScope.vf502.f50212}</span>周
						<span class="spanAll w40" style="width:60px">${requestScope.vf502.f50230}</span>天
							<span style="margin-left:130px;">NT：</span>
							<span class="spanAll w40">${requestScope.vf502.f50213}</span>mm
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>心率：</span>
							<span class="spanAll w40">${requestScope.vf502.f50214}</span>次/分
						
						<label style="margin-left: 210px;">
								颅光环：<c:choose>
								<c:when test="${requestScope.vf502.f50215 eq '1'}">可显示</c:when>
								<c:otherwise></c:otherwise></c:choose>
							</label>
							<label style="margin-left: 10px;">
								<c:choose>
								<c:when test="${requestScope.vf502.f50215 eq '2'}">部分显示</c:when>
								<c:otherwise></c:otherwise></c:choose>
							</label>
						<label style="margin-left: 10px;">
							<c:choose>
								<c:when test="${requestScope.vf502.f50215 eq '3'}">未显示</c:when>
								<c:otherwise></c:otherwise></c:choose>
						</label>
					</p>
				</div>
				
				<div class="divAll">
					<p class="Pall" align="left">
						<label>
							脑部缺陷：
							<c:choose>
								<c:when test="${requestScope.vf502.f50235 eq '1'}">是</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.vf502.f50235 eq '2'}">否</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</label>
					</p>
					<p style=" margin-top: 20px;text-align:left;margin-left:120px">
						<label>
							脑部缺陷内容：<c:choose>
								<c:when test="${requestScope.a1 eq '1'}">无脑儿</c:when>
								<c:otherwise></c:otherwise></c:choose>
								<c:choose>
								<c:when test="${requestScope.a2 eq '2'}">露脑畸形</c:when>
								<c:otherwise></c:otherwise></c:choose>
								<c:choose>
								<c:when test="${requestScope.a3 eq '3'}">严重脑膨出</c:when>
								<c:otherwise></c:otherwise></c:choose>
								<c:choose>
								<c:when test="${requestScope.a4 eq '4'}">严重胸腹壁缺损</c:when>
								<c:otherwise></c:otherwise></c:choose>
								<c:choose>
								<c:when test="${requestScope.a5 eq '5'}">严重开放性脊柱裂声像表现</c:when>
								<c:otherwise></c:otherwise></c:choose>
						</label>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
							<span>胎盘：位置</span>
							<span class="spanAll w60">${requestScope.vf502.f50217Zh}</span>
							<span style="margin-left:190px;">厚度：</span>
							<span class="spanAll w40" style="width:60px">${requestScope.vf502.f50218}</span>mm
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
							<span>羊水：最大深度</span>
							<span class="spanAll w60" >${requestScope.vf502.f50219}</span>mm
							<span style="margin-left:120px;">宫颈内口：</span>
							<c:choose>
								<c:when test="${requestScope.vf502.f50220 eq '0'}">开放</c:when>
								<c:otherwise></c:otherwise></c:choose>
						<label>
							<c:choose>
								<c:when test="${requestScope.vf502.f50220 eq '1'}">关闭</c:when>
								<c:otherwise></c:otherwise></c:choose>
						</label>
					</p>
				</div>
				<div>
					<p  class='line'></p>
				</div>
				<div class="divAll">
					<p style=" margin-top: 20px;text-align:left;margin-left:120px">
						<label>
							超声所见：<c:choose>
									<c:when test="${requestScope.vf502.f50233 == null}"></c:when>
									<c:otherwise>${requestScope.vf502.f50233}</c:otherwise>
								</c:choose>
						</label>
					</p>
				</div>
				<div class="divAll">
					<p style=" margin-top: 20px;text-align:left;margin-left:120px">
						<label>
							提示：<c:choose>
									<c:when test="${requestScope.vf502.f50234 == null}"></c:when>
									<c:otherwise>${requestScope.vf502.f50234}</c:otherwise>
								</c:choose>
						</label>
					</p>
				</div>
				<div  class="divAll">
					<p style=" margin-top: 20px;text-align:left;margin-left:120px">
						<label><b>告知： </b></label>
						<br/><label style="margin-left: 70px;"><b>推荐本次检查在孕周11~13周是进行，只检查报告中超声</b></label>	
						<br/><label style="margin-left: 70px;"><b>描述的内容，没有描述的胎儿结构不在本次检查范围内，</b></label>
						<br/><label style="margin-left: 70px;"><b>胎儿性别、生殖器、手指、脚趾、耳及其他有关的问题</b></label>
						<br/><label style="margin-left: 70px;"><b>不在超声检查范围内。建议在孕周20~24周进行系统超声</b></label>
						<br/><label style="margin-left: 70px;"><b>检查，特此声明。</b></label>
					</p>
				</div>
				<div>
					<p  class='line'></p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>报告医生：</span>
						<span class="spanAll w120">${requestScope.vf502.f50222}</span>
							<span style="margin-left: 175px;">审核医生：</span>
							<span class="spanAll w70">${requestScope.vf502.f50223}</span>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>报告单位：</span>
						<span class="spanAll w200">${requestScope.vf502.f50225Zh}</span>
							<span style="margin-left: 90px;">报告时间：</span>
							<span class="spanAll 120">${requestScope.vf502.f50224}</span>
					</p>
				</div>
				<div class="Noprint" align="center" style="padding-top: 10px">
				<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
				<input type="button" value="执行打印"  onclick='wb.execwb(6,6)' style="width:80px;background-color:#f7f7f7;"/>
				<input type="button" value="打印设置" onclick="wb.execwb(8,1)" style="width:80px;background-color:#f7f7f7;margin-left:60px;"/> 
				<input type="button" value="打印预览" onclick='wb.execwb(7,1)' style="width:80px;background-color:#f7f7f7;margin-left:60px;"/> 
			</div>
			</div>
		</div>
	</center>
</body>
</html>