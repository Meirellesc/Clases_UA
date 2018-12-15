package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class Z extends Piece {

	/**
	 * @variable formato de la pieza "Z"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 1, 1, 0, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 0, 1, 0, 
	    	0, 1, 1, 0, 
	    	0, 1, 0, 0, 
	    	0, 0, 0, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	    	1, 1, 0, 0, 
	    	0, 1, 1, 0, 
	    	0, 0, 0, 0 },
	      //D90
	      { 0, 1, 0, 0, 
	    	1, 1, 0, 0, 
	    	1, 0, 0, 0, 
	    	0, 0, 0, 0 } 
	};
	
	/** [ENG] Constructor which create a Piece Z.
	 *  [SPA] Constructor que crea la Pieza Z.
	 *  
	 */
	public Z() {		
		super();
		blockSymbol = '◫';
	}
	
	/** [ENG] Method that copy the piece Z.
	 *  [SPA] Método que copia la pieza Z.
	 *  
	 */
	@Override
	public Z copy() {
		Z p = new Z();
		p.copyAttributes(this);
		return p;
	}

	/** [ENG] Method that take the shape of piece Z.
	 *  [SPA] Método que coge la forma de la pieza Z.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
