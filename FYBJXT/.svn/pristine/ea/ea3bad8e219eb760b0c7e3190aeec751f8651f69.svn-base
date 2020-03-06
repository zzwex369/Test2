package com.xyw.sys.event
{
	import flash.events.Event;
	
	public class RefreshParentWindowDataEvent extends Event
	{
		public static const OPERATION_SUCCESS:String = "operationOk";
		private var _data:Object;
		public function RefreshParentWindowDataEvent(type:String, data:Object = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this._data = data;
			super(type, bubbles, cancelable);
		}
		
		public function get data():Object{
			return this._data;
		}
		public function set data(value:Object):void
		{
			this._data = value;
		}
	}
}