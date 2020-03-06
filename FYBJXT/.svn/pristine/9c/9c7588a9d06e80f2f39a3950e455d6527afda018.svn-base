package com.xyw.sys.custom.component
{
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.core.IVisualElement;
	import mx.styles.StyleManager;
	
	import spark.components.TitleWindow;

	/**
	 *在弹出窗口添加组件
	 */
	public class CustomButtonTitleWindow extends TitleWindow
	{
		/**
		*添加组件
		*/
		public var arrElement:ArrayCollection=new ArrayCollection();
		public function CustomButtonTitleWindow()
		{
			super();
		}
		
		override protected function createChildren():void
		{  
			super.createChildren();
			for(var i:int=0;i<arrElement.length;i++)
			{
				this.addElement(arrElement[i]);  
			}
		}  
	}
}