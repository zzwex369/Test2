package com.xyw.module.fnbj.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.F305Response")]
	public class F305Response
	{
		public var  rowCount:Number;
		public var f305:F305;
		public var vf305s:ArrayCollection;
		public var errorMessage:String;
		public var promptMessage:String;
		public var state:Boolean;
		public function F305Response()
		{
		}
	}
}