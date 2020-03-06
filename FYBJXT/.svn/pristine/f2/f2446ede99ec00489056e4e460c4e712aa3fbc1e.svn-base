<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>母婴保健技术考核合格证书</title>
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
</head>
<body>
<center>
  <table id="excel" align="center" >
  	<tr>
  		<td><h3 align="center">《母婴保健技术考核合格证书》申领表</h3></td>
  	</tr>
  	
  	<tr>
  		<td align="left">省辖市卫生局名称：${institutionLabel }</td>
  	</tr>
  	
  	<tr>
  		<td>
  			<table border="1" borderColor="#000000"  align="center"
					style="font-size: 14px; border: gray2px; border-collapse: collapse"
					cellspacing="0" cellpadding="1">
			  <thead>
			  	<tr>
			        <td rowspan="2" nowrap="nowrap">序号</td>
			        <td rowspan="2" nowrap="nowrap">市县区</td>
			        <td rowspan="2" nowrap="nowrap">单位全称</td>
			        <td rowspan="2" nowrap="nowrap">姓名</td>
			        <td rowspan="2" nowrap="nowrap">性别</td>
			        <td rowspan="2" nowrap="nowrap">年龄</td>
			        <td rowspan="2" nowrap="nowrap">学历</td>
			        <td rowspan="2" nowrap="nowrap">职称</td>
			        <td rowspan="2" nowrap="nowrap">专业</td>
			        <td rowspan="2" nowrap="nowrap">工作<br>年限</td>
			        <td colspan="4" nowrap="nowrap">申请项目</td>
			        <td rowspan="2" nowrap="nowrap">培训<br>日期</td>
			        <td rowspan="2" nowrap="nowrap">考核<br>结果</td>
			        <td rowspan="2" nowrap="nowrap">合格证号</td>
			        <td rowspan="2" nowrap="nowrap">发证日期</td>
			    </tr>
			    <tr>
			    	<td nowrap="nowrap">婚前<br>检查</td>
			    	<td nowrap="nowrap">助产<br>技术</td>
			    	<td nowrap="nowrap">结扎<br>技术</td>
			    	<td nowrap="nowrap">终止<br>妊娠</td>
			    </tr>
			  </thead>
			<c:forEach items="${requestScope.vd603s }" var="vd603" varStatus="i">
			  <tr>
			    <td>${i.count }</td>
			    <td nowrap="nowrap">${vd603.d60316Zh }</td>
			    <td nowrap="nowrap">${vd603.d60302Zh }</td>
			    <td nowrap="nowrap">${vd603.d60303 }</td>
			    <td nowrap="nowrap">${vd603.d60304Zh }</td>
			    <td nowrap="nowrap">${vd603.d60306 }</td>
			    <td nowrap="nowrap">${vd603.d60307Zh }</td>
			    <td nowrap="nowrap">${vd603.d60308Zh }</td>
			    <td class="txt">${vd603.d60309Zh }</td>
			    <td class="txt">${vd603.d60310 }</td>
			    <c:choose>
					<c:when test="${vd603.d60312 == 1}">
						<td>√</td>
					</c:when>
					<c:otherwise>
						<td>&nbsp;</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${vd603.d60312 == 2}">
						<td>√</td>
					</c:when>
					<c:otherwise>
						<td>&nbsp;</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${vd603.d60312 == 3}">
						<td>√</td>
					</c:when>
					<c:otherwise>
						<td>&nbsp;</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${vd603.d60312 == 4}">
						<td>√</td>
					</c:when>
					<c:otherwise>
						<td>&nbsp;</td>
					</c:otherwise>
				</c:choose>
			    <td class="txt">${vd603.d60311 }</td>
			    <td class="txt">${vd603.d60313Zh }</td>
			    <td class="txt" nowrap="nowrap">${vd603.d60314 }</td>
			    <td class="txt" nowrap="nowrap">${vd603.d60315 }</td>
			  </tr>
			</c:forEach>
			</table>
  		</td>
  	</tr>
  	<tr>
  		<td align="left" style="padding-top:20px">　　　　填表人　　　　　　　日期　　　　　　　审核人：　　　　　　　日期　　　　</td>
  	</tr>
  </table>
  
  
</center><br/><br/>
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