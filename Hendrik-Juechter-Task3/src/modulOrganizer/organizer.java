package modulOrganizer;

import java.awt.Frame;

import calculator.view.calcPanel;
import global.Conf;

public class organizer {

	private static Frame window;

	public static void start(Frame windows) {
		//#if Taschenrechner
			window = windows;
			window.add(new calcPanel());
		//#endif
	}

}
