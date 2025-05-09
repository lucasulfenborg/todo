package assignment2;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;

public class HomeTaskFactory {	
	public Task createTask() {
		return new HomeTask();
	}	
}
