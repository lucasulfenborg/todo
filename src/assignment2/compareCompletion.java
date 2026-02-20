package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

public class compareCompletion implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		// Not complete first
		if (t1.isComplete() && !t2.isComplete()) {
			return 1;
		} else if (!t1.isComplete() && t2.isComplete()) {
			return -1;
		} else {
			return 0;
		}
	}
}
