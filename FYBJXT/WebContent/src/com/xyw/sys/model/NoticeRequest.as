package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.NoticeRequest")]
	public class NoticeRequest
	{
		public var message:String;
		public var fileName:String;
		public var path:String;
		public function NoticeRequest()
		{
		}
	}
}