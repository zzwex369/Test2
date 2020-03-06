package com.xyw.module.etbj.etsl.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E704Request")]
	public class E704Request
	{
		public var zhujian:String;
		public var e70403:String;
		public var e70404:String;
		public var jigou:String;
		public var e70406_str:Date;
		public var e70406_end:Date;
		public var e70416_str:Date;
		public var e70416_end:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public function E704Request()
		{
		}
	}
}