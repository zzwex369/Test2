package com.xyw.sys.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.ServiceDateResponse")]
	public class ServiceDateResponse extends MessageResponse{
		public var dateType:String;//需要返回的日期类型  字符串  date 两种   1 date 2 字符串
		public var date:Object;
		public var state:Object;
	}	
}
