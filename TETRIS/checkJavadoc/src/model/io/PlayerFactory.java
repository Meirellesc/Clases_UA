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
	
	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public PlayerFactory() {
	}
	
	/** [ENG] Method that verify if the 'String(s)' has a "Long" number valid or not.
	 *  [SPA] Método que verifica si la cadena contiene un número entero largo válido o no.
	 * 
	 * @param s = input a "Long" number / introduce un número entero largo.
	 * @return = true if it is a valid "Long" number and not if it is not valid.
	 */
	private static boolean isLong(String s) {	
		try {
			Long.parseLong(s);
			return true;
				
		}catch(NumberFormatException e) {
			return false;
		}	
	}
	
	/** [ENG] Method that creates objects of different classes (PlayerString/PlayerFile/PlayerRandom).
	 *  [SPA] Método que crea objetos de las diferentes clases (PlayerString/PlayerFile/PlayerRandom).
	 * 
	 * @param s = input which type of object to be created (Ex: String; "I↓↓↓↺→→↓↓↓↓" / File: "...players/player1.txt" / Random: "12345")
	 * @return = a object of a specific class, according to the input parameter / un objeto de una clase específica, de acuerdo com el parámetro de entrada.
	 * @throws TetrisIOException = if have some Error with the player instructions.
	 */
	public static IPlayer createPlayer(String s) throws TetrisIOException{
		
		s = Objects.requireNonNull(s, "El parametro 'createPlayer(s)' no puede ser null!");
		
		IPlayer p;
		
		//Condition that check if has specific characters which represent a file's path.
		if (s.contains("/")|| s.contains(".")) { 
			try {
				p = new PlayerFile(new BufferedReader (new FileReader(s))); //Create a PlayerFile.
				return p;
			}catch (FileNotFoundException e) {
				throw new TetrisIOException("No se puede crear un objeto. Verifica el camino del fichero pasado como parámetro!");
			}
		}
		//Condition that check if is a "Long" number.
		else if (isLong(s)){
			p = new PlayerRandom(Long.parseLong(s)); //Create a PlayerRandom.
			return p;			
		}
		else {
			p = new PlayerString(s); //Create a PlayerString.
			return p;
		}
	}
}
