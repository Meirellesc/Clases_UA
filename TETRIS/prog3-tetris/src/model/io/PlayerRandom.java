package model.io;

import java.util.Random;

public class PlayerRandom implements IPlayer{

	private Random random;
	
	private boolean nextPutPiece = true;
	
	private int downCounter = 0;
	
	public PlayerRandom(long l) {
	
	}
	
	@Override
	public char nextMove() {
		return 0;
	}

}
