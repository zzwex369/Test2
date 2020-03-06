package com.xyw.ws.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{

	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Date unmarshal(String v) throws Exception {
		if(v == null) {
			return null;
		}
		return df.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		if(v == null) {
			return null;
		}
		return df.format(v);
	}
}
