package assignment2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

public class GUI implements ActionListener {

	private JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton, sortByTypeButton, sortByNameButton, sortByCompletionButton;
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel topButtonsPanel;
	private JPanel tasksPanel;
	private JLabel tasksCompletedLabel;
	private JScrollPane scrollPane;
	private TaskManager taskManager;
	private ButtonEventHandler buttonEventHandler;

	
	public GUI(TaskManager taskManager) {
		this.frame = new JFrame();
		this.taskManager = taskManager;
		this.buttonEventHandler = new ButtonEventHandler(taskManager, this);
	}
	
	public void execute() {
		frame.setTitle("ToDo");
		frame.setBounds(100,100,500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
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
	
	void updateTaskDisplay(java.util.List<Task> taskList) {
	    tasksPanel.removeAll(); // Cear the panel
	    for (Task task : taskList) {
	        tasksPanel.add(task.getGuiComponent());
	    }
	    
	    //Also update the amount of completed tasks label
		tasksCompletedLabel.setText(taskManager.getNumberOfCompletedTasks() + " out of " + taskManager.getNumberOfTasks() + " tasks completed.");

	    
	    tasksPanel.revalidate(); // Update layout
	    tasksPanel.repaint();    // Redraw panel
	}
	

	@Override
	public void actionPerformed(ActionEvent whichButton) {
			this.buttonEventHandler.ButtonAction(whichButton);
			updateTaskDisplay(taskManager.getTaskList());
		}
	
	//Getters for GUI components
	public JButton getNewStudyTaskButton() {
		return newStudyTaskButton;
	}
	
	public JButton getNewHomeTaskButton() {
		return newHomeTaskButton;
	}
	
	public JButton getNewOtherTaskButton() {
		return newOtherTaskButton;
	}
	
	public JButton getSortByTypeButton() {
		return sortByTypeButton;
	}
	
	public JButton getSortByNameButton() {
		return sortByNameButton;
	}
	
	public JButton getSortByCompletionButton() {
		return sortByCompletionButton;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}