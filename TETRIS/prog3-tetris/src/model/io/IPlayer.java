package model.io;

import java.io.IOException;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public interface IPlayer {

	public static final char NEXT_PIECE_I = 'I';
	public static final char NEXT_PIECE_J = 'J';
	public static final char NEXT_PIECE_L = 'L';
	public static final char NEXT_PIECE_O = 'O';
	public static final char NEXT_PIECE_S = 'S';
	public static final char NEXT_PIECE_T = 'T';
	public static final char NEXT_PIECE_Z = 'Z';
	
	public static final char ROTATE_CLOCKWISE = '↻';
	public static final char ROTATE_COUNTERCLOCKWISE = '↺';
	
	public static final char MOVE_RIGHT = '→';
	public static final char MOVE_LEFT = '←';
	public static final char MOVE_DOWN = '↓';
	
	public static final char LAST_MOVE = '●';
	
	public static final String VALID_MOVES = "IJLOSTZ↻↺→←↓";
	
	public char nextMove() throws TetrisIOException, IOException;
}
