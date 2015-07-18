public aspect Mac {
	after() : call(void Main.start()) {
		Main.callMacMethod();
	}
}
