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
		
		board = new Gameboard(c);
				
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
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		
		Coordinate cadd = new Coordinate(0,-1); // Coordinate that makes the piece go to left.
		Coordinate caux = currentPosition.add(cadd);//Coordinate auxiliary to test the exceptions.
		
		if (!board.isPlaceValid(caux, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(caux);
		}
		else if (!board.isPlaceFree(caux, currentPiece)) { // If the new position would result in a collision with another piece
			throw new CollisionMovementException(caux);
		}
		
		board.removePiece(currentPiece);//erasing the piece.
		caux = currentPosition;//updating aux to original coordinates.
		currentPosition = currentPosition.add(cadd);//working with the current piece to move the piece.
		
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
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 * @throws OffBoardMovementException 
	 * @throws CollisionMovementException 
	 */
	public void moveCurrentPieceRight() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		
		Coordinate cadd = new Coordinate(0,1); //Coordinate that makes the piece go to right.
		Coordinate caux = currentPosition.add(cadd); //Coordinate auxiliary to test the exceptions.
		
		if (!board.isPlaceValid(caux, currentPiece)) { // If the new position it will be off the board
			throw new OffBoardMovementException(caux);
		}
		else if (!board.isPlaceFree(caux, currentPiece)) { // If the new position would result in a collision with another piece
			throw new CollisionMovementException(caux);
		}
		
		board.removePiece(currentPiece); // erasing the piece.
		caux = currentPosition; //updating aux to original coordinates.
		currentPosition = currentPosition.add(cadd); //working with the current piece to move the piece.
		
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			board.putPiece(currentPosition, currentPiece);
		}
		else { //if is not Valid or Free cell, the piece stay at the same place.
			currentPosition = caux;
			board.putPiece(currentPosition, currentPiece);
		}
	}	
	
	/** [ENG] Method that move the piece down.
	 * 	[SPA] Método que mueve la pieza hacia abajo.
	 * 
	 * @throws NoCurrentPieceException 
	 * @throws GameEndedMovementException 
	 * @throws FixedPieceMovementException 
	 */
	public int moveCurrentPieceDown() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException {
		
		if (currentPiece == null) { // If the first piece has not been put on the board
			throw new NoCurrentPieceException();
		}
		else if (isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if (isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		
		Coordinate cadd = new Coordinate(1,0);
		Coordinate caux = currentPosition;
		int rows = 0;
		
		board.removePiece(currentPiece); //remove the piece of the board.
		currentPosition = currentPosition.add(cadd); //update the currentPosition (increasing)
		
		//Condition that check if the next position is not valid or not free
		if (!board.isPlaceValid(currentPosition, currentPiece) || !board.isPlaceFree(currentPosition, currentPiece)) {
			currentPosition = caux; //update the currentPosition (original).
			board.putPiece(currentPosition, currentPiece); //put the piece updated (last position Valid or Free).
			currentPiece.setFixed(true); //set piece Fixed.
			
			//Loop that occurs while the last row is full.
			while (board.firstRowFullFromBottom() != -1) {
				int row = board.firstRowFullFromBottom(); //receiving the last row.
				board.clearRow(row); //erasing the last row.
				board.makeUpperRowsFall(row); //moving all the rows down.
				rows += 1; //Counting how many rows were cleared.
			}
		}
		else { //How the next position is Valid and Free the Piece is falling.
			board.putPiece(currentPosition, currentPiece); //put piece updated (the piece is falling).
			currentPiece.setFixed(false); //set piece Not Fixed.
		}
		return rows;
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
		
		if (board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			if(currentPiece.getOrientation() == Rotation.D0) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D90);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D90) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D180);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D180) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D270);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D0);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
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
		if (!isCurrentPieceFixed() && !isGameEnded() && board.isPlaceValid(currentPosition, currentPiece) && board.isPlaceFree(currentPosition, currentPiece)) {
			if(currentPiece.getOrientation() == Rotation.D0) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D270);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D0);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D270) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D180);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D270);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else if(currentPiece.getOrientation() == Rotation.D180) {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D90);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D180);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
			else {
				board.removePiece(currentPiece);
				currentPiece.setOrientation(Rotation.D0);
				if(!board.isPlaceValid(currentPosition, currentPiece)) { // If the new position it will be off the board
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
					throw new OffBoardMovementException(currentPosition);
				}
				else if (!board.isPlaceFree(currentPosition, currentPiece)) { // If the new position would result in a collision with another piece
					currentPiece.setOrientation(Rotation.D90);
					board.putPiece(currentPosition, currentPiece);
					throw new CollisionMovementException(currentPosition);
				}
				board.putPiece(currentPosition, currentPiece);
			}
		}
		
		
	}
	
	/** [ENG] Method that create a new piece and place it on top of the game board.
	 * 	[SPA] Método que crea una nueva pieza y la coloca en lo alto del tablero.
	 * 
	 * @param type = it is the type of the piece.
	 * @return = true if is possible to put another piece or if the game is not ended 
	 * and false if can not put another piece or if the game is ended.
	 * @throws GameEndedMovementException 
	 * @throws CurrentPieceNotFixedException 
	 * @throws NoCurrentPieceException 
	 */
	public boolean nextPiece(String type) throws GameEndedMovementException, CurrentPieceNotFixedException, NoCurrentPieceException {
		
		if(isGameEnded()) {
			throw new GameEndedMovementException();
		}
		
		else if (currentPiece != null && !isCurrentPieceFixed()) {
			throw new CurrentPieceNotFixedException();
		}
		
		currentPosition = new Coordinate(0, ((board.getWidth())/2) - 2);
		
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
	
	/** [ENG] Method that returns a reference of the board used in the game.
	 * 	[SPA] Método que devuelve una referencia al tablero usado en el juego.
	 * 
	 * @return the game board.
	 */
	//protected Gameboard getGameboard() {
	public Gameboard getGameboard() {
		return board;
	}

	@Override
	public String toString() {
	
		StringBuilder boards = new StringBuilder();
		Coordinate coords;
		Piece p;
		
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				coords = new Coordinate(i,j);
				p = board.getCellContent(coords);
				if (p != null) {
					if (p.getBlockSymbol() == '▒') { // PIECE I
						boards.append("▒");
					}
					else if (p.getBlockSymbol() == '◪') { // PIECE J
						boards.append("◪");
					}
					else if (p.getBlockSymbol() == '▧') { // PIECE L
						boards.append("▧");
					}
					else if (p.getBlockSymbol() == '▣') { // PIECE O
						boards.append("▣");
					}
					else if (p.getBlockSymbol() == '▦') { // PIECE S
						boards.append("▦");
					}
					else if (p.getBlockSymbol() == '▤') { // PIECE T
						boards.append("▤");
					}
					else { // PIECE Z
						boards.append("◫");
					}	
				}
				else
					boards.append("·");
			}
			boards.append("\n");
		}
		return boards.toString();	
	}
	
}

