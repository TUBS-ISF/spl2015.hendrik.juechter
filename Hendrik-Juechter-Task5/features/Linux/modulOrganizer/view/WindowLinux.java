package modulOrganizer.view;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		setTitle("ModulOrganizer"); 
		setSize(800, 600); 
		addWindowListener(new WindowLinuxListener());							// werden kann)
		setVisible(true);
		desk.setLayout(new GridLayout());
		this.add(desk);
	}

	public void addInternalFrame(JInternalFrame frame) {
		desk.add(frame);
	}
	class WindowLinuxListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
			System.exit(0); // VM "killen"
		}
	}
}
