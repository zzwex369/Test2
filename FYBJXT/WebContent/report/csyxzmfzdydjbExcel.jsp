<%@ page language="java" contentType="application/msexcel; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生医学证明打印及填写错误登记表</title>
</head>
<body>
	<div>
		<h3 align="center">《出生医学证明》打印及填写错误登记表</h3>
			<table id="excel" border="2" borderColor="#000000"  align="center"
				style="font-size: 14px; border: gray2px; border-collapse: collapse"
				cellspacing="0" cellpadding="1">
				<thead>
					<tr>
						<td rowspan="2">序号</td>
						<td rowspan="2" align="center">单位名称</td>
						<td rowspan="2">打印及填写错误的出生证编号</td>
						<td rowspan="2">打印及填写错误的时间</td>
						<td rowspan="2">经办人签名</td>
						<td rowspan="2">审核人签名</td>
						<td colspan="2" align="center">作废处理结果</td>
						<td rowspan="2">签发机构负责人签名</td>
						<td rowspan="2">省辖市销毁时间</td>
					</tr>
					<tr>
						<td>废证编号永久存档</td>
						<td>废证交省辖市卫生局按程序销毁</td>
					</tr>
				</thead>
				<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td align="center">${vd401.d40110Zh }</td>
						<td align="center">${vd401.d40105 }</td>
						<td align="center">${vd401.d40108 }</td>
						<td align="center">${vd401.d40109 }</td>
						<td align="center">${vd401.d40111 }</td>
						<td align="center">${vd401.d40120 }</td>
						<td align="center">${vd401.d40121 }</td>
						<td align="center">${vd401.d40122 }</td>
						<td align="center">${vd401.d40123 }</td>
					</tr>
				</c:forEach>
			</table>
	</div><br/><br/>
</body>
</html>