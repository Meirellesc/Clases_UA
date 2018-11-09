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
public class OffBoardMovementException extends MovementException {

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 * @param c = Coordinate.
	 */
	public OffBoardMovementException(Coordinate c) {
		
	}
	
	/** [ENG] Method that returns a String which describe the reason  of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return " [ENG] A piece can not be moved because some of the new positions ocuppied by this piece would be off the board" + 
				"[SPA] Una pieza no se puede mover porque algunas de las posiciones nuevas ocupadas por la pieza estarían fuera del tablero";
		
	}
}