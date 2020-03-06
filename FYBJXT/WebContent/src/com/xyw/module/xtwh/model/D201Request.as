package com.xyw.module.xtwh.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.xzjgwh.model.D201Request")]
	public class D201Request
	{
		public var pageIndex:int;
		public var pageSize:int;
		public var d201:D201;
		public function D201Request()
		{
		}
	}
}