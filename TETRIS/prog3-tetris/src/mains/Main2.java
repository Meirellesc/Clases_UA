//package mains;
//
//import model.Coordinate;
//import model.Game;
//import model.Piece;
//
///**
// * @author Lucas  Meirelles
// * @version Oxygen 4.7
// **/
//public class Main2 {
//	
//	public static void main(String[] args) {	
//		Game game= new Game(new Coordinate(7, 10));
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceClockwise();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceCounterclockwise();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceCounterclockwise();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		
//		System.out.println("----------------------");
//		main2(args);
//	}
//	
//
//	public static void main2(String[] args) {
//		
//		Coordinate a= new Coordinate(0,0);
//		System.out.println(a);
//		Piece t= new Piece();
//		System.out.println(t.toString());
//		t.rotateCounterclockwise();
//		System.out.println(t.toString());
//		t.rotateCounterclockwise();
//		System.out.println(t.toString());
//		t.rotateCounterclockwise();
//		System.out.println(t.toString());
//		t.rotateCounterclockwise();
//		System.out.println(t.toString());
//		
//		Game game= new Game(new Coordinate(7, 10));
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceClockwise();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceCounterclockwise();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceCounterclockwise();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceClockwise();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		System.out.println(game.isCurrentPieceFixed());
//
//		// New game:
//		System.out.println("\nNew game!\n");
//		game= new Game(new Coordinate(5,9));
//		game.toString();
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.rotateCurrentPieceCounterclockwise();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.toString();
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceRight();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceLeft();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		
//		// New game:
//		System.out.println("\nNew game!\n");
//		System.out.println(game.isGameEnded());
//		game= new Game(new Coordinate(3,8));
//		game.toString();
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		System.out.println(game.isGameEnded());
//		game.nextPiece();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.moveCurrentPieceDown();
//		System.out.println(game.toString());
//		game.nextPiece();
//		System.out.println("FIM " + game.isGameEnded());
//	}
//
//}