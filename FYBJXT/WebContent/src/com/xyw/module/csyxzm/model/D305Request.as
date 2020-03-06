package com.xyw.module.csyxzm.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D305Request")]
	public class D305Request
	{
		public var d305:D305;
		public var vd305:VD305;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var d30537Start:Date;
		public var d30537End:Date;
		public var flag:String;
		public function D305Request()
		{
		}
	}
}