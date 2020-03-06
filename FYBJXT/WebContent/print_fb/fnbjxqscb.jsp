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
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>河南省免费血清学产前筛查申请单</title>
<style type="text/css">
table{
            margin: 8 auto;
            align: center;
            border-collapse: collapse;
            table-layout:fixed;
            /* cellspacing:"0";指定相邻单元格边框的间距；*/

            /* cellpadding:10;指定表格单元格与内容之间的间距；*/
            border:1px solid #000;
}
tr,td{
            border:solid 1px #000000;
            font-size: 13px;
            line-height:20px;
            vertical-align:0px;
         	 
}
.spanAll {
	text-align: center;
	border-bottom: solid 1px black;
	display: Inline-Block;
	vertical-align: bottom;
	padding-top:10px;
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
          /*ie7 ol bug*/
         .ie7 ol{
			float:left; 
			margin-left:0px;        
      	} 
        .ie7 .div1{
        	margin-top:20px;
        	margin-bottom:-23px;
        }
        /*.ie7 .div2{
        	padding-top:15px;
        }*/
        .ie7 .tbodyClass{
        	height:70px;
        }
        .ie7 .trClass1{
        	height:36px;
        }
         .ie8 .tbodyClass{
        	height:70px;
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
		<h4 style="text-align:center;">河南省免费血清学产前筛查申请单</h4>
		<div class="d2">
			<table style="table-layout:fixed;" width="100%" >
				<tr>
					<td>
						<table class="table" cellspacing="0" cellpadding="2" style="">
							<tr>
								<td valign="top" style="border-style:hidden;"><label><strong>孕中期血清学产前筛查申请单</strong>（带*必填）</label>
								<br>
									*姓名
									<span class="spanAll" style="width:40px"></span>
									身份证号码：
									<span class="spanAll" style="width:120px"></span>
								<br>
									*出生日期：<span class="spanAll" style="width:30px"></span>年
									<span class="spanAll" style="width:30px"></span>月
									<span class="spanAll" style="width:30px"></span>日（公历）
								<br>
									*种族：黄种人☐
										其他<span class="spanAll" style="width:30px"></span>
										/民族：汉☐  回☐
								<br>		
									其他（民族）<span class="spanAll" style="width:90px"></span>
								<br>
									*联系电话：<span class="spanAll" style="width:150px"></span>
								<br>
									*采血日体重：<span class="spanAll" style="width:40px"></span>公斤
									<label style="margin-left:10px">
										吸烟史：是☐
									</label>
									<label style="margin-left:10px">
											否☐
									</label>
									<br>
										*I型糖尿病：是☐
										<label style="margin-left:10px">
											否☐
										</label>
									<br>
										IVF:是☐
										否☐
										<label style="margin-left:10px">
										植入日期：
										<span class="spanAll" style="width:30px"></span>年
										<span class="spanAll" style="width:30px"></span>月
										<span class="spanAll" style="width:30px"></span>日
										</label>
									<br>
										*本次怀孕胎儿数：单胎☐
										<label style="margin-left:10px">
											双胎☐
										</label>
										<label style="margin-left:10px">
											多胞胎☐
										</label>
										（胎
									<br>
										数：<span class="spanAll" style="width:30px"></span>）
										<label>
										<b>（双胞胎或多胞胎不适宜该项目检测）</b>
										</label>
									<br>
										*末次月经：<span class="spanAll" style="width:30px"></span>年
										<span class="spanAll" style="width:30px"></span>月
										<span class="spanAll" style="width:30px"></span>日（公历）
									<br>
										*月经周期：<span class="spanAll" style="width:30px"></span>天（不规律者需用B超计算孕周）
									<br>
										*采血日孕周：<span class="spanAll" style="width:30px"></span>周+
											<span class="spanAll" style="width:30px"></span>天
									<br>
										*孕周计算方法：<span class="spanAll" style="width:130px"></span>
									<br>
										超声测定的孕周：<span class="spanAll" style="width:30px"></span>周+
											<span class="spanAll" style="width:30px"></span>天
									<br>
										超声测孕周日期：
										<span class="spanAll" style="width:30px"></span>年
										<span class="spanAll" style="width:30px"></span>月
										<span class="spanAll" style="width:30px"></span>日（公历）
									<br>
										异常妊娠史：21-三体综合症☐  开放性神经管缺陷☐
									<br>
										自然流产史☐  死胎史☐  新生儿死亡史☐
									<br>
										孕期感染史：有☐ 无☐ 
										<label style="margin-left:10px">其他：<span class="spanAll" style="width:90px"></span></label>
									<br>
										检测项目：21-三体综合症产前筛查☐  
									<br>
										<label style="margin-left:60px">开放性神经管缺陷产前筛查□</label>
									<br>
										*标本采集日期<span class="spanAll" style="width:30px"></span>年
										<span class="spanAll" style="width:30px"></span>月
										<span class="spanAll" style="width:30px"></span>日（公历）
									<br>
										*采血者：<span></span>           
										<label style="margin-left:103px">*申请医师：<span></span></label>
									<br>
										*采血单位：<span></span>           
										<label style="margin-left:90px">*组织机构代码：<span></span></label>
									<br>
										*送检单位：<span></span>           
										<label style="margin-left:90px">*送检日期：<span></span></label>
									<br>
										<span class="spanAll" style="width:100%"></span>
									<br>
										产筛结果记录单
									<br>
										************************************
									<br>
										*<label style="margin-left:16px">此处可贴条形码</label><label style="margin-left:123px">*</label>
									<br>
										*<label style="margin-left:230px">*</label>
									<br>
										*<label style="margin-left:230px">*</label>
									<br>
										************************************
									<br>
										检测标本编号：<span class="spanAll" style="width:150"></span>
									<br>
										本次检测结果：（详见筛查检测记录列表）
									<br>
										建议：
									<br>
										
									<br>
										
									<br>
										
									<br>
										检测者：<span></span>           
										<label style="margin-left:103px">审核者：<span></span></label>
									<br>
										日期：<span></span>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table valign="top" class="table" cellspacing="0" cellpadding="2">
							<tr>
								<td style="border-style:hidden;">
										<label><b>筛查申请单填写说明：</b></label>
									<br>
										请申请医师用正楷字认真填写。
									<br>
										<label style="margin-left:30px">产筛申请单信息填写不准确或错误会导致风险计</label>
									<br>
										算与实际结果产生较大偏差，为了尽量减少假阴性和假
									<br>
										阳性，现将填写申请单需要注意的事项进行说明。
									<br>
										<b>1.出生日期</b>
									<br>
										年龄与风险值计算密切相关，因此务必填写真实准确的
									<br>
										公历出生日期。
									<br>
										<b>2.体重</b>	
									<br>
										体重是计算风险值的参数之一，必需填写采血日体重公
									<br>
										斤数，体重≤37公斤或≥120公斤，风险评估软件不能
									<br>
										计算.	
									<br>
										<b>3.吸烟、I-型糖尿病</b>
									<br>
										长期吸烟或患有I-型糖尿病的孕妇，需要区别计算。
									<br>
										4.本次怀孕胎儿数
									<br>
										只能计算所怀胎儿数为单胎的，双胎及多胎不能计算风
									<br>
										险值。
									<br>
										<b>5.孕周</b>
									<br>
										如月经周期规律（28±7天），按末次月经确定孕周；
									<br>
										如月经周期不规律，按超声数据所提示孕周计算孕周
									<br>
										（孕早期超声最好）；无论月经是否规律，建议提供超
									<br>
										声提示孕周以便与末次月经推算孕周核对。
									<br>
										“B超测孕周日期”是填写做B超当天的日期，“B超测
									<br>
										定的孕龄”是填写做B超当天HC提示的孕周。
									<br>
										规范的孕周填写方式为“xx周+x天”，日期填写方式公
									<br>
										历“xxxx年xx月xx日”，孕周的准确填写与计算风险值
									<br>
										的准确性密切相关，不能短缺模糊。
									<br>
										可计算的孕周范围是孕15～20+6周，超出此范围的无法
									<br>
										计算风险值。
									<br>
										<b>6.采血日期</b>
									<br>
										有极少部分孕妇在医师填写申请单多天后才来抽血，医
									<br>
										师应事先提醒孕妇按标注的日期采血。									
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</center>
</body>
</html>