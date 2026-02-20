package assignment2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GUI {

	private JFrame frame;
	private TaskManager taskManager;
	private ButtonEventHandler buttonHandler;

	private TaskCreationPanel creationPanel;
	private SortPanel sortPanel;
	private TaskListPanel listPanel;

	public GUI(TaskManager taskManager) {
		this.taskManager = taskManager;
		this.buttonHandler = new ButtonEventHandler(taskManager, this); // Handles actions
	}

	public void execute() {
		frame = new JFrame("ToDo");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create panels
		creationPanel = new TaskCreationPanel(buttonHandler);
		sortPanel = new SortPanel(buttonHandler);
		listPanel = new TaskListPanel();

		// Add panels to frame
		frame.add(creationPanel, BorderLayout.NORTH);
		frame.add(sortPanel, BorderLayout.CENTER);
		frame.add(listPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	// Update task display from ButtonEventHandler
	public void updateTaskDisplay() {
		listPanel.updateDisplay(taskManager.getTaskList(), taskManager.getNumberOfCompletedTasks(),
				taskManager.getNumberOfTasks());
	}
}