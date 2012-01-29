import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuffer;

public class StatGatherer {
	String fName = "UsageLog.csv";
	String[] headerItems = {"date", "difficulty", "guesses", "hints"};
	
	/*StatGatherers
	 * Construct a stat gather object with the default stats file name.
	 */
	public StatGatherer(){
		this.init();
	}

	private void init(){
		
	}//end init

/*================================
 * Public methods
 */
	/*getCSVHeader
	 * Returns the various column names defined in headerItems
	 * as a string, formatted to be the header of a CSV.
	 */
	public String getCSVHeader(){
		StringBuffer s = new StringBuffer();
		for (int i=0; i<this.headerItems.length; i++){
			s.append(this.headerItems[i]);
			if (i<this.headerItems.length-1){
				s.append(",");
			}
		}
		s.append("\r\n");
		return s.toString();
	}
	
	/*loadLog
	 * Loads the current log file into ?? or creates a new log file if
	 * one does not already exist.
	 */
	@SuppressWarnings({ "finally" })
	public String loadLog(){
		BufferedReader fileIn = null;
		
		//try to open the stats file for reading
		try{
			fileIn  = new BufferedReader(new FileReader(this.fName));
		}
		
		//IOError occurs when file does not yet exist
		catch (IOException loadError){
		//so try to create the file
			
			BufferedWriter fileOut = new BufferedWriter(new FileWriter(this.fName));
			fileOut.write(this.getCSVHeader());
			fileOut.close();
			fileIn  = new BufferedReader(new FileReader(this.fName));
		}
		
		//now that the file exists, load whatever contents it has
		finally{
			final StringBuffer s = new StringBuffer();
			String line;
			try {
				while ((line = fileIn.readLine()) != null){
					s.append(line+"\r\n");
				}
			} catch (final IOException e) {
				System.out.println("An issue occurred while loading the file into a string.");
			}
			return s.toString();
		}
	}//end loadLog
	
	
/*================================
 * Private methods
 */
	


	
	
	
	
		
/*=========================
 * Testing functions
 */
	
	/*Main method for testing*/
	public static void main(String [] args){
		StatGatherer s = new StatGatherer();
		System.out.println(s.loadLog());
	}//end main
}