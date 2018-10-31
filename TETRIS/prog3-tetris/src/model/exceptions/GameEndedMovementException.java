package model.exceptions;

@SuppressWarnings("serial")  
public class GameEndedMovementException extends MovementException {
	public GameEndedMovementException() {
		
	}
	
	public String getMessage() {
		return " [ENG] A piece can not be moved or added to the game because the game already over" + 
				"[SPA] Una pieza no se puede mover o añadir a la partida porque la partida ya se ha terminado";
		
	}
}