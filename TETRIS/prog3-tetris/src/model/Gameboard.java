package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import model.exceptions.WrongSizeException;

import java.util.HashSet;



/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 23/09/2018
 */
public class Gameboard {
	
	/**
	 * @variable altura.
	 */
	private int height;
	
	/**
	 * @variable anchura.
	 */
	private int width;
	
	/**
	 * @variable mapa.
	 */
	private Map <Coordinate, Piece> gameboard = new HashMap <Coordinate, Piece> ();
	
	private final static int MINIMUM_BOARD_HEIGHT = 4;
	
	private final static int MINIMUM_BOARD_WIDTH = 4;
	
	
	
	/** [ENG] Constructor which create a Coordinate and count it.
	 *  [SPA] Constructor que crea la Coordenada y añade al total.
	 * 
	 * @param c = input the number of row and column / introduce el número de las filas y columnas.
	 * @throws WrongSizeException 
	 */
	public Gameboard(Coordinate c) throws WrongSizeException {
		
			
		if (c.getRow() < MINIMUM_BOARD_HEIGHT) {
			throw new WrongSizeException(c);
		}
		else if (c.getColumn() < MINIMUM_BOARD_WIDTH) {
			throw new WrongSizeException(c);
		}
		else {
			height = c.getRow();
			width = c.getColumn();
		}
		
	}
	
	/** [ENG] Method that insert a piece in the game board.
	 * 	[SPA] Método que añada una pieza al tablero.
	 * 
	 * @param c = input the coordinates / introduce con la coordenada.
	 * @param p = input the piece / introduce con la pieza.
	 */
	public void putPiece(Coordinate c, Piece p) {
		
		Set<Coordinate> caux = new HashSet<Coordinate>();
		
		//<Set>Coordinates which the piece are occupying		
		caux = p.getAbsoluteCells(c);

				
		//Inserting the piece to these coordinates
		for (Coordinate coords : caux) {
			gameboard.put(coords, p);
		}
	}
	
	/** [ENG] Method which check if the positions belongs to game board.
	 * 	[SPA] Método que comprueba si las posiciones pertencen al tablero.
	 * 
	 * @param c = input the coordinates / introduce con la coordenada.
	 * @param p = input the piece / introduce con la pieza. 
	 * @return = true if its valid place and false if it is not valid place.
	 */
	public boolean isPlaceValid(Coordinate c, Piece p) {
				
		Set<Coordinate> caux = new HashSet<Coordinate>();

		int count = 0;
		//Getting the piece coordinates
		caux = p.getAbsoluteCells(c);
		
		
		//Checking if which coordintates belongs to game board and count it.
		for (Coordinate coords: caux) {
			for (int i = 0; i < getHeight(); i++) {
				for (int j = 0; j < getWidth(); j++){
					if (coords.equals(new Coordinate (i,j))) {
						count += 1;
					}
				}
			}
		}
				
		//If count results 4, it is because all the positions belong to game board.
		if(count == 4) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	/** [ENG] Method which check if the positions are empty.
	 * 	[SPA] Método que comprueba si las posiciones están vacías.
	 * 
	 * @param c = input the coordinates / introduce con la coordenada.
	 * @param p = input the piece / introduce con la pieza. 
	 * @return = true if it is a free place and false if it is occupied.
	 */
	public boolean isPlaceFree(Coordinate c, Piece p) {
		
		Set<Coordinate> caux = new HashSet<Coordinate>();
		
		//Getting the piece coordinates.
		caux = p.getAbsoluteCells(c);
		
		//Check if in these coordinates has a piece and if this piece is fixed.
		for (Coordinate coords : caux) {
			if (gameboard.containsKey(coords)) { 
				if (gameboard.get(coords).isFixed()) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		return true;
	}
	
	/** [ENG] Method that remove a piece from the game board.
	 * 	[SPA] Método que elimina la pieza del tablero. 
	 * 
	 * @param p = input the piece / introduce con la pieza.
	 */
	public void removePiece(Piece p) {
		
		Coordinate coords;
		
		for (int i = 0; i<=getHeight(); i++) {
			for(int j=0; j<= getWidth(); j++) {
				coords = new Coordinate(i,j);
				if (p.equals(gameboard.get(coords))) {
					gameboard.remove(coords, p);
				}
			}
		}
		
	}
	
	/** [ENG] Method that check if in this coordinate have a piece.
	 * 	[SPA] Método que comprueba si nesta coordenadas tienes una pieza.
	 * 
	 * @param c = input the coordinates / introduce con la coordenada.
	 * @return = devuelve una referencia a la pieza contenida en la posición
	 */
	public Piece getCellContent(Coordinate c) {
		if (gameboard.containsKey(c)) 
			return gameboard.get(c); //return piece 
		else
			return null;  //return null 
	}
	
	/** [ENG] Method that insert a piece reference in the game board.
	 * 	[SPA] Método que añada una referencia de la pieza al tablero.
	 * 
	 * @param c = input the coordinates / introduce con la coordenada.
	 * @param p = input the piece / introduce con la pieza. 
	 */
	public void setCellContent(Coordinate c, Piece p) {
		gameboard.put(c, p);
		
	}
	
	/** [ENG] Method that takes the value of row.
	 * 	[SPA] Método que coge el valor de la fila.
	 * 
	 * @return the number(s) of row(s) / devuelve los números de las filas.
	 */
	public int getHeight() {
		return this.height;		
	}
	
	/** [ENG] Method that takes the value of column.
	 * 	[SPA] Método que coge el valor de la columna.
	 * 
	 * @return the number(s) of column(s) / devuelve los números de las columnas.
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder board = new StringBuilder();
		
		Coordinate coords;
		
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				coords = new Coordinate(i,j);
				if (getCellContent(coords) != null) {
					board.append("▒");
				}
				else
					board.append("·");
			}
			board.append("\n");
		}
		return board.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Gameboard other = (Gameboard) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
}