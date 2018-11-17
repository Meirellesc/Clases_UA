package model.io;

import model.Game;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class GamePlay {

	protected static final int TETRIS_BOARD_STANDARD_HEIGHT = 20;
	
	protected static final int TETRIS_BOARD_STANDARD_WIDTH = 10;
	
	private Game game;
	
	IPlayer player;
	
	IVisualizer visualizer;
	
	
	public GamePlay(IPlayer p,IVisualizer v) {
		
	}
	
	public void play() {
		
	}
}
