package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.SysView02Response")]
	public class SysView02Response extends MessageResponse
	{
		public var sysView02List:ArrayCollection;
		public var rowCount:Number;
		public function SysView02Response()
		{
			super();
		}
	}
}