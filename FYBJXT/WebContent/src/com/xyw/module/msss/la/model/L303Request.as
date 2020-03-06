package com.xyw.module.msss.la.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L303Request")]
	public class L303Request
	{
		public function L303Request()
		{
		}
		public var l30301:String;
		public var l30302:String;
		public var l303:L303;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
	}
}