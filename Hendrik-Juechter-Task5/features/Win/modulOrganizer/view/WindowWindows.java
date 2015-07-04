package modulOrganizer.view;

import filehandler.FileExport;
import global.Conf;
import global.view.AllIntFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import modulOrganizer.organizer;

public class WindowWindows extends JFrame implements Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desk = new JDesktopPane();
	public WindowWindows() {
		setTitle("ModulOrganizer");
		setSize(800, 600);
		addWindowListener(new WindowWindowsListener());
		
		desk.setLayout(new GridLayout());
		this.add(desk);
		organizer.startWin(this);
		setVisible(true);
	}

	public void addInternalFrame(JInternalFrame frame) {
		desk.add(frame);
	}

	class WindowWindowsListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
			System.exit(0); // VM "killen"
		}
	}

	class ChooserWindowsListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
		}
	}
}
