import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Mastermind {
	private static boolean quit = false;
	private static String helptext = "Type 'h' to see this menu, type 'quit' to exit the game. Enter all row guesses in the format 'R, G, B'.";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StatGatherer statGatherer = new StatGatherer();

		print("Hello, and welcome to Mastermind!");
		//helptext

		print("Enter a game mode, either 'easy' or 'hard'.");
		String mode = scanner.nextLine();
		GameMode gameMode = GameMode.factory(mode);
		
		Game game = new Game(gameMode);
		print("Game started on " + mode + " mode.");
		print(helptext);

		while(!quit && !game.isSolved()){
			String input = scanner.nextLine();
			String response = parseInput(input, game);
			print(response);
		}
		statGatherer.logGame(game);
	}
	
	private static String parseInput(String input, Game game){
		Pattern pattern = Pattern.compile("^[A-Z](, *[A-Z])*$");
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

	private static void print(String s){
		System.out.println(s);
	}

	private static void print(){
		System.out.println();
	}

}
