<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》入库登记本</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
		border-collapse:collapse;
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
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
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
</head>
<body>
<center>
  <!-- table borderColor="#FFFFFF" cellSpacing="0" align="center"  border="0" height="40">
        <tr align="left">
            <td>单位名称 : ${requestScope.vd502s[0].d50202Zh}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
  </table -->
    <table id="excel" borderColor="#000000" cellSpacing="0" align="center"  border="0">
	<tr>
		<td align="left" colspan="7">
			<h3 align="center" style="margin-bottom:0px;">《出生医学证明》入库登记本</h3>
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
				<tr style="background-color:#CCC;">
			        <td>序号</td>
			        <td>入库日期</td>
			        <td>入库数量</td>
			        <td>起始编码</td>
			        <td>终止编码</td>
			        <td>库存数量</td>
			        <td>经办人签名</td>
			        <td>审核人签名</td>
			    </tr>
				<c:forEach var="vd502" items="${requestScope.vd502s}" varStatus="i">
				  <tr>
				    <td>${i.count}</td>
				    <td nowrap="nowrap"><fmt:formatDate value="${vd502.d50205}" type="date" pattern="yyyy-MM-dd"/></td>
				    <td nowrap="nowrap">${vd502.d50204}</td>
				    <td nowrap="nowrap" class="txt">${vd502.d50209}</td>
				    <td nowrap="nowrap" class="txt">${vd502.d50210}</td>
				    <td nowrap="nowrap">${vd502.d50206}</td>
				    <td nowrap="nowrap">${vd502.d50203}</td>
				    <td nowrap="nowrap">${vd502.d50208}</td>
				  </tr>
				</c:forEach>
			</table>
		</td>
	</tr>
</table>
</center><br/><br/>
<div align="center">
	<form action="/csyxzm/CertificateRegistServlet" method="post">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
		<input type="hidden" value="${requestScope.date_start }" name="date_start"/>
		<input type="hidden" value="${requestScope.date_end }" name="date_end"/>
		<input type="hidden" value="${requestScope.institution }" name="institution"/>
		<input type="hidden" value="${requestScope.institutionType }" name="institutionType"/>
		<!-- <input type="hidden" name="flag" value="excel"/>
		<input type="submit" value="导出excel"/> -->
		<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" /> 
	</form>
</div>
<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
</body>
</html>    