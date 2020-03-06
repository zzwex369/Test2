package com.xyw.uploadPictures.model
{
	import mx.collections.ArrayCollection;

	/**
	 * @author Joe
	 */
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.loadPicture.model.PictureResponse")]
	public class PictureResponse extends PictureMessage
	{
		public var rowCount:Number;
		public var vp:ArrayCollection;
		public var picture:Pictures;
		public var vpicture:VPicture;
		public function PictureResponse()
		{
			
		}
	}	
}