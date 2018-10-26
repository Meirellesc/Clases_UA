package model;

public class OPiece extends Piece {

	/**
	 * @variable formato de la pieza "O"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 0, 1, 1, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 1, 1, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D180
	      { 0, 1, 1, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D90
	      { 0, 1, 1, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 } 
	};
	
	
	
	public OPiece() {		
		super();
		blockSymbol = '▣';
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
