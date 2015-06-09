package modulOrganizer.view;

import filehandler.FileExport;
import global.Conf;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modulOrganizer.organizer;
import calculator.view.calcPanel;

public class WindowWindows extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowWindows() {
		setTitle("ModulOrganizer");
		setSize(800, 600);
		addWindowListener(new WindowWindowsListener());
		//#if Basis
		this.setMenuBar(this.getMenubar());
		//#endif
		organizer.start(this);
		setVisible(true);
	}

	protected MenuBar getMenubar() {
		// Men?leiste anlegen
		MenuBar menueLeiste = new MenuBar();
		// Ein Men? anlegen
		
		Menu datei = new Menu("Datei");
		//#if Dateiimport
		// Einen Men?eintrag anlegen
		MenuItem oeffnen = new MenuItem("?ffnen");
		oeffnen.addActionListener(new ActionListener() {

			@Override
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
		MenuItem speichern = new MenuItem("Speichern");
		speichern.addActionListener(new ActionListener() {

			@Override
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

		// Noch ein Men? anlegen
		Menu extra = new Menu("Extras");
		// ... und noch ein Men?
		Menu schriftart = new Menu("Schriftart");
		// ...das Men? dem Extramen? als Untermen? hinzuf?gen
		extra.add(schriftart);
		// Das Untermen? mit Eintr?gen f?llen
		schriftart.add("Sans");
		schriftart.add("Sans Serif");
		schriftart.addSeparator();
		schriftart.add("Courier");
		// Das Extramen? der Leiste hinzuf?gen
		menueLeiste.add(extra);
		return menueLeiste;
	}

	protected void imData(String pfad) {
		switch(Conf.getActualPanel()) {
		case "calc":
			calcPanel pan = calcPanel.getInstance();
			
			pan.importData(pfad);
			break;
		default:
			System.out.println("Bitte Aktion in Fenster ausf?hren");
			break;
		}
	}
	
	protected void exData(String pfad) {
		switch(Conf.getActualPanel()) {
		case "calc":
			calcPanel pan = calcPanel.getInstance();
			FileExport ex = new FileExport();
			
			ex.write(pfad, pan.getOutput());
			break;
		default:
			System.out.println("Bitte Aktion in Fenster ausf?hren");
			break;
		}
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
