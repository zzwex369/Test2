<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	td {
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
<body>
<%
 	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String fileName = request.getParameter("fileName");
	response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"),"ISO8859-1")+".xls");
	String str = request.getParameter("htmltable");
	out.print(str); 
%>
</body>
</html>