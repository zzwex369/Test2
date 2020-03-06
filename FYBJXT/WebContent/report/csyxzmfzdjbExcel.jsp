<%@ page language="java" contentType="application/msexcel; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《出生医学证明》废证登记本</title>
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
	td
	{
		text-align:center; 
	}
	@media print {
   		.Noprint {display:none;}
	}
</style>
<script type="text/javascript">
function refreshPage()
{
	window.location.reload();
}
</script>
</head>
<body>
	<div>
		<h3 align="center">《出生医学证明》废证登记本</h3>
			<table id="excel" border="2" borderColor="#000000"  align="center"
				style="font-size: 14px; border: gray2px; border-collapse: collapse"
				cellspacing="0" cellpadding="1">
				<thead>
				<tr>
					<td rowspan="2" nowrap="nowrap">序号</td>
					<td rowspan="2">县市区</td>
					<td rowspan="2" nowrap="nowrap">日期</td>
					<td rowspan="2" nowrap="nowrap">出生证编号</td>
					<td colspan="3">废证原因</td>
					<td rowspan="2" nowrap="nowrap">审核人签名</td>
					<td rowspan="2" nowrap="nowrap">经办人签名</td>
				</tr>
				<tr>
					<td nowrap="nowrap">打印或填写错误 </td>
					<td>遗失</td>
					<td nowrap="nowrap">其他</td>
				</tr>
				</thead>
				<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td nowrap="nowrap">${vd401.d40113Zh }</td>
						<td><fmt:formatDate value="${vd401.d40108}" type="date" pattern="yyyy-MM-dd"/></td>
						<td>${vd401.d40105 }</td>
						<c:choose>
							<c:when test="${vd401.d40106 == 1 || vd401.d40106 == 2 }">
								<td>√</td>
							</c:when>
							<c:otherwise>
								<td>&nbsp;</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${vd401.d40106 == 3}">
								<td>√</td>
							</c:when>
							<c:otherwise>
								<td>&nbsp;</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${vd401.d40106 == 5 }">
								<td>√</td>
							</c:when>
							<c:otherwise>
								<td>&nbsp;</td>
							</c:otherwise>
						</c:choose>
						<td>${vd401.d40111 }</td>
						<td>${vd401.d40109 }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>