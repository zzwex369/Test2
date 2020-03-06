package com.xyw.module.msss.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E504Response")]
	public class E504Response  extends MessageResponse
	{
		public  var e50401:String;
		public  var e504:E504;
		public  var  rowCount:Number;
		public  var  state:Boolean;
		public  var ve504:ArrayCollection;
	}
}