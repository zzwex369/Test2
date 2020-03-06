package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D401Response")]
	public class D401Response extends MessageResponse
	{
		public var vd401s:ArrayCollection;
		public var rowCount:Number;
		public function D401Response()
		{
		}
	}
}