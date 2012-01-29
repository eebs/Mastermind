import java.util.ArrayList;

public class Game {

	private GameMode mode;
	private ArrayList<Row> board;
	private Row key;
	private String helpText;
	private ArrayList<Integer> hints;
	private int hintCount;
	
	private void init(GameMode mode){
		
	}
	
	public boolean isSolved(){
		return true;
	}
	
	public String getHint(){
		return "Hint";
	}
	
	public void parseGuess(String guess){
		
	}
	
	public boolean addRow(Row row){
		return true;
	}
	
}

