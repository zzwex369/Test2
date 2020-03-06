package com.xyw.module.msss.fnbj.model
{
	import com.xyw.module.msss.fnbj.model.F502;
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F603Response")]
	public class F603Response extends MessageResponse
	{
		public var f603:F603;
		public var vf603s:ArrayCollection;
		
		public var state:Boolean;
		public var rowCount:Number;
		
		public function F603Response()
		{
		}
	}
}