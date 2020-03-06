package com.xyw.module.fnbj.model
{
	import com.xyw.module.fnbj.model.F307;
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F307Response")]
	public class F307Response extends MessageResponse
	{	
		public var f307:F307;
		public var vf307s:ArrayCollection;
		
		public var state:Boolean;
		public var rowCount:Number;
		public var errorMessage:String;
		public var promptMessage:String;
		
		public function F307Response()
		{
		}
	}
}