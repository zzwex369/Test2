package com.xyw.sys.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.AssistRequest")]
	public class AssistRequest
	{
		public var path:String;
		public var fileName:String;
		public var d80704:String;
		public var message:String;
		public var d807:D807;
		
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public function AssistRequest()
		{
		}
	}
}