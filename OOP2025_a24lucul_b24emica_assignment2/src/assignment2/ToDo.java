package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo implements ActionListener, TaskListener{
	
	//Global JSWING components, accessible everywhere in the program
	JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton;
	JFrame frame;
	JPanel mainPanel;
	JPanel createTasksPanel;
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
		frame.setBounds(100,100,500,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
		
		//Group create buttons in a panel
		createTasksPanel = new JPanel();
		createTasksPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//createTasksPanel.setSize(new Dimension(100, 100));
        createTasksPanel.setPreferredSize(new Dimension(450, 50));


		//Create buttons for making new tasks
		newStudyTaskButton = new JButton("New Study Task");
		newStudyTaskButton.addActionListener(this);
		createTasksPanel.add(newStudyTaskButton);
		
		newHomeTaskButton = new JButton("New Home Task");
		newHomeTaskButton.addActionListener(this);
		createTasksPanel.add(newHomeTaskButton);
		
		newOtherTaskButton = new JButton("New Other Task");
		newOtherTaskButton.addActionListener(this);
		createTasksPanel.add(newOtherTaskButton);
		
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
		mainPanel.add(createTasksPanel);
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
			
			updateTasksCompletedLabel();

		}
		
		if (whichButton.getSource().equals(newOtherTaskButton)) {
			//Action of newHomeTaskButton on click (create a home task button)
			Task task = new OtherTask();
			tasksPanel.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
			numberOfTasks++;
			
			updateTasksCompletedLabel();

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
	
}
	
	
