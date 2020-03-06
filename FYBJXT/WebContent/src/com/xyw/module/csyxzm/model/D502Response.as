package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D502Response")]
	public class D502Response extends MessageResponse
	{
		public var vd502s:ArrayCollection;
		public var rowCount:Number;
		public function D502Response()
		{
		}
	}
}