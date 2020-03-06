package com.xyw.sys.custom.itemrenderer
{
	import spark.skins.spark.DefaultGridHeaderRenderer;
	
	public class CustomDataGridColumnHeaderItemRender extends DefaultGridHeaderRenderer
	{
		public function CustomDataGridColumnHeaderItemRender()
		{
			super();
			this.labelDisplay.setStyle("textAlign", "center");
		}
	}
}