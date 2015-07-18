
import modulOrganizer.view.WindowLinux; 

public  class  MainTask6 {
	

	public static void main(String[] args) {
		new MainTask6().start();
		//#if Win
//@		callWindowsMethod();
		//#elif Linux
//@        callLinuxMethod();
		//#elif Mac
//@        callMacMethod();
		//#endif

	}

	public void start() {
		
	}

	private static void log() {
		// TODO Auto-generated method stub
		
	}

	

	public static void callWindowsMethod() {
		WindowWindows window = new WindowWindows();
	}

	

	public static void callLinuxMethod() {
		WindowLinux window = new WindowLinux();
	}

	
	
	public static void callMacMethod() {
		//not ready jet
		callLinuxMethod();
	}


}
