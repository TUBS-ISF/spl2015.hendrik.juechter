
public aspect Dateiexport {
	after() : call(void WindowWindows.initMenu()) {
		WindowWindows.addExportItem();
	}
}