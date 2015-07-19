
public aspect Subtraktion {
	after() : call(void CalcPanel.initButtons()) {
		CalcPanel.addSubButton();
	}
}