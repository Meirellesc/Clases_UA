package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 28/09/2018
 *
 */
public abstract class Piece {
	/**
	 * @variable fijo
	 */
	private boolean fixed;
	
	/**
	 * @variable simbolo de la pieza
	 */
	protected char blockSymbol;
	
	/**
	 * @variable orientación de la pieza 
	 */
	private Rotation orientation;
	
	/**
	 * @variable zona ocupada por la pieza
	 */
	private static final int BOUNDING_SQUARE_SIZE = 4;

	      
	/** [ENG] Constructor which create a Piece.
	 *  [SPA] Constructor que crea la Pieza.
	 *  
	 */
	public Piece() {
		fixed = false;
		orientation = Rotation.D0;
	}
	
	/** [ENG] Method that check if the piece is fixed or not.
	 *  [SPA] Método que comprueba si la pieza esta fija o no. 
	 * 
	 * @return = true if is fixed or false if is not fixed.
	 */
	public boolean isFixed() { 
		return fixed;
	}
	
	/** [ENG] Method that set if the piece is fixed or not.
	 *  [SPA] Método que establece si la pieza esta fija o no. 
	 *   
	 * @param f = input true if the piece are fixed. / ingresa cierto se la pieza está fija.
	 */
	public void setFixed(boolean f) {		
		this.fixed = f;
	}
	
	/** [ENG] Method that takes the piece orientation.
	 * 	[SPA] Método que coge la orientación de la pieza.
	 * 
	 * @return = la orientación de la pieza.
	 */
	public Rotation getOrientation() {
		return orientation;
	}
	
	/** [ENG] Method that set the piece orientation.
	 * 	[SPA] Método que estabelece la orientación de la pieza.
	 * 
	 * @param r = input the orientation. / ingresa con la orientación.
	 */
	public void setOrientation(Rotation r) {
		this.orientation = Objects.requireNonNull(orientation, "El parametro 'orientation' no puede ser null");
		
		orientation =  r;
	}
	
	/** [ENG] Method that takes the piece symbol.
	 * 	[SPA] Método que coge el símbolo de la pieza.
	 * 
	 * @return = el símbolo de la pieza.
	 */
	public char getBlockSymbol() {
		return this.blockSymbol;
	}
	
	/** [ENG] Method that rotate the piece clockwise.
	 * 	[SPA] Método que rota la pieza en sentido horário.
	 */
	public void rotateClockwise() {
		if (orientation.equals(Rotation.D0)) {
			orientation = Rotation.D270;
		}
		else if (orientation.equals(Rotation.D270)) {
			orientation = Rotation.D180;
		}
		else if (orientation.equals(Rotation.D180)) {
			orientation = Rotation.D90;
		}
		else {
			orientation = Rotation.D0;
		}
		
	}
	
	/** [ENG] Method that rotate the piece counterclockwise.
	 * 	[SPA] Método que rota la pieza en sentido antihorário.
	 */
	public void rotateCounterclockwise() {
		if (orientation.equals(Rotation.D0)) {
			orientation = Rotation.D90;
		}
		else if (orientation.equals(Rotation.D90)) {
			orientation = Rotation.D180;
		}
		else if (orientation.equals(Rotation.D180)) {
			orientation = Rotation.D270;
		}
		else {
			orientation = Rotation.D0;
		}
	}
	
