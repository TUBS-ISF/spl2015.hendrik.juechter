package global;

import modulOrganizer.view.WindowLinux;
import modulOrganizer.view.WindowWindows;

public class Main {

	public static void main(String[] args) {
		
		if(Conf.Logging) {
			log();
		}
		if(Conf.Windows) {
			callWindowsMethod();
		} else if(Conf.Linux) {
			callLinuxMethod();
		} else {
			throw new RuntimeException();
		}
			
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

}
