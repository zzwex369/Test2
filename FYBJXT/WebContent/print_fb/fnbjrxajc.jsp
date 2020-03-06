<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.xyw.medical.fnbj.model.VL402"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>乳腺癌检查信息</title>
<style>
body {
	font-family: '宋体', '微软雅黑'; /*统一浏览器字体*/
	padding: 0; /*清空浏览器边距*/
	margin: 0;
	/* overflow: auto;/*页面滚动条*/
}

@media print {
	.Noprint {
		display: none;
	}
}

div { /*自动居中*/
	margin: auto;
	height: auto;
	zoom: 1;
	width: 1100px;
}

/*input {*/ /*vertical-align: middle;*/ /*font-weight: bold;*/
	/*width: 20px;*/ /*height: 25px;}*/ /*.d2{*/ /*padding-top: 20px;*/
	/*}*/
.line {
	border-bottom: solid 5px black;
	width: 100%;
	padding-top: 0px;
}

.spanAll {
	text-align: left;
	border-bottom: solid 1px black;
	display: Inline-Block;
	vertical-align: bottom;
}

/*p{*/ /*display:inline-block;*/ /*margin-top:0px;*/
	/*margin-bottom:0px;*/ /*}*/
.fz18 {
	font-size: 18px;
}

.fz20 {
	font-size: 20px;
}

.fz25 {
	font-size: 25px;
}

.pf60 {
	padding-left: 60px;
}

.pf255 {
	padding-left: 255px;
}

.fwb {
	font-weight: bolder;
}

.w40 {
	width: 40px;
}
.w55 {
	width: 55px;
}
.w72 {
	width: 72px;
}
.w79 {
	width: 79px;
}
.w80 {
	width: 80px;
}

.w140 {
	width: 140px;
}

.w200 {
	width: 200PX;
}

.w252 {
	width: 252px;;
}

.w275 {
	width: 275px;
}

.w400 {
	width: 400px;
}

.display-block {
	display: inline-block;
}

.margin7 {
	margin: 7px 0px 2px 0px;
}

