package model;

public class JPiece extends Piece {
	
	/**
	 * @variable formato de la pieza "J"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 1, 0, 0, 0, 
	    	1, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 1, 1, 0,
	        0, 1, 0, 0, 
	        0, 1, 0, 0, 
	        0, 0, 0, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	        1, 1, 1, 0, 
	        0, 0, 1, 0, 
	        0, 0, 0, 0 },
	      //D90
	      { 0, 1, 0, 0, 
	        0, 1, 0, 0, 
	        1, 1, 0, 0, 
	        0, 0, 0, 0 } 
	};
	
	
	
	public JPiece() {		
		super();
		blockSymbol = '◪';
	}
	
	@Override
	public JPiece copy() {
		JPiece p = new JPiece();
		p.copyAttributes(this);
		return p;
	}
	
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
