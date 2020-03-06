package com.xyw.module.fndj.model
{
	import com.xyw.module.fnbj.model.F302;
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F302Response")]
	public class F302Response extends MessageResponse
	{
		public var f30201:Number;
		public var f30202:Number;
		public var f302:F302;
		public var rowCount:Number;
		public var vf302s:ArrayCollection;
		
		public var state:Boolean;
		
		public function F302Response()
		{
		}
	}
}