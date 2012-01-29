import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Mastermind {
	private static boolean quit = false;
	private static String helptext = "Type 'h' to see this menu, type 'quit' to exit the game. Enter all row guesses in the format 'R, G, B'.";
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		StatGatherer statGatherer = new StatGatherer();

		print("Hello, and welcome to Mastermind!");
		//helptext
		
		Game game = startNewGame();

		while(!quit && !game.isSolved()){
			String input = scanner.nextLine();
			String response = parseInput(input, game);
			print(response);
			
			if (game.isSolved()){
				//want to start a new game.
				print("Your game has ended.  Would you like to play again? (y/n)");
				String replay = scanner.nextLine();
				if (replay.toLowerCase() == "y"){
					statGatherer.logGame(game);
					game = startNewGame();
				}
			}
		}
		//log the final game
		statGatherer.logGame(game);
	}
	
	private static String parseInput(String input, Game game){
		Pattern pattern = Pattern.compile("^[a-zA-Z](, *[a-zA-Z])*$");
		Matcher matcher = pattern.matcher(input);
		String response = "";
		if(matcher.matches()){
			String[] guesses = input.split(", *");
			if(!game.addRow(new Row(new ArrayList<String>(Arrays.asList(guesses))))){
				response = "Incorrect number of pegs entered";
			}
		}else if(input.equalsIgnoreCase("quit")){
			quit = true;
		}else{
			response = helptext;
		}
		return response;
	}
	
	private static Game startNewGame(){
		//enforce a valid game mode selection
		print("Enter a game mode, either 'easy' or 'hard'.");
		String mode = scanner.nextLine().toLowerCase();
		while ( !(mode.equalsIgnoreCase("easy") || mode.equalsIgnoreCase("hard"))){
			print(mode+" is not a valid game mode. Please choose either 'easy' or 'hard'.");
			mode = scanner.nextLine();
		}
		
		GameMode gameMode = GameMode.factory(mode);
		Game game = new Game(gameMode);
		
		print("Game started on " + mode + " mode.");
		print(helptext);
		
		return game;
	}

	private static void print(String s){
		System.out.println(s);
	}

	private static void print(){
		System.out.println();
	}

}
