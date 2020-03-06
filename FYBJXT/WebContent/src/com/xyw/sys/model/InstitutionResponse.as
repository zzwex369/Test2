package com.xyw.sys.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.InstitutionResponse")]
	public class InstitutionResponse extends MessageResponse
	{
		public var comboBoxDataList:ArrayCollection;
		public var institutionFlag:String;
		public var showPrompt:Boolean;
		public function InstitutionResponse()
		{
			super();
		}
	}
}