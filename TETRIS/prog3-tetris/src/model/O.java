package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class O extends Piece {

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
	
	/** [ENG] Constructor which create a Piece O.
	 *  [SPA] Constructor que crea la Pieza O.
	 *  
	 */
	public O() {		
		super();
		blockSymbol = '▣';
	}
	
	/** [ENG] Method that copy the piece O.
	 *  [SPA] Método que copia la pieza O.
	 *  
	 */
	@Override
	public O copy() {
		O p = new O();
		p.copyAttributes(this);
		return p;
	}
	
	/** [ENG] Method that take the shape of piece O.
	 *  [SPA] Método que coge la forma de la pieza O.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
