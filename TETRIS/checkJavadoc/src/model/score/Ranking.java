package model.score;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.RankingException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 * @param <ScoreType> = ScoreType: RowsClearedScore or TimeScore.
 */
public class Ranking<ScoreType extends Score> {
	
	/**
	 * @variable gamePlays.
	 */
	private SortedSet<ScoreType> gamePlays;
	
	/** [ENG] Constructor that initialize the atribute "gamePlays" (type 'TreeSet').
	 *  [SPA] Constructor que inicializa el atributo "gamePlays" (tipo 'TreeSet').
	 * 
	 */
	public Ranking() {
		gamePlays = new TreeSet<>();
	}
	
	/** [ENG] Method that add the object passed as a parameter to the gamePlays set.
	 *  [SPA] Método que añade el objeto pasado como parámetro al conjunto gamePlays.
	 * 
	 * @param st = input a ScoreType / introduce a ScoreType.
	 */
	public void addScore(ScoreType st) {
		
		st = Objects.requireNonNull(st, "El parametro 'addScore (st)' no puede ser null.");
		
		gamePlays.add(st); //The function "add()" call the 'compareTo' implicit.
	}
	
	/** [ENG] Method that returns the first element of the gamePlays set (the winner).
	 *  [SPA] Método que devuelve el primer elemento del conjunto gamePlays (el gañador).
	 * 
	 * @return = first element of the gamePlays set (the winner).
	 * @throws RankingException = throws if the set "gamePlays" is Empty. 
	 */
	public ScoreType getWinner() throws RankingException{
		//Condition that check if the set "gamePlays" is Empty.
		if(gamePlays.isEmpty()) {
			throw new RankingException();
		}
		return gamePlays.first();
	}
	
	/** [ENG] Method that returns gamePlays set (the ranking).
	 *  [SPA] Método que devuelve  el conjunto gamePlays (el ranking).
	 * 
	 * @return = el ranking.
	 */
	public SortedSet<ScoreType> getSortedRanking(){
		return gamePlays;
	}
}
