import java.util.ArrayList;


public class Row {

	private ArrayList<String> holes;
	private int numColorCorrect = 0;
	private int numHoleCorrect = 0;

	public Row(ArrayList<String> holes){
		this.holes = holes;
	}

	public Row(ArrayList<String> holes, Row key){
		this.holes = holes;
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
	}

	public boolean equals(Row newRow){
		return this.holes.equals(newRow.holes);
	}

	public int size(){
		return holes.size();
	}

	public String toString(){
		String output = "";
		for(int i = 0; i < holes.size(); i++){
			output += "[" + holes.get(i)+ "] ";
		}
		output += " - (" + numColorCorrect + "W, " + numHoleCorrect + "B)";
		return output;
	}
}
