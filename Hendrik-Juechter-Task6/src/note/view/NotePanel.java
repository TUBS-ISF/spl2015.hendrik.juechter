/**
 * 
 */
package note.view; 

//#if Dateiimport
import filehandler.FileImport; 
//#endif
import global.Conf; 
import global.view.InputProvider; 
import global.view.Plugin; 
import global.view.AllIntFrame; 

import java.awt.Dimension; 
import java.awt.GridLayout; 
import java.util.ArrayList; 

import javax.swing.JInternalFrame; 
import javax.swing.JTextArea; 

/**
 * @author Hendrik
 *
 */
public  class  NotePanel  extends AllIntFrame  implements Plugin {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5383817286205350138L;

	
	private InputProvider app;

	
	
	private JTextArea text = new JTextArea();

	

	
	public NotePanel() {
		init();
	}

	

	public String getText() {
		return text.getText();
	}

	

	public void setText(String string) {
		text.setText(string);
	}

	
	
	@Override
	protected void setName() {
		if(Conf.getActualPanel() != Conf.NOTE) {
			Conf.setActualPanel(Conf.NOTE);
		}
	}

	

	public String getApplicationTitle() {
		return "Notizbuch";
	}

	

	public void setApplication(InputProvider application) {
		app = application;
		
	}

	

	@Override
	public ArrayList<String[]> getOutput() {
		ArrayList<String[]> output = new ArrayList<String[]>();
		String[] noteText = getText().split("\n");
		for(String line : noteText) {
			String[] lineText = {line};
			output.add(lineText);
		}
		
		return output;
	}

	

	
	@Override
	public void importData(String pfad) {
		FileImport im = new FileImport();
		ArrayList<String[]>  imTextList = im.read(pfad);
		String imText = "";
		for(String[] line : imTextList) {
			imText = imText + line[0] + "\n";
		}
		text.setText(imText);
	}

	

	public JInternalFrame start() {
		Conf.getInstance().setNote(this);
		this.setSize(new Dimension(200, 300));
		this.setLayout(new GridLayout());
		this.add(text);
		this.setTitle(getApplicationTitle());
		this.setVisible(true);
		
		return this;
	}


}
