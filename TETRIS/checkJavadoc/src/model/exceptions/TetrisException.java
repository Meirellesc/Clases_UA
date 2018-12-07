package model.exceptions;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
@SuppressWarnings("serial")  
public class TetrisException extends java.lang.Exception {

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public TetrisException() {

	}
	
	/** [ENG] Method that returns a String which describe the reason of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return "TETRIS ERROR!";
		
	}

}
