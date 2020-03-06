package com.xyw.sys.custom.component
{
	import mx.states.OverrideBase;
	
	import spark.components.DropDownList;
	
	public class CustomDropDownList extends DropDownList
	{
		public function CustomDropDownList()
		{
			super();
		}
		/*override public function set enabled(value:Boolean) : void
		{
			if (enabled != value)
			invalidateSkinState();
			super.enabled = value;
		}*/

		override protected function getCurrentSkinState():String
		{
			 return super.enabled?"":"normal"
		}
	}
}