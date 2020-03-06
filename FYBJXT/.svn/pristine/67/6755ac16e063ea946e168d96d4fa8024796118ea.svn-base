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
	 //如果是IE10及以下浏览器，则跳过不处理，
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
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10_login();
    
   //判断是否安装了服务程序，如果没有安装提示用户安装
    if(bConnect==0)
    {
        window.alert ( "未能连接服务程序，请确定服务程序是否安装。");return false;
    }
    
   	var DevicePath,ret,n,mylen,ID_1,ID_2,addr;
	try
	{
			
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
	        //alert(Msg.data);
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
	                    s_simnew1.GetID_1(DevicePath); //发送命令取ID_1
	                }
	                break;
	            case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("返回ID号错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    ID_1=UK_Data.return_value;//获得返回的UK的ID_1
	                    s_simnew1.GetID_2(DevicePath); //发送命令取ID_2
	                }
	                break;
	             case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("取得ID错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                     ID_2=UK_Data.return_value;//获得返回的UK的ID_2
	                     
	                     frmlogin.KeyID.value=toHex(ID_1)+toHex(ID_2);
	                     
	                     s_simnew1.ContinueOrder();//为了方便阅读，这里调用了一句继续下一行的计算的命令，因为在这个消息中没有调用我们的函数，所以要调用这个
	                }
	                break;
	             case 4:
	                {
	                    //获取设置在锁中的用户名
			            //先从地址0读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			            addr=0;
			            s_simnew1.YReadEx(addr,1,"ffffffff","ffffffff",DevicePath);//发送命令取UK地址0的数据
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
	                    
	                    //再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
	                    addr=1;
	                    s_simnew1.YReadString(addr,mylen, "ffffffff", "ffffffff", DevicePath);//发送命令从UK地址1中取字符串
	                }
	                break;
	            case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("获取用户名时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.UserName.value=UK_Data.return_value;//获得返回的UK地址1的字符串
	                    
	                    //获到设置在锁中的用户密码,
			            //先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
			            addr=20;
			            s_simnew1.YReadEx(addr,1,"ffffffff","ffffffff",DevicePath);//发送命令取UK地址20的数据
	                }
	                break;
	            case 8:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("读数据时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//发送命令从数据缓冲区中数据
	                }
	                break;
	            case 9:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("调用GetBuf时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//获得返回的数据缓冲区中数据
	                    
	                    //再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
	                    addr=21;
	                    s_simnew1.YReadString(addr,mylen,"ffffffff", "ffffffff", DevicePath);//发送命令从UK地址21中取字符串
	                }
	                break;
	             case 10:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("获取用户密码时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.Password.value=UK_Data.return_value;//获得返回的UK中地址21的字符串
	                    
	                    frmlogin.submit();	
	                    
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
		alert(e.name + ": " + e.message);
		return false;
	 }  

}


