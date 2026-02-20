package assignment2;

import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.his.it401g.todo.Task;

public class TaskListPanel extends JPanel {

	private JPanel tasksPanel;
	private JScrollPane scrollPane;
	private JLabel tasksCompletedLabel;

	public TaskListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		tasksPanel = new JPanel();
		tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));

		scrollPane = new JScrollPane(tasksPanel);
		scrollPane.setPreferredSize(new Dimension(500, 200));

		tasksCompletedLabel = new JLabel("No tasks yet.");

		add(scrollPane);
		add(tasksCompletedLabel);
	}

	public void updateDisplay(List<Task> taskList, int completed, int total) {
		tasksPanel.removeAll();
		for (Task task : taskList) {
			tasksPanel.add(task.getGuiComponent());
		}
		tasksCompletedLabel.setText(completed + " out of " + total + " tasks completed.");
		tasksPanel.revalidate();
		tasksPanel.repaint();
	}
}