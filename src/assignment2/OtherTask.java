package assignment2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;
import se.his.it401g.todo.TaskInputListener;




/**
 * Implements a simple other task type, following the Task.java interface class.
 *  
 * This file licensed under the <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC) BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public class OtherTask extends JPanel implements Task {

	/**
	 * The editable text field. 
	 */
	private JTextField text;

	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;

	/**
	 * Check box holding the completion status. 
	 */
	JCheckBox completed = new JCheckBox();

	/**
	 * The task listener used for reporting changes to the main application. 
	 */
	private TaskListener listener;

	//Textfield and label for duedate
	private JTextField dueDateField;
	private JLabel dueDateLabel;




	/**
	 * This is the constructor for the task, initiating the GUI component for the task. Several listeners are used to react to various events in the GUI.  
	 */
	public OtherTask() {
		super(new BorderLayout());
		this.text = new JTextField("New task",20);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);

		JPanel center = new JPanel();
		center.add(text);
		center.add(textLabel);
		add(center);

		//due date input field and labels
		this.dueDateField = new JTextField("", 5);
		this.dueDateLabel = new JLabel("Due date:");
		center.add(dueDateLabel);
		center.add(dueDateField);

		add(center);

		TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
		this.text.addKeyListener(inputListener);
		this.textLabel.addMouseListener(inputListener);

		JButton remove = new JButton("Remove");
		add(remove,BorderLayout.EAST);
		remove.addActionListener(inputListener);

		add(completed,BorderLayout.WEST);
		completed.addItemListener(inputListener);

		setMaximumSize(new Dimension(1000,50));
		setBorder(new TitledBorder(getTaskType()));
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public String getTaskType() {
		return "Other";
	}

	@Override
	public void setTaskListener(TaskListener t) {
		listener = t;		
	}

	@Override
	public TaskListener getTaskListener() {
		return listener;
	}

	@Override
	public boolean isComplete() {
		return completed.isSelected();
	}

	@Override
	public Component getGuiComponent() {
		// Since this class extends JPanel, it is itself a GUI component, and thus we can return "this". 
		return this;
	}

}