function button1_onclick() 
{
	    //如果是IE10及以下浏览器，则使用AVCTIVEX控件的方式
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10_1();
    
	//判断是否安装了服务程序，如果没有安装提示用户安装
    if(bConnect==0)
    {
        window.alert ( "未能连接服务程序，请确定服务程序是否安装。");return false;
    }
    
    if(frmlogin.UserName.value=="" || frmlogin.Password.value=="")
    {
	    window.alert ( "请输入用户名密码后才进行操作。");return 0;
    }
    
   	var DevicePath,ret,n,mylen,addr;
	try
	{
			
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
	       // alert(Msg.data);
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
	                    
	                    //写用户名
	                    //写入用户名到地址1，使用默认的写密码"FFFFFFFF","FFFFFFFF"
	                    addr=1;
	                    s_simnew1.YWriteString(frmlogin.UserName.value, addr, "ffffffff", "ffffffff", DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("写入用户名失败。错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen = UK_Data.return_value;
	                    
	                    s_simnew1.SetBuf( mylen, 0);//设置要字符串的长度到缓冲区中，
	                }
	                break;
	                
                case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("调用SetBuf时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                    //写入缓冲区的数据即用户名的字符串长度到地址0，使用默认的写密码"FFFFFFFF","FFFFFFFF"
	                    addr=0;
	                    s_simnew1.YWriteEx(addr, 1, "ffffffff", "ffffffff",DevicePath);
	                }
	                break;
                case 4:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("写入用户名长度失败。错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    //写用户密码
	                    //写入用户密码到地址21，使用默认的写密码"FFFFFFFF","FFFFFFFF"
	                    addr=21;
	                    s_simnew1.YWriteString(frmlogin.Password.value, addr, "ffffffff", "ffffffff", DevicePath);
	                }
	                break;
                case 5:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("写入用户密码失败。错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen = UK_Data.return_value;
	                    
	                    s_simnew1.SetBuf( mylen, 0);//设置要字符串的长度到缓冲区中，
	                }
	                break;
                case 6:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("调用SetBuf时错误，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    //写入用户名密码的字符串长度到地址20，使用默认的写密码"FFFFFFFF","FFFFFFFF"
	                    addr=20;
	                    s_simnew1.YWriteEx(addr, 1, "ffffffff", "ffffffff",DevicePath);
	                }
	                break;	
	            case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("写入用户密码长度失败，错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "写入成功");
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
		alert(e.name + ": " + e.message);
		return false;
	 }  

}  

function button2_onclick() 
{
	var DevicePath,ret;
    //如果是IE10及以下浏览器，则使用AVCTIVEX控件的方式
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) 
    {
		var s_simnew1;
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3")//创建控件
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "未发现加密锁，请插入加密锁");return false;
		}
		else
		{
			ret=s_simnew1.SetWritePassword(frmlogin.w_hkey.value,frmlogin.w_lkey.value,frmlogin.new_w_hkey.value,frmlogin.new_w_lkey.value, DevicePath);
			if( ret != 0 )
			{ 
				window.alert ( "设置写密码错误");return false;
			}
			window.alert ( "设置写密码成功");
		}
		return true;
    }
    
	 //判断是否安装了服务程序，如果没有安装提示用户安装
    if(bConnect==0)
    {
        window.alert ( "未能连接服务程序，请确定服务程序是否安装。");return false;
    }
    
   	
	try
	{
			
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
	        //alert(Msg.data);
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
	                    
	                    //设置写密码
	                    s_simnew1.SetWritePassword(frmlogin.w_hkey.value,frmlogin.w_lkey.value,frmlogin.new_w_hkey.value,frmlogin.new_w_lkey.value, DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("设置写密码错误。错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "设置写密码成功");
	                     
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
		alert(e.name + ": " + e.message);
		return false;
	 }  			
}

function button3_onclick() 
{
	var DevicePath,ret;
	

	//如果是IE10及以下浏览器，则使用AVCTIVEX控件的方式
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1)
    {	
		var s_simnew1;
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");//创建控件
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "未发现加密锁，请插入加密锁");return false;
		}
		else
		{
			ret=s_simnew1.SetReadPassword(frmlogin.w_hkey_2.value,frmlogin.w_lkey_2.value,frmlogin.r_hkey.value,frmlogin.r_lkey.value, DevicePath);
			if( ret != 0 )
			{ 
				window.alert ( "设置读密码错误");return false;
			}
			window.alert ( "设置读密码成功");
		}
		return true;
	}
    
	 //判断是否安装了服务程序，如果没有安装提示用户安装
    if(bConnect==0)
    {
        window.alert ( "未能连接服务程序，请确定服务程序是否安装。");return false;
    }
    
	try
	{
			
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
	        //alert(Msg.data);
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
	                    
	                    //设置读密码，注意，设置新的读密码，是用原“写”密码，而不是用原“读”密码
	                    s_simnew1.SetReadPassword(frmlogin.w_hkey_2.value,frmlogin.w_lkey_2.value,frmlogin.r_hkey.value,frmlogin.r_lkey.value, DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("设置读密码错误。错误码为："+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "设置读密码成功");
	                     
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
		alert(e.name + ": " + e.message);
		return false;
	 }  			
}

