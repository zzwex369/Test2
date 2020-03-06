<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@media print {
   .Noprint {display:none;}
}
</style>
<title>《出生医学证明》管理使用情况年度统计表</title>
</head>
<body>
<div>
	<table id="excel" width="100%" align="center" style="font-size: 14px">
		<tr>
			<td colspan="17">
				<h3 align="center">河南省 &nbsp;${year }&nbsp;年《出生医学证明》管理使用情况年度统计表</h3>
			</td>
		</tr>
		<tr>
			<td colspan="17" align="left">
				机构名称：${institutionName }
			</td>
		</tr>
		<tr>
			<td colspan="17">
			</td>
		</tr>
		<tr>
			<td colspan="17">
				<table border="2" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
					<tr>
						<td colspan="1" rowspan="3"><p align="center">机构名称</p></td>
						<td colspan="1" rowspan="3"><p align="center">上一年<br/>底库存<br/>数（1）</p></td>
						<td colspan="1" rowspan="3"><p align="center">当年申<br/>领数（2）</p></td>
						<td colspan="12"><p align="center">当年使用情况</p></td>
						<td colspan="1" rowspan="3"><p align="center">当年<br/>年底<br/>库存数（15）</p></td>
						<td colspan="1" rowspan="3"><p align="center">当年医<br/>疗保健<br/>机构内<br/>活产数（16）</p></td>
						
						
					</tr>
					<tr>
						<td colspan="4"><p align="center">医疗保健机构内出生的签发数</p></td>
						<td colspan="3"><p align="center">医疗保健机构外出生的签发数</p></td>
						<td colspan="4"><p align="center">废证数</p></td>
						<td colspan="1" rowspan="2" nowrap="nowrap"><p align="center">合计（14）</p></td>
					</tr>
					<tr>
						<td colspan="1"><p align="center">首次<br/>签发数（3）</p></td>
						<td colspan="1"><p align="center">换发数（4）</p></td>
						<td colspan="1"><p align="center">补发数（5）</p></td>
						<td colspan="1"><p align="center">小计（6）</p></td>
						<td colspan="1"><p align="center">家庭接生<br/>员接生的<br/>签发数（7）</p></td>
						<td colspan="1"><p align="center">其它情<br/>况的签<br/>发数（8）</p></td>
						<td colspan="1"><p align="center">小计（9）</p></td>
						<td colspan="1"><p align="center">因打印或填写错误数（10）</p></td>
						<td colspan="1"><p align="center">遗失数（11）</p></td>
						<td colspan="1"><p align="center">其它原因数（12）</p></td>
						<td colspan="1"><p align="center">小计（13）</p></td>
					</tr>
					<c:forEach items="${requestScope.listBirthCertificateCount}"
						var="birthCertificateCount">
						<tr>
							<td nowrap="nowrap">${birthCertificateCount.institutionName}</td>
							<td nowrap="nowrap">${birthCertificateCount.kc01}</td>
							<td nowrap="nowrap">${birthCertificateCount.sl02}</td>
							<td nowrap="nowrap">${birthCertificateCount.qf03}</td>
							<td nowrap="nowrap">${birthCertificateCount.qf05}</td>
							<td nowrap="nowrap">${birthCertificateCount.qf04}</td>
							<td nowrap="nowrap">${birthCertificateCount.qfCount06}</td>
							<td nowrap="nowrap">${birthCertificateCount.qf07}</td>
							<td nowrap="nowrap">${birthCertificateCount.qf08}</td>
							<td nowrap="nowrap">${birthCertificateCount.qfCount09}</td>
							<td nowrap="nowrap">${birthCertificateCount.fz10}</td>
							<td nowrap="nowrap">${birthCertificateCount.fz11}</td>
							<td nowrap="nowrap">${birthCertificateCount.fz12}</td>
							<td nowrap="nowrap">${birthCertificateCount.fzCount13}</td>
							<td nowrap="nowrap">${birthCertificateCount.syCount14}</td>
							<td nowrap="nowrap">${birthCertificateCount.kc15}</td>
							<td nowrap="nowrap">${birthCertificateCount.hc16}</td>
							
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="17">
			</td>
		</tr>
		<tr>
			<td colspan="17" align="left">
				注：1、本统计表的《出生医学证明》数量为内芯数量，单位均为“枚”。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				表中逻辑关系：（6）=（3）+（4）+（5）；（9）=（7）+（8）；（13）=（10）+（11）+（12）；（14）=（6）+（9）+（13）；（15）=（1）+（2）-（14）；<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				2、“换发”原则为“0”；“家庭接生员”是指获得卫生部颁发的“家庭接生员证书”的人员。我省自1996年以来已经不存在“家庭接生员”，因此“家庭接生员的签发数（7）”应为“0”，
				有“家庭接生”的应追究法律责任；机构外其他情况的签发数（8）为“0”，如有发生应追究法律责任。<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				3、有补发和废证的应同时上报补证、废证登记本（样表10、13）；有遗失、其他原因及打印填写错误的分别上报等记和处理情况。<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				4、统计数据应为：当年1月1日至12月31日。
			</td>
		</tr>
		<tr>
			<td colspan="17">
			</td>
		</tr>
		<tr>
			<td colspan="17">
			</td>
		</tr>
		<tr>
			<td width="20%" colspan="4" >
				负责人：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
			</td>
			<td width="20%" colspan="4">
				填表人：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
			</td>
			<td width="20%" colspan="4">
				联系电话：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
			</td>
			<td width="50%" colspan="4">
				填表日期：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
			</td>
		</tr>
	</table>
</div>		
	<div align="center" style="margin-top:30px;">
		<form action="/csyxzm/CencusServlet" method="post">
			<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
			<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
			<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
			<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" class="Noprint"/>
		</form>
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