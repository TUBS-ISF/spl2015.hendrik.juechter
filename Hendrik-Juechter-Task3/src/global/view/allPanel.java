/**
 * 
 */
package global.view;

import java.awt.Panel;
import java.util.ArrayList;

/**
 * @author Hendrik
 *
 */
public abstract class allPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 *            the output to set
	 */
	protected void addOutput(ArrayList<String[]> output) {
		this.output.addAll(output);
	}

	/**
	 * @param output
	 *            the output to set
	 */
	protected void addOutput(String[] output) {
		System.out.println(output[0]);
		this.output.add(output);
	}

	/**
	 * @return the input
	 */
	protected ArrayList<String[]> getInput() {
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
