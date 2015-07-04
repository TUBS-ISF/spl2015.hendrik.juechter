package modulOrganizer.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import modulOrganizer.organizer;

public class WindowWindows extends JFrame implements Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JDesktopPane desk = new JDesktopPane();
	public WindowWindows() {
	}
	
	public void addInternalFrame(JInternalFrame frame) {
		desk.add(frame);
	}
}
