<%@ page contentType="text/html; charset=GBK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
</head>
<%

if (request.getParameter("UserName") != null )
{
out.println("<p>");
out.println("�û����ǣ�");
out.println(request.getParameter("UserName"));
out.println("</p>");

out.println("<p>");
out.println("�����ǣ�");
out.println(request.getParameter("Password"));
out.println("</p>");

out.println("<p>");
out.println("��ID�ǣ�");
out.println(request.getParameter("KeyID"));
out.println("</p>");

out.println("<p>");

}
else
{

%>
<body onload="load()" bgcolor="#FFFFFF"><!--��onload�¼��д����¼��岦������Ƿ��Ѿ���װ�˿ͻ��˷������-->

<script src="syunew3.js"></script><!--��Ҫ���������ǵ�UK��Ԫ��-->
<SCRIPT LANGUAGE=javascript>

var bConnect=0;
 
function load()
{
	 //�����IE10�������������������������
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return;
    try
    {
        var s_pnp=new SoftKey3W();
         s_pnp.Socket_UK.onopen = function() 
        {
               bConnect=1;//�����Ѿ����ӣ������ж��Ƿ�װ�˿ͻ��˷���
        } 
        
        //��ʹ���¼��岦ʱ��ע�⣬һ����Ҫ�ص�Sockey�������޷�����¼��岦
        s_pnp.Socket_UK.onmessage =function got_packet(Msg) 
        {
            var PnpData = JSON.parse(Msg.data);
            if(PnpData.type=="PnpEvent")//����ǲ岦�¼�������Ϣ
            {
                if(PnpData.IsIn) 
                {
                        alert("UKEY�ѱ����룬�����������·���ǣ�"+PnpData.DevicePath);
                }
                else
                {
                        alert("UKEY�ѱ�������������������·���ǣ�"+PnpData.DevicePath);
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
	 //�����IE10���������������ʹ��AVCTIVEX�ؼ��ķ�ʽ
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10_login();
    
   //�ж��Ƿ�װ�˷���������û�а�װ��ʾ�û���װ
    if(bConnect==0)
    {
        window.alert ( "δ�����ӷ��������ȷ����������Ƿ�װ��");return false;
    }
    
   	var DevicePath,ret,n,mylen,ID_1,ID_2,addr;
	try
	{
			
		 //������ʹ���¼���Ϣ�ķ�ʽ�����������ͨѶ��
		    //�ô��ǲ��ð�װ���������ϵͳ���汾���ؼ�Ҳ���ᱻ���أ�ͬʱ��װ�������󣬿�������ʹ�ã��������������
		    //���õĵط������ǵ�д����Ḵ��һЩ
			var s_simnew1=new SoftKey3W(); //����UK��
			
		    s_simnew1.Socket_UK.onopen = function() {
		   	   s_simnew1.ResetOrder();//�������ResetOrder���������㣬��������Ϣ�����ͻ��յ�0��ŵ���Ϣ��ͨ����������ŵķ�ʽ���Ӷ���������
		    } 

           
		 //д����ʱһ��Ҫע�⣬ÿ�������ǵ�һ��UKEY�������ͻ�����һ��������������һ����ţ��Ϻõ��߼���һ����ŵ���Ϣ�����У�ֻ��������һ��UKEY�ĺ���
	    s_simnew1.Socket_UK.onmessage =function got_packet(Msg) 
	    {
	        var UK_Data = JSON.parse(Msg.data);
	        //alert(Msg.data);
	        if(UK_Data.type!="Process")return ;//����������̴�����Ϣ��������
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//��������ȡUK��·��
	                }
	                break;//!!!!!��Ҫ��ʾ������ڵ����У����ִ��벻�ԣ�һ��Ҫע�⣬�ǲ�������break,��������Ǻܳ����Ĵ���
	            case 1:
	                {
	                    if( UK_Data.LastError!=0){window.alert ( "δ���ּ�����������������");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//��÷��ص�UK��·��
	                    s_simnew1.GetID_1(DevicePath); //��������ȡID_1
	                }
	                break;
	            case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����ID�Ŵ��󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    ID_1=UK_Data.return_value;//��÷��ص�UK��ID_1
	                    s_simnew1.GetID_2(DevicePath); //��������ȡID_2
	                }
	                break;
	             case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("ȡ��ID���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                     ID_2=UK_Data.return_value;//��÷��ص�UK��ID_2
	                     
	                     frmlogin.KeyID.value=toHex(ID_1)+toHex(ID_2);
	                     
	                     s_simnew1.ContinueOrder();//Ϊ�˷����Ķ������������һ�������һ�еļ���������Ϊ�������Ϣ��û�е������ǵĺ���������Ҫ�������
	                }
	                break;
	             case 4:
	                {
	                    //��ȡ���������е��û���
			            //�ȴӵ�ַ0��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			            addr=0;
			            s_simnew1.YReadEx(addr,1,"ffffffff","ffffffff",DevicePath);//��������ȡUK��ַ0������
	                }
	                break;
	            case 5:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("������ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//������������ݻ�����������
	                }
	                break;
	            case 6:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����GetBufʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//��÷��ص����ݻ�����������
	                    
	                    //�ٴӵ�ַ1��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
	                    addr=1;
	                    s_simnew1.YReadString(addr,mylen, "ffffffff", "ffffffff", DevicePath);//���������UK��ַ1��ȡ�ַ���
	                }
	                break;
	            case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("��ȡ�û���ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.UserName.value=UK_Data.return_value;//��÷��ص�UK��ַ1���ַ���
	                    
	                    //�����������е��û�����,
			            //�ȴӵ�ַ20��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			            addr=20;
			            s_simnew1.YReadEx(addr,1,"ffffffff","ffffffff",DevicePath);//��������ȡUK��ַ20������
	                }
	                break;
	            case 8:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("������ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//������������ݻ�����������
	                }
	                break;
	            case 9:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����GetBufʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//��÷��ص����ݻ�����������
	                    
	                    //�ٴӵ�ַ21��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
	                    addr=21;
	                    s_simnew1.YReadString(addr,mylen,"ffffffff", "ffffffff", DevicePath);//���������UK��ַ21��ȡ�ַ���
	                }
	                break;
	             case 10:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("��ȡ�û�����ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.Password.value=UK_Data.return_value;//��÷��ص�UK�е�ַ21���ַ���
	                    
	                    frmlogin.submit();	
	                    
	                   //���й���������ɺ󣬹ص�Socket
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
	    //�����IE10���������������ʹ��AVCTIVEX�ؼ��ķ�ʽ
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10_1();
    
	//�ж��Ƿ�װ�˷���������û�а�װ��ʾ�û���װ
    if(bConnect==0)
    {
        window.alert ( "δ�����ӷ��������ȷ����������Ƿ�װ��");return false;
    }
    
    if(frmlogin.UserName.value=="" || frmlogin.Password.value=="")
    {
	    window.alert ( "�������û��������Ž��в�����");return 0;
    }
    
   	var DevicePath,ret,n,mylen,addr;
	try
	{
			
		 //������ʹ���¼���Ϣ�ķ�ʽ�����������ͨѶ��
		    //�ô��ǲ��ð�װ���������ϵͳ���汾���ؼ�Ҳ���ᱻ���أ�ͬʱ��װ�������󣬿�������ʹ�ã��������������
		    //���õĵط������ǵ�д����Ḵ��һЩ
			var s_simnew1=new SoftKey3W(); //����UK��
			
		    s_simnew1.Socket_UK.onopen = function() {
		   	   s_simnew1.ResetOrder();//�������ResetOrder���������㣬��������Ϣ�����ͻ��յ�0��ŵ���Ϣ��ͨ����������ŵķ�ʽ���Ӷ���������
		    } 

           
		 //д����ʱһ��Ҫע�⣬ÿ�������ǵ�һ��UKEY�������ͻ�����һ��������������һ����ţ��Ϻõ��߼���һ����ŵ���Ϣ�����У�ֻ��������һ��UKEY�ĺ���
	    s_simnew1.Socket_UK.onmessage =function got_packet(Msg) 
	    {
	        var UK_Data = JSON.parse(Msg.data);
	       // alert(Msg.data);
	        if(UK_Data.type!="Process")return ;//����������̴�����Ϣ��������
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//��������ȡUK��·��
	                }
	                break;//!!!!!��Ҫ��ʾ������ڵ����У����ִ��벻�ԣ�һ��Ҫע�⣬�ǲ�������break,��������Ǻܳ����Ĵ���
                case 1:
                    {
                        if( UK_Data.LastError!=0){window.alert ( "δ���ּ�����������������");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//��÷��ص�UK��·��
	                    
	                    //д�û���
	                    //д���û�������ַ1��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
	                    addr=1;
	                    s_simnew1.YWriteString(frmlogin.UserName.value, addr, "ffffffff", "ffffffff", DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("д���û���ʧ�ܡ�������Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen = UK_Data.return_value;
	                    
	                    s_simnew1.SetBuf( mylen, 0);//����Ҫ�ַ����ĳ��ȵ��������У�
	                }
	                break;
	                
                case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����SetBufʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                    //д�뻺���������ݼ��û������ַ������ȵ���ַ0��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
	                    addr=0;
	                    s_simnew1.YWriteEx(addr, 1, "ffffffff", "ffffffff",DevicePath);
	                }
	                break;
                case 4:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("д���û�������ʧ�ܡ�������Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    //д�û�����
	                    //д���û����뵽��ַ21��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
	                    addr=21;
	                    s_simnew1.YWriteString(frmlogin.Password.value, addr, "ffffffff", "ffffffff", DevicePath);
	                }
	                break;
                case 5:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("д���û�����ʧ�ܡ�������Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen = UK_Data.return_value;
	                    
	                    s_simnew1.SetBuf( mylen, 0);//����Ҫ�ַ����ĳ��ȵ��������У�
	                }
	                break;
                case 6:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����SetBufʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    //д���û���������ַ������ȵ���ַ20��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
	                    addr=20;
	                    s_simnew1.YWriteEx(addr, 1, "ffffffff", "ffffffff",DevicePath);
	                }
	                break;	
	            case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("д���û����볤��ʧ�ܣ�������Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "д��ɹ�");
	                     //���й���������ɺ󣬹ص�Socket
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
    //�����IE10���������������ʹ��AVCTIVEX�ؼ��ķ�ʽ
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) 
    {
		var s_simnew1;
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3")//�����ؼ�
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "δ���ּ�����������������");return false;
		}
		else
		{
			ret=s_simnew1.SetWritePassword(frmlogin.w_hkey.value,frmlogin.w_lkey.value,frmlogin.new_w_hkey.value,frmlogin.new_w_lkey.value, DevicePath);
			if( ret != 0 )
			{ 
				window.alert ( "����д�������");return false;
			}
			window.alert ( "����д����ɹ�");
		}
		return true;
    }
    
	 //�ж��Ƿ�װ�˷���������û�а�װ��ʾ�û���װ
    if(bConnect==0)
    {
        window.alert ( "δ�����ӷ��������ȷ����������Ƿ�װ��");return false;
    }
    
   	
	try
	{
			
		 //������ʹ���¼���Ϣ�ķ�ʽ�����������ͨѶ��
		    //�ô��ǲ��ð�װ���������ϵͳ���汾���ؼ�Ҳ���ᱻ���أ�ͬʱ��װ�������󣬿�������ʹ�ã��������������
		    //���õĵط������ǵ�д����Ḵ��һЩ
			var s_simnew1=new SoftKey3W(); //����UK��
			
		    s_simnew1.Socket_UK.onopen = function() {
		   	   s_simnew1.ResetOrder();//�������ResetOrder���������㣬��������Ϣ�����ͻ��յ�0��ŵ���Ϣ��ͨ����������ŵķ�ʽ���Ӷ���������
		    } 

           
		 //д����ʱһ��Ҫע�⣬ÿ�������ǵ�һ��UKEY�������ͻ�����һ��������������һ����ţ��Ϻõ��߼���һ����ŵ���Ϣ�����У�ֻ��������һ��UKEY�ĺ���
	    s_simnew1.Socket_UK.onmessage =function got_packet(Msg) 
	    {
	        var UK_Data = JSON.parse(Msg.data);
	        //alert(Msg.data);
	        if(UK_Data.type!="Process")return ;//����������̴�����Ϣ��������
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//��������ȡUK��·��
	                }
	                break;//!!!!!��Ҫ��ʾ������ڵ����У����ִ��벻�ԣ�һ��Ҫע�⣬�ǲ�������break,��������Ǻܳ����Ĵ���
                case 1:
                    {
                        if( UK_Data.LastError!=0){window.alert ( "δ���ּ�����������������");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//��÷��ص�UK��·��
	                    
	                    //����д����
	                    s_simnew1.SetWritePassword(frmlogin.w_hkey.value,frmlogin.w_lkey.value,frmlogin.new_w_hkey.value,frmlogin.new_w_lkey.value, DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����д������󡣴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "����д����ɹ�");
	                     
	                     //���й���������ɺ󣬹ص�Socket
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
	

	//�����IE10���������������ʹ��AVCTIVEX�ؼ��ķ�ʽ
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1)
    {	
		var s_simnew1;
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");//�����ؼ�
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "δ���ּ�����������������");return false;
		}
		else
		{
			ret=s_simnew1.SetReadPassword(frmlogin.w_hkey_2.value,frmlogin.w_lkey_2.value,frmlogin.r_hkey.value,frmlogin.r_lkey.value, DevicePath);
			if( ret != 0 )
			{ 
				window.alert ( "���ö��������");return false;
			}
			window.alert ( "���ö�����ɹ�");
		}
		return true;
	}
    
	 //�ж��Ƿ�װ�˷���������û�а�װ��ʾ�û���װ
    if(bConnect==0)
    {
        window.alert ( "δ�����ӷ��������ȷ����������Ƿ�װ��");return false;
    }
    
	try
	{
			
		 //������ʹ���¼���Ϣ�ķ�ʽ�����������ͨѶ��
		    //�ô��ǲ��ð�װ���������ϵͳ���汾���ؼ�Ҳ���ᱻ���أ�ͬʱ��װ�������󣬿�������ʹ�ã��������������
		    //���õĵط������ǵ�д����Ḵ��һЩ
			var s_simnew1=new SoftKey3W(); //����UK��
			
		    s_simnew1.Socket_UK.onopen = function() {
		   	   s_simnew1.ResetOrder();//�������ResetOrder���������㣬��������Ϣ�����ͻ��յ�0��ŵ���Ϣ��ͨ����������ŵķ�ʽ���Ӷ���������
		    } 

           
		 //д����ʱһ��Ҫע�⣬ÿ�������ǵ�һ��UKEY�������ͻ�����һ��������������һ����ţ��Ϻõ��߼���һ����ŵ���Ϣ�����У�ֻ��������һ��UKEY�ĺ���
	    s_simnew1.Socket_UK.onmessage =function got_packet(Msg) 
	    {
	        var UK_Data = JSON.parse(Msg.data);
	        //alert(Msg.data);
	        if(UK_Data.type!="Process")return ;//����������̴�����Ϣ��������
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//��������ȡUK��·��
	                }
	                break;//!!!!!��Ҫ��ʾ������ڵ����У����ִ��벻�ԣ�һ��Ҫע�⣬�ǲ�������break,��������Ǻܳ����Ĵ���
                case 1:
                    {
                        if( UK_Data.LastError!=0){window.alert ( "δ���ּ�����������������");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//��÷��ص�UK��·��
	                    
	                    //���ö����룬ע�⣬�����µĶ����룬����ԭ��д�����룬��������ԭ����������
	                    s_simnew1.SetReadPassword(frmlogin.w_hkey_2.value,frmlogin.w_lkey_2.value,frmlogin.r_hkey.value,frmlogin.r_lkey.value, DevicePath);
                    }
                    break;
                case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("���ö�������󡣴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    
	                     window.alert ( "���ö�����ɹ�");
	                     
	                     //���й���������ɺ󣬹ص�Socket
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
			//�����������ǵ����Ŀؼ��������ڲ������ǵ���
            var s_simnew1;
		    //�����ؼ�

			s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");

            
            //�����Ƿ������,����ʹ����FindPort����
			DevicePath = s_simnew1.FindPort(0);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert ( "δ���ּ�������������������");
				
				return false;
			}
			
			 //'��ȡ����ID
            frmlogin.KeyID.value=toHex(s_simnew1.GetID_1(DevicePath))+toHex(s_simnew1.GetID_2(DevicePath));
            if( s_simnew1.LastError!= 0 )
			{
	            window.alert( "��ȡIDʱ����,��������:"+s_simnew1.LastError.toString());
		        return false;
			}
			
			//��ȡ���������е��û���
			//�ȴӵ�ַ0��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			ret=s_simnew1.YReadEx(0,1,"ffffffff","ffffffff",DevicePath);
			mylen =s_simnew1.GetBuf(0);
			//�ٴӵ�ַ1��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			frmlogin.UserName.value=s_simnew1.YReadString(1,mylen, "ffffffff", "ffffffff", DevicePath);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert(  "��ȡ�û�������,��������:"+s_simnew1.LastError.toString());
				return false;
			}

			//�����������е��û�����,
			//�ȴӵ�ַ20��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			ret=s_simnew1.YReadEx(20,1,"ffffffff","ffffffff",DevicePath);
			mylen =s_simnew1.GetBuf(0);
			//�ٴӵ�ַ21��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			frmlogin.Password.value=s_simnew1.YReadString(21,mylen,"ffffffff", "ffffffff", DevicePath);
			if( s_simnew1.LastError!= 0 )
			{
				window.alert( "��ȡ�û��������,��������:"+s_simnew1.LastError.toString());
				return false;
			}
			 
			 frmlogin.submit ();
			 return true;

		}
	catch (e) 
	{
		alert(e.name + ": " + e.message+"��������û�а�װ��Ӧ�Ŀؼ�����");
	}
}

function Handle_IE10_1() 
{
	try
	 {
		var DevicePath,mylen,ret;
		//�����������ǵ����Ŀؼ��������ڲ������ǵ���
        var s_simnew1;
	    //�����ؼ�
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");
	    
	    //�����Ƿ������,����ʹ����FindPort����
		DevicePath = s_simnew1.FindPort(0);
		if( s_simnew1.LastError!= 0 )
		{
		    window.alert ( "δ���ּ�����������������");return false;
		}
		else
		{
		    if(frmlogin.UserName.value=="" || frmlogin.Password.value=="")
		    {
			    window.alert ( "�������û��������Ž��в�����");return false;
		    }
		    //д���û�������ַ1��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
		    mylen = s_simnew1.YWriteString(frmlogin.UserName.value, 1, "ffffffff", "ffffffff", DevicePath);
		    if( s_simnew1.LastError!= 0 )
		    { 
			    window.alert ( "д���û���ʧ�ܡ��������ǣ�"+s_simnew1.LastError.toString());return false;
		    }
		    s_simnew1.SetBuf( mylen, 0);
		    //д���û������ַ������ȵ���ַ0��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
		    ret = s_simnew1.YWriteEx(0, 1, "ffffffff", "ffffffff",DevicePath);
		    if( ret != 0 )
		    { 
			    window.alert ( "д���û�������ʧ�ܡ��������ǣ�"+s_simnew1.LastError.toString());return false;
		    }
		    
		    //д���û����뵽��ַ21��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
		    mylen = s_simnew1.YWriteString(frmlogin.Password.value, 21, "ffffffff", "ffffffff", DevicePath);
		    if( s_simnew1.LastError!= 0 )
		    { 
			    window.alert ( "д���û�����ʧ�ܡ��������ǣ�"+s_simnew1.LastError.toString());return false;
		    }
		    s_simnew1.SetBuf( mylen, 0);
		    //д���û���������ַ������ȵ���ַ20��ʹ��Ĭ�ϵ�д����"FFFFFFFF","FFFFFFFF"
		    ret = s_simnew1.YWriteEx(20, 1, "ffffffff", "ffffffff",DevicePath);
		    if( ret != 0 )
		    { 
			    window.alert ( "д���û����볤��ʧ�ܡ��������ǣ�"+s_simnew1.LastError.toString());return false;
		    }
		    window.alert ( "д��ɹ�");
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

    <b>�û���¼<b>

  </tr>
  <tr>
    <td colspan="2"><input name="chkonly" type="checkbox" id="chkonly" checked>
      ������������Ȼ��������¼��</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <!--/��Ҫ�����������һ��������Submit�������޷���ȫ�������е���Ϣ�����ύ��ȥ�ˣ�һ��Ҫ�����ύ-->
    <td><input type="button" name="Submit" value="�ύ" onclick="login_onclick()">
    &nbsp;<input name="reset" type="reset" id="reset" value="����"></td>
        <td>&nbsp;
  </tr>
</table>

<p>
  �������û�����<input name="UserName" type="text" id="UserName" >
</p>
<p> 
�������û����룺<input name="Password" type="password" id="Password" >
</p>
<input name="KeyID" type="text" id="KeyID" style="VISIBILITY: hidden">
<p> 
  <input type="button" name="button1" value="д���û���������" onClick="button1_onclick()">
</p>
<p>&nbsp;</p>
<p>����д���룺</p>
<p>ԭд���룺
  <input name="w_hkey" type="text" id="w_hkey" value="ffffffff" >
  --
  <input name="w_lkey" type="text" id="w_lkey" value="ffffffff" >
</p>
<p>��д���룺
  <input name="new_w_hkey" type="text" id="new_w_hkey" value="ffffffff" >
  --
  <input name="new_w_lkey" type="text" id="new_w_lkey" value="ffffffff" >
</p>
<p>
  <input type="button" name="button2" value="����" onClick="button2_onclick()">
</p>
<p>&nbsp;</p>
<p>���ö����룺</p>
<p>д���룺
  <input name="w_hkey_2" type="text" id="w_hkey_2" value="ffffffff" >
  --
  <input name="w_lkey_2" type="text" id="w_lkey_2" value="ffffffff" >
</p>
<p>�µĶ����룺
  <input name="r_hkey" type="text" id="r_hkey" value="ffffffff" >
  --
  <input name="r_lkey" type="text" id="r_lkey" value="ffffffff" >
</p>
<p>
  <input type="button" name="button3" value="����" onClick="button3_onclick()">
</p>
<p>ע�����ö��������á�д����������</p>
<p>&nbsp;</p>
</form>
</body>
</html>
<%
}
%>

