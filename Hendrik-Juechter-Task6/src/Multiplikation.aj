
public aspect Multiplikation {
	after() : call(void CalcPanel.initButtons()) {
		CalcPanel.addMultButton();
	}
}