package global; 

import global.view.AllIntFrame; 

public  class  Conf {
	
	 private static Conf instance;

	
	  // Verhindere die Erzeugung des Objektes über andere Methoden
	 
	private static int actualPanel = 0;

	
	private AllIntFrame[] panel = new AllIntFrame[4];

	

	public static final int CALC = 1;

	
	public static final int NOTE = 2;

	
	public static final int CAL = 3;

	

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
	public AllIntFrame getCalc() {
		return panel[CALC];
	}

	

	/**
	 * @param calc the calc to set
	 */
	public void setCalc(AllIntFrame calc) {
		this.panel[CALC] = calc;
	}

	
	
	/**
	 * @return the note
	 */
	public AllIntFrame getNote() {
		return panel[NOTE];
	}

	
	/**
	 * @param note the note to set
	 */
	public void setNote(AllIntFrame note) {
		this.panel[NOTE] = note;
	}

		
	
	/**
	 * 
	 * @return the calender
	 */
	public AllIntFrame getCalender() {
		return panel[CAL];
	}

	
	
	public void setCalender(AllIntFrame cal) {
		this.panel[CAL] = cal;
	}


}
