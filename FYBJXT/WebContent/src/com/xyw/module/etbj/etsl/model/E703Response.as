package com.xyw.module.etbj.etsl.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.etsl.model.E703Response")]
	public class E703Response
	{
		public var falg:Boolean;
		public var state:Number;
		public ve701:VE703;
		public rowCount:Number;
		public var ve701s:ArrayCollection;
		
		public function E703Response()
		{
		}
	}
}