<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医疗机构外出生的《出生医学证明》首次签发登记本</title>
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
  <h3 align="center">医疗机构外出生的《出生医学证明》首次签发登记本</h3>
  <table  borderColor="#000000" cellSpacing="0" align="center"  border="1">
  <thead>
  	<tr>
        <td>序号</td>
        <td>签发机构</td>
        <td>领证日期</td>
        <td>母亲姓名</td>
        <td>新生儿姓名</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>出生证编号</td>
        <td>领证人有效身份证件号码</td>
        <td>领证人签名</td>
        <td>签发人签名</td>
        <td>盖章人签名</td>
    </tr>
  </thead>
  <c:forEach items="${requestScope.vd301s }" var="vd301" varStatus="i">
  <tr>
    <td>${i.count }</td>
    <td>${vd301.d30126Zh }</td>
    <td>${vd301.d30128 }</td>
    <td>${vd301.d30111 }</td>
    <td>${vd301.d30102 }</td>
    <td>${vd301.d30103Zh }</td>
    <td>${vd301.d30104 }</td>
    <td>${vd301.d30110 }</td>
    <td class="txt">${vd301.d30139 }</td>
    <td>${vd301.d30136 }</td>
    <td>${vd301.d30127 }</td>
    <td></td>
  </tr>
</c:forEach>
</table>
</center>
</body>
</html>