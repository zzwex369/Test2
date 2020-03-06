package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D501Response")]
	public class D501Response extends MessageResponse
	{
		public var vd501s:ArrayCollection;
		public var rowCount:Number;
		public var vD501:VD501;
		public function D501Response()
		{
		}
	}
}