package global.view;

import javax.swing.JInternalFrame;

public interface Plugin {
	String getApplicationTitle();

	void setApplication(InputProvider app);
	
	JInternalFrame start();
	
	String getText();
}
