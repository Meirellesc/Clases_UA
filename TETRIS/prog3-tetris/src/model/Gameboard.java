package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
	
	private Map <Coordinate, Piece> gameboard = new HashMap <Coordinate, Piece> ();
	
	/** [ENG] Constructor which create a Coordinate and count it.
	 *  [SPA] Constructor que crea la Coordenada y añade al total.
	 * 
	 * @param c = input the number of row and column / introduce el número de las filas y columnas.
	 */
	public Gameboard(Coordinate c) {
		height = c.getRow();
		width = c.getColumn();
	}
	
	public void putPiece(Coordinate c, Piece p) {
		
		Set<Coordinate> caux = new HashSet<Coordinate>();
		
		//<Set>Coordinates which the piece are occupying		
		caux = p.getAbsoluteCells(c);
		//System.out.println("ABS CELLS  " + p.getAbsoluteCells(c));
				
		//Inserting the piece to these coordinates
		for (Coordinate coords : caux) {
			//System.out.println("ADDING TO GAMEBOARD  " + coords);
			gameboard.put(coords, p);
		}
		
		//System.out.println("GB CONTAINS P: " + gameboard.containsValue(p));
		
		//System.out.println("GB SIZE" + gameboard.size());
		
	}
	

	public boolean isPlaceValid(Coordinate c, Piece p) {
				
		Set<Coordinate> coords = new HashSet<Coordinate>();
		Set<Coordinate> board = new HashSet<Coordinate>();
		
		coords = p.getAbsoluteCells(c);
		System.out.println("ABS CELLS: " + p.getAbsoluteCells(c));
		
		for (int i = 0; i <= getHeight(); i++) {
			for (int j = 0; j <= getWidth(); j++) {
				board.add(new Coordinate(i,j));
			}
		}
		
		if (board.containsAll(coords)) {
			return true;
		}
		else
			return false;
		
	}
	
	public boolean isPlaceFree(Coordinate c, Piece p) {
		//System.out.println("GB CONTAINS C: " + gameboard.containsKey(c));
		
		if (p.isFixed() == true || gameboard.containsKey(c) == true) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
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
	
	public Piece getCellContent(Coordinate c) {
		
		//System.out.println("values" + gameboard.values());
		//System.out.println("GB CONTAINS C: " + gameboard.containsKey(c));
		if (gameboard.containsKey(c) == true) {
			//System.out.println("GETCELL " + gameboard.get(c));
			//System.out.println("ENTREI IF");
			return gameboard.get(c); //return piece 
		}
		else
			//System.out.println("ENTREI ELSE");
			return null;  //return null 
	}
	
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