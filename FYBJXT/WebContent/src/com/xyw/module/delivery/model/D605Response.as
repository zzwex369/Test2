package com.xyw.module.delivery.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D605Response")]
	public class D605Response extends MessageResponse
	{
		public var vd605s:ArrayCollection;
		public var rowCount:Number;
		public function D605Response()
		{
		}
	}
}