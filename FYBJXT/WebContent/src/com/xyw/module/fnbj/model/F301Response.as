package com.xyw.module.fndj.model
{
	import com.xyw.module.fnbj.model.F301;
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F301Response")]
	public class F301Response extends MessageResponse
	{
		public var f30101:Number;
		public var f301:F301;
		public var rowCount:Number;
		public var vf301s:ArrayCollection;
		
		public var state:Boolean;
		
		public function F301Response()
		{
		}
	}
}