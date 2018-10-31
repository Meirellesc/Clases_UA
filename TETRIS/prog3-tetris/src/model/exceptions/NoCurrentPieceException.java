package model.exceptions;

@SuppressWarnings("serial")
public class NoCurrentPieceException extends TetrisException {

	public NoCurrentPieceException() {
		
	}
	
	public String getMessage() {
		return " [ENG] The game has not started yet, therefore, there is no current piece\n" + 
				"[SPA] La partida no ha empezado todavía, y por tanto, no hay pieza actual";
		
	}

}
