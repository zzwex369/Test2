package com.xyw.module.swjc.model
{

	import com.xyw.module.swjc.model.Sw301;
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.swjc.model.Sw301Response")]
	public class Sw301Response extends MessageResponse
	{
		public var sw30101:Number;
		public var sw301:Sw301;
		public var vSw301:VSw301;
		public var rowCount:Number;
		public var vSw301s:ArrayCollection;
		
		public var state:Boolean;
		
		public function Sw301Response()
		{
		}
	}
}