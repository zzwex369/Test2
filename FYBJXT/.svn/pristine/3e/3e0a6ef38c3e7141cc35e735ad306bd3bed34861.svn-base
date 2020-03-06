<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>出生医学证明打印</title>
	<style type="text/css">
		.td_font
		{
        	font-size:12px;
		}
		@media print {
   			.Noprint {display:none;}
		}
		.divV
		{
			width:1159px;
			height:470px;
		    background-image: url("birth.jpg");
		}
	</style>
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="../js/printBirthInfo.js"></script>
</head>
<body bgcolor="#ffffff">
	<div id="printDiv" class="divV"></div>
	<div align="center">
		<input type="button" value="打印..." onclick="wb.execwb(6,6)" class="Noprint"/>
		<input type="button" value="打印页面设置..." onclick="wb.execwb(8,1)" class="Noprint"/>
		<input type="button" value="打印页面预览..." onclick="wb.execwb(7,1)" class="Noprint"/>
	</div>
	<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
	<input type="hidden" id="d30110" value="${param.d30110}"/>
</body>
</html>