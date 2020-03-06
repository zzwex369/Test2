package com.xyw.module.etbj.etsl.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E702Response")]
	public class E702Response extends MessageResponse
	{
		public var e70201:String;
		public var e702:Object;
		public var rowCount:Number;
		public var ve702s:ArrayCollection;
		public var state:Boolean;
		public function E702Response()
		{
		}
	}
}