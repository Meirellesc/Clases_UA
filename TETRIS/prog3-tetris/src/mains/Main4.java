package mains;

import model.exceptions.io.TetrisIOException;
import model.io.GamePlay;
import model.io.IVisualizer;
import model.io.IPlayer;
import model.io.VisualizerFactory;
import model.io.PlayerFactory;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 01/12/2018
 *
 */
public class Main4 {

	public static void main(String[] args) throws TetrisIOException {
		String output= "console";

		playTheGame("2001", output);
		playTheGame("I↓↓↓↺→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓", output);
		playTheGame("I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
		//		+ "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓", output); //main en svn
			+ "O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓", output); // main en wiki

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