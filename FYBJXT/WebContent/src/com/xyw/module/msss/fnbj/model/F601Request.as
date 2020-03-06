package com.xyw.module.msss.fnbj.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F601Request")]
	public class F601Request
	{
		public var f601:F601;
		
		
		public var flag:String;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var f60101List:ArrayCollection;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		
		public function F601Request()
		{
		}
	}
}