<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
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
	td{ 
		background-color: #FFFFFF; 
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
  <h3 align="center">《出生医学证明》入库登记本</h3>
  <!--table borderColor="#FFFFFF" cellSpacing="0" align="center"  border="0" height="40">
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
  	<div align="left">单位名称：${requestScope.vd502s[0].d50202Zh}</div>
    <table  borderColor="#000000" cellSpacing="0" align="center"  border="1">
  <thead>
  	<tr>
        <td>序号</td>
        <td>入库日期</td>
        <td>入库数量</td>
        <td>起始编码</td>
        <td>终止编码</td>
        <td>库存数量</td>
        <td>经办人签名</td>
        <td>审核人签名</td>
    </tr>
  </thead>
<c:forEach var="vd502" items="${requestScope.vd502s}" varStatus="i">
  <tr>
    <td>${i.count}</td>
    <td><fmt:formatDate value="${vd502.d50205}" type="date" pattern="yyyy-MM-dd"/></td>
    <td>${vd502.d50204}</td>
    <td class="txt">${vd502.d50209}</td>
    <td class="txt">${vd502.d50210}</td>
    <td>${vd502.d50206}</td>
    <td>${vd502.d50203}</td>
    <td>${vd502.d50208}</td>
  </tr>
</c:forEach>
</table>
</center><br/><br/>
</body>
</html>    