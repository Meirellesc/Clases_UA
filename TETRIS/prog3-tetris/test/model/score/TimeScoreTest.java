package model.score;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import model.exceptions.io.TetrisIOException;
import model.io.GamePlay;
import model.io.IPlayer;
import model.io.IVisualizer;
import model.io.PlayerFactory;
import model.io.VisualizerFactory;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 *
 */
public class TimeScoreTest {

	static String player1;
	static IVisualizer visu;
	static String name;
	
		@Rule
	    public Timeout globalTimeout = Timeout.seconds(10);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		player1="I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		visu=VisualizerFactory.createVisualizer("console");
		name = "Lucas";
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	//Testing the default constructor.
	@Test
	public void testTimeScore() {
		try {
			IPlayer pl = PlayerFactory.createPlayer(player1);
			GamePlay gp = new GamePlay(pl, visu);
			TimeScore ts = new TimeScore(name, gp);
			gp.play();
			
			assertNotNull(ts);
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing the duration of a game returned by getScoring.
	@Test
	public void getScoringtest() {
		try {
			IPlayer pl = PlayerFactory.createPlayer(player1);
			GamePlay gp = new GamePlay(pl, visu);
			TimeScore ts = new TimeScore(name, gp);
			gp.play();
			
			//HAVE TO CHECK WHAT IS THE DURATION OF THIS GAME
			fail("HAVE TO CHECK WHAT IS THE DURATION OF THIS GAME");
			
			assertEquals("getScoring", 0, ts.getScoring()); //The duration of the game has to be 2.
		
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}

}
