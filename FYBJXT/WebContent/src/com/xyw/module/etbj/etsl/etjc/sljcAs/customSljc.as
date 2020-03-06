import com.xyw.module.etbj.etsl.etjc.ccjc.jccx.cjTitle;
import com.xyw.module.etbj.etsl.model.E702;
import com.xyw.module.etbj.etsl.model.E702Request;
import com.xyw.module.etbj.etsl.model.E702Response;
import com.xyw.sys.custom.component.CompMethod;
import com.xyw.sys.model.SystemUser;

import mx.events.FlexEvent;
import mx.rpc.events.ResultEvent;

import spark.components.DataGrid;
import spark.events.GridSelectionEvent;

private var systemUser:SystemUser ;
private var e702Request:E702Request;
private var e702Reponse:E702Response;
private var e702:E702;
[Bindable]
private var ve702:Object;

private function moduleCreationCompleteHandler(event:FlexEvent,isQueryE705=false,getComboBoxDataHandler:Function=null):void
{
	//security();
	this.systemUser = this.parentApplication.systemUser;
	//检查读卡权限
	if(this.systemUser.duka == "1"){
		this.duka1.enabled = true;
	}
	if(isQueryE705)
		CompMethod.getComboBoxData(
			["select e705_04,t.e705_03 from E705 t","E705",false],
			["systemService","getComboBoxData",getComboBoxDataHandler,null])
}

private function onSelected(event:GridSelectionEvent):void
{
	this.ve702 = DataGrid(event.target).selectedItem;
}

private function query():void
{
	_query(1);
}

private function queryE702Handler(event:ResultEvent):void
{
	CompMethod.queryHandler(event.result,['ve702s','rowCount','errorMessage'],
		certificateDataGrid,pagerBar,pagerFunction);
	
}

public function pagerFunction(currentPageIndex:int, pageSize:int):void
{
	_query(currentPageIndex,pageSize);
}

public function refresh():void
{
	_query(pagerBar.currentPageIndex);
}

private function _query(currentPageIndex:int,pageSize:int=20):void
{
	this.ve702=null;
	CompMethod.query(initQueryParam,new E702Request(),
		['e702Service','queryE702',queryE702Handler],
		currentPageIndex,pageSize);
}

/**
 *
 */
private function readCard():void
{
	var arr:Array = CompMethod.read_card();
	if(!arr)
		return ;
	parent_name.text=arr[0];
	parent_idcard.text=arr[5];
	query();
}

/**
 *
 */
private function modifyOrDel(isDel:Boolean=false,param:*=null):void
{
	CompMethod.modifyOrDel(this.ve702,['e70277','e70274'],
		isDel?deleteE702:update,param,isDel);
}


private function update(registrationType:Number):void
{
	var window:cjTitle = new cjTitle();
	window.ve702= this.ve702;
	window.modify=true;
	window.registrationType=registrationType;
	CompMethod.popUpTitleWindow(window,this,true);
	
} 


private function deleteE702():void
{
	e702Request=new E702Request();
	e702Request.e70201 = ve702.e70201;
	this.e702Service.deleteE702(e702Request);
}

private function  deleteE702Handler(event:ResultEvent):void{
	CompMethod.CUDHandler(event.result,['errorMessage','删除'],refresh);
}

/**
 *
 */
private function E702_08LabelFunction(item:Object,column:GridColumn):String
{
	
	var label:String=item[column.dataField];
	var month:int=Number(label.substring(0,label.length-1));
	if(!isNaN(month)&&month>8)
	{
		label=label.substring(0,label.length-1);
		label=Number(label)/12+'岁';
	}
	return label;
	
}


/**
 *
 */
private function getText(e702Request:Object):Boolean
{
	e702=new E702();
	if(E701_06.text||parent_name.text||parent_idcard.text||parent_phone.text)
	{
		
		e702.e70207=StringUtil.trim(E701_06.text);
		e702Request.parent_name=StringUtil.trim(parent_name.text);
		e702Request.parent_phone=StringUtil.trim(parent_phone.text);
		e702Request.parent_idcard=StringUtil.trim(parent_idcard.text);
		
		return true;
	}
	return false;
}