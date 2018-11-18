package mains;

import java.io.FileNotFoundException;

import model.exceptions.WrongSizeException;
import model.exceptions.io.TetrisIOException;
import model.io.GamePlay;
import model.io.IVisualizer;
import model.io.IPlayer;
import model.io.VisualizerFactory;
import model.io.PlayerFactory;

public class Main4 {

	//=====================CHANGED!!!=====================> "FILENOTFOUNDWXCEPTION"
	
	public static void main(String[] args) throws TetrisIOException, FileNotFoundException, WrongSizeException {
		String output= "console";
		//String output= "window";

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

	//=====================CHANGED!!!=====================> "FILENOTFOUNDWXCEPTION"
	static void playTheGame(String input, String output)
			throws TetrisIOException, FileNotFoundException, WrongSizeException {
		System.out.println("New game!");
		IPlayer player = PlayerFactory.createPlayer(input);
		IVisualizer visualizer = VisualizerFactory.createVisualizer(output);
		GamePlay gamePlay = new GamePlay(player, visualizer);
		gamePlay.play();
	}
}