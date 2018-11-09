package model.exceptions;

import model.Coordinate;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
@SuppressWarnings("serial")  
public class WrongSizeException extends TetrisException{

    /** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
     * 
     * @param c = coordinate.
     */
	public WrongSizeException(Coordinate c) {
		
	}
	
	/** [ENG] Method that returns a String which describe the reason  of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return " \n[ENG] A board must have a minimum size that at least the first piece can be put on the board.\n" + 
				"[SPA] Un tablero debe tener un tamaño mínimo que al menos la primera pieza pueda ponerse en el tablero.\n";
		
	}
}