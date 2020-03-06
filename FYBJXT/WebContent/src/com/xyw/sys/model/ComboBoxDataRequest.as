package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.ComboBoxDataRequest")]
	public class ComboBoxDataRequest
	{
		public var sql:String;
		public var showPrompt:Boolean;
		public var flag:String;
		public function ComboBoxDataRequest()
		{
		}
	}
}