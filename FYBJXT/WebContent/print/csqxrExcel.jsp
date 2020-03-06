<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.xyw.medical.birth.csqxr.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生缺陷儿登记卡</title>
<style type="text/css"> 
div.div1 {
	text-align:center;
	border:solid 1px #000;
	width:15px;
	height:15px;
 }
 div.div2{
         float:left;
         height:20px;
         top:2px ;
         position:relative;
 }
 div.div3{
       float:left;
       border:1px solid #000;
       width:15px;
       margin-left:10px;
       height:15px;"
 }
 div.div4{
         height:20px;
         top:2px ;
         position:relative;
 
 }
 div.div5{
         height:20px;
       
         position:relative;
         
 }
 	table tr{
		height:25px;
	}
</style>
</head>
<body>
	<div align="center">
		<div id="content">
			<div align="center"><h2>医疗机构出生缺陷儿登记卡</h2></div>
			
			<table width="830" height="10%">
			  <tr><td> <div class="div5"  style="margin-left:460px;">&nbsp;表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：卫统47表</div></td></tr>
			  <tr><td><div class="div5" style="margin-left:448px;">制定机关：卫生部</div></td></tr>
			  <tr><td> <div class="div5" style="margin-left:479px;">批准机关：国家统计局</div></td></tr>
			  <tr><td><div class="div5" style="margin-left:520px;">批准文号：国统制[2012]184号</div></td></tr>
			  <tr><td><div class="div5" style="margin-left:480px;">有效期至：2014年12月</div></td></tr>
			</table>
			
			<table><tr>
			    <td></td>
