package com.xyw.module.upload.model
{
	import com.xyw.sys.model.MessageResponse;
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.client.fybj.upload.model.FybjUploadResponse")]
	public class FybjUploadResponse extends MessageResponse
	{
		public var ve601s:ArrayCollection;
		public var rowCount:Number;
		public function FybjUploadResponse()
		{
			super();
		}
	}
}