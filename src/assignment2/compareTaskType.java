package assignment2;

import java.util.Comparator;

import se.his.it401g.todo.Task;

public class compareTaskType implements Comparator<Task> {
	@Override
	public int compare(Task t1, Task t2) {
		// 3 types of tasks
		// #1HomeTask, #2StudyTask, #3OtherTask
		int t1INT;
		int t2INT;
		if (t1.getTaskType().equals("Home")) {
			t1INT = 1;
		} else if (t1.getTaskType().equals("Study")) {
			t1INT = 2;
		}

		else {
			t1INT = 3;
		}
		if (t2.getTaskType().equals("Home")) {
			t2INT = 1;
		} else if (t2.getTaskType().equals("Study")) {
			t2INT = 2;
		}

		else {
			t2INT = 3;
		}

		// Compare the integer values
		if (t1INT < t2INT) {
			return -1;
		}
		if (t1INT > t2INT) {
			return 1;
		}

		return 0;
	}
}