<%-- 			    <td>${requestScope.sheng}省（市、自治区）${requestScope.shi}区县${requestScope.quXian}</td> --%>
			    <td>${requestScope.vd606.d60651Zh}医院（保健院、所）</td>
			    <td>${requestScope.vd606.d60651}医院编码</td></tr></table>
			
			<table width="830" cellpadding="0" cellspacing="0" height="80%"  frame="box" rules="all">
			  <tr><td width="20" colspan="1">产 <br /> 妇<br /> 情<br /> 况</td>
			      <td height="25px" width="810" colspan="6"  style="padding:5px;">
			       <table width="810" >
							<tr><td align="left"colspan="1">住院号：${requestScope.vd606.d60610}</td>
								<td align="left">产妇姓名：${requestScope.vd606.d60604}</td>
								<td align="left">产妇民族：${requestScope.vd606.d60609Zh}</td>
								<td align="left">出生日期：${requestScope.vd606.d60606Str}</td>
								<td align="left" colspan="2">实足年龄：${requestScope.vd606.d60610}岁</td></tr>
							<tr><td align="left" colspan="3">通讯地址及邮编：${requestScope.vd606.d60610}</td>
								<td align="left" colspan="1">孕次：${requestScope.vd606.d60611}</td>
								<td align="left" colspan="1">产次：${requestScope.vd606.d60612}</td></tr>
							<tr><td align="left" colspan="2" >
									<div class="div2" >常住地：</div>
									<div class="div3" align="center">
									  <c:choose>
					                    <c:when test="${requestScope.vd606.d60613 == 1}">1</c:when>
					                    <c:when test="${requestScope.vd606.d60613 == 2}">2</c:when>
                                        <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                                      </c:choose></div></td>
								<td align="left" colspan="3">1.城镇&nbsp;&nbsp;&nbsp;2.乡村</td>
							</tr>
							<tr><td align="left" colspan="1">家庭年人均收入（元）</td>
								<td><div class="div3" align="center">${requestScope.vd606.d60614}</div></td>
								<td align="left" colspan="4">1.＜1000&nbsp;&nbsp;&nbsp;2.1000～&nbsp;&nbsp;&nbsp;3.2000～&nbsp;&nbsp;&nbsp;4.4000～&nbsp;&nbsp;&nbsp;5.8000～</td></tr>
							<tr><td align="left" colspan="1" >文化程度</td>
								<td><div class="div1" align="center">${requestScope.vd606.d60615}</div></td>
								<td align="left" colspan="4">1.文盲&nbsp;&nbsp;&nbsp;2.小学&nbsp;&nbsp;&nbsp;3.初中&nbsp;&nbsp;&nbsp;4.高中、中专&nbsp;&nbsp;&nbsp;5.大专及以上</td></tr>
				  </table></td></tr>
			  <tr>
			  <td width="20" colspan="1">缺<br />陷<br />儿<br />情<br />况</td>
			  <td height="25px" width="" colspan="3" >
			    <table>
					<tr><td align="left" colspan="1"><div>出生日期：${requestScope.vd606.d60618Str}</div></td></tr>
					<tr><td align="left" colspan="1">
					    <div>胎龄：${requestScope.vd606.d60619}&nbsp;&nbsp;周&nbsp;&nbsp;&nbsp;</div></td>
						<td><div>体重：${requestScope.vd606.d60620}&nbsp;&nbsp;克</div></td></tr>
					<tr><td align="left" colspan="1">
					    <div class="div2">胎数</div></td>
					    <td>1.单胎&nbsp;&nbsp;&nbsp;2.双胎&nbsp;&nbsp;&nbsp;3.多胎</td>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">
					      <c:choose>
					       <c:when test="${requestScope.vd606.d60621 == 1}">1</c:when>
					       <c:when test="${requestScope.vd606.d60621 == 2}">2</c:when>
					       <c:when test="${requestScope.vd606.d60621 == 3}">2</c:when>
					       <c:when test="${requestScope.vd606.d60621 == 4}">3</c:when>
					       <c:when test="${requestScope.vd606.d60621 == 5}">3</c:when>
                          <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td></td><td>&nbsp;&nbsp;&nbsp;若双胎或多胎，请圈</td></tr>		
					<tr><td></td><td>1.同卵&nbsp;&nbsp;&nbsp;2.异卵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td><td><div class="div3" align="center">
					   <c:choose>
					     <c:when test="${requestScope.vd606.d60621 == 2}">1</c:when>
					     <c:when test="${requestScope.vd606.d60621 == 4}">1</c:when>
					     <c:when test="${requestScope.vd606.d60621 == 3}">2</c:when>
					     <c:when test="${requestScope.vd606.d60621 == 5}">2</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td align="left" colspan="1">
					    <div class="div2">性别</div></td>
					    <td>1.男&nbsp;&nbsp;&nbsp;2.女&nbsp;&nbsp;&nbsp;3.不明</td>
					    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">${requestScope.vd606.d60617}</div></td></tr>
				</table></td>
			  <td height="25px" width="" colspan="3" >
					 <table>
						<tr><td align="left">
						       <div class="div2">性      别</div>
						       <div class="div4">&nbsp;&nbsp;&nbsp;1.男 &nbsp;&nbsp;&nbsp;2.女&nbsp;&nbsp;&nbsp; 3.不明</div></td>
						       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">${requestScope.vd606.d60617}</div></td></tr>
						<tr><td align="left">
						       <div class="div2">结       果</div>
						       <div class="div4">&nbsp;&nbsp;&nbsp;1.存活&nbsp;&nbsp;&nbsp; 2.死胎死产 &nbsp;&nbsp;&nbsp;3.七天内死亡</div></td>
						       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">${requestScope.vd606.d60622}</div></td></tr>
						<tr><td align="left">
						       <div class="div2">诊断为出生缺陷后治疗性引产</div>
						       <div class="div4">&nbsp;&nbsp;&nbsp;1.是&nbsp;&nbsp;&nbsp; 2.否</div></td>
						       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">${requestScope.vd606.d60623}</div></td></tr>
						<tr><td align="left">
						       <div class="div2">诊断依据</div>
						       <div class="div4">&nbsp;&nbsp;&nbsp;1.临床 &nbsp;&nbsp;&nbsp;2.超声 &nbsp;&nbsp;&nbsp;3.尸解&nbsp;&nbsp;&nbsp; 4.生化检查</div></td>
						       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">${requestScope.vd606.d60624}</div></td></tr>
						<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（AFP、HCG、其他 ） 5.染色体 6.其他:${requestScope.vd606.d60610}</td>
							<td><tr><td align="left">
							     <div class="div2">畸形确诊时间</div>
							     <div class="div4">&nbsp;&nbsp;&nbsp;1.产前（孕${requestScope.vd606.d60626}周）2.产后七天内</div>
							     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><div class="div3" align="center">
							        <c:choose>
					                   <c:when test="${requestScope.vd606.d60663 == 1}">1</c:when>
					                   <c:when test="${requestScope.vd606.d60663 == 2}">2</c:when>
                                       <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                                    </c:choose></div></td></tr>   
				     </table>
			  </td></tr>
			  <tr> 
			  <td width="20" colspan="1">出<br/>生<br/>缺<br/>陷<br/>诊<br/>断</td>
			  <td height="25px" width="495" colspan="3" >
			    <table>
					<tr><td>01无脑畸形（Q00）……………………...…..............</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 01}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>02脊柱裂（Q05）…………………………….............</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 02}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>03脑彭出（Q01）…………………………….............</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 03}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>04先天性脑积水（Q03）………………………….....</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 04}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>05腭裂（Q35）  左  右…………………………….......</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 05}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>06唇裂（Q36）  左  右…………………………….......</td>
					<td><div class="div1" align="center">
					    <c:choose>
					     <c:when test="${requestScope.d60610 == 06}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>07唇裂合并腭裂（Q37）  左  右……………………...</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 07}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>08小耳（包括无耳）（Q17.2,Q16.0）  左右..............</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 08}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>09外耳其他畸形（小耳,无耳除外）（Q17）左右...</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 09}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>10食道闭锁或狭窄（Q39）……………………….....</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 10}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>11直肠肛门闭锁或狭窄（包括无肛）（Q42） ……</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 11}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>12尿道下裂（Q54）……………………...…..............</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 12}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>13膀胱外翻（Q64.1）……………………...…...........</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 13}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>14马蹄内翻足（Q66.0） 左右……………………….</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 14}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>15多指 （Q69）  左  右……………………………......</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 15}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>16多趾 （Q69） 左  右……………………………......</td>
					<td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 16}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
				 </table></td>
			  <td height="25px" width="495" align="left" colspan="3"  valign="top">
			  <table>
					<tr><td>17并指（Q70）   左  右…………………………………..</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 17}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>18并趾（Q70）   左  右…………………………………..</td><td><div class="div1" align="center">
					    <c:choose>
					     <c:when test="${requestScope.d60610 == 18}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>19肢体短缩[包括缺指(趾),裂手(足)]上肢（Q71）左右</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 19}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>20肢体短缩[包括缺指(趾),裂手(足)]下肢（Q72）左右</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 20}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>21先天性膈疝（Q79.0）……………………………......</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 21}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>22脐膨出（Q79.2）…………………………………......</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 22}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>23腹裂（Q79.3）……………………………………......</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 23}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>24联体双胎（Q89.4）……………………………..........</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 24}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>25唐氏综合征（21-三体综合征） （Q90）…………..</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 25}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>26先天性心脏病（Q20-26）……………………...........</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 26}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>写明类型：${requestScope.d60610}</td></tr>
					<tr><td>27其他（写明病名并详细描述）……………...............</td><td><div class="div1" align="center">
					   <c:choose>
					     <c:when test="${requestScope.d60610 == 27}">√</c:when>
                         <c:otherwise><td nowrap="nowrap">&nbsp;</td></c:otherwise>
                       </c:choose></div></td></tr>
					<tr><td>写明：${requestScope.d60610}</td></tr>
			        </table></td>
			  </tr>
			  <tr>
			     <td width="20" rowspan="2" colspan="1">孕&nbsp;<br/>早&nbsp;<br/>期&nbsp;<br/>情&nbsp;<br/> 况</td>
			     <td height="25px" width="330" colspan="2" align="center">患 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病</td>
			     <td height="25px" width="330 " colspan="2" align="center">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;药</td>
			     <td height="25px"  width="330" colspan="2" align="center">接触其他有害因素</td>
			  </tr>
			  <tr><td height="25px" width="330" colspan="2" valign="top" >
			     <table>
			        <tr><td align="left">发烧（＞38℃）：${requestScope.vd606.d60656Zh}</td></tr>
			        <tr><td align="left">病毒感染：${requestScope.vd606.d60657Zh}（类型：${requestScope.vd606.d60658}）</td></tr>
			        <tr><td align="left">糖尿病：${requestScope.vd606.d60659Zh}</td></tr>
			        <tr><td align="left">其他：${requestScope.vd606.d60660}</td></tr>
			     </table>
			  <td height="25px" width="330" colspan="2" >
			     <table>
			        <tr><td align="left">磺胺类（名称：${requestScope.vd606.d60629}）</td></tr>
			        <tr><td align="left">抗生素（名称：${requestScope.vd606.d60630}）</td></tr>
			        <tr><td align="left">避孕药（名称：${requestScope.vd606.d60631}）</td></tr>
			        <tr><td align="left">镇静药（名称：${requestScope.vd606.d60632}）</td></tr>
			        <tr><td align="left">其他：${requestScope.vd606.d60633}</td></tr>
			     </table></td>
			  <td height="25px"  width="330" colspan="2" >
			     <table>
			        <tr><td align="left">饮酒（剂量：${requestScope.vd606.d60634}）</td></tr>
			        <tr><td align="left">农药（名称：${requestScope.vd606.d60635}）</td></tr>
			        <tr><td align="left">射线（类型：${requestScope.vd606.d60636}）</td></tr>
			        <tr><td align="left">化学制剂（名称：${requestScope.vd606.d60637}）</td></tr>
			        <tr><td align="left">其他：${requestScope.vd606.d60638}</td></tr>
			     </table>
			 </td></tr>
			  <tr><td width="20" colspan="1">家<br/>庭<br/>史</td><td height="25px" width="990" colspan="6" >
			    <table>
					<tr><td>产妇异常生育史：</td>
					    <td>1.死胎： ${requestScope.vd606.d60639}例  </td>
					    <td>2.自然流产：${requestScope.vd606.d60640}例</td></tr>
					<tr><td></td>
					    <td>3.缺陷儿：${requestScope.vd606.d60641}例</td>
					    <td>（缺陷名：${requestScope.vd606.d60642}、）</td></tr>
					<tr><td>家庭遗传史：</td>
					    <td>缺陷名:${requestScope.vd606.d60643}</td>
					    <td>与缺陷儿亲缘关系:${requestScope.vd606.d60644}</td></tr>
					<tr><td></td>
					    <td>缺陷名:${requestScope.vd606.d60645}</td>
					    <td>与缺陷儿亲缘关系:${requestScope.vd606.d60646}</td></tr>
					<tr><td></td>
					    <td>缺陷名:${requestScope.vd606.d60647}</td>
					    <td>与缺陷儿亲缘关系:${requestScope.vd606.d60648}</td></tr>
					<tr><td>近亲婚配史：</td>
					    <td>1.不是&nbsp;&nbsp;&nbsp;&nbsp;2.是（关系:${requestScope.vd606.d60650}）</td></tr>
				 </table></td>
			  </tr>
			</table>
			
			<table  width="830" >
			  <tr><td><div align="left"> <span>填&nbsp;&nbsp;&nbsp;&nbsp; 表&nbsp;&nbsp;&nbsp;人：　　　                　　　   　　　     职称：           　　    　　　  　　　     填表日期：　　　　　年　　　月　　　日</span></div></td></tr>
		      <tr><td><div align="left"><span>医院审表人：　　　             　　　    　　　    职称：           　　   　　　    　　　    审表日期：　　　　　年　　　月　　　日</span></div></td></tr>
		      <tr><td><div align="left"><span>省级审表人：　　　             　　　   　　　     职称：           　　   　　　   　　　     审表日期：　　　　　年　　　月　　　日</span></div></td></tr>
		    </table>
			
				<div class="Noprint" align="center">
				<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
				<input type="button" value="执行打印" onclick='wb.execwb(6,6)' />
				<input type="button" value="打印设置" onclick="wb.execwb(8,1)"/> 
				<input type="button" value="打印预览" onclick='wb.execwb(7,1)' /> 
			</div>
		</div>
	</div>
</body>
</html>