import java.util.Arrays;

public class GameMode {
	
	private static String[] availableColors = {"R", "B", "G", "Y", "P", "O", "C"};
	private String[] colors;
	private int slots;
	
	public GameMode(String[] colors, int slots){
		this.colors = colors;
		this.slots = slots;
	}
	
	
	public static GameMode factory(String mode){
		if(mode.equalsIgnoreCase("hard")){
			return new GameModeHard(availableColors, 5);
		}else{
			String[] easyColors = Arrays.copyOf(availableColors, availableColors.length - 1);
			return new GameModeEasy(easyColors, 4);
		}
	}
}
