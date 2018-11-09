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
public class CollisionMovementException  extends MovementException {
	
	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 * @param c = coordinates.
	 */
	public CollisionMovementException (Coordinate c) {
		
	}
	
	/** [ENG] Method that returns a String which describe the reason  of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return " [ENG] A piece can not be moved because it would occupy a cell previously occupied by another piece" + 
				"[SPA] Una pieza no se puede mover porque ocuparía una celda ya ocupada previamente por otra pieza";
		
	}
}