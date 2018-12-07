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
	
	/**
	 * @variable next piece I.
	 */
	public static final char NEXT_PIECE_I = 'I';
	/**
	 * @variable next piece J.
	 */
	public static final char NEXT_PIECE_J = 'J';
	/**
	 * @variable next piece L.
	 */
	public static final char NEXT_PIECE_L = 'L';
	/**
	 * @variable next piece O.
	 */
	public static final char NEXT_PIECE_O = 'O';
	/**
	 * @variable next piece S.
	 */
	public static final char NEXT_PIECE_S = 'S';
	/**
	 * @variable next piece T.
	 */
	public static final char NEXT_PIECE_T = 'T';
	/**
	 * @variable next piece Z.
	 */
	public static final char NEXT_PIECE_Z = 'Z';
	
	/**
	 * @variable rotate clockwise.
	 */
	public static final char ROTATE_CLOCKWISE = '↻';
	/**
	 * @variable rotate counterclockwise.
	 */
	public static final char ROTATE_COUNTERCLOCKWISE = '↺';
	
	/**
	 * @variable move right.
	 */
	public static final char MOVE_RIGHT = '→';
	/**
	 * @variable move left.
	 */
	public static final char MOVE_LEFT = '←';
	/**
	 * @variable move down.
	 */
	public static final char MOVE_DOWN = '↓';
	
	/**
	 * @variable last move.
	 */
	public static final char LAST_MOVE = '●';
	
	/**
	 * @variable valid moves.
	 */
	public static final String VALID_MOVES = "IJLOSTZ↻↺→←↓";
	
	/** [ENG] Method that return a character which represent a respective movement.
	 * 	[SPA] Método que devuelva un carácter que represente un movimiento respectivo.
	 * 
	 * @return = the 'char' which represent a movement.
	 * @throws TetrisIOException = if have some Error with the player instructions.
	 * @throws IOException = if have some Error with the player instructions.
	 */
	public char nextMove() throws TetrisIOException, IOException;
}
