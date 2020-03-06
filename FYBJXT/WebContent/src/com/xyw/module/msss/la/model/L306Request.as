package com.xyw.module.msss.la.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L306Request")]
	public class L306Request
	{
		public var l306:L306;
		public var delStatus:Boolean;
		public var picPath:String;
		public var suffix:String;
		public var flag:String;
		public var picNum:String;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:Number;
		public var parameterPagesize:Number;
		public var picList:ArrayCollection;
		public function L306Request()
		{
		}
	}
}