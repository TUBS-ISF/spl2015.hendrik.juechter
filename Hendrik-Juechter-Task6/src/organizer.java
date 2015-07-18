 
import modulOrganizer.Application;
import modulOrganizer.view.Window; 
import note.view.NotePanel; 

public   class  organizer {
	

	private static Window window  ;

	

	public static void startWin(Window windows) {
		window = windows;
		init();
	}

	

	private static void init() {
		// TODO Auto-generated method stub
		
	}



	public static void initCal  () {
		Application calApp = new Application();
		window.addInternalFrame(calApp.init(new CalenderPanel()));
	}

	

	
	public static void initCalc  () {
		Application calcApp = new Application();
		window.addInternalFrame(calcApp.init(new CalcPanel()));
	}

	

	
	public static void initNote  () {
		Application noteApp = new Application();
		window.addInternalFrame(noteApp.init(new NotePanel()));
	}


}
