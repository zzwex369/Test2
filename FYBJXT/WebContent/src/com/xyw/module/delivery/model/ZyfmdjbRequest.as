package com.xyw.module.delivery.model
{
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.ZyfmdjbRequest")]
	public class ZyfmdjbRequest
	{
		public var pageIndex:int;
		public var pageSize:int;
		
		public var sexFlag:String;
		public var areaFlag:String;
		public var timeFlag:String;
		
		public var areaCode:String;
		
		public var date_start:String;
		public var date_end:String;
		public var  jiwei:String;
		
		public function ZyfmdjbRequest()
		{
		}
	}
}