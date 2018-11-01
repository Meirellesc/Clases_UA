package model;

import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.WrongSizeException;

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
	 * @throws WrongSizeException 
	 */
	public Game(Coordinate c) throws WrongSizeException {
				
		gameEnded = false;
				
		for (int i = 0; i <= c.getRow(); i++) {
			for (int j = 0; j <= c.getColumn(); j++) {
				board = new Gameboard(new Coordinate(i,j));
			}
		}
	}
	
	/** [ENG] Method that move the piece to left.
	 * 	[SPA] Método que mueve la pieza hacia la izquierda.
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 * @throws OffBoardMovementException 
	 * @throws CollisionMovementException 
	 */
	public void moveCurrentPieceLeft() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		
		Coordinate cadd = new Coordinate(0,-1);
		Coordinate caux = currentPosition;
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		else if (!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(currentPosition);
		}
		else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece 
			throw new CollisionMovementException(currentPosition);
		}
		else {
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
		
			
	}
	
	/** [ENG] Method that move the piece to right.
	 * 	[SPA] Método que mueve la pieza hacia la derecha.
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 * @throws OffBoardMovementException 
	 * @throws CollisionMovementException 
	 */
	public void moveCurrentPieceRight() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		
		Coordinate cadd = new Coordinate(0,1);
		Coordinate caux = currentPosition;
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		else if (!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(currentPosition);
		}
		else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece 
			throw new CollisionMovementException(currentPosition);
		}
		else {
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
		
	}	
	
	/** [ENG] Method that move the piece down.
	 * 	[SPA] Método que mueve la pieza hacia abajo.
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 */
	public void moveCurrentPieceDown() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException {
		
		Coordinate cadd = new Coordinate(1,0);
		Coordinate csub = new Coordinate(-1,0);
		Coordinate caux = currentPosition;
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		else {
			board.removePiece(currentPiece); //remove the piece of the board.
			currentPosition = currentPosition.add(cadd); //update the currentPosition (increasing)
			
			
			if(!isCurrentPieceFixed() || !isGameEnded()) {
				//Condition that check if the next position isn't Valid or isn't Free.
				if (!board.isPlaceValid(currentPosition, currentPiece) || !board.isPlaceFree(currentPosition, currentPiece)) {
					
					currentPiece.setFixed(true); //set piece Fixed.
					currentPosition = currentPosition.add(csub); //update the currentPosition (decreasing).
					board.putPiece(currentPosition, currentPiece); //put the piece updated (last position Valid or Free).
					
					//System.out.println("FIXEI!!");
					
					//Loop that occurs while the last row is full.
					while (board.firstRowFullFromBottom() != -1) {
						int row = board.firstRowFullFromBottom(); //receiving the last row.
						board.clearRow(row); //erasing the last row.
						board.makeUpperRowsFall(row); //moving all the rows down.
					}
					
				}
				else {
					board.putPiece(currentPosition, currentPiece); //put piece updated (the piece is falling).
					currentPiece.setFixed(false); //set piece Not Fixed.
				}
			}
			else {
				currentPosition = caux; //update currentPosition to original value (the piece doesn't move).
				board.putPiece(currentPosition, currentPiece); //put the piece on the board.
			}
		}
		
	}
		
	
			
	/** [ENG] Method that rotate the piece counterclockwise.
	 * 	[SPA] Método que rota la pieza en sentido antihorário.
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 * @throws OffBoardMovementException 
	 * @throws CollisionMovementException 
	 */
	public void rotateCurrentPieceCounterclockwise() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		else if (!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(currentPosition);
		}
		else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece 
			throw new CollisionMovementException(currentPosition);
		}
		else {
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
		
	}
	
	/** [ENG] Method that rotate the piece clockwise.
	 * 	[SPA] Método que rota la pieza en sentido horário.
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 * @throws OffBoardMovementException 
	 * @throws CollisionMovementException 
	 */
	public void rotateCurrentPieceClockwise() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		else if (!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(currentPosition);
		}
		else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece 
			throw new CollisionMovementException(currentPosition);
		}
		else {
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
		
	}
	
	/** [ENG] Method that create a new piece and place it on top of the game board.
	 * 	[SPA] Método que crea una nueva pieza y la coloca en lo alto del tablero.
	 * 
	 * @return = true if is possible to put another piece or if the game is not ended 
	 * and false if can not put another piece or if the game is ended.
	 * @throws GameEndedMovementException 
	 * @throws CurrentPieceNotFixedException 
	 * @throws NoCurrentPieceException 
	 */
	public boolean nextPiece(String type) throws GameEndedMovementException, CurrentPieceNotFixedException, NoCurrentPieceException {
		
		currentPosition = new Coordinate(0, ((board.getWidth())/2) - 2);
		
		//new PieceFactory();
		//currentPiece = PieceFactory.createPiece(type);
		
		if(isGameEnded() && nextPiece(type)) {
			throw new GameEndedMovementException();
		}
		else if (currentPiece != null && !isCurrentPieceFixed()) {
			throw new CurrentPieceNotFixedException();
		}
		else {
			
			new PieceFactory();
			currentPiece = PieceFactory.createPiece(type);
			
			if(board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
				board.putPiece(currentPosition, currentPiece);
				return true;
			}
			else {
				gameEnded = true;
				return false;
			}
		}
		
	}
	
	/** [ENG] Method that check if the current piece is fixed or not.
	 *  [SPA] Método que comprueba si la pieza actual está fija o no. 
	 * 
	 * @return = true if is fixed or false if is not fixed.
	 * @throws NoCurrentPieceException 
	 */
	public boolean isCurrentPieceFixed() throws NoCurrentPieceException {
		
		if (currentPiece == null) {
			throw new NoCurrentPieceException();
		}
		else {
			if(currentPiece.isFixed()) {
				return true;
			}
			else {
				return false;
			}
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
	
	protected Gameboard getGameboard() {
		return board;
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
