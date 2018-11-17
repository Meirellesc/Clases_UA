package mains;

import model.exceptions.io.TetrisIOException;
import model.io.GamePlay;
import model.io.IVisualizer;
import model.io.IPlayer;
import model.io.VisualizerFactory;
import model.io.PlayerFactory;

public class Main4 {

	public static void main(String[] args) throws TetrisIOException {
		String output= "console";

		playTheGame("2001", output);
		playTheGame("Iâ†“â†“â†“â†ºâ†’â†’â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“Tâ†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“", output);
		playTheGame("Iâ†ºâ†’â†»â†’â†’â†’â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“Iâ†â†â†â†â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“"
				+ "Iâ†ºâ†’â†»â†’â†’â†’â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“Iâ†â†â†â†â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“"
		//		+ "Iâ†â†â†â†â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“Oâ†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“", output); //main en svn
			+ "Oâ†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“â†“", output); // main en wiki

		playTheGame("players/player1.txt", output);

		/*
		  Uncomment this in order to play with the keyboard
			(after adding the PlayerKeyboard class):
		*/
		// playTheGame("", output);
	}

	static void playTheGame(String input, String output)
			throws TetrisIOException {
		System.out.println("New game!");
		IPlayer player = PlayerFactory.createPlayer(input);
		IVisualizer visualizer = VisualizerFactory.createVisualizer(output);
		GamePlay gamePlay = new GamePlay(player, visualizer);
		gamePlay.play();
	}
}
