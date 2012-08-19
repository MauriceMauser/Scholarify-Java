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
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.tile.TileLayout;
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.tile.TileGrid;  
import com.smartgwt.client.widgets.viewer.DetailViewerField; 
//sort out irrelevant libraries

public class CourseFinder extends Canvas {

	public CourseFinder() {
		
		VLayout vLayout = new VLayout();  
        vLayout.setWidth100();  
        vLayout.setMembersMargin(5);  
        vLayout.setLayoutMargin(10);  
        
        	SearchForm searchBox = new SearchForm();   
        	
        		TextItem searchBar = new TextItem("searchBar", "Search");
        	
        	searchBox.setFields(new FormItem[] { searchBar });
       	vLayout.addMember(searchBox);  
       	
       		TileLayout courseTiles = new TileLayout();
       		
       			TileGrid courses_grid = new TileGrid();  
       			courses_grid.setTileWidth(194);  
       			courses_grid.setTileHeight(165);  
       			courses_grid.setHeight(400);  
       			courses_grid.setWidth100();  
       			courses_grid.setCanReorderTiles(true);  
       			courses_grid.setShowAllRecords(true);  
       			//tileGrid.setData(CourseData.getRecords());  
      
       			DetailViewerField pictureField = new DetailViewerField("picture");  
       			pictureField.setType("image");  
       			//pictureField.setImageURLPrefix("courses/");  
       			pictureField.setImageWidth(186);  
       			pictureField.setImageHeight(120);  
      
       			//DetailViewerField titleField = new DetailViewerField("title");  
       			//DetailViewerField companyField = new DetailViewerField("company");
       			
       			//add button to enroll in courses
       		
       	vLayout.addMember(courseTiles);
        		
	}
}
