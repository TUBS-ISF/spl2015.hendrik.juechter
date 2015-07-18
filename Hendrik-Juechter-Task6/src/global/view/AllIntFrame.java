/**
 * 
 */
package global.view; 

import java.util.ArrayList; 

import javax.swing.JInternalFrame; 
import javax.swing.event.InternalFrameEvent; 
import javax.swing.event.InternalFrameListener; 

/**
 * @author Hendrik
 *
 */
public abstract  class  AllIntFrame  extends JInternalFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public AllIntFrame() {

	}

	
	
	protected void init(){
		this.addInternalFrameListener(new InternalFrameListener() {
			
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameClosed(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void internalFrameActivated(InternalFrameEvent e) {
				setName();
				
			}
		});
	}

	
	
	protected abstract void setName();

	

	private ArrayList<String[]> output = new ArrayList<String[]>();

	

	public abstract void importData(String pfad);

	

	/**
	 * @return the output
	 */
	public ArrayList<String[]> getOutput() {
		
		return output;
	}

	

	/**
	 * @param output
	 *            the output to add
	 */
	protected void addOutput(ArrayList<String[]> output) {
		this.output.addAll(output);
	}

	

	/**
	 * @param output
	 *            the output to set
	 */
	protected void setOutput(ArrayList<String[]> output) {
		this.output = output;
	}

	
	
	/**
	 * @param output
	 *            the output to add
	 */
	protected void addOutput(String[] output) {
		System.out.println(output[0]);
		this.output.add(output);
	}

	

	/**
	 * @return the input
	 */
	public ArrayList<String[]> getInput() {
		return input;
	}

	

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(ArrayList<String[]> input) {
		this.input = input;
	}

	

	private ArrayList<String[]> input = new ArrayList<String[]>();


}
