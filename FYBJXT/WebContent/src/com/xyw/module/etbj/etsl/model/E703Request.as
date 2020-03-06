package com.xyw.module.etbj.etsl.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E703Request")]
	public class E703Request
	{
		public var jigou:String;
		public var zhujian:String;
		public var e70208:String;
		public var e703:E703;
		public var e70318_str:Date;
		public var e70318_end:Date;
		public var parent_name:String;
		public var parent_idcard:String;
		public var parent_phone:String;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public function E703Request()
		{
		}
	}
}