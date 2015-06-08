package modulOrganizer.view;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modulOrganizer.organizer;

public class WindowWindows extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowWindows() {
		setTitle("ModulOrganizer");
		setSize(800, 600);
		addWindowListener(new WindowWindowsListener()); 
		organizer.start(this);
		setVisible(true);
	}

	class WindowWindowsListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
			System.exit(0); // VM "killen"
		}
	}
}
