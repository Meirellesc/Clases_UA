package model;

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
		
		if(c == "I") {
			IPiece p = new IPiece();
			return p;
		}
		else if (c == "J") {
			JPiece p = new JPiece();
			return p;
		}
		else if (c == "L") {
			LPiece p = new LPiece();
			return p;
		}
		else if (c == "O") {
			OPiece p = new OPiece();
			return p;
		}
		else if (c == "S") {
			SPiece p = new SPiece();
			return p;
		}
		else if (c == "T") {
			TPiece p = new TPiece();
			return p;
		}
		else if (c == "Z") {
			ZPiece p = new ZPiece();
			return p;
		}
		else {
			return null;
		}
	}

}
