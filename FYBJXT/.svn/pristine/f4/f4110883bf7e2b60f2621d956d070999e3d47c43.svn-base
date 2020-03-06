package com.xyw.ws.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyw.ws.model.Fp;
import com.xyw.ws.model.FpResponse;
import com.xyw.ws.service.CsyxzmService;
import com.xyw.ws.webservice.CsyxzmWebService;

@WebService(targetNamespace = "http://www.xywdzkj.com/csyxzm/",
			portName = "CsyxzmWebServicePort",
			serviceName = "CsyxzmWebServiceImpl",
			wsdlLocation = "WEB-INF/wsdl/csyxzmWebService.wsdl",
			name = "CsyxzmWebService",
			endpointInterface = "com.xyw.ws.webservice.CsyxzmWebService")
public class CsyxzmWebServiceImpl implements CsyxzmWebService {
	
	private static  ClassPathXmlApplicationContext classPathXMLApplicationContext = null;
	
	private static CsyxzmService csyxzmService = null;
	
	static {
//		classPathXMLApplicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//		csyxzmService = (CsyxzmService)classPathXMLApplicationContext.getBean("csyxzmService");
	}
	
	 /**
     * 
     * @param fp
     * @return
     *     returns com.xywdzkj.csyxzm.FpResponse
     */
    @WebMethod(action = "http://www.xywdzkj.com/csyxzm/#csyxzmFp")
    @WebResult(name = "fpResponse", targetNamespace = "http://www.xywdzkj.com/csyxzm/", partName = "fpResponse")
    public FpResponse csyxzmFp(
        @WebParam(name = "fp", targetNamespace = "http://www.xywdzkj.com/csyxzm/", partName = "fp")
        Fp fp){
    	return csyxzmService.csyxzmFp(fp);
    }

}
