<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>孕产妇产后管理信息提供</title>
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
  <h3 align="center">孕产妇产后管理信息提供</h3>
	<table  borderColor="#000000" cellSpacing="0" align="center"  border="1">
  		<thead>
  			<tr>
        		<td nowrap="nowrap">序号</td>
        		<td>母亲姓名</td>
        		<td>身份证号</td>
        		<td>生产日期</td>
        		<td>家庭地址</td>
        		<td>婴儿姓名</td>
        		<td>出生证号</td>
        		<td>生产医院</td>
        		<td>联系方式</td>
    		</tr>
    	</thead>
    	<c:forEach items="${requestScope.vd301s }" var="vd301" varStatus="i">
	    	<tr>
	    		<td>${i.count }</td>
	    		<td>${vd301.d30111 }</td>
	    		<td class="txt">${vd301.d30112 }</td>
	    		<td>${vd301.d30104 }</td>
	    		<td>${vd301.d30121 }</td>
	    		<td>${vd301.d30102 }</td>
	    		<td>${vd301.d30110 }</td>
	    		<td>${vd301.d30124Zh }</td>
	    		<td>${vd301.d30143 }</td>
	    	</tr>
	    </c:forEach>
 	</table>
</center>
</body>
</html>