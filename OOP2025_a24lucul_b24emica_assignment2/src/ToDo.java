package assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo implements ActionListener{
	
	JButton newStudyTaskButton, newHomeTaskButton;
	JFrame frame;
	
	public static void main(String[] args) {
		
	    ToDo application = new ToDo();

	    application.execute();
	    
	}
	
	private void execute() {
		// TODO Auto-generated method stub
		//Window container and button component
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setTitle("ToDo");
		
		newStudyTaskButton = new JButton("New StudyTask");
		newStudyTaskButton.addActionListener(this);
		frame.add(newStudyTaskButton);

		
		newHomeTaskButton = new JButton("New HomeTask");
		newHomeTaskButton.addActionListener(this);
		frame.add(newHomeTaskButton);
		
		
		
		
		//Example for creating a studytask
		//Task studyTask = new StudyTask();
		//frame.add(studytask.getGuiComponent());
		
		//Position, dimensions, visibility & make window closeable
		frame.setBounds(100,100,600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Actions of buttons
	public void actionPerformed (ActionEvent whichButton) {
		if (whichButton.getSource().equals(newStudyTaskButton)) {
			Task task = new StudyTask();
			frame.add(task.getGuiComponent());
			frame.revalidate();
		}
		if (whichButton.getSource().equals(newHomeTaskButton)) {
			Task task = new HomeTask();
			frame.add(task.getGuiComponent());
			frame.revalidate();
		}
	}
	
	
}
