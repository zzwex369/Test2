package com.xyw.module.etbj.etsl.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E701Response")]
	public class E701Response extends MessageResponse
	{
		public var falg:Boolean;
		public var ve701:VE701;
		public var ve701s:ArrayCollection;
		public var rowCount:Number; 
		public var state:Number;
		public function E701Response()
		{
		}
	}
}