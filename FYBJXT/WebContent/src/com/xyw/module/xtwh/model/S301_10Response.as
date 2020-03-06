package com.xyw.module.xtwh.model
{
	import mx.collections.ArrayCollection;
	import com.xyw.sys.model.MessageResponse;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.qfrwh.model.S301_10Reponse")]
	public class S301_10Response extends MessageResponse
	{
		public var rowCount:Number;
		public var vs301_10s:ArrayCollection;
		public var s301_10:S301_10;
		public function S301_10Response()
		{
		}
	}
}