package model.exceptions;

import model.Coordinate;

@SuppressWarnings("serial")  
public class WrongSizeException extends TetrisException{

	public WrongSizeException(Coordinate c) {
		
	}
	
	public String getMessage() {
		return " \n[ENG] A board must have a minimum size that at least the first piece can be put on the board.\n" + 
				"[SPA] Un tablero debe tener un tamaño mínimo que al menos la primera pieza pueda ponerse en el tablero.\n";
		
	}
}