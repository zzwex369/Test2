<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》 首次签发登记本</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
		border-collapse:collapse;
	}
	thead tr
	{
		background-color:#CCC;
	}
	p
	{
		text-align:left;
	}
	@media print {
   		.Noprint {display:none;}
	}
	.txt
    {
     padding-top:1px;
     padding-right:1px;
     padding-left:1px;
     mso-ignore:padding;
     color:black;
     font-size:11.0pt;
     font-weight:400;
     font-style:normal;
     text-decoration:none;
     font-family:宋体;
     mso-generic-font-family:auto;
     mso-font-charset:134;
     mso-number-format:"@";
     text-align:general;
     vertical-align:middle;
     mso-background-source:auto;
     mso-pattern:auto;
     white-space:nowrap;
    }
</style>
</head>
<body>
<center>
	<table id="excel" align="center">
		<tr><td><h3 align="center">《出生医学证明》首次签发登记本</h3></td></tr>
		<tr><td align="left">单位名称：${requestScope.vd304s[0].d30411Zh}</td></tr>
		<tr>
			<td>
			<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
			  <thead>
			  	<tr>
			        <td nowrap="nowrap">序号</td>
			        <td nowrap="nowrap">出生证编号</td>
			        <td nowrap="nowrap">领证日期</td>
			        <td nowrap="nowrap">母亲姓名</td>
			        <td nowrap="nowrap">新生儿姓名</td>
			        <td nowrap="nowrap">性别</td>
			        <td nowrap="nowrap">出生日期</td>
			        <td nowrap="nowrap">母亲身份证号码</td>
			        <td nowrap="nowrap">结婚证号</td>
			        <td nowrap="nowrap">亲子鉴定<br>证明编号</td>
			        <td nowrap="nowrap">父亲姓名</td>
			        <td nowrap="nowrap">父亲身份证号码</td>
			        <td nowrap="nowrap">领证人签名</td>
			        <td nowrap="nowrap">领证人身份证号</td>
			        <td nowrap="nowrap">签发人签名</td>
			        <td nowrap="nowrap">盖章人签名</td>
			        <td nowrap="nowrap">审核人签名</td>
			    </tr>
			  </thead>
			<c:forEach items="${requestScope.vd304s }" var="vd304" varStatus="i">
			  <tr>
			    <td>${i.count }</td>
			    <td></td>
			    <td></td>
			    <td>${vd304.d30416 }</td>
			    <td>${vd304.d30402 }</td>
			    <td>${vd304.d30403Zh }</td>
			    <td nowrap="nowrap">${vd304.d30404 }</td>
			    <td class="txt">${vd304.d30418 }</td>
			    <td>${vd304.d30414 }</td>
			    <td>${vd304.d30415 }</td>
			    <td>${vd304.d30422 }</td>
			    <td class="txt">${vd304.d30424 }</td>
			    <td>${vd304.d30428 }</td>
			    <td class="txt">${vd304.d30431 }</td>
			    <td></td>
			    <td></td>
			    <td></td>
			  </tr>
			</c:forEach>
			</table>
			</td>
		</tr>
		<tr><td></td></tr>
		<tr><td></td></tr>
		<tr><td></td></tr>
		<tr><td></td></tr>
	</table>
  
</center><br/><br/>
<div align="center">
	<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
	<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
	<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
	<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" class="Noprint"/>
</div>
<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
		 <script language="javascript">  
            function AutomateExcel(){  
            	  var elTable = document.getElementById("excel"); //要导出的table id。  
                 	var oRangeRef = document.body.createTextRange();   
                  oRangeRef.moveToElementText(elTable);   
                  oRangeRef.execCommand("Copy");  
                  var appExcel = new ActiveXObject("Excel.Application");  
                  appExcel.Workbooks.Add().Worksheets.Item(1).Paste();   
                  appExcel.Visible = true;   
                  appExcel = null;  
            }
       </script>
</body>
</html>