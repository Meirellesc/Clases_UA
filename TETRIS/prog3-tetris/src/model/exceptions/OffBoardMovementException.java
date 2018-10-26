package model.exceptions;

import model.Coordinate;

@SuppressWarnings("serial")  
public class OffBoardMovementException extends java.lang.Exception{

	//private Coordinate c;
	
	public OffBoardMovementException(Coordinate c) {
		
	}
	
	public String getMessage() {
		return " [ENG] A piece can not be moved because some of the new positions ocuppied by this piece would be off the board" + 
				"[SPA] Una pieza no se puede mover porque algunas de las posiciones nuevas ocupadas por la pieza estarían fuera del tablero";
		
	}
}