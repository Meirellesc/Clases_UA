package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 28/09/2018
 *
 */
public class Game {
	
	/**
	 * @variable juego acabado.
	 */
	private boolean gameEnded;
	
	/**
	 * @variable tablero.
	 */
	Gameboard board;
	
	/**
	 * @variable posición actual.
	 */
	Coordinate currentPosition;
	
	/**
	 * @variable pieza actual.
	 */
	Piece currentPiece;
	
	/** [ENG] Constructor which create the game board with the size of the coordinates.
	 *  [SPA] Constructor que crea el tablero con el tamaño de las coordenadas.
	 * 
	 * @param c = input the coordinates / introduce com la coordenada.
	 */
	public Game(Coordinate c) {
		
		gameEnded = false;
		
		for (int i = 0; i <= c.getRow(); i++) {
			for (int j = 0; j <= c.getColumn(); j++) {
				board = new Gameboard(new Coordinate(i,j));
			}
		}
	}
	
	/** [ENG] Method that move the piece to left.
	 * 	[SPA] Método que mueve la pieza hacia la izquierda.
	 */
	public void moveCurrentPieceLeft() {
		
		Coordinate cadd = new Coordinate(0,-1);
		Coordinate caux = currentPosition;
		
		board.removePiece(currentPiece);
		currentPosition = currentPosition.add(cadd);
		
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			board.putPiece(currentPosition, currentPiece);
		}
		else {
			currentPosition = caux;
			board.putPiece(currentPosition, currentPiece);
		}
			
	}
	
	/** [ENG] Method that move the piece to right.
	 * 	[SPA] Método que mueve la pieza hacia la derecha.
	 */
	public void moveCurrentPieceRight() {
		
		Coordinate cadd = new Coordinate(0,1);
		Coordinate caux = currentPosition;
		
		board.removePiece(currentPiece);
		currentPosition = currentPosition.add(cadd);
		
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			board.putPiece(currentPosition, currentPiece);
		}
		else {
			currentPosition = caux;
			board.putPiece(currentPosition, currentPiece);
		}
	}
	
	
	/** [ENG] Method that move the piece down.
	 * 	[SPA] Método que mueve la pieza hacia abajo.
	 */
	public void moveCurrentPieceDown() {
		
		Coordinate cadd = new Coordinate(1,0);
		Coordinate csub = new Coordinate(-1,0);
		Coordinate caux = currentPosition;
		
		board.removePiece(currentPiece);
		currentPosition = currentPosition.add(cadd);
		
		
		if(!isCurrentPieceFixed() || !isGameEnded()) {
			if (!board.isPlaceValid(currentPosition, currentPiece) || !board.isPlaceFree(currentPosition, currentPiece)) {
				currentPiece.setFixed(true);			
				currentPosition = currentPosition.add(csub);
				board.putPiece(currentPosition, currentPiece);		
			}
			else {
				currentPiece.setFixed(false);			
				board.putPiece(currentPosition, currentPiece);
			}
		}
		else {
			currentPosition = caux;
			board.putPiece(currentPosition, currentPiece);
		}
	}
		
	
			
	/** [ENG] Method that rotate the piece counterclockwise.
	 * 	[SPA] Método que rota la pieza en sentido antihorário.
	 */
	public void rotateCurrentPieceCounterclockwise() {
		
		if (!isCurrentPieceFixed() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece) && !isGameEnded()) {
			if(currentPiece.getOrientation() == Rotation.D0) {
				currentPiece.setOrientation(Rotation.D90);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D90) {
				currentPiece.setOrientation(Rotation.D180);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D180) {
				currentPiece.setOrientation(Rotation.D270);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
			}
			else {
				currentPiece.setOrientation(Rotation.D0);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
			}
		}
	}
	
	/** [ENG] Method that rotate the piece clockwise.
	 * 	[SPA] Método que rota la pieza en sentido horário.
	 */
	public void rotateCurrentPieceClockwise() {
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			if(currentPiece.getOrientation() == Rotation.D0) {
				currentPiece.setOrientation(Rotation.D270);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D270) {
				currentPiece.setOrientation(Rotation.D180);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D180) {
				currentPiece.setOrientation(Rotation.D90);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
			}
			else {
				currentPiece.setOrientation(Rotation.D0);
				board.removePiece(currentPiece);
				if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece))
					board.putPiece(currentPosition, currentPiece);
				else
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
			}
		}
	}
	
	/** [ENG] Method that create a new piece and place it on top of the game board.
	 * 	[SPA] Método que crea una nueva pieza y la coloca en lo alto del tablero.
	 * 
	 * @return = true if is possible to put another piece or if the game is not ended.
	 */
	public boolean nextPiece() {
		currentPosition = new Coordinate(0, ((board.getWidth())/2) - 2);
		
		currentPiece = new Piece();
		
		if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			board.putPiece(currentPosition, currentPiece);
			return true;
		}
		else {
			gameEnded = true;
			return false;
		}
		
		
	}
	
	/** [ENG] Method that check if the current piece is fixed or not.
	 *  [SPA] Método que comprueba si la pieza actual está fija o no. 
	 * 
	 * @return = true if is fixed or false if is not fixed.
	 */
	public boolean isCurrentPieceFixed() {
		
		if(currentPiece.isFixed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** [ENG] Method that check if the game is ended. 
	 * 	[SPA] Método que comprueba si el juego ha terminado.
	 * 
	 * @return true if the game is ended or false if not.
	 */
	public boolean isGameEnded() {
		return gameEnded;
	}

	@Override
	public String toString() {
	
		StringBuilder boards = new StringBuilder();
		Coordinate coords;
		
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				coords = new Coordinate(i,j);
				if (board.getCellContent(coords) != null) {
					boards.append("▒");
				}
				else
					boards.append("·");
			}
			boards.append("\n");
		}
		return boards.toString();	
	}
	
}
