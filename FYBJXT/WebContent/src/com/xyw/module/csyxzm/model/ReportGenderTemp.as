package com.xyw.module.csyxzm.model
{
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.birth.report.model.ReportGenderTemp")]
	public class ReportGenderTemp
	{
		public var institution:String;
		public var institutionZH:String;
		public var boy:Number;
		public var girl:Number;
		public var percent_boy:String;
		public var percent_girl:String;
		public var total:Number;
		public var se:Number;
		public var area:String;
		public var areaZH:String;
		public var nativePlace:Number;
		public var otherPlaces:Number;
		public var sreach:String;
		
		public function ReportGenderTemp()
		{
		}
	}
}