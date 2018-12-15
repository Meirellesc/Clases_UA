package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class L extends Piece {

	/**
	 * @variable formato de la pieza "L"
	 */
	protected static int shape[][] = new int[][] {
	      //D0
		  { 0, 0, 1, 0, 
	    	1, 1, 1, 0, 
	    	0, 0, 0, 0, 
	    	0, 0, 0, 0 },
	      //D270
	      { 0, 1, 0, 0,
	        0, 1, 0, 0, 
	        0, 1, 1, 0, 
	        0, 0, 0, 0 },
	      //D180
	      { 0, 0, 0, 0, 
	        1, 1, 1, 0, 
	        1, 0, 0, 0, 
	        0, 0, 0, 0 },
	      //D90
	      { 1, 1, 0, 0, 
	        0, 1, 0, 0, 
	        0, 1, 0, 0, 
	        0, 0, 0, 0 } 
	};
	
	/** [ENG] Constructor which create a Piece L.
	 *  [SPA] Constructor que crea la Pieza L.
	 *  
	 */
	public L() {		
		super();
		blockSymbol = '▧';
	}
	
	/** [ENG] Method that copy the piece L.
	 *  [SPA] Método que copia la pieza L.
	 *  
	 */
	@Override
	public L copy() {
		L p = new L();
		p.copyAttributes(this);
		return p;
	}

	/** [ENG] Method that take the shape of piece L.
	 *  [SPA] Método que coge la forma de la pieza L.
	 *  
	 */
	@Override
	protected int[][] getShape() {
	    return shape;
	}
	
	

}
