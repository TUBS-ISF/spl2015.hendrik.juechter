package calculator.view;

import filehandler.FileImport;
import global.Conf;
import global.view.allPanel;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import calculator.calc;

public class calcPanel extends allPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static calcPanel instance = new calcPanel();
	private TextField text = new TextField();
	protected boolean hasPoint = false;

	public static calcPanel getInstance() {
		return instance;
	}

	public calcPanel() {
		this.setLayout(new GridLayout(3, 1));
		text.setSize(100, 20);
		this.add(text);
		Panel delButtons = new Panel();
		delButtons.setLayout(new GridLayout(1, 2));
		Button delAllButton = new Button("C");
		delAllButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setText("");

			}
		});
		Button delOneButton = new Button("CE");
		delOneButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setText(getText().substring(0, getText().length() - 1));

			}
		});
		delButtons.add(delOneButton);
		delButtons.add(delAllButton);
		this.add(delButtons);
		Panel buttons = new Panel();
		buttons.setLayout(new GridLayout(4, 4));

		Button sevenB = new Button("7");
		sevenB.addActionListener(new WriteAction());
		buttons.add(sevenB);
		Button eightB = new Button("8");
		eightB.addActionListener(new WriteAction());
		buttons.add(eightB);
		Button nineB = new Button("9");
		nineB.addActionListener(new WriteAction());
		buttons.add(nineB);
		Button plusB = new Button("+");
		//#if Addition
		plusB.addActionListener(new WriteAction());
		//#else
		//@ plusB.setLabel("");
		//@ plusB.setEnabled(false);
		//#endif
		buttons.add(plusB);
		Button fourB = new Button("4");
		fourB.addActionListener(new WriteAction());
		buttons.add(fourB);
		Button fiveB = new Button("5");
		fiveB.addActionListener(new WriteAction());
		buttons.add(fiveB);
		Button sixB = new Button("6");
		sixB.addActionListener(new WriteAction());
		buttons.add(sixB);
		Button minusB = new Button("-");
		minusB.addActionListener(new WriteAction());
		buttons.add(minusB);
		//#if Subtraktion
		minusB.addActionListener(new WriteAction());
		//#else
		//@ minusB.setLabel("");
		//@ minusB.setEnabled(false);
		//#endif
		Button oneB = new Button("1");
		oneB.addActionListener(new WriteAction());
		buttons.add(oneB);
		Button twoB = new Button("2");
		twoB.addActionListener(new WriteAction());
		buttons.add(twoB);
		Button threeB = new Button("3");
		threeB.addActionListener(new WriteAction());
		buttons.add(threeB);
		Button multipleB = new Button("*");
		multipleB.addActionListener(new WriteAction());
		//#if Multiplikation
		multipleB.addActionListener(new WriteAction());
		//#else
		//@ multipleB.setLabel("");
		//@ multipleB.setEnabled(false);
		//#endif
		buttons.add(multipleB);
		Button nullB = new Button("0");
		nullB.addActionListener(new WriteAction());
		buttons.add(nullB);
		Button pointB = new Button(".");
		pointB.addActionListener(new WriteAction());
		buttons.add(pointB);
		Button equalB = new Button("=");
		equalB.addActionListener(new WriteAction());
		buttons.add(equalB);
		Button differenceB = new Button("/");
		differenceB.addActionListener(new WriteAction());
		//#if Division
		differenceB.addActionListener(new WriteAction());
		//#else
		//@ differenceB.setLabel("");
		//@ differenceB.setEnabled(false);
		//#endif
		buttons.add(differenceB);

		this.add(buttons);
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String string) {
		text.setText(string);
	}

	class WriteAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			setName();
			String ausgabe = e.getActionCommand();
			if (ausgabe.equals("+")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("+") && !getText().contains("-")
						&& !getText().contains("*") && !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("-")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("+") && !getText().contains("-")
						&& !getText().contains("*") && !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("*")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("+") && !getText().contains("-")
						&& !getText().contains("*") && !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("/")) {
				if (getText().isEmpty() || getText().equals("0")) {
					setText("ERROR Division with 0");
				}
				if (!getText().contains("+") && !getText().contains("-")
						&& !getText().contains("*") && !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals(".")) {
				if (!hasPoint) {
					setText(getText() + ausgabe);
				}
				hasPoint = true;

			} else if (ausgabe.equals("=")) {
				calc calculate = new calc();
				setText(calculate.calculate(getText()));
				String[] out = { calculate.getOutput() };
				addOutput(out);
			} else {
				setText(getText() + ausgabe);
			}
		}
	}

	@Override
	public void importData(String pfad) {
		FileImport im = new FileImport();
		String imText = im.read(pfad).get(0)[0];
		if(imText.matches("[0-9]*")) {
			text.setText(text.getText() + imText);
		} else {
			text.setText(imText);
		}
	}

	@Override
	protected void setName() {
		Conf.setActualPanel("calc");
	}
}
