
public aspect Taschenrechner {
		declare precedence: Taschenrechner, Notizbuch, Kalender;

	after() : call(void organizer.init()) {
		organizer.initCalc();
	}
	
}