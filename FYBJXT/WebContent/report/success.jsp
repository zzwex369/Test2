<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载</title>
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
 <%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.SocketException"%>
</head>
<body>
<%
      //关于文件下载时采用文件流输出的方式处理：
      //加上response.reset()，并且所有的％>后面不要换行，包括最后一个；

      response.reset();//可以加也可以不加
      response.setContentType("application/x-download");
      //上传服务器地址
      String filedownload = "//csyxzm//csyxzm_fy//csyxzm//"+request.getAttribute("pathname");
      String systemName = (String)request.getAttribute("systemName");
      //本地测试地址   String filedownload = "E:\\WorkSpace\\Eclipse\\ny\\CSYXZM\\"+request.getAttribute("pathname");
   //   String filedownload = "E:\\WorkSpace\\Eclipse\\Flex\\FYBJXT\\build\\classes\\"+request.getAttribute("pathname");
      String filedisplay = "N047_"+systemName+".dbf";
      //java.net.URLEncoder.encode()必须加这个 不然汉字显示为_ 字符集问题 
      response.addHeader("Content-Disposition","attachment;filename=" + java.net.URLEncoder.encode(filedisplay));

      OutputStream outp = null;
      FileInputStream in = null;
      try
      {
          outp = response.getOutputStream();
          in = new FileInputStream(filedownload);//"E:\\WorkSpace\\Eclipse\\ny\\CSYXZM\\WebContent\\report\\dbf\\4113.dbf"

          byte[] b = new byte[1024];
          int i = 0;

          while((i = in.read(b)) > 0)
          {
              outp.write(b, 0, i);
          }
          outp.flush();
      }
      catch(SocketException e)
      {
      }catch(Exception e)
      {
        // System.out.println("Error!");
         e.printStackTrace();
      }
      finally
      {
          if(in != null)
          {
              in.close();
              in = null;
          }
          if(outp != null)
          {
              outp.close();
              outp = null;
          }
      }
%>
</body>
</html>