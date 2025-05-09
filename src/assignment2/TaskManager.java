package assignment2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

import se.his.it401g.todo.Task;

public class TaskManager {
	private int numberOfTasks;
	private int numberOfCompletedTasks;
	private java.util.List<Task> taskList;

	public TaskManager() {
		taskList = new java.util.ArrayList<>();

	}
	
	
	//Getters and setters
	
		
	public int getNumberOfTasks() {
		return numberOfTasks;
	}

	public java.util.List<Task> getTaskList() {
		return taskList;
	}


	public void setTaskList(java.util.List<Task> taskList) {
		this.taskList = taskList;
	}


	public void setNumberOfTasks(int numberOfTasks) {
		this.numberOfTasks = numberOfTasks;
	}

	public int getNumberOfCompletedTasks() {
		return numberOfCompletedTasks;
	}

	public void setNumberOfCompletedTasks(int numberOfCompletedTasks) {
		this.numberOfCompletedTasks = numberOfCompletedTasks;
	}

	//Method for updating the bottom label (number of completed tasks)
	public void updateTasksCompletedLabel(JLabel tasksCompletedLabel) {
		tasksCompletedLabel.setText(numberOfCompletedTasks + " out of " + numberOfTasks + " tasks completed.");		
	}
	
	
}
