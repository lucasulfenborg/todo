package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo implements ActionListener, TaskListener{
	
	JButton newStudyTaskButton, newHomeTaskButton;
	JFrame frame;
	
	public static void main(String[] args) {
		
		//Create an instance of the application and start it
	    ToDo application = new ToDo();

	    application.execute();
	    
	}
	
	private void execute() {
		//Create the window
		frame = new JFrame();
		
		//Configuration of the window: Layout, title, dimensions/size, visibility, make it exitable
		frame.setLayout(new FlowLayout());
		frame.setTitle("ToDo");
		frame.setBounds(100,100,600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create buttons
		newStudyTaskButton = new JButton("New StudyTask");
		newStudyTaskButton.addActionListener(this);
		frame.add(newStudyTaskButton);

		newHomeTaskButton = new JButton("New HomeTask");
		newHomeTaskButton.addActionListener(this);
		frame.add(newHomeTaskButton);
		
	}

	//Actions of buttons
	public void actionPerformed (ActionEvent whichButton) {
		
		if (whichButton.getSource().equals(newStudyTaskButton)) {
			//Action of newStudyTaskButton on click (create a study task button)
			Task task = new StudyTask();
			frame.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
		}
		if (whichButton.getSource().equals(newHomeTaskButton)) {
			//Action of newHomeTaskButton on click (create a home task button)
			Task task = new HomeTask();
			frame.add(task.getGuiComponent());
			//Listen on the remove button for clicks
			task.setTaskListener(this);
			frame.revalidate();
		}
	}
	

	//Action for the remove button on click (remove the button)
	@Override 
	public void taskRemoved(Task t) {
		frame.remove(t.getGuiComponent()); 
        frame.revalidate(); 
        frame.repaint();
        
        
	}
	}
