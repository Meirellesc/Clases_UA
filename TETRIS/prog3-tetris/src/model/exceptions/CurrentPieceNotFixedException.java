package model.exceptions;

@SuppressWarnings("serial")  
public class CurrentPieceNotFixedException extends java.lang.Exception {

	public CurrentPieceNotFixedException() {

	}
	
	public String getMessage() {
		return " [ENG] The current piece is not fixed and you want to put a new piece on the board" + 
				"[SPA] La pieza actual no está fijada y se quiere poner una nueva pieza en el tablero";
		
	}

}