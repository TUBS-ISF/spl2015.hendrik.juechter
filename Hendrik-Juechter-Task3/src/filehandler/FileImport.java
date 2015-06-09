/**
 * 
 */
package filehandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileImport
 * @author Hendrik
 *
 */
public class FileImport {

	/**
	 * Daten einlesen und als ArrayList von String-Arrays zurückgeben.
	 * 
	 * @param pfad
	 *            Dateipfad
	 * @return ArrayList<String []>
	 */
	public ArrayList<String[]> read(String pfad) {
		String type = pfad.substring(pfad.lastIndexOf("."));
		if (type.contains("txt")) {
			return readTxt(pfad);
		} else if (type.contains("csv")) {
			return readCsv(pfad);
		}
		return null;
	}

	/**
	 * TXT einlesen und als ArrayList von String-Arrays zurückgeben.
	 * 
	 * @param pfad
	 *            Dateipfad
	 * @return ArrayList<String []>
	 */
	private ArrayList<String[]> readCsv(String pfad) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(pfad));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] lineArray = line.split(cvsSplitBy);
	 
				data.add(lineArray);
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	/**
	 * CSV einlesen und als ArrayList von String-Arrays zurückgeben.
	 * 
	 * @param pfad
	 *            Dateipfad
	 * @return ArrayList<String []>
	 */
	private ArrayList<String[]> readTxt(String pfad) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		try {
			FileReader fr = new FileReader(pfad);

			BufferedReader br = new BufferedReader(fr);
			Boolean end = false;
			while(!end) {
				String[] line = {br.readLine()};
				if(line[0] == null) {
					end = true;
				} else {
					data.add(line);
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
}
