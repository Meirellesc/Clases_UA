package model.exceptions;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
@SuppressWarnings("serial")  
public class GameEndedMovementException extends MovementException {
	
	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public GameEndedMovementException() {
		
	}
	
	/** [ENG] Method that returns a String which describe the reason  of the exception that is throwing.
	 *  [SPA] Método que devolverá una cadena que describirá la razón de la excepción que se está lanzando.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return " [ENG] A piece can not be moved or added to the game because the game already over" + 
				"[SPA] Una pieza no se puede mover o añadir a la partida porque la partida ya se ha terminado";
		
	}
}