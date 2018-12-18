package model.score;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import model.S;
import model.exceptions.io.TetrisIOException;
import model.io.GamePlay;
import model.io.IPlayer;
import model.io.IVisualizer;
import model.io.PlayerFactory;
import model.io.VisualizerFactory;

public class ScoreTest {

	static String player1;
	static String name;
	static IVisualizer visu;
	
		@Rule
	    public Timeout globalTimeout = Timeout.seconds(10);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		player1="I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		visu=VisualizerFactory.createVisualizer("console");
		name = "Lucas";
		
		IPlayer pl = PlayerFactory.createPlayer(player1);
		GamePlay gp = new GamePlay(pl, visu);
		Score sc = new Score(name,gp) {
			
			@Override
			public int getScoring() {
				return 2;
			}
		};
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	//Testing the default constructor
	@Test
	public void testScore() {
				
	}
	
	//Testing toString
	@Test
	public void toStringTest() {
		
	}
	
	//Testing getName
	@Test
	public void getNameTest() {
		//assertEquals("Lucas",);
	}
}
