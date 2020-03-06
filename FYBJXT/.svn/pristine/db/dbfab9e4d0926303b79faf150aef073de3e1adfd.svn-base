<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>《母婴保健技术服务执业许可证》申领表</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		border-collapse:collapse;
	}
	thead {
		background:#ccc;
	}
	td
	{
		text-align:center; 
	}
</style>
</head>
<body>
	<table id="excel" align="center">
		<tr>
			<td style="text-align:left;">
				<h3 align="center">《母婴保健技术服务执业许可证》申领表</h3>
				省辖市卫生局名称：${requestScope.institutionName}　　　　　　　　　　机构总数：${requestScope.vd602s.size() }
			</td>
		</tr>
		<tr>
			<td>
				<table border="1" borderColor="#000000"  align="center"
				style="font-size: 14px; border: gray2px; border-collapse: collapse"
				cellspacing="0" cellpadding="1">
				<thead>
					<tr>
						<td rowspan="2">序号</td>
						<td rowspan="2">县市区</td>
						<td rowspan="2">申请单位（全称）</td>
						<td rowspan="2">法人代表</td>
						<td rowspan="2">机构类别</td>
						<td rowspan="2">地址</td>
						<td rowspan="2">联系人</td>
						<td rowspan="2">联系电话</td>
						<td colspan="4">申请项目</td>
					</tr>
					<tr>
						<td>婚前<br>检查</td>
						<td>助产<br>技术</td>
						<td>结扎<br>手术</td>
						<td>终止<br>妊娠</td>
					</tr>
				</thead>
					<c:forEach items="${requestScope.vd602s }" var="vd602" varStatus="i">
				    	<tr>
				    		<td nowrap="nowrap">${i.count }</td>
				    		<td nowrap="nowrap">${vd602.d60209ZH }</td>
				    		<td nowrap="nowrap">${vd602.d60202ZH }</td>
				    		<td nowrap="nowrap">${vd602.d60203 }</td>
				    		<td nowrap="nowrap">${vd602.d60204ZH }</td>
				    		<td nowrap="nowrap">${vd602.d60205 }</td>
				    		<td nowrap="nowrap">${vd602.d60206 }</td>
				    		<td nowrap="nowrap">${vd602.d60207 }</td>
				    		<c:choose>
								<c:when test="${vd602.d60208 == 1}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd602.d60208 == 2}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd602.d60208 == 3}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${vd602.d60208 == 4}">
									<td>√</td>
								</c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose>
				    	</tr>
				    </c:forEach>
				</table><br><br>
	<table borderColor="#000000" cellSpacing="0" align="center"  border="0">
		<tr>
			<td align="center">
				<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
				<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
				<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
				<input type="button" onClick="AutomateExcel();" value="导出EXCEL" class="Noprint"/>
			</td>
		</tr>
	</table>
			</td>
		</tr>
	</table>
	
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