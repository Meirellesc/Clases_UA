package model;

import static org.junit.Assert.*;
import model.Coordinate;
import model.Gameboard;
import model.exceptions.*;

import org.junit.Before;
import org.junit.Test;

/* 
 * 
 *  
 *  Busca los comentarios con la cadena "TODO" para saber qué tests has de completar. 
 *  
 *  
 */

public class GameboardExceptionsTestP3 {
    
    Gameboard gb, gb1;
	

	@Before
	public void setUp() throws Exception {
		gb1 = new Gameboard(new Coordinate(6,7));
	}

	@Test
	public void testGameBoardConstructorExceptions1() {
		try {
			gb = new Gameboard(new Coordinate(3,4));
			fail("Error: no se lanzó la excepción WrongSizeException");
		} catch (WrongSizeException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testGameBoardConstructorExceptions2() {
		
		// TODO: ¡completa el test! Crea un tablero de forma similar a como se hace en 
		// testGameBoardConstructorExceptions1, pero con un número de columnas incorrecto y
		// comprueba que se lanza la excepción adecuada.
				
		fail("¡Completa el test!");	
	}

	@Test
	public void testGameBoardConstructorExceptions3() {
		
		// TODO: ¡completa el test! Crea un tablero de forma similar a como se hace en 
		// testGameBoardConstructorExceptions1, pero con tamaño (0,0).
						
		fail("¡Completa el test!");	
	}
		
	@Test
	public void testGameBoardConstructorExceptions4() {
		
		// TODO: ¡completa el test! Crea un tablero de forma similar a como se hace en 
		// testGameBoardConstructorExceptions1, pero esta vez con un tamaño correcto.
		// Haz que el test falle si el constructor de Gameboard devuelve alguna excepción.
					
		fail("¡Completa el test!");	
	}
	
	
	/* Un test pasa si no falla en ningún punto. */
	@Test
	public void testGameBoardclearRowExceptions1() {
		try {		
			gb1.clearRow(6);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testGameBoardclearRowExceptions2() {

		// TODO: repite un test como el de testGameBoardclearRowExceptions1, pero intentando
		// borrar una fila negativa.
		
		fail("¡Completa el test!");	

	}
		
	@Test
	public void testGameBoardclearRowExceptions3() {
		
		// TODO: escribe un test que falle si al llamar a gb1.clearRow con algunas de las filas
		// vacías, este método devolviera cualquier tipo de excepción.
		
		fail("¡Completa el test!");
	}

		
	@Test
	public void testGameBoardmakeUpperRowsFallExceptions1() {
		try {		
			gb1.makeUpperRowsFall(6);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testGameBoardmakeUpperRowsFallExceptions2() {
		try {		
			gb1.makeUpperRowsFall(-1);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
		
	@Test
	public void testGameBoardmakeUpperRowsFallExceptions3() {
		
		// TODO: prueba gb1.makeUpperRowsFall con algunas filas que no hagan que el método lance
		// ninguna excepción. Haz que este test falle si se lanza alguna.
		
		fail("¡Completa el test!");
	}
}
