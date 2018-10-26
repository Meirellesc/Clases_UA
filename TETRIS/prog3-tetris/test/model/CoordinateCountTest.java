package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Coordinate;	

/**
* @author Lucas Meirelles
* @version Oxygen 4.7
**/
public class CoordinateCountTest {
	Coordinate c;
	
	@Before
	public void setUp() throws Exception {
		c = new Coordinate(3, 5);
				
	}

	
	@Test
	public final void testCoordinateCount() {
		Coordinate c3 = new Coordinate(100,25);
		Coordinate c2 = new Coordinate(c);
		assertEquals("c.add(c7)","[103,30]",c.add(c3).toString());
		assertEquals("Num. Coords. ", 4, Coordinate.getCoordinateCount());
	}
	

}