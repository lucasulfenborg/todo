package assignment2;

public class ToDo {

	public static void main(String[] args) {
		ToDo application = new ToDo();
		application.execute();
	}

	private void execute() {
		GUI gui = new GUI(new TaskManager());
		gui.execute();
	}
}
