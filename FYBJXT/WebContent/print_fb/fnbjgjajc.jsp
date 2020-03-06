<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.xyw.medical.fnbj.model.VL302"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>宫颈癌检查信息</title>
    <style>
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
            width: 970px;
        }
        @media print {
   			.Noprint {display:none;}
		}
        /*input {*/
        /*vertical-align: middle;*/
        /*font-weight: bold;*/
        /*width: 20px;*/
        /*height: 25px;}*/
        /*.d2{*/
        /*padding-top: 20px;*/
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
        /*p{*/
        /*display:inline-block;*/
        /*margin-top:0px;*/
        /*margin-bottom:0px;*/
        /*}*/
        .fz18{
            font-size: 18px;
        }
        .fz20{
            font-size: 20px;
        }
        .fz25{
            font-size: 25px;
        }
        .pf60{
            padding-left: 60px;
        }
        .fwb{
            font-weight: bolder;
        }
        .w40{
            width: 40px;
        }
        .w150{
            width: 150px;
        }
        .w200{
            width: 200PX;
        }
        .w252{
            width:252px;;
        }
        .w275{
            width: 275px;
        }
        .w400{
            width: 400px;
        }
        .display-block{
           display:  inline-block;
        }
        .floatR{
        	float:right;
        }
        .margin7{
            margin: 7px 0px 2px 0px;
        }
        .margin2{
            margin: 2px 0px 0px 0px;
        }
    </style>
</head>
<body>
<% 
			VL302 vl302 = (VL302) request.getAttribute("vl302");
			int i=0;
			String []numArr={"二","三","四","五","六","七","八","九"};
			String []l30208Arr=vl302.getL30208().split(",");
			String []l30245Arr=null;
			String []l30250Arr=null;
			String []l30251Arr=null;
			if(vl302.getL30245()!=null){
				l30245Arr=vl302.getL30245().split(",");
			}
			if(vl302.getL30250()!=null){
				l30250Arr=vl302.getL30250().split(",");
			}
			if(vl302.getL30251()!=null){
				l30251Arr=vl302.getL30251().split(",");
			}
