package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class I extends Piece {

	/**
	 * @variable formato de la pieza "I"
	 */
	protected static int shape[][] = new int[][] {
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
	
	/** [ENG] Constructor which create a Piece I.
	 *  [SPA] Constructor que crea la Pieza I.
	 *  
	 */
	public I() {		
		super();
		blockSymbol = '▒';
	}
	
	/** [ENG] Method that copy the piece I.
	 *  [SPA] Método que copia la pieza I.
	 *  
	 */
	@Override
	public I copy() {
		I p = new I();
		p.copyAttributes(this);
		return p;
	}
	
	/** [ENG] Method that take the shape of piece I.
	 *  [SPA] Método que coge la forma de la pieza I.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
