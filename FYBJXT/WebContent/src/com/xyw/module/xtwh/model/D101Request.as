package com.xyw.module.xtwh.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.yljggl.model.D101Request")]
	public class D101Request
	{
		public var pageIndex:int;
		public var pageSize:int;
		public var d101:D101;
		public function D101Request()
		{
		}
	}
}