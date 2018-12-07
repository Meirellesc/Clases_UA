package model.score;

import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date --/--/2018
 *
 */
public class Score {

	protected GamePlay gamePlay;
	
	private String name;
	
	private int score;
	
	
	Score(String s, GamePlay g){
		
	}
	
	public String toString() {
		return null;
	}
	
	public String getName() {
		return null;
	}
	
	public int getScoring() {
		return 0;
	}
	
	public int compareTo(Score sc) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	
	
}
