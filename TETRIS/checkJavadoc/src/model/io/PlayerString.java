package model.io;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class PlayerString implements IPlayer{

	/**
	 * @variable movimientos.
	 */
	private String moves;
	
	/**
	 * @variable "contador de movimientos".
	 */
	private int currentMove = 0;
	
	/** [ENG] Constructor that keep the parameter which represent a movements sequence. 
	 *  [SPA] Constructor que almacena el parámetro cuyo representa la secuencia de movimientos.   
	 * 
	 * @param s = input the sequence of movements / introduce con la secuencia de movimientos /Example: 'I','↓'...
	 */
	PlayerString(String s) {
		s = Objects.requireNonNull(s, "El parametro 'PlayerString(s)' no puede ser null");
		moves = s;
	}
	
	@Override
	public char nextMove() throws TetrisIOException {
	
		//Checking if have a char which is not "VALID".
		char check;
		int count = 0;
		
		for (int i=0; i< VALID_MOVES.length();i++) {
			for(int j=0; j < moves.length(); j++) {
				check = moves.charAt(j);
				if (check == VALID_MOVES.charAt(i)) {
					count += 1;
				}
				
			}
		}
		if (count != moves.length()) {
			throw new TetrisIOException("You are trying to do a INVALID movement, check again: " + moves);
		}
		
		//Returning a character that represents the next movement
		if (currentMove < moves.length()) {
			char mov = moves.charAt(currentMove);
			currentMove += 1;
			return mov;
		}
		else {
			return LAST_MOVE;
		}
				
	}

}
