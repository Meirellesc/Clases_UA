package model.io;
//5 TEST A REALIZAR
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.exceptions.io.TetrisIOException;

import org.junit.Before;
import org.junit.Test;

public class PlayerFileTestP4 {
	BufferedReader bin;
	PlayerFile pf;
	String m2, m1; 
	@Before
	public void setUp() throws Exception {
		m1=new String("I↻↻J↺L→→→→O←S↓↓↓↓←←↓↓↓↓T↓↓→↓↓Z↺↺");
		m2=new String("I↻J↺L→O←S↓T↓Z");


	}
	
	@Test
	public void testNextMove() {
		NewPlayerFile("test/files/P4/testNextMove.in");
	
		try {
			for (int i=0; i<m1.length(); i++) {
				assertEquals(m1.charAt(i),pf.nextMove());
			}
			assertEquals(IPlayer.LAST_MOVE,pf.nextMove());
		} catch (TetrisIOException e) {
			fail ("Error, se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testNextMoveConEspacios() {
		//TODO Copia el fichero del test anterior "test/files/P4/testNextMove.in" en "test/files/P4/testNextMoveConEspacios.in"
		// Edita este último y añade espacios entre las ordenes put, move, rotation y las piezas y movimientos. 
		// Crea un PlayerFile 'pf' a partir del fichero con espacios y comprueba en un bucle sobre la cadena m1, que pf.nextMove() 
		// devuelve la misma sucesión de caracteres que la que está en m1.
		// Por supuesto, no se lanza excepción.
	    fail ("¡Implementa el test!");
	}
	
	@Test
	public void testNextMoveIOException1() {
		//TODO Crea un fichero "test/files/P4/testNextMoveIOException1.in", con lineas donde se pongan piezas y realicen 
		// movimientos. Pon una linea donde ponga una pieza incorrecta: 'put M'
		// Crea un PlayerFile 'pf' a partir del fichero y comprueba que tras las sucesivas ejecuciones de nextMove() 
		// al llegar a esta línea (y solo en ésta) lanza la excepción TetrisIOException
		fail ("¡Implementa el test!");
	}
	
	@Test
	public void testNextMoveIOException2() {
		//TODO Crea un fichero "test/files/P4/testNextMoveIOException2.in", con lineas donde se pongan piezas y realicen 
		// movimientos correctos. Pon una linea que contenga 'Move right'
		// Crea un PlayerFile 'pf' a partir del fichero comprueba que tras las sucesivas ejecuciones de nextMove() al 
		// llegar a esta línea (y solo en esta) lanza la excepción TetrisIOException
		fail ("¡Implementa el test!");
	}
	
	@Test
	public void testNextMoveIOException3() {
		//TODO Crea un fichero "test/files/P4/testNextMoveIOException3.in", con lineas donde se pongan piezas y realicen 
		// movimientos correctos. Pon una linea que ponga sólo 'move'
		// Crea un PlayerFile 'pf' a partir del fichero y comprueba que tras las sucesivas ejecuciones de nextMove() al 
		// llegar a esta línea (y solo en esta) lanza la excepción TetrisIOException
		fail ("¡Implementa el test!");
	}
	
	@Test
	public void testNextMoveIOException4() {
		//TODO Crea un fichero "test/files/P4/testNextMoveIOException2.in", con lineas donde se pongan piezas y realicen 
		// movimientos correctos. Pon una linea que contenga 'move left right'
		// Crea un PlayerFile 'pf' a partir del fichero y comprueba que tras las sucesivas ejecuciones de nextMove() al llegar a esta línea (y solo en esta) lanza
		// la excepción TetrisIOException
		fail ("¡Implementa el test!");
	}
	
	@Test(expected=NullPointerException.class)
	public void testNextMoveIOException5() {
		
		pf=new PlayerFile(null);
	
	}
	
	
//Funciones de apoyo
	private void NewPlayerFile(String name) {
	
		try {
			bin = new BufferedReader(new FileReader(name));
			pf=new PlayerFile(bin);
		} catch (FileNotFoundException e) {
			fail("Error apertura, fichero "+name);
		}
	}

}
