package model;

public class SPiece extends Piece {

	/**
	 * @variable formato de la pieza "S"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 0, 1, 1, 0, 
	    	1, 1, 0, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 1, 0, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 1, 0, 
	    	0, 0, 0, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	    	0, 1, 1, 0, 
	    	1, 1, 0, 0, 
	    	0, 0, 0, 0 },
	      //D90
	      { 1, 0, 0, 0, 
	    	1, 1, 0, 0, 
	    	0, 1, 0, 0, 
	    	0, 0, 0, 0 } 
	};
	
	
	
	public SPiece() {		
		super();
		blockSymbol = '▦';
	}
	
	@Override
	public IPiece copy() {
		IPiece p = new IPiece();
		p.copyAttributes(this);
		return p;
	}
	
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
