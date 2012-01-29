import java.util.ArrayList;
import java.util.Random;

public class Game {

	private GameMode mode;
	private ArrayList<Row> board = new ArrayList<Row>();
	private Row key;
	private String helpText;
	private ArrayList<Integer> hints;
	private int hintCount;
	
	public Game(GameMode gameMode) {
		mode = gameMode;
		ArrayList<String> keyColors = new ArrayList<String>();
		Random random = new Random();
		for(int i = 0; i < mode.getSlots(); i++){
			keyColors.add(gameMode.getColors()[random.nextInt(gameMode.getColors().length)]);
		}
		key = new Row(keyColors);
	}
	
	public boolean isSolved(){
		if(board.size() == 0){
			return false;
		}
		return key.equals(board.get(board.size() - 1));
	}
	
	public String getHint(){
		return "Hint";
	}
	
	public void parseGuess(String guess){
		
	}
	
	public boolean addRow(Row row){
		if(row.size() != mode.getSlots()){
			return false;
		}
		board.add(row);
		return true;
	}
	
}

