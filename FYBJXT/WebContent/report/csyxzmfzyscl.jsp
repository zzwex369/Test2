<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生医学证明遗失及其它废证处理情况登记表</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
		border-collapse:	;
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
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
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
</head>
<body>
	<div>
			
				
		<table id="excel"  align="center">
		<tr STYLE="font-size:18pt ; position:relative ; text-align:middle"><td>《出生医学证明》遗失及其它废证处理情况登记表</td></tr>
		<tr STYLE="font-size:12pt ; position:relative ; text-align:left"><td>${institutionLabel }省辖市卫生局（签章）　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
起始时间：<span style="border-bottom:1px solid #000">${requestScope.date_start }</span>
	终止时间：<span style="border-bottom:1px solid #000">${requestScope.date_end }</span></td></tr>
		<tr><td>
			<table border="2" borderColor="#000000"  align="center"
			style="font-size: 14px; border: gray2px; border-collapse: collapse"
			cellspacing="0" cellpadding="1">
			
			<!-- 
				<tr STYLE="font-size:12pt ; position:relative ; text-align:left"><td colspan="7" style="border-top:0px;border-bottom:0px;border-left:0px;border-right:0px">____________省辖市卫生局（签章）</td><td colspan="4"  position:relative ; text-align:left" style="border-top:0px;border-bottom:0px;border-left:0px;border-right:0px">起止时间：</td></tr>
				 -->
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

				<c:forEach var="vd401" items="${requestScope.vd401s }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td nowrap="nowrap" align="center">${vd401.d40110Zh }</td>
						<td nowrap="nowrap" align="center">${vd401.d40105 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40108 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40115 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40109 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40111 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40116 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40117 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40118 }</td>
						<td nowrap="nowrap" align="center">${vd401.d40119 }</td>
					</tr>
				</c:forEach>

				</table>
			</td>
			</tr>
			<tr>
			<td>
			省辖市卫生局:
			　　　　　　　　
			管理人员签字：
			　　　　　　　　
			负责人签字：
			　　　　　　　　
			审核日期：</td></tr>
			</table>
			
	</div><br/><br/>
	<div align="center">
		<form action="/csyxzm/CertificateHandleServlet">
			<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
			<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
			<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
			<input type="hidden" value="${requestScope.date_start }" name="date_start"/>
			<input type="hidden" value="${requestScope.date_end }" name="date_end"/>
			<input type="hidden" value="${requestScope.institution }" name="institution"/>
			<input type="hidden" value="${requestScope.institutionType }" name="institutionType"/>
			<!-- input type="hidden" value="motherExcel" name="flag"/>
			<input type="submit" value="导出Excel"/> -->
			<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" /> 
		</form>
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
</body>
</html>