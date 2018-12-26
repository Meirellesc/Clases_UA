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
public class RankingTest {

	static String player1, player2, player3;
	static String name1, name2, name3;
	static IVisualizer visu;
	
	Ranking<RowsClearedScore> rankRows = new Ranking<>();
	Ranking<TimeScore> rankTime = new Ranking<>();
	
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
		
		player2 = player3 = "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
						  + "I↺→↻→→→↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
						  + "I←←←←↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓O↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓";
		
		
		visu=VisualizerFactory.createVisualizer("console");
		name1 = "Lucas";
		name2 = "Amanda";
		name3 = "Joe";
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	//Testing addScore() with RowsClearedScore.
	@Test
	public void addScoreTest_RCS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			RowsClearedScore rc1 = new RowsClearedScore(name1, gp1);
			rankRows.addScore(rc1);
			
			assertNotNull(rankRows);
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
		
	}
	
	//Testing addScore() with TimeScore.
	@Test
	public void addScoreTest_TS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			rankTime.addScore(ts1);
		
			assertNotNull(rankTime);
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing getWinner with RowsClearedScore. 
	@Test
	public void getWinnerTest_RCS() {
		
		try {
			//Player1
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			RowsClearedScore rc1 = new RowsClearedScore(name1, gp1);
			rankRows.addScore(rc1);
			
			//Player2
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2, visu);
			gp2.play();
			RowsClearedScore rc2 = new RowsClearedScore(name2, gp2);
			rankRows.addScore(rc2);
			
			assertEquals("Lucas", rankRows.getWinner().getName());
			
		} catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		} catch (RankingException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
		
	}
	
	//Testing getWinner with TimeScore.
	@Test
	public void getWinnerTest_TS() {
		
		try {
			//Player1
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			rankTime.addScore(ts1);
		
			//Player2
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2, visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			rankTime.addScore(ts2);
		
			assertEquals("Amanda", rankTime.getWinner().getName());
			
		} catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		} catch (RankingException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing getWinner throwing the RankingException with RowsClearedScore. 
	@Test
	public void getWinnerTest() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			
			assertEquals("Lucas", rankRows.getWinner().getName());
			
			fail("Error: no se lanzo la excepcion RankingException");
			
		} catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		} catch (RankingException e) {
			
		}
	}
	
	//Testing getWinner throwing the RankingException with TimeScore.
	@Test (expected=RankingException.class)
	public void getWinnerTest2() throws TetrisIOException, RankingException {
		
		IPlayer pl1 = PlayerFactory.createPlayer(player1);
		GamePlay gp1 = new GamePlay(pl1, visu);
		gp1.play();
		
		assertEquals("Lucas", rankTime.getWinner().getName());
	}
	
	//Testing getSortedRanking().
	@Test
	public void getSortedRankingTest() {
		
		try {
			//Player1
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1, visu);
			gp1.play();
			RowsClearedScore rc1 = new RowsClearedScore(name1, gp1);
			rankRows.addScore(rc1);
			
			//Player2
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2, visu);
			gp2.play();
			RowsClearedScore rc2 = new RowsClearedScore(name2, gp2);
			rankRows.addScore(rc2);
		 
			assertEquals("[Lucas:4, Amanda:2]", rankRows.getSortedRanking().toString());
			
		} catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	
}
