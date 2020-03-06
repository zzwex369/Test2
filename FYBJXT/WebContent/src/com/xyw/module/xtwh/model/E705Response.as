package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.common.et.yey.model.E705Reponse")]
	public class E705Reponse extends MessageResponse
	{
		public var e70501:String;
		public var state:Boolean;
		public var rowCount:Number;
		public var ve705s:ArrayCollection;
		public var e705:E705;
		public function E705Reponse()
		{
		}
	}
}