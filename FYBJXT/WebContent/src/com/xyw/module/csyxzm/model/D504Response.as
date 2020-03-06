package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D504Response")]
	public class D504Response extends MessageResponse
	{
		public function D504Response()
		{
		}
		public var d504s:ArrayCollection;
		public var rowCount:Number
	}
}