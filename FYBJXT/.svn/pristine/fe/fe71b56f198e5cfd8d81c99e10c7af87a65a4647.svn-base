<%@ page contentType="text/html; charset=GBK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<%



if (request.getParameter("UserName") != null )
{
out.println("<p>");
out.println("用户名是：");
out.println(request.getParameter("UserName"));
out.println("</p>");

out.println("<p>");
out.println("密码是：");
out.println(request.getParameter("Password"));
out.println("</p>");

out.println("<p>");
out.println("锁ID是：");
out.println(request.getParameter("KeyID"));
out.println("</p>");

out.println("<p>");

}
else
{

%>
<body onload="load()" bgcolor="#FFFFFF"><!--在onload事件中处理事件插拨及检查是否已经安装了客户端服务程序-->

<script src="syunew3.js"></script><!--定要包含有我们的UK单元包-->
<SCRIPT LANGUAGE=javascript>

var bConnect=0;
 
function load()
{
	//如果是IE10及以下浏览器，则跳过不处理
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return;
    try
    {
        var s_pnp=new SoftKey3W();
         s_pnp.Socket_UK.onopen = function() 
        {
               bConnect=1;//代表已经连接，用于判断是否安装了客户端服务
        } 
        
        //在使用事件插拨时，注意，一定不要关掉Sockey，否则无法监测事件插拨
        s_pnp.Socket_UK.onmessage =function got_packet(Msg) 
        {
            var PnpData = JSON.parse(Msg.data);
            if(PnpData.type=="PnpEvent")//如果是插拨事件处理消息
            {
                if(PnpData.IsIn) 
                {
                        alert("UKEY已被插入，被插入的锁的路径是："+PnpData.DevicePath);
                }
                else
                {
                        alert("UKEY已被拨出，被拨出的锁的路径是："+PnpData.DevicePath);
                }
            }
        } 
        
        s_pnp.Socket_UK.onclose = function()
        {
            
        }
   }
   catch(e)  
   {  
        alert(e.name + ": " + e.message);
        return false;
    }  
}

var digitArray = new Array('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f');

function toHex( n ) {

        var result = ''
        var start = true;

        for ( var i=32; i>0; ) {
                i -= 4;
                var digit = ( n >> i ) & 0xf;

                if (!start || digit != 0) {
                        start = false;
                        result += digitArray[digit];
                }
        }

        return ( result == '' ? '0' : result );
}

function login_onclick() 
{
    //如果是IE10及以下浏览器，则使用AVCTIVEX控件的方式
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10();
    
    //判断是否安装了服务程序，如果没有安装提示用户安装
    if(bConnect==0)
    {
        window.alert ( "未能连接服务程序，请确定服务程序是否安装。");return false;
    }
    
    
	 try
	 {
		var DevicePath,mylen,ret;
		
		//由于是使用事件消息的方式与服务程序进行通讯，
	    //好处是不用安装插件，不分系统及版本，控件也不会被拦截，同时安装服务程序后，可以立即使用，不用重启浏览器
	    //不好的地方，就是但写代码会复杂一些
		var s_simnew1=new SoftKey3W(); //创建UK类
		
	    s_simnew1.Socket_UK.onopen = function() {
	   	   s_simnew1.ResetOrder();//这里调用ResetOrder将计数清零，这样，消息处理处就会收到0序号的消息，通过计数及序号的方式，从而生产流程
	    } 
		    
		 //写代码时一定要注意，每调用我们的一个UKEY函数，就会生产一个计数，即增加一个序号，较好的逻辑是一个序号的消息处理中，只调用我们一个UKEY的函数
	    s_simnew1.Socket_UK.onmessage =function got_packet(Msg) 
	    {
	        var UK_Data = JSON.parse(Msg.data);
	        if(UK_Data.type!="Process")return ;//如果不是流程处理消息，则跳过
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//发送命令取UK的路径
	                }
	                break;//!!!!!重要提示，如果在调试中，发现代码不对，一定要注意，是不是少了break,这个少了是很常见的错误
	            case 1:
	                {
	                    if( UK_Data.LastError!=0){window.alert ( "未发现加密锁，请插入加密锁");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//获得返回的UK的路径
	                    //获取设置在锁中的用户名
			            //先从地址0读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			            s_simnew1.YReadEx(0,1,"ffffffff","ffffffff",DevicePath);//发送命令取UK地址0的数据
	                    
	                }
	                break;
	            case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("读数据时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//发送命令从数据缓冲区中数据
	                }
	                break;
	            case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("调用GetBuf时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//获得返回的数据缓冲区中数据
	                    
	                    //再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
	                    s_simnew1.YReadString(1,mylen, "ffffffff", "ffffffff", DevicePath);//发送命令从UK地址1中取字符串
	                }
	                break;
	            case 4:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("读取字符串时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.UserName.value=UK_Data.return_value;//获得返回的UK地址1的字符串
	                    
	                    //获到设置在锁中的用户密码,
			            //先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			            s_simnew1.YReadEx(20,1,"ffffffff","ffffffff",DevicePath);//发送命令取UK地址20的数据
	                     
	                }
	                break;
	            case 5:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("读数据时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//发送命令从数据缓冲区中数据
	                }
	                break;
	            case 6:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("调用GetBuf时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//获得返回的数据缓冲区中数据
	                    
	                    //再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
	                    s_simnew1.YReadString(21,mylen,"ffffffff", "ffffffff", DevicePath);//发送命令从UK地址21中取字符串
	                    
	                }
	                break;
	             case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("读取字符串时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.Password.value=UK_Data.return_value;//获得返回的UK地址21的字符串
	                     
	                     
	                     //!!!!!注意，这里一定要主动提交，不能用提交类型的按钮，否则无法完全处理所有的消息
			             frmlogin.submit ();
	                     
	                     //所有工作处理完成后，关掉Socket
	                     s_simnew1.Socket_UK.close();
	                }
	                break;
            }
	    } 
	    s_simnew1.Socket_UK.onclose = function(){

	    }
		return true;
	  }
	 catch(e)  
	  {  
				alert(e.name + ": " + e.message+"。可能是没有安装相应的控件或插件");
				return false;
	  }  

}

