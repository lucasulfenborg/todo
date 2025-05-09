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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;

public class GUI implements ActionListener {

	private JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton, sortByTypeButton, sortByNameButton, sortByCompletionButton;
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel topButtonsPanel;
	private JPanel tasksPanel;
	private JLabel tasksCompletedLabel;
	private JScrollPane scrollPane;
	private TaskManager taskManager;
	
	
	public JButton getNewStudyTaskButton() {
		return newStudyTaskButton;
	}



	public void setNewStudyTaskButton(JButton newStudyTaskButton) {
		this.newStudyTaskButton = newStudyTaskButton;
	}



	public JButton getNewHomeTaskButton() {
		return newHomeTaskButton;
	}



	public void setNewHomeTaskButton(JButton newHomeTaskButton) {
		this.newHomeTaskButton = newHomeTaskButton;
	}



	public JButton getNewOtherTaskButton() {
		return newOtherTaskButton;
	}



	public void setNewOtherTaskButton(JButton newOtherTaskButton) {
		this.newOtherTaskButton = newOtherTaskButton;
	}



	public JButton getSortByTypeButton() {
		return sortByTypeButton;
	}



	public void setSortByTypeButton(JButton sortByTypeButton) {
		this.sortByTypeButton = sortByTypeButton;
	}



	public JButton getSortByNameButton() {
		return sortByNameButton;
	}



	public void setSortByNameButton(JButton sortByNameButton) {
		this.sortByNameButton = sortByNameButton;
	}



	public JButton getSortByCompletionButton() {
		return sortByCompletionButton;
	}



	public void setSortByCompletionButton(JButton sortByCompletionButton) {
		this.sortByCompletionButton = sortByCompletionButton;
	}



	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



	public JPanel getMainPanel() {
		return mainPanel;
	}



	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}



	public JPanel getTopButtonsPanel() {
		return topButtonsPanel;
	}



	public void setTopButtonsPanel(JPanel topButtonsPanel) {
		this.topButtonsPanel = topButtonsPanel;
	}



	public JPanel getTasksPanel() {
		return tasksPanel;
	}



	public void setTasksPanel(JPanel tasksPanel) {
		this.tasksPanel = tasksPanel;
	}



	public JLabel getTasksCompletedLabel() {
		return tasksCompletedLabel;
	}



	public void setTasksCompletedLabel(JLabel tasksCompletedLabel) {
		this.tasksCompletedLabel = tasksCompletedLabel;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public GUI() {
		this.frame = new JFrame();
		this.taskManager = new TaskManager();
		
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
	
	private void updateTaskDisplay(java.util.List<Task> taskList) {
	    tasksPanel.removeAll(); // Clear the panel
	    for (Task task : taskList) {
	        tasksPanel.add(task.getGuiComponent()); // Re-add in sorted order
	    }
	    tasksPanel.revalidate(); // Update layout
	    tasksPanel.repaint();    // Redraw panel
	}
	
	//Method for updating the bottom label (number of completed tasks)
	public void updateTasksCompletedLabel() {
		tasksCompletedLabel.setText(taskManager.getNumberOfCompletedTasks() + " out of " + taskManager.getNumberOfTasks() + " tasks completed.");
		
	}



	@Override
	public void actionPerformed(ActionEvent whichButton) {
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
		    Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::getTaskType, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay(taskManager.getTaskList());
		}
		else if (whichButton.getSource().equals(sortByCompletionButton)) {
		    Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::isComplete));
		    updateTaskDisplay(taskManager.getTaskList());
		}
		
		else if (whichButton.getSource().equals(sortByNameButton)) {
			Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::getText, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay(taskManager.getTaskList());
		}
		
	}
	}
	
	
	

