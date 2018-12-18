package model.io;

import java.io.IOException;
import java.util.Objects;
import java.util.Date;

import model.Coordinate;
import model.Game;
import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
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

	/**
	 * @variable altura minima del tablero. 
	 */
	protected static final int TETRIS_BOARD_STANDARD_HEIGHT = 20;
	
	/**
	 * @variable anchura minima del tablero.
	 */
	protected static final int TETRIS_BOARD_STANDARD_WIDTH = 10;
	
	/**
	 * @variable juego.
	 */
	private Game game;
	
	/**
	 * @variable jugador.
	 */
	IPlayer player;
	
	/**
	 * @variable visualizador.
	 */
	IVisualizer visualizer;
	
	private int rowsCleared;

	private int duration;
	
	private long t0;
	/** [ENG] Constructor that stores its two parameters in the attributes 'player' and 'visualizer' and creates a game with a board size (10x20).
	 *  [SPA] Constructor que almacena sus dos parámetros en los atributos ‘player’ y ‘visualizer’ y crea un juego com un tamaño de tablero (10x20)
	 * 
	 * @param p = input a player/ introduce un jugador.
	 * @param v = input a visualizer / introduce un visualizador.
	 */
	public GamePlay(IPlayer p,IVisualizer v) {
	
		p = Objects.requireNonNull(p, "El parametro 'player (p)' no puede ser null.");
		v = Objects.requireNonNull(v, "El parametro 'visualizer (v)' no puede ser null.");
		
		player = p;
		visualizer = v;
		
		//CHECK IF ITS RIGHT
		rowsCleared = 0;
		duration = 0;
		
		t0 = new Date().getTime();
				
		try {
			Coordinate c = new Coordinate(TETRIS_BOARD_STANDARD_HEIGHT,TETRIS_BOARD_STANDARD_WIDTH);
			game = new Game(c);
			v.setGame(game);
		}catch(WrongSizeException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/** [ENG] Method that play the Tetris.
	 *  [SPA] Método que juega a Tetris.
	 * 
	 * @throws TetrisIOException = if have some Error.
	 */
	public void play() throws TetrisIOException {
		
		char move;
		
		//IS THIS INITIAZLIZE HERE OR IN GAMEPLAY??
		//long t0 = new Date().getTime();
		
		try {
			visualizer.show();
	        move = player.nextMove();
	        
		    // codigo actual de GamePlay.play
		    long t1 = new Date().getTime();
		    duration = (int)(t1 - t0);
	        
	        //Condition that happens while has instructions to be read.
	        while (move != IPlayer.LAST_MOVE) {
	        	
	        	//Instructions that create or movement a piece.
	        	try {
		        	if(move == IPlayer.NEXT_PIECE_I) {
		        		game.nextPiece("I");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_J) {
		        		game.nextPiece("J");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_L) {
		        		game.nextPiece("L");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_O) {
		        		game.nextPiece("O");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_S) {
		        		game.nextPiece("S");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_T) {
		        		game.nextPiece("T");
		        	}
		        	else if (move == IPlayer.NEXT_PIECE_Z) {
		        		game.nextPiece("Z");
		        	}
		        	else if(move == IPlayer.MOVE_LEFT) {
	        			game.moveCurrentPieceLeft();
	        		}
	        		else if(move == IPlayer.MOVE_RIGHT) {
	        			game.moveCurrentPieceRight();
	        		}
	        		else if (move == IPlayer.MOVE_DOWN) {
						rowsCleared += game.moveCurrentPieceDown(); //Counting how many rows were cleared.
					}
	        		else if (move == IPlayer.ROTATE_CLOCKWISE) {
	        			game.rotateCurrentPieceClockwise();
	        		}
	        		else if(move == IPlayer.ROTATE_COUNTERCLOCKWISE) {
	        			game.rotateCurrentPieceCounterclockwise();
	        		}
				}catch(OffBoardMovementException | CollisionMovementException | FixedPieceMovementException e) {
					     		       	
	        	}catch(NoCurrentPieceException | CurrentPieceNotFixedException e){
	        		throw new TetrisIOException("Don't have a current Piece or the current Piece isn't fixed yet!!");
	        	}catch(GameEndedMovementException e) {
	        		return;
	        	}
	        		
	        	visualizer.show();
	        	move = player.nextMove();
	        }
        }catch(IOException e) {  
        	throw new TetrisIOException("Error!");
        }
	}
	
	public int getRowsCleared() {
		return rowsCleared;
	}

	public int getDuration() {
		return duration;
	}
}
