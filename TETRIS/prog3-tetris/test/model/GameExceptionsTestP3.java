package model;

import static org.junit.Assert.*;
import model.Coordinate;
import model.Game;
import model.exceptions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* 
 * 
 *  
 *  Busca los comentarios con la cadena "TODO" para saber qué tests has de completar. 
 *  
 *  
 */

/**
 * 
 * @author Lucas Meirelles
 *
 */
public class GameExceptionsTestP3 {

	Game g, g1;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		g1 = new Game(new Coordinate(5,5));
	}

	//Excepciones en Game(Coordenada)
	@Test
	public void testGameConstructorExceptions1() {
		try {
			g = new Game(new Coordinate(3,4));
			fail("Error: no se lanzó la excepción WrongSizeException");
		} catch (WrongSizeException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testGameBoardConstructorExceptions2() {

		// TODO: prueba otras llamadas al constructor de Game que lancen excepciones por motivos
		// diferentes al del método testGameConstructorExceptions1
		try {
			g = new Game(new Coordinate(4,3));
			fail("Error: no se lanzó la excepción WrongSizeException");
		} catch (WrongSizeException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}

	@Test
	public void testGameBoardConstructorExceptions3() {
		// TODO: prueba otras llamadas al constructor de Game que lancen excepciones
		try {
			g = new Game(new Coordinate(3,-1));
			fail("Error: no se lanzó la excepción WrongSizeException");
		} catch (WrongSizeException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}

	
	//Excepcion NoCurrentPieceException al mover o rotar sin haber pieza
	@Test
	public void testGame_moveRotateCurrentPieceExceptions1() {
		
		// TODO: sin colocar ninguna pieza en g1, invoca todos los métodos que mueven
		// o rotan la pieza actual y comprueba que lanzan las excepciones correctas.

		try {
			g1.moveCurrentPieceLeft();
			g1.moveCurrentPieceRight();
			g1.moveCurrentPieceDown();
			g1.rotateCurrentPieceClockwise();
			g1.rotateCurrentPieceCounterclockwise();
			fail ("Error: no se lanzó la excepción NoCurrentPieceException o otras.");
		} catch (NoCurrentPieceException e){
			assertNotNull(e.getMessage());
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (FixedPieceMovementException e) {
			assertNotNull(e.getMessage());
		} catch (OffBoardMovementException e) {
			assertNotNull(e.getMessage());
		} catch (CollisionMovementException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
	}
	
	/*Excepcion GameEndedMovementException al mover o rotar en partida acabada.
	Se comprueba la prioridad de la excepción respecto a FixedPieceMovementException y 
	OffBoardMovementException y CollisionMovimentException */
	@Test
	public void testGame_moveRotateCurrentPieceExceptions2() {
		//Ponemos las piezas en el tablero hasta acabar partida
		try {
			g1.nextPiece("T");
			g1.rotateCurrentPieceCounterclockwise();
			for (int i=0; i<3; i++) g1.moveCurrentPieceDown(); //bajamos hasta fijar la pieza
			g1.nextPiece("Z");
			g1.rotateCurrentPieceCounterclockwise();
			g1.moveCurrentPieceDown();//bajamos para fijar la pieza
			try {
				g1.nextPiece("I"); //Se acaba la partida
			} catch (GameEndedMovementException e) {
				fail("Error:Se lanzó la excepción "+e.getClass().getSimpleName());
			}
		} catch (TetrisException e) {
			fail ("Error: Se lanzó la excepción "+e.getClass().getSimpleName());
		}
			
		// Probamos mover abajo la currentPiece con la partida acabada
		try {
			g1.moveCurrentPieceDown();
			fail("Error: no se lanzó la excepción GameEndedMovementException");
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}

		// TODO: repite lo anterior con los otros movimientos y rotaciones.
		try {
			g1.moveCurrentPieceLeft();
			fail("Error: no se lanzó la excepción GameEndedMovementException");
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		try {
			g1.moveCurrentPieceRight();
			fail("Error: no se lanzó la excepción GameEndedMovementException");
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		try {
			g1.rotateCurrentPieceClockwise();
			fail("Error: no se lanzó la excepción GameEndedMovementException");
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		try {
			g1.rotateCurrentPieceCounterclockwise();
			fail("Error: no se lanzó la excepción GameEndedMovementException");
		} catch (GameEndedMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}

		
	}
	
	/*Excepcion FixedPieceMovementException al mover o rotar en una pieza fija.
	Se comprueba la prioridad de la excepción respecto a OffBoardMovementException 
	y CollisionMovimentException */
	@Test
	public void testGame_moveRotateCurrentPieceExceptions3() {
		//Ponemos las piezas en el tablero fijando la currentPiece
		try {
			g1.nextPiece("T");
			g1.rotateCurrentPieceCounterclockwise();
			for (int i=0; i<3; i++) g1.moveCurrentPieceDown(); //bajamos hasta fijar la pieza
			g1.nextPiece("Z");
			g1.rotateCurrentPieceCounterclockwise();
			g1.moveCurrentPieceDown();//bajamos para fijar la pieza
		} catch (TetrisException e) {
			fail ("Error: Se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		// TODO: comprueba que se lanza las excepción correcta al intentar mover o rotar
		// la pieza actual.
		try {
			g1.moveCurrentPieceDown();
			g1.moveCurrentPieceLeft();
			g1.moveCurrentPieceRight();
			g1.rotateCurrentPieceClockwise();
			g1.rotateCurrentPieceCounterclockwise();
		} catch (FixedPieceMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: Se lanzó la excepción "+e.getClass().getSimpleName());
		}
		

	}

	/* Excepcion OffBoardMovementException al mover o rotar fuera del tablero.
	Se comprueba la prioridad de la excepción respecto a CollisionMovimentException */
	@Test
	public void testGame_moveRotateCurrentPieceExceptions4() {

		try {
			g1.nextPiece("Z");
			g1.rotateCurrentPieceCounterclockwise();
			//Bajamos la pieza a la parte inferior derecha del tablero
			for (int i=0; i<3; i++) { 
				g1.moveCurrentPieceRight(); 
				g1.moveCurrentPieceDown();
			}
			g1.nextPiece("Z");
			g1.rotateCurrentPieceCounterclockwise();
			for (int i=0; i<3; i++) g1.moveCurrentPieceRight(); 
		} catch (TetrisException e) {
			fail("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Probamos mover derecha la currentPiece
		try {
			g1.moveCurrentPieceRight(); //debe lanzar excepción
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException e) { //OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Probamos girar a favor agujas reloj la currentPiece		
		try {
			g1.toString();
			g1.rotateCurrentPieceClockwise();//debe lanzar exepción
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Probamos girar en contra agujas reloj la currentPiece	
		try {
			g1.rotateCurrentPieceCounterclockwise();
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Fijamos la currentPiece y añadimos nuevas piezas
		try {
			g1.moveCurrentPieceDown();
			g1.nextPiece("S");
			g1.rotateCurrentPieceCounterclockwise();
			for (int i=0; i<3; i++) g1.moveCurrentPieceDown(); //bajamos y fijamos la pieza
			g1.nextPiece("S");
			g1.rotateCurrentPieceClockwise();
			g1.moveCurrentPieceLeft();
		} catch (TetrisException e) {
			fail("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		//Probamos mover izquierda la currentPiece
		try {
			g1.moveCurrentPieceLeft(); //debe lanzar excepción
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Probamos girar a favor agujas reloj la currentPiece		
		try {
			g1.toString();
			g1.rotateCurrentPieceClockwise();//debe lanzar exepción
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		//Probamos girar en contra agujas reloj la currentPiece	
		try {
			g1.rotateCurrentPieceCounterclockwise();
			fail("Error: no se lanzó la excepción OffBoardMovementException");
		} catch (OffBoardMovementException  e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}	
	}	

	//Excepcion CollisionMovementException al mover o rotar sobre una pieza fija
	@Test
	public void testGame_moveRotateCurrentPieceExceptions5() {
	
		// TODO: coloca un par de piezas y ve moviéndolas hasta que caigan al fondo del tablero
		// y queden fijas; a continuación mueve y rota la pieza actual y comprueba que se lanza
		// CollisionMovementException y no otra excepción.
		try {
			//ADDING THE FISRT PIECE AND FIXING IT.
			g1.nextPiece("Z");
			g1.rotateCurrentPieceCounterclockwise();
			//Bajamos la pieza a la parte inferior derecha del tablero
			for (int i=0; i<3; i++) { 
				g1.moveCurrentPieceRight(); 
				g1.moveCurrentPieceDown();
			}
			//ADDING THE SECOND PIECE AND FIXING IT.
			g1.nextPiece("S");
			g1.rotateCurrentPieceClockwise();
			g1.moveCurrentPieceLeft();
			for (int i=0; i<3; i++) g1.moveCurrentPieceDown();
			
			//ADDING THE THIRD PIECE.
			g1.nextPiece("T");
			g1.moveCurrentPieceRight();
			g1.moveCurrentPieceDown();
		} catch (TetrisException e) {
			fail("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		try {
			g1.moveCurrentPieceRight();
			g1.moveCurrentPieceLeft();
			g1.rotateCurrentPieceClockwise();
			g1.rotateCurrentPieceCounterclockwise();
		} catch (CollisionMovementException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
	}	
	
	/* Excepciones CurrentPieceNotFixedException y GameEndedMovementException
	   en nextPiece */
	@Test
	public void testGame_nexPieceExceptions() {
		
		try {
			g1.nextPiece("I");
			g1.rotateCurrentPieceClockwise();
			g1.moveCurrentPieceDown(); //No está fija
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		//Probamos CurrentPieceNotFixedException
		try {
			g1.nextPiece("I");
			fail("Error: no se lanzó la excepción CurrentPieceNotFixedException");
		} catch (CurrentPieceNotFixedException e) {
			assertNotNull(e.getMessage());
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		}
		
		try {
			g1.moveCurrentPieceDown(); //Fijamos la pieza
			g1.nextPiece("I"); //Se acaba la partida
		} catch (TetrisException e) {
			fail ("Error: se lanzó la excepción "+e.getClass().getSimpleName());
		} 
		
	}	
	
	/* Excepción NoCurrentPieceException en isCurrentPieceFixed
	*/
	@Test
	public void testGame_isCurrentPieceFixedException() {

		// TODO: escribe pruebas para comprobar que se lanza correctamente NoCurrentPieceException
		try {
			g1.isCurrentPieceFixed();
			fail ("Error: no se lanzó la excepción NoCurrentPieceException");
		} catch (NoCurrentPieceException e) {
			assertNotNull(e.getMessage());
		}
	}
}
