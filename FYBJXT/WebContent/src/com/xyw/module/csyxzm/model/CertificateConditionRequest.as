package com.xyw.module.csyxzm.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.model.CertificateConditionRequest")]
	public class CertificateConditionRequest
	{
		public var date_start:Date;
		public var date_end:Date;
		
		public var institution:String;
		public var institutionType:String;
		
		public var areacode:String;
		public var areacodeZh:String;
		public var areacodeType:String;
		
		public var flag:String;
		
		public var parameterPageindex:uint;
		public var parameterPagesize:uint;
		
		public function CertificateConditionRequest()
		{
		}
	}
}