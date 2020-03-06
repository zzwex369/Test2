<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》补发登记本</title>
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
  <table id="excel" borderColor="#000000" cellSpacing="0" align="center"  border="0">
  	<tr>
  		<td align="left" colspan="7">
  			<h3 align="center" style="margin-bottom:0px;">《出生医学证明》补发登记本</h3>
  		</td>
  	</tr>
  	<tr>
  		<td align="left">
  			  单位名称：<u>${institutionLabel }</u>
  		</td>
  		<td align="right" colspan="6">
  			  起始时间：<u>${date_start }</u>&nbsp;&nbsp;&nbsp;&nbsp;终止时间：<u>${date_end }</u>
  		</td>
  	</tr>
  	<tr>
  		<td colspan="7">
  			<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
			  <thead>
			  	<tr>
			        <td nowrap="nowrap">序号</td>
			        <td nowrap="nowrap">县市区</td>
			        <td nowrap="nowrap">领证日期</td>
			        <td nowrap="nowrap">母亲姓名</td>
			        <td nowrap="nowrap">新生儿姓名</td>
			        <td nowrap="nowrap">性别</td>
			        <td nowrap="nowrap">出生日期</td>
			        <td nowrap="nowrap">原证编号</td>
			        <td nowrap="nowrap">新证编号</td>
			        <td nowrap="nowrap">补发原因</td>
			        <td nowrap="nowrap">声明作废的<br>报刊名称</td>
			        <td nowrap="nowrap">报刊刊登日期</td>
			        <td nowrap="nowrap">母亲户籍<br>地证明是<br>否入户</td>
			        <td nowrap="nowrap">父亲户籍<br>地证明是<br>否入库</td>
			        <td nowrap="nowrap">领证人有效身份证件号码</td>
			        <td nowrap="nowrap">领证人签名</td>
			        <td nowrap="nowrap">签发人签名</td>
			        <td nowrap="nowrap">盖章人签名</td>
			        <td nowrap="nowrap">审核人签名</td>
			    </tr>
			  </thead>
			<c:forEach items="${requestScope.vd305s }" var="vd305" varStatus="i">
			  <tr>
			    <td nowrap="nowrap">${i.count }</td>
			    <td nowrap="nowrap">${vd305.d30505_Zhx }</td>
			    <td nowrap="nowrap">${vd305.d30537 }</td>
			    <td nowrap="nowrap">${vd305.d30516 }</td>
			    <td nowrap="nowrap">${vd305.d30502 }</td>
			    <td nowrap="nowrap">${vd305.d30503_Zh }</td>
			    <td nowrap="nowrap">${vd305.d30504 }</td>
			    <td nowrap="nowrap">${vd305.d30533 }</td>
			    <td nowrap="nowrap">${vd305.d30534 }</td>
			    <td nowrap="nowrap">${vd305.d30532_Zh }</td>
			    <td nowrap="nowrap">${vd305.d30540 }</td>
			    <td nowrap="nowrap">${vd305.d30541 }</td>
			    <td nowrap="nowrap">${vd305.d30538_Zh }</td>
			    <td nowrap="nowrap">${vd305.d30538_Zh }</td>
			    <td class="txt" nowrap="nowrap">${vd305.d30531 }</td>
			    <td nowrap="nowrap">${vd305.d30528 }</td>
			    <td></td>
			    <td></td>
			    <td></td>
			  </tr>
			</c:forEach>
			</table>
  		</td>
  	</tr>
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