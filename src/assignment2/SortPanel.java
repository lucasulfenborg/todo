package assignment2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class SortPanel extends JPanel {

	private JButton sortByTypeButton, sortByNameButton, sortByCompletionButton;

	public SortPanel(ActionListener handler) {
		setLayout(new FlowLayout());

		sortByTypeButton = new JButton("Sort by Type");
		sortByTypeButton.setActionCommand("SORT_TYPE");
		sortByTypeButton.addActionListener(handler);
		add(sortByTypeButton);

		sortByNameButton = new JButton("Sort by Name");
		sortByNameButton.setActionCommand("SORT_NAME");
		sortByNameButton.addActionListener(handler);
		add(sortByNameButton);

		sortByCompletionButton = new JButton("Sort by Uncompleted");
		sortByCompletionButton.setActionCommand("SORT_COMPLETION");
		sortByCompletionButton.addActionListener(handler);
		add(sortByCompletionButton);
	}
}