<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>河南省听力障碍儿童个案登记表</title>
<style type="text/css">
	.d2{
      padding-top: 20px; 
}
.spanAll {
	text-align: center;
	border-bottom: solid 1px black;
	display: Inline-Block;
	vertical-align: bottom;
}
.table{
	border:0;
	width:1500;
	align:center; 
	valign:center;
	height:100%;
	border-collapse:collapse;
	margin:0;
	padding:0;
}
 body{
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
 input {
            vertical-align: middle;
            font-weight: bold;
            width: 20px;
            height: 25px;
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
			window.onload = function() {
			var cssStyle = document.compatMode;//得到浏览器的渲染模式
			var div = document.getElementById("divId");
			var divId2 = document.getElementById("divId2");
			var divId4 = document.getElementById("divId4");
			var table=document.getElementById("tableId");
			var tbody=document.getElementById("tbodyId");
			var ol=document.getElementById("olId");
			if (cssStyle == 'BackCompat') {
			div.style.paddingTop = "1px";
			table.style.textAlign="center";
			tbody.style.height="80px";
		}
			 if(isIE=="7"&&document.documentMode>"7"){
            	divId4.style.height="150px";
            	divId4.style.marginBottom="20px";
             }
            if(isIE!="7"&&document.documentMode=="7"){
            	ol.style.marginLeft="0px";
            	ol.style.paddingBottom="10px";
            	div.style.marginTop="20px";
            	tbody.style.height="80px";
            	divId2.style.marginBottom="-23px";
            }
            if(isIE=="7"&&document.documentMode=="7"){
            	divId4.style.marginTop="20px";
            	divId4.style.marginBottom="30px";
       		}
	}
	</script>
</head>
<body>
	<center>
		<h1>河南省听力障碍儿童个案登记表</h1>
	</center>
</body>
</html>