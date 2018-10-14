package model;

import java.util.HashSet;
import java.util.EnumSet;
import java.util.Set;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 28/09/2018
 *
 */
public class Piece {

	private boolean fixed;
	
	private char blockSymbol;
	
	private Rotation orientation;
	
	private static final int BOUNDING_SQUARE_SIZE = 4;

	private static int shape[][] = new int[][] {
	      //D0
		  { 0, 0, 0, 0, 
	    	1, 1, 1, 1, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 0, 1, 0,
	        0, 0, 1, 0, 
	        0, 0, 1, 0, 
	        0, 0, 1, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	        0, 0, 0, 0, 
	        1, 1, 1, 1, 
	        0, 0, 0, 0 },
	      //D90
	      { 0, 1, 0, 0, 
	        0, 1, 0, 0, 
	        0, 1, 0, 0, 
	        0, 1, 0, 0 } 
	};
	      

	public Piece() {
		fixed = false;
		blockSymbol = '▒';
		orientation = Rotation.D0;
	}
	
	public Piece(Piece p) {
		fixed = p.fixed;
		blockSymbol = p.blockSymbol;
		orientation = p.orientation;
	}
	
	public boolean isFixed() { 
		return fixed;
	}
	
	public void setFixed(boolean f) {
		this.fixed = f;
	}
	
	public Rotation getOrientation() {
		return orientation;
	}
	
	public void setOrientation(Rotation r) {
		orientation =  r;
	}
	
	public char getBlockSymbol() {
		return this.blockSymbol;
	}
	
	public void rotateClockwise() {
		if (orientation.equals(Rotation.D0)) {
			orientation = Rotation.D270;
		}
		else if (orientation.equals(Rotation.D270)) {
			orientation = Rotation.D180;
		}
		else if (orientation.equals(Rotation.D180)) {
			orientation = Rotation.D90;
		}
		else {
			orientation = Rotation.D0;
		}
		
	}
	
	public void rotateCounterclockwise() {
		if (orientation.equals(Rotation.D0)) {
			orientation = Rotation.D90;
		}
		else if (orientation.equals(Rotation.D90)) {
			orientation = Rotation.D180;
		}
		else if (orientation.equals(Rotation.D180)) {
			orientation = Rotation.D270;
		}
		else {
			orientation = Rotation.D0;
		}
	}
	

	public Set<Coordinate> getAbsoluteCells(Coordinate c) {
		
		Set<Coordinate> squares = new HashSet<Coordinate>();
		
		//getting the index of orientation ordinal
		int index = orientation.ordinal(); // index = 0 | 1 | 2 | 3
		
		int row_ini = c.getRow(); //getting the initial row
		int column_ini = c.getColumn(); //getting the initial column
		
		Coordinate coords;
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D0
		if(index == 0) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if((i==row_ini+1)&&(j>=column_ini)&&(j<=column_ini+3)) {
						coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
						squares.add(coords); //adding coordinates to squares	
					}
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D90
		else if(index == 3) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if((i>=row_ini)&&(i<=row_ini+3)&&(j==column_ini+1)) {
						coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
						squares.add(coords); //adding coordinates to squares	
					}					
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D180
		else if(index == 2) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if((i==row_ini+2)&&(j>=column_ini)&&(j<=column_ini+3)) {
						coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
						squares.add(coords); //adding coordinates to squares	
					}					
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D270
		else {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if((i>=row_ini)&&(i<=row_ini+3)&&(j==column_ini+2)) {
						coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
						squares.add(coords); //adding coordinates to squares	
					}					
				}
			}
		}
		
		return squares;		
	}
	
	@Override
	public String toString() {
		
		char block = getBlockSymbol();
		
		if (orientation.ordinal() == 0) {
			return "····\n"+ block + block + block + block + "\n····\n····\n";
		}
		else if(orientation.ordinal() == 1) {
			return "··▒·\n··▒·\n··▒·\n··▒·\n";
		}
		else if(orientation.ordinal() == 2) {
			return "····\n····\n▒▒▒▒\n····\n";
		}
		else {
			return "·▒··\n·▒··\n·▒··\n·▒··\n";
		}
	}	

}
