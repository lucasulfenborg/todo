package assignment2;

import javax.swing.JFrame;

public class ToDo {

	public static void main(String[] args) {
		//Create a GUI window
		JFrame frame = new JFrame();
		
		Task task = new HomeTask();
		frame.add(task.getGuiComponent());
		
		//Position, dimensions, visibility & make window closeable
		frame.setBounds(100,100,600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