.margin2 {
	margin: 2px 0px 0px 0px;
}
</style>
		</head>
		<body>
			<% 
			VL402 vl402 = (VL402) request.getAttribute("vl402");
			String [] l40215Arr=vl402.getL40215().split(",");	
			String []numArr={"二","三","四","五"};
			int i=0;
			%>
			<div>
				<div>
					<p align="center" class="fz25">
						乳腺癌检查信息
					</p>
				</div>
				<p class="line"></p>
				<div>
					<p align="left" class="fz20 margin7">
						(一)病史情况
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						1.月经情况
					</p>
					<span class="pf60">初潮年龄：</span><span class="spanAll w40">${vl402.l40206}岁</span>
					<span>末次月经：</span><span class="spanAll w140">${vl402.l40207Str}</span>
					<span>绝经：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40208=='2'}">否☑</c:when>
							<c:otherwise>否☐</c:otherwise>
						</c:choose>
					</label>
					<label>
						<c:choose>
							<c:when test="${vl402.l40208=='1'}">是☑</c:when>
							<c:otherwise>是☐</c:otherwise>
						</c:choose>
					</label>
					<label>
						<c:choose>
							<c:when test="${vl402.l40208=='3'}">不确定☑</c:when>
							<c:otherwise>不确定☐</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40208=='1'}">
						<span>绝经年龄:</span>
						<span class="spanAll w40">${vl402.l40209}岁</span>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						2.孕产史
					</p>
					<span class="pf60">是否生产：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40210=='1'}">是☑</c:when>
							<c:otherwise>否☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40210=='1'}">
						<span>初产年龄:</span>
						<span class="spanAll w40">${vl402.l40211}岁</span>
					</c:if>
					<span>是否哺乳：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40208=='1'}">是☑</c:when>
							<c:otherwise>否☑</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						3.过去是否接受过乳腺检查
					</p>
					<span class="pf60">是否接受过乳腺检查：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40213=='1'}">是☑</c:when>
							<c:otherwise>否☑</c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if test="${vl402.l40213=='1'}">
					<div>
						<span class="pf60">近期检查时间:</span>
						<span class="spanAll w55">${vl402.l40214}年</span>
						<span>检查内容:</span>
						<span>a.手诊：</span>
						<label>
							<c:choose>
								<c:when test="<%=l40215Arr[0].equals("1")%>">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>b.超声：</span>
						<label>
							<c:choose>
								<c:when test="<%=l40215Arr[1].equals("2")%>">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>c.X线：</span>
						<label>
							<c:choose>
								<c:when test="<%=l40215Arr[2].equals("3")%>">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>d.不详：</span>
						<label>
							<c:choose>
								<c:when test="<%=l40215Arr[3].equals("4")%>">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<c:if test="<%=l40215Arr[4].equals("9")%>">
							<span>其他:</span>
							<span class="spanAll w200">${vl402.l40216}</span>
						</c:if>
					</div>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.乳腺手术或活检史
					</p>
					<span class="pf60">乳腺手术或活检史：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40217=='1'}">是☑</c:when>
							<c:otherwise>否☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40217=='1'}">
						<span>次数:</span>
						<span class="spanAll w40">${vl402.l40218}次</span>
						<span>病理结果：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40219=='1'}">☑良性</c:when>
								<c:otherwise>☑恶性</c:otherwise>
							</c:choose>
						</label>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						5.激素替代治疗史
					</p>
					<span class="pf60">激素替代治疗史：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40220=='1'}">是☑</c:when>
							<c:otherwise>否☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40220=='1'}">
						<span>用药时间:</span>
						<span class="spanAll w40">${vl402.l40221}年</span>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb  margin7">
						6.二级以内亲属乳腺癌或卵巢癌家族史
					</p>
					<p class="margin2">
						<span class="pf60  w140 display-block">(1).乳腺癌：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40222=='1'}">是☑</c:when>
								<c:otherwise>否☑</c:otherwise>
							</c:choose>
						</label>
						<c:if test="${vl402.l40222=='1'}">
							<span>患病家属与自己的关系:</span>
							<span class="spanAll w400">${vl402.l40223Zh}</span>
						</c:if>
					</p>
					<p class="margin2">
						<span class="pf60 w140 display-block">(2).卵巢癌：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40224=='1'}">是☑</c:when>
								<c:otherwise>否☑</c:otherwise>
							</c:choose>
						</label>
						<c:if test="${vl402.l40224=='1'}">
							<span>患病家属与自己的关系:</span>
							<span class="spanAll w400">${vl402.l40225Zh}</span>
						</c:if>
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						7.检查机构
					</p>
					<span class="pf60">检查机构:</span>
					<span class="spanAll w200">${vl402.l402123Zh}</span>
					<span>检查人员:</span>
					<span class="spanAll w200">${vl402.l402124}</span>
					<span>检查日期:</span>
					<span class="spanAll w200">${vl402.l402125Str}</span>
				</div>
				<p class="line"></p>
			 <c:if test="${vl402.l40244!=null}">
				<div>
					<p align="left" class="fz20 margin7">
						(<%=numArr[i]%>)乳腺触诊
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						1.左乳症状
					</p>
					<span class="pf60">症状：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40226=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40226=='1'}">
						<c:if test="${vl402.l40227=='1'}">
							<span>乳腺疼痛：</span>
							<label>
								☑
							</label>
							<span>a.周期性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40228=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>b.非周期性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40228=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</c:if>
						<c:if test="${vl402.l40227=='2'}">
							<span>乳头溢液：</span>
							<label>
								☑
							</label>
							<span>a.血性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40229=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>b.浆液性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40229=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>c.其它：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40229=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</c:if>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						2.左乳体征
					</p>
					<span class="pf60">体征：</span>
					<span>(1).未见异常：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(2).乳房肿块或团块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(3).不对称性增厚或结节：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(4).皮肤改变：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(5).腋淋巴结肿大：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(6).其它：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40230=='9'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if
					test="${vl402.l40230=='3'||vl402.l40230=='4'||vl402.l40230=='9'}">
					<div>
						<c:if test="${vl402.l40230=='3'}">
							<span class="pf60">最大径:</span>
							<span class="spanAll w40">${vl402.l40231}</span>
							<span>CM</span>
						</c:if>
						<c:if test="${vl402.l40230=='4'}">
							<span class="pf60">皮肤改变详细:</span>
							<span class="spanAll w200">${vl402.l40232}</span>
						</c:if>
						<c:if test="${vl402.l40230=='9'}">
							<span class="pf60">其它详细:</span>
							<span class="spanAll w200">${vl402.l40233}</span>
						</c:if>
					</div>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						3.右乳症状
					</p>
					<span class="pf60">症状：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40234=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40234=='1'}">
						<c:if test="${vl402.l40235=='1'}">
							<span>(1)乳腺疼痛：</span>
							<label>
								☑
							</label>
							<span>a.周期性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40236=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>b.非周期性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40236=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</c:if>
						<c:if test="${vl402.l40235=='2'}">
							<span>(2)乳头溢液：</span>
							<label>
								☑
							</label>
							<span>a.血性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40237=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>b.浆液性：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40237=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span>c.其它：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40237=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</c:if>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.右乳体征
					</p>
					<span class="pf60">体征：</span>
					<span>(1).未见异常：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(2).乳房肿块或团块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(3).不对称性增厚或结节：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(4).皮肤改变：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(5).腋淋巴结肿大：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(6).其它：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40238=='9'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if
					test="${vl402.l40238=='3'||vl402.l40238=='4'||vl402.l40238=='9'}">
					<div>
						<c:if test="${vl402.l40238=='3'}">
							<span class="pf60">最大径:</span>
							<span class="spanAll w40">${vl402.l40239}</span>
							<span>CM</span>
						</c:if>
						<c:if test="${vl402.l40238=='4'}">
							<span class="pf60">皮肤改变详细:</span>
							<span class="spanAll w200">${vl402.l40240}</span>
						</c:if>
						<c:if test="${vl402.l40238=='9'}">
							<span class="pf60">其它详细:</span>
							<span class="spanAll w200">${vl402.l40241}</span>
						</c:if>
					</div>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						5.临床检查结果
					</p>
					<span class="pf60">临床检查结果：</span>
					<span>(1).未见异常：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40242=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(2).良性病变：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40242=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(3).可疑恶性：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40242=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40242=='2'}">
						<span>良性病变详细:</span>
						<span class="spanAll w400">${vl402.l40243}</span>
					</c:if>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						8.检查机构
					</p>
					<span class="pf60">检查机构:</span>
					<span class="spanAll w200">${vl402.l40244Zh}</span>
					<span>检查人员:</span>
					<span class="spanAll w200">${vl402.l40245}</span>
					<span>检查日期:</span>
					<span class="spanAll w200">${vl402.l40246Str}</span>
				</div>
				<p class="line"></p>
				<%++i; %>
				</c:if>
				<c:if test="${vl402.l40284!=null}">
				<div>
					<p align="left" class="fz20 margin7">
						(<%=numArr[i]%>)乳腺彩色超声检查
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						1.左乳超声评估 BI-RADS 分级
					</p>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(1).左乳囊肿
					</p>
					<span class="pf60">囊肿：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40247=='0'}">无☑</c:when>
							<c:otherwise>有☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40247=='1'}">
						<span>单纯囊肿：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40248=='1'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>复杂囊肿：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40248=='2'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
					</c:if>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(2).左乳实性肿块
					</p>
					<span class="pf60">实性肿块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40249=='0'}">无☑</c:when>
							<c:otherwise>有☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40249=='1'}">
						<span>单发：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40250=='1'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>多发：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40250=='2'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
					</c:if>
				</div>
				<div>
					<c:if test="${vl402.l40249=='1'}">
						<p class="margin2">
							<span class="pf60 ">肿块部位：</span>
							<span class="spanAll w200">${vl402.l40251}</span>
							<span>象限法：</span>
							<span class="spanAll w200">${vl402.l40252}</span>
						</p>
						<p class="margin2">
							<span class="pf60 w79 display-block">时钟法：</span>
							<span class="spanAll w200">${vl402.l40253}</span>
							<c:set var="l40254Arr" value="${fn:split(vl402.l40254, ',')}" />
							<span>大小：</span>
							<span class="spanAll w40">${l40254Arr[0]}</span>
							<span>mm</span>
							<span>X</span>
							<span class="spanAll w40">${l40254Arr[1]}</span>
							<span>mm</span>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">形态：</span>
							<span class="display-block w72">椭圆形</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40255=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">圆形</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40255=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不规则</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40255=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">分叶状</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40255=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">方向：</span>
							<span class="display-block w72">纵横比≥1</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40256=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">纵横比＜1</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40256=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">边界：</span>
							<span class="display-block w72">锐利</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40257=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">回声晕环</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40257=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">边缘：</span>
							<span class="display-block w72">清晰</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40258=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不清晰</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40258=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">内部回声：</span>
							<span class="display-block w72">低</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40259=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">等</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40259=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">高</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40259=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">均匀</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40259=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不均匀</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40259=='5'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">后方回声：</span>
							<span class="display-block w72">无变化</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40260=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">衰减</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40260=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">增强</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40260=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">侧方声影</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40260=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">钙化灶：</span>
							<span class="display-block w72">无：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40261=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">粗大：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40261=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">细小：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40261=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">血流：</span>
							<span class="display-block w72">无</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40262=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">少许</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40262=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">丰富</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40262=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
					</c:if>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(3).左乳其他
					</p>
					<span class="pf60">其他：</span>
					<span class="spanAll w400">${vl402.l40263}</span>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(4).左乳分级
					</p>
					<span class="pf60">分级：</span>
					<span>0级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>1级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>2级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>3级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>4级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>5级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40264=='6'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						2.右乳超声评估 BI-RADS 分级
					</p>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(1).右乳囊肿
					</p>
				<span class="pf60">囊肿：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40265=='0'}">无☑</c:when>
							<c:otherwise>有☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40265=='1'}">
						<span>单纯囊肿：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40266=='1'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>复杂囊肿：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40266=='2'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
					</c:if>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(2).右乳实性肿块
					</p>
					<span class="pf60">实性肿块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40267=='0'}">无☑</c:when>
							<c:otherwise>有☑</c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l40267=='1'}">
						<span>单发：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40268=='1'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
						<span>多发：</span>
						<label>
							<c:choose>
								<c:when test="${vl402.l40268=='2'}">☑</c:when>
								<c:otherwise>☐</c:otherwise>
							</c:choose>
						</label>
					</c:if>
				</div>
				<div>
						<c:if test="${vl402.l40267=='1'}">
						<p class="margin2">
							<span class="pf60 ">肿块部位：</span>
							<span class="spanAll w200">${vl402.l40269}</span>
							<span>象限法：</span>
							<span class="spanAll w200">${vl402.l40270}</span>
						</p>
						<p class="margin2">
							<span class="pf60 w79 display-block">时钟法：</span>
							<span class="spanAll w200">${vl402.l40271}</span>
							<c:set var="l40272Arr" value="${fn:split(vl402.l40272, ',')}" />
							<span>大小：</span>
							<span class="spanAll w40">${l40272Arr[0]}</span>
							<span>mm</span>
							<span>X</span>
							<span class="spanAll w40">${l40272Arr[1]}</span>
							<span>mm</span>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">形态：</span>
							<span class="display-block w72">椭圆形</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40273=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">圆形</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40273=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不规则</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40273=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">分叶状</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40273=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">方向：</span>
							<span class="display-block w72">纵横比≥1</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40274=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">纵横比＜1</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40274=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">边界：</span>
							<span class="display-block w72">锐利</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40275=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">回声晕环</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40275=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">边缘：</span>
							<span class="display-block w72">清晰</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40276=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不清晰</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40276=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">内部回声：</span>
							<span class="display-block w72">低</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40277=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">等</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40277=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">高</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40277=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">均匀</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40277=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">不均匀</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40277=='5'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">后方回声：</span>
							<span class="display-block w72">无变化</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40278=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">衰减</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40278=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">增强</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40278=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">侧方声影</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40278=='4'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">钙化灶：</span>
							<span class="display-block w72">无：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40279=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">粗大：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40279=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">细小：</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40279=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
						<p class="margin2">
							<span class="pf60 display-block w80">血流：</span>
							<span class="display-block w72">无</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40280=='1'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">少许</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40280=='2'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
							<span class="display-block w72">丰富</span>
							<label>
								<c:choose>
									<c:when test="${vl402.l40280=='3'}">☑</c:when>
									<c:otherwise>☐</c:otherwise>
								</c:choose>
							</label>
						</p>
					</c:if>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(3).右乳其他
					</p>
					<span class="pf60">其他：</span>
					<span class="spanAll w400">${vl402.l40281}</span>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(4).右乳分级
					</p>
					<span class="pf60">分级：</span>
					<span>0级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>1级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>2级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>3级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>4级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>5级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40282=='6'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						3.建 议
					</p>
					<span class="pf60">(1)定期检查：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40283=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(2)乳腺X线检查：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40283=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>(3)活检：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40283=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.检查机构
					</p>
					<span class="pf60">检查机构:</span>
					<span class="spanAll w200">${vl402.l40284Zh}</span>
					<span>检查人员:</span>
					<span class="spanAll w200">${vl402.l40285}</span>
					<span>检查日期:</span>
					<span class="spanAll w200">${vl402.l40286Str}</span>
				</div>
				<p class="line"></p>
				  <%++i; %>
   			 </c:if>
   			  <c:if test="${vl402.l402102!=null}">
				<div>
					<p align="left" class="fz20 margin7">
						(<%=numArr[i]%>)乳腺X线检查
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb margin7">
						1.左乳乳腺X线评估BI-RADS分级（0级、3级及以上）
					</p>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(1).左乳分级
					</p>
					<span class="pf60">分级：</span>
					<span>0级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>1级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>2级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>3级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>4级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>5级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40287=='6'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(2).左乳肿块
					</p>
					<span class="pf60">左乳肿块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40288=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
				</div>
					<c:if test="${vl402.l40288=='1'}">
					<p class="margin2">
					<span  class="pf60">可疑钙化：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40290=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
				<c:if test="${vl402.l40288=='1'}">
					<p class="margin2">
						<span class="pf60">结构紊乱：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40291=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
				<c:if test="${vl402.l40288=='1'}">
					<p class="margin2">
					<c:set var="l40289Arr" value="${fn:split(vl402.l40289, ',')}" />
					<span class="pf60">肿块大小：</span>
					<span class="spanAll w40">${l40289Arr[0]}</span>
					<span>mm</span>
					<span>X</span>
					<span class="spanAll w40">${l40289Arr[1]}</span>
					<span>mm</span>
					</p>
				</c:if>
				<c:if test="${vl402.l40288=='1'}">
					<p class="margin2">
						<span class="pf60">肿块部位：</span>
						<span>外上：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>外下：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>内上：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>内下象限：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='4'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>中央区：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='5'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>乳晕后：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40292=='6'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(3).左乳其他
					</p>
					<span class="pf60">其他：</span>
					<span class="spanAll w400">${vl402.l40293}</span>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb margin7">
						2.右乳乳腺X线评估BI-RADS分级（0级、3级及以上）
					</p>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(1).右乳分级
					</p>
					<span class="pf60">分级：</span>
					<span>0级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='1'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>1级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='2'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>2级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='3'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>3级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='4'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>4级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='5'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
					<span>5级：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40294=='6'}">☑</c:when>
							<c:otherwise>☐</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(2).右乳肿块
					</p>
				<span class="pf60">右乳肿块：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40295=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if test="${vl402.l40295=='1'}">
					<p class="margin2">
					<span  class="pf60">可疑钙化：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40297=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
				<c:if test="${vl402.l40295=='1'}">
					<p class="margin2">
						<span class="pf60">结构紊乱：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40298=='1'}">有☑</c:when>
							<c:otherwise>无☑</c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
					<c:if test="${vl402.l40295=='1'}">
					<p class="margin2">
					<c:set var="l40296Arr" value="${fn:split(vl402.l40296, ',')}" />
					<span class="pf60">肿块大小：</span>
					<span class="spanAll w40">${l40296Arr[0]}</span>
					<span>mm</span>
					<span>X</span>
					<span class="spanAll w40">${l40296Arr[1]}</span>
					<span>mm</span>
					</p>
				</c:if>
			<c:if test="${vl402.l40295=='1'}">
					<p class="margin2">
						<span class="pf60">肿块部位：</span>
						<span>外上：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>外下：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>内上：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>内下象限：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='4'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>中央区：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='5'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>乳晕后：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l40299=='6'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					</p>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						(3).右乳其他
					</p>
					<span class="pf60">其他：</span>
					<span class="spanAll w400">${vl402.l402100}</span>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						3.建议
					</p>
					<span class="pf60">(1)定期检查：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402101=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(2)短期随访（6个月后复查乳腺X线）：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402101=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(3)活检：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402101=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(4)其他：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402101=='4'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.检查机构
					</p>
					<span class="pf60">检查机构:</span>
					<span class="spanAll w200">${vl402.l402102Zh}</span>
					<span>检查人员:</span>
					<span class="spanAll w200">${vl402.l402103}</span>
					<span>检查日期:</span>
					<span class="spanAll w200">${vl402.l402104Str}</span>
				</div>
				<p class="line"></p>
				 <%++i; %>
   			 </c:if>
   		  <c:if test="${vl402.l402120!=null}">
				<div>
					<p align="left" class="fz20 margin7">
						(<%=numArr[i]%>)最终随访结果
					</p>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						1.随访情况
					</p>
					<span class="pf60">(1)已随访：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402105=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(2)失访：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402105=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						2.病理检查
					</p>
					<span class="pf60">(1)已做：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402106=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(2)未做：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402106=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(3)不详：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402106=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if test="${vl402.l402106=='1'}">
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						2.1.病理检查机构
					</p>
					<span class="pf60">病理检查机构:</span>
					<span class="spanAll w200">${vl402.l402107Zh}</span>
					<span>病理诊断者:</span>
					<span class="spanAll w200">${vl402.l402108}</span>
					<span>病理检查日期:</span>
					<span class="spanAll w200">${vl402.l402109Str}</span>
				</div>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						3.最后诊断
					</p>
					<span class="pf60">(1).未见异常：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402110=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(2).良性疾病：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402110=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(3).癌前病变：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402110=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(4).导管原位癌：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402110=='4'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>(5).浸润癌：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402110=='5'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if test="${vl402.l402110=='2'||vl402.l402110=='3'||vl402.l402110=='5'}">
				<div>
				<c:if test="${vl402.l402110=='2'}">
					<p class="margin2">
						<span class="pf60">良性疾病：</span>
						<span>(1).乳腺纤维腺瘤：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402111=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(2).乳腺导管内乳头状瘤：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402111=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(3).其他乳腺疾病:</span>
						<span class="spanAll w200">${vl402.l402126}</span>
					</p>
					</c:if>
					<c:if test="${vl402.l402110=='3'}">
					<p class="margin2">
						<span class="pf60">癌前病变：</span>
						<span>(1).导管不典型增生：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402112=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(2).小叶不典型增生：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402112=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(3).小叶原位癌：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402112=='3'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					</p>
					</c:if>
					<c:if test="${vl402.l402110=='5'}">
					<p class="margin2">
						<span class="pf60">浸润癌：</span>
						<span>(1).浸润性导管癌：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402113=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(2).浸润性小叶癌：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402113=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
						<span>(3).其他类型疾病:</span>
						<span class="spanAll w200">${vl402.l402127}</span>
					</p>
					</c:if>
				</div>
				</c:if>
				<c:if test="${vl402.l402114=='1'||vl402.l402114=='2'}">
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.TNM分期
					</p>
					<span class="pf60">(1).临床分期（cTNM）：</span>
					<label>是☑</label>
					<span>a.获得：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402114=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>b.未获得：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402114=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>①分期：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402115=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>②未分期：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402115=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l402115=='1'}">
					<c:set var="l402116Arr" value="${fn:split(vl402.l402116, ',')}" />
					<span>分期c：</span>
					<span>T</span>
					<span class="spanAll w40">${l402116Arr[0]}</span>
					<span>N</span>
					<span class="spanAll w40">${l402116Arr[1]}</span>
					<span>M</span>
					<span class="spanAll w40">${l402116Arr[2]}</span>
					<span>临床分期：</span>
					<span class="spanAll w40">${l402116Arr[3]}</span>
					<span>期</span>
					</c:if>
				</div>
				</c:if>
				<c:if test="${vl402.l402117=='1'||vl402.l402117=='2'}">
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						4.TNM分期
					</p>
					<span class="pf60">(1).病理分期（pTNM）：</span>
					<label>是☑</label>
					<span>a.获得：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402117=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>b.未获得：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402117=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>①分期：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402118=='1'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<span>②未分期：</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402118=='2'}">☑</c:when>
							<c:otherwise>☐ </c:otherwise>
						</c:choose>
					</label>
					<c:if test="${vl402.l402118=='1'}">
					<c:set var="l402119Arr" value="${fn:split(vl402.l402119, ',')}" />
					<span>分期p：</span>
					<span>T</span>
					<span class="spanAll w40">${l402116Arr[0]}</span>
					<span>N</span>
					<span class="spanAll w40">${l402116Arr[1]}</span>
					<span>M</span>
					<span class="spanAll w40">${l402116Arr[2]}</span>
					<span>临床分期：</span>
					<span class="spanAll w40">${l402116Arr[3]}</span>
					<span>期</span>
					</c:if>
				</div>
				</c:if>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">5.接受治疗情况</p>
					<span class="pf60">接受治疗情况:</span>
					<label>
						<c:choose>
							<c:when test="${vl402.l402122=='1'}">是☑</c:when>
							<c:when test="${vl402.l402122=='2'}">否☑</c:when>
							<c:otherwise>不详☑ </c:otherwise>
						</c:choose>
					</label>
				</div>
				<div>
					<p align="left" class="fz18 pf60 fwb w275 margin7">
						6.诊治机构
					</p>
					<span class="pf60">诊治机构:</span>
					<span class="spanAll w200">${vl402.l402120Zh}</span>
					<span>诊治日期:</span>
					<span class="spanAll w200">${vl402.l402121Str}</span>
				</div>
				</c:if>
				<div class="Noprint" align="center" style="padding-top: 10px">
					<OBJECT id="wb" height="0" width="0"
						classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
					<input type="button" value="执行打印" onclick='wb.execwb(6,6)' />
					<input type="button" value="打印设置" onclick="wb.execwb(8,1)" />
					<input type="button" value="打印预览" onclick='wb.execwb(7,1)' />
				</div>
			</div>
		</body>
	</html>