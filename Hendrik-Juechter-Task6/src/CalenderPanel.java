import filehandler.FileImport;
import global.Conf;
import global.view.AllIntFrame;
import global.view.InputProvider;
import global.view.Plugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class CalenderPanel extends AllIntFrame implements Plugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5383817286205350138L;

	private InputProvider app;

	private static JTable dateTable = new JTable();

	private String[] dayNotes = new String[32];
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private GregorianCalendar gregCal = new GregorianCalendar();
	private String actualDate = df.format(gregCal.getTime());
	private Integer month = Integer.parseInt(actualDate.substring(
			actualDate.indexOf(".") + 1, actualDate.lastIndexOf(".")));
	private Integer year = Integer.parseInt(actualDate.substring(actualDate
			.lastIndexOf(".") + 1));;

	private JPanel calPanel = new JPanel();
	private static int firstDayOfMonth;
	private static int anzDayOfMonth;
	private JLabel Today;

	private static CalenderPanel panel = new CalenderPanel();
	private static JTextArea text = new JTextArea();

	public CalenderPanel() {
		init();
	}

	public String getText() {
		return "Calender";
	}

	public void setText(String string) {
		System.out.println(string);
	}

	@Override
	protected void setName() {
		if (Conf.getActualPanel() != Conf.CAL) {
			Conf.setActualPanel(Conf.CAL);
		}
	}

	public String getApplicationTitle() {
		return "Kalender";
	}

	public void setApplication(InputProvider application) {
		app = application;

	}

	@Override
	public ArrayList<String[]> getOutput() {
		ArrayList<String[]> output = new ArrayList<String[]>();
		output.add(dayNotes);
		return output;
	}

	@Override
	public void importData(String pfad) {
		FileImport im = new FileImport();
		ArrayList<String[]> imTextList = im.read(pfad);
		String imText = "";
		for (String[] line : imTextList) {
			imText = imText + line[0] + "\n";
		}
		// text.setText(imText);
	}

	public JInternalFrame start() {
		for (int i = 0; i < dayNotes.length; i++) {
			dayNotes[i] = "";
		}
		Conf.getInstance().setCalender(panel);
		panel.setSize(new Dimension(200, 300));
		panel.setLayout(new BorderLayout());
		Today = new JLabel("Heute ist der: "
				+ gregCal.get(gregCal.DAY_OF_MONTH) + ". "
				+ getMonthName(month - 1) + " " + year);
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);
		firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
		anzDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		initView();
		calPanel.setLayout(new GridLayout(2, 1));
		calPanel.add(dateTable);
		text.setText("Hier ist Platz für Tages-Notizen.");
		calPanel.add(text);
		panel.add(calPanel, BorderLayout.CENTER);
		panel.setTitle(getApplicationTitle());
		panel.setVisible(true);
		return panel;
	}

	public void initView() {
		// TODO Auto-generated method stub
		panel.add(Today, BorderLayout.NORTH);

	}

	public static void initMonthView() {
		String[][] rowData = new String[7][7];
		String[] WeekDays = { "Sonntag", "Montag", "Dienstag", "Mittwoch",
				"Donnerstag", "Freitag", "Samstag" };
		dateTable = new JTable(rowData, WeekDays);

		dateTable.addMouseListener(panel.new MouseSensor(rowData));
		int day = 1;
		rowData[0] = WeekDays;
		for (int row = 1; row < rowData.length; row++) {
			for (int col = 0; col < rowData[1].length; col++) {
				rowData[row][col] = "";
				// System.out.println(cols + " " + rows);
				if (day <= anzDayOfMonth) {
					if (row == 1) {
						if (col >= firstDayOfMonth - 1) {
							rowData[row][col] = "" + day;
							day++;
						}
					} else {
						rowData[row][col] = "" + day;
						day++;
					}
				}

			}
		}

	}

	class MouseSensor implements MouseListener {
		private String data[][];
		private String oldDay = "";

		public MouseSensor(String[][] rowData) {
			data = rowData;
		}

		public void mouseReleased(MouseEvent arg0) {
			int col = dateTable.getSelectedColumn();
			int row = dateTable.getSelectedRow();
			String day = data[row][col];
			oldDay = day;
			if (!day.equals("")) {
				showDay(day);
			}
		}

		public void mousePressed(MouseEvent arg0) {
			if (!oldDay.equals("")) {
				int d = Integer.parseInt(oldDay);
				String writeText = text.getText();

				if (dayNotes[d] != "") {
					dayNotes[d] = writeText;
				} else {
					dayNotes[d] = dayNotes[d] + writeText;
				}

				text.setText("");
				//System.out.println("Ich speicher: " + dayNotes[d]);
			}
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

	}

	private void showDay(String day) {
		String oldText = dayNotes[Integer.parseInt(day)];
		//System.out.println("alt: " + oldText);
		if (oldText != "" && oldText != "null") {
			text.setText(oldText);
		}

	}

	private String getMonthName(int month) {
		switch (month) {
		case 0:
			return "Januar";
		case 1:
			return "Februar";
		case 2:
			return "März";
		case 3:
			return "April";
		case 4:
			return "Mai";
		case 5:
			return "Juni";
		case 6:
			return "Juli";
		case 7:
			return "Ausgust";
		case 8:
			return "September";
		case 9:
			return "Oktober";
		case 10:
			return "November";
		case 11:
			return "Dezember";
		default:
			return "Fail";
		}
	}

}