function Handle_IE10_login() 
{
	var DevicePath,ret,n,mylen;
	try
	{
			//建立操作我们的锁的控件对象，用于操作我们的锁
            var s_simnew1;
		    //创建控件

			s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");

            
            //查找是否存在锁,这里使用了FindPort函数
			DevicePath = s_simnew1.FindPort(0);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert ( "未发现加密锁，请插入加密锁。");
				
				return false;
			}
			
			 //'读取锁的ID
            frmlogin.KeyID.value=toHex(s_simnew1.GetID_1(DevicePath))+toHex(s_simnew1.GetID_2(DevicePath));
            if( s_simnew1.LastError!= 0 )
			{
	            window.alert( "获取ID时错误,错误码是:"+s_simnew1.LastError.toString());
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
				window.alert(  "获取用户名错误,错误码是:"+s_simnew1.LastError.toString());
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
	catch (e) 
	{
		alert(e.name + ": " + e.message+"。可能是没有安装相应的控件或插件");
	}
}

function Handle_IE10_1() 
{
	try
	 {
		var DevicePath,mylen,ret;
		//建立操作我们的锁的控件对象，用于操作我们的锁
        var s_simnew1;
	    //创建控件
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");
	    
	    //查找是否存在锁,这里使用了FindPort函数
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
		    window.alert ( "未发现加密锁，请插入加密锁");return false;
		}
		else
		{
		    if(frmlogin.UserName.value=="" || frmlogin.Password.value=="")
		    {
			    window.alert ( "请输入用户名密码后才进行操作。");return false;
		    }
		    //写入用户名到地址1，使用默认的写密码"FFFFFFFF","FFFFFFFF"
		    mylen = s_simnew1.YWriteString(frmlogin.UserName.value, 1, "ffffffff", "ffffffff", DevicePath);
		    if( s_simnew1.LastError!= 0 )
		    { 
			    window.alert ( "写入用户名失败。错误码是："+s_simnew1.LastError.toString());return false;
		    }
		    s_simnew1.SetBuf( mylen, 0);
		    //写入用户名的字符串长度到地址0，使用默认的写密码"FFFFFFFF","FFFFFFFF"
		    ret = s_simnew1.YWriteEx(0, 1, "ffffffff", "ffffffff",DevicePath);
		    if( ret != 0 )
		    { 
			    window.alert ( "写入用户名长度失败。错误码是："+s_simnew1.LastError.toString());return false;
		    }
		    
		    //写入用户密码到地址21，使用默认的写密码"FFFFFFFF","FFFFFFFF"
		    mylen = s_simnew1.YWriteString(frmlogin.Password.value, 21, "ffffffff", "ffffffff", DevicePath);
		    if( s_simnew1.LastError!= 0 )
		    { 
			    window.alert ( "写入用户密码失败。错误码是："+s_simnew1.LastError.toString());return false;
		    }
		    s_simnew1.SetBuf( mylen, 0);
		    //写入用户名密码的字符串长度到地址20，使用默认的写密码"FFFFFFFF","FFFFFFFF"
		    ret = s_simnew1.YWriteEx(20, 1, "ffffffff", "ffffffff",DevicePath);
		    if( ret != 0 )
		    { 
			    window.alert ( "写入用户密码长度失败。错误码是："+s_simnew1.LastError.toString());return false;
		    }
		    window.alert ( "写入成功");
		    return true;
		}
	}
	catch(e)  
	  {  
		alert(e.name + ": " + e.message);
		return false;
	  }  
}  

</SCRIPT>


<form name="frmlogin" method="post" action="WriteSN.jsp">
<table width="354" height="92" border="0">
  <tr>

    <b>用户登录<b>

  </tr>
  <tr>
    <td colspan="2"><input name="chkonly" type="checkbox" id="chkonly" checked>
      请插入加密锁后，然后点击“登录”</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <!--/重要，这里的类型一定不能是Submit，否则无法完全处理所有的消息，就提交上去了，一定要主动提交-->
    <td><input type="button" name="Submit" value="提交" onclick="login_onclick()">
    &nbsp;<input name="reset" type="reset" id="reset" value="重置"></td>
        <td>&nbsp;
  </tr>
</table>

<p>
  请输入用户名：<input name="UserName" type="text" id="UserName" >
</p>
<p> 
请输入用户密码：<input name="Password" type="password" id="Password" >
</p>
<input name="KeyID" type="text" id="KeyID" style="VISIBILITY: hidden">
<p> 
  <input type="button" name="button1" value="写入用户名及密码" onClick="button1_onclick()">
</p>
<p>&nbsp;</p>
<p>设置写密码：</p>
<p>原写密码：
  <input name="w_hkey" type="text" id="w_hkey" value="ffffffff" >
  --
  <input name="w_lkey" type="text" id="w_lkey" value="ffffffff" >
</p>
<p>新写密码：
  <input name="new_w_hkey" type="text" id="new_w_hkey" value="ffffffff" >
  --
  <input name="new_w_lkey" type="text" id="new_w_lkey" value="ffffffff" >
</p>
<p>
  <input type="button" name="button2" value="设置" onClick="button2_onclick()">
</p>
<p>&nbsp;</p>
<p>设置读密码：</p>
<p>写密码：
  <input name="w_hkey_2" type="text" id="w_hkey_2" value="ffffffff" >
  --
  <input name="w_lkey_2" type="text" id="w_lkey_2" value="ffffffff" >
</p>
<p>新的读密码：
  <input name="r_hkey" type="text" id="r_hkey" value="ffffffff" >
  --
  <input name="r_lkey" type="text" id="r_lkey" value="ffffffff" >
</p>
<p>
  <input type="button" name="button3" value="设置" onClick="button3_onclick()">
</p>
<p>注意设置读密码是用“写”密码设置</p>
<p>&nbsp;</p>
</form>
</body>
</html>
<%
}
%>

