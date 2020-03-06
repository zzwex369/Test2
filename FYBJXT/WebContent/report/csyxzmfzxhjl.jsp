<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》废证销毁记录</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
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
	    text-align:center;
	    vertical-align:middle;
	    mso-background-source:auto;
	    mso-pattern:auto;
	    white-space:nowrap;
    }
</style>
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
</head>
<body>
<center>
  <table id="excel" align="center" >
  	<tr>
  		<td><h3 align="center">《出生医学证明》废证销毁记录</h3></td>
  	</tr>
  	
  	<tr>
  		<td>年度</td>
  	</tr>
  	<tr>
  		<td align="left">省辖市卫生局（盖章）：　　　　　　　　主管领导审核签字：　　　　　　　日期：</td>
  	</tr>
  	
  	<tr>
  		<td>
  			<table border="1" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
			  <thead>
			  	<tr>
			        <td nowrap="nowrap">序号</td>
			        <td nowrap="nowrap">县（市区）</td>
			        <td nowrap="nowrap">县级管理<br/>废证人员</td>
			        <td nowrap="nowrap">县级主管<br/>领导</td>
			        <td nowrap="nowrap">市级审核接<br/>收人</td>
			        <td nowrap="nowrap">废证编号</td>
			        <td nowrap="nowrap">废证数量</td>
			        <td nowrap="nowrap">销毁日期</td>
			        <td nowrap="nowrap">销毁方式</td>
			        <td nowrap="nowrap">销毁地点</td>
			    </tr>
			  </thead>
			<c:forEach items="${requestScope.vd301s }" var="vd301" varStatus="i">
			  <tr>
			    <td>${i.count }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30126Zh }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30128 }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30111 }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30102 }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30103Zh }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30104 }</td>
			    <td class="txt" nowrap="nowrap">${vd301.d30110 }</td>
			    <td class="txt">${vd301.d30139 }</td>
			    <td class="txt">${vd301.d30139 }</td>
			  </tr>
			</c:forEach>
			</table>
  		</td>
  	</tr>
  	<tr>
  		<td align="left" style="padding-top:10px;">注：1、省辖市卫生局《出生医学证明》管理人员审核确认后销毁，纪检监察人员监督销毁全过程。</td>
  	</tr>
  	<tr>
  		<td align="left">　　2、此申请表一式两份，省辖市卫生局存档一份，报省卫生厅备案一份。</td>
  	</tr>
  	<tr>
  		<td align="left" style="padding-top:20px">销毁人员签字：　　　　　日期：　　　　　　纪检监察人员签字：　　　　　日期：</td>
  	</tr>
  </table>
  
  
</center><br/><br/>
<div align="center">
	<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
	<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
	<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
	<input type="button" onClick="AutomateExcel();" value="导出EXCEL" class="Noprint"/> 
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