package model.io;

import static org.junit.Assert.*;

import model.exceptions.io.TetrisIOException;

import org.junit.Test;

//2 TEST A COMPLETAR

public class PlayerRandomTestP4 {

	static final String moves1="S↓↓↓↓↻↓↓→↓↓↓↓↓↓↓←↓↓↓↓↓↓↓●↺↻↓↓↺↺↓↓↓↓→↺↓↺→";
	static final String moves2="T↓↓↓↓↓→↓↓↓↓↓→↓↓→→↓↓↺←↓↓↺←↓↓↓→↓●↓←↓↓↺↓↓↓↓";

	
	@Test
	public void testNextMove1() {
		PlayerRandom plr= new PlayerRandom(54322);
		try {
			//TODO Introduce el código que compruebe que la sucesión de caracteres 
			//que proporciona plr.nextMove() coincide con los de la cadena moves1.
			plr.nextMove(); //instrucción a incluir
			fail ("¡Completa el test!");
		
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
			plr.nextMove(); //instrucción a incluir
			fail ("¡Completa el test!");
		
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}

}
