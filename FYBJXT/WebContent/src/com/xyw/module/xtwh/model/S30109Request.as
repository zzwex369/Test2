package com.xyw.module.xtwh.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.jsywh.model.S30109Request")]
	public class S30109Request
	{
		public var pageIndex:int;
		public var pageSize:int;
		public var s30109:S30109;
		public var vs30109:VS30109;
		public var systemCode:String;
		public function S30109Request()
		{
		}
	}
}