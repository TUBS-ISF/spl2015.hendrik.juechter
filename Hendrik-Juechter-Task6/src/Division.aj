
public aspect Division {
	after() : call(void CalcPanel.initButtons()) {
		CalcPanel.addDivButton();
	}
}