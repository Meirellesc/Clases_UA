package model.exceptions.score;

import model.exceptions.TetrisException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 */
@SuppressWarnings("serial")
public class RankingException extends TetrisException{

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public RankingException() {
		
	}
	
	/** [ENG] Method that returns a String which describe the reason of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 * 
	 */
	public String getMessage() {
		return ("The gamePlays set is empty! Please, check again if you inserted right a ScoreType in the set.");
	}
}
