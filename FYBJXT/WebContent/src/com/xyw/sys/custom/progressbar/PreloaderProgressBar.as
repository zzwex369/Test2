package com.xyw.sys.custom.progressbar
{
	import flash.display.*;
	import flash.events.*;
	import flash.net.*;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import flash.utils.Timer;
	import mx.controls.Alert;
	import mx.events.FlexEvent;
	import mx.preloaders.DownloadProgressBar;
	import org.osmf.events.TimeEvent;
	
	public class PreloaderProgressBar extends DownloadProgressBar{
		private var logo:Loader;
		private var txt:TextField;
		private var _preloader:Sprite;
		private var timer:Timer;
		public function PreloaderProgressBar(){
			logo = new Loader();
			// logo.load(new URLRequest("l4cd.png"));
			addChild(logo);
			
			var style:TextFormat = new TextFormat(null,15,0xFFFFFF,null,null,null,null,null,"left");
			txt = new TextField();
			txt.defaultTextFormat = style;
			txt.width = 200;
			txt.selectable = false;
			txt.height = 20;
			txt.text = "系统加载中";
			addChild(txt);
			
			timer = new Timer(1000,0);
			timer.addEventListener(TimerEvent.TIMER, dispatchComplete);
			super();
		}
		//最重要的代码就在这里..重写preloader,让swf执行加载的时候~进行你希望的操作~
		override public function set preloader(value:Sprite):void{
			_preloader = value
			//四个侦听~分别是 加载进度 / 加载完毕 / 初始化进度 / 初始化完毕
			_preloader.addEventListener(ProgressEvent.PROGRESS,load_progress);
			_preloader.addEventListener(Event.COMPLETE,load_complete);
			_preloader.addEventListener(FlexEvent.INIT_PROGRESS,init_progress);
			_preloader.addEventListener(FlexEvent.INIT_COMPLETE,init_complete);
			
			stage.addEventListener(Event.RESIZE,resize)
			resize(null);
		}
		private function remove():void{
			_preloader.removeEventListener(ProgressEvent.PROGRESS,load_progress);
			_preloader.removeEventListener(Event.COMPLETE,load_complete);
			_preloader.removeEventListener(FlexEvent.INIT_PROGRESS,init_progress);
			_preloader.removeEventListener(FlexEvent.INIT_COMPLETE,init_complete);
			stage.removeEventListener(Event.RESIZE,resize);
			this.timer.removeEventListener(TimerEvent.TIMER, dispatchComplete);
		}
		private function resize(e:Event):void{
			logo.x = (stage.stageWidth - 40)/2;
			logo.y = (stage.stageHeight - 80)/2;
			txt.x = (stage.stageWidth - 200)/2;
			txt.y = logo.y + 40+5;
			
			graphics.clear();
			graphics.beginFill(0x333333);
			graphics.drawRect(0,0,stage.stageWidth,stage.stageHeight);
			graphics.endFill();
		}
		private function load_progress(e:ProgressEvent):void{
			timer.start();
			//txt.text = "正在加载..." + int(e.bytesLoaded/e.bytesTotal*100) + "%";
			/*
			if((int(e.bytesLoaded/e.bytesTotal*100) + "%") == "100%") {
				if(txt.text.length >= 15) {
					txt.text = txt.text.substr(0, 9);
				}
				txt.text = "系统加载中 请稍候  .";
			}*/
		}
		private function load_complete(e:Event):void{
			txt.text = "加载完毕"
		}
		private function init_progress(e:FlexEvent):void{
			txt.text = "正在初始化"
		}
		private function init_complete(e:FlexEvent):void{
			txt.text = "初始化完毕"
			remove()
			//最后这个地方需要dpe一个Event.COMPLETE事件..表示加载完毕让swf继续操作~
			dispatchEvent(new Event(Event.COMPLETE))
		}
		
		private function dispatchComplete(event:TimerEvent):void
		{
			if(txt.text.length == 5) {
				txt.text = "系统加载中 .";
			} else if(txt.text.length == 7) {
				txt.text = "系统加载中 . .";
			} else if(txt.text.length == 9) {
				txt.text = "系统加载中 . . .";
			} else if(txt.text.length == 11) {
				txt.text = "系统加载中";
			}
		}
	}
}