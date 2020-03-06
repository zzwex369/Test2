package com.xyw.sys.custom.component
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.MouseEvent;
	import flash.events.SecurityErrorEvent;
	import flash.net.FileFilter;
	import flash.net.FileReference;
	import flash.utils.ByteArray;
	
	import mx.controls.Alert;
	
	import spark.components.Button;

	/**
	 *得到单个图片信息
	 */
	public class SingleUploadPic extends EventDispatcher
	{
		private var file:FileReference;
		[Bindable]
		public var byteArray:ByteArray;
		
		[Bindable]
		public var name:String;
		
		public function SingleUploadPic	()
		{
			
			file=new FileReference();
			configureListeners(file);
			file.browse(getTypes())
		}
		
		private function configureListeners(dispatcher:IEventDispatcher):void {
			dispatcher.addEventListener(Event.COMPLETE, completeHandler);
			dispatcher.addEventListener(Event.SELECT, selectHandler);
		}
		
		private function getTypes():Array{
			var allTypes:Array = new Array(getImageTypeFilter());
			return allTypes;
		}
		
		private function getImageTypeFilter():FileFilter {
			return new FileFilter("Images (*.jpg, *.jpeg, *.png)", "*.jpg;*.jpeg;*.png");
		}
		
	
		
		private function completeHandler(event:Event):void {
			byteArray=file.data;
			name=file.name;
			this.dispatchEvent(new Event("byteArray"));
		}
		
		
		
		private function selectHandler(event:Event):void {
			 file = FileReference(event.target);
			 file.load();
			
		
		}
	}
}