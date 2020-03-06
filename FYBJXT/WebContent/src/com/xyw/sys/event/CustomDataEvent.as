package com.xyw.sys.event
{
	import flash.events.Event;

	public class CustomDataEvent extends Event
	{
		public static const CUSTOM_DATA:String = "customData";
		public static const CUSTOM_DATA_CHANGE:String = "customDataChange";
		public var data:Object;//任一类型数据
		public function CustomDataEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false,data:Object = null)
		{
			this.data = data;
			super(type, bubbles, cancelable);
		}
		/**
		 *  @private
		 */
		override public function clone():Event 
		{
			return new CustomDataEvent(type,bubbles,cancelable,data);
		}
	}
}