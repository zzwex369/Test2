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
    if(navigator.userAgent.indexOf("MSIE")>0 && !navigator.userAgent.indexOf("opera") > -1) return Handle_IE10();
    
    //�ж��Ƿ�װ�˷���������û�а�װ��ʾ�û���װ
    if(bConnect==0)
    {
        window.alert ( "δ�����ӷ��������ȷ����������Ƿ�װ��");return false;
    }
    
    
	 try
	 {
		var DevicePath,mylen,ret;
		
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
	                    //��ȡ���������е��û���
			            //�ȴӵ�ַ0��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			            s_simnew1.YReadEx(0,1,"ffffffff","ffffffff",DevicePath);//��������ȡUK��ַ0������
	                    
	                }
	                break;
	            case 2:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("������ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    s_simnew1.GetBuf(0);//������������ݻ�����������
	                }
	                break;
	            case 3:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("����GetBufʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    mylen=UK_Data.return_value;//��÷��ص����ݻ�����������
	                    
	                    //�ٴӵ�ַ1��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
	                    s_simnew1.YReadString(1,mylen, "ffffffff", "ffffffff", DevicePath);//���������UK��ַ1��ȡ�ַ���
	                }
	                break;
	            case 4:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("��ȡ�ַ���ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.UserName.value=UK_Data.return_value;//��÷��ص�UK��ַ1���ַ���
	                    
	                    //�����������е��û�����,
			            //�ȴӵ�ַ20��ȡ�ַ����ĳ���,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
			            s_simnew1.YReadEx(20,1,"ffffffff","ffffffff",DevicePath);//��������ȡUK��ַ20������
	                     
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
	                    
	                    //�ٴӵ�ַ21��ȡ��Ӧ�ĳ��ȵ��ַ�����,ʹ��Ĭ�ϵĶ�����"FFFFFFFF","FFFFFFFF"
	                    s_simnew1.YReadString(21,mylen,"ffffffff", "ffffffff", DevicePath);//���������UK��ַ21��ȡ�ַ���
	                    
	                }
	                break;
	             case 7:
	                {
	                    if( UK_Data.LastError!=0){ window.alert("��ȡ�ַ���ʱ���󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.Password.value=UK_Data.return_value;//��÷��ص�UK��ַ21���ַ���
	                     
	                     
	                     //!!!!!ע�⣬����һ��Ҫ�����ύ���������ύ���͵İ�ť�������޷���ȫ�������е���Ϣ
			             frmlogin.submit ();
	                     
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
				alert(e.name + ": " + e.message+"��������û�а�װ��Ӧ�Ŀؼ�����");
				return false;
	  }  

}

function Handle_IE10() 
{
	 try
	 {
		var DevicePath,mylen,ret;
		var s_simnew1;
		//�����ؼ�
	
		s_simnew1=new ActiveXObject("Syunew3A.s_simnew3");
	
		DevicePath = s_simnew1.FindPort(0);//'�����Ҽ�������0��ָ����Ĭ�϶˿ڵ���
		if( s_simnew1.LastError!= 0 )
		{
			window.alert ( "δ���ּ�����������������");return false;
		}
		else
		{
			 //'��ȡ����ID
            frmlogin.KeyID.value=toHex(s_simnew1.GetID_1(DevicePath))+toHex(s_simnew1.GetID_2(DevicePath));
            if( s_simnew1.LastError!= 0 )
			{
	            window.alert( "��ȡ�û�������,��������"+s_simnew1.LastError.toString());
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
				window.alert(  "Err to GetUserName,ErrCode is:"+s_simnew1.LastError.toString());
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
	  }

	 catch(e)  
	  {  
				alert(e.name + ": " + e.message+"��������û�а�װ��Ӧ�Ŀؼ�����");
				return false;
	  }  

}

</SCRIPT>

<form name="frmlogin" method="post" action="testJSP.jsp">
<table width="354" height="92" border="0">
  <tr>
	<b>�û���¼<b>
  </tr>
   <tr>
    <td colspan="2"><input name="chkonly" type="checkbox" id="chkonly" checked>
      ������������Ȼ��������¼��</td>
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
    <!--/��Ҫ�����������һ��������Submit�������޷���ȫ�������е���Ϣ�����ύ��ȥ�ˣ�һ��Ҫ�����ύ-->
    <td><input type="button" name="Submit" value="�ύ" onclick="login_onclick()">
  </tr>
</table>

</form>
</body>
</html>
<%
}
%>

