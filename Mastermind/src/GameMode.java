import java.util.Arrays;

abstract class GameMode {
	
	private static String[] availableColors = {"R", "B", "G", "Y", "P", "O", "C"};
	private String[] colors;
	private int slots;
	private String name;
	
	public GameMode(String[] colors, int slots){
		this.setColors(colors);
		this.setSlots(slots);
	}
	
	
	public static GameMode factory(String mode){
		if(mode.equalsIgnoreCase("hard")){
			return new GameModeHard(availableColors, 5);
		}else{
			String[] easyColors = Arrays.copyOf(availableColors, availableColors.length - 1);
			return new GameModeEasy(easyColors, 4);
		}
	}

	public String[] getColors() {
		return colors;
	}


	public void setColors(String[] colors) {
		this.colors = colors;
	}


	public int getSlots() {
		return slots;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
	
	public String[] getAvailableColors(){
		return availableColors;
	}
	
	public String getAvailableColorsString(){
		String colorString = "";
		for(int i = 0; i < availableColors.length; i++){
			colorString += availableColors[i] + " ";
		}
		return colorString;
	}
}
