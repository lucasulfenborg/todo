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

	//GUI variables 
	private JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton, sortByTypeButton, sortByNameButton, sortByCompletionButton;
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel topButtonsPanel;
	private JPanel tasksPanel;
	private JLabel tasksCompletedLabel;
	private JScrollPane scrollPane;
	private TaskManager taskManager;
	private ButtonEventHandler buttonEventHandler;

	//Constructor, creates a window and assigns the taskManager to be used (taken from parameter)
	public GUI(TaskManager taskManager) {
		this.frame = new JFrame();
		this.taskManager = taskManager;
		//Make a buttonEventHandler for this GUI that will control actions of buttons
		this.buttonEventHandler = new ButtonEventHandler(taskManager, this);
	}

	//This script sets up the GUI
	public void execute() {
		//Title, size 
		frame.setTitle("ToDo");
		frame.setBounds(100,100,500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		//The mainpanel of the GUI, it has a FlowLayout
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

	//Method for updating the GUI, it takes in a arrayList of tasks
	void updateTaskDisplay(java.util.List<Task> taskList) {
		tasksPanel.removeAll(); 
		for (Task task : taskList) {
			tasksPanel.add(task.getGuiComponent());
		}

		//Also update the amount of completed tasks label
		tasksCompletedLabel.setText(taskManager.getNumberOfCompletedTasks() + " out of " + taskManager.getNumberOfTasks() + " tasks completed.");


		tasksPanel.revalidate(); //Update layout
		tasksPanel.repaint();    //Redraw panel
	}


	//Actions of buttons, send the button that is clicked to the ButtonEventHandlers method "ButtonAction"
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