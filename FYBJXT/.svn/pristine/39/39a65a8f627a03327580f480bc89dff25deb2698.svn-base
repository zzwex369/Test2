<%@ page language="java" contentType="application/msexcel; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生医学证明遗失及其它废证处理情况登记表</title>
</head>
<body>
	<div>
		<h3 align="center">《出生医学证明》遗失及其它废证处理情况登记表</h3>
			<table id="excel" border="2" borderColor="#000000"  align="center"
				style="font-size: 14px; border: gray2px; border-collapse: collapse"
				cellspacing="0" cellpadding="1">
				<thead>
					<tr>
						<td rowspan="2">序号</td>
						<td rowspan="2" align="center">单位名称</td>
						<td rowspan="2">遗失（其它废证）出生证编号</td>
						<td rowspan="2">遗失（其它）时间</td>
						<td rowspan="2">遗失（其它）原因</td>
						<td rowspan="2">经办人签名</td>
						<td rowspan="2" align="center">审核人签名</td>
						<td colspan="2">遗失（其它废证）作废声明</td>
						<td colspan="2">处理情况</td>
					</tr>
					<tr>
						<td align="center">时间</td>
						<td align="center">报刊名称</td>
						<td align="center">对单位</td>
						<td align="center">对人员</td>
					</tr>
				</thead>
				<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td align="center">${vd401.d40110Zh }</td>
						<td align="center">${vd401.d40105 }</td>
						<td align="center">${vd401.d40108 }</td>
						<td align="center">${vd401.d40115 }</td>
						<td align="center">${vd401.d40109 }</td>
						<td align="center">${vd401.d40111 }</td>
						<td align="center">${vd401.d40116 }</td>
						<td align="center">${vd401.d40117 }</td>
						<td align="center">${vd401.d40118 }</td>
						<td align="center">${vd401.d40119 }</td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>