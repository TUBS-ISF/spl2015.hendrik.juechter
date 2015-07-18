
public aspect Notizbuch {
	after() : call(void organizer.init()) {
		organizer.initNote();
	}
}