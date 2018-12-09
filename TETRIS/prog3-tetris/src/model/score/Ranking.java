package model.score;

import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.RankingException;

public class Ranking<ScoreType extends Score> {
		
	private SortedSet<ScoreType> gamePlays;
	
	public Ranking() {
		gamePlays = new TreeSet<>();
	}

	public void addScore(ScoreType st) {
		gamePlays.add(st); //IS IT RIGHT??
	}
	
	public ScoreType getWinner() throws RankingException{
		//Condition that check if the set "gamePlays" is Empty.
		if(gamePlays.isEmpty()) {
			throw new RankingException();
		}
		else {
			return gamePlays.first();
		}
	}
	
	public SortedSet<ScoreType> getSortedRanking(){
		//DON'T UNDERSTAND WHAT I HAVE TO RETURN!!
		return null;
	}
}
