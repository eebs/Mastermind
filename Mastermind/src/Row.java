import java.util.ArrayList;


public class Row {

	private ArrayList<String> holes;
	private int numColorCorrect;
	private int numHoleCorrect;

	public Row(ArrayList<String> holes){
		this.holes = holes;
	}

	public boolean equals(Row newRow){
		return this.holes.equals(newRow.holes);
	}

	public int size(){
		return holes.size();
	}
}
