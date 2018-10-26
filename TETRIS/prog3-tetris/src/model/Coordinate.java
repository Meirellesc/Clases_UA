package model;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 23/09/2018
 */
public class Coordinate {
	
	/**
	 * @variable filas.
	 */
	private int row;
	/**
	 * @variable columna.
	 */
	private int column;
	
	/**
	 * @variable contador de coordenadas.
	 */
	private static int COORDINATE_COUNT;
	
	/** [ENG] Constructor which input the number of row(s) and column(s).
	 *  [SPA] Constructor que introduce el número de las filas y columnas. 
	 * 
	 * @param row = number of rows / número de las filas.
	 * @param column = number of columns / número de las columnas.
	 */
	public Coordinate (int row, int column) {
		this.row = row;
		this.column = column;
		COORDINATE_COUNT++;
	}
	
	/** [ENG] Constructor which create a Coordinate and count it.
	 *  [SPA] Constructor que crea una Coordenada y se cuenta al total.
	 * 
	 * @param c = input the number of row and column / ingresa el número de la fila y columna.
	 */
	public Coordinate (Coordinate c) {
		this.row = c.row;
		this.column = c.column;
		COORDINATE_COUNT++;
	}
	
	/** [ENG] Method which add a Coordinate to another one.
	 *  [SPA] Método que añade una Coordenada a la otra.
	 * 
	 * @param c = input the coordinates / introduce com la coordenada.
	 * @return = the coordinates added to coordinates inputed / la coordenadas añadidas a la coordenadas insertadas.
	 */
	public Coordinate add(Coordinate c) {
	 	return new Coordinate(row + c.row,column + c.column);
	}
	
		
	/** [ENG] Method that takes the value of row.
	 * 	[SPA] Método que coge el valor de la fila.
	 * 
	 * @return the number(s) of row(s) / devuelve los números de las filas.
	 */
	public int getRow() {
		return this.row;
	}
	
	/** [ENG] Method that takes the value of column.
	 * 	[SPA] Método que coge el valor de la columna.
	 * 
	 * @return the number(s) of column(s) / devuelve los números de las columnas.
	 */
	public int getColumn() {
		return this.column;
	}
	
	/** [ENG] Method that takes the total value of coordinates created.
	 * 	[SPA] Método que coge el valor total de las coordenadas creadas.
	 * 
	 * @return the number of how many Coordinates were created / devuelve el número de cuantas coordenadas ha sido creadas.
	 */
	public static int getCoordinateCount() {
		return COORDINATE_COUNT;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		//return "Coordinate [row=" + row + ", column=" + column + "]";
		return "[" + row + "," + column + "]";
	}
	
	
	
}
