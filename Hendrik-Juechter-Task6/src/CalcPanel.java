//#if Dateiimport
import filehandler.FileImport;
//#endif
import global.Conf;
import global.view.InputProvider;
import global.view.Plugin;
import global.view.AllIntFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculator.calc;

public class CalcPanel extends AllIntFrame implements Plugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField text = new JTextField();

	private JLabel lblErg = new JLabel();

	private static JPanel calcButtons = new JPanel();
	private static JPanel moreCalcButtons = new JPanel();

	protected boolean hasPoint = false;

	private InputProvider app;

	public CalcPanel() {
		init();
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String string) {
		text.setText(string);
	}

	class WriteAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String ausgabe = e.getActionCommand();
			if (ausgabe.equals("+")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("%") && !getText().contains("+")
						&& !getText().contains("-") && !getText().contains("*")
						&& !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("-")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("%") && !getText().contains("+")
						&& !getText().contains("-") && !getText().contains("*")
						&& !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("*")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("%") && !getText().contains("+")
						&& !getText().contains("-") && !getText().contains("*")
						&& !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("/")) {
				if (getText().isEmpty() || getText().equals("0")) {
					setText("ERROR Division with 0");
				}
				if (!getText().contains("%") && !getText().contains("+")
						&& !getText().contains("-") && !getText().contains("*")
						&& !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
				hasPoint = false;
			} else if (ausgabe.equals("%")) {
				if (getText().isEmpty()) {
					setText("0" + ausgabe);
				}
				if (!getText().contains("%") && !getText().contains("+")
						&& !getText().contains("-") && !getText().contains("*")
						&& !getText().contains("/")) {
					setText(getText() + ausgabe);
				}
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
				lblErg.setText(out[0]);
			} else {
				lblErg.setText(getText() + ausgabe);
				setText(getText() + ausgabe);
			}
		}

	}

	@Override
	public void importData(String pfad) {
		FileImport im = new FileImport();
		String imText = im.read(pfad).get(0)[0];
		if (imText.matches("[0-9]*")) {
			text.setText(text.getText() + imText);
		} else {
			text.setText(imText);
		}
	}

	@Override
	protected void setName() {
		Conf.setActualPanel(Conf.CALC);
	}

	public String getApplicationTitle() {
		// TODO Auto-generated method stub
		return "Taschenrechner";
	}

	public void setApplication(InputProvider application) {
		app = application;

	}

	public JInternalFrame start() {
		JPanel ButtonField = new JPanel();
		ButtonField.setLayout(new BorderLayout());
		JPanel numButtons = new JPanel();

		calcButtons.setLayout(new GridLayout(4, 1));
		moreCalcButtons.setLayout(new GridLayout(1, 4));
		ButtonField.add(moreCalcButtons, BorderLayout.NORTH);
		ButtonField.add(calcButtons, BorderLayout.EAST);
		ButtonField.add(numButtons, BorderLayout.CENTER);

		Conf.getInstance().setCalc(this);

		this.setSize(new Dimension(200, 300));
		this.setLayout(new GridLayout(2, 1));
		text.setSize(100, 20);
		JPanel showPanel = new JPanel();
		showPanel.setLayout(new GridLayout(2, 1));
		showPanel.add(text);

		JButton delAllButton = new JButton("C");
		delAllButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setText("");

			}
		});
		JButton delOneButton = new JButton("CE");
		delOneButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (getText().length() > 0) {
					setText(getText().substring(0, getText().length() - 1));
				}
			}
		});

		showPanel.add(lblErg);
		this.add(showPanel);

		numButtons.setLayout(new GridLayout(4, 3));

		moreCalcButtons.add(new JLabel());
		moreCalcButtons.add(delOneButton);
		moreCalcButtons.add(delAllButton);
		JButton sevenB = new JButton("7");
		sevenB.addActionListener(new WriteAction());
		numButtons.add(sevenB);
		JButton eightB = new JButton("8");
		eightB.addActionListener(new WriteAction());
		numButtons.add(eightB);
		JButton nineB = new JButton("9");
		nineB.addActionListener(new WriteAction());
		numButtons.add(nineB);


		JButton fourB = new JButton("4");
		fourB.addActionListener(new WriteAction());
		numButtons.add(fourB);
		JButton fiveB = new JButton("5");
		fiveB.addActionListener(new WriteAction());
		numButtons.add(fiveB);
		JButton sixB = new JButton("6");
		sixB.addActionListener(new WriteAction());
		numButtons.add(sixB);

		JButton oneB = new JButton("1");
		oneB.addActionListener(new WriteAction());
		numButtons.add(oneB);
		JButton twoB = new JButton("2");
		twoB.addActionListener(new WriteAction());
		numButtons.add(twoB);
		JButton threeB = new JButton("3");
		threeB.addActionListener(new WriteAction());
		numButtons.add(threeB);

		JButton nullB = new JButton("0");
		nullB.addActionListener(new WriteAction());
		numButtons.add(nullB);
		JButton pointB = new JButton(".");
		pointB.addActionListener(new WriteAction());
		numButtons.add(pointB);
		JButton equalB = new JButton("=");
		equalB.addActionListener(new WriteAction());
		numButtons.add(equalB);

		this.add(ButtonField);
		this.setTitle(getApplicationTitle());
		this.setVisible(true);
		initButtons();
		return this;

	}

	private void initButtons() {
		// TODO Auto-generated method stub
		
	}

	public static void addAddButton() {
		JButton plusB = new JButton("+");

		// #if Addition
		plusB.addActionListener(new CalcPanel().new WriteAction());
		// #else
		// @ plusB.setLabel("");
		// @ plusB.setEnabled(false);
		// #endif
		calcButtons.add(plusB);
	}

	public static void addSubButton() {
		JButton minusB = new JButton("-");
		calcButtons.add(minusB);
		// #if Subtraktion
		minusB.addActionListener(new CalcPanel().new WriteAction());
		// #else
		// @ minusB.setLabel("");
		// @ minusB.setEnabled(false);
		// #endif
	}

	public static void addMultButton() {
		JButton multipleB = new JButton("*");
		// #if Multiplikation
		multipleB.addActionListener(new CalcPanel().new WriteAction());
		// #else
		// @ multipleB.setLabel("");
		// @ multipleB.setEnabled(false);
		// #endif
		calcButtons.add(multipleB);
	}

	public static void addDivButton() {
		JButton differenceB = new JButton("/");
		// #if Division
		differenceB.addActionListener(new CalcPanel().new WriteAction());
		// #else
		// @ differenceB.setLabel("");
		// @ differenceB.setEnabled(false);
		// #endif
		calcButtons.add(differenceB);
	}

	public static void addProzentButton() {
		// #if Prozent
		JButton prozentB = new JButton("%");
		prozentB.addActionListener(new CalcPanel().new WriteAction());
		moreCalcButtons.add(prozentB);
		// #else
		// @ buttons.add(new JLabel());
		// #endif
	}

}
