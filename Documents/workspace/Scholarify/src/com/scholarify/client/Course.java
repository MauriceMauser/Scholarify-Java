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


public class Course extends Canvas {

	public Course() {
		
		TabSet course_navigation = new TabSet();
		course_navigation.setTabBarPosition(Side.LEFT);
		
			Tab course_outline = new Tab("Outline");
			
				VLayout co_vLayout = new VLayout();
				co_vLayout.setWidth100();
				co_vLayout.setHeight100();
			
					HLayout co_hLayout = new HLayout();
					co_hLayout.setHeight("60%");
					co_hLayout.setWidth100();
			
						Canvas intro_video = new Canvas();
						intro_video.setWidth("70%");
						intro_video.setHeight100();
					co_hLayout.addMember(intro_video);
					
						DynamicForm course_objectives = new DynamicForm();
						course_objectives.setWidth("30%");
						course_objectives.setHeight100();
						TextAreaItem objectives_txt = new TextAreaItem("course_objectives", "Course Objectives");
						objectives_txt.setDisabled(true);
						objectives_txt.setValue("Here you'll find the objectives of the course...");
						objectives_txt.setTextAlign(Alignment.CENTER);
						objectives_txt.setVAlign(VerticalAlignment.CENTER);
						objectives_txt.setAlign(Alignment.CENTER);
						objectives_txt.setShowTitle(true);
						
						CanvasItem enroll_canvas = new CanvasItem("enroll_canvas", "Enroll");
						
							IButton enroll_button = new IButton("Enroll");
						enroll_canvas.setCanvas(enroll_button);
						course_objectives.setFields(new FormItem[] { objectives_txt, enroll_canvas});
					co_hLayout.addMember(course_objectives);						
				co_vLayout.addMember(co_hLayout);
				
					HLayout co_hLayout_bottom = new HLayout();
					co_hLayout_bottom.setHeight("60%");
					co_hLayout_bottom.setWidth100();
						
						Image company_logo = new Image((String) null);
					co_hLayout_bottom.addMember(company_logo);
		
						DynamicForm company_info = new DynamicForm();
						company_info.setSize("100%", "75%");
						company_info.setHeight100();
							TextAreaItem companyInfo_txt = new TextAreaItem("companyInfo_txt", "Company"); //replace title "company" with real company name
							companyInfo_txt.setShowTitle(true);
							companyInfo_txt.setDisabled(true);
						company_info.setFields(new FormItem[] { companyInfo_txt});
					co_hLayout_bottom.addMember(company_info);
					
						DynamicForm course_syllabus = new DynamicForm();
						course_syllabus.setSize("55%", "85%");
						course_syllabus.setHeight100();
							TextAreaItem syllabus_txt = new TextAreaItem("syllabus_txt", "Syllabus"); //aggregate from course unit titles
							syllabus_txt.setShowTitle(true);
							syllabus_txt.setDisabled(true);
						course_syllabus.setFields(new FormItem[] { syllabus_txt});
					co_hLayout_bottom.addMember(course_syllabus);
				co_vLayout.addMember(co_hLayout_bottom);
			course_outline.setPane(co_vLayout);
		course_navigation.addTab(course_outline);
		
			Tab course_resources = new Tab("Resources");
			///
				Canvas resource_canvas = new Canvas();
				resource_canvas.setSize("100%", "100%");		
				
					ListGrid resource_grid = new ListGrid();
					resource_grid.setSize("100%", "80%");
				
						ListGridField resource_file = new ListGridField("resource_file", "File");
						//TASK: file type can be upload or link
				
						ListGridField resource_name = new ListGridField("resource_name", "Resource");
				
						resource_grid.setFields(new ListGridField[] { resource_name, resource_file});
			
					resource_grid.setAutoFetchData(true);  
					resource_grid.setCanEdit(false);  
				resource_canvas.addChild(resource_grid);
	        	resource_canvas.draw();		
			course_resources.setPane(resource_canvas);
		course_navigation.addTab(course_resources);
		
			Tab course_lectures = new Tab("Lectures");
				HLayout cl_hLayout = new HLayout();
				cl_hLayout.setHeight100();
		
					VLayout cl_vLayout = new VLayout();
					cl_vLayout.setWidth("426px");
					cl_vLayout.setHeight100();
					
		
						Canvas content_video = new Canvas();
						content_video.setWidth100();
						content_video.setHeight100();
						content_video.setContents("<!---<iframe width=\"420\" height=\"315\" src=\"http://www.youtube.com/embed/D1R-jKKp3NA\" frameborder=\"0\" allowfullscreen></iframe>---!>");
					cl_vLayout.addMember(content_video);
		
						DynamicForm lecture_instruction = new DynamicForm();
						lecture_instruction.setWidth100();
						lecture_instruction.setHeight100();
						TextAreaItem instruction_txt = new TextAreaItem("lecture_instructions", "Instructions");
						instruction_txt.setDisabled(true);
						instruction_txt.setShowTitle(true);
						lecture_instruction.setFields(new FormItem[] { instruction_txt});	
					cl_vLayout.addMember(lecture_instruction);
				cl_hLayout.addMember(cl_vLayout);
		
					SectionStack lecture_menu = new SectionStack();
					lecture_menu.setSize("141px", "414px");
		
						SectionStackSection lecture_unit = new SectionStackSection("Unit");
						lecture_unit.setName("sctUnit");
						
							ListGrid unit_videos = new ListGrid();
							unit_videos.setShowHeader(false); 
								
								ListGridField video_title = new ListGridField("video_title", "Title");
									
								ListGridField task_question = new ListGridField("task_question", "Question");
								
								ListGridField task_answer = new ListGridField("task_answer", "Answer");
						
							unit_videos.setFields(new ListGridField[] { video_title, task_question, task_answer});
						lecture_unit.addItem(unit_videos);
					lecture_menu.addSection(lecture_unit);
					
						SectionStackSection assignment_section = new SectionStackSection("Problem Set");
						assignment_section.setName("sctAssignment");
						
							ListGrid assignment_videos = new ListGrid();
							assignment_videos.setShowHeader(false); 
						
								ListGridField assignment_title = new ListGridField("assignment_title", "Title");
						
								ListGridField aTask_question = new ListGridField("aTask_question", "Question");
						
								ListGridField aTask_answer = new ListGridField("aTask_answer", "Answer");
				
							assignment_videos.setFields(new ListGridField[] { assignment_title, aTask_question, aTask_answer});
					lecture_menu.addSection(assignment_section);
				cl_hLayout.addMember(lecture_menu);
			course_lectures.setPane(cl_hLayout);
		course_navigation.addTab(course_lectures);
		
			Tab course_forum = new Tab("Forum");
		course_navigation.addTab(course_forum);
		
			Tab course_challenge = new Tab("Challenge");
		
				VLayout cc_vLayout = new VLayout();
					Canvas challenge_video = new Canvas();
					challenge_video.setSize("442px", "250px");
				cc_vLayout.addMember(challenge_video);
		
					DynamicForm submitProject_form = new DynamicForm();
					submitProject_form.setWidth("442px");
					SubmitItem submitItem = new SubmitItem();
					submitItem.setTitle("Submit");
					submitItem.setName("submitProjectFiles");
					submitProject_form.setFields(new FormItem[] { new UploadItem("projectUpload", "Project Files"), submitItem});
				cc_vLayout.addMember(submitProject_form);
				
					HLayout cc_hLayout = new HLayout();
					
						DynamicForm challenge_intructions = new DynamicForm();
						challenge_intructions.setWidth("50%");
						TextAreaItem cInstruction_txt = new TextAreaItem("projectDefinition", "Problem Definition");
						cInstruction_txt.setDisabled(true);
						challenge_intructions.setFields(new FormItem[] { cInstruction_txt});
					cc_hLayout.addMember(challenge_intructions);
					
						DynamicForm challenge_submission = new DynamicForm();
						challenge_submission.setWidth("50%");
						TextAreaItem cSubmission_txt = new TextAreaItem("submissionDetails", "Submission Details");
						cSubmission_txt.setDisabled(true);
						challenge_submission.setFields(new FormItem[] { cSubmission_txt});
					cc_hLayout.addMember(challenge_submission);						
				cc_vLayout.addMember(cc_hLayout);
			course_challenge.setPane(cc_vLayout);
		course_navigation.addTab(course_challenge);
		//TabSet tabSet = new TabSet();
		//tabSet.setTabBarPosition(Side.LEFT);
		addChild(course_navigation);
		course_navigation.setRect(6, 6, 639, 422);

	}
}
