package com.xyw.module.etbj.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E305Request")]
	public class E305Request
	{
		public var e305:E305;
		public var timeStart:Date;//起始时间
		public var timeEnd:Date;//结束时间
		public var parameterPageindex:Number;
		public var parameterPagesize:Number;
		public var flag:String;
		public var f301_02:String;
		public var f301_05:String;
		public function E305Request()
		{
		}
	}
}