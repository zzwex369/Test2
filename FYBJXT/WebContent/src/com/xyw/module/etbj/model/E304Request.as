package com.xyw.module.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E304Request")]
	public class E304Request extends MessageResponse
	{
		public var e304:E304;
		public  var count_e30402:Number;//月龄查询用
		public var e30405Start:Date;//随访起始时间
		public var e30405End:Date;//随访结束时间
		public var parameterPageindex:Number;
		public var parameterPagesize:Number;
		public var flag:String;
		public var sql:String;
		public var f301_02:String;
		public var f301_05:String;
		public var e30451start:Date;
		public var e30451end:Date;
		public var e30402start:String;
		public var e30402end:String;
		public function E304Request()
		{
		}
	}
}