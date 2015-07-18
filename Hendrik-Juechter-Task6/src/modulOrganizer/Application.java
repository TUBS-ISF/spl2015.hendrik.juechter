package modulOrganizer; 

import global.view.InputProvider; 
import global.view.Plugin; 

import javax.swing.JInternalFrame; 

public  class  Application  implements InputProvider {
	

	private Plugin plugin;

	

	public Application() {
		
	}

	

	public JInternalFrame init(Plugin p){
		this.plugin = p;
		p.setApplication(this);
		return plugin.start();
	}

	
	public String getInput() {
		// TODO Auto-generated method stub
		return plugin.getText();
	}


}
