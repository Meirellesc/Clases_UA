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
	 try {
		 IVisualizer vf;
		 vf = VisualizerFactory.createVisualizer("console"); 
		 
		 assertNotNull(vf);
		 assertEquals(VisualizerConsole.class, vf.getClass());
	 }catch(TetrisIOException e) {
		 fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName());
	 }
		
	}
	
	@Test(expected=TetrisIOException.class)
	public void testCreateVisualizerTetrisIOException1() throws TetrisIOException {
			VisualizerFactory.createVisualizer("Console");
	}

}


