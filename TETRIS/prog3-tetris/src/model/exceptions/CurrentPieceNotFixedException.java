package model.exceptions;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
@SuppressWarnings("serial")  
public class CurrentPieceNotFixedException extends TetrisException {

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public CurrentPieceNotFixedException() {

	}
	
	/** [ENG] Method that returns a String which describe the reason  of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return " [ENG] The current piece is not fixed and you want to put a new piece on the board" + 
				"[SPA] La pieza actual no está fijada y se quiere poner una nueva pieza en el tablero";
		
	}

}