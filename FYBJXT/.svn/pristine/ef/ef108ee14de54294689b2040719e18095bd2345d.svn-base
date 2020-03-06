<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table id="excel" align="center">
		<tr>
			<td colspan="7" align="center"><h3>《出生医学证明》废证登记本</h3></td>
		</tr>
		<tr>
			<td><div align="left">单位名称：<span style="border-bottom:1px solid #000">${requestScope.institutionLabel }</span></div></td>
			<td colspan="6">
				<div align="right">
					起始时间：<span style="border-bottom:1px solid #000">${requestScope.date_start }</span>
					终止时间：<span style="border-bottom:1px solid #000">${requestScope.date_end }</span>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="8">
				<table border="1" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
					<thead>
					<tr>
						<td rowspan="2" nowrap="nowrap">序号</td>
						<td rowspan="2" nowrap="nowrap">县市区及单位名称</td>
						<td rowspan="2" nowrap="nowrap">日期</td>
						<td rowspan="2" nowrap="nowrap">出生证编号</td>
						<td colspan="6" nowrap="nowrap">废证原因</td>
						<td rowspan="2" nowrap="nowrap">审核人签名</td>
						<td rowspan="2" nowrap="nowrap">经办人签名</td>
					</tr>
					<tr>
						<td nowrap="nowrap">打印错误 </td>
						<td nowrap="nowrap">被盗</td>
						<td nowrap="nowrap">家长遗失</td>
						<td nowrap="nowrap">医院遗失</td>
						<td nowrap="nowrap">损毁</td>
						<td nowrap="nowrap">其他</td>
					</tr>
					</thead>
					<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
						<tr>
							<td>${i.count }</td>
							<td nowrap="nowrap">${vd401.d40113Zh }</td>
							<td nowrap="nowrap"><fmt:formatDate value="${vd401.d40108}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${vd401.d40105 }</td>
							<c:choose>
								<c:when test="${vd401.d40106 == 1}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd401.d40106 == 4}">
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
								<c:when test="${vd401.d40106 == 10}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd401.d40106 == 9}">
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
			</td>
		</tr>
	</table>
			
</div><br/><br/>
<div align="center">
	<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
	<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
	<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
	<input type="button" onClick="AutomateExcel();" value="导出EXCEL" class="Noprint"/> 
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