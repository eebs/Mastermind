/**
 * Concrete Game mode - easy
 *
 * @author Eebs Kobeissi
 */
public class GameModeEasy extends GameMode{

	/**
	 * Constructor. Calls parent constructor, and sets name.
	 *
	 * @param colors
	 * @param slots
	 */
	public GameModeEasy(String[] colors, int slots) {
		super(colors, slots);
		setName("easy");
	}
}
