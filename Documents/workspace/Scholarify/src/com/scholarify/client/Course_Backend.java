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
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
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
import com.smartgwt.client.widgets.WidgetCanvas;
import com.google.gwt.user.client.ui.TextBox;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ColumnTree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.CanvasItem;  
//TASK: sort out unnecessary libraries

public class Course_Backend extends Canvas {
	public Course_Backend() {
		setSize("100%", "100%");
		
		TabSet courseBE_navigation = new TabSet();
		courseBE_navigation.setSize("100%", "100%");
		
			Tab edit_generalInfo = new Tab("General Information");
			
				DynamicForm generalInfo_form = new DynamicForm();
				generalInfo_form.setSize("100%", "100%");
			
					TextItem title_txt = new TextItem("course_title", "Course Title");
					title_txt.setRequired(true);
					
					TextItem course_instructor = new TextItem("course_instructor", "Instructor");
					title_txt.setRequired(true);
					
					//add keywords as meta information
					TextAreaItem keywords = new TextAreaItem("course_keywords", "Keywords");
					keywords.setRequired(false);
				
					TextItem jobPos_txt = new TextItem("job_position", "Corresponding Job Position");
					jobPos_txt.setRequired(false);
					
					TextAreaItem course_objectives = new TextAreaItem("course_objectives", "Learning Objectives");
					keywords.setRequired(true);
					
					TextAreaItem course_description = new TextAreaItem("course_description", "Course Description");
					keywords.setRequired(true);
					
					//company information will be retrieved from company profile / registration process, not necessarily here
					
					//DateTimeItem course_start = new DateTimeItem("course_start", "Course Start");
					//DateTimeItem course_end = new DateTimeItem("course_end", "Course End");
					//auto generate Course session ID: term1, term2, term3...
					CanvasItem term_canvas = new CanvasItem("term_canvas", "Terms");
				
						final ListGrid course_terms = new ListGrid();
						course_terms.setSize("100%", "120px");
						
							ListGridField term = new ListGridField("term", "Term");
							term.setType(ListGridFieldType.TEXT);
						
							ListGridField course_start = new ListGridField("course_start", "Start");
							course_start.setType(ListGridFieldType.DATE);
							
							ListGridField course_end = new ListGridField("course_end", "End");
							course_end.setType(ListGridFieldType.DATE);
										
						course_terms.setFields(new ListGridField[] { term, course_start, course_end });
				
						course_terms.setAutoFetchData(true);  
						course_terms.setCanEdit(true);  
						course_terms.setEditEvent(ListGridEditEvent.CLICK);  
						course_terms.setListEndEditAction(RowEndEditAction.NEXT);  
						
						IButton newTerm_button = new IButton("New Term");
						newTerm_button.addClickHandler(new ClickHandler() {  
			        		public void onClick(ClickEvent event) {  
			        			course_terms.startEditingNew();  
			        		}  
			        	});  
						term_canvas.setCanvas(newTerm_button);
						
					term_canvas.setCanvas(course_terms);
				generalInfo_form.setFields(new FormItem[] { title_txt, course_instructor, keywords, jobPos_txt, course_objectives, course_description, term_canvas });
			edit_generalInfo.setPane(generalInfo_form);
		courseBE_navigation.addTab(edit_generalInfo);
		
			Tab edit_resources = new Tab("Resources");
			
				Canvas resource_canvas = new Canvas();  
			
					final ListGrid resource_grid = new ListGrid();
					resource_grid.setSize("100%", "80%");
					
						ListGridField resource_file = new ListGridField("resource_file", "File");
						//TASK: file type can be upload or link
						resource_file.setType(ListGridFieldType.LINK);
					
						ListGridField resource_name = new ListGridField("resource_name", "Resource");
					
						ListGridField resource_visible = new ListGridField("resource_visible", "Visible");
						resource_visible.setType(ListGridFieldType.BOOLEAN);
						resource_grid.setFields(new ListGridField[] { resource_name, resource_file, resource_visible});
				
					resource_grid.setAutoFetchData(true);  
					resource_grid.setCanEdit(true);  
					resource_grid.setEditEvent(ListGridEditEvent.CLICK);  
					resource_grid.setListEndEditAction(RowEndEditAction.NEXT);  
				resource_canvas.addChild(resource_grid);
		        
		        	IButton add_resource_button = new IButton("New Resource");  
		        	add_resource_button.setTop(250);  
		        	add_resource_button.addClickHandler(new ClickHandler() {  
		        		public void onClick(ClickEvent event) {  
		        			resource_grid.startEditingNew();  
		        		}  
		        	});  
		        resource_canvas.addChild(add_resource_button);
		        resource_canvas.draw();  
			edit_resources.setPane(resource_canvas);
		courseBE_navigation.addTab(edit_resources);
			
			Tab edit_lectures = new Tab("Lectures");
			
				ColumnTree contentTree = new ColumnTree();
				contentTree.setWidth100();  
		        contentTree.setHeight(205); 
		        contentTree.setShowHeaders(true);
		        //contentTree.setAutoFetchData(true);  
		        //contentTree.setNodeIcon("icons/16/person.png");  
		        //contentTree.setFolderIcon("icons/16/person.png");  
		        //contentTree.setShowOpenIcons(false);  
		        //contentTree.setShowDropIcons(false);  
		        //contentTree.setClosedIconSuffix("");
		        //contentTree.setShowNodeCount(true);          
		        //contentTree.setLoadDataOnDemand(false);  
		        
		        //3 Columns:
		        //(1) Edit units:
		        //   	- Title: text
		        // 	  +Add unit
		        //				(2) Edit sessions:
		        //						- Title: text
		        //						- Video: Video Upload
		        //						- Task Type: Dropdown [ None (default), Multiple Choice, Programming ]
		        //					+Add session
		        //								(3) Edit tasks (if Task Type != None):
		        //									- Question: Upload [ Video OR TextFile ]
		        //									- Task: IF Multiple choice -> Grid: Answer 1: text, checkbox, Answer 2: text, checkbox, Answer 3: text, checkbox, Answer 4: text, checkbox
		        //											IF Programming -> Code: Upload Textfile, Testcases: Upload Textfile
		        //									- Answer: Upload [ Video OR TextFile ]
		        //
		        
					TreeGridField units_treeField = new TreeGridField("course_units", "Units");
					units_treeField.setFrozen(true);
		
					TreeGridField videos_treeField = new TreeGridField("videos_treeField", "Video Lectures");
					
					TreeGridField tasks_treeField = new TreeGridField("tasks_treeField", "Tasks");
				
				contentTree.setFields(new ListGridField[] { units_treeField, videos_treeField, tasks_treeField});		        
		        contentTree.draw();
				
			edit_lectures.setPane(contentTree);
		
		courseBE_navigation.addTab(edit_lectures);
			
			Tab edit_assignments = new Tab("Assignments");
			
				Canvas assignment_canvas = new Canvas();  
			
					final ListGrid assignment_grid = new ListGrid();
					assignment_grid.setSize("100%", "80%");
			
						ListGridField assignment_title = new ListGridField("assignment_title", "Title");
						
						ListGridField assignment_dueDate = new ListGridField("assignment_dueDate", "Due Date");
						assignment_dueDate.setType(ListGridFieldType.DATE);

						ListGridField assignmentTerm = new ListGridField("assignmentTerm", "Term");
						assignmentTerm.setType(ListGridFieldType.TEXT); //dropdown: select term (default: term matching due date)
						
						ListGridField assignment_qFile = new ListGridField("assignment_qFile", "Question Part");
						assignment_qFile.setType(ListGridFieldType.LINK); //type = Video UPLOAD
						
						//Programming Task
						ListGridField assignment_tFile = new ListGridField("assignment_tFile", "Task Upload");
						assignment_qFile.setType(ListGridFieldType.TEXT); //type = code text UPLOAD
						
						ListGridField assignment_sFile = new ListGridField("assignment_sFile", "Solution Upload");
						assignment_qFile.setType(ListGridFieldType.TEXT); //type = code text UPLOAD
						
						//OR Multiple Choice Task: create 4 possible solutions, check the correct ones
					
						ListGridField assignment_aFile = new ListGridField("assignment_aFile", "Answer Part");
						assignment_aFile.setType(ListGridFieldType.LINK); //type = Video UPLOAD
								
					assignment_grid.setFields(new ListGridField[] { assignment_title, assignment_dueDate, assignmentTerm, assignment_qFile, assignment_tFile, assignment_sFile, assignment_aFile});
		
					assignment_grid.setAutoFetchData(true);  
					assignment_grid.setCanEdit(true);  
					assignment_grid.setEditEvent(ListGridEditEvent.CLICK);  
					assignment_grid.setListEndEditAction(RowEndEditAction.NEXT);  
				assignment_canvas.addChild(assignment_grid);
        
					IButton add_assignment_button = new IButton("New Assignment");  
					add_assignment_button.setTop(250);  
					add_assignment_button.addClickHandler(new ClickHandler() {  
					public void onClick(ClickEvent event) {  
						assignment_grid.startEditingNew();  
					}  
					});  
        		assignment_canvas.addChild(add_assignment_button);
        		assignment_canvas.draw();  
        	edit_assignments.setPane(assignment_canvas);
			//select to which term the assignment belongs
		courseBE_navigation.addTab(edit_assignments);
			
			//speeches shifted to company profile
		
			Tab edit_QnA = new Tab("Q&A");
				Canvas qna_canvas = new Canvas();  
			
					final ListGrid qna_grid = new ListGrid();
					qna_grid.setSize("100%", "80%");
						
						ListGridField qna_title = new ListGridField("qna_title", "Title");
			
						ListGridField qna_file = new ListGridField("qna_file", "Video");
						qna_file.setType(ListGridFieldType.LINK); //type = video UPLOAD or LINK
						
						ListGridField qna_date = new ListGridField("qna_date", "Date");
						qna_date.setType(ListGridFieldType.DATE);
					qna_grid.setFields(new ListGridField[] { qna_title, qna_file, qna_date});
		
					qna_grid.setAutoFetchData(true);  
					qna_grid.setCanEdit(true);  
					qna_grid.setEditEvent(ListGridEditEvent.CLICK);  
					qna_grid.setListEndEditAction(RowEndEditAction.NEXT);  
				qna_canvas.addChild(qna_grid);
        
					IButton add_qna_button = new IButton("New Speech");  
					add_qna_button.addClickHandler(new ClickHandler() {  
						public void onClick(ClickEvent event) {  
							qna_grid.startEditingNew();  
						}  
					});  
					qna_canvas.addChild(add_qna_button);
					qna_canvas.draw();  
				edit_QnA.setPane(qna_canvas);
		courseBE_navigation.addTab(edit_QnA);
			
			Tab edit_challenges = new Tab("Challenges");
			
				Canvas challenge_canvas = new Canvas();  
			
					final ListGrid challenge_grid = new ListGrid();
					challenge_grid.setSize("100%", "80%");
	
						ListGridField challenge_title = new ListGridField("challenge_title", "Title");
				
						ListGridField challenge_dueDate = new ListGridField("challenge_dueDate", "Due Date");
						challenge_dueDate.setType(ListGridFieldType.DATE);

						ListGridField challengeTerm = new ListGridField("challengeTerm", "Term");
						challengeTerm.setType(ListGridFieldType.TEXT); //dropdown: select term (default: term matching due date)
				
						ListGridField challenge_video = new ListGridField("challenge_video", "Problem Definition");
						challenge_video.setType(ListGridFieldType.LINK); //type = Video UPLOAD
				
						ListGridField challenge_instructions = new ListGridField("challenge_instructions", "Instruction");
						challenge_instructions.setType(ListGridFieldType.TEXT); //type = UPLOAD text file
						
					challenge_grid.setFields(new ListGridField[] { challenge_title, challenge_dueDate, challengeTerm, challenge_video, challenge_instructions});

					challenge_grid.setAutoFetchData(true);  
					challenge_grid.setCanEdit(true);  
					challenge_grid.setEditEvent(ListGridEditEvent.CLICK);  
					challenge_grid.setListEndEditAction(RowEndEditAction.NEXT);  
				challenge_canvas.addChild(challenge_grid);

				IButton add_challenge_button = new IButton("New Challenge");  
				add_challenge_button.addClickHandler(new ClickHandler() {  
				public void onClick(ClickEvent event) {  
					challenge_grid.startEditingNew();  
				}  
				});  
				challenge_canvas.addChild(add_challenge_button);
				challenge_canvas.draw();  
			edit_challenges.setPane(challenge_canvas);
		courseBE_navigation.addTab(edit_challenges);
		
		addChild(courseBE_navigation);
		
	}
}
