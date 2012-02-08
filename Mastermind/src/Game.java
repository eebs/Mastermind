import java.util.ArrayList;
import java.util.Random;

/**
 * Game class. Has a game mode, the board, and the solution.
 *
 * @author Eebs Kobeissi
 * @author Sam Brown
 */
public class Game {

	/**
	 * The game's mode.
	 */
	private GameMode mode;

	/**
	 * Game's board.
	 */
	private ArrayList<Row> board = new ArrayList<Row>();

	/**
	 * The game's key. This is the game's solution.
	 */
	private Row key;

	/**
	 * Hints already hinted. This prevents the same hint being
	 * hinted more than once.
	 */
	private ArrayList<Integer> hints = new ArrayList<Integer>();
	
	/**
	 * Constructor. Creates a game based on the game mode.
	 * Randomly generates the key based on the game mode.
	 *
	 * @param gameMode
	 */
	public Game(GameMode gameMode) {
		mode = gameMode;
		ArrayList<String> keyColors = new ArrayList<String>();
		Random random = new Random();
		for(int i = 0; i < mode.getSlots(); i++){
			keyColors.add(gameMode.getColors()[random.nextInt(gameMode.getColors().length)]);
		}
		key = new Row(keyColors);
	}
	
	/**
	 * Returns whether the game is solved in the current state.
	 *
	 * @return boolean
	 */
	public boolean isSolved(){
		if(board.size() == 0){
			return false;
		}
		return key.equals(board.get(board.size() - 1));
	}
	
	/**
	 * Returns a hint
	 *
	 * @return String
	 */
	public String getHint(){
		boolean hintAdded = false;
		int position;
		Random random = new Random();
		while(!hintAdded && (hints.size() != key.size())){
			position = random.nextInt(mode.getSlots());
			if(!hints.contains(position)){
				hints.add(position);
				hintAdded = true;
			}
		}

		String output = "";
		for(int i = 0; i < key.size(); i++){
			if(hints.contains(i)){
				output += "[" + key.getHoles().get(i) + "] ";
			}else{
				output += "[ ] ";
			}
		}
		return output;
	}
	
	/**
	 * Adds a row to the board.
	 *
	 * @param row
	 * @param key
	 * @return boolean Whether the row was added successfully or not.
	 */
	public boolean addRow(Row row, Row key){
		if(row.size() != mode.getSlots()){
			return false;
		}
		row.init(key);
		board.add(row);
		return true;
	}

	/**
	 * Returns a string representation of the game board.
	 * Outputs many blank lines to 'clear' the screen.
	 *
	 * @return String
	 */
	public String toString(){
		for(int i = 0; i < 80; i++){
			System.out.println();
		}

		int boardSize = board.size();
		String output = "";
		for(int i = 0; i < boardSize; i++){
			if(i != boardSize - 1){
				output += "# ";
			}else{
				output += "> ";
			}
			output += board.get(i).toString() + "\n";
		}
		return output;
	}

	/**
	 * Gets the game mode.
	 *
	 * @return GameMode
	 */
	public GameMode getMode() {
		return mode;
	}

	/**
	 * Sets the game mode.
	 *
	 * @param mode
	 */
	public void setMode(GameMode mode) {
		this.mode = mode;
	}

	/**
	 * Returns the number of current guesses.
	 *
	 * @return int
	 */
	public int getNumberOfGuesses(){
		return board.size();
	}

	/**
	 * Returns the key.
	 *
	 * @return Row
	 */
	public Row getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 */
	public void setKey(Row key) {
		this.key = key;
	}
	
	/**
	 * Gets the number of current hints.
	 *
	 * @return int
	 */
	public int getHintCount(){
		return hints.size();
	}
}
