package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class S extends Piece {

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
	
	/** [ENG] Constructor which create a Piece S.
	 *  [SPA] Constructor que crea la Pieza S.
	 *  
	 */
	public S() {		
		super();
		blockSymbol = '▦';
	}
	
	/** [ENG] Method that copy the piece S.
	 *  [SPA] Método que copia la pieza S.
	 *  
	 */
	@Override
	public S copy() {
		S p = new S();
		p.copyAttributes(this);
		return p;
	}

	/** [ENG] Method that take the shape of piece S.
	 *  [SPA] Método que coge la forma de la pieza S.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
