package com.xyw.module.msss.fnbj.model
{
	import com.xyw.module.msss.fnbj.model.F501;
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F504Response")]
	public class F504Response extends MessageResponse
	{
		public var f504:F504;
		public var vf504s:ArrayCollection;
		public var state:Boolean;
		public var rowCount:Number;
	
		
		public function F504Response()
		{
		}
	}
}