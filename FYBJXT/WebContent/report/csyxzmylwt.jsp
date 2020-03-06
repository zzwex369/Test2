<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出生医学证明遗留问题统计表</title>
<style>
table
	{
		text-align:center;
		vertical-align:middle;
		border-collapse:collapse;
	}
.font530100
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;}
.xl1530100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6330100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:bottom;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6430100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:20.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:bottom;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6530100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:left;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6630100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6730100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl6830100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl6930100
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-char-type:none;}
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
<table id="excel" border=0 cellpadding=0 cellspacing=0 width=1137 align="center" style='border-collapse:
 collapse;table-layout:fixed;width:857pt'>
 <col width=45 style='mso-width-source:userset;mso-width-alt:1440;width:34pt'>
 <col width=57 style='mso-width-source:userset;mso-width-alt:1824;width:43pt'>
 <col width=45 span=3 style='mso-width-source:userset;mso-width-alt:1440;
 width:34pt'>
 <col width=58 style='mso-width-source:userset;mso-width-alt:1856;width:44pt'>
 <col width=61 style='mso-width-source:userset;mso-width-alt:1952;width:46pt'>
 <col width=78 style='mso-width-source:userset;mso-width-alt:2496;width:59pt'>
 <col width=45 span=2 style='mso-width-source:userset;mso-width-alt:1440;
 width:34pt'>
 <col width=73 style='mso-width-source:userset;mso-width-alt:2336;width:55pt'>
 <col width=82 style='mso-width-source:userset;mso-width-alt:2624;width:62pt'>
 <col width=85 style='mso-width-source:userset;mso-width-alt:2720;width:64pt'>
 <col width=63 span=2 style='mso-width-source:userset;mso-width-alt:2016;
 width:47pt'>
 <col width=65 style='mso-width-source:userset;mso-width-alt:2080;width:49pt'>
 <col width=60 style='mso-width-source:userset;mso-width-alt:1920;width:45pt'>
 <col width=77 style='mso-width-source:userset;mso-width-alt:2464;width:58pt'>
 <col width=45 style='mso-width-source:userset;mso-width-alt:1440;width:34pt'>
 <tr height=34 style='height:25.5pt'>
  <td colspan=18 height=34 class=xl6430100 width=1092 style='height:25.5pt;
  width:823pt'>《出生医学证明》遗留问题统计表</td>
  <td class=xl6330100 width=45 style='width:34pt'></td>
 </tr>
 <tr class=xl6730100 height=46 style='mso-height-source:userset;height:34.5pt'>
  <td colspan=18 height=46 class=xl6630100 style='height:34.5pt'>(<span
  style='mso-spacerun:yes'>&nbsp; </span>__________省辖市 _________年度)</td>
  <td class=xl6630100></td>
 </tr>
 <tr class=xl6730100 height=42 style='mso-height-source:userset;height:31.5pt'>
  <td colspan=18 height=42 class=xl6530100 style='height:31.5pt'>${institutionLabel }县（市、区）　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
起始时间：<span style="border-bottom:1px solid #000">${requestScope.date_start }</span>
	终止时间：<span style="border-bottom:1px solid #000">${requestScope.date_end }</span>
</td>
  <td class=xl6630100></td>
 </tr>
 <tr class=xl6930100 height=69 style='mso-height-source:userset;height:51.75pt'>
  <td height=69 class=xl6830100 width=45 style='height:51.75pt;width:34pt'>序号</td>
  <td class=xl6830100 width=57 style='border-left:none;width:43pt'>助产机构全称</td>
  <td class=xl6830100 width=45 style='border-left:none;width:34pt'>出生日期</td>
  <td class=xl6830100 width=45 style='border-left:none;width:34pt'>婴儿姓名</td>
  <td class=xl6830100 width=45 style='border-left:none;width:34pt'>母亲姓名</td>
  <td class=xl6830100 width=58 style='border-left:none;width:44pt'>母亲身份证号</td>
  <td class=xl6830100 width=61 style='border-left:none;width:46pt'>父母结婚证号</td>
  <td class=xl6830100 width=78 style='border-left:none;width:59pt'>亲子鉴定证明编号</td>
  <td class=xl6830100 width=45 style='border-left:none;width:34pt'>父亲姓名</td>
  <td class=xl6830100 width=45 style='border-left:none;width:34pt'>父亲身份证号</td>
  <td class=xl6830100 width=73 style='border-left:none;width:55pt'>母亲户籍地证明是否入户</td>
  <td class=xl6830100 width=82 style='border-left:none;width:62pt'>父亲户籍地证明是否入户</td>
  <td class=xl6830100 width=85 style='border-left:none;width:64pt'>单位或社区证明延迟申领原因</td>
  <td class=xl6830100 width=63 style='border-left:none;width:47pt'>母、父亲联系电话</td>
  <td class=xl6830100 width=63 style='border-left:none;width:47pt'>助产人员签字</td>
  <td class=xl6830100 width=65 style='border-left:none;width:49pt'>产科主任签字</td>
  <td class=xl6830100 width=60 style='border-left:none;width:45pt'>助产机构院长签字</td>
  <td class=xl6830100 width=77 style='border-left:none;width:58pt'>助产机构联系电话</td>
  <td class=xl6930100 width=45 style='width:34pt'></td>
 </tr>
 <tr height=0 style='display:none'>
  <td width=45 style='width:34pt'></td>
  <td width=57 style='width:43pt'></td>
  <td width=45 style='width:34pt'></td>
  <td width=45 style='width:34pt'></td>
  <td width=45 style='width:34pt'></td>
  <td width=58 style='width:44pt'></td>
  <td width=61 style='width:46pt'></td>
  <td width=78 style='width:59pt'></td>
  <td width=45 style='width:34pt'></td>
  <td width=45 style='width:34pt'></td>
  <td width=73 style='width:55pt'></td>
  <td width=82 style='width:62pt'></td>
  <td width=85 style='width:64pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=65 style='width:49pt'></td>
  <td width=60 style='width:45pt'></td>
  <td width=77 style='width:58pt'></td>
  <td width=45 style='width:34pt'></td>
 </tr>
</table><br>
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