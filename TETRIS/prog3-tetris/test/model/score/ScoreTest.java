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
public class ScoreTest {

	static String player1, player2, player3;
	static String name1, name2, name3;
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
	
	//Testing the default constructor.
	@Test
	public void testScore() {
				
	}
	
	//Testing toString.
	@Test
	public void toStringTest() {
		try {
			IPlayer pl = PlayerFactory.createPlayer(player1);
			GamePlay gp = new GamePlay(pl, visu);
			gp.play();
			RowsClearedScore rc = new RowsClearedScore(name1, gp);			
			assertEquals("Lucas:4", rc.toString());
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing getName with RowsClearedScore.
	@Test
	public void getNameTest_RCS() {
		try {
			IPlayer pl = PlayerFactory.createPlayer(player1);
			GamePlay gp = new GamePlay(pl, visu);
			gp.play();
			RowsClearedScore rc = new RowsClearedScore(name1,gp);		
			assertEquals("Lucas", rc.getName());
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}

	
	//Testing getName with TimeScore.
	@Test
	public void getNameTest_TS() {
		try {
			IPlayer pl = PlayerFactory.createPlayer(player1);
			GamePlay gp = new GamePlay(pl, visu);
			gp.play();
			TimeScore tc = new TimeScore(name1, gp);		
			
			assertEquals("Lucas", tc.getName());
			
		}catch(TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing compareTo with "this" > "parameter" with RowsClearedScore.
	@Test
	public void compareTo1_RCS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1,visu);
			gp1.play();
			RowsClearedScore rc1 = new RowsClearedScore(name1, gp1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			RowsClearedScore rc2 = new RowsClearedScore(name2, gp2);
			
			assertEquals("rc1 > rc2 .: -1",-1,rc1.compareTo(rc2)); //How rc1 > rc2 then compareTo have to return "-1".
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
		
		
	}
	
	//Testing compareTo with "this" < "parameter" with RowsClearedScore.
	@Test
	public void compareTo2_RCS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1,visu);
			gp1.play();
			RowsClearedScore rc1 = new RowsClearedScore(name1, gp1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			RowsClearedScore rc2 = new RowsClearedScore(name2, gp2);
			
			assertEquals("rc1 < rc2 .: -1",1,rc2.compareTo(rc1)); //How rc1 < rc2 then compareTo have to return "-1".
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing compareTo with "this" == "parameter" with RowsClearedScore.
	@Test
	public void compareTo3_RCS() {
		
		try {
			IPlayer pl3 = PlayerFactory.createPlayer(player3);
			GamePlay gp3 = new GamePlay(pl3,visu);
			gp3.play();
			RowsClearedScore rc3 = new RowsClearedScore(name1, gp3);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			RowsClearedScore rc2 = new RowsClearedScore(name2, gp2);
			
			assertEquals("Amanda",-11,rc2.compareTo(rc3)); //How rc3 == rc2 then compareTo have to return in alphabetical order.
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing compareTo with "this" < "parameter" with TimeScore.
	@Test
	public void compareTo1_TS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1,visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			
			assertEquals("ts1 < ts2 .: 1",1,ts1.compareTo(ts2)); //How ts1 < ts2 then compareTo have to return "1".
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing compareTo with "this" > "parameter" with TimeScore.
	@Test
	public void compareTo2_TS() {
		
		try {
			IPlayer pl1 = PlayerFactory.createPlayer(player1);
			GamePlay gp1 = new GamePlay(pl1,visu);
			gp1.play();
			TimeScore ts1 = new TimeScore(name1, gp1);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			
			assertEquals("ts1 < ts2 .: -1",-1,ts2.compareTo(ts1)); //How ts1 < ts2 then compareTo have to return "-1".
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
	
	//Testing compareTo with "this" == "parameter" with TimeScore.
	@Test
	public void compareTo3_TS() {
		
		try {
			IPlayer pl3 = PlayerFactory.createPlayer(player3);
			GamePlay gp3 = new GamePlay(pl3,visu);
			gp3.play();
			TimeScore ts3 = new TimeScore(name3, gp3);
			
			IPlayer pl2 = PlayerFactory.createPlayer(player2);
			GamePlay gp2 = new GamePlay(pl2,visu);
			gp2.play();
			TimeScore ts2 = new TimeScore(name2, gp2);
			
			assertEquals("ts3 == ts2 .: -1",-1,ts2.compareTo(ts3)); //How ts3 == ts2 then compareTo have to return "-1".
			
		}catch (TetrisIOException e) {
			fail("Error: se lanzo la excepcion "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
	}
}
