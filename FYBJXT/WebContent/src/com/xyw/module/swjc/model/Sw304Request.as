package com.xyw.module.swjc.model
{
	import com.xyw.sys.model.MessageResponse;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.swjc.model.Sw304Request")]
	public class Sw304Request
	{
		public var sw30401:Number;
		public var sw304:Sw304;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
		public var suffixSql:String;
		public var resType:String;//返回类型 对应 Sw304Response 属性顺序 1 主键 2 对象  3 视图
		public function Sw304Request()
		{
		}
	}
}