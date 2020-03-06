package com.xyw.module.msss.fnbj.model
{
	import com.xyw.module.msss.fnbj.model.F502;
	import com.xyw.module.msss.fnbj.model.VF502;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F502Request")]
	public class F502Request
	{
		public var f50201:String;
		public var f502:F502;
		public var flag:String;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var suffixSql:String;
		public var f502PicArr:ArrayCollection;
		public function F502Request()
		{
		}
	}
}