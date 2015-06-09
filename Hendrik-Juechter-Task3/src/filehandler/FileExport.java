/**
 * 
 */
package filehandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Hendrik
 *
 */
public class FileExport {

	private String pfad;
	private String type;
	public void write(String thePfad, ArrayList<String[]> data) {
		type = thePfad.substring(thePfad.lastIndexOf("."));
		pfad = thePfad;
		if (type.contains("txt") || type.contains("csv")) {
			writeCsvTxt(data);
		}
	}
	
	/**
	 * Writes Data in CSV
	 * @param data Data
	 */
	private void writeCsvTxt(ArrayList<String[]> data) {
		try
		{
		    FileWriter writer = new FileWriter(pfad);
		    for(String[] line : data) {
		    	for(String cell : line) {
		    		writer.append(cell);
		    		if(type.contains("csv")) {
		    			writer.append(',');
		    		}
		    	}
		    	writer.append('\n');
		    }
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
		
	}
}
