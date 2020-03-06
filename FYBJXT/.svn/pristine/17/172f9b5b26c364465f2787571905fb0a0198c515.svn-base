<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
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
</style>
</head>
<body>
<center>
  <h3 align="center">《出生医学证明》首次签发登记本</h3>
  <div align="left">单位名称：${requestScope.vd304s[0].d30411Zh}</div>
  <table  borderColor="#000000" cellSpacing="0" align="center"  border="1">
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
    <td>${vd304.d30404 }</td>
    <td>${vd304.d30418 }</td>
    <td>${vd304.d30414 }</td>
    <td>${vd304.d30415 }</td>
    <td>${vd304.d30422 }</td>
    <td>${vd304.d30424 }</td>
    <td>${vd304.d30428 }</td>
    <td>${vd304.d30431 }</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</c:forEach>
</table>
</center><br/><br/>
</body>
</html>