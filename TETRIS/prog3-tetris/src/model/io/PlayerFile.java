package model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class PlayerFile implements IPlayer{

	private BufferedReader br;
	
	private int currentLine = 0;
	
	PlayerFile(BufferedReader b) {
		b = Objects.requireNonNull(b, "El parametro 'BufferedReader(b)' no puede ser null!");
		br = b;
	}
	
	// I use try/catch or throws IOException?? 
	
	@Override
	public char nextMove() throws TetrisIOException{
		
		String content;
		String[] line = null;
		int count = 0;
		
		//Puting the instructions in a String[] (without spaces and tab)
		try {
			if(br.ready()) {
				content = br.readLine();
				line = content.split("\\s+");
				
				////Checking if have a instruction which is not "VALID".	
				if((line.length == 2) && (line[currentLine].equals("put") && line[currentLine+1].equals("I") || line[currentLine].equals("put") && line[currentLine+1].equals("J") 
				|| line[currentLine].equals("put") && line[currentLine+1].equals("L") || line[currentLine].equals("put") && line[currentLine+1].equals("O") 
				|| line[currentLine].equals("put") && line[currentLine+1].equals("S") || line[currentLine].equals("put") && line[currentLine+1].equals("T")
				|| line[currentLine].equals("put") && line[currentLine+1].equals("Z") || line[currentLine].equals("move")&& line[currentLine+1].equals("left")
				|| line[currentLine].equals("move")&& line[currentLine+1].equals("right") ||line[currentLine].equals("move")&& line[currentLine+1].equals("down")
				|| line[currentLine].equals("rotate") && line[currentLine+1].equals("clockwise") || line[currentLine].equals("rotate") && line[currentLine+1].equals("counterclockwise"))){
							
					count = 1;
				}
				if (count != 1) {
					throw new TetrisIOException("Have a INVALID instruction, check again the file!!");
				}
				
				//Returning a character that represents the next movement 
				if (line[currentLine].equals("put") && line[currentLine+1].equals("I")) {
					return NEXT_PIECE_I;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("J")) {
					return NEXT_PIECE_J;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("L")) {
					return NEXT_PIECE_L;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("O")) {
					return NEXT_PIECE_O;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("S")) {
					return NEXT_PIECE_S;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("T")) {
					return NEXT_PIECE_T;
				}
				else if (line[currentLine].equals("put") && line[currentLine+1].equals("Z")) {
					return NEXT_PIECE_Z;
				}
				else if (line[currentLine].equals("move") && line[currentLine+1].equals("left")) {
					return MOVE_LEFT;
				}
				else if (line[currentLine].equals("move") && line[currentLine+1].equals("right")) {
					return MOVE_RIGHT;
				}
				else if (line[currentLine].equals("move") && line[currentLine+1].equals("down")) {
					return MOVE_DOWN;
				}
				else if (line[currentLine].equals("rotate") && line[currentLine+1].equals("clockwise")) {
					return ROTATE_CLOCKWISE;
				}
				else if (line[currentLine].equals("rotate") && line[currentLine+1].equals("counterclockwise")) {
					return ROTATE_COUNTERCLOCKWISE;
				}
			}
		}catch (IOException e) {
		}
		return LAST_MOVE;
	}
}