function Handle_IE10() 
{
	 try
	 {
		var DevicePath,mylen,ret;
		var s_simnew1;
		//创建控件
	
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");
	
		DevicePath = s_simnew1.FindPort(0);//'来查找加密锁，0是指查找默认端口的锁
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "未发现加密锁，请插入加密锁");return false;
		}
		else
		{
			 //'读取锁的ID
            frmlogin.KeyID.value=toHex(s_simnew1.GetID_1(DevicePath))+toHex(s_simnew1.GetID_2(DevicePath));
            if( s_simnew1.LastError!= 0 )
			{
	            window.alert( "获取用户名错误,错误码是"+s_simnew1.LastError.toString());
		        return false;
			}
			
			//获取设置在锁中的用户名
			//先从地址0读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			ret=s_simnew1.YReadEx(0,1,"ffffffff","ffffffff",DevicePath);
			mylen =s_simnew1.GetBuf(0);
			//再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			frmlogin.UserName.value=s_simnew1.YReadString(1,mylen, "ffffffff", "ffffffff", DevicePath);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert(  "Err to GetUserName,ErrCode is:"+s_simnew1.LastError.toString());
				return false;
			}

			//获到设置在锁中的用户密码,
			//先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			ret=s_simnew1.YReadEx(20,1,"ffffffff","ffffffff",DevicePath);
			mylen =s_simnew1.GetBuf(0);
			//再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			frmlogin.Password.value=s_simnew1.YReadString(21,mylen,"ffffffff", "ffffffff", DevicePath);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert( "获取用户密码错误,错误码是:"+s_simnew1.LastError.toString());
				return false;
			}
			
			frmlogin.submit ();
			return true;
		}
	  }

	 catch(e)  
	  {  
				alert(e.name + ": " + e.message+"。可能是没有安装相应的控件或插件");
				return false;
	  }  

}

</SCRIPT>

<form name="frmlogin" method="post" action="testJSP.jsp">
<table width="354" height="92" border="0">
  <tr>
	<b>用户登录<b>
  </tr>
   <tr>
    <td colspan="2"><input name="chkonly" type="checkbox" id="chkonly" checked>
      请插入加密锁后，然后点击“登录”</td>
  </tr>
  <tr>
    <td width="92"></td>
    <td width="246"><input name="UserName" type="text" id="UserName" style="VISIBILITY: hidden"></td>
  </tr>
  <tr>
    
    <td><input name="Password" type="Password" id="Password" style="VISIBILITY: hidden" ></td>
  </tr>
  <tr>
  
    <td><input name="KeyID" type="text" id="KeyID" style="VISIBILITY: hidden"></td>
  </tr>

  <tr>
    <td>&nbsp;</td>
    <!--/重要，这里的类型一定不能是Submit，否则无法完全处理所有的消息，就提交上去了，一定要主动提交-->
    <td><input type="button" name="Submit" value="提交" onclick="login_onclick()">
  </tr>
</table>

</form>
</body>
</html>
<%
}
%>

