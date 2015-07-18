

public aspect Win {
	declare precedence: Win, Linux, Mac;

	after() : call(void MainTask6.start()) {
		MainTask6.callWindowsMethod();
	}
}
