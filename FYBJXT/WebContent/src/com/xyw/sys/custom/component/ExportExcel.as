package com.xyw.sys.custom.component
{
	import flash.errors.*;
	import flash.events.*;
	import flash.external.*;
	import flash.net.URLRequest;
	import flash.net.URLRequestMethod;
	import flash.net.URLVariables;
	import flash.net.navigateToURL;
	
	import mx.controls.Alert;
	import mx.utils.StringUtil;
	
	import spark.components.DataGrid;
	import spark.components.gridClasses.GridColumn;
	
	public class ExportExcel
	{
		public function ExportExcel()
		{
		}
		/** 在导出数据的时候有可能出现单元格数据长度过长而导致Excel在显示时   
		 *  出现科学计数法或者#特殊符号，在此设置单元格宽度比例WIDTHSCALE，在   
		 *  代码中每个单元格的宽度扩展适当的比例值WIDTHSCALE。   
		 */   
		private static var WIDTHSCALE:Number=2.0;   
		
		/**   
		 * 将DataGrid转换为htmltable   
		 * @author rentao   
		 * @param: dg 需要转换成htmltable的DataGrid   
		 * @return: String   
		 */   
		public static function convertDGToHTMLTable2(dg:DataGrid,header:String):String {   
			//设置默认的DataGrid样式   
			var font:String = dg.getStyle('fontFamily');   
			var size:String = dg.getStyle('fontSize');   
			var str:String = '';   
			var colors:String = '';   
			var style:String = 'style="font-family:'+font+';font-size:'+size+'pt;"';                   
			var hcolor:Array;   
			
			//检索DataGrid的 headercolor   
			if(dg.getStyle("headerColor") != undefined) {   
				hcolor = [dg.getStyle("headerColor")];   
			} else {   
				hcolor = dg.getStyle("headerColors");   
			}                  
			
			//   Alert.show(hcolor+"");
			var x :String = "" ;
			if(hcolor == null){
				x = "0x323232" ;
			}else{
				x = Number((hcolor[0])).toString(16);
			}
			//   str+= '<table width="'+dg.width+'" border="1"><thead><tr width="'+dg.width+'" style="background-color:#' +Number((hcolor[0])).toString(16)+'" mce_style="background-color:#' +Number((hcolor[0])).toString(16)+'">';   
			str+= '<table align="center" width="'+dg.width+'" border="1"><thead><tr width="'+dg.width+'" style="background-color:#' +x+'" mce_style="background-color:#' +x+'">';  
			
			//设置tableheader数据(从datagrid的header检索headerText信息)                  
			for(var i:int = 0;i<dg.columns.length;i++) {   
				colors = dg.getStyle("themeColor");   
				if(dg.columns.toArray()[i].dataField == null || dg.columns.toArray()[i].dataField == ""){}else{ //表示不是操作列
					if(dg.columns.toArray()[i].headerText != undefined) {   
						str+="<th "+style+">"+dg.columns.toArray()[i].headerText+"</th>";   
					} else {   
						str+= "<th "+style+">"+dg.columns.toArray()[i].dataField+"</th>";   
					} 
				}
				
			}   
			str += "</tr></thead><tbody>";   
			colors = dg.getStyle("alternatingRowColors");   
			
			for(var j:int =0;j<dg.dataProvider.length;j++) {                    
				str+="<tr width=\""+Math.ceil(dg.width)+"\">";   
				
				for(var k:int=0; k < dg.columns.length; k++) {   
					
					if(dg.dataProvider.getItemAt(j) != null) {   
						if(dg.columns.toArray()[k].dataField == null || dg.columns.toArray()[k].dataField == ""){}else{   //表示的是字段列
							if(dg.columns.toArray()[k].labelFunction != null) { 
								var dataGridColumn:GridColumn = dg.columns.toArray()[k] as GridColumn ;
								//       str += "<td width=\""+Math.ceil((dg.columns.toArray()[k] as DataGridColumn).width*WIDTHSCALE)+"\" "+style+">"+(dg.columns.toArray()[k] as DataGridColumn).labelFunction(dg.dataProvider.getItemAt(j),dg.columns.toArray()[k].dataField)+"</td>"; 
								str += "<td align='center' width=\""+Math.ceil(dataGridColumn.width*WIDTHSCALE)+"\" "+style+">"+dataGridColumn.labelFunction(dg.dataProvider.getItemAt(j),dataGridColumn)+"</td>";
								//       //"+dg.columns.toArray()[k].labelFunction(dg.dataProvider.getItemAt(j),dg.columns.toArray()[k].dataField)+"
							} else {   
								str += "<td align='center' width=\""+Math.ceil(dg.columns.toArray()[k].width*WIDTHSCALE)+"\" "+style+">"+dg.dataProvider.getItemAt(j)[(dg.columns.toArray()[k] as GridColumn).dataField]+"</td>";   
							}   
						}
					}   
				}   
				str += "</tr>";   
			}   
			str+="</tbody></table>";   
			
			return str;   
		}
		
		
		
		public static function convertDGToHTMLTable(dg:DataGrid,header:String):String {   
			//设置默认的DataGrid样式   
			var font:String = dg.getStyle('fontFamily');   
			var size:String = dg.getStyle('fontSize');   
			var str:String = '';   
			var colors:String = '';   
			var style:String = 'style="font-family:'+font+';font-size:'+size+'pt;"';  
			var style2:String = 'style="font-family:'+font+';font-size:'+size+'pt;vnd.ms-excel.numberformat:@;"';  
			var hcolor:Array;   
			
			//检索DataGrid的 headercolor   
			if(dg.getStyle("headerColor") != undefined) {   
				hcolor = [dg.getStyle("headerColor")];   
			} else {   
				hcolor = dg.getStyle("headerColors");   
			}                  
			
			//   Alert.show(hcolor+"");
			var x :String = "" ;
			if(hcolor == null){
				x = "0x323232" ;
			}else{
				x = Number((hcolor[0])).toString(16);
			}
			//   str+= '<table width="'+dg.width+'" border="1"><thead><tr width="'+dg.width+'" style="background-color:#' +Number((hcolor[0])).toString(16)+'" mce_style="background-color:#' +Number((hcolor[0])).toString(16)+'">';   
			str+= '<table align="center" width="'+dg.width+'" border="1"><thead><tr width="'+dg.width+'" style="background-color:#' +x+'" mce_style="background-color:#' +x+'">';  
			
			//设置tableheader数据(从datagrid的header检索headerText信息)                  
			for(var i:int = 0;i<dg.columns.length;i++) { 
				colors = dg.getStyle("themeColor");   
				if(dg.columns.toArray()[i].dataField == null || dg.columns.toArray()[i].dataField == ""){}else{ //表示不是操作列
					if(dg.columns.toArray()[i].headerText != undefined) {
						str+="<th "+style+">"+dg.columns.toArray()[i].headerText+"</th>";   
					} else {   
						str+= "<th "+style+">"+dg.columns.toArray()[i].dataField+"</th>";   
					} 
				}
				
			}   
			str += "</tr></thead>";   
			colors = dg.getStyle("alternatingRowColors");   
			
			for(var j:int =0;j<dg.dataProvider.length;j++) {                    
				str+="<tr width=\""+Math.ceil(dg.width)+"\">";   
				
				for(var k:int=0; k < dg.columns.length; k++) {   
					
					if(dg.dataProvider.getItemAt(j) != null) {   
						if(dg.columns.toArray()[k].dataField == null || dg.columns.toArray()[k].dataField == ""){
						}else{   //表示的是字段列
							if(dg.columns.toArray()[k].labelFunction != null) { 
								var dataGridColumn:GridColumn = dg.columns.toArray()[k] as GridColumn ;
								//       str += "<td width=\""+Math.ceil((dg.columns.toArray()[k] as DataGridColumn).width*WIDTHSCALE)+"\" "+style+">"+(dg.columns.toArray()[k] as DataGridColumn).labelFunction(dg.dataProvider.getItemAt(j),dg.columns.toArray()[k].dataField)+"</td>"; 
								var obj:Object=dataGridColumn.labelFunction(dg.dataProvider.getItemAt(j),dataGridColumn);
								if(obj!=null)
								{
									str += "<td align='center' width=\""+Math.ceil(dataGridColumn.width*WIDTHSCALE)+"\" "+style+">"+obj+"</td>";
								}else
								{
									str += "<td align='center' width=\""+Math.ceil(dg.columns.toArray()[k].width*WIDTHSCALE)+"\" "+style+">暂无数据</td>";  
								}
								//       //"+dg.columns.toArray()[k].labelFunction(dg.dataProvider.getItemAt(j),dg.columns.toArray()[k].dataField)+"
							} else {   
								var dataStr:String=dg.dataProvider.getItemAt(j)[(dg.columns.toArray()[k] as GridColumn).dataField]+"";
								
								if(StringUtil.trim(dataStr)!="null")
								{
									if(StringUtil.trim(dataStr).length>=7)
									{
										str += "<td align='center' width=\""+Math.ceil(dg.columns.toArray()[k].width*WIDTHSCALE)+"\" "+style2+">"+dg.dataProvider.getItemAt(j)[(dg.columns.toArray()[k] as GridColumn).dataField]+"</td>";   
									}else
									{								
										str += "<td align='center' width=\""+Math.ceil(dg.columns.toArray()[k].width*WIDTHSCALE)+"\" "+style+">"+dg.dataProvider.getItemAt(j)[(dg.columns.toArray()[k] as GridColumn).dataField]+"</td>";   
									}   
								}else 
								{
									str += "<td align='center' width=\""+Math.ceil(dg.columns.toArray()[k].width*WIDTHSCALE)+"\" "+style+"></td>";  
									
								}
								
							}					
						}
					}   
				}   
				str += "</tr>";   
			}   
			str+="</table>";   
			
			return str;   
		}   
		
		
		/**   
		 * 将制定的DataGrid加载到Excel文件，此方法传入一个htmltable字符串参数到后台Script脚本，然后浏览器给用户提供一个Excel下载   
		 * @author Chenwenfeng   
		 * @params dg 需要导入的数据源DataGrid   
		 * @params url excel文件下载路径   
		 */   
		public static function loadDGInExcel(dg:DataGrid,name:String,url:String):void {   
			
			//设置URLVariables参数变量，动态增加属性htmltable   
			var variables:URLVariables = new URLVariables();    
			variables.htmltable = convertDGToHTMLTable(dg,name);   
			variables.fileName = name;
			
			var u:URLRequest = new URLRequest(url);   
			u.data = variables;   
			u.method = URLRequestMethod.POST;   
			
			navigateToURL(u,"_blank");
			//"_self" 指定当前窗口中的当前帧。    
			//"_blank" 指定一个新窗口。    
			//"_parent" 指定当前帧的父级。    
			//"_top" 指定当前窗口中的顶级帧。   
		}    
	}
}