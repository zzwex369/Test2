package com.xyw.module.csyxzm.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.D306Response")]
	public class D306Response extends MessageResponse
	{
		public var d306:D306;
		public var vd306:VD306;
		public var vd306_:VD306_;
		public var state:Boolean;
		public var rowCount:Number;
		public var vd306s:ArrayCollection;
		public var flag:String;
		public function D306Response()
		{
		}
	}
}