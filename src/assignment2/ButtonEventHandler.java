package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

/**
 * Handles all button actions and interacts with TaskManager and GUI.
 */
public class ButtonEventHandler implements ActionListener, TaskListener {

	private TaskManager taskManager;
	private GUI gui;

	private Comparator<Task> compareByType = new compareTaskType();
	private Comparator<Task> compareByCompletion = new compareCompletion();
	private Comparator<Task> compareByName = new compareName();

	public ButtonEventHandler(TaskManager taskManager, GUI gui) {
		this.taskManager = taskManager;
		this.gui = gui;
	}

	/**
	 * Handles button clicks from GUI panels using ActionCommand.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "NEW_STUDY":
			createStudyTask();
			break;
		case "NEW_HOME":
			createHomeTask();
			break;
		case "NEW_OTHER":
			createOtherTask();
			break;
		case "SORT_TYPE":
			sortByType();
			break;
		case "SORT_NAME":
			sortByName();
			break;
		case "SORT_COMPLETION":
			sortByCompletion();
			break;
		}

		// Update GUI after every action
		gui.updateTaskDisplay();
	}

	// Task creation helpers
	private void createStudyTask() {
		Task t = new StudyTask();
		t.setTaskListener(this);
		taskCreated(t);
	}

	private void createHomeTask() {
		Task t = new HomeTask();
		t.setTaskListener(this);
		taskCreated(t);
	}

	private void createOtherTask() {
		Task t = new OtherTask();
		t.setTaskListener(this);
		taskCreated(t);
	}

	// Sorting helpers
	private void sortByType() {
		List<Task> taskList = taskManager.getTaskList();
		Collections.sort(taskList, compareByType);
	}

	private void sortByName() {
		List<Task> taskList = taskManager.getTaskList();
		Collections.sort(taskList, compareByName);
	}

	private void sortByCompletion() {
		List<Task> taskList = taskManager.getTaskList();
		Collections.sort(taskList, compareByCompletion);
	}

	// TaskListener overrides
	@Override
	public void taskCreated(Task t) {
		taskManager.addToTaskList(t);
		taskManager.incrementNumberOfTasks();
		gui.updateTaskDisplay();
	}

	@Override
	public void taskRemoved(Task t) {
		taskManager.removeFromTaskList(t);
		taskManager.decrementNumberOfTasks();
		if (t.isComplete()) {
			taskManager.decrementNumberOfCompletedTasks();
		}
		gui.updateTaskDisplay();
	}

	@Override
	public void taskCompleted(Task t) {
		taskManager.incrementNumberOfCompletedTasks();
		gui.updateTaskDisplay();
	}

	@Override
	public void taskUncompleted(Task t) {
		taskManager.decrementNumberOfCompletedTasks();
		gui.updateTaskDisplay();
	}

	@Override
	public void taskChanged(Task t) {
	}
}