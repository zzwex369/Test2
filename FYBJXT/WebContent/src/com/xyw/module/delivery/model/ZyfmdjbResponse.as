package com.xyw.module.delivery.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.ZyfmdjbResponse")]
	public class ZyfmdjbResponse extends MessageResponse
	{
		public var vd601s:ArrayCollection;
		public var rowCount:Number;
		public function ZyfmdjbResponse()
		{
		}
	}
}