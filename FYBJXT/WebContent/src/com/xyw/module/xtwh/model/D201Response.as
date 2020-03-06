package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.xzjgwh.model.D201Response")]
	public class D201Response extends MessageResponse
	{
		public var rowCount:Number;
		public var vd201s:ArrayCollection;
		public var d201:D201;
		public function D201Response()
		{
		}
	}
}