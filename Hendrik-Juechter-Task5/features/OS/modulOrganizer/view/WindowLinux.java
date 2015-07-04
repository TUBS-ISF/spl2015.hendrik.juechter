package modulOrganizer.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class WindowLinux extends JFrame implements Window{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JDesktopPane desk = new JDesktopPane();
	public WindowLinux() {
	}
	public void addInternalFrame(JInternalFrame frame) {
		desk.add(frame);
	}
}
