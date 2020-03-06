package com.xyw.module.swjc.model
{

	import com.xyw.module.swjc.model.Sw301;
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.swjc.model.Sw304Response")]
	public class Sw304Response extends MessageResponse
	{
		public var sw30401:Number;
		public var sw304:Sw304;
		public var vSw304:VSw304;
		public var rowCount:Number;
		public var vSw304s:ArrayCollection;
		
		public var state:Boolean;
		
		public function Sw304Response()
		{
		}
	}
}