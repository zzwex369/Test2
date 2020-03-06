package com.xyw.sys.model
{
	import com.xyw.sys.model.D807;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.AssistRsponse")]
	public class AssistResponse extends MessageResponse
	{
		public var listD807:ArrayCollection;
		public var rowCount:Number;
		public var d807:D807;
		public function AssistResponse()
		{
			super();
		}
	}
}