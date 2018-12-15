package model.score;

import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.RankingException;


/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 */
public class Ranking<ScoreType extends Score> {
		
	private SortedSet<ScoreType> gamePlays;
	
	public Ranking() {
		gamePlays = new TreeSet<>();
	}

	public void addScore(ScoreType st) {
		gamePlays.add(st); //I have to call 'compareTo' or this already doing implicit??
	}
	
	public ScoreType getWinner() throws RankingException{
		//Condition that check if the set "gamePlays" is Empty.
		if(gamePlays.isEmpty()) {
			throw new RankingException();
		}
		return gamePlays.first();
	}
	
	public SortedSet<ScoreType> getSortedRanking(){
		return gamePlays;
	}
}
