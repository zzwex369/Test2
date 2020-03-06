package com.xyw.uploadPictures.model
{
	import mx.collections.ArrayCollection;

	/**
	 * @author Joe
	 */
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.loadPicture.model.PictureRequest")]
	public class PictureRequest
	{	
		public var pic01:Number;
		public var pic02:String;
		public var pic03:String;
		public var pic04:String;
		public var pic05:Date;
		public var pic06:String;
		public var pic07:String;
		public var pic08:String;
		public var pic09:String;
		public var pic10:String;
		public var pic11:String;
		public var pic12:String;
		public var pic13:String;
		public var pic14:String;
		public var pic15:String;
		public var pic16:String;
		public var pic17:String;
		public var pic18:String;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var parameterPageindex:int;
		public var parameterPagesize:int;
		public var flag:String;
		public var picArrays:ArrayCollection;
		public function PictureRequest()
		{
			
		}
	}	
}