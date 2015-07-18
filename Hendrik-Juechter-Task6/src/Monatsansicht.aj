
public aspect Monatsansicht {
	after() : call(void CalenderPanel.initView()) {
		CalenderPanel.initMonthView();
	}
}