package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.MessageResponse")]
	public class MessageResponse
	{
		public var errorMessage:String;
		public var promptMessage:String;
		public var sessionInfo:String;
		
		public function MessageResponse()
		{
		}
	}
}