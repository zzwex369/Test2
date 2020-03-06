package com.xyw.module.fnbj.model
{
	import com.xyw.module.fnbj.model.F302;
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F303Response")]
	public class F303Response extends MessageResponse
	{
		public var state:Boolean;
		public var f30301:Number;
		public var f303:F303;
		public var vf303s:ArrayCollection;
		public var rowCount:Number;
		public var errorMessage;
		public function F303Response()
		{
		}
	}
}