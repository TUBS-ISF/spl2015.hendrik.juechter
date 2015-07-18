
public aspect Linux {
		after() : call(void Main.start()) {
			Main.callLinuxMethod();
		}
	
}
