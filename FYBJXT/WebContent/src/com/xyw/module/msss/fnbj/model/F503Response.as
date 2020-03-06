package com.xyw.module.msss.fnbj.model
{
	import com.xyw.module.msss.fnbj.model.F502;
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F503Response")]
	public class F503Response extends MessageResponse
	{
		public var f503:F503;
		public var vf503s:ArrayCollection;
		
		public var state:Boolean;
		public var rowCount:Number;
		
		public function F503Response()
		{
		}
	}
}