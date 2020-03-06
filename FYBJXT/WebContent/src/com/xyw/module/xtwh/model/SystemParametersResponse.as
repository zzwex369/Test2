package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.SystemParametersResponse")]
	public class SystemParametersResponse extends MessageResponse
	{
		public var listS900:ArrayCollection;
		public function SystemParametersResponse()
		{
		}
	}
}