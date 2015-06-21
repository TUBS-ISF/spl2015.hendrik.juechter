package modulOrganizer;

import modulOrganizer.view.WindowWindows;
import note.view.NotePanel;
import calculator.view.CalcPanel;

public class organizer {

	private static WindowWindows window;
	public static void startWin(WindowWindows windows) {
		window = windows;
		//#if Taschenrechner
			Application calcApp = new Application();
			window.addInternalFrame(calcApp.init(new CalcPanel()));
		//#endif
		Application noteApp = new Application();
		window.addInternalFrame(noteApp.init(new NotePanel()));
	}

}
