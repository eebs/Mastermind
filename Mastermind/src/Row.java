import java.util.ArrayList;

/**
 * Row class. Contains the holes, and the number correct
 * colors and pegs.
 *
 * @author Sam Brown
 * @author Eebs Kobeissi
 *
 */
public class Row {

	/**
	 * The pegs in the row.
	 */
	private ArrayList<String> holes;

	/**
	 * The number of colors correct based on the game key.
	 */
	private int numColorCorrect = 0;

	/**
	 * The number of pegs in the correct hole based on the game key.
	 */
	private int numHoleCorrect = 0;

	/**
	 * Constructor. Sets the pegs.
	 *
	 * @param holes
	 */
	public Row(ArrayList<String> holes){
		this.holes = holes;
	}

	/**
	 * Initialize a row. Computes the number of correct colors and holes.
	 *
	 * @param key
	 * @return Row
	 */
	public Row init(Row key){
		ArrayList<Integer> perfectMatches = new ArrayList<Integer>();
		ArrayList<Integer> colorMatches = new ArrayList<Integer>();
		for(int i = 0; i < key.size(); i++){
			if(holes.get(i).equalsIgnoreCase(key.holes.get(i))){
				numHoleCorrect++;
				perfectMatches.add(i);
			}
		}

		for(int i = 0; i < key.size(); i++){
			if(!perfectMatches.contains(i)){
				boolean colorMatched = false;
				for(int j = 0; j < holes.size(); j++){
					if(!perfectMatches.contains(j) && !colorMatched && !colorMatches.contains(j) && (holes.get(j).equalsIgnoreCase(key.holes.get(i)))){
						colorMatches.add(j);
						colorMatched = true;
						numColorCorrect++;
					}
				}
			}
		}
		return this;
	}

	/**
	 * Row equality. Based on the pegs in the holes.
	 *
	 * @param newRow
	 * @return boolean
	 */
	public boolean equals(Row newRow){
		return this.holes.equals(newRow.holes);
	}

	/**
	 * Returns the size of the row.
	 *
	 * @return int
	 */
	public int size(){
		return holes.size();
	}

	/**
	 * Returns a string representation of the row.
	 *
	 * @return String
	 */
	public String toString(){
		String output = "";
		for(int i = 0; i < holes.size(); i++){
			output += "[" + holes.get(i)+ "] ";
		}
		output += " - (" + numColorCorrect + "W, " + numHoleCorrect + "B)";
		return output;
	}

	/**
	 * Returns the peg holes.
	 *
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getHoles(){
		return holes;
	}
}
