/**
 * Main package for the first assignment.
 */
package mains;

import java.util.ArrayList;

import model.Coordinate;
import model.Game;
import model.Piece;
import model.Rotation;
import model.Gameboard;

/**
 * @author Lucas  Meirelles
 * @version Oxygen 4.7
 **/
public class Main1 {

	/**
	 * Entry method.
	 * @param args Arguments from command line.
	 */
	public static void main(String[] args) {
		Coordinate c0; // no instance created for c0 
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(10,10);
		Coordinate c3 = new Coordinate(4,3);
		Coordinate c4 = new Coordinate(5,15);
		Coordinate c5 = new Coordinate(c4);
		Coordinate c6 = new Coordinate(2,5);
		System.out.println(c1.toString());
		System.out.println();
		
		System.out.println(c2.toString());
		System.out.println();

		System.out.println(c3.toString());
		System.out.println();
		
		System.out.println(c4.toString());
		System.out.println();

		System.out.println(c5.toString());
		System.out.println();
		
		Coordinate s = c3.add(c6);
		System.out.println(c3.toString() + "+" + c6.toString() + "= " + s.toString());
		System.out.println();
		
		Coordinate [] v = new Coordinate[5];
		for (int i=0; i<5; i++) {
			v[i] = new Coordinate(i,4-i);
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(v[i].getRow() + "," + v[i].getColumn());
		}

		ArrayList<Coordinate> v2 = new ArrayList<Coordinate>();
		for (int i=0; i<8; i++) {
			v2.add(new Coordinate(i, i));
			System.out.println(v2.get(i).toString());
		}
		
		Coordinate c7 = c1.add(c3);
		if (c7.equals(c3)) {
			System.out.println("c7 and c3 are equal");
		}

		System.out.println("Coordinate count: " + Coordinate.getCoordinateCount());
		
		
		//TEST PIECE
		
		Piece p1 = new Piece();
		Piece p2 = new Piece();
		/*
		char p = p1.getBlockSymbol();
		System.out.println("Ordinal 1 :  " + p1.getOrdinal());
		p1.setOrientation(Rotation.D270);
		System.out.println("Ordinal 2 :  " + p1.getOrdinal());
		System.out.println("Orientation 2 :  " + p1.getOrientation());
		
		p1.setOrientation(Rotation.D180);
		int a = p1.getShape();
		System.out.println("a:  " + a);
		
		p1.setOrientation(Rotation.D270);
		System.out.println("\nAbsoluteCells: \n");
		System.out.println(p1.getAbsoluteCells(c1)); 
		*/
		
		//TEST GAMEBOARD
		Gameboard g = new Gameboard(c3);
		
		/*
		g.setCellContent(c3, p1);
		g.setCellContent(c2, p2);
		g.getCellContent(c3);
		g.getCellContent(c2);
		*/
		g.putPiece(c3, p2);
		//System.out.println("p2 STRING: " + p2.toString());
		g.isPlaceValid(new Coordinate(-1,-1), p1);
		//System.out.println("g STRING: " + g.toString());
		//g.setCellContent(c3, p2);
		//g.getCellContent(new Coordinate(5,3));
		//g.getCellContent(c3);
		//System.out.println(g.getCellContent(c3));
		
		//g.isPlaceFree(new Coordinate(5,3), p2);
		
		//Game game = new Game(c2);
		 
	}

}
