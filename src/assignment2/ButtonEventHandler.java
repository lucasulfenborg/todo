package assignment2;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

//This class handles actions of buttons. It interacts with both the GUI and the Task manager 
public class ButtonEventHandler implements TaskListener {
	private TaskManager taskManager;
	private GUI gui;

	public ButtonEventHandler(TaskManager taskManager, GUI gui) {
		this.taskManager = taskManager;
		this.gui = gui;

	}

	//Method triggered from clicking buttons on the GUI. It does actions based on which button has been clicked.
	void ButtonAction(ActionEvent whichButton) {
		//First 3 buttons are for creating different types of tasks
		if (whichButton.getSource().equals(gui.getNewStudyTaskButton())) {
			Task t = new StudyTask();
			t.setTaskListener(this);
			taskCreated(t);
		}

		else if (whichButton.getSource().equals(gui.getNewHomeTaskButton())) {
			Task t = new HomeTask();
			t.setTaskListener(this);
			taskCreated(t);
		}

		else if (whichButton.getSource().equals(gui.getNewOtherTaskButton())) {
			Task t = new OtherTask();
			t.setTaskListener(this);
			taskCreated(t);
		}

		//
		//Sorting by type of the task
		else if (whichButton.getSource().equals(gui.getSortByTypeButton())) {
			Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::getTaskType, String.CASE_INSENSITIVE_ORDER));
		}

		//Sort by uncompleted tasks
		else if (whichButton.getSource().equals(gui.getSortByCompletionButton())) {
			Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::isComplete));
		}

		//Sort by the name of the task
		else if (whichButton.getSource().equals(gui.getSortByNameButton())) {
			Collections.sort(taskManager.getTaskList(), Comparator.comparing(Task::getText, String.CASE_INSENSITIVE_ORDER));
		}

	}


	//When a task is created, send it to the task manager and update the GUI
	@Override
	public void taskCreated(Task t) {
		taskManager.addToTaskList(t);
		taskManager.incrementNumberOfTasks();
		gui.updateTaskDisplay(taskManager.getTaskList());
	}

	//When a task is removed
	@Override
	public void taskRemoved(Task t) {
		taskManager.removeFromTaskList(t);
		taskManager.decrementNumberOfTasks();
		if(t.isComplete()) {
			taskManager.decrementNumberOfCompletedTasks();
		}
		gui.updateTaskDisplay(taskManager.getTaskList());
	}

	//Overwrite taskcompleted and taskuncompleted to make it possible to track the number of completed tasks
	@Override
	public void taskCompleted(Task t) {
		taskManager.incrementNumberOfCompletedTasks();
		gui.updateTaskDisplay(taskManager.getTaskList());
	}

	@Override
	public void taskUncompleted(Task t) {
		taskManager.decrementNumberOfCompletedTasks();
		gui.updateTaskDisplay(taskManager.getTaskList());
	}

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub

	}
}
