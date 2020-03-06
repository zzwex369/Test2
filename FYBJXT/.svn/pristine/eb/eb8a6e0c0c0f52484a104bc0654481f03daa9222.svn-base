package com.xyw.client.henan.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			String ns = "http://www.xywdzkj.com/csyxzm/";
			Boolean out = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(out) {
				SOAPMessage message = context.getMessage();
				SOAPEnvelope enve = message.getSOAPPart().getEnvelope();
				
				SOAPHeader header = enve.getHeader();
				if(header==null) header = enve.addHeader();
				
				QName qname = new QName(ns, "areaCode","ns");
				header.addHeaderElement(qname).setValue("4113");
				qname = new QName(ns, "password","ns");
				header.addHeaderElement(qname).setValue("E6558CI4-AIC308D7-62C76ABD-8B538A82");
				//message.writeTo(System.out);
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
		
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
