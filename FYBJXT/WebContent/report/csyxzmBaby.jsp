<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新生儿管理信息提供</title>
<style type="text/css">
	table
	{
		width:940px;
		text-align:center;
		vertical-align:middle;
		font-size:14px;
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
</head>
<body>
<center>
	<table id="excel" align="center">
		<tr><td align="center"><h3>新生儿管理信息提供</h3></td></tr>
		<tr>
			<td>
				<table borderColor="#000000" cellSpacing="0" align="center"  border="1">
			  		<thead>
			  			<tr>
			        		<td nowrap="nowrap">序号</td>
			        		<td nowrap="nowrap">婴儿姓名</td>
			        		<td nowrap="nowrap">性别</td>
			        		<td>出生日期</td>
			        		<td nowrap="nowrap">出生证号</td>
			        		<td>出生地</td>
			        		<td>家庭地址</td>
			        		<td>接生机构</td>
			        		<td nowrap="nowrap">父亲姓名</td>
			        		<td nowrap="nowrap">父亲身份证号</td>
			        		<td nowrap="nowrap">母亲姓名</td>
			        		<td nowrap="nowrap">母亲身份证号</td>
			        		<td nowrap="nowrap">联系方式</td>
			    		</tr>
			    	</thead>
			    	<c:forEach items="${requestScope.vd301s }" var="vd301" varStatus="i">
				    	<tr>
				    		<td>${i.count }</td>
				    		<td>${vd301.d30102 }</td>
				    		<td>${vd301.d30103Zh }</td>
				    		<td nowrap="nowrap">${vd301.d30104 }</td>
				    		<td nowrap="nowrap">${vd301.d30110 }</td>
				    		<td nowrap="nowrap">${vd301.d30105Zh }</td>
				    		<td nowrap="nowrap">${vd301.d30121 }</td>
				    		<td nowrap="nowrap">${vd301.d30124Zh }</td>
				    		<td>${vd301.d30116 }</td>
				    		<td  class="txt" nowrap="nowrap">${vd301.d30117 }</td>
				    		<td>${vd301.d30111 }</td>
				    		<td class="txt" nowrap="nowrap">${vd301.d30112 }</td>
				    		<td nowrap="nowrap">${vd301.d30143 }</td>
				    	</tr>
				    </c:forEach>
			 	</table>
			</td>
		</tr>
	</table>
  
	
</center>
<br/><br/>
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