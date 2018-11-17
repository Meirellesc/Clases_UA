package model.io;

import java.io.BufferedReader;
import java.util.Objects;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class PlayerFile implements IPlayer{

	private BufferedReader br;
	
	PlayerFile(BufferedReader b) {
		b = Objects.requireNonNull(b, "El parametro 'b' no puede ser null!");
		br = b;
	}
	
	@Override
	public char nextMove() {
		
		return 0;
	}

}
