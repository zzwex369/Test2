package com.xyw.module.msss.la.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L401Request")]
	public class L401Request
	{
		public function L401Request()
		{
		}
		public var l40101:Number;
		public var l401:L401;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
	}
}