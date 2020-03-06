package com.xyw.sys.model
{
	import mx.collections.ArrayCollection;
	
	
	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.PicDataRequest")]
	public class PicDataRequest {
		public var picList:ArrayCollection;//图片字符数组集合
		public var picParams:Array;//图片参数   0 sql 1 缩放比例   2质量参数  3图片格式
	
		}	
}
