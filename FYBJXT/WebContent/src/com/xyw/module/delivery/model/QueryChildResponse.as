package com.xyw.module.delivery.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.QueryChildResponse")]
	public class QueryChildResponse extends MessageResponse
	{
		public var state:Boolean;
		public var d605:D605;
		public var vd605:VD605;
		public var listVD605:ArrayCollection;
		public var rowCount:Number;
		public var flag:String;
		public function QueryChildResponse()
		{
		}
	}
}