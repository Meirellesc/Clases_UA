package model.io;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

public class PlayerString implements IPlayer{

	private String moves;
	
	private int currentMove = 0;
	
	PlayerString(String s) {
		s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
		moves = s;
	}
	
	@Override
	public char nextMove() throws TetrisIOException {
	
		//Checking if have a char which is not "VALID".
		char check;
		int count = 0;
	
		for (int i=0; i<=VALID_MOVES.length();i++) {
			for(int j=0; j<=moves.length(); j++) {
				check = moves.charAt(j);
				if (check == VALID_MOVES.charAt(i)) {
					count += 1;
				}
				
			}
		}
		
		if (count != moves.length()) {
			throw new TetrisIOException(moves);
		}
		
		//Returning a character that represents the next movement
		char mov = moves.charAt(currentMove);
		
		for (int i=0; i<=VALID_MOVES.length();i++) {
			if (VALID_MOVES.charAt(i) == mov) {
				currentMove += 1;
				return mov;
			}
		}
		currentMove += 1; //I don't know if this line is necessary		
		return LAST_MOVE;
	}

}
