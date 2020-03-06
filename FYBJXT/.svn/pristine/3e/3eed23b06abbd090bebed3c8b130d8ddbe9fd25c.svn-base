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
<!--强制用ie8标准模式-->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
 <!--会强制浏览器按照最新的标准去渲染-->
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宫颈癌档案登记表</title>
<style type="text/css">
	body{
            font-family:'微软雅黑', '宋体';/*统一浏览器字体*/
            padding: 0;/*清空浏览器边距*/
            margin: 0;
            /* overflow: auto;/*页面滚动条*/
        }
     div{
			/*自动居中*/
            margin: auto;
            height: auto;
            text-align:center;
            zoom:1;
        }

	@media print {
		.Noprint {
			display: none;
		}
	}
	div.Noprint {
		margin:50px;
	}
	* {
		padding:0px;
		margin:0px;
	}
	#content {
		margin-top:40px;
		width:700px;
	}
	#table1 {
		border-left:1px solid #000;
	}
	table td {
		border-right:1px solid #000;
		border-bottom:1px solid #000;
		padding-top:3px;
		padding-bottom:3px;
		height:25px;
	}
	table thead {
		background:#bbb;
	}
	.td{
	width:100;
	}
	</style>
</head>
<body>
	<div align="center">
		<div id="content">
			<div>
			<h1>妇女宫颈癌档案登记表</h1>
			</div>
			<br>
			<br>
			<div>
			<table id="table1" width="700" cellpadding="0" cellspacing="0">
			<thead>
					<tr>
						<td width="700" colspan="6" align="center" style="border-top:1px solid #000"><h3>个人信息</h3></td>
					</tr>
			</thead>
				<tr>
					<td class="td" nowrap="nowrap" align="center">姓名</td>
					<td class="td" nowrap="nowrap" align="center">${requestScope.vl301.l30102}</td>
					<td class="td" nowrap="nowrap" align="center">年龄</td>
					<td class="td" nowrap="nowrap" align="center">${requestScope.vl301.l30106}</td>								
				</tr>
				<tr>
					<td class="td" nowrap="nowrap" align="center">国籍</td>
					<td nowrap="nowrap" align="center">${requestScope.vl301.l30108zh}</td>
					<td class="td" nowrap="nowrap" align="center">出生日期</td>
					<td nowrap="nowrap" align="center">
					<span>${requestScope.vl301.l30105str}</span>					
					</td>					
				</tr>
				<tr>
					<td class="td" nowrap="nowrap" align="center">民族</td>
					<td nowrap="nowrap" align="center">${requestScope.vl301.l30107zh}</td>
					<td class="td" nowrap="nowrap" align="center">文化程度</td>
					<td nowrap="nowrap" align="center">${requestScope.vl301.l30109zh}</td>	
				</tr>
				<tr>
					<td class="td" nowrap="nowrap" align="center">有效身份证件类型</td>
					<td colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30103zh}</td>
				</tr>
				<tr>
					<td class="td" nowrap="nowrap" align="center">有效身份证件号码</td>
					<td colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30104}</td>					
				</tr>	
				<tr>
					<td class="td" nowrap="nowrap" align="center">联系方式</td>
					<td colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30110}</td>
				</tr>			
				<tr>
					<td class="td" nowrap="nowrap" align="center">户口地址</td>
					<td colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30111zh}</td>
				</tr>	
					<tr>
					<td  class="td" nowrap="nowrap" align="center">现住址</td>
					<td  colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30113zh}</td>
				</tr>				
				<tr>
					<td class="td" nowrap="nowrap" align="center">录入单位</td>
					<td colspan="5" nowrap="nowrap" align="center">${requestScope.vl301.l30117zh}</td>
				</tr>	
				<tr>
					<td class="td" nowrap="nowrap" align="center">录入人员</td>
					<td nowrap="nowrap" align="center">${requestScope.vl301.l30118}</td>
					<td class="td" nowrap="nowrap" align="center">录入日期</td>
					<td nowrap="nowrap" align="center">${requestScope.vl301.l30119str}</td>
				</tr>
			</table>
			</div>
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