package model.exceptions.io;

import model.exceptions.*;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
@SuppressWarnings("serial")  
public class TetrisIOException extends TetrisException {

	/**
	 * @variable mensaje.
	 */
	private String message;
	
	/** [ENG] Method that store the String which describe the reason of the exception that is throwing.
	 *  [SPA] Método que almacena una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @param s = message that describe the reason of the exception / mensaje que describirá la razón de la excepción.
	 */
	public TetrisIOException(String s) {
		message = s;
	}
	
	/** [ENG] Method that returns a message which describe the reason of the exception that is throwing.
	 *  [SPA] Método que devolverá una mesaje que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return message.
	 */
	public String getMessage() {
		return message;
	}
}
