import mx.controls.Alert;
import mx.utils.StringUtil;

import spark.components.DropDownList;
import spark.events.IndexChangeEvent;

private function cardType_changeHandler(event:IndexChangeEvent):void
{
	
	var label:String=DropDownList(event.target).selectedItem.label;
	if('其他'==StringUtil.trim(label))
		callLater(
			function ():void
			{
				Alert.show("证件号码一栏请输入港澳台居民出入境证件或者港澳台居民居住证的证件号码","系统提示");
			}	
		)
}