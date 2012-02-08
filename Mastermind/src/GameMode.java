import java.util.Arrays;

/**
 * Abstract base class for game modes.
 *
 * @author Eebs Kobeissi
 */
abstract class GameMode {

	/**
	 * Array of available colors.
	 */
	private static String[] availableColors = {"R", "B", "G", "Y", "P", "O", "C"};

	/**
	 * Colors for the concrete game mode.
	 */
	private String[] colors;

	/**
	 * Number of slots in the concrete game mode.
	 */
	private int slots;

	/**
	 * String name of the game mode.
	 */
	private String name;

	/**
	 * Constructor. Sets the color and slots.
	 *
	 * @param colors
	 * @param slots
	 */
	public GameMode(String[] colors, int slots){
		this.setColors(colors);
		this.setSlots(slots);
	}

	/**
	 * Factory for creating game modes. Takes a mode string and
	 * creates a game mode based on the string.
	 *
	 * @param mode
	 * @return GameMode
	 */
	public static GameMode factory(String mode){
		if(mode.equalsIgnoreCase("hard")){
			return new GameModeHard(availableColors, 5);
		}else{
			String[] easyColors = Arrays.copyOf(availableColors, availableColors.length - 1);
			return new GameModeEasy(easyColors, 4);
		}
	}

	/**
	 * Gets the colors option.
	 *
	 * @return String[]
	 */
	public String[] getColors() {
		return colors;
	}

	/**
	 * Sets the colors option.
	 *
	 * @param colors
	 */
	public void setColors(String[] colors) {
		this.colors = colors;
	}

	/**
	 * Gets the slots option.
	 *
	 * @return int
	 */
	public int getSlots() {
		return slots;
	}

	/**
	 * Sets the slots option.
	 *
	 * @param slots
	 */
	public void setSlots(int slots) {
		this.slots = slots;
	}

	/**
	 * Gets the name option.
	 *
	 * @return String
	 */
	public String getName(){
		return name;
	}

	/**
	 * Sets the name option
	 *
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Gets the available colors array
	 *
	 * @return String[]
	 */
	public String[] getAvailableColors(){
		return availableColors;
	}

	/**
	 * Gets the available colors as a string.
	 * Colors returned are based on the current mode.
	 *
	 * @return String
	 */
	public String getAvailableColorsString(){
		String colorString = "";
		int length = this.getName().equalsIgnoreCase("hard") ? availableColors.length : availableColors.length - 1;
		for(int i = 0; i < length; i++){
			colorString += availableColors[i] + " ";
		}
		return colorString;
	}
}
