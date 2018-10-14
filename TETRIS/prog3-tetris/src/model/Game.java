package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 28/09/2018
 *
 */
public class Game {
	
	private boolean gameEnded;
	
	Gameboard board;
	
	Coordinate currentPosition;
	
	Piece p = new Piece();
		
	public Game(Coordinate c) {
		
		gameEnded = false;
		
		Coordinate coords;
		
		for (int i = 0; i < c.getRow(); i++) {
			for (int j = 0; j < c.getColumn(); j++) {
				coords = (new Coordinate(i,j));
				board = new Gameboard(coords);
			}
		}
	}
	
	public void moveCurrentPieceLeft() {
		
		Coordinate coords = new Coordinate(0,0);
		
		if (isCurrentPieceFixed() == false && isGameEnded() == false && board.isPlaceValid(currentPosition, p) == true && board.isPlaceFree(currentPosition, p) == true) {
			board.removePiece(p);
			currentPosition.add(coords);
			board.putPiece(currentPosition, p);
		}
	}
	
	public void moveCurrentPieceRight() {
		
		Coordinate coords = new Coordinate(0,0);
		
		if (isCurrentPieceFixed() == false && isGameEnded() == false && board.isPlaceValid(currentPosition, p) == true && board.isPlaceFree(currentPosition, p) == true) {
			board.removePiece(p);
			currentPosition.add(coords);
			board.putPiece(currentPosition, p);
		}
	}
	
	public void moveCurrentPieceDown() {
		
		if ((isCurrentPieceFixed() == true && isGameEnded() == true) && (board.isPlaceValid(currentPosition, p) == false || board.isPlaceFree(currentPosition, p) == false)) {
			p.setFixed(true);
		}
		else {
			p.setFixed(false);
		}
	}
	
	public void rotateCurrentPieceCounterclockwise() {
		
		if (isCurrentPieceFixed() == false && board.isPlaceValid(currentPosition, p) == true && board.isPlaceFree(currentPosition, p) == true && isGameEnded() == false) {
			if(p.getOrientation() == Rotation.D0) {
				p.setOrientation(Rotation.D90);
			}
			else if(p.getOrientation() == Rotation.D90) {
				p.setOrientation(Rotation.D180);
			}
			else if(p.getOrientation() == Rotation.D180) {
				p.setOrientation(Rotation.D270);
			}
			else {
				p.setOrientation(Rotation.D0);
			}
		}
	}
	
	public void rotateCurrentPieceClockwise() {
		
		if (isCurrentPieceFixed() == false && isGameEnded() == false && board.isPlaceValid(currentPosition, p) == true && board.isPlaceFree(currentPosition, p) == true) {
			if(p.getOrientation() == Rotation.D0) {
				p.setOrientation(Rotation.D270);
			}
			else if(p.getOrientation() == Rotation.D270) {
				p.setOrientation(Rotation.D180);
			}
			else if(p.getOrientation() == Rotation.D180) {
				p.setOrientation(Rotation.D90);
			}
			else {
				p.setOrientation(Rotation.D0);
			}
		}	
	}
	
	public boolean nextPiece() {
			
		currentPosition = new Coordinate(0, (board.getWidth()/2) - 2).add(new Coordinate(0,1));
		System.out.println("CURRT POS: " + currentPosition);
		
		System.out.println("PLACE VALID :" + board.isPlaceValid(currentPosition, p));
		System.out.println("PLACE FREE :" + board.isPlaceFree(currentPosition, p));
		System.out.println("CURRENT PIECE FIXED :" + isCurrentPieceFixed());
		System.out.println("PIECE FIXED :" + p.isFixed());
		System.out.println("GAME ENDED :" + isGameEnded());
		
		
		if(board.isPlaceValid(currentPosition, p) == true && board.isPlaceFree(currentPosition, p) == true && isGameEnded() == false && isCurrentPieceFixed()==false) {
			board.putPiece(currentPosition, p);
			moveCurrentPieceDown();
			return true;
		}
		else {
			gameEnded = true;
			return false;
		}
		
		
	}
	
	public boolean isCurrentPieceFixed() {
		
		if(p.isFixed() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isGameEnded() {
		return gameEnded;
	}

	@Override
	public String toString() {
	
		
		StringBuilder boards = new StringBuilder();
		Coordinate coords;
		
		for (int i = 0; i <= board.getHeight(); i++) {
			for (int j = 0; j <= board.getWidth(); j++) {
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

