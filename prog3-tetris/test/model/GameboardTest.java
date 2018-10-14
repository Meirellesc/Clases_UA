package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Gameboard;

public class GameboardTest {
	Coordinate c;
	
	@Before
	public void setUp() throws Exception {
		c = new Coordinate(3, 5);
	}
	
	@Test
	public void testGetHeight() {
		assertEquals("Height", 3, c.getRow());
	}

	@Test
	public void testGetWidth() {
		assertEquals("Width", 5, c.getColumn());
	}


}
