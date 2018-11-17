package model.io;

import java.util.Objects;

public class PlayerString implements IPlayer{

	private String moves;
	
	private int currentMove = 0;
	
	PlayerString(String s) {
		s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
		moves = s;
	}
	
	@Override
	public char nextMove() {
		//currentMove += 1;
		return moves.charAt(currentMove);
	}

}
