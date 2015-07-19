public aspect Mac {
	after() : call(void MainTask6.start()) {
		MainTask6.callMacMethod();
	}
}
