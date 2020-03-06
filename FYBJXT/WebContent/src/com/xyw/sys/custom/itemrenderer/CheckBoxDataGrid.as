package com.xyw.sys.custom.itemrenderer
{
	import com.xyw.sys.custom.itemrenderer.CheckBoxHeaderRenderer;
	import com.xyw.sys.custom.itemrenderer.CheckBoxItemRenderer;
	
	import flash.events.KeyboardEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.DataGrid;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.controls.dataGridClasses.DataGridItemRenderer;
	import mx.controls.listClasses.IListItemRenderer;
	import mx.core.ClassFactory;
	
	
	/** 
	 *  DataGrid that uses checkboxes for multiple selection
	 */
	public class CheckBoxDataGrid extends DataGrid
	{
		public function CheckBoxDataGrid()
		{
			editable=false;
			allowMultipleSelection = true;
		}
		
		override public function set columns(value:Array):void
		{   
			var arr:Array = value.concat();
			var column:DataGridColumn = new DataGridColumn();
			column.width = 40;
			column.editable = false;
			column.headerText = ""
			column.sortable = false;
			column.headerRenderer = new ClassFactory(CheckBoxHeaderRenderer);
			column.itemRenderer = new ClassFactory(CheckBoxItemRenderer);
			arr.unshift(column);
			super.columns = arr;
		}
		
		override protected function selectItem(item:IListItemRenderer,
											   shiftKey:Boolean, ctrlKey:Boolean,
											   transition:Boolean = true):Boolean
		{
			if(item is CheckBoxItemRenderer||item is DataGridItemRenderer)
				return super.selectItem(item, false, true, transition);
			return false;
		}
		
		override protected function keyDownHandler(event:KeyboardEvent):void
		{
			event.ctrlKey = true;
			event.shiftKey = false;
			super.keyDownHandler(event);
		}
		
		public function deleteItems():void
		{
			for each(var item:Object in selectedItems)
			{
				var index:int = dataProvider.getItemIndex(item);
				dataProvider.removeItemAt(index);
			}
			
		}
		public function getAllItems():ArrayCollection
		{
			var arr:ArrayCollection=new ArrayCollection();
			for each(var item:Object in selectedItems)
			{
				arr.addItem(item);
				
			}
			return arr;
		}
		public function changeState(item,transition:Boolean = true):void
		{
			selectItem(item, false, true,transition);
		}
	}
	
}