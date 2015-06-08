package modulOrganizer.view;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowLinux extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowLinux() {
		setTitle("ModulOrganizer"); 
		setSize(800, 600); 
		addWindowListener(new WindowLinuxListener());							// werden kann)
		setVisible(true);
	}

	class WindowLinuxListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
			System.exit(0); // VM "killen"
		}
	}
}
