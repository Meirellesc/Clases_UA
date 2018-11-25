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
 * @date 25/11/2018
 *
 */
public class PlayerFactoryTestP4 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCreatePlayerFile1() {
		
		try {
			IPlayer ip=PlayerFactory.createPlayer("test/files/P4/testCreatePlayerFile1.in");
			assertEquals("PlayerFile",ip.getClass().getSimpleName());
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testCreatePlayerFile2() {
		//TODO Implementa el test para que al crear un IPlayer con una cadena que contiene un 
		//número con un caracter '/' genere un PlayerFile y no un PlayerRandom
		
		try {
			IPlayer ip = PlayerFactory.createPlayer("12345/54321");
			assertEquals("PlayerFile", ip.getClass().getSimpleName());
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testCreatePlayerFile3() {
		
		try {
			IPlayer ip=PlayerFactory.createPlayer("IJL/OSTZ");
			assertEquals("PlayerFile",ip.getClass().getSimpleName());
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}

	@Test
	public void testCreatePlayerRandom1() {
		
		try {
			IPlayer ip=PlayerFactory.createPlayer("67584902");
			assertEquals("PlayerRandom",ip.getClass().getSimpleName());
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testCreatePlayerRandom2() {
		//TODO Implementa el test para que al crear un IPlayer con una cadena numérica que 
		//tiene un símbolo '-' al principio genere un PlayerRandom
		
		try {
			IPlayer ip = PlayerFactory.createPlayer("-67584902");
			assertEquals("PlayerRandom", ip.getClass().getSimpleName());
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	//Completa los 2 test siguientes  que comprueben que pasando como string una cadena que 
	// no tenga ni ./\ ni un long, PlayerFactory.createPlayer genere un PlayerString
	@Test
	public void testCreatePlayerString() {
		//TODO
		try {
			IPlayer ip = PlayerFactory.createPlayer("IJLOSTZ↻↺→←↓");
			assertEquals("PlayerString", ip.getClass().getSimpleName());
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testCreatePlayerString2() {
		
		//TODO
		try {
			IPlayer ip = PlayerFactory.createPlayer("I↻J↺L→O←S↓T↓Z");
			assertEquals("PlayerString", ip.getClass().getSimpleName());
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}
	
	@Test(expected=TetrisIOException.class)
	public void testCreatePlayerTetrisIOException() throws TetrisIOException {
		//TODO
        //Crea un test para que lance una excepcion TetrisIOException cuando a createPlayer se pasa un
        // fichero que no existe.
		IPlayer ip = PlayerFactory.createPlayer("/test/noexist");
		assertEquals("PlayerFile", ip.getClass().getSimpleName());
	}
}