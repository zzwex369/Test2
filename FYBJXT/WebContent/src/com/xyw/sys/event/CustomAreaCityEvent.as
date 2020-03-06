package com.xyw.sys.event
{
	import flash.events.Event;
	
	public class CustomAreaCityEvent extends Event
	{
		public static const CUSTOMAREACITYEVENT:String = "customAreaCITYEvent";
		public var dataValue:String;
		public function CustomAreaCityEvent(dataValue:String, type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.dataValue = dataValue;
		}
	}
}