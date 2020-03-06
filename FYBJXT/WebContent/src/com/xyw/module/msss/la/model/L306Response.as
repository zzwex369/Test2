package com.xyw.module.msss.la.model
{
	import com.xyw.uploadPictures.model.PictureMessage;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.xyw.medical.fnbj.model.L306Response")]
	public class L306Response extends PictureMessage
	{
		public var l30601:String;
		public var delStatus:Boolean;
		public var suffix:String;
		public var flag:String;
		public var picNum:String;
		public var picPath:String;
		public var errorMessage:String;
		public var picList:ArrayCollection;
		public var vl306s:ArrayCollection;
		public function L306Response()
		{
		}
	}
}