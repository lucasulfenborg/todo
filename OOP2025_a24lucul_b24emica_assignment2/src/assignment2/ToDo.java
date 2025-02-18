package assignment2;

import javax.swing.JFrame;

public class ToDo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		Task task = new HomeTask();
		frame.add(task.getGuiComponent());
		
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
