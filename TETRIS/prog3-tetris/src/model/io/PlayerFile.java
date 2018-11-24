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
	
	@Override
	public char nextMove() throws TetrisIOException{
		
		try {
						
			String content;
			String[] line = null;
			int count = 0;
			
			//Puting the instructions in a String (without spaces and tab)
			while ((content = br.readLine()) != null) {
				line = content.split("\\s+");
				//System.out.println(content);
			}
			
			System.out.println("Linha 0 " + line[0] + "\n " +"Linha 1 "  + line[1]);
			
			/*
			//Checking if have a instructions which are not valid.
			for(int i=0; i<=line.length;i++) { //Or i<=content.lenght() ??
				if(line[i] == "put" || line[i] == "I" || line[i] == "J" || line[i] == "L" || line[i] == "O"|| line[i] == "S" 
				|| line[i] == "T" || line[i] == "Z" || line[i] == "move" || line[i] == "left" || line[i] == "right" 
				|| line[i] == "down" || line[i] == "rotate" || line[i] == "clockwise" || line[i] == "counterclockwise"){
					count += 1;
				}
			}
			if (count != line.length) {
				throw new TetrisIOException("Have a INVALID instruction, check again the file!!");
			}
			*/
			//Returning a character that represents the next movement 
			if (line[currentLine].equals("put") || line[currentLine+1].equals("I")) {
				currentLine += 1;
				return NEXT_PIECE_I;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "J") {
				currentLine += 1;
				return NEXT_PIECE_J;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "L") {
				currentLine += 1;
				return NEXT_PIECE_L;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "O") {
				currentLine += 1;
				return NEXT_PIECE_O;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "S") {
				currentLine += 1;
				return NEXT_PIECE_S;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "T") {
				currentLine += 1;
				return NEXT_PIECE_T;
			}
			else if (line[currentLine] == "put" && line[currentLine+1] == "Z") {
				currentLine += 1;
				return NEXT_PIECE_Z;
			}
			else if (line[currentLine] == "move" && line[currentLine+1] == "left") {
				currentLine += 1;
				return MOVE_LEFT;
			}
			else if (line[currentLine] == "move" && line[currentLine+1] == "right") {
				currentLine += 1;
				return MOVE_RIGHT;
			}
			else if (line[currentLine] == "move" && line[currentLine+1] == "down") {
				currentLine += 1;
				return MOVE_DOWN;
			}
			else if (line[currentLine] == "rotate" && line[currentLine+1] == "clockwise") {
				currentLine += 1;
				return ROTATE_CLOCKWISE;
			}
			else if (line[currentLine] == "rotate" && line[currentLine+1] == "counterclockwise") {
				currentLine += 1;
				return ROTATE_COUNTERCLOCKWISE;
			}
			else {
				return LAST_MOVE;
			}
		}catch (IOException e) {
			
		}
		return 0;
		
	}

}
