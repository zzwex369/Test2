<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
		<!-- <meta http-equiv="pragma" content="no-cache"/>-->
		<!-- <meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>-->
		<meta  http-equiv="Expires"  content="0" />
		<title>南阳市妇幼保健信息管理平台</title>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript" src="js/softKey/syunew3.js"></script>
		<script type="text/javascript" src="js/softKey/loadKey.js"></script>
		<script type="text/javascript" src="js/softKey/modifyPwd.js"></script>
		<script type="text/javascript" src="js/softKey/modifyPmn.js"></script>
		<style type="text/css">

body {
	margin: 0;
	padding:0px;
	width: 100%;
	height: 100%;
}

iframe {
	width: 100%;
	height: 100%;
	margin:0px; 
	padding:0px;
	border:0px;
}
object{
	
	display:none;
}
</style>
	</head>
	<body>
		<iframe id="mainFrame"></iframe>
<!--		 OBJECT读卡添加的 -->
		<OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7"
			codebase="CVR100.CAB#version=4,0,0,2" id="CVR_IDCard"
			name="CVR_IDCard" width="0" height="0">
		</OBJECT>
		<OBJECT id="pluginKey" type="application/npsyunew3-plugin" width="0"
			height="0">
		</OBJECT>

	</body>
</html>