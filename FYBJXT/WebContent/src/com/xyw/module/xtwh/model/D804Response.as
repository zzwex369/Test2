package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.D804Response")]
	public class D804Response extends MessageResponse
	{
		public var d804s:ArrayCollection;
		public function D804Response()
		{
			super();
		}
	}
}