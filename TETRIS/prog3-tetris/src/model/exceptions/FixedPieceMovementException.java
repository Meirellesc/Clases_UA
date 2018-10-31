package model.exceptions;

@SuppressWarnings("serial")  
public class FixedPieceMovementException extends MovementException {

	public FixedPieceMovementException() {
		
	}
	
	public String getMessage() {
		return " [ENG] A piece can not be moved because its already fixed" + 
				"[SPA] Una pieza no se puede mover porque ya está fijada";
		
	}
}