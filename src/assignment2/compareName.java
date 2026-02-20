package assignment2;

import java.util.Comparator;

import se.his.it401g.todo.Task;

public class compareName implements Comparator<Task> {
	@Override
	public int compare(Task t1, Task t2) {
		return t1.getText().compareToIgnoreCase(t2.getText());
	}
}