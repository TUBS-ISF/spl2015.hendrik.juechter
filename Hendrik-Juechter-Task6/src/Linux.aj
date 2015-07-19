
public aspect Linux {
		after() : call(void MainTask6.start()) {
			MainTask6.callLinuxMethod();
		}
	
}
