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
//sort out irrelevant libraries

public class Profile extends Canvas {

	public Profile() {
		
			DynamicForm studentInfo = new DynamicForm();
			studentInfo.setSize("100%", "100%");
		
				UploadItem resume_upload = new UploadItem("resume_upload", "Upload CV");
			
				Canvas badge_canvas = new Canvas();
					CanvasItem badges = new CanvasItem("badges", "Badges");
				badges.setCanvas(badge_canvas);
			
				BooleanItem isScholar = new BooleanItem();
				isScholar.setDisabled(true);
				isScholar.setValue(false);
				isScholar.setName("isScholar");
				isScholar.setTitle("Scholar Rank");
			studentInfo.setFields(new FormItem[] { new ViewFileItem("profile_pic", "Profile Picture"), resume_upload, new TextItem("student_name", "Name"), new TextItem("student_mail", "E-Mail"), new SelectItem("gender", "Gender"), new DateTimeItem("birthday", "Birthday"), new TextItem("city", "City"), new TextItem("state", "State"), new TextItem("country", "Country"), new TextItem("homepage", "Website"), new TextAreaItem("education", "Education"), new TextAreaItem("experience", "Experience"), badges, isScholar});
		addChild(studentInfo);
		
	}
}
