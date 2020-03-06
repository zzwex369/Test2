package com.xyw.module.upload.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.client.fybj.upload.model.FybjUploadRequest")]
	public class FybjUploadRequest
	{
		public var parameterPageindex:uint;
		public var parameterPagesize:uint;
		public var institutionCode:String;
		public var timeStart:String;
		public var timeEnd:String;
		public var status:String;
		public function FybjUploadRequest()
		{
		}
	}
}