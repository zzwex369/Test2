package com.xyw.module.delivery.model
{
	import mx.collections.ArrayCollection;
	import com.xyw.sys.model.MessageResponse;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.ycfsw.model.D604Response")]
	public class D604Response extends MessageResponse
	{
		public var rowCount:Number;
		public var vD604s:ArrayCollection;
		public var d604:D604;
		public function D604Response()
		{
		}
	}
}