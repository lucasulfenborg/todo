package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import se.his.it401g.todo.*;


public class ToDo implements ActionListener, TaskListener{
	
	//Global JSWING components, accessible everywhere in the program
	//Arraylist for storing the tasks
	java.util.List<Task> taskList = new java.util.ArrayList<>();
	
	JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton, sortByTypeButton, sortByNameButton, sortByCompletionButton;
	JFrame frame;
	JPanel mainPanel;
	JPanel topButtonsPanel;
	JPanel tasksPanel;
	JLabel tasksCompletedLabel;
	JScrollPane scrollPane;
	//Global variables (for tracking the total number of tasks and number of completed tasks)
	int numberOfTasks;
	int numberOfCompletedTasks;
	
	public static void main(String[] args) {
		
		//Create an instance of the application and start it
	    ToDo application = new ToDo();

	    application.execute();
	    
	}
	
	private void execute() {
		
		//Keep track of how many tasks and completed tasks there are (starting at 0, 0)
		numberOfTasks = 0;
		numberOfCompletedTasks = 0;
		
		//Create the window
		frame = new JFrame();
		
		//Configuration of the window: Layout, title, dimensions/size, visibility, make it exitable
		//frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
		frame.setTitle("ToDo");
		frame.setBounds(100,100,500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
		
		//Group create buttons in a panel
		topButtonsPanel = new JPanel();
		topButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topButtonsPanel.setPreferredSize(new Dimension(450, 70));


		//Create buttons for making new tasks
		newStudyTaskButton = new JButton("New Study Task");
		newStudyTaskButton.addActionListener(this);
		topButtonsPanel.add(newStudyTaskButton);
		
		newHomeTaskButton = new JButton("New Home Task");
		newHomeTaskButton.addActionListener(this);
		topButtonsPanel.add(newHomeTaskButton);
		
		newOtherTaskButton = new JButton("New Other Task");
		newOtherTaskButton.addActionListener(this);
		topButtonsPanel.add(newOtherTaskButton);
		
		//Sort tasks buttons
		sortByTypeButton = new JButton("Sort by type");
		sortByTypeButton.addActionListener(this);
		topButtonsPanel.add(sortByTypeButton);
		
		sortByNameButton = new JButton("Sort by name");
		sortByNameButton.addActionListener(this);
		topButtonsPanel.add(sortByNameButton);
		
		sortByCompletionButton = new JButton("Sort by Uncompleted");
		sortByCompletionButton.addActionListener(this);
		topButtonsPanel.add(sortByCompletionButton);
		
		
		//Group tasks in a panel
		tasksPanel = new JPanel();
		tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));
		//tasksPanel.setPreferredSize(new Dimension(500, 200));
		
		 // Wrap tasksPanel inside a JScrollPane to make it scrollable
        scrollPane = new JScrollPane(tasksPanel);
        scrollPane.setPreferredSize(new Dimension(500, 200));

		
		//Panel with the tasks completed text
		tasksCompletedLabel = new JLabel("You haven't created any tasks yet.");
		
		
		
		//Add all panels to the window
		frame.add(mainPanel);
		mainPanel.add(topButtonsPanel);
		mainPanel.add(scrollPane);
		mainPanel.add(tasksCompletedLabel);


		frame.setVisible(true);


	}

	//Actions of buttons
	public void actionPerformed (ActionEvent whichButton) {
		
		if (whichButton.getSource().equals(newStudyTaskButton)) {
			//Action of newStudyTaskButton on click (create a study task button)
			Task task = new StudyTask();
			tasksPanel.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
			numberOfTasks++;
			taskList.add(task);
			
			updateTasksCompletedLabel();

		}
		if (whichButton.getSource().equals(newHomeTaskButton)) {
			//Action of newHomeTaskButton on click (create a home task button)
			Task task = new HomeTask();
			tasksPanel.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
			numberOfTasks++;
			taskList.add(task);
			
			updateTasksCompletedLabel();

		}
		
		else if (whichButton.getSource().equals(newOtherTaskButton)) {
			//Action of newHomeTaskButton on click (create a home task button)
			Task task = new OtherTask();
			tasksPanel.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
			numberOfTasks++;
			taskList.add(task);
			
			updateTasksCompletedLabel();

		}
		
		else if (whichButton.getSource().equals(sortByTypeButton)) {
		    Collections.sort(taskList, Comparator.comparing(Task::getTaskType, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay();
		}
		else if (whichButton.getSource().equals(sortByCompletionButton)) {
		    Collections.sort(taskList, Comparator.comparing(Task::isComplete));
		    updateTaskDisplay();
		}
		
		else if (whichButton.getSource().equals(sortByNameButton)) {
			Collections.sort(taskList, Comparator.comparing(Task::getText, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay();
		}
		}

	//Action for the remove button on click (remove the button). Taken and overwritten from superclass.
	@Override 
	public void taskRemoved(Task t) {
		tasksPanel.remove(t.getGuiComponent()); 
        frame.revalidate(); 
        frame.repaint();
        
        if (t.isComplete()) {
    		numberOfCompletedTasks--;
        }
        
        numberOfTasks--;
        taskList.remove(t);
		updateTasksCompletedLabel();
	}

	//Overwrite taskcompleted and taskuncompleted to make it possible to track the number of completed tasks
	@Override
	public void taskCompleted(Task t) {
		numberOfCompletedTasks++;
		updateTasksCompletedLabel();
	}
	
	@Override
	public void taskUncompleted(Task t) {
		numberOfCompletedTasks--;
		updateTasksCompletedLabel();
	}
	
	//Method for updating the bottom label (number of completed tasks)
	public void updateTasksCompletedLabel() {
		tasksCompletedLabel.setText(numberOfCompletedTasks + " out of " + numberOfTasks + " tasks completed.");
		
	}
	
	private void updateTaskDisplay() {
	    tasksPanel.removeAll(); // Clear the panel
	    for (Task task : taskList) {
	        tasksPanel.add(task.getGuiComponent()); // Re-add in sorted order
	    }
	    tasksPanel.revalidate(); // Update layout
	    tasksPanel.repaint();    // Redraw panel
	}
	
}
	
	
