package assignment2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class TaskCreationPanel extends JPanel {

	private JButton newStudyTaskButton, newHomeTaskButton, newOtherTaskButton;

	public TaskCreationPanel(ActionListener handler) {
		setLayout(new FlowLayout());

		// Buttons
		newStudyTaskButton = new JButton("New Study Task");
		newStudyTaskButton.setActionCommand("NEW_STUDY");
		newStudyTaskButton.addActionListener(handler);
		add(newStudyTaskButton);

		newHomeTaskButton = new JButton("New Home Task");
		newHomeTaskButton.setActionCommand("NEW_HOME");
		newHomeTaskButton.addActionListener(handler);
		add(newHomeTaskButton);

		newOtherTaskButton = new JButton("New Other Task");
		newOtherTaskButton.setActionCommand("NEW_OTHER");
		newOtherTaskButton.addActionListener(handler);
		add(newOtherTaskButton);
	}
}