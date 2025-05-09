package assignment2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

public class TaskManager  {
	private int numberOfTasks;
	private int numberOfCompletedTasks;
	//Array list that will contain the tasks
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

	public void addToTaskList(Task t) {
		this.taskList.add(t);
	}
	
	public void removeFromTaskList(Task t) {
		this.taskList.remove(t);
	}

	public void incrementNumberOfTasks() {
		this.numberOfTasks++;
	}
	
	public void decrementNumberOfTasks() {
		this.numberOfTasks--;
	}

	public int getNumberOfCompletedTasks() {
		return numberOfCompletedTasks;
	}

	public void incrementNumberOfCompletedTasks() {
		this.numberOfCompletedTasks++;
	}
	
	public void decrementNumberOfCompletedTasks() {
		this.numberOfCompletedTasks--;
	}	
}
