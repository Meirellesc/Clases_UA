package model.io;

import static org.junit.Assert.*;

import model.exceptions.io.TetrisIOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 23/11/2018
 *
 */
public class PlayerStringTestP4 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=NullPointerException.class)
	public void testPlayerString() {
		new PlayerString(null);
	}

	@Test
	public void testNextMove() {
		//TODO Implementa el test con un string que contenga una serie de movimientos de tal forma
		// que aparezcan todos los caracteres de movimientos y piezas.
		// Crea un PlayerString a partir de ese String. 
		// Comprueba que las sucesivas llamadas a nextMove, devuelve el caracter correcto y que al
		// final de la cadena, devuelve el caracter IPlayer.LAST_MOVE
		
		String s = new String("IJLOSTZ↻↺→←↓");
		PlayerString ps = new PlayerString(s);
		
		try {
			for(int i=0; i<s.length();i++) {
				assertEquals(s.charAt(i), ps.nextMove());
			}
			assertEquals(IPlayer.LAST_MOVE, ps.nextMove());
		}catch (TetrisIOException e) {
			fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
		}
		
		
	}
	
	//Prueba de TetrisIOException
	@Test(expected=TetrisIOException.class) //(/*añade lo que debe estar aquí */)
	public void testNextMoveException1() throws TetrisIOException {
		//TODO Comprobar que nextMove lanza la excepción TetrisIOException cuando en el String moves
        // de PlayerString se introduce un carácter de una pieza que no existe. 
		
		String s = new String("I↻↻J↺L→→F→→O←↓↓Z↺↺↓↓←←↓↓");
		PlayerString ps = new PlayerString(s);
		
		for(int i=0; i<s.length(); i++) {
			assertEquals(s.charAt(i), ps.nextMove());
		}
	}
		
	
	@Test(expected=TetrisIOException.class)
	public void testNextMoveException2() throws TetrisIOException {
		String m = new String("I↻↻J↺L→→→→O←Q↓↓↓↓←←↓↓↓↓T↓↓->↓↓Z↺↺");
		PlayerString pl = new PlayerString(m);
		
		for (int i=0; i<m.length(); i++) {
			assertEquals(m.charAt(i), pl.nextMove());	
		}
		
	}
}
