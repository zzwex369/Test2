package com.xyw.module.msss.fnbj.model
{
	import com.xyw.module.msss.fnbj.model.F502;
	import com.xyw.module.msss.fnbj.model.VF502;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F603Request")]
	public class F603Request
	{
		public var f60301:String;
		public var f603:F603;
		public var flag:String;
		public var paramMap:Object;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public function F603Request()
		{
		}
	}
}