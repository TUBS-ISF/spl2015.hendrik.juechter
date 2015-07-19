
public aspect Addition {
	after() : call(void CalcPanel.initButtons()) {
		CalcPanel.addAddButton();
		
	}
}