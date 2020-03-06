package com.xyw.module.etbj.model
{
	import com.xyw.module.etbj.model.VE301;
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E301Response")]
	public class E301Response extends MessageResponse
	{
		public var e30101:Number;
		public var e30103:String;
		public var ve301:VE301;
		public var ve301s:ArrayCollection;
		public var rowCount:Number; 
		public var state:Boolean;
		
		public function E301Response()
		{
		}
	}
}