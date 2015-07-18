
public aspect Subtraktion {
	before() : call(void CalcPanel.initButtons()) {
		CalcPanel.addSubButton();
	}
}