package com.xyw.module.fnbj.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F306Response")]
	public class F306Response
	{
		public var  rowCount:Number;
		public var f306:F306;
		public var vf306s:ArrayCollection;
		public var errorMessage:String;
		public var promptMessage:String;
		public var state:Boolean;
		public function F306Response()
		{
		}
	}
}