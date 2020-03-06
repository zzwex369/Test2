package com.xyw.module.msss.la.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L302Request")]
	public class L302Request
	{
		public function L302Request()
		{
		}
		public var l30201:String;
		public var l30202:String;
		public var l302:L302;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var suffixSql:String;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
		public var picList:ArrayCollection;//图片集合
	}
}