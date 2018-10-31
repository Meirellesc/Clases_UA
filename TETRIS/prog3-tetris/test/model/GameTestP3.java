package model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import model.exceptions.TetrisException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* 
 * 
 *  
 *  Busca los comentarios con la cadena "TODO" para saber qué tests has de completar. Como en la práctica 
 *  anterior, la mayoría de estos tests van generando en un fichero de texto (con extensión .alu) las diferentes 
 *  configuraciones de tablero obtenidas al ir jugando al juego y grabando los estados intermedios del tablero 
 *  con saveGame. Recuerda que la salida esperada está en un fichero con el mismo nombre pero extensión .sol.   
 *  
 *  
 */

public class GameTestP3 {
    Game game;
    Piece p[];
    StringBuilder sbIn = new StringBuilder();
	StringBuilder sbOut = new StringBuilder();
	PrintStream ps;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sbIn = new StringBuilder();
		sbOut = new StringBuilder();
		game = new Game(new Coordinate(9,5));
		p = new Piece[7];
		p[0] = PieceFactory.createPiece("I");
		p[1] = PieceFactory.createPiece("J");
		p[2] = PieceFactory.createPiece("L");
		p[3] = PieceFactory.createPiece("O");
		p[4] = PieceFactory.createPiece("S");
		p[5] = PieceFactory.createPiece("T");
		p[6] = PieceFactory.createPiece("Z");
		for (int i=0; i<7; i++) p[i].setFixed(true);
	}
    
	
	
	//Elimina linea del fondo llena
	@Test
	public void testMoveCurrentPieceDown1() {
		ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown1.alu");
		Gameboard gb = game.getGameboard();
		Piece p = PieceFactory.createPiece("I");
		p.setFixed(true);
		for (int i=1; i<gb.getWidth(); i++)
		gb.setCellContent(new Coordinate(gb.getHeight()-1,i), p);
		saveGame(game);
		try {
			game.nextPiece("Z");
			saveGame(game);
			game.rotateCurrentPieceCounterclockwise();
			saveGame(game);
			for (int i=0; i<7; i++)
							game.moveCurrentPieceDown();
		} catch (TetrisException e) {
			fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
		}
		saveGame(game);
		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown1.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
	}
	
	//Eliminación 4 primeras lineas llenas desde el fondo
	@Test
	public void testMoveCurrentPieceDown2() {
		ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown2.alu");
		Gameboard gb = game.getGameboard();
		Piece p = PieceFactory.createPiece("O");
		p.setFixed(true);
		for (int i=5; i<gb.getHeight();  i++)
			for (int j=1; j<gb.getWidth();j++)
					gb.setCellContent(new Coordinate(i,j), p);
		saveGame(game);
		
		// TODO: reproduce la partida del fichero P3/testMoveCurrentPieceDown2.sol; mueve una pieza de
		// tipo I para que caiga por la primera columna de forma que haga que se llenen y borren las 4 líneas
		// del fondo del tablero.
		
		fail("¡Completa el test!");

		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown2.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
		
	}
	
	//Eliminación fila del fondo llena y bajan las de arriba
	@Test
	public void testMoveCurrentPieceDown3() {
			ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown3.alu");
			prepareGameboard(game);
			saveGame(game);
			try {
				game.nextPiece("I");
				saveGame(game);
				game.rotateCurrentPieceCounterclockwise();	
				saveGame(game);
				game.moveCurrentPieceLeft();
				saveGame(game);
				for (int i=0; i<6; i++){
								game.moveCurrentPieceDown();
								saveGame(game);
				}
				assertTrue(game.isCurrentPieceFixed());
			} catch (TetrisException e) {
				fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
			}
			ps.close();
			
			sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown3.sol");
			assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
			
		}
	
	//Eliminación fila intermedia llena y bajan las de arriba
	@Test
	public void testMoveCurrentPieceDown4() {
			ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown4.alu");
			Gameboard gb = game.getGameboard();
			prepareGameboard(game);
			gb.setCellContent(new Coordinate(7,0),p[4]);
			gb.setCellContent(new Coordinate(6,1), p[3]);
			saveGame(game);
			try {
				game.nextPiece("I");
				saveGame(game);
				game.rotateCurrentPieceCounterclockwise();	
				saveGame(game);
				game.moveCurrentPieceLeft();
				saveGame(game);
				for (int i=0; i<4; i++){
								game.moveCurrentPieceDown();
								saveGame(game);
				}
				assertTrue(game.isCurrentPieceFixed());
			} catch (TetrisException e) {
				fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
			}
			ps.close();
			
			sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown4.sol");
			assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
			
		}
	
	//Eliminación 2 filas intermedias separadas llenas y bajan las de arriba
	@Test
	public void testMoveCurrentPieceDown5() {
			ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown5.alu");
			Gameboard gb = game.getGameboard();
			prepareGameboard(game);
			gb.setCellContent(new Coordinate(7,0),p[4]);
			gb.setCellContent(new Coordinate(6,1), p[3]);
			gb.setCellContent(new Coordinate(4,4), p[5]);
			saveGame(game);

			// TODO: reproduce la partida del fichero P3/testMoveCurrentPieceDown5.sol; mueve una pieza de
			// tipo I para que caiga por la primera columna de forma que haga que se llenen 2 líneas
			// y caigan las de arriba.
			
			fail("¡Completa el test!");
			
			ps.close();
			
			sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown5.sol");
			assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
		
		}
		
	//Eliminación 4 filas inferiores  llenas y bajan las de arriba
	@Test
	public void testMoveCurrentPieceDown6() {
			ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown6.alu");
			Gameboard gb = game.getGameboard();
			prepareGameboard(game);
			gb.setCellContent(new Coordinate(5,2),p[4]);
			gb.setCellContent(new Coordinate(6,1), p[3]);
			gb.setCellContent(new Coordinate(7,4), p[5]);
			saveGame(game);
			try {
				game.nextPiece("I");
				saveGame(game);
				game.rotateCurrentPieceCounterclockwise();	
				saveGame(game);
				game.moveCurrentPieceLeft();
				saveGame(game);
				for (int i=0; i<6; i++){
								game.moveCurrentPieceDown();
								saveGame(game);
				}
				assertTrue(game.isCurrentPieceFixed());
			} catch (TetrisException e) {
				fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
			}
			ps.close();
			
			sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown6.sol");
			assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
		
	}
	
	//Eliminación 3 filas  llenas y bajan las de arriba
	@Test
	public void testMoveCurrentPieceDown7() {
			ps = openFileForWritingStudentOutput("test/files/P3/testMoveCurrentPieceDown7.alu");
			Gameboard gb = game.getGameboard();
			prepareGameboard(game);
			gb.setCellContent(new Coordinate(5,2),p[4]);
			gb.setCellContent(new Coordinate(6,1), p[3]);
			gb.setCellContent(new Coordinate(4,4), p[5]);
			saveGame(game);
			

			// TODO: reproduce la partida del fichero P3/testMoveCurrentPieceDown7.sol; mueve una pieza de
			// tipo I para que caiga por la primera columna de forma que haga que se llenen 3 líneas
			// y caigan las de arriba.
			
			fail("¡Completa el test!");
			
			ps.close();
			
			sbIn=readSolutionFromFile("test/files/P3/testMoveCurrentPieceDown7.sol");
			assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
		
	}
	
	//Partida de tetris
	@Test
	public void testPartida1() {
		ps = openFileForWritingStudentOutput("test/files/P3/testPartida1.alu");
		try {
			saveGame(game);
			game.nextPiece("J");
			saveGame(game);
			for (int i=0; i<8; i++)	game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("J");
			saveGame(game);
			game.moveCurrentPieceRight();
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			for (int i=0; i<7; i++) game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("L");
			saveGame(game);
			game.rotateCurrentPieceCounterclockwise();
			saveGame(game);
			for (int i=0; i<3; i++) game.moveCurrentPieceRight();
			saveGame(game);
			for (int i=0; i<7; i++) game.moveCurrentPieceDown();
			saveGame(game);
			//se llenaron las filas 7 y 8 y se eliminaron
			game.nextPiece("O");
			saveGame(game);
			for (int i=0; i<2; i++) game.moveCurrentPieceRight();
			saveGame(game);
			for (int i=0; i<7; i++)	game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("J");
			saveGame(game);
			for (int i=0; i<8; i++) game.moveCurrentPieceDown();
			saveGame(game);
			//se llenó y eliminó fila 8
			game.nextPiece("I");
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			for (int i=0; i<6; i++)	game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("O");
			saveGame(game);
			game.moveCurrentPieceLeft();
			saveGame(game);
			for (int i=0; i<7; i++) game.moveCurrentPieceDown();
			saveGame(game);		
			//se llenó y eliminó la fila 7
	
			game.nextPiece("L");
			saveGame(game);
			game.rotateCurrentPieceCounterclockwise();
			saveGame(game);
			game.moveCurrentPieceRight();
			saveGame(game);
			game.moveCurrentPieceRight();
			saveGame(game);
			for (int i=0; i<6; i++)	game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("I");
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			game.moveCurrentPieceRight();
			saveGame(game);
			game.moveCurrentPieceRight();
			saveGame(game);
			for (int i=0; i<5; i++) game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("O");
			saveGame(game);
			game.moveCurrentPieceLeft();
			saveGame(game);
			for (int i=0; i<7; i++) game.moveCurrentPieceDown();
			saveGame(game);
			//se llenaron y eliminaron las fila 6 y 7
			
			game.nextPiece("I");
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			for (int i=0; i<5; i++) game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("I");
			saveGame(game);
			game.rotateCurrentPieceClockwise();
			saveGame(game);
			game.moveCurrentPieceDown();
			saveGame(game);
			game.nextPiece("Z");
			saveGame(game);
			//Fin de la partida
			assertTrue(game.isGameEnded());
			
		} catch (TetrisException e) {
			fail("Error: se produjo la excepción "+e.getClass().getSimpleName());
		}
		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testPartida1.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
	
	}
	@Test
	public void testPartida2() {
		ps = openFileForWritingStudentOutput("test/files/P3/testPartida2.alu");
		Gameboard gb = game.getGameboard();
		Piece piece = PieceFactory.createPiece("O");
		piece.setFixed(true);
		gb.setCellContent(new Coordinate(8,0), piece);
		saveGame(game);
		
		// TODO: completar este test te puede llevar más tiempo que otros de esta práctica; 
		// reproduce la partida de P3/testPartida2.sol.
		
		fail("¡Completa el test!");
		
		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testPartida2.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
	
	}
	
	
	//Partida de tetris
	@Test
	public void testPartida3() {
		ps = openFileForWritingStudentOutput("test/files/P3/testPartida3.alu");
		Gameboard gb = game.getGameboard();
		Piece p = PieceFactory.createPiece("O");
		p.setFixed(true);
		gb.setCellContent(new Coordinate(9,0), p);
		saveGame(game);
		
		// TODO: completar este test te puede llevar más tiempo que otros de esta práctica; 
		// reproduce la partida de P3/testPartida3.sol.
		
		fail("¡Completa el test!");
		
		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testPartida3.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
	
	}	
			
	//Partida de tetris
	@Test
	public void testPartida4() {
		ps = openFileForWritingStudentOutput("test/files/P3/testPartida4.alu");
		Gameboard gb = game.getGameboard();
		Piece p = PieceFactory.createPiece("O");
		p.setFixed(true);
		gb.setCellContent(new Coordinate(8,1), p);
		gb.setCellContent(new Coordinate(8,3), p);
		gb.setCellContent(new Coordinate(7,3), p);
		saveGame(game);

		// TODO: completar este test te puede llevar más tiempo que otros de esta práctica; 
		// reproduce la partida de P3/testPartida4.sol.
		
		fail("¡Completa el test!");

		ps.close();
		
		sbIn=readSolutionFromFile("test/files/P3/testPartida4.sol");
		assertEquals("solucion == alumno",sbIn.toString().trim(),sbOut.toString().trim());
	
	}
	
	
	
	
	/* *****************************
	 * FUNCIONES DE APOYO
	 * *****************************/
		
	//Abre un fichero para escribir los tableros que genera el alumno.
	private PrintStream openFileForWritingStudentOutput (String fichero) {
			PrintStream s=null;
			try {
				s = new PrintStream(fichero);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}
			return s;
	}
		
	//Lee la solución de un fichero y la devuelve en un StringBuilder	
	private StringBuilder readSolutionFromFile(String file) {
		Scanner sc=null;
		try {
				sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) 
			sb.append(sc.nextLine()+"\n");			
		sc.close();
		return (sb);
	}
		
	/* Almacena la partida en un fichero como un string para el alumno,
	   y en un StringBuilder para compararla luego con la solución */
	private void saveGame(Game game) {
		sbOut.append(game.toString()+"\n");
		ps.println(game.toString());
	}
	
	private void prepareGameboard (Game game) {
		Gameboard gb = game.getGameboard();
		gb.setCellContent(new Coordinate(1,4), p[0]);
		gb.setCellContent(new Coordinate(2,2), p[1]);
		gb.setCellContent(new Coordinate(2,3), p[5]);
		gb.setCellContent(new Coordinate(2,4), p[2]);
		gb.setCellContent(new Coordinate(3,2), p[4]);
		gb.setCellContent(new Coordinate(3,3), p[4]);
		gb.setCellContent(new Coordinate(4,1), p[3]);
		gb.setCellContent(new Coordinate(4,2), p[3]);
		gb.setCellContent(new Coordinate(4,3), p[6]);
		gb.setCellContent(new Coordinate(5,1), p[2]);
		gb.setCellContent(new Coordinate(5,3), p[2]);
		gb.setCellContent(new Coordinate(5,4), p[3]);
		gb.setCellContent(new Coordinate(6,2), p[3]);
		gb.setCellContent(new Coordinate(6,3), p[3]);
		gb.setCellContent(new Coordinate(6,4), p[6]);
		gb.setCellContent(new Coordinate(7,1), p[4]);
		gb.setCellContent(new Coordinate(7,2), p[1]);
		gb.setCellContent(new Coordinate(7,3), p[2]);
		gb.setCellContent(new Coordinate(8,1), p[3]);
		gb.setCellContent(new Coordinate(8,2), p[0]);
		gb.setCellContent(new Coordinate(8,3), p[0]);
		gb.setCellContent(new Coordinate(8,4), p[4]);		
	}

}



