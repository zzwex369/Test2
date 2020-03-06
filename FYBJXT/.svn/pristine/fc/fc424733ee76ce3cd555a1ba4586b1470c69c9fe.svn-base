package com.xyw.sys.custom.component
{
	import mx.core.mx_internal;
	
	import spark.components.ComboBox;
	import spark.utils.LabelUtil;
	use namespace mx_internal;
	public class CustomComboxImpl extends ComboBox
	{
		
		
		override mx_internal function updateLabelDisplay(displayItem:* = undefined):void
		{
			if(sub()){
				return;
			}
			//		super.updateLabelDisplay();
			
			if (textInput)
			{
				if (displayItem == undefined)
					displayItem = selectedItem;
				if (displayItem != null && displayItem != undefined)
				{
					textInput.text = LabelUtil.itemToLabel(displayItem, labelField, labelFunction);
				}
			}
		}
		
		public function sub():Boolean{
			return false;
		}
		
		public function CustomComboxImpl()
		{
			super();
		}
	}
}