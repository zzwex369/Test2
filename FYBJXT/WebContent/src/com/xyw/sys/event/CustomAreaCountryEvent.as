package com.xyw.sys.event
{
	import flash.events.Event;

	public class CustomAreaCountryEvent extends Event
	{
		public static const CUSTOMAREATOWNEVENT:String = "customAreaCountryEvent";
		public var dataValue:String;
		public function CustomAreaCountryEvent(dataValue:String, type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.dataValue = dataValue;
		}
	}
}