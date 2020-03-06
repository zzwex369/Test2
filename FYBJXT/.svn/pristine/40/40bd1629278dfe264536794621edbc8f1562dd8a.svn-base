import com.xyw.sys.custom.component.CompMethod;
import com.xyw.sys.model.ComboBoxDataRequest;

import flash.events.Event;

import mx.collections.ArrayCollection;
import mx.core.FlexGlobals;
import mx.events.CloseEvent;
import mx.rpc.events.ResultEvent;

/**
 * 得到月龄 
 * birth 小孩出生日期
 * return 0 月 1 天
 */
private function getDiffMoth(birth:Date):Array
{
	var totalM:int=0;
	var now:Date=FlexGlobals.topLevelApplication.serviceNow;
	var year:Number=now.fullYear;
	var moth:Number=now.month+1;//
	var date:Number=now.date;//
	var birthYear:Number=birth.fullYear;
	var birthMoth:Number=birth.month+1;//
	var birthDate:Number=birth.date;//
	var diffDate:Number=0;
	var diffMonth:Number=(year-birthYear)*12+moth;
	if(date-birthDate>-1)
	{
		diffDate=date-birthDate;
	}else
	{
		--moth;
		--diffMonth;
		if(!moth)
		{
			moth=12;
			--year;
		}
		diffDate=CompMethod.dayCount(year,moth)+date-birthDate;
	}
	diffMonth-=birthMoth;
	return [diffMonth.toString(),diffDate.toString()];
}	

/**
 *
 */
public function getSelectItem(ve301:Object):void
{
	this.ve301=ve301;
	var moth:Array=getDiffMoth(ve301.e30106);
	E304_56_1.text=moth[0];
	E304_56_2.text=moth[1];
}

private function saveOrUpdateE304Handler(event:ResultEvent):void
{   
	CompMethod.CUDHandler(event.result,['errorMessage',
		this.ve301?"保存":"修改"],
		function():void{dispatchEvent(new Event("saveSuccess"))},
		saveButton);
}



/**
 *
 */
private function getSelectIdx(table:String,id:Object):void
{
	var e30454:int=E304_54.selectedIndex;
	if(e30454==1||e30454==2)
		validateParam(table,id.text);
}

/**
 *	验证性别  身高 体重 是否有参数
 */
private function validateParam(table:String,val:String):void
{
	
	
	var label:String=E304_02.selectedItem.label;
	var isOPeration:Boolean=label.indexOf('月')!=-1?false:true;
	label=label.substring(0,label.length-1);
	var month:Object=isOPeration?Number(label)*12:label;
	setLevel(table,val,month.toString(),E304_54.selectedItem.data);
	
}
/**
 *用于身高 和体重
 * s
 */
private function setLevel(table:String,val:String,s01:String,s03:String,s02:String=''):void
{
	if(!val||isNaN(Number(val)))
		return ;
		
	var sql:String="select nvl(sum"+
		"("+
		"case "+ 
		"when "+val+" between t.s_04 and t.s_05 then 5 "+
		"when "+val+" between t.s_05 and t.s_06 then 4 "+
		"when "+val+" between t.s_06 and t.s_08 then 3 "+
		"when "+val+" between t.s_08 and t.s_09 then 2 "+
		"when "+val+" between t.s_09 and t.s_10 then 1 "+
		"else 0 "+
		"end"+
		"),0) as result,0 as label from "+table+
		" t where t.s_01="+s01+" and t.s_03="+s03 ;
	sql+=s02?" and t.s_02="+s02:s02;
	
	comboBoxDataRequest = new ComboBoxDataRequest();
	comboBoxDataRequest.showPrompt = false;
	comboBoxDataRequest.flag = table;
	comboBoxDataRequest.sql = sql;
	this.systemService.getComboBoxData(this.comboBoxDataRequest);
	
	CompMethod.customRemoteObject(["systemService","getComboBoxData",
		getLevelHandler],comboBoxDataRequest);
	
}

/**
 *
 */
private function getLevelHandler(event:ResultEvent):void
{
	var comboBoxDataResponse:Object =  event.result;
	var flag:String = comboBoxDataResponse.flag;
	var comboBoxDataList:ArrayCollection = comboBoxDataResponse.comboBoxDataList;
	var obj:Object=comboBoxDataList.getItemAt(0);
	var idx:int=Number(obj.data);
	if(flag == "Z304_11")//身高
		E304_08.selectedIndex=idx;
	else if(flag == "Z304_12")//体重
		E304_06.selectedIndex=idx;
	else if(flag == "Z304_14")//
		E304_74.selectedIndex=idx;
	
}

private function setRange():void{
	getSelectIdx('Z304_11',E304_07);
	getSelectIdx('Z304_12',E304_05);
}

/**
 *清空输入内容
 */
private function selectRange(event:IndexChangeEvent,val:*,id:*):void
{
	var valArr:Array=val is int?[val]:val;
	doSelectRange(event.newIndex,valArr,id);
	
}

/**
 *
 */
private function doSelectRange(newIdx:int,val:Array,id:*):void
{
	var isSame:Boolean=false;
	for(var i:String in val)
	{
		if(val[i]==newIdx)
			isSame=true;
	}
	if(!isSame)
		setEleNull(id);
}

/**
 *清空输入内容
 */
private function setEleNull(id:*,enabled:Boolean=false):void
{
	var idArr:Array=id is UIComponent?[id]:id;
	for(var i:String in idArr)
	{
		if(idArr[i] is DropDownList)
			idArr[i].selectedIndex=0;
		else if(idArr[i] is TextInput)
			idArr[i].text='';
		else if(idArr[i] is spark.components.CheckBox)
			idArr[i].selected=false;
		idArr[i].enabled=enabled;
	}
	
}



