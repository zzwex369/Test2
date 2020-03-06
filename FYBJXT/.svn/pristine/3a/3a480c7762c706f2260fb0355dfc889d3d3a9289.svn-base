<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.xyw.medical.etbj.model.VE502"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河南省新生儿复筛及延迟听力筛查预约通知单</title>
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
		VE502 ve502 = (VE502)request.getAttribute("ve502");
		String birthDay[] = (ve502.getE50215Str()).split("-");
		String birthDayYear = birthDay[0];//出生日期---年
		String birthDayMonth = birthDay[1];//出生日期---月
		String birthDayDay = birthDay[2];//出生日期---月
		String appointment[] = (ve502.getE50230Str()).split("-");
		String appointmentYear = appointment[0];
		String appointmentMonth = appointment[1];
		String appointmentDay = appointment[2];
	%>
	<center>
		<h1 style="text-align:center;"><nobr>河南省新生儿复筛及延迟听力筛查预约通知单</nobr></h1>
			<div class="d2">
				<table class="table" style="border-collapse:separate; border-spacing:15px;">
					<tr>
						<td>
							<label style="margin-left:430px">编号：
							<span class="spanAll" style="width:120px">${ve502.e50204 }</span>
						</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								母亲姓名：
								<c:if test="${ve502.e50205!=null }">
								<span class="spanAll" style="width:60px">${ve502.e50205 }</span>
								</c:if>
							</label>
							年龄：
							<span class="spanAll" style="width:60px">
								<c:if test="${ve502.e50207!=null }">
									${ve502.e50207}
								</c:if>
							</span>；
								父亲姓名：
								<span class="spanAll" style="width:60px">
									<c:if test="${ve502.e50208!=null }">
									${ve502.e50208}
								</c:if>
								</span>
							年龄：
							<span class="spanAll" style="width:60px">
								<c:if test="${ve502.e50210!=null }">
									${ve502.e50210}
								</c:if>
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								家庭地址：
								<span class="spanAll" style="width:150px">
									<c:if test="${ve502.e50211!=null }">
									${ve502.e50211}
								</c:if>
								</span>
							</label>
							联系电话：
							<span class="spanAll" style="width:150px">
								<c:if test="${ve502.e50212!=null }">
									${ve502.e50212}
								</c:if>
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								新生儿姓名：
								<span class="spanAll" style="width:60px">
									<c:if test="${ve502.e50213!=null }">
									${ve502.e50213}
								</c:if>
								</span>
							</label>
							出生日期：<c:if test="<%=birthDay!=null%>">
							<span class="spanAll" style="width:40px"><%=birthDayYear%></span>年
							<span class="spanAll" style="width:40px"><%=birthDayMonth%></span>月
							<span class="spanAll" style="width:40px"><%=birthDayDay%></span>日
								</c:if>
						</td>
					</tr>
					<tr>
						<td>
							
						<label style="margin-left:20px">	新生儿性别：
							男
							<c:choose>
								<c:when test="${ve502.e50214=='1' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
							</label>
						<label style="margin-left:10px">
							女
							<c:choose>
								<c:when test="${ve502.e50214=='2' }">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<label style="margin-left:20px">
							婴儿出生医院：
							<span class="spanAll" style="width:160px">
								<c:if test="${ve502.e50219!=null }">
									${ ve502.e50219}
								</c:if>
							</span>
						</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								住院门诊号：<span class="spanAll" style="width:120px">
									<c:if test="${ve502.e50220!=null}">
										${ve502.e50220}
									</c:if>
								</span>
							</label>
							初筛机构：
							<span class="spanAll" style="width:120px">
									<c:if test="${ve502.e50221!=null}">
										${ve502.e50221}
									</c:if>
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								产妇情况：
								<span class="spanAll" style="width:240px">
									<c:if test="${ve502.e50225!=null}">
										${ve502.e50225 }
									</c:if>
								</span>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								新生儿出生情况：出生孕周<span class="spanAll" style="width:50px">
									<c:if test="${ve502.e50216!=null }">
										${ve502.e50216}
									</c:if>
								</span>
							</label>
							出生体重
							<span class="spanAll" style="width:50px">
								<c:if test="${ve502.e50217!=null }">
										${ve502.e50217}
									</c:if>
							</span>g
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:150px">
								顺产
								<c:choose>
									<c:when test="${ve502.e50218=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<label style="margin-left:10px">
								剖宫产
								<c:choose>
									<c:when test="${ve502.e50218=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<label style="margin-left:10px">
								臀产
								<c:choose>
									<c:when test="${ve502.e50218=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<label style="margin-left:10px">
								其他
								<c:choose>
									<c:when test="${ve502.e50218=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								新生儿高危儿因素：阿氏评分<span class="spanAll" style="width:40px">
									<c:if test="${ve502.e50226!=null}">
										${ve502.e50226 }
									</c:if>
								</span>
							</label>
							<label style="margin-left:10px">
								高危因素：<span class="spanAll" style="width:40px">
									<c:if test="${ve502.e50227!=null }">
										${ve502.e50227}
									</c:if>
								</span>（编号）
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								其他：<span class="spanAll" style="width:240px">
									<c:if test="${ve502.e50228!=null }">
										${ve502.e50228}
									</c:if>
								</span>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								延迟筛查原因：<span class="spanAll" style="width:240px">
									<c:if test="${ve502.e50229!=null }">
										${ve502.e50229}
									</c:if>
								</span>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								初查方法：
								<c:choose>
									<c:when test="${ve502.e50222=='1' }">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>耳声发射（OAE）
							</label>
							<label style="margin-left:20px">
								<c:choose>
									<c:when test="${ve502.e50222=='2' }">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>耳声发射（OAE）自动听性脑干反应（AABR）
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<c:if test="${ ve502.e50223!=null}">
							<label style="margin-left:20px">
								初查结果：右耳：
								通过
								<c:choose>
									<c:when test="${ve502.e50223=='1' }">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<label style="margin-left:60px">
								未通过
								<c:choose>
									<c:when test="${ve502.e50223=='2' }">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							</c:if>
						</td>
					</tr>
					<tr>
						<td><c:if test="${ ve502.e50223!=null}">
							<label style="margin-left:100px">
								左耳：</label><label style="margin-left:8px">通过
										<c:choose>
											<c:when test="${ve502.e50224=='1' }">☑</c:when>
											<c:otherwise>☐</c:otherwise>
										</c:choose>
										</label>
									</c:if>
							<label style="margin-left:60px">
								未通过
								<c:choose>
									<c:when test="${ve502.e50224=='2' }">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px"><c:if test="<%=appointment!=null%>">
								预约筛查日期：<span class="spanAll" style="width: 60px"><%=appointmentYear %></span>年
								<span class="spanAll" style="width: 60px"><%=appointmentMonth %></span>月
								<span class="spanAll" style="width: 60px"><%=appointmentDay %></span>日
								</c:if>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								预约筛查机构：<span class="spanAll" style="width: 160px">
												<c:if test="${ve502.e50231!=null }">
													${ve502.e50231}
												</c:if>
										</span>
								告知人：<span class="spanAll" style="width: 80px">
												<c:if test="${ve502.e50232!=null }">
													${ve502.e50232}
												</c:if>
									</span>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								1.新生儿未通过初步筛查者及漏筛者于42天内均应当进行双耳复筛；
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								2.请新生儿家长在延迟因素解除后，持此单到指定机构进行听力筛查；
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="margin-left:20px">
								<nobr>3.新生儿高危儿因素：填写高危因素编码，具体参考见《新生儿听力高危因素》提示。</nobr>
							</label>
						</td>
					</tr>
				</table>
		</div>
	</center>
</body>
</html>