<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.xyw.medical.etbj.model.VE501" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<html lang="en">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河南省儿童（新生儿）听力筛（复）查报告单</title>
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
<% 
	VE501 ve501 = (VE501)request.getAttribute("ve501");
	String birthDay[] = (ve501.getE50108Str()).split("-");//婴儿出生日期
	String birthDayYear = birthDay[0];//婴儿出生日期----年
	String birthDayMonth = birthDay[1];//婴儿出生日期----月
	String birthDayDay = birthDay[2];//婴儿出生日期----日
	//筛查日期
	String ScreenDay[] = (ve501.getE50118Str()).split("-");
	String ScreenDayYear = ScreenDay[0];
	String ScreenDayMonth = ScreenDay[1];
	String ScreenDayDay = ScreenDay[2];
%>
	<center>
		<h1 style="text-align:center;">河南省儿童(新生儿)听力筛（复）查报告单</h1>
		<div class="d2">
			<table class="table" style="border-collapse:separate; border-spacing:15px;">
				<tr>
					<td colspan='3'>
						<label style="margin-left:430px">编号：
							<span class="spanAll" style="width:120px">
								<c:if test="${ve501.e50120 !=null}">
									${ve501.e50120}
								</c:if>
							</span>
						</label>
					</td>
				</tr>
				<tr>
					<td>
					<label style="margin-left:50px">筛查医院：
						<span class="spanAll" style="width:120px">
							<c:if test="${ve501.e50119!=null}">
								${ve501.e50119}
							</c:if>
						</span></label>
						家长姓名：
						<span class="spanAll" style="width:120px">
							<c:if test="${ve501.e50103!=null}">
								${ve501.e50103 }
							</c:if>
						</span>
					</td>
				</tr>
				<tr>
					<td>
					<label style="margin-left:50px">身份证号码：
						<span class="spanAll" style="width:120px">
							<c:if test="${ve501.e50104!=null}">
								${ve501.e50104 }
							</c:if>
						</span></label>
						联系电话：
						<span class="spanAll" style="width:120px">
							<c:if test="${ve501.e50105!=null}">
								${ve501.e50105 }
							</c:if>
						</span>
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">儿童（新生儿）姓名：
							<span class="spanAll" style="width:120px">
								<c:if test="${ve501.e50106!=null}">
								${ve501.e50106 }
							</c:if>
							</span>
						</label>
						新生儿性别：
						<c:if test="${ve501.e50107!=null }">
							男
							<c:choose>
								<c:when test="${ve501.e50107=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						<label style="margin-left:10px">
							女
							<c:choose>
								<c:when test="${ve501.e50107=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						</c:if>	
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">
							婴儿出生医院：
							<span class="spanAll" style="width:180px">
							<c:if test="${ve501.e50111!=null}">
									${ve501.e50111 }
								</c:if>
							</span>
						</label>
						出生日期：
						<span class="spanAll" style="width:30px"><%=birthDayYear%></span>年
						<span class="spanAll" style="width:30px"><%=birthDayMonth %></span>月
						<span class="spanAll" style="width:30px"><%=birthDayDay %></span>日
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">
							出生时孕周：<span  class="spanAll" style="width:60px">
										<c:if test="${ve501.e50109!=null }">
											${ ve501.e50109}
										</c:if>
									</span>
						</label>
						出生时体重：<span  class="spanAll" style="width:60px">
								<c:if test="${ ve501.e50110!=null}">
									${ ve501.e50110}
								</c:if>
							</span>Kg
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${ve501.e50112!=null}">
						<label style="margin-left:50px">
							检查方法：
							<c:choose>
								<c:when test="${ve501.e50112=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
							耳声发射（OAE）	
						</label>
						<br/>
						<label style="margin-left:138px">
						<c:choose>
								<c:when test="${ve501.e50112=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
							自动听性脑干反应（AABR）	
						</label>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${ve501.e50113!=null}">
						<label style="margin-left:50px">
							检查结果：
							初筛：
							<c:choose>
								<c:when test="${ve501.e50113=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<label style="margin-left:120px">
							复筛：</label>
							<label style="margin-left:14px">
								<c:choose>
								<c:when test="${ve501.e50113=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
							</label>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${ve501.e50114!=null}">
						<label style="margin-left:80px">
							右耳：
							通过：
							<c:choose>
								<c:when test="${ve501.e50114=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>	
						</label>
						<label style="margin-left:120px">
							未通过：
							<c:choose>
								<c:when test="${ve501.e50114=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${ve501.e50115!=null }">
						<label style="margin-left:80px">
							左耳：
							通过：
							<c:choose>
								<c:when test="${ve501.e50115=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<label style="margin-left:120px">
							未通过：
							<c:choose>
								<c:when test="${ve501.e50115=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">
							意见：1.通过；
						</label>
						<br/>
						<label style="margin-left:98px">
							2.未通过：请于婴儿出生后42天到初筛机构复查；
						</label>
						<br/>
						<label style="margin-left:98px">
							3.复查未通过，请于婴儿出生后3个月内到省新筛中心。或省
						</label>
						<br/>
						<label  style="margin-left:98px">
							级听力障碍诊治机构确诊。
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">
							筛查者签名：
							<span class="spanAll" style="width: 120px">
								<c:if test="${ve501.e50117!=null }">
									${ve501.e50117 }
								</c:if>
							</span>
						</label>
						报告时间：<span class="spanAll" style="width: 40px"><%=ScreenDayYear %></span>年
						<span class="spanAll" style="width: 40px"><%=ScreenDayMonth %></span>月
						<span class="spanAll" style="width: 40px"><%=ScreenDayDay %></span>日
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left:50px">
							备注：
						</label>
						<br/>
						<label style="margin-left:70px">
							1.“通过”说明您的孩子目前外周听觉器官功能正常，但在儿
						</label>
						<br/>
						<label style="margin-left:100px">
							童发育过程中，听力会受多种因素影响，如：疾病、噪音
						</label>
						<br/>
						<label style="margin-left:100px">
							等，请您继续关注孩子的听力与语言发育，发现异常及时就诊。
						</label>
					</td>
					</tr>
					<tr>
						<td>
						<label style="margin-left:70px">
							2.“未通过”表示在您孩子外耳道未记录到耳声发射反应，
						</label>
						<br/>
						<label style="margin-left:100px">
							可能是孩子的听力有问题，也可能是由于测试环境噪音
						</label>
						<br/>
						<label style="margin-left:100px">
							过大或婴儿耳道内分泌物堵塞引起，因此需要按时复查。
						</label>
						</td>
					</tr>
			</table>
		</div>
	</center>
</body>
</html>