package modulOrganizer;

import java.awt.Frame;

import calculator.view.calcPanel;

public class organizer {

	private static Frame window;

	public static void start(Frame windows) {
		//#if Taschenrechner
			window = windows;
			calcPanel calc = calcPanel.getInstance();
			window.add(calc);
		//#endif
			
	}

}
