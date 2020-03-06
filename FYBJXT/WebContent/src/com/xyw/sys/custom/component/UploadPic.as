package com.xyw.sys.custom.component
{
	import com.xyw.uploadPictures.model.Pictures;
	
	import flash.events.DataEvent;
	import flash.events.Event;
	import flash.events.HTTPStatusEvent;
	import flash.events.IOErrorEvent;
	import flash.net.FileReference;
	import flash.net.URLRequest;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	

	public class UploadPic
	{
		private var _file:FileReference=null;
		private var _picData:ArrayCollection=new ArrayCollection();
		private var _uploadFNum:int=0;
		private var pic10:String=null;
		public function UploadPic()
		{
		}
		public function _uploadPic(picData:ArrayCollection,image:Pictures,contextRootUrl:String):void
		{ 
			_picData.addAll(picData);
			for(var i:int=0;i<picData.length;i++)
			{
				_file=new FileReference();  
				var obj:Object=new Object();
				obj=picData[i];
				_file=obj.file;
				pic10=obj.pic10;
				uploadfile(_file,image,pic10,contextRootUrl);			
			}
		}
		private function uploadfile(file:FileReference,image:Pictures,pic10:String,contextRootUrl:String):void
		{   
			try{
				/*var requestUrl:URLRequest = new URLRequest(contextRootUrl +"/FileUploadServlet?pic02="
											   +image.pic02+"&pic07="+image.pic07+"&pic08="
											   +image.pic08+"&pic09="+image.pic09+"&pic10="
											   +pic10);*/
				var requestUrl:URLRequest = new URLRequest(contextRootUrl +"/FileUploadServlet?pic02="
					+image.pic02+"&pic07="+image.pic07+"&pic08="
					+image.pic08+"&pic10="+pic10);
				file.upload(requestUrl);
				file.addEventListener(Event.COMPLETE,onComplete);	
				//file.addEventListener(IOErrorEvent,ioErrorEventHandler);
				file.addEventListener(HTTPStatusEvent.HTTP_STATUS,httpStatusHandler);
				//	file.addEventListener(HTTPStatusEvent.HTTP_RESPONSE_STATUS,httpResponseHandler);
				file.addEventListener(DataEvent.UPLOAD_COMPLETE_DATA,dataEvent); 
			}
			catch(e:Error){
				Alert.show("上传图片失败","系统提示");
				trace("UploadPic.uploadfile(file, image, pic10, contextRootUrl)"+e);
				
			}				
		}
		internal function onComplete(e:Event):void{
			++_uploadFNum;
			completeHandler();
		}
		internal function completeHandler():void{
			_file.removeEventListener(Event.COMPLETE,onComplete);
			if(_uploadFNum>=_picData.length){
				_picData.removeAll();//清空文件列表			
			}
		}
		protected function saveImageFaultHandler(event:FaultEvent):void
		{
			Alert.show(event.fault.message.toString());
		}
		private function ioErrorEventHandler(event:IOErrorEvent):void
		{
			Alert.show("IOErrorEvent************"+event);
		}
		private function httpStatusHandler(event:HTTPStatusEvent):void
		{
			Alert.show("HTTPStatusEvent----"+event);
		}
		private function httpResponseHandler(event:HTTPStatusEvent):void
		{
			Alert.show("HTTPStatusEvent>>>>>>>>>>>>>>>>"+event);
		}
		/**
		 * 返回的提示
		 * */
		private function dataEvent(event:DataEvent):void
		{
		}
	}
}