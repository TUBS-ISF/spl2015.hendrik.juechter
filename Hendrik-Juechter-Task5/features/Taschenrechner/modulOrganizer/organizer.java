package modulOrganizer;

import modulOrganizer.view.Window;
import note.view.NotePanel;
import calculator.view.CalcPanel;

public class organizer {

	private static Window window;
	public static void startWin(Window windows) {
		window = windows;
		Application calcApp = new Application();
		window.addInternalFrame(calcApp.init(new CalcPanel()));
		Application noteApp = new Application();
		window.addInternalFrame(noteApp.init(new NotePanel()));
	}

}
