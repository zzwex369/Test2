package com.xyw.module.msss.la.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L303Response")]
	public class L303Response extends MessageResponse
	{
		public function L303Response()
		{
		}
		public var l30301:String;
		public var l303:L303;
		public var rowCount:Number;
		public var vl303s:ArrayCollection;
		public var state:Boolean;
	}
}