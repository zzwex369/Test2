package com.xyw.sys.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.PicDataResponse")]
	public class PicDataResponse extends MessageResponse{
		public var picByteList:ArrayCollection;//返回转换图片字符数组集合
	}	
}
