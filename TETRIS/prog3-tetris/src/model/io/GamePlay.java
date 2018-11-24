package model.io;

import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.WrongSizeException;
import model.exceptions.io.TetrisIOException;

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
	
	
	//ASK ABOUT THE EXCEPTIONS ???
	
	public GamePlay(IPlayer p,IVisualizer v) throws WrongSizeException {
	
		p = Objects.requireNonNull(p, "El parametro 'player (p)' no puede ser null.");
		v = Objects.requireNonNull(v, "El parametro 'visualizer (v)' no puede ser null.");
		
		player = p;
		visualizer = v;
		
		Coordinate c = new Coordinate(TETRIS_BOARD_STANDARD_HEIGHT,TETRIS_BOARD_STANDARD_WIDTH);
		game = new Game(c);
		
		v.setGame(game);
	}
	
	public void play() throws TetrisIOException {
		
		char move;
		
		visualizer.show();
        move = player.nextMove();
        while (move != IPlayer.LAST_MOVE) {
        	
        	//execute move...
        	// catch exceptions...
        	visualizer.show();
        	move = player.nextMove();
        }
        
	}
}
