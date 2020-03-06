package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.SKLoginRequest")]
	public class SKLoginRequest
	{
		public var name:String;
		public var pwd:String;
		public var permission:String;
		public var ranTime:String;//随机时间
		public var sKID:String;//加密狗ID
		public var skCard:String;//身份证信息
		public var clientResult:String;//客户端加密结果
		public function SKLoginRequest()
		{
		}
	}
}