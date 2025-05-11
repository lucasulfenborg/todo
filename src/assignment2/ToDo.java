package assignment2;

public class ToDo {

	public static void main(String[] args) {
		//Create an instance of the application and start it
		ToDo application = new ToDo();
		application.execute();
	}

	private void execute() {		
		//Create the todo gui
		GUI gui = new GUI(new TaskManager());
		gui.execute();		
	}
}


