package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.StockResponse")]
	public class StockResponse extends MessageResponse
	{
		public var listStock:ArrayCollection;
		public var listVd505:ArrayCollection;
		public var rowCount:Number;
		public function StockResponse()
		{
			super();
		}
	}
}