package model.exceptions;

import model.Coordinate;

@SuppressWarnings("serial")  
public class CollisionMovementException  extends java.lang.Exception{

	public CollisionMovementException (Coordinate c) {
		
	}
	
	public String getMessage() {
		return " [ENG] A piece can not be moved because it would occupy a cell previously occupied by another piece" + 
				"[SPA] Una pieza no se puede mover porque ocuparía una celda ya ocupada previamente por otra pieza";
		
	}
}