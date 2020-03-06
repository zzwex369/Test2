package com.xyw.module.fnbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F310Response")]
	public class F308Response extends MessageResponse
	{
		public var f310:F310;
		public var rowCount:Number;
		public var vf310s:ArrayCollection;
		
		public var state:Boolean;
		public var errorMessage:String;
		public var promptMessage:String;
		public function F310Response()
		{
		}
	}
}