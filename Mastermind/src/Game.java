import java.util.ArrayList;
import java.util.Random;

public class Game {

	private GameMode mode;
	private ArrayList<Row> board;
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

