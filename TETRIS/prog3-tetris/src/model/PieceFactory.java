package model;

import java.util.Objects;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 07/11/2018
 *
 */
public class PieceFactory {

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 *  
	 */
	public PieceFactory() {
		
	}
	
	/** [ENG] Method that create the specific piece according to the parameter.
	 *  [SPA] Método que crea una pieza específica de acuerdo con el parámetro.
	 * 
	 * @param c = the first letter of the piece (Need to be upper-case)
	 * @return the piece chosen.
	 */
	public static Piece createPiece(String c) {
		
		c = Objects.requireNonNull(c,"El parametro 'createPiece(c)' no puede ser null!");
		
		Piece temp = null; //creating a temporary null piece.
		
		try {
			
			temp = (Piece) Class.forName("model." + c.toString()).newInstance(); //calling a class from model."c" and creating a object from it.
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
		
		return temp;
	}
}
