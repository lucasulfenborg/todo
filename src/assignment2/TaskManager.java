package assignment2;
import se.his.it401g.todo.Task;

//This class handles the task logic, 
public class TaskManager  {
	//Keep track of number of tasks
	private int numberOfTasks;
	//Keep track of completed tasks
	private int numberOfCompletedTasks;
	//Array list that will contain the tasks
	private java.util.List<Task> taskList;

	//Here is the constructor which creates the tasklist once a taskmanager is instantiated
	public TaskManager() {
		//An array list for holding the tasks
		taskList = new java.util.ArrayList<>();

	}

	//Getters and setters for using the taskmanager from other classes
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
