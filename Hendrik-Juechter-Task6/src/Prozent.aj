
public aspect Prozent {
	after() : call(void CalcPanel.initButtons()) {
		CalcPanel.addProzentButton();
	}
}