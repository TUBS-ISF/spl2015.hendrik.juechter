package global;

import modulOrganizer.view.WindowLinux;
import modulOrganizer.view.WindowWindows;

public class Main {

	public static void main(String[] args) {
		//#if Win
		callWindowsMethod();
		//#elif Linux
//@        callLinuxMethod();
		//#elif Mac
//@        callMacMethod();
		//#endif

	}

	private static void log() {
		// TODO Auto-generated method stub
		
	}

	private static void callWindowsMethod() {
		WindowWindows window = new WindowWindows();
	}

	private static void callLinuxMethod() {
		WindowLinux window = new WindowLinux();
	}
	
	private static void callMacMethod() {
		//not ready jet
		callLinuxMethod();
	}

}
