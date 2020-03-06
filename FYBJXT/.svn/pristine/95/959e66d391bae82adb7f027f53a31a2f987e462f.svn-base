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
<title>出生证使用情况</title>
</head>
<body>
<div>
	<table id="excel" width="75%" align="center" style="font-size: 14px">
		<tr>
			<td colspan="12">
				<h3 align="center">河南省 《出生医学证明》出生证使用情况</h3>
			</td>
		</tr>
		<!-- tr>
			<td colspan="12" align="left">
				省辖市卫生局名称：${institutionName }
			</td>
		</tr>-->
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
						<td width="300"><p align="center">所属地区</p></td>
						<td><p align="center">出生总数</p></td>
						<td><p align="center">男</p></td>
						<td><p align="center">女</p></td>
						<td><p align="center">本地</p></td>
						<td><p align="center">外地</p></td>
					</tr>  	
					<c:forEach var="listGender" items="${listReportGenderTemp}" varStatus="i">
						<tr height="20">
							<td width="300"><p align="center">${listGender.institutionZH }</p></td>
							<td><p align="center">${listGender.total }</p></td>
							<td><p align="center">${listGender.boy }</p></td>
							<td><p align="center">${listGender.girl }</p></td>
							<td><p align="center">${listGender.nativePlace }</p></td>
							<td><p align="center">${listGender.otherPlaces }</p></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>         
	</table>
</div>
<br><br>
<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
		<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" class="Noprint"/> 
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