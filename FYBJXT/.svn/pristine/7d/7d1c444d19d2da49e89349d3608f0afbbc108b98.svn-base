package com.xyw.sys.custom.itemrenderer
{
	import com.xyw.sys.custom.component.CustomCheckBoxExtendedWithButton;
	import com.xyw.sys.custom.component.CustomCheckBoxTree;
	import com.xyw.sys.custom.component.CustomCheckBoxTreeListData;
	
	import flash.events.MouseEvent;
	
	import mx.controls.treeClasses.TreeItemRenderer;
	import mx.core.mx_internal;
	import mx.events.TreeEvent;
		
		use namespace mx_internal;
		
		public class CustomCheckBoxTreeItemRender extends TreeItemRenderer
		{
			
			protected var _checkbox:CustomCheckBoxExtendedWithButton;
			protected var _listOwner:CustomCheckBoxTree;
			
			public function CustomCheckBoxTreeItemRender( )
			{
				super( );
			}
			
			private function onCheckboxClick( event: MouseEvent ): void
			{
				if( _listOwner.isBranch( this.data ) && checkBox.middle )
				{
					checkBox.middle = false;
					checkBox.selected = !checkBox.selected;
				}
				_listOwner.dispatchEvent( new TreeEvent( "itemCheck", false, false, data, this ) );
			}
			
			override protected function createChildren( ): void
			{
				super.createChildren( );
				if( !_checkbox )
				{
					_checkbox = new CustomCheckBoxExtendedWithButton( );
					_checkbox.allow3StateForUser = false;
					_checkbox.addEventListener( MouseEvent.CLICK, onCheckboxClick );
					addChild( _checkbox );
				}
			}
			
			override protected function measure():void
			{
				super.measure();
				
				var w:Number = data ? ( listData as CustomCheckBoxTreeListData ).indent : 0;
				
				if ( disclosureIcon )
					w += disclosureIcon.width;
				
				if ( icon )
					w += icon.measuredWidth;
				
				if ( label.width < 4 || label.height < 4 )
				{
					label.width  = 4;
					label.height = 16;
				}
				
				if ( isNaN( explicitWidth ) )
				{
					w += label.getExplicitOrMeasuredWidth( );
					w += _checkbox.getExplicitOrMeasuredWidth( );	
					measuredWidth  = w;
					measuredHeight = Math.max( _checkbox.getExplicitOrMeasuredHeight( ), label.getExplicitOrMeasuredHeight( ) );
				}
				else
				{
					label.width = Math.max(explicitWidth - ( w + _checkbox.getExplicitOrMeasuredWidth( ) ), 4 );
					measuredHeight = Math.max( _checkbox.getExplicitOrMeasuredHeight( ), label.getExplicitOrMeasuredHeight( ) );
					
					if ( icon && icon.measuredHeight > measuredHeight )
						measuredHeight = icon.measuredHeight;
				}
			}
			
			override protected function commitProperties( ): void
			{
				super.commitProperties( );
				
				if( data != null )
				{
					_listOwner = ( listData.owner as CustomCheckBoxTree );
					_checkbox.middle   = ( listData as CustomCheckBoxTreeListData ).checkedState == 2;
					_checkbox.selected = ( listData as CustomCheckBoxTreeListData ).checkedState > 0;
				}
			}
			
			override protected function updateDisplayList( unscaledWidth: Number, unscaledHeight: Number ): void
			{
				super.updateDisplayList( unscaledWidth, unscaledHeight );
				
				var startx: Number = data ? ( listData as CustomCheckBoxTreeListData ).indent : 0;
				
				if ( disclosureIcon )
				{
					disclosureIcon.x = startx;
					startx = disclosureIcon.x + disclosureIcon.width;
					disclosureIcon.setActualSize( disclosureIcon.width, disclosureIcon.height );
					disclosureIcon.visible = data ? ( listData as CustomCheckBoxTreeListData ).hasChildren : false;
				}
				
				if ( icon )
				{
					icon.x = startx;
					startx = icon.x + icon.measuredWidth;
					icon.setActualSize(icon.measuredWidth, icon.measuredHeight);
				}
				
				if( checkBox )
				{
					_checkbox.x = startx;
					startx = checkBox.x + checkBox.measuredWidth;
					checkBox.setActualSize( checkBox.measuredWidth, checkBox.measuredHeight );
				}
				
				label.x = startx;
				label.setActualSize( unscaledWidth - startx, measuredHeight );
				
				var verticalAlign:String = getStyle("verticalAlign");
				
				if (verticalAlign == "top")
				{
					label.y = 0;
					_checkbox.y = 0;
					
					if ( icon )
						icon.y = 0;
					if ( disclosureIcon )
						disclosureIcon.y = 0;
				} else if ( verticalAlign == "bottom")
				{
					label.y = unscaledHeight - label.height + 2; // 2 for gutter
					_checkbox.y = unscaledHeight - checkBox.height + 2; // 2 for gutter
					if ( icon )
						icon.y = unscaledHeight - icon.height;
					if ( disclosureIcon )
						disclosureIcon.y = unscaledHeight - disclosureIcon.height;
				} else
				{
					label.y    = ( unscaledHeight - label.height ) / 2;
					checkBox.y = ( unscaledHeight - checkBox.height ) / 2;
					if ( icon )
						icon.y = ( unscaledHeight - icon.height ) / 2;
					if ( disclosureIcon )
						disclosureIcon.y = ( unscaledHeight - disclosureIcon.height ) / 2;
				}
			}		
			
			public function get checkBox( ):CustomCheckBoxExtendedWithButton
			{
				return _checkbox;
			}
		}
}