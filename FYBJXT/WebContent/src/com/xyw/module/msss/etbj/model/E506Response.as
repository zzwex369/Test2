package com.xyw.module.msss.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E506Response")]
	public class E506Response extends MessageResponse
	{
		public var id:String;
		public var e506:E506;
		public var rowCount:Number;
		public var state:Boolean;

	}
}