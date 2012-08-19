package com.scholarify.client;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.form.fields.SectionItem;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.Image;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.form.fields.FileItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.ViewFileItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;

import com.smartgwt.client.types.ListGridFieldType;import com.smartgwt.client.types.Alignment;  
import com.smartgwt.client.types.ListGridEditEvent;  
import com.smartgwt.client.types.ListGridFieldType;  
import com.smartgwt.client.types.RowEndEditAction;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.IButton;  
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler;  
import com.smartgwt.client.widgets.grid.CellFormatter;  
import com.smartgwt.client.widgets.grid.ListGrid;  
import com.smartgwt.client.widgets.grid.ListGridField;  
import com.smartgwt.client.widgets.grid.ListGridRecord;
//sort out irrelevant libraries

public class Company_Profile extends Canvas {

	public Company_Profile() {
		
		DynamicForm companyInfo = new DynamicForm();
		companyInfo.setSize("100%", "100%");
		
		
			Canvas speeches_canvas = new Canvas();  
		
				final ListGrid speeches_grid = new ListGrid();
				speeches_grid.setSize("100%", "80%");
			
					ListGridField speeches_title = new ListGridField("speeches_title", "Title");

					ListGridField speeches_file = new ListGridField("speeches_file", "Video");
					speeches_file.setType(ListGridFieldType.LINK); //type = video UPLOAD or LINK
			
				speeches_grid.setFields(new ListGridField[] { speeches_title, speeches_file});

				speeches_grid.setAutoFetchData(true);  
				speeches_grid.setCanEdit(true);  
				speeches_grid.setEditEvent(ListGridEditEvent.CLICK);  
				speeches_grid.setListEndEditAction(RowEndEditAction.NEXT);  
			speeches_canvas.addChild(speeches_grid);

				IButton add_speech_button = new IButton("New Speech");  
				add_speech_button.addClickHandler(new ClickHandler() {  
				public void onClick(ClickEvent event) {  
					speeches_grid.startEditingNew();  
				}  
				});  
			speeches_canvas.addChild(add_speech_button);
			speeches_canvas.draw();  	
			
			CanvasItem speeches_canItem = new CanvasItem("speeches_canItem", "Speeches");
			speeches_canItem.setCanvas(speeches_canvas);
		
		companyInfo.setFields(new FormItem[] { new ViewFileItem("company_logo", "Company Logo"), new TextItem("contact", "Contact Person"), new TextItem("company_phone", "Phone"), new TextItem("company_name", "Company"), new TextItem("company_mail", "E-Mail"), new TextItem("address", "Address"), new TextItem("city", "City"), new TextItem("state", "State"), new TextItem("zip", "ZIP"), new TextItem("country", "Country"), new TextItem("homepage", "Website"), new TextAreaItem("company_description", "Company Description"), new TextAreaItem("recruiting_needs", "Recruiting Needs"), speeches_canItem});
		addChild(companyInfo);
		
	}
}
