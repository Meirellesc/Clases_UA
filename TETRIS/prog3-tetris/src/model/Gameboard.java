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
	
	/**
	 * @variable tamanyo mínimo de la altura.
	 */
	private final static int MINIMUM_BOARD_HEIGHT = 4;
	
	/**
	 * tamanyo minímo de la anchura.
	 */
	private final static int MINIMUM_BOARD_WIDTH = 4;
	
	
	
	/** [ENG] Constructor which create a Coordinate and count it.
	 *  [SPA] Constructor que crea la Coordenada y añade al total.
	 * 
	 * @param c = input the number of row and column / introduce el número de las filas y columnas.
	 * @throws WrongSizeException 
	 */
	public Gameboard(Coordinate c) throws WrongSizeException {
		
		Objects.requireNonNull(c, "Cannot be null");
		
		if (c.getRow() < MINIMUM_BOARD_HEIGHT || c.getColumn() < MINIMUM_BOARD_WIDTH) {
			throw new WrongSizeException(c);
		}
			height = c.getRow();
			width = c.getColumn();
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
	
	
	//----------PRACTICA 3----------
	
	/** [ENG] Method that check if the row indicated as parameter is full. 
	 * 	[SPA] Método que verifica si la fila indicada cómo parámetro está llena.
	 * 
	 * @param r = row
	 * @return true if the row is full or false if the row is not full.
	 */
	private boolean isRowFull(int r) {
		
		//Checking if "r" is a valid row.
		if (r > getHeight() || r <= -1) {
			throw new java.lang.IllegalArgumentException();
		}
		
		Coordinate coords;
		Piece p;
		int count = 0;
		int i = r;
		
		//checking all the cells of the row (r)
		for (int j = 0; j < getWidth(); j++) {
			coords = new Coordinate(i,j);
			p = getCellContent(coords);
			if ( p != null && p.isFixed()) { //condition that check if have a fixed piece in this coordinate and count it.
				count += 1;
		}
			
		}
		if (count == getWidth()) { //condition that check if have a full row.
			return true;
		}
		else {
			return false;
		}
			
	}
	
	/** [ENG] Method that takes the value of the first full row, counting upwards up from the bottom of the board.
	 * 	[SPA] Método que coge el valor de la primera fila llena, contando hacia arriba desde el fondo del tablero.
	 * 
	 * @return the number of the row.
	 */
	public int firstRowFullFromBottom() {
		
		int r = getHeight();
		
		while (r >= 0) {
			if(isRowFull(r)) {
				return (r);
			}
			r = r-1;
		}
		return -1;	
	}
	
	/** [ENG] Method that eliminates all the coordinates of the row put of a parameter.
	 * 	[SPA] Método que elimina todas las coordenadas de la fila puesta cómo parámetro.
	 * 
	 * @param r = row.
	 */
	public void clearRow(int r) {

		//Checking if "r" is a valid row.
		if (r > getHeight() || r <= -1) {
			throw new java.lang.IllegalArgumentException();
		}
		
		Coordinate coords;
		
		for (int i = r; i<=r; i++) {
			for(int j=0; j<= getWidth(); j++) {
				coords = new Coordinate(i,j);
				gameboard.remove(coords);
			}
		}
		
	}
	
	/** [ENG] Method that moves a row down all the pieces that are above the row indicated by the parameter.
	 * 	[SPA] Método que mueve una fila hacia abajo todas las piezas que están por encima de la fila indicada por el parámetro.
	 * 
	 * @param r = row.
	 */
	public void makeUpperRowsFall(int r) {
		
		//Checking if "r" is a valid row.
		if (r > getHeight() || r <= -1) {
			throw new java.lang.IllegalArgumentException();
		}
		
		Coordinate coords;
		Coordinate down = new Coordinate(1,0);
		Piece p;
			
		//for (int i = r; i < 0; i--) {
		while (r > 0) {
			
			for (int j = 0; j <= getWidth(); j++) {
				coords = new Coordinate((r-1),j);
				p = getCellContent(coords);
				//System.out.println("DESCENDO A FILA " + r);
				if ( p != null) {
					gameboard.remove(coords, p);
					coords = coords.add(down);
					gameboard.put(coords, p);
				}
			}
		r = r-1;
		}
		
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder board = new StringBuilder();
		
		Coordinate coords;
		Piece p;
		
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				coords = new Coordinate(i,j);
				p = getCellContent(coords);
				if ( p != null) {
					if (p.getBlockSymbol() == '▒')
						board.append("▒");
					else if (p.getBlockSymbol() == '◪')
						board.append("◪");
					else if (p.getBlockSymbol() == '▧')
						board.append("▧");
					else if (p.getBlockSymbol() == '▣')
						board.append("▣");
					else if (p.getBlockSymbol() == '▦')
						board.append("▦");
					else if (p.getBlockSymbol() == '▤')
						board.append("▤");
					else 
						board.append("◫");
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