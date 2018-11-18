package model.io;
// 10 TEST A REALIZAR
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import model.exceptions.io.TetrisIOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GamePlayTestP4 {
	static String splayMain1, splayFinal;
	static IVisualizer ivc; 
	final String stestplay5="T↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T"+
			"←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T↻←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T↺→↓↓↓↓↓↓↓↓↓↓↓↓"+
			"↓↓↓↓↓L↺←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓J↻←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T↺→→→→↓↓↓↓↓↓↓↓"+
			"↓↓↓↓↓↓↓↓↓J↻→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I↺→→→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
	final String stestplay6="S←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓S↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓←↓"+
			"L↻↻←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O→→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O→→↓↓↓↓↓↓↓↓↓↓"+
			"↓↓↓↓↓↓↓↓↓I↺→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓T↻↻↻↓↓↓↓↓"+
			"↓↓↓↓↓↓↓↓↓↓↓↓↓↓O→→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"+
			"Z↺↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I↻↓↓↓↓↓↓↓↓↓↓↓↓↓↓"+
			"↓↓T↻←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓J↺↓↓↓↓↓↓↓↓↓↓↓↓↓↓←↓←↓Z↺↓↓↓↓↓↓↓↓↓↓↓↓↓↓"+
			"↓↓O→→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓S↻↻↻←←←↓↓↓↓↓↓↓↓↓"+
			"↓↓↓↓↓↓↓T↺←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓J↻←↓↓↓↓↓↓↓↓↓↓↓↓↓↓"+
			"↓L↓↓↓↓↓↓↓↓↓↓↓↓↓I↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓Z↺↓↓↓↓↓↓↓↓L↻↓↓↓↓↓I↺↓J";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		splayMain1="I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		ivc=VisualizerFactory.createVisualizer("console");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGamePlay() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
	
			GamePlay gp = new GamePlay(ip,ivc);
			assertNotNull(gp);
		
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
		}
	}

	@Test(/*Pon lo que debe ir aquí*/)
	public void testGamePlayVacio() throws TetrisIOException {
		//TODO Test que al ejecutar play() lanza TetrisIOException cuando se crea un GamePlay con un IPlayer creado
		// con un String con un espacio en blanco (" ");
		fail ("¡Falta implementar el test!");
	}

	@Test
	public void testPlayRandom() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("54322");
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlayRandom.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlayRandom.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlayRandom.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//String del main
	@Test
	public void testPlay1() {
		try {
			IPlayer ip = PlayerFactory.createPlayer(splayMain1);
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlay1.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlay1.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlay1.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
		
	//Fichero con string del main (resultado igual a testPlay1)
	@Test
	public void testPlay2() {
		
			//TODO Apoyándote en splayMain1, crea un fichero de texto UTF8 "testPlay2.in", en test/files/P4/ del proyecto
			// que contenga las instrucciones correspondientes a splayMain1 en fichero.
			// Seguidamente añade las instrucciones correspondientes para:
			// - crear un IPlayer pasándo como String la cadena "test/files/P4/testPlay2.in"
			// - crea un GamePlay con ese IPlayer y el IVisualizer vrc
			// - Cambia la salida estandard al fichero "test/files/P4/testPlay2.alu"
 			// - Invoca a play para ese GamePlay
			// - Restituye la salida estandard a System.out
			// - Lee con readSolutionFromFile los contenidos de los ficheros "testPlay2.alu" y "testPlay1.sol" asignando
			//   sus contenidos a dos variables StringBuilder respectivamente
			// - Comprueba que ambos StringBuilder tienen el mismo contenido.
			fail ("¡Realiza el test!");
			
	}
		//PlayerRamdom
	@Test
	public void testPlay3() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("123987");
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlay3.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlay3.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlay3.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	@Test
	public void testPlay4() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("test/files/P4/testPlay4.in");
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlay4.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlay4.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlay4.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	@Test
	public void testPlay5() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("test/files/P4/testPlay5.in");
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlay5.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlay5.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlay5.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	//Misma partida que testPlay5 pero leyéndola de un String
	@Test
	public void testSPlay5() {
		//TODO Si el testPlay5() te fue bien, realiza éste creando un IPlayer a partir del atributo stestplay5
		// Comprueba que la ejecución del play con este IPlayer coincide con la solución del anterior test y que 
		// no se produce excepción. Puedes usar, si quieres, la misma estructura que los anteriores.
		fail("¡Realiza el test!");
	}
	
	@Test
	public void testPlay6() {
		try {
			IPlayer ip = PlayerFactory.createPlayer("test/files/P4/testPlay6.in");
			GamePlay gp = new GamePlay(ip,ivc);
			standardIO2File("test/files/P4/testPlay6.alu");
			gp.play();
			System.setOut(System.out);
			StringBuilder sbalu = readSolutionFromFile("test/files/P4/testPlay6.alu");
			StringBuilder sbsol = readSolutionFromFile("test/files/P4/testPlay6.sol");
			assertEquals(sbsol.toString(),sbalu.toString());
			
		} catch (TetrisIOException e) {
			fail("Error: excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Misma partida que testPlay6 pero leyéndola de un String
	@Test
	public void testSPlay6() {
		//TODO Si el testPlay6() te fue bien, realiza éste creando un IPlayer a partir del atributo stestplay6
		// Comprueba que la ejecución del play con este IPlayer coincide con la solución del anterior test y que 
		// no se produce excepción. Puedes usar, si quieres, la misma estructura que los anteriores.
		fail("¡Realiza el test!");
	}
	
	
	
	//Comprobación que al salirse del tablero ignora la excepcion
	@Test
	public void testPlay7() {
		//TODO Crea un test (puedes usar la estructura de los anteriores) que cree un PlayerString, para usarlo en un GamePlay,
		// en cuya secuencia del string, una pieza intenta salir del tablero. Comprueba que ignora esa excepción.
		// Por supuesto, no se produce excepción alguna.
		fail ("¡Implementa el test!");
	}
	
	//Comprobación que al mover una pieza fija ignora la excepcion
	@Test
	public void testPlay8() {
		//TODO Crea un test (puedes usar la estructura de los anteriores) que cree un PlayerString, para usarlo en un GamePlay,
		// en cuya secuencia del string una pieza se hace fija y se intenta mover. Comprueba que ignora esa excepción.
		// Por supuesto, no se produce excepción alguna.
		fail ("¡Implementa el test!");
	}
	
	//Comprobación que al colisionar con una pieza fija ignora la excepcion
	@Test
	public void testPlay9() {
		//TODO Crea un test (puedes usar la estructura de los anteriores) que cree un PlayerString, para usarlo en un GamePlay,
		// en cuya secuencia la pieza no fija colisiona con una fija. Comprueba que ignora esa excepción.
		fail ("¡Implementa el test!");
	}
	
	//Comprobación que al terminar la partida, ignora el resto de movimientos
	@Test
	public void testPlay10() {
		//TODO Crea un test (puedes usar la estructura de los anteriores) que cree un PlayerString, para usarlo en un GamePlay,
		// en cuya secuencia del string la partida que termina,  pero sigue intentando mover. Comprueba que ignora esos movimientos de más.
		// Por supuesto, no se produce excepción alguna.
		fail ("¡Implementa el test!");
	}
	

	//Se produce excepción TetrisIOException cuando movemos en un tablero vacío
	@Test(/*Pon lo que debe ir aquí*/)
	public void testPlay11() throws TetrisIOException {
	//TODO Crear un test que produzca una excepcion TetrisIOException cuando en un
	// GamePlay intentamos mover en un tablero vacío.
		fail("¡Implementa el test!");
	
	}
	
	//Se produce excepción TetrisIOException cuando ponemos pieza con una pieza no fija en el tablero
	@Test(/*Pon lo que debe ir aquí*/)
	public void testPlay12() throws TetrisIOException {
	//TODO Crear un test para que lance la excepcion TetrisIOException cuando en 
	// el String que se pase al crear el PlayerString, se pone una pieza en el tablero
    // cuando hay una pieza no fija todavía.
		fail("¡Implementa el test!");
	}
	
	
	/*************************
	 * FUNCIONES AUXILIARES
	 *************************/
	//Redirección de la salida estandard a un fichero	
	public static void standardIO2File(String fileName){

        if(fileName.equals("")){//Si viene vacío usamos este por defecto
            fileName="C:\\javalog.txt";
        }

        try {
            //Creamos un printstream sobre el archivo.
            PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(fileName))),true);
            //Redirigimos salida estandar
            System.setOut(ps);
        } catch (FileNotFoundException ex) {
            System.err.println("Se ha producido una excepción FileNotFoundException");
        }
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
	
	
}
