package com.xyw.module.msss.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E505Response")]
	public class E505Response extends MessageResponse
	{
		public  var e50501:String;
		public  var e505:E505;
		public  var  _ve505:VE505;
		public  var  _ve504:VE504;
		public  var  rowCount:Number;
		public  var  state:Boolean;
		public  var ve505:ArrayCollection;
		public  var ve505AndVE504s:ArrayCollection;

	}
}