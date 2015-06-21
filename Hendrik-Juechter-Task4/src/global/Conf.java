package global;

import note.view.NotePanel;
import calculator.view.CalcPanel;

public class Conf {
	 private static Conf instance;
	  // Verhindere die Erzeugung des Objektes über andere Methoden
	 
	private static int actualPanel = 0;
	public static final int CALC = 1;
	public static final int NOTE = 2;
	private CalcPanel calc;
	private NotePanel note;

	 private Conf () {}
	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
	  // Objekt erzeugt und dieses zurückliefert.
	  public static Conf getInstance () {
	    if (Conf.instance == null) {
	    	Conf.instance = new Conf ();
	    }
	    return Conf.instance;
	  }
	
	/**
	 * @return the actualPanel
	 */
	public static int getActualPanel() {
		return actualPanel;
	}

	/**
	 * @param actualPanel the actualPanel to set
	 */
	public static void setActualPanel(int theActualPanel) {
		actualPanel = theActualPanel;
	}

	/**
	 * @return the calc
	 */
	public CalcPanel getCalc() {
		return calc;
	}

	/**
	 * @param calc the calc to set
	 */
	public void setCalc(CalcPanel calc) {
		this.calc = calc;
	}
	/**
	 * @return the note
	 */
	public NotePanel getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(NotePanel note) {
		this.note = note;
	}
}
