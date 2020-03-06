<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>孕产妇产后管理信息提供</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
		border-collapse:collapse;
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
<center>
	<table id="excel" borderColor="#000000" cellSpacing="0" align="center"  border="0">
  			<tr>
  				<td align="left"><h3 align="center">孕产妇产后管理信息提供</h3></td>
  			</tr>
  			<tr>
  				<td>
  					<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
  						<tr style="background-color:#CCC;">
			        		<td nowrap="nowrap">序号</td>
			        		<td>母亲姓名</td>
			        		<td>身份证号</td>
			        		<td>生产日期</td>
			        		<td>家庭地址</td>
			        		<td>婴儿姓名</td>
			        		<td>出生证号</td>
			        		<td>生产医院</td>
			        		<td>联系方式</td>
			    		</tr>
				    	<c:forEach items="${requestScope.vd301s }" var="vd301" varStatus="i">
					    	<tr>
					    		<td nowrap="nowrap">${i.count }</td>
					    		<td nowrap="nowrap">${vd301.d30111 }</td>
					    		<td class="txt">${vd301.d30112 }</td>
					    		<td nowrap="nowrap">${vd301.d30104 }</td>
					    		<td nowrap="nowrap">${vd301.d30121 }</td>
					    		<td nowrap="nowrap">${vd301.d30102 }</td>
					    		<td nowrap="nowrap">${vd301.d30110 }</td>
					    		<td nowrap="nowrap">${vd301.d30124Zh }</td>
					    		<td nowrap="nowrap" class="txt">${vd301.d30143 }</td>
					    	</tr>
					    </c:forEach>
  					</table>
  				</td>
  			</tr>
 	</table>
</center>
<br/><br/>
	<div align="center">
		<form action="/csyxzm/CertificateFamilyServlet" method="post">
			<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
			<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
			<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
			<input type="hidden" value="${requestScope.areaCode }" name="areaCode"/>
			<input type="hidden" value="${requestScope.date_start }" name="date_start"/>
			<input type="hidden" value="${requestScope.date_end }" name="date_end"/>
			<input type="hidden" value="${requestScope.queryType }" name="queryType"/>
			<!-- input type="hidden" value="motherExcel" name="flag"/>
			<input type="submit" value="导出Excel"/> -->
			<input type="button" onClick="return AutomateExcel();" value="导出EXCEL" /> 
		</form>
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
</body>
</html>