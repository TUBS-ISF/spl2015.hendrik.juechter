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

public class WindowWindows extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desk = new JDesktopPane();
	public WindowWindows() {
		this.setJMenuBar(this.getMenubar());
	}

	
	protected JMenuBar getMenubar() {
		// Men?leiste anlegen
		JMenuBar menueLeiste = new JMenuBar();
		// Ein Men? anlegen
		
		JMenu datei = new JMenu("Datei");
		//#if Dateiimport
		// Einen Men?eintrag anlegen
		JMenuItem oeffnen = new JMenuItem("Öffnen");
		oeffnen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"TXT & CSV Dateien", "txt", "csv");
				fc.setFileFilter(filter);
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String pfad = fc.getSelectedFile().getAbsolutePath();
					imData(pfad);
				}

			}
		});
		// Den Eintrag dem Men? hinzuf?gen
		datei.add(oeffnen);
		//#endif
		//#if Dateiexport
		JMenuItem speichern = new JMenuItem("Speichern");
		speichern.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"TXT & CSV Dateien", "txt", "csv");
				fc.setFileFilter(filter);
				int returnVal = fc.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String pfad = fc.getSelectedFile().getAbsolutePath();
					exData(pfad);
				}
			}
		});
		// Den Eintrag dem Men? hinzuf?gen
		datei.add(speichern);
		//#endif
		// Das Men? der Leiste hinzuf?gen
		menueLeiste.add(datei);
		return menueLeiste;
	}

	protected void imData(String pfad) {
		switch(Conf.getActualPanel()) {
		case Conf.CALC:
			Conf.getInstance().getCalc().importData(pfad);
			break;
		case Conf.NOTE:
			Conf.getInstance().getNote().importData(pfad);
			break;
		default:
			System.out.println("Bitte Aktion in Fenster ausführen");
			break;
		}
	}
	
	protected void exData(String pfad) {
		FileExport ex = new FileExport();
		switch(Conf.getActualPanel()) {
		case Conf.CALC:
			AllIntFrame cPan = Conf.getInstance().getCalc();
			ex.write(pfad, cPan.getOutput());
			break;
		case Conf.NOTE:
			AllIntFrame nPan = Conf.getInstance().getNote();
			ex.write(pfad, nPan.getOutput());
			break;
		default:
			System.out.println("Bitte Aktion in Fenster ausf?hren");
			break;
		}
	}
}
