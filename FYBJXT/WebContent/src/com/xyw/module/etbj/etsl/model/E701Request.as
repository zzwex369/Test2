package com.xyw.module.etbj.etsl.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E701Request")]
	public class E701Request
	{
		public var jigou:String;
		public var zhujian:String;
		public var e701:E701;
		public var e70133_str:Date;
		public var e70133_end:Date;
		public var parent_name:String;
		public var parent_idcard:String;
		public var parent_phone:String;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		
		public function E701Request()
		{
		}
	}
}