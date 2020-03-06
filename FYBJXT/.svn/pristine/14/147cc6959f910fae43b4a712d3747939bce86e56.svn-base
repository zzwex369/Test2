<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	text-align: left;
	border-bottom: solid 1px black;
	display: Inline-Block;
	vertical-align: bottom;
}

 body{			zoom:1;
  			font-size: 21px;
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
w40{
	width:40px;
}
.w60{
	width:60px;
}
.w80{
	width:80px;
}
.w120{
	width:120px;
}
.Pall{
	margin-top: 20px;
	padding-left: 120px;
}
.line {
	border-bottom: solid 5px black;
	width: 763px;
	margin-left: 1px;
	padding-top: 10px
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
</head>

<body>
	<center>
		<h2 style="text-align:center;"><b>河南省免费产前超声筛查申请单</b></h2>
		<div class="d2">
			<div class="div" id="divId">
				<div class="divAll">
					<p class="Pall" align="left">
						请申请医师认真填写本栏内容：
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>姓名：</span>
						<span class="w60">${requestScope.vf501.f50103}</span>
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
						<span>身份证号：</span>
						<span class="w120">${requestScope.vf501.f50105}</span>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">出生日期：
						<span class="spanAll w60">${requestScope.nian06}</span>年
						<span class="spanAll w60">${requestScope.yue06}</span>月
						<span class="spanAll w60">${requestScope.ri06}</span>日（公历）
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>年龄：</span>
						<span class="w60">
							<c:choose>
								<c:when test="${empty requestScope.vf501.f50131}">
								</c:when>
								<c:otherwise>
									${requestScope.vf501.f50131}
								</c:otherwise>

							</c:choose>
						</span>
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
						<span>联系电话：</span>
						<span class="w120">${requestScope.vf501.f50107}</span>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
					<span>体重：</span>
						<span class="spanAll w40">${requestScope.vf501.f50108}</span>（公斤）
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
						<span>吸烟史：</span>
						<c:choose>
							<c:when test="${requestScope.vf501.f50109 == 1}">是</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.vf501.f50109 == 2}">否</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>糖尿病史：</span>
						<c:choose>
							<c:when test="${requestScope.vf501.f50110 == 1}">是</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.vf501.f50110 == 2}">否</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
						高血压史：
						<c:choose>
							<c:when test="${requestScope.vf501.f50111 == 1}">是</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.vf501.f50111 == 2}">否</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						既往超声检查异常：
						<span style="width: 350px;">${requestScope.vf501.f50116}</span>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
					IVF：
						<c:choose>
							<c:when test="${requestScope.vf501.f50112 == 1}">是</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.vf501.f50112 == 2}">否</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						植入日期：
						<c:choose>
							<c:when test="${requestScope.nian13 eq ''}">无</c:when>
							<c:otherwise><span class="spanAll w60">${requestScope.nian13}</span>年</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.yue13 eq ''}"></c:when>
							<c:otherwise><span class="spanAll w60">${requestScope.yue13}</span>月</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${requestScope.ri13 eq ''}"></c:when>
							<c:otherwise><span class="spanAll w60">${requestScope.ri13}</span>日（公历）</c:otherwise>
						</c:choose>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">本次怀孕胎儿数：
						<c:choose>
							<c:when test="${requestScope.vf501.f50114 == 1}">单胎</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<label style="margin-left: 10px">
						<c:choose>
							<c:when test="${requestScope.vf501.f50114 == 2}">双胞胎</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						</label>
						<label style="margin-left: 10px">
						<c:choose>
							<c:when test="${requestScope.vf501.f50114 == 3}">多胎</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>（胎数：${requestScope.vf501.f50115}  ）
						</label>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">末次月经：
						<span class="spanAll w60">${requestScope.nian17}</span>年
						<span class="spanAll w60">${requestScope.yue17}</span>月
						<span class="spanAll w60">${requestScope.ri17}</span>日（公历）
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">月经周期：
						<span class="spanAll w60">${requestScope.vf501.f50118}</span>天   （不规律者需用B超计算孕周）
					</p>
				</div>
				
				<div class="divAll">
					<p class="Pall" align="left">
					异常妊娠史：
						<c:choose>
							<c:when test="${requestScope.c1 == 1}">21-三体综合症</c:when>
							<c:otherwise>无</c:otherwise>
						</c:choose>
						<label style="margin-left: 5px"><c:choose>
							<c:when test="${requestScope.c2 == 2}">开放性神经管缺陷</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
						<label style="margin-left: 5px;"><c:choose>
							<c:when test="${requestScope.c3 == 3}">自然流产史</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
						<label><c:choose>
							<c:when test="${requestScope.c4 == 4}">死胎史</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
						
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left" style="margin-left:150px">
						<c:choose>
							<c:when test="${requestScope.c5 == 5}">新生儿死亡史</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<label style="margin-left: 5px"><c:choose>
							<c:when test="${requestScope.c6 == 6}">18-三体综合征</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
						<label style="margin-left: 5px"><c:choose>
							<c:when test="${requestScope.c7 == 7}">孕期感染史</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
						<label style="margin-left: 5px"><c:choose>
							<c:when test="${requestScope.c8 == 8}">其他</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></label>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						家族史：<span style="width: 180px;">${requestScope.vf501.f50122}</span>
						
					</p>
					
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<label>
						临床诊断：<span  style="width: 120px;">${requestScope.vf501.f50123}</span></label>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						<span>申请医生：</span>
						<span class="w80">${requestScope.vf501.f50124}</span>
					</p>
				</div>
				<div>
					<p class="Pall" align="left">
						<span>申请日期：</span>
						<span class="w120">${requestScope.vf501.f50125Str}</span>
					</p>
				</div>
				<div class="divAll">
					<p class="Pall" align="left">
						申请单位名称：<span style="width:300px">${requestScope.vf501.f50126Zh}</span>
					</p>
				</div>
				<div class="Noprint" align="center" style="padding-top: 10px">
				<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
				<input type="button" value="执行打印"  onclick='wb.execwb(6,6)' style="width:80px;background-color:#f7f7f7"/>
				<input type="button" value="打印设置" onclick="wb.execwb(8,1)" style="width:80px;background-color:#f7f7f7;margin-left:60px;"/> 
				<input type="button" value="打印预览" onclick='wb.execwb(7,1)' style="width:80px;background-color:#f7f7f7;margin-left:60px;"/> 
			</div>
			</div>
		</div>
		</center>
</body>
</html>