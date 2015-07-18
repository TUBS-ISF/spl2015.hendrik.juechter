

import filehandler.FileImport;
import global.Conf;
import global.view.AllIntFrame;
import global.view.InputProvider;
import global.view.Plugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

public class CalenderPanel extends AllIntFrame implements Plugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5383817286205350138L;

	private InputProvider app;

	private static JTable text = new JTable();

	GregorianCalendar gregCal = new GregorianCalendar();
	private static int firstDayOfMonth;
	private static int anzDayOfMonth;
	private JLabel Today;

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
		String[] noteText = getText().split("\n");
		for (String line : noteText) {
			String[] lineText = { line };
			output.add(lineText);
		}

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
		Conf.getInstance().setCalender(this);
		this.setSize(new Dimension(200, 300));
		this.setLayout(new BorderLayout());
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM); // 14.
																		// April
																		// 2012
		String actualDate = df.format(gregCal.getTime());
		Integer y = Integer.parseInt(actualDate.substring(actualDate
				.lastIndexOf(".") + 1));
		Integer m = Integer.parseInt(actualDate.substring(
				actualDate.indexOf(".") + 1, actualDate.lastIndexOf(".")));
		Today = new JLabel("Heute ist der: "
				+ gregCal.get(Calendar.DAY_OF_WEEK)+ ". " + getMonthName(m - 1) +" " + y );
		GregorianCalendar cal = new GregorianCalendar(y, m - 1, 1);
		firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
		anzDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		initView();
		this.add(text, BorderLayout.CENTER);
		this.setTitle(getApplicationTitle());
		this.setVisible(true);

		return this;
	}
	
	public void initView() {
		// TODO Auto-generated method stub
		this.add(Today, BorderLayout.NORTH);
		
	}

	public static void initMonthView() {
		String[][] rowData = new String[7][7];
		String[] WeekDays = { "Sonntag", "Montag", "Dienstag", "Mittwoch",
				"Donnerstag", "Freitag", "Samstag" };
		text = new JTable(rowData, WeekDays);
		int day = 1;
		rowData[0] = WeekDays;
		for (int cols = 1; cols < rowData.length; cols++) {
			for (int rows = 0; rows < rowData[1].length; rows++) {

				// System.out.println(cols + " " + rows);
				if (day <= anzDayOfMonth) {
					if (cols == 1) {
						if (rows >= firstDayOfMonth - 1) {
							rowData[cols][rows] = "" + day;
							day++;
						}
					} else {
						rowData[cols][rows] = "" + day;
						day++;
					}
				}

			}
		}
		
	}
	
	private String getMonthName(int month) {
		switch (month) {
		case 0: return "Januar";
		case 1:	return "Februar";
		case 2: return "März";
		case 3: return "April";
		case 4: return "Mai";
		case 5: return "Juni";
		case 6: return "Juli";
		case 7:	return "Ausgust";
		case 8: return "September";
		case 9: return "Oktober";
		case 10: return "November";
		case 11: return "Dezember";
		default:
			return "Fail";
		}
	}

}
