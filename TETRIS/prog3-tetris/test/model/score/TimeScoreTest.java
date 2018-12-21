package model.score;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import model.exceptions.io.TetrisIOException;
import model.exceptions.score.RankingException;
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

	static String player1, player2;
	static String name1, name2;
	static IVisualizer visu;
	
		@Rule
	    public Timeout globalTimeout = Timeout.seconds(10);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		player1 = "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		player2 = "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
				+ "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		visu=VisualizerFactory.createVisualizer("console");
		name1 = "Lucas";
		name2 = "Amanda";
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
			TimeScore ts = new TimeScore(name1, gp);
			gp.play();
			
			assertNotNull(ts);
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing who won a game using TimeSocore.getScoring().
	@Test
	public void getScoringtest() throws RankingException {
		try {
			Ranking<TimeScore> rt = new Ranking<>();
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			rt.addScore(ts1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2, visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			rt.addScore(ts2);
					
			assertEquals("Amanda", rt.getWinner().getName());
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing who won a game using TimeSocore.getScoring().
	@Test
	public void getScoringtest2() throws RankingException {
		try {
			Ranking<TimeScore> rt = new Ranking<>();
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			rt.addScore(ts1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2, visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			rt.addScore(ts2);
					
			assertNotEquals("Lucas", rt.getWinner().getName());
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}

}