	/** [ENG] Method that take the coordinates which are occupied by the piece.
	 * 	[SPA] Método que coge las coordenadas que están ocupadas por la pieza.
	 * 
	 * @param c = input the coordinates / introduce com la coordenada.
	 * @return = the Set<Coordinates> which are occupied by the piece.
	 */
	public Set<Coordinate> getAbsoluteCells(Coordinate c) {
		
		Set<Coordinate> squares = new HashSet<Coordinate>();
		
		//getting the index of orientation ordinal
		int index = orientation.ordinal(); // index = 0 | 1 | 2 | 3
		
		int row_ini = c.getRow(); //getting the initial row
		int column_ini = c.getColumn(); //getting the initial column
		
		Coordinate coords;
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D0
		if(index == 0) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if (getBlockSymbol() == '▒') { // PIECE I
						if((i==row_ini+1)&&(j>=column_ini)&&(j<=column_ini+3)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares	
						}
					}
					else if(getBlockSymbol() == '◪') { // PIECE J
						if((i==row_ini && j==column_ini) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▧') { // PIECE L
						if((i==row_ini && j==column_ini+2) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▣') { // PIECE O
						if((i==row_ini && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▦') { // PIECE S
						if((i==row_ini && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+1 && j>=column_ini && j<=column_ini+1) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▤') { // PIECE T
						if((i==row_ini && j==column_ini+1) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else { // PIECE Z
						if((i==row_ini && j>=column_ini && j<=column_ini+1) || (i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D90
		else if(index == 3) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if (getBlockSymbol() == '▒') { // PIECE I
						if((i>=row_ini)&&(i<=row_ini+3)&&(j==column_ini+1)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares	
						}
					}
					else if(getBlockSymbol() == '◪') { // PIECE J
						if((i>=row_ini && i<=row_ini+2 && j==column_ini+1) || (i==row_ini+2 && j==column_ini)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▧') { // PIECE L
						if((i==row_ini && j==column_ini) || (i>=row_ini && i<=row_ini+2 && j==column_ini+1) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▣') { // PIECE O
						if((i==row_ini && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▦') { // PIECE S
						if((i>=row_ini && i<=row_ini+1 && j==column_ini) || (i>=row_ini+1 && i<=row_ini+2 && j==column_ini+1)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▤') { // PIECE T
						if((i>=row_ini && i<=row_ini+2 && j==column_ini+1) || (i==row_ini+1 && j==column_ini)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else { // PIECE Z
						if((i>=row_ini+1 && i<=row_ini+2 && j==column_ini) || (i>=row_ini && i<=row_ini+1 && j==column_ini+1)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
										
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D180
		else if(index == 2) {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if (getBlockSymbol() == '▒') { // PIECE I
						if((i==row_ini+2)&&(j>=column_ini)&&(j<=column_ini+3)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares	
						}
					}
					else if(getBlockSymbol() == '◪') { // PIECE J
						if((i==row_ini+2 && j==column_ini+2) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▧') { // PIECE L
						if((i==row_ini+2 && j==column_ini) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▣') { // PIECE O
						if((i==row_ini && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▦') { // PIECE S
						if((i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+2 && j>=column_ini && j<=column_ini+1) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▤') { // PIECE T
						if((i==row_ini+2 && j==column_ini+1) || (i==row_ini+1 && j>=column_ini && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else { // PIECE Z
						if((i==row_ini+1 && j>=column_ini && j<=column_ini+1) || (i==row_ini+2 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
										
				}
			}
		}
		
		//CONDITION FOR WHEN THE PIECE HAVE THE ORIENTATION D270
		else {
			for (int i = row_ini; i <= row_ini+3; i++) {
				for(int j = column_ini; j <= column_ini+3; j++) {
					if (getBlockSymbol() == '▒') { // PIECE I
						if((i>=row_ini)&&(i<=row_ini+3)&&(j==column_ini+2)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares	
						}
					}
					else if(getBlockSymbol() == '◪') { // PIECE J
						if ((i>=row_ini && i<=row_ini+2 && j==column_ini+1) || (i==row_ini && j==column_ini+2)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares	
						}
					}
					else if(getBlockSymbol() == '▧') { // PIECE L
						if((i==row_ini+2 && j==column_ini+2) || (i>=row_ini && i<=row_ini+2 && j==column_ini+1) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▣') { // PIECE O
						if((i==row_ini && j>=column_ini+1 && j<=column_ini+2) || (i==row_ini+1 && j>=column_ini+1 && j<=column_ini+2) ) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▦') { // PIECE S
						if((i>=row_ini && i<=row_ini+1 && j==column_ini+1) || (i>=row_ini+1 && i<=row_ini+2 && j==column_ini+2)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else if(getBlockSymbol() == '▤') { // PIECE T
						if((i>=row_ini && i<=row_ini+2 && j==column_ini+1) || (i==row_ini+1 && j==column_ini+2)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
					else { // PIECE Z
						if((i>=row_ini+1 && i<=row_ini+2 && j==column_ini+1) || (i>=row_ini && i<=row_ini+1 && j==column_ini+2)) {
							coords = new Coordinate(i,j); //getting the coordinates that will be occupied by D0
							squares.add(coords); //adding coordinates to squares
						}
					}
				}
			}
		}
		
		return squares;		
	}

	//----------PRÁCTICA 3----------
	
	/** [ENG] Method that take the shape of a piece.
	 *  [SPA] Método que coge la forma de una pieza.
	 * 
	 * @return the shape of a piece.
	 */
	protected abstract int[][] getShape();

	/** [ENG] Method that copy a piece.
	 *  [SPA] Método que copia una pieza.
	 *  
	 *  @return the copy of the piece.
	 */
	public abstract Piece copy();
	
	/** [ENG] Method that copy the values of all instance attributes declared in Piece.
	 *  [SPA] Método que copia los valores de todos los atributos de instancia declarados en Piece.
	 *  
	 *  @param p = Piece.
	 */
	protected void copyAttributes(Piece p) {
		fixed = p.fixed;
		blockSymbol = p.blockSymbol;
		orientation = p.orientation;
	}
	
	@Override
	public String toString() {
		
		//PIECE I
		if (getBlockSymbol() == '▒') {
			if (orientation.ordinal() == 0) {
				return "····\n▒▒▒▒\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "··▒·\n··▒·\n··▒·\n··▒·\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n····\n▒▒▒▒\n····\n";
			}
			else {
				return "·▒··\n·▒··\n·▒··\n·▒··\n";
			}
		}
		//PIECE J
		else if (getBlockSymbol() == '◪') {
			if (orientation.ordinal() == 0) {
				return "◪···\n◪◪◪·\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "·◪◪·\n·◪··\n·◪··\n····\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n◪◪◪·\n··◪·\n····\n";
			}
			else {
				return "·◪··\n·◪··\n◪◪··\n····\n";
			}
		}
		//PIECE L
		else if (getBlockSymbol() == '▧') {
			if (orientation.ordinal() == 0) {
				return "··▧·\n▧▧▧·\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "·▧··\n·▧··\n·▧▧·\n····\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n▧▧▧·\n▧···\n····\n";
			}
			else {
				return "▧▧··\n·▧··\n·▧··\n····\n";
			}
		}
		//PIECE O
		else if (getBlockSymbol() == '▣') {
			return "·▣▣·\n·▣▣·\n····\n····\n";
		}
		//PIECE S
		else if (getBlockSymbol() == '▦') {
			if (orientation.ordinal() == 0) {
				return "·▦▦·\n▦▦··\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "·▦··\n·▦▦·\n··▦·\n····\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n·▦▦·\n▦▦··\n····\n";
			}
			else {
				return "▦···\n▦▦··\n·▦··\n····\n";
			}
		}
		//PIECE T
		else if (getBlockSymbol() == '▤') {
			if (orientation.ordinal() == 0) {
				return "·▤··\n▤▤▤·\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "·▤··\n·▤▤·\n·▤··\n····\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n▤▤▤·\n·▤··\n····\n";
			}
			else {
				return "·▤··\n▤▤··\n·▤··\n····\n";
			}
		}
		//PIECE Z
		else {
			if (orientation.ordinal() == 0) {
				return "◫◫··\n·◫◫·\n····\n····\n";
			}
			else if(orientation.ordinal() == 1) {
				return "··◫·\n·◫◫·\n·◫··\n····\n";
			}
			else if(orientation.ordinal() == 2) {
				return "····\n◫◫··\n·◫◫·\n····\n";
			}
			else {
				return "·◫··\n◫◫··\n◫···\n····\n";
			}
		}
	}
}
