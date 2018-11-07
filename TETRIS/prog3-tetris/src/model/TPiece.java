package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class TPiece extends Piece {

	/**
	 * @variable formato de la pieza "T"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 0, 1, 0, 0, 
	    	1, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 1, 0, 0, 
	    	0, 1, 1, 0, 
	    	0, 1, 0, 0, 
	    	0, 0, 0, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	    	1, 1, 1, 0, 
	    	0, 1, 0, 0, 
	    	0, 0, 0, 0 },
	      //D90
	      { 0, 1, 0, 0, 
	    	1, 1, 0, 0, 
	    	0, 1, 0, 0, 
	    	0, 0, 0, 0 } 
	};
	
	/** [ENG] Constructor which create a Piece T.
	 *  [SPA] Constructor que crea la Pieza T.
	 *  
	 */
	public TPiece() {		
		super();
		blockSymbol = '▤';
	}
	
	/** [ENG] Method that copy the piece T.
	 *  [SPA] Método que copia la pieza T.
	 *  
	 */
	@Override
	public TPiece copy() {
		TPiece p = new TPiece();
		p.copyAttributes(this);
		return p;
	}
	

	/** [ENG] Method that take the shape of piece T.
	 *  [SPA] Método que coge la forma de la pieza T.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
