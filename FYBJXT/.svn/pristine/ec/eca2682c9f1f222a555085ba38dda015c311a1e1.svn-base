package com.xyw.sys.custom.component
{
	import com.xyw.module.msss.la.model.VL301;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class DataGridEvent extends Event
	{
		public var state:Boolean=false;
		public var vl301:VL301=null;
		public function DataGridEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new DataGridEvent(type,bubbles,cancelable);
		}
	}
}