%>
<div>
    <div><p align="center" class="fz25">宫颈癌检查信息</p></div>
    <p class="line"></p>
    <div><p align="left" class="fz20 margin7">(一)病史情况</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.症状</p>
        <span class="pf60">性交出血：</span>
        <label>
        	<c:choose>
				<c:when test="${vl302.l30206=='0'}">否☑</c:when>
				<c:otherwise>有☑</c:otherwise>
			</c:choose>
		</label>
        <span>白带异常：</span>
         <label>	
         	<c:choose>
				<c:when test="${vl302.l30207=='0'}">否☑</c:when>
				<c:otherwise>有☑</c:otherwise>
			</c:choose>
		</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.月经情况</p>
        <span class="pf60">月经周期：</span>
        <span>持续时间</span>
        <span class="spanAll w40"><%=l30208Arr[0]%>天</span>
        <span>/</span>
        <span>周期</span>
        <span class="spanAll w40"><%=l30208Arr[1]%>天</span>
        <span>末次月经：</span>
         <span class="spanAll w150">${vl302.l30209str}</span>
        <span>绝经：</span>
        <label>	
         	<c:choose>
				<c:when test="${vl302.l30210=='2'}">否☑</c:when>
				<c:otherwise>有☑</c:otherwise>
			</c:choose>
		</label>
		<c:if test="${vl302.l30210=='1'}">
        <span>绝经年龄:</span>
        <span class="spanAll w40">${vl302.l30211}岁</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.目前使用避孕方法</p>
        <span class="pf60">a.未避孕：</span>
        <label>
        	<c:choose>
				<c:when test="${vl302.l30212=='1'}">☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>
        <span>b.避孕套：</span>
         <label>
        	<c:choose>
				<c:when test="${vl302.l30212=='2'}">☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>
        <span>c.避孕药（年）：</span>
         <label>
        	<c:choose>
				<c:when test="${vl302.l30212=='3'}">☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>
        <span>d.宫内节育器（年）：</span> <label>
        	<c:choose>
				<c:when test="${vl302.l30212=='4'}">☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>
		<c:if test="${vl302.l30212=='9'}">
        <span>e.其他:</span>
        <span class="spanAll w200">${vl302.l30213}</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">4.孕产史</p>
        <span class="pf60">产次：</span>
        <span class="spanAll w40">${vl302.l30214}次</span>
        <span>孕次：</span>
        <span class="spanAll w40">${vl302.l30215}次</span>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">5.既往接受过宫颈癌检查</p>
        <span class="pf60">(1).既往接受过宫颈癌检查：</span>
        <label>
			<c:choose>
				<c:when test="${vl302.l30216=='1'}">是☑</c:when>
				<c:otherwise>否☑</c:otherwise>
			</c:choose>
		</label>
		<c:if test="${vl302.l30216=='1'}">
        <span>a.三年内：</span>
			<label>
			<c:choose>
				<c:when test="${vl302.l30217=='1'}">☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>	
        <span>b.三年以上：</span>
		<label>
			<c:choose>
				<c:when test="${vl302.l30217=='2'}">是☑</c:when>
				<c:otherwise>☐</c:otherwise>
			</c:choose>
		</label>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">6.既往史</p>
       <p class="margin2">
           <span class="pf60 w252 display-block">(1).宫颈细胞学结果异常：</span>
		<label>
			<c:choose>
				<c:when test="${vl302.l30218=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
		</label>
       </p>
       <p class="margin2">
      	 <c:if test="${vl302.l30218=='1'}">
      	  <span class="pf60">持续时间：</span>
           <span class="spanAll w40">${vl302.l30219}</span>
           <span>月</span>
       		 <span >异常注明：</span>
              <span class="spanAll w400">${vl302.l30220}</span>
          </c:if>
       </p>
          <p class="margin2">
             <span  class="pf60 w252 display-block">(2).HPV检查阳性：</span>
          <label>
			<c:choose>
				<c:when test="${vl302.l30221=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
		</label>
		<c:if test="${vl302.l30221=='1'}">
              <span>注明：</span>
              <span class="spanAll w400">${vl302.l30222}</span>
          </c:if>   
         </p>
         <p class="margin2">
            <span  class="pf60 w252 display-block">(3).CIN：</span>
             <label>
			<c:choose>
				<c:when test="${vl302.l30223=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
		</label>
			<c:if test="${vl302.l30223=='1'}">
             <span>注明：</span>
             <span class="spanAll w400">${vl302.l30224}</span>
            </c:if>  
        </p>
        <p class="margin2">
             <span  class="pf60 w252 display-block">(4).宫颈癌：</span>
             <c:choose>
				<c:when test="${vl302.l30225=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
			<c:if test="${vl302.l30225=='1'}">
            <span>注明：</span>
            <span class="spanAll w400">${vl302.l30226}</span>
             </c:if>  
         </p>
        <p class="margin2">
            <span  class="pf60 w252 display-block">(5).生殖道感染：</span>
			<c:choose>
				<c:when test="${vl302.l30227=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
			<c:if test="${vl302.l30227=='1'}">
            <span>注明：</span>
            <span class="spanAll w400">${vl302.l30228}</span>
             </c:if> 
         </p> 
        <p class="margin2">
           <span  class="pf60 w252 display-block">(6).其他肿瘤：</span>
           <c:choose>
				<c:when test="${vl302.l30229=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
			</c:choose>
           <c:if test="${vl302.l30229=='1'}">
           <span>注明：</span>
           <span class="spanAll w400">${vl302.l30230}</span>
           </c:if>
         </p>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">7.家族肿瘤史</p>
        <span class="pf60">家族肿瘤史:</span>
        <label>
        <c:choose>
				<c:when test="${vl302.l30231=='1'}">是☑</c:when>
				<c:otherwise>无☑</c:otherwise>
		</c:choose>
		</label>
		<c:if test="${vl302.l30231=='1'}">
        <span>疾病名称:</span>
        <span class="spanAll w200">${vl302.l30232}</span>
        <p class="margin2">
        <span class="pf60">患病家属与自己的关系:</span>
        <span class="spanAll w400">${vl302.l30233zh}</span>
       </p>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">8.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l302118zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l302119}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l302120str}</span>
    </div>
    <p class="line"></p>
    <c:if test="${vl302.l30259!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)妇科检查</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.外阴</p>
        <span class="pf60">(1).正常</span>
        	<label>
				 <c:choose>
					<c:when test="${vl302.l30234=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).白斑</span>
        <label>
				 <c:choose>
					<c:when test="${vl302.l30234=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).溃疡</span>
        <label>
				 <c:choose>
					<c:when test="${vl302.l30234=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4). 湿疣</span>
        	<label>
				 <c:choose>
					<c:when test="${vl302.l30234=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).疱疹</span>
        	<label>
				 <c:choose>
					<c:when test="${vl302.l30234=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(6). 肿物</span>
        <label>
				 <c:choose>
					<c:when test="${vl302.l30234=='6'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		 <c:if test="${vl302.l30234=='9'}">	
        <span>(7)其他:</span>
        <span class="spanAll w200">${vl302.l30235}</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.阴道</p>
        <span class="pf60">(1).正常</span>
  			<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).白斑</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).溃疡</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4). 湿疣</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).疱疹</span>
        	<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(6). 肿物</span>
        	<label>
				 <c:choose>
					<c:when test="${vl302.l30236=='6'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l30236=='9'}">	
        <span>(7)其他:</span>
        <span class="spanAll w200">${vl302.l30237}</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.分泌物</p>
        <span class="pf60">(1).正常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异味</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).血性</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4). 脓性</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).泡沫样</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(6). 豆渣样</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30238=='6'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <c:if test="${vl302.l30238=='9'}">	
        <span>(7)其他:</span>
        <span class="spanAll w200">${vl302.l30239}</span>
         </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">4.子宫颈</p>
        <span class="pf60">(1).正常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30240=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).触血</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30240=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).息肉</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30240=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).糜烂样</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30240=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).菜花样</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30240=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
          <c:if test="${vl302.l30240=='9'}">	
        <span>(6)其他:</span>
        <span class="spanAll w200">${vl302.l30241}</span>
         </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">5.分泌物检查清洁度</p>
        <span  class="pf60">(1).Ⅰ度</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30254=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).Ⅱ度</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30254=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).Ⅲ度</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30254=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).Ⅳ度</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30254=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">6.分泌物检查</p>
        <span class="pf60">(1).滴虫</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30253=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).假丝酵母菌</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30253=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).加德纳菌</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30253=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).线索细胞</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30253=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
				</label>
         <c:if test="${vl302.l30253=='9'}">	
        <span>(5)其他:</span>
        <span class="spanAll w200">${vl302.l30255}</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">7.子宫</p>
        <span class="pf60">(1).正常</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30242=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).肿物</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30242=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).脱垂</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30242=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).压痛</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30242=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
         <c:if test="${vl302.l30242=='9'}">	
        <span>(5)其他:</span>
        <span class="spanAll w200">${vl302.l30246}</span>
        </c:if>
    </div>
     <c:if test="${vl302.l30242=='1'}">	
    <div>
        <span class="pf60">子宫大小:</span>
        <span class="spanAll w200">${vl302.l30244}</span>
        <span>子宫位置:</span>
        <span class="spanAll w200">${vl302.l30243}</span>
    </div>
   </c:if>
   <c:if test="${vl302.l30242=='2'}">	
    <div>
        <span class="pf60">肿物大小:</span>
        <span class="spanAll w200"><%=l30245Arr[0] %></span>
        <span>肿物性状:</span>
        <span class="spanAll w200"><%=l30245Arr[1] %></span>
        <span>肿物位置:</span>
        <span class="spanAll w200"><%=l30245Arr[2] %></span>
    </div>
    </c:if>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">8.附件（盆腔）</p>
        <span class="pf60">(1).正常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30247=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).压痛左</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30247=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).压痛右</span>
			 <label>
				 <c:choose>
					<c:when test="${vl302.l30247=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).肿物左</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30247=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).肿物右</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30247=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(6).增厚</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30247=='6'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
         <c:if test="${vl302.l30247=='9'}">	
        <span>(7).其他:</span>
        <span class="spanAll w200" >${vl302.l30252}</span>
        </c:if>
    </div>
      <c:if test="${vl302.l30247=='2'||vl302.l30247=='3'}">
    <div>
        <span class="pf60">附件压痛:</span>
        <span class="spanAll w200">${vl302.l30248}</span>
    </div>
    </c:if>
     <c:if test="${vl302.l30247=='4'}">
    <div>
        <span class="pf60">肿物大小:</span>
        <span class="spanAll w200"><%=l30250Arr[0] %></span>
        <span>肿物性状:</span>
        <span class="spanAll w200"><%=l30250Arr[1] %></span>
        <span>肿物位置:</span>
        <span class="spanAll w200"><%=l30250Arr[2] %></span>
    </div>
    </c:if>
    <c:if test="${vl302.l30247=='5'}">
    <div>
        <span class="pf60">肿物大小:</span>
        <span class="spanAll w200"><%=l30251Arr[0] %></span>
        <span>肿物性状:</span>
        <span class="spanAll w200"><%=l30251Arr[1] %></span>
        <span>肿物位置:</span>
        <span class="spanAll w200"><%=l30251Arr[2] %></span>
    </div>
    </c:if>
     <c:if test="${vl302.l30247=='6'}">
    <div>
        <span class="pf60">附件增厚:</span>
        <span class="spanAll w200">${vl302.l30249}</span>
    </div>
    </c:if>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">9.妇科检查临床诊断</p>
        <span  class="pf60">(1).未见异常</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30256=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30256=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l30256=='2'}">
        <span>病因:</span>
        <span class="spanAll w200">
        		 <c:choose>
					<c:when test="${vl302.l30257!='9'}">${vl302.l30257zh}</c:when>
					<c:otherwise>${vl302.l30258}</c:otherwise>
				</c:choose>	
		</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">10.检查机构</p>
        <span  class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30259zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30260}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l30261str}</span>
    </div>
    <p class="line"></p>
    <%++i; %>
    </c:if>
     <c:if test="${vl302.l30268!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)HPV检查</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.HPV检查</p>
        <span  class="pf60">(1).阴性</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30262=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).阳性</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30262=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l30262=='2'}">
        <span>a.HPV亚型</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30263=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>b.未分型</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30263=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        </c:if>
        <c:if test="${vl302.l30263=='2'}">
        <span>a1.HPV亚型分类</span>
        <span class="spanAll w200">
       			 <c:choose>
					<c:when test="${vl302.l30264!='9'}">${vl302.l30264zh}</c:when>
					<c:otherwise>${vl302.l30265}</c:otherwise>
				</c:choose>	
        </span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.需进一步检查</p>
        <span class="pf60">(1).是</span>
        		<label>
				 <c:choose>
					<c:when test="${vl302.l30266=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30266=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l30266=='1'}">
        <span>a.宫颈细胞学</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30267=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>b.VIA/VILI</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30267=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>c.阴道镜</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30267=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30268zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30269}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l30270str}</span>
    </div>
    <p class="line"></p>
     <%++i; %>
    </c:if>
    <c:if test="${vl302.l30276!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)宫颈细胞学检查</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.宫颈细胞取材方式</p>
        <span class="pf60">(1).巴氏涂片</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30271=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).液基/薄层细胞学检查</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30271=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3)其他:</span>
        <span class="spanAll w200">${vl302.l30272}</span>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.巴氏分级</p>
        <span class="pf60">(1).Ⅰ级</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).ⅡA</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).ⅡB</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(4).Ⅲ级</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='4'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(5).Ⅳ级</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='5'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(6).Ⅴ级</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30273=='6'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.TBS分类报告结果</p>
        <span class="pf60">TBS分类报告结果:</span>
        <span class="spanAll w400">${vl302.l30274zh}</span>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">4.需阴道镜检查</p>
        <span class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30275=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30275=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">5.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30276zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30277}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l30278str}</span>
    </div>
    <p class="line"></p>
         <%++i; %>
    </c:if>
     <c:if test="${vl302.l30282!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)醋酸染色或复方碘染色后肉眼观察法检查（VIA/VILI）</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.醋酸染色后肉眼观察（VIA）</p>
        <span  class="pf60">(1).未见异常（无颜色变化）</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30279=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常或可疑癌（有白色反应）</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30279=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.碘染色后肉眼观察（VILI）</p>
        <span  class="pf60">(1).未见异常（染成深褐色）</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30280=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常或可疑癌（未被碘染色）</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30280=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.需阴道镜检查</p>
        <span  class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30281=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30281=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">4.检查机构</p>
        <span  class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30282zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30283}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l30284str}</span>
    </div>
    <p class="line"></p>
       <%++i; %>
    </c:if>
     <c:if test="${vl302.l30292!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)阴道镜检查</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.接受阴道镜检查</p>
        <span class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30285=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30285=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <c:if test="${vl302.l30285=='2'}">
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.未接受检查的原因</p>
        <span class="pf60">(1).拒绝检查</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30286=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).失访</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30286=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		 <c:if test="${vl302.l30286=='3'}">
        <span>其他:</span>
        <span class="spanAll w400">${vl302.l30287}</span>
        </c:if>
    </div>
    </c:if>
    <c:if test="${vl302.l30285=='1'}">
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.阴道镜检查评价</p>
        <span class="pf60">(1).满意</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30288=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).不满意</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30288=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    </c:if>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.初步诊断</p>
        <span class="pf60">(1).未见异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30289=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30289=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
	  <c:if test="${vl302.l30289=='2'}">
        <span>异常:</span>
        <span class="spanAll w200">
        		 <c:choose>
					<c:when test="${vl302.l30290!='9'}">${vl302.l30290zh}</c:when>
					<c:otherwise>${vl302.l302115}</c:otherwise>
				</c:choose>
		</span>
       </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">4.需组织病理检查</p>
        <span class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30291=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30292=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">5.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30292zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30293}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l30294str}</span>
    </div>
    <p class="line"></p>
     <%++i; %>
    </c:if>
     <c:if test="${vl302.l30298!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)组织病理检查</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.组织病理学检查结果</p>
        <span class="pf60">(1).未见异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30295=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l30295=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l30295=='2'}">
        <span>异常:</span>
        <span class="spanAll w200">
        	 <c:choose>
					<c:when test="${vl302.l30296!='9'}">${vl302.l30296zh}</c:when>
					<c:otherwise>${vl302.l30297}</c:otherwise>
			</c:choose>	
        </span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l30298zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l30299}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l302100str}</span>
    </div>
    <p class="line"></p>
      <%++i; %>
    </c:if>
     <c:if test="${vl302.l302105!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)最后诊断</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.组织病理学检查结果</p>
        <span class="pf60">(1).未见异常</span>
				<label>
				 <c:choose>
					<c:when test="${vl302.l302101=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).异常</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302101=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l302101=='2'}">
        <span>异常:</span>
        <span class="spanAll w200">
        	 <c:choose>
					<c:when test="${vl302.l302102=='13'}">${vl302.l302103}</c:when>
					<c:when test="${vl302.l302102=='14'}">${vl302.l302104}</c:when>
					<c:otherwise>${vl302.l302102zh}</c:otherwise>
				</c:choose>	
        </span>
        </c:if>
    </div>
    <div>
        <p  align="left" class="fz18 pf60 fwb w275 margin7">2.检查机构</p>
        <span class="pf60">检查机构:</span>
        <span class="spanAll w200">${vl302.l302105zh}</span>
        <span>检查人员:</span>
        <span class="spanAll w200">${vl302.l302106}</span>
        <span>检查日期:</span>
        <span class="spanAll w200">${vl302.l302107str}</span>
    </div>
    <p class="line"></p>
      <%++i; %>
    </c:if>
     <c:if test="${vl302.l302112!=null}">
    <div><p align="left" class="fz20 margin7">(<%=numArr[i]%>)随访治疗</p></div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">1.宫颈病变随访情况</p>
        <span class="pf60">(1).已随访</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302108=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).失访</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302108=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">2.宫颈病变接受治疗</p>
        <span class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302109=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302109=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).不详</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302109=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l302109=='3'}">
        <span>不详原因:</span>
        <span class="spanAll w200">${vl302.l302116}</span>
        </c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">3.其他肿瘤随访情况</p>
        <span class="pf60">(1).已随访</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302110=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).失访</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302110=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
    </div>
    <div>
        <p  align="left" class="fz18 pf60 fwb w275 margin7">4.其他肿瘤接受治疗</p>
        <span class="pf60">(1).是</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302111=='1'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(2).否</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302111=='2'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
        <span>(3).不详</span>
			<label>
				 <c:choose>
					<c:when test="${vl302.l302111=='3'}">☑</c:when>
					<c:otherwise>☐</c:otherwise>
				</c:choose>	
			</label>
		<c:if test="${vl302.l302109=='3'}">
        <span>不详原因:</span>
        <span class="spanAll w200">${vl302.l302117}</span>
    	</c:if>
    </div>
    <div>
        <p align="left" class="fz18 pf60 fwb w275 margin7">5.随访机构</p>
        <span class="pf60">随访机构:</span>
        <span class="spanAll w200">${vl302.l302112zh}</span>
        <span>随访人员:</span>
        <span class="spanAll w200">${vl302.l302113}</span>
        <span>随访日期:</span>
        <span class="spanAll w200">${vl302.l302114str}</span>
    </div>
    </c:if>
    	<div class="Noprint" align="center" style="padding-top: 10px">
				<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
				<input type="button" value="执行打印" onclick='wb.execwb(6,6)' />
				<input type="button" value="打印设置" onclick="wb.execwb(8,1)"/> 
				<input type="button" value="打印预览" onclick='wb.execwb(7,1)' /> 
			</div>
</div>
</body>
</html>