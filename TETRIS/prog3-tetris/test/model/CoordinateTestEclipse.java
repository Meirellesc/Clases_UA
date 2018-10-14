package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 **/
public class CoordinateTestEclipse {
	Coordinate c;
	
	/* Este metodo se ejecuta antes de cada Test,
	   de manera que el objeto 'c' es un objeto distinto en cada test  */
	@Before
	public void setUp() throws Exception {
		c = new Coordinate(3, 5);
				
	}

	@Test
	public final void testGetters() {
		assertEquals("Row", 3, c.getRow());
		assertEquals("Column", 5, c.getColumn());
		
	}

	@Test
	public final void testInicializacion() {
		// comprobamos si el constructor de copia funciona bien
		Coordinate c2 = new Coordinate(c);
		// Fijate en que el objeto c2 solo se crea cuando se ejecuta este test
		// mientras que 'c' se crea y esta disponible para cada test.
		
		assertEquals("c2.Row", c2.getRow(), c.getRow());
		assertEquals("c2.Column", c2.getColumn(), c.getColumn());
		
		// aserciones equivalentes al primer assertEquals
		// se incluyen a modo ilustrativo
		assertTrue("c2.Row True", c2.getRow() == c.getRow());
		assertFalse("c2.Row False", c2.getRow() != c.getRow());	
	}
	
	
	@Test
	public final void testEquals() {
		Coordinate c4 = new Coordinate(3,5);
		Coordinate c5 = new Coordinate(3,6);
		Coordinate c6 = new Coordinate(4,5);
		String s = new String();
		// equals() devuelve falso cuando le paso null
		assertFalse(c.equals(null));
		// equals() devuelve falso cuando le paso un objeto que no es de tipo Coordinate
		assertFalse(c.equals(s));
		// equals devuelve falso cuando el valor de la columna es distinto
		assertFalse(c.equals(c5));
		
		// ¡COMPLETA EL TEST!
		
		// tenemos que comprobar TODAS las posibles condiciones
		// bajo las cuales nuestra funcion equals() devuelve true o false
		// Aun faltan algunas. 
		
		// 1. equals() devuelve falso cuando el valor de la fila es distinto
		// ( usa c6: tiene un valor distinto en la fila )
		//assertFalse(c6.equals(c5));
		assertFalse(c.equals(c6));
		
		// 2. equals() devuelve cierto cuando comparo un objeto Coordinate consigo mismo
		assertTrue(c.equals(c));
		
		// 3. equals() devuelve cierto cuando comparo dos objetos Coordinate distintos
		// y sus valores de fila y columna son iguales.
		assertTrue(c.equals(c4));
		
	}
	
	@Test
	public final void testToString() {
		assertEquals("Coordinate.toString()","Coordinate [row=3, column=5]",c.toString());
		
	}
	
	@Test
	public final void testAdd() {
		Coordinate c7 = c.add(c);
		//Coordinate c8 = c.add(c);
		//Coordinate c9 = c7.add(c);
		
		// Comprobamos que add() devuelve un nuevo objeto que representa la suma
		assertNotSame(c,c7);
		
		// ¡COMPLETA El TEST!

		// Comprueba que el resultado de sumar las filas es correcto (1 linea)
		//assertSame(c7.getRow(), c8.getRow());
		assertEquals("c.add(c).x",6,c7.getRow());
		
		// Comprueba que el resultado de sumar las columnas es correcto (1 linea)
		//assertSame(c7.getColumn(), c8.getColumn());
		assertEquals("c.add(c).y",10,c7.getColumn());
		
		// Comprueba que el resultado de convertir a String el resultado de  c + c7 es "[9,15]" 
		// ¡intenta hacerlo en una sola linea!
		assertEquals("Coordinate c + c7.toString() ","Coordinate [row=9, column=15]", c.add(c7).toString());
	}

		
}