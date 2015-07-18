
public aspect Dateiimport {
	declare precedence: Basis, Dateiimport, Dateiexport;

	after() : call(void WindowWindows.initMenu()) {
		WindowWindows.addImportItem();
	}
}