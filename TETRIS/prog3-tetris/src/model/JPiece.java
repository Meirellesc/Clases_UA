package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
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
	
	/** [ENG] Constructor which create a Piece J.
	 *  [SPA] Constructor que crea la Pieza J.
	 *  
	 */
	public JPiece() {		
		super();
		blockSymbol = '◪';
	}
	
	/** [ENG] Method that copy the piece J.
	 *  [SPA] Método que copia la pieza J.
	 *  
	 */
	@Override
	public JPiece copy() {
		JPiece p = new JPiece();
		p.copyAttributes(this);
		return p;
	}

	/** [ENG] Method that take the shape of piece J.
	 *  [SPA] Método que coge la forma de la pieza J.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
