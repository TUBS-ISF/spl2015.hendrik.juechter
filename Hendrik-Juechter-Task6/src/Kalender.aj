
public aspect Kalender {
	after() : call(void organizer.init()) {
		organizer.initCal();
	}
}