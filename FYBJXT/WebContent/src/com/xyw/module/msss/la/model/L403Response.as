package com.xyw.module.msss.la.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L403Response")]
	public class L403Response extends MessageResponse
	{
		public function L403Response()
		{
		}
		public var l40301:String;
		public var l403:L403;
		public var rowCount:Number;
		public var vl403s:ArrayCollection;
		public var state:Boolean;
	}
}