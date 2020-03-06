<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.xyw.medical.fnbj.model.VF401"%>
<%@page import="com.xyw.medical.fnbj.print.model.Items"%>
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
<title>男性婚前医学检查表</title>
<style type="text/css">
	body {
	font-family: '宋体', '微软雅黑'; /*统一浏览器字体*/
	text-align:center;
	padding: 0; /*清空浏览器边距*/
	margin: 0;
	/* overflow: auto;/*页面滚动条*/
}
div { /*自动居中*/
	text-align:left;
	zoom: 1;
}

.div {
	width: 800px;
}

.divAll {
	width: 800px;
	padding-top: -15px
}
.spanAll {
	text-align: left;
	border-bottom: solid 2px black;
	display: Inline-Block;
	vertical-align: bottom;
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

	<%
	VF401 vf401 = (VF401)request.getAttribute("vf401");
	Items items = (Items)request.getAttribute("items");
	String birth[] = vf401.getF40104().toString().split("-");//出生日期
	String birthYear = birth[0];
	String birthMonth = birth[1];
	String birthDay = birth[2];
	String check[] = vf401.getF40193Str().split("-");//检查日期
	String checkYear = check[0];
	String checkMonth = check[1];
	String checkDay = check[2];
	
	%>
	<center>
		<div class="div" id="divId">
			<div style="width: 800px; padding-top:0px; text-align: center;">
				<h2>
					男性婚前医学检查表
				</h2>
			</div>
		
		<div>
				<p>
					填写日期：
					<span class="spanAll" style="width:60px"></span>年
					<span class="spanAll" style="width:60px"></span>月
					<span class="spanAll" style="width:60px"></span>日
				</p>
			</div>
			<div>
				<p>
					姓&nbsp;&nbsp;&nbsp;&nbsp;名：
					<span class="spanAll" style="width:90px">${vf401.f40102 }</span>
					出生日期：
					<span class="spanAll" style="width:60px"><%=birthYear %></span>年
					<span class="spanAll" style="width:60px"><%=birthMonth %></span>月
					<span class="spanAll" style="width:60px"><%=birthDay %></span>日
				</p>
			</div>
			<div>
				身份证号：
				<span class="spanAll" style="width:190px">${vf401.f40106}</span>
			</div>
			<div>
				<p>
					职&nbsp;&nbsp;&nbsp;&nbsp;业：
					<span class="spanAll" style="width:90px">${vf401.f40114Zh}</span>
					文化程度：
					<span class="spanAll" style="width:90px">${vf401.f40115Zh}</span>
					民族：
					<span class="spanAll" style="width:60px">${vf401.f40107Zh}</span>
				</p>
			</div>
			<div>
				<p>户口所在地：
					<span class="spanAll" style="width:240px">${vf401.f40109}</span>
					邮编：
					<span class="spanAll" style="width:80px"></span>
				</p>
			</div>
			<div>
				<p>现&nbsp;住&nbsp;址：
					<span class="spanAll" style="width:240px">${vf401.f40110}</span>
					对方姓名：
				<span class="spanAll" style="width:120px">${vf401.f40113}</span>
				</p>
			</div>
			<div>
				<p>
					工作单位：
					<span class="spanAll" style="width:240px">${vf401.f40111}</span>
					联系电话：
					<span class="spanAll" style="width:180px">${vf401.f40112}</span>
				</p>
			</div>
			<div style="width: 800px; padding-top:0px; text-align: center;">
				<span>
		- - - - - - - -以 - - - - - 下- - - - - 由- - - -医- - - - 生 - - - - 填- - - - 写 - - - - - - - 
				</span>
			</div>
			<div  style="width: 800px; padding-top: 0px; text-align: center;">
				<h3>既&nbsp;&nbsp;往&nbsp;&nbsp;史</h3>
			</div>
			<div>
				<p>
					编&nbsp;&nbsp;&nbsp;&nbsp;号：
					<span class="spanAll" style="width:120px">${vf401.f40116}</span>
					对方编号：
					<span class="spanAll" style="width:120px"></span>
				</p>
			</div>
			<div>
				<p>
					检查日期：
					<span class="spanAll" style="width:60px"><%=checkYear%></span>年
					<span class="spanAll" style="width:60px"><%=checkMonth%></span>月
					<span class="spanAll" style="width:60px"><%=checkDay%></span>日
				</p>
			</div>
			<div>
				<p>
					血缘关系：无
							<c:choose>
								<c:when test="${vf401.f40117=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
					                       表
					       <c:choose>
								<c:when test="${vf401.f40117=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>               
					                       唐
					        <c:choose>
								<c:when test="${vf401.f40117=='3' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>     
					                      其他
					        <c:choose>
								<c:when test="${vf401.f40117=='9' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>    
					<span class="spanAll" style="width:160px">${vf401.f40118}</span>
				</p>
			</div>
			<div>
				<p>
					既往病史：
					         无   
						<c:choose>
						<c:when test="${items.f40119_01=='1'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					心脏病 
						<c:choose>
						<c:when test="${items.f40119_02=='2'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					   肺结核  
						<c:choose>
						<c:when test="${items.f40119_03=='3'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					   肝脏病   
						<c:choose>
						<c:when test="${items.f40119_04=='4'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					   泌尿生殖疾病  
						<c:choose>
						<c:when test="${items.f40119_05=='5'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					   糖尿病
						<c:choose>
						<c:when test="${items.f40119_06=='6' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					     高血压
						<c:choose>
						<c:when test="${items.f40119_07=='7'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>  
					       精神病
						<c:choose>
						<c:when test="${items.f40119_08=='8' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>   
					          性病
						<c:choose>
						<c:when test="${items.f40119_09=='9'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>    
					 <br/> <label style="margin-left:90px">癫痫</label>
						<c:choose>
						<c:when test="${items.f40119_10=='10' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>          
					 甲亢
						<c:choose>
						<c:when test="${items.f40119_11=='11' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					   先天疾患
						<c:choose>
						<c:when test="${items.f40119_12=='12'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>   
					其他
						<c:choose>
						<c:when test="${items.f40119_13=='99' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
						</c:choose>
					<span class="spanAll" style="width:160px">${vf401.f40120}</span>
				</p>
			</div>
			<div>
				<p>手术史：无 
					<c:choose>
						<c:when test="${vf401.f40121=='0' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
				有
				 <c:choose>
						<c:when test="${vf401.f40121=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
				<span class="spanAll" style="width:160px">${vf401.f40122}</span>
				现病史：无
					<c:choose>
						<c:when test="${vf401.f40123=='0' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					   有
					   <c:choose>
						<c:when test="${vf401.f40123=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					   <span class="spanAll" style="width:60px">${vf401.f40124}</span>
				</p>
			</div>
			<div>
				<p>
					既往婚史：无
					  <c:choose>
						<c:when test="${vf401.f40125=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					 丧偶
					 <c:choose>
						<c:when test="${vf401.f40125=='2' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					    离异
					 <c:choose>
						<c:when test="${vf401.f40125=='3' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					&nbsp;&nbsp;子女数：<span class="spanAll" style="width:30px">${vf401.f40126 }</span>人
				</p>
			</div>
			<div>
				<p>
					与遗传有关的家族史：无
					<c:choose>
						<c:when test="${items.f40127_01=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					   盲
					 <c:choose>
						<c:when test="${items.f40127_02=='2' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>  
					      聋
					  <c:choose>
						<c:when test="${items.f40127_03=='3' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>       
					      哑
					  <c:choose>
						<c:when test="${items.f40127_04=='4' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>    
					         精神病
					 <c:choose>
						<c:when test="${items.f40127_05=='5' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>          
					          先天性智力低下
					  <c:choose>
						<c:when test="${items.f40127_06=='6' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>           
					           先天性心脏病
					   <c:choose>
						<c:when test="${items.f40127_07=='7'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>             
					           血友病
					   <c:choose>
						<c:when test="${items.f40127_08=='8' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>           
					 <br/>  糖尿病
					 <c:choose>
						<c:when test="${items.f40127_09=='9'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>      
					其他：
					<c:choose>
						<c:when test="${items.f40127_10=='99'}">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>     
					<span class="spanAll" style="width:160px"></span>
					患者与本人关系：<span class="spanAll" style="width:60px">${vf401.f40129Zh}</span>
				</p>
			</div>
			<div>
				<p>
					家族近亲婚配：无   
					<c:choose>
						<c:when test="${items.f40130_01=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					父母
					<c:choose>
						<c:when test="${items.f40130_02=='2' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
					  祖父母
					 <c:choose>
						<c:when test="${items.f40130_03=='3' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose> 
					     外祖父母
					 <c:choose>
						<c:when test="${items.f40130_04=='4' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div style="width: 800px;text-align:right;">
				<p>
					受检者签名：<span class="spanAll" style="width:120px"></span>
					医师签名：<span class="spanAll" style="width:120px"></span>
				</p>
			</div>
			<div  style="width: 800px; padding-top: 0px; text-align: center;">
				<h3>体&nbsp;&nbsp;格&nbsp;&nbsp;检&nbsp;&nbsp;查</h3>
			</div>
			<div>
				<p>
					血压：<span class="spanAll" style="width:120px">${vf401.f40133 }</span>mmHg
				<label style="margin-left:150px">
					特殊体态：无
						<c:choose>
							<c:when test="${vf401.f40136=='0' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					   有
						<c:choose>
							<c:when test="${vf401.f40136=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	   
					<span class="spanAll" style="width:180px">${vf401.f40137}</span></label>
					
				</p>
			</div>
			<div>
				<p>
					精神体态：正常
					<c:choose>
							<c:when test="${vf401.f40134=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					   异常
					  <c:choose>
							<c:when test="${vf401.f40134=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	 
					  <span class="spanAll" style="width:120px">${vf401.f40135}</span></label>
					<label style="margin-left:20px">皮肤毛发：正常
						<c:choose>
							<c:when test="${vf401.f40138=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					  异常
					  <c:choose>
							<c:when test="${vf401.f40138=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					    <span class="spanAll" style="width:180px">${vf401.f40139}</span></label>
					
				</p>
			</div>
			<div>
				<p>
					甲状腺：正常
					<c:choose>
							<c:when test="${vf401.f40140=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					   异常
					   <c:choose>
							<c:when test="${vf401.f40140=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					<label style="margin-left:150px">肺：正常
						<c:choose>
							<c:when test="${vf401.f40148=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					  异常
					  <c:choose>
							<c:when test="${vf401.f40148=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	
					   <span class="spanAll" style="width:180px">${vf401.f40149}</span></label>
				</p>
			</div>
			<div>
				<p>
					  心率：<span class="spanAll" style="width:60px">${vf401.f40150}</span>次/分
					     <label style="margin-left:20px">心律：<span class="spanAll" style="width:60px">${vf401.f40151}</span></label>
					      <label style="margin-left:70px">杂音：无
					  		<c:choose>
							<c:when test="${vf401.f40152=='0' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	    
					         有
						<c:choose>
							<c:when test="${vf401.f40152=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>	         
					  <span class="spanAll" style="width:180px">${vf401.f40153}</span></label>
				</p>
			</div>
			<div>
				<p>四肢：正常
					<c:choose>
							<c:when test="${vf401.f40158=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	
				   肌萎缩
				   <c:choose>
							<c:when test="${vf401.f40158=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	
				      麻痹
				  <c:choose>
							<c:when test="${vf401.f40158=='3' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	    
				        痉挛
				  <c:choose>
							<c:when test="${vf401.f40158=='4' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	      
				          震颤
				    <c:choose>
							<c:when test="${vf401.f40158=='5' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	      
					<label style="margin-left:20px">肝：未及
						 <c:choose>
							<c:when test="${vf401.f40154=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	     
					  可及
					  <c:choose>
							<c:when test="${vf401.f40154=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	      
					 <span class="spanAll" style="width:180px">${vf401.f40155 }</span></label>
				</p>
			</div>
			<div>
				<p>
					
					脊柱：正常
						 <c:choose>
							<c:when test="${vf401.f40159=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
					   异常
					    <c:choose>
							<c:when test="${vf401.f40159=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
					 <span class="spanAll" style="width:180px">${vf401.f40160}</span>
				</p>
			</div>
			<div style="width: 800px;text-align:right;">
				<p>
					医师签名：<span class="spanAll" style="width:120px"></span>
					<div style="width: 800px; padding-top: 20px; text-align: center;page-break-before:always"><h3>第&nbsp;&nbsp;二&nbsp;&nbsp;性&nbsp;&nbsp;征</h3></div>
				</p>
			</div>
				<div>
					<p>
						喉结：有
					<c:choose>
							<c:when test="${vf401.f40161=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
						    无
					<c:choose>
							<c:when test="${vf401.f40161=='0' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
						<label style="margin-left:350px">阴毛：正常
						<c:choose>
							<c:when test="${vf401.f40162=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
					稀少
						 <c:choose>
							<c:when test="${vf401.f40162=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	     
					 无
					<c:choose>
							<c:when test="${vf401.f40162=='3' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   		     
						     </label>   
					</p>
				</div>
				<div>
					<p>
					生殖器：阴茎：正常
					<c:choose>
							<c:when test="${vf401.f40165=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	  
					   异常
					  <c:choose>
							<c:when test="${vf401.f40165=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
					  <span class="spanAll" style="width:80px">${vf401.f40166}</span>
					<label style="margin-left:170px">包皮：正常
						<c:choose>
							<c:when test="${vf401.f40167=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	  
					   过长
					   <c:choose>
							<c:when test="${vf401.f40167=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	
					       包茎
					   <c:choose>
							<c:when test="${vf401.f40167=='3' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
					</c:choose>	   
					  </label>
					</p>
				</div>
				<div>
					<p>
						<label style="margin-left:65px">
							睾丸：体积左：<span class="spanAll" style="width:80px">${vf401.f40168}</span>
							              体积右：<span class="spanAll" style="width:80px">${vf401.f40169}</span>（ml）
						</label>
						<label style="margin-left:61px">
							未扪及：左
					<c:choose>
						<c:when test="${vf401.f40170=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	  
						右
					<c:choose>
						<c:when test="${vf401.f40170=='2' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	  
						</label>
					</p>
				</div>
				<div>
					<p>
						<label style="margin-left:65px">
						附睾：正常
					<c:choose>
						<c:when test="${vf401.f40171=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	 
						   异常
					<c:choose>
						<c:when test="${vf401.f40171=='2' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	 	
						</label>
						<label style="margin-left:190px">
							附睾左：<span class="spanAll" style="width:80px">${vf401.f40172 }</span>
							附睾右：<span class="spanAll" style="width:80px">${vf401.f40173 }</span>
						</label>
					</p>
				</div>
				<div>
					<p>
						<label style="margin-left:65px">
							精索静脉曲线：有
					<c:choose>
						<c:when test="${vf401.f40174=='1' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	 
						无
					<c:choose>
						<c:when test="${vf401.f40174=='0' }">☑</c:when>
						<c:otherwise>☐</c:otherwise>
					</c:choose>	 
						</label>
						<label style="margin-left:180px">
							部位：<span class="spanAll" style="width:80px">${vf401.f40175}</span>
							程度：<span class="spanAll" style="width:80px">${vf401.f40176}</span>
						</label>
					</p>
				</div>
				<div style="width: 800px;text-align:right;">
					<p>
						医师签名：<span class="spanAll" style="width:120px"></span>
					</p>
				</div>
				<div>
					<p>
						<div style="width: 800px; padding-top: 20px; text-align: center;"><h3>&nbsp;实&nbsp;验&nbsp;室&nbsp;检&nbsp;查</h3></div>
					</p>
				</div>
				<div>
					<p>
						<label>--------------------------------------------------------------------------------</label>
						<br>*    <label style="margin-left:60px">胸部透视、血常规、尿常规、梅毒筛查、血转氨酶和乙肝表面抗原检测、&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;及其他特殊检查
								
						</label> 
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>检测报告粘贴处</b>                     
						<label style="margin-left:470px">*</label>
						<br>*																				 <label style="margin-left:620px">*</label>
						<br>*																				 <label style="margin-left:620px">*</label>
						<br>*																				 <label style="margin-left:620px">*</label>
						<br>--------------------------------------------------------------------------------
					</p>
				</div>
				<div>
					<p>
						检查结果：正常
						<c:choose>
							<c:when test="${vf401.f40186=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
						   异常
						 <c:choose>
							<c:when test="${vf401.f40186=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
						 异常情况：<span class="spanAll" style="width:380px">${vf401.f40187}</span>
					</p>
				</div>
				<div>
					<p>
						<label style="margin-left:80px">疾病诊断：<span class="spanAll" style="width:380px">${vf401.f40188}</span></label>
					</p>
				</div>
				<div>
					<p>
					医学意见：未发现医学上不宜结婚的情形
						<c:choose>
							<c:when test="${vf401.f40189=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
					建议暂缓结婚
						<c:choose>
							<c:when test="${vf401.f40189=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
					    建议不宜生育
					 <c:choose>
							<c:when test="${vf401.f40189=='3' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>    
					        建议不宜结婚
					   <c:choose>
							<c:when test="${vf401.f40189=='4' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>    
					</p>
				</div>
				<div>
					<p>
						<label style="margin-left:75px">建议采取医学措施，尊重受检者意愿
						<c:choose>
							<c:when test="${vf401.f40189=='5' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
						</label>
					</p>
				</div>
				<div style="width: 800px;text-align:right;">
					<p>
						受检双方签名：<span class="spanAll" style="width:120px"></span>
					</p>
				</div>
				<div>
					<p>
						婚前卫生咨询：<span class="spanAll" style="width:380px">${vf401.f40190}</span>
					</p>
				</div>
				<div>
					<p>
						咨询指导结果：接受指导意见
						<c:choose>
							<c:when test="${vf401.f40191=='1' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
						    不接受指导意见，知情后选择结婚，后果自己承担
						  <c:choose>
							<c:when test="${vf401.f40191=='2' }">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose> 
					</p>
				</div>
				<div style="width: 800px;text-align:right;">
					<p>
						受检双方签名：<span class="spanAll" style="width:120px"></span>
					</p>
				</div>
				<div>
					<p>
						转诊医院：<span class="spanAll" style="width:120px"></span>
						<label>
							转诊日期：<span class="spanAll" style="width:80px"></span>年
							<span class="spanAll" style="width:80px"></span>月
							<span class="spanAll" style="width:80px"></span>日
						</label>
					</p>
				</div>
				<div>
					<p>
						预约复诊日期：<span class="spanAll" style="width:80px"></span>年
							<span class="spanAll" style="width:80px"></span>月
							<span class="spanAll" style="width:80px"></span>日
					</p>
				</div>
				<div>
					<p>
							出具《婚前医学     检查证明》日期：<span class="spanAll" style="width:80px"></span>年
							<span class="spanAll" style="width:80px"></span>月
							<span class="spanAll" style="width:80px"></span>日
					</p>
				</div>
				<div style="width: 800px;text-align:right;">
					<p>
						主治医师签名：<span class="spanAll" style="width:120px"></span>
					</p>
				</div>
				</div>
			</div>
			
	</center>
</body>
</html>