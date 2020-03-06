<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>河南省免费产前超声筛查服务月统计报表</title>
<style type="text/css">
	   div{
			/*自动居中*/
            margin: auto;
            height: auto;
/*              text-align:center;  */
            zoom:1;
        }
        .div{
            width: 910px;
        }
        html {
              overflow:hidden;    /*这个可以去掉IE6,7的滚动*/
        }
        body{
            font-family:'微软雅黑', '宋体';/*统一浏览器字体*/
            padding: 0;/*清空浏览器边距*/
            margin: 0;
           /* overflow: auto;/*ie5及其他版本页面滚动条*/
        }
           table{
            width:887px;
            height:324px;
            margin: 8px auto;
             text-align:center;
            border-collapse: collapse;
            table-layout:fixed;/*固定宽度*/
            /* cellspacing:"0";指定相邻单元格边框的间距；*/

            /* cellpadding:10;指定表格单元格与内容之间的间距；*/
        }
         tr,td{
            border:solid 1px #000000;
            font-size: 13px;
            line-height:18px;
            valign:middle;
        }
        .spanAll{
        	 margin-bottom: 0px;
            display: inline-block;
            border-bottom: solid 1px black;
        }
          .ie7 .tbodyClass1{
            height:19px;
        }
          .trClass1{
        	height:43px;
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
	<div class="div" id="divId">
		<h2 style="text-align:center;">河南省免费产前超声筛查服务月统计报表</h2>
		<span style="float:left">填报单位（盖章）：</span>
		<label style="padding-left:70px">统计期限：<span class="spanAll" style="width:40px"></span>年</label>
			<span class="spanAll" style="width:40px"></span>月
			<span class="spanAll" style="width:40px"></span>日至
			<span class="spanAll" style="width:40px"></span>年
			<span class="spanAll" style="width:40px"></span>月
			<span class="spanAll" style="width:40px"></span>日
		<span style="padding-left:40px">单位：人（例）</span>
		<table id="tableId" width="100%"  cellspacing="0" cellpadding="2">
			<colgroup>
				<col style="width:80px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:30px">
				<col style="width:80px">
			</colgroup>
			<tbody class="tbodyClass1">
				<tr class="trClass1">
					<td rowspan="2">辖区机构名称</td>
					<td rowspan="2">产前筛查总人数</td>
					<td colspan="7">产前筛查异常人数</td>
					<td rowspan="2">转诊人数</td>
					<td rowspan="2">接受产前诊断人数</td>
					<td rowspan="2">备注</td>
				</tr>
				<tr class="trClass1">
					<td>NT增厚人数</td>
					<td>无脑儿高危险人数</td>
					<td>露脑畸形高危险人数</td>
					<td>严重脑膨出高危险人数</td>
					<td>严重胸腹壁缺损内脏外翻高危险人数</td>
					<td>严重开放性脊柱裂高危险人数</td>
					<td>其他异常人数</td>
				</tr>
				<tr class="trClass1">
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>
					<td>8</td>
					<td>9</td>
					<td>10</td>
					<td>11</td>
					<td>12</td>
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
		<div class="div">
			<span style="float:left">填表人：</span>
			<span style="padding-left:90px">填表时间：</span>
			<span style="padding-left:90px">审表人：</span>
			<span style="padding-left:90px">审表时间：</span>
			<label style="padding-left:90px">联系电话：<span class="spanAll" style="width:120px"></span></label>
		</div>
		<div class="div" style="padding-top:20px">
			注：其他异常人数请注明具体异常情况。
		</div>
	</div>
</body>
</html>