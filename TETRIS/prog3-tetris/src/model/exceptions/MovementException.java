package model.exceptions;

@SuppressWarnings("serial")  
public class MovementException extends TetrisException {

	public MovementException() {
		
	}
	
	public String getMessage() {
		return " [ENG] SUPERCLASS: illegal movement" + 
				"[SPA] SUPERCLASE: Movimiento ilegal";
		
	}
}