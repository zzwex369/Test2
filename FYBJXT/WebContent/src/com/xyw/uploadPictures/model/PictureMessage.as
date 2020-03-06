package com.xyw.uploadPictures.model
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;

	/**
	 * @author Joe
	 */
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.loadPicture.model.PictureMessage")]
	public class PictureMessage
	{
		public var status:Boolean;
		public var imageByte:ByteArray;
		public var message:String;
		public var rowCount:Number;
		public var picArrays:ArrayCollection;

		public function PictureMessage()
		{
			
		}
	}	
}