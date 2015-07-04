package modulOrganizer;

import modulOrganizer.view.Window;
import note.view.NotePanel;

public class organizer {

	private static Window window;
	public static void startWin(Window windows) {
		window = windows;
		Application noteApp = new Application();
		window.addInternalFrame(noteApp.init(new NotePanel()));
	}

}
