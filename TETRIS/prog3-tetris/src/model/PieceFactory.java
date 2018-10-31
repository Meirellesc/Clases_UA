package model;

public class PieceFactory {

	public PieceFactory() {
		
	}
	
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
		else {//(c == "Z") {
			ZPiece p = new ZPiece();
			return p;
		}
		/*else {
			return null;
		}*/
	}

}
