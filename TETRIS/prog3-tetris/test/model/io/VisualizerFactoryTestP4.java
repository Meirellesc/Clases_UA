package model.io;
// 1 TEST A REALIZAR
import static org.junit.Assert.*;

import model.exceptions.io.TetrisIOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VisualizerFactoryTestP4 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateVisualizer() {
	 //TODO Implementa el test que cree un VisualizerConsole y compruebe que:
	 // - no es null
     // - y que efectivamente es un objeto de la clase VisualizerConsole
	 fail("¡Implementa el test!");
	}
	
	@Test(expected=TetrisIOException.class)
	public void testCreateVisualizerTetrisIOException1() throws TetrisIOException {
			VisualizerFactory.createVisualizer("Console");
	}

}


