package com.xyw.module.msss.etbj.model
{
	import mx.collections.ArrayCollection;

	/**
	 * @author libo
	 * 创建时间：Jun 17, 2017 11:44:51 AM
	 */
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E601Request")]
	public class E601Request
	{
		
		public var e601:E601;
		public var timeStr:Date;
		public var timeEnd:Date;
		public var dateField:String;
		public var parameterPageindex:Number;
		public var parameterPagesize:Number;
		public var flag:String;
		public var e60101List:ArrayCollection;
		public function E601Request()
		{
		}
	}
}