package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
		
		if (Long.parseLong(s) > 0) { //I have to check with which number???
			return true;
		}
		return false;
	}
	
	public static IPlayer createPlayer(String s) throws TetrisIOException, FileNotFoundException {
		
		IPlayer p = null;
		
		if (s.contains("/")|| s.contains(".")) { //Probably have to add more conditions to check
			p = new PlayerFile(new BufferedReader(new FileReader(s)));
			return p;
			
		}
		else if (isLong(s)){
			p = new PlayerRandom(Long.parseLong(s));
			return p;
		}
		else
			p = new PlayerString(s);
			return p; 
	}
}
