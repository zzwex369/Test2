package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.LoginRequest")]
	public class LoginRequest
	{
		public var username:String;
		public var password:String;
		public var quanxian:String;
		public var modifyTime:String;
		public function LoginRequest()
		{
		}
	}
}