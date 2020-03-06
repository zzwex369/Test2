package com.xyw.module.msss.fnbj.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F605Request")]
	public class F605Request
	{
		public var f60501:String;
		public var f605:F605;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var suffixSql:String;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
		public var fieldMap:Object;
		public var codeLength:int;
		public function F605Request()
		{
		}
		
	}
}