package com.xyw.sys.custom.component
{
	import flash.events.Event;
	import flash.events.FocusEvent;
	import mx.controls.Alert;
	import mx.controls.DateChooser;
	import mx.controls.DateField;
	import mx.controls.dataGridClasses.DataGridListData;
	import mx.controls.listClasses.BaseListData;
	import mx.controls.listClasses.ListData;
	import mx.core.ClassFactory;
	import mx.core.IFactory;
	import mx.events.CalendarLayoutChangeEvent;
	import mx.events.DropdownEvent;
	import mx.events.FlexEvent;
	import mx.formatters.DateFormatter;
	import mx.logging.Log;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.utils.ObjectUtil;
	
	public class DateTimeField extends DateField
	{
		// using custom data to avoid beeing overwritten
		protected var _cData:Object;
		protected var _cListData:BaseListData;
		protected var _cSelectedDate:Date = null;
		
		// copied vars
		protected var updateDateFiller:Boolean;
		protected var selectedDateSet:Boolean;
		protected var selectedDateChanged:Boolean = false;
		protected var show:Boolean = false;
		private var _timeStampMode:Boolean = true;
		private var _timeStampModeChanged:Boolean;
		private var _dateTimeChooserDropdownFactory:IFactory = new ClassFactory(DateTimeChooser);
		private var _dateChooserDropdownFactory:IFactory = new ClassFactory(DateChooser);
		private var _dropdownFactory:IFactory = new ClassFactory(DateChooser);
		public function DateTimeField()
		{
			super();
			parseFunction = customerParseFunction;
			this.labelFunction = labelDateTime;
			this.addEventListener(DropdownEvent.OPEN, handleDropdown);
			this.addEventListener(DropdownEvent.CLOSE, handleDropdown);
			super.formatString = "YYYY-MM-DD HH";
			super.yearNavigationEnabled = true;
		}
		
		// -------------------------------
		// own functions
		// -------------------------------
		public function set timeStampMode(value:Boolean):void
		{
			value = true;
			_timeStampMode = value;
			_timeStampModeChanged = true;
			if(value)
			{
				dropdownFactory = _dateTimeChooserDropdownFactory;
			}
			else
			{
				dropdownFactory = _dateChooserDropdownFactory;
			}
			invalidateProperties();
			invalidateSize();
		}
		
		public function get timeStampMode():Boolean
		{
			return _timeStampMode;
		}
		protected function handleDropdown(e:DropdownEvent):void
		{
			if (e.type == DropdownEvent.CLOSE)
			{
				// save new date without beeing cropped
				if (ObjectUtil.dateCompare(selectedDate, dropdown.selectedDate) != 0)
				{
					setUpdateDate();
				}
				show = false;
			}
			else
			{
				show = true;
				dateFiller(_cSelectedDate);
			}	
		}
		
		private function setUpdateDate():void
		{
			selectedDate = dropdown.selectedDate;
			updateData();
		}
		
		protected function updateData():void
		{
			// if new date selected, save it to the data-binding variable
			if (data && selectedDate)
			{
				if (listData && listData is DataGridListData)
					data[DataGridListData(listData).dataField] = selectedDate;
				else if (listData is ListData && ListData(listData).labelField in value)
					data[ListData(listData).labelField] = selectedDate;
				else if (value is String)
					data = selectedDate.toString();
				else
					data = value as Date;
			}
		}
		
		// -------------------------------
		// change Label
		// -------------------------------
		protected function numberToTime(value:Number):String
		{
			return (value >= 10) ? String(value) : ("0" + value);
		}
		
		protected function labelDateTime(value:Date):String
		{
			if (value)	
			{
				if(timeStampMode)
				{
					return DateField.dateToString(value, formatString) + " " + numberToTime(value.hours) + ":" + numberToTime(value.minutes) + ":" + numberToTime(value.seconds);
				}
				else
				{
					return DateField.dateToString(value, formatString);
				}
				
			}
			else
			{
				return "";
			}
		}
		
		// -------------------------------
		// overwritten data functions
		// -------------------------------
		
		override public function get data():Object
		{
			return _cData;
		}
		
		override public function set data(value:Object):void
		{
			var newDate:Date;
			
			_cData = value;
			
			if (_cListData && _cListData is DataGridListData)
				newDate = _cData[DataGridListData(_cListData).dataField];
			else if (_cListData is ListData && ListData(_cListData).labelField in _cData)
				newDate = _cData[ListData(_cListData).labelField];
			else if (_cData is String)
				newDate = new Date(Date.parse(data as String));
			else
				newDate = _cData as Date;
			
			if (!selectedDateSet)
			{
				selectedDate = newDate;
				selectedDateSet = false;
			}
			
			dispatchEvent(new FlexEvent(FlexEvent.DATA_CHANGE));
		}
		
		override public function get listData():BaseListData
		{
			return _cListData;
		}
		
		
		override public function set listData(value:BaseListData):void
		{
			_cListData = value;
		}
		
		//----------------------------------
		//  selectedDate
		//----------------------------------
		
		[Bindable("change")]
		[Bindable("valueCommit")]
		[Bindable("selectedDateChanged")]
		[Inspectable(category="General")]
		
		override public function get selectedDate():Date
		{
			return _cSelectedDate;
		}
		
		/**
		 *  @private
		 */
		override public function set selectedDate(value:Date):void
		{
			if (ObjectUtil.dateCompare(_cSelectedDate, value) == 0) 
				return;
			
			selectedDateSet = true;
			_cSelectedDate = value;
			updateDateFiller = true;
			selectedDateChanged = true;
			
			invalidateProperties();
			
			// Trigger bindings to 'selectedData'.
			dispatchEvent(new Event("selectedDateChanged"));
			
			dispatchEvent(new FlexEvent(FlexEvent.VALUE_COMMIT));
		}
		
		
		//--------------------------------------------------------------------------
		//
		//  Overridden methods: UIComponent
		//
		//--------------------------------------------------------------------------
		override protected function commitProperties():void
		{
			super.commitProperties();
			
			if (updateDateFiller)
			{
				updateDateFiller = false;
				dateFiller(_cSelectedDate);
			}
			
			if (selectedDateChanged)
			{
				selectedDateChanged = false;
				dropdown.selectedDate = _cSelectedDate;
			}
			if(_timeStampModeChanged)
			{
				_timeStampModeChanged = false;
				this.dispatchEvent(new Event(Event.REMOVED_FROM_STAGE));
				var editable:Boolean = textInput.editable;
				super.createChildren();
				this.yearNavigationEnabled = this.yearNavigationEnabled;
				textInput.editable = editable;
			}
		}
		
		//--------------------------------------------------------------------------
		//
		//  Methods
		//
		//--------------------------------------------------------------------------
		private function dateFiller(value:Date):void
		{
			if (labelFunction != null)
				textInput.text = labelFunction(value);
			else
				textInput.text = dateToString(value, formatString);
		}
		
		//--------------------------------------------------------------------------
		//
		//  Event handlers
		//
		//--------------------------------------------------------------------------
		override protected function downArrowButton_buttonDownHandler(event:FlexEvent):void
		{
			if (show)
			{
				close();
			}
			else 
			{
				if(text == "")
				{
					selectedDate = new Date();
					dropdown.selectedDate = selectedDate;
				}
				open();
			}
			dateFiller(_cSelectedDate);
		}
		
		//----------------------------------
		//  dropdownFactory // Overwrite, to include the own DateTimeChooser class
		//----------------------------------
		
		[Bindable("dropdownFactoryChanged")]
		override public function get dropdownFactory():IFactory
		{
			return _dropdownFactory;
		}
		
		override public function set dropdownFactory(value:IFactory):void
		{
			_dropdownFactory = value;
			dispatchEvent(new Event("dropdownFactoryChanged"));
		}
		
		// -------------------------------
		// Remove focus handler
		// -------------------------------
		override protected function focusOutHandler(event:FocusEvent):void
		{
			setActualDate();
		}
		
		override protected function textInput_changeHandler(event:Event):void
		{
			super.textInput_changeHandler(event);
			setActualDate();
		}
		
		private function setActualDate():void
		{
			if(text == "")
			{
				selectedDate = null;
			}
			else
			{
				var inputDate:Date = customerParseFunction(text);
				text = labelDateTime(inputDate);
				selectedDate = inputDate;
			}
		}
		
		override public function open():void
		{
			selectedDate = DateFormatter.parseDateString(text);
			super.open();
		}
		
		private function customerParseFunction(text:String,format:String = null):Date
		{
			var date:Date = DateFormatter.parseDateString(text);
			if(date && (date.fullYear >9999 || date.fullYear < 1000))
			{
				date = null;
			}
			return date;
		}
	}
}