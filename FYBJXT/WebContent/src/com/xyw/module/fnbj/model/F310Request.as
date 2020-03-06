package com.xyw.module.fnbj.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F310Request")]
	public class F310Request
	{
		public var f310:F310;
		public var timeStr:String;
		public var timeEnd:String;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public function F310Request()
		{
		}
	}
}