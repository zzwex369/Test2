<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@media print {
   .Noprint {display:none;}
}
</style>
<title>婴儿性别数据统计</title>
</head>
<body>
<div>
	<table id="excel" width="75%" align="center" style="font-size: 14px">
		<tr>
			<td colspan="12">
				<h3 align="center">河南省 &nbsp;&nbsp;______年《出生医学证明》婴儿性别数据统计表</h3>
			</td>
		</tr>
		<tr>
			<td colspan="12" align="left">
				省辖市卫生局名称：${institutionName }
			</td>
		</tr>
		<tr>
			<td colspan="6">
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<table border="2" width="100%" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
					<tr>
						<td><p align="center">单位名称</p></td>
						<td><p align="center">男孩儿比例</p></td>
						<td><p align="center">女孩儿比例</p></td>
						<td><p align="center">男</p></td>
						<td><p align="center">女</p></td>
						<td><p align="center">总数</p></td>
					</tr>  	
					<c:forEach var="listGender" items="${listReportGenderTemp}" varStatus="i">
						<tr height="20">
							<td><p align="center">${listGender.institutionZH }</p></td>
							<td><p align="center">${listGender.percent_boy }</p></td>
							<td><p align="center">${listGender.percent_girl }</p></td>
							<td><p align="center">${listGender.boy }</p></td>
							<td><p align="center">${listGender.girl }</p></td>
							<td><p align="center">${listGender.total }</p></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>         
	</table>
</div>
</body>
</html>