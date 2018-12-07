package model.io;

import java.util.Random;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class PlayerRandom implements IPlayer{
	
	/**
	 * @variable numero aleatório.
	 */
	private Random random;
	
	/**
	 * @variable boolean responsable por verificar se puede poner otra pieza en el tablero.
	 */
	private boolean nextPutPiece = true;
	
	/**
	 * @variable contador de movimientos para abajo.
	 */
	private int downCounter = 0;
	
	/** [ENG] Constructor that initialize the variable 'random' with the seed result indicated by the parameter.
	 *  [SPA] Constructor que inicializa el atributo 'random' con el resultado de la semilla indicada como parámetro.
	 * 
	 * @param l = input a Long type to create a random sequence / introduce un tipo 'Long' para crear una secuencia aleatória.
	 */
	public PlayerRandom(long l) {
        random = new Random();
		random.setSeed(l);
	}
	
	
	@Override
	public char nextMove() throws TetrisIOException {
		
		//Condition that check if can put another piece on the game board.
		if (nextPutPiece) {
			int r1 = random.nextInt(8); //Generate a random number between 0~7 (pieces).
			nextPutPiece = false;
			downCounter = 0;
			
			if(r1 == 0) {
				return NEXT_PIECE_I;
			}
			else if(r1 == 1) {
				return NEXT_PIECE_J;
			}
			else if(r1 == 2) {
				return NEXT_PIECE_L;
			}
			else if(r1 == 3) {
				return NEXT_PIECE_O;
			}
			else if(r1 == 4) {
				return NEXT_PIECE_S;
			}
			else if(r1 == 5) {
				return NEXT_PIECE_T;
			}
			else if(r1 == 6) {
				return NEXT_PIECE_Z;
			}
			else {
				return LAST_MOVE;
			}
			
		}
		
		int r2 = random.nextInt(10); //Generate a random number between 0~9 (movements).
		
		if(r2 == 0) {
			return MOVE_LEFT;
		}
		else if(r2 == 1) {
			return MOVE_RIGHT;
		}
		else if(r2 == 2) {
			return ROTATE_CLOCKWISE;
		}
		else if(r2 == 3) {
			return ROTATE_COUNTERCLOCKWISE;
		}
		else {
			downCounter += 1;
			
			//Condition that check if the piece reached the bottom of the board.
			if (downCounter >= GamePlay.TETRIS_BOARD_STANDARD_HEIGHT) { 
				nextPutPiece = true;
			}
			return MOVE_DOWN;
		}
	}

}
