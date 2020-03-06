package com.xyw.module.msss.la.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L304Request")]
	public class L304Request
	{
		public function L304Request()
		{
		}
		public var l30401:String;
		public var l30402:String;
		public var l304:L304;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
	}
}