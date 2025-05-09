package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;


public class ToDo implements ActionListener, TaskListener{
	
	public static void main(String[] args) {
		
		//Create an instance of the application and start it
	    ToDo application = new ToDo();

	    application.execute();
	    
	}
	
	private void execute() {
		
		//Keep track of how many tasks and completed tasks there are (starting at 0, 0)
		//numberOfTasks = 0;
		//numberOfCompletedTasks = 0;
		
		//Create the window
		GUI gui = new GUI();
		gui.execute();
		
		TaskManager taskManager= new TaskManager();
		
		
	}
	
	/*
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
	
	
	//Action for the remove button on click (remove the button). Taken and overwritten from superclass.
	@Override 
	public void taskRemoved(Task t) {
		tasksPanel.remove(t.getGuiComponent()); 
        frame.revalidate(); 
        frame.repaint();
        
        if (t.isComplete()) {
    		numberOfCompletedTasks--;
        }
        
        numberOfTasks--;
        taskList.remove(t);
		updateTasksCompletedLabel();
	}

	//Overwrite taskcompleted and taskuncompleted to make it possible to track the number of completed tasks
	@Override
	public void taskCompleted(Task t) {
		numberOfCompletedTasks++;
		updateTasksCompletedLabel();
	}
	
	@Overridedispla
	public void taskUncompleted(Task t) {
		numberOfCompletedTasks--;
		updateTasksCompletedLabel();
	}
	
	//Method for updating the bottom label (number of completed tasks)
	public void updateTasksCompletedLabel() {
		tasksCompletedLabel.setText(numberOfCompletedTasks + " out of " + numberOfTasks + " tasks completed.");
		
	}
	
	private void updateTaskDisplay() {
	    tasksPanel.removeAll(); // Clear the panel
	    for (Task task : taskList) {
	        tasksPanel.add(task.getGuiComponent()); // Re-add in sorted order
	    }
	    tasksPanel.revalidate(); // Update layout
	    tasksPanel.repaint();    // Redraw panel
	}
	*/
}
	
	
