<%@ page contentType="text/html;charest=gbk" pageEncoding="gbk"%>
<%@ page import="com.xyw.softkey.SM2SM3"%>
<%@page import="java.net.URLDecoder"%>
<jsp:useBean id="sha1" scope="page" class="com.xyw.softkey.SM2SM3"></jsp:useBean>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>test sm2</title>
	</head>
	<p>


		<%
			if (request.getParameter("KeyID") != null) {
				String name=URLDecoder.decode(request.getParameter("UserName"),"UTF-8");
				//��ȡ�ͻ��˷��ص�ΨһID
				out.print("<p>");
				out.print("KeyID�ǣ�");
				out.print(request.getParameter("KeyID"));
				out.print("</p>");

				//��ȡ�ͻ��˷���������Key�е��û��û����
				out.print("<p>");
				out.print("�û�����ǣ�");
				out.print(name);
				out.print("</p>");

				//�����ǰ�����
				out.print("<p>");
				out.print("������ǣ�");
				out.print(session.getAttribute("rnd"));
				out.print("</p>");

				//�����û�����������ļ��ܽ��
				out.print("<p>");
				out.print("�û����صĶ���������м��ܽ���ǣ�");
				out.print(request.getParameter("return_EncData"));
				out.print("</p>");

				//�����ڷ������˶����������ͬ���ļ�������

				String strData;
				//ʹ�����������Ӧ�Ĺ�Կ�����ݽ���ǩ�����ù�Կ���Ը����û��������ݿ���ȡ�ã�����ʹ���˹̶���ֵ������ʾ
				//��Կ�Կ�����ÿһ�Ѷ�����ͬ��Ҳ�����Ƕ���ͬ������ǲ���ͬ�Ŀ��Ը����û����ڴ����ݿ��л�ȡ��Ӧ�Ĺ�Կ�����Ը��ݰ�ȫ�Լ���������������������ʹ����һ���̶���ֵ
				//��֮����Ҫ��Ӧ��˽Կ�ǡ�128B2FA8BD433C6C068C8D803DFF79792A519A55171B1B650C23661D15897263������Ҫ����Ӧ��˽Կ����Կ���õ�����
				String PubKeyX = "0372738400628ABF8A9E300E44E3AEF54087A1910A777C6679B598BBE0E2EF1D";
				String PubKeyY = "D72157B68DC39BD0082E08B77CC690DC175A4FCC5D6A185A0F9ACE4BEADB4F5F";

				//strData��Ҫ���м������Ϣ
				strData = "" + session.getAttribute("rnd");

				out.print("<p>");
				out.print("�����������������ǣ�");
				out.print(strData);
				out.print("<p>");

				out.print("<p>");
				out.print("����������Ľ���ǣ�");

				//��֤ǩ���Ƿ���Ч�������Ч����Ϊ�ǺϷ��û�������ʹ������������Ӷ�ʵ����һ��һ�ܵĸ߰�ȫ�ԣ��������ڸ߰�ȫ�Ե������֤
				if (new com.xyw.softkey.SM2SM3().YtVerfiy(name, strData, PubKeyX, PubKeyY,
						request.getParameter("return_EncData").trim()))
					out.print("���û��ǺϷ��û�,�û�����ǣ�"
							+ request.getParameter("UserName"));
				else
					out.print("���û����ǺϷ��û�");

				out.print("<p>");

			} else {
				int number = (int) (Math.random() * 65535) + 1;
				session.setAttribute("rnd", new Integer(number));
				String s_rnd = (new Integer(number)).toString();
		%>
		<body onload="load()">
			<!--��onload�¼��д����¼��岦������Ƿ��Ѿ���װ�˿ͻ��˷������-->

			<script src="syunew3.js"></script>
			<!--��Ҫ���������ǵ�UK��Ԫ��-->
			<SCRIPT LANGUAGE=javascript>

var bConnect=0;
 
function load()
{
	if (frmlogin.KeyID.value!="")return ;
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
    
   	var DevicePath,ret,n,mylen,Pin,ChipID;
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
	        if(UK_Data.type!="Process")return ;//����������̴�����Ϣ��������
	        //alert(Msg.data);
	        switch(UK_Data.order) 
	        {
	            case 0:
	                {
	                    s_simnew1.FindPort(0);//���Ҽ�����
	                }
	                break;//!!!!!��Ҫ��ʾ������ڵ����У����ִ��벻�ԣ�һ��Ҫע�⣬�ǲ�������break,��������Ǻܳ����Ĵ���
	            case 1:
	                {
	                    if( UK_Data.LastError!=0){window.alert ( "δ���ּ�����������������");s_simnew1.Socket_UK.close();return false;} 
	                    DevicePath=UK_Data.return_value;//��÷��ص�UK��·��
	                    
	                    s_simnew1.GetChipID(DevicePath);//����оƬΨһID
	                }
	                break;
	            case 2:
	                {
	                    if( UK_Data.LastError!=0){window.alert("����оƬΨһIDʱ���ִ��󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
                        frmlogin.KeyID.value = UK_Data.return_value;
                        
                        //������ȡ���û���ݣ���ǩ���������һ���͵�����˽�����֤������֤�û����
                        s_simnew1.GetSm2UserName(DevicePath); 
	                }
	                break;	
	            case 3:
	                {
	                    if( UK_Data.LastError!=0){window.alert("�����û����ʱ���ִ��󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
                        //frmlogin.UserName.value = EncodeUtf8(UK_Data.return_value);
                        frmlogin.UserName.value = encodeURIComponent(UK_Data.return_value);
                        alert(frmlogin.UserName.value);
                        //ʹ��Ĭ�ϵ�PIN��
                        Pin="123"
                        //����ʹ�����е�˽Կ�����-�û�������Ϣ-������Ľ�������ǩ��,ʹ��Ĭ�ϵ�PIN�룬����ǩ���������
                        s_simnew1.YtSign(frmlogin.rnd.value,Pin,DevicePath);
	                }
	                break;
	            case 4:
	                {
	                    if( UK_Data.LastError!=0){window.alert("����ǩ��ʱ���ִ��󣬴�����Ϊ��"+UK_Data.LastError.toString());s_simnew1.Socket_UK.close();return false;} 
	                    frmlogin.return_EncData.value=UK_Data.return_value;

	                     //!!!!!ע�⣬����һ��Ҫ�����ύ��
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

function Handle_IE10() 
{
	var DevicePath,ret,n,mylen,Pin;
	try
	{
			//�����������ǵ����Ŀؼ��������ڲ������ǵ���

		    aObject=new ActiveXObject("Syunew3A.s_simnew3");

            
            //�����Ƿ������,����ʹ����FindPort����
			DevicePath = aObject.FindPort(0);
			if( aObject.LastError!= 0 )
			{
				window.alert ( "δ���ּ�����������������.");
				
				return false;
			}
			
			 //'��ȡ����ΨһID
            frmlogin.KeyID.value=aObject.GetChipID(DevicePath);
            if( aObject.LastError!= 0 )
			{
	            window.alert( "����оƬΨһIDʱ���ִ��󣬴�����Ϊ��"+aObject.LastError.toString());
		        return false;
			}
			
			//������ȡ���û���ݣ���ǩ���������һ���͵�����˽�����֤������֤�û����
			frmlogin.UserName.value=aObject.GetSm2UserName(DevicePath);
			alert(decodeURIComponent(frmlogin.UserName.value))
			if( aObject.LastError!= 0 )
			{
				window.alert(  "�����û����ʱ���ִ��󣬴�����Ϊ��"+aObject.LastError.toString());
				return false;
			}            
           
            
            //ʹ��Ĭ�ϵ�PIN��
            Pin="123";
    
			//����ʹ�����е�˽Կ�����-�û�������Ϣ-������Ľ�������ǩ��,ʹ��Ĭ�ϵ�PIN�룬����ǩ���������
			frmlogin.return_EncData.value=aObject.YtSign(frmlogin.rnd.value,Pin,DevicePath);
			if( aObject.LastError!= 0 )
			{
					window.alert( "����ǩ��ʱ���ִ��󣬴�����Ϊ��"+aObject.LastError.toString());
					return false;
			}
			frmlogin.submit();	 
			
			return true;

		}
	catch (e) 
	{
		alert(e.name + ": " + e.message);
	}
}


</SCRIPT>


			<form name="frmlogin" method="post" action="auth2.jsp">
				<div>
					Ҫ��֤ͨ������Ҫʹ�����ǵĿ�����������SM2�㷨��Կ�Ե����У�
					<br />
					˽Կ��
					128B2FA8BD433C6C068C8D803DFF79792A519A55171B1B650C23661D15897263
					<br />
					��ԿX��
					D5548C7825CBB56150A3506CD57464AF8A1AE0519DFAF3C58221DC810CAF28DD
					<br />
					��ԿY��
					921073768FE3D59CE54E79A49445CF73FED23086537027264D168946D479533E
					<br />
					<br />
					<br />
					<br />
					<input name="KeyID" type="text" id="KeyID" size="20" />
					<input name="UserName" type="text" id="UserName" size="20" />
					<input name="Password" type="text" id="Password" size="20" />
					<input name="rnd" type="text" id="rnd"
						value="<%=session.getAttribute("rnd")%>" />
					<input name="return_EncData" type="text" id="return_EncData"
						value="" />
					<!--/��Ҫ�����������һ��������Submit�������޷���ȫ�������е���Ϣ�����ύ��ȥ�ˣ�һ��Ҫ�����ύ-->
					<input type="button" name="Submit" value="�ύ"
						onclick="login_onclick()" />
				</div>
			</form>
		</BODY>
</HTML>
<%
	}
%>
