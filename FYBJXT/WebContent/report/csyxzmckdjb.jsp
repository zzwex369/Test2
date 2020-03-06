<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》出库登记本</title>
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
</style>
</head>
<body>
<center>
	<table id="excel" align="center">
		<tr><td align="center"><h3>《出生医学证明》出库登记本</h3></td></tr>
		<tr>
			<td>
			<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
			  <thead>
			  	<tr>
			        <td>序号</td>
			        <td>出库单位</td>
			        <td>出库日期</td>
			        <td>出库数量</td>
			        <td>起始编码</td>
			        <td>终止编码</td>
			        <td>库存数</td>
			        <td>申领单位名称</td>
			        <td>领证人签名</td>
			        <td>经办人签名</td>
			    </tr>
			  </thead>
			  <c:forEach var="vd503" items="${requestScope.vd503s}" varStatus="i">
				  <tr>
				    <td>${i.count }</td>
				    <td>${vd503.d50302Zh }</td>
				    <td><fmt:formatDate value="${vd503.d50305}" type="date" pattern="yyyy-MM-dd"/></td>
				    <td>${vd503.d50304}</td>
				    <td>${vd503.d50309}</td>
				    <td>${vd503.d50310}</td>
				    <td>${vd503.d50306}</td>
				    <td>${vd503.d50307Zh }</td>
				    <td>${vd503.d50303}</td>
				    <td>${vd503.d50308}</td>
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