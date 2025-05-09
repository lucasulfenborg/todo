package assignment2;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.*;

public class ButtonEventHandler {

	
	
	//Actions of buttons
	public void actionPerformed (ActionEvent whichButton) {
		
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
		    Collections.sort(taskList, Comparator.comparing(Task::getTaskType, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay();
		}
		else if (whichButton.getSource().equals(sortByCompletionButton)) {
		    Collections.sort(taskList, Comparator.comparing(Task::isComplete));
		    updateTaskDisplay();
		}
		
		else if (whichButton.getSource().equals(sortByNameButton)) {
			Collections.sort(taskList, Comparator.comparing(Task::getText, String.CASE_INSENSITIVE_ORDER));
		    updateTaskDisplay();
		}
	}
}
