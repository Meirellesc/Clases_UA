package model.io;

import static org.junit.Assert.*;

import model.exceptions.io.TetrisIOException;

import org.junit.Test;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 23/11/2018
 *
 */
public class PlayerRandomTestP4 {

	static final String moves1="S↓↓↓↓↻↓↓→↓↓↓↓↓↓↓←↓↓↓↓↓↓↓●↺↻↓↓↺↺↓↓↓↓→↺↓↺→";
	static final String moves2="T↓↓↓↓↓→↓↓↓↓↓→↓↓→→↓↓↺←↓↓↺←↓↓↓→↓●↓←↓↓↺↓↓↓↓";

	
	@Test
	public void testNextMove1() {
		PlayerRandom plr= new PlayerRandom(54322);
		try {
			//TODO Introduce el código que compruebe que la sucesión de caracteres 
			//que proporciona plr.nextMove() coincide con los de la cadena moves1.
			//plr.nextMove(); instrucción a incluir
			
			for (int i=0; i<moves1.length(); i++) {
				assertEquals(moves1.charAt(i),plr.nextMove());
			}
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testNextMove2() {
		PlayerRandom plr= new PlayerRandom(98765);
		try {
		    //TODO Introduce el código que compruebe que la sucesión de caracteres que proporciona 
			// plr.nextMove() coincide con los de la cadena moves2.
			//plr.nextMove(); //instrucción a incluir
			
			for (int i=0; i<moves2.length();i++) {
				assertEquals(moves2.charAt(i),plr.nextMove());
			}
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}

}
