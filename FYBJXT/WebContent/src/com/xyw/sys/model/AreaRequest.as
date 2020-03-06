package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.AreaRequest")]
	public class AreaRequest
	{
		public var areaCode:String;
		public var showPrompt:Boolean;
		public var areaFlag:String;
		public var table:String;
		public function AreaRequest()
		{
		}
	}
}