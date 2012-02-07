/**
 * Concrete Game mode - hard
 *
 * @author Eebs Kobeissi
 */
public class GameModeHard extends GameMode{

	/**
	 * Constructor. Calls parent constructor, and sets name.
	 *
	 * @param colors
	 * @param slots
	 */
	public GameModeHard(String[] colors, int slots) {
		super(colors, slots);
		setName("hard");
	}
}
