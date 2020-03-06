package com.xyw.module.etbj.model
{
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E305Response")]
	public class E305Response
	{
		public var e305:E305;
		public var ve305:VE305;
		public var ve305s:ArrayCollection;
		public var rowCount:Number; 
		public var state:Boolean;
		public function E305Response()
		{
		}
	}
}