package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class PlayerFactory {
	
	public PlayerFactory() {
		
	}
	
	private static boolean isLong(String s) {
		
		if (Long.parseLong(s) > (Long.MIN_VALUE) && Long.parseLong(s) < (Long.MAX_VALUE)) { //I have to check with which number???
			return true;
		}
		return false;
	}
	
	
	public static IPlayer createPlayer(String s) throws TetrisIOException{//, FileNotFoundException {
		
		s = Objects.requireNonNull(s, "El parametro 'createPlayer(s)' no puede ser null!");
		
		IPlayer p;
		
		if (s.contains("/")|| s.contains(".")) { //Probably have to add more conditions to check
			/*
			p = new PlayerFile(new BufferedReader(new FileReader(s)));
			return p;
			*/
			try {
				p = new PlayerFile(new BufferedReader(new FileReader(s)));
				return p;
			}catch(FileNotFoundException e) {
				//new throw TetrisIOException();
			}
			
		}
		else if (isLong(s)){
			p = new PlayerRandom(Long.parseLong(s));
			return p;
		}
		else if (s.equals(String.class)) {
			p = new PlayerString(s);
			return p;
		}
		else {
			throw new TetrisIOException("No se puede crear un objeto. Verifica el camino del fichero pasado como parámetro!");
		}
	}
}
