import java.util.Scanner;


public class Mastermind {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		print("Hello, and welcome to Mastermind!");
		//helptext
		
		print("Enter a game mode, either 'easy' or 'hard'.");
		String mode = scanner.nextLine();
		GameMode gameMode = GameMode.factory(mode);
		
		Game game = new Game(gameMode);
		

	}
	
	private static void print(String s){
		System.out.println(s);
	}
	
	private static void print(){
		System.out.println();
	}

}
