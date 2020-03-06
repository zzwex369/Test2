package com.xyw.module.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E303Response")]
	public class E303Response extends MessageResponse
	{
		public var e30301:Number;
		public var ve303:VE303;
		public var ve303s:ArrayCollection;
		public var rowCount:Number; 
		public var state:Boolean;
		
		public function E301Response()
		{
		}
	}
}