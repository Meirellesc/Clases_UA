package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	private FileReader fr;
	
	private static final String filename = "/home/meirelles/Clases_UA/TETRIS/prog3-tetris"; 
	
	PlayerFile(BufferedReader b) {
		b = Objects.requireNonNull(b, "El parametro 'b' no puede ser null!");
		br = b;
	}
	
	
	@Override
	public char nextMove() throws TetrisIOException, FileNotFoundException {
				
		fr = new FileReader(filename);
		
		String sCurrentLine;
		
		
		
		/*
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
		*/
		
		return 0;
	}

}
