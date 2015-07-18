
public aspect Addition {
	before() : call(void CalcPanel.initButtons()) {
		CalcPanel.addAddButton();
	}
}