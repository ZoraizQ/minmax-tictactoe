import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * This class is used to read in a state of a tic tac toe board. It creates a MinMax object and passes the state to it. What returns is a list 
 * of possible moves for the player X that have been given min/max values by the method findMoves. The moves that can result in a win or a 
 * tie for X are printed out with the method printBestMoves()
 * 
 * @author Mark Hallenbeck
 *
 * Copyright© 2014, Mark Hallenbeck, All Rights Reservered.
 *
 */
public class AI_MinMax  {
	
	private String[] init_board;
	
	private ArrayList<Node> movesList;
	
//	private Button b1;
//	private TextField t1;
//	private MenuBar menu;
	
	AI_MinMax(String[] board)
	{
		init_board = board;
		
		if(init_board.length != 9)
		{
			System.out.println("You have entered an invalid state for tic tac toe, exiting......");
			System.exit(-1);
		}
		
		MinMax sendIn_InitState = new MinMax(init_board);
		
		movesList = sendIn_InitState.findMoves();
		
		printBestMoves(true);
	}
	
	/**
	 * reads in a string from user and parses the individual letters into a string array
	 * @return String[]
	 */
	private String[] getBoard()
	{
			String puzzle;
			String[] puzzleParsed;
			String delim = "[ ]+";
			
			//give input message
			System.out.println("Enter a string to represent the board state:");
			
			Scanner userInput = new Scanner(System.in);		//open scanner
			
			puzzle = userInput.nextLine();					//scan in string
			
			puzzleParsed = puzzle.split(delim);
			userInput.close();   	  						//close scanner
			
			return puzzleParsed;
			
	}

	/**
	 * goes through a node list and prints out the moves with the best result for player X
	 * checks the min/max function of each state and only recomends a path that leads to a win or tie
	 */
	ArrayList<Integer> printBestMoves(boolean print)
	{
		
		ArrayList<Integer> bestMovesList = new ArrayList<Integer>();;
		
		if (print)
			System.out.print("\n\nThe moves list is: < ");
		
		for(int x = 0; x < movesList.size(); x++)
		{
			Node temp = movesList.get(x);
			
			if(temp.getMinMax() == 10 || temp.getMinMax() == 0)
			{	
				if (print) 
					System.out.print(temp.getMovedTo() + " ");					
				
				bestMovesList.add(temp.getMovedTo());
			}
		}
		
		if (print)
			System.out.print(">");			

		return bestMovesList;
		
	}
	
	public static void main(String[] args) {

		String[] gameBoard = {"b", "b", "b", "b", "b", "b", "b", "b", "b"};

		ExecutorService ex = Executors.newFixedThreadPool(5);
		
		String turn = "X";
		
		for(int iter = 0; iter < 9; iter++) { // total 9 turns
			AI_MinMax newAIPrediction = new AI_MinMax(gameBoard);
			ArrayList<Integer> bestMovesList = newAIPrediction.printBestMoves(false);

			Future<Integer> future = ex.submit(new MyCall(gameBoard, turn, bestMovesList));
		
			try {
				Integer index = future.get(); // result of promise, index to set character  on
				gameBoard[index] = turn; // sets x or o depending on term
				
				// print updated gameboard
				System.out.println(gameBoard[0]+ " "+gameBoard[1]+" "+gameBoard[2]);
				System.out.println(gameBoard[3]+ " "+gameBoard[4]+" "+gameBoard[5]);
				System.out.println(gameBoard[6]+ " "+gameBoard[7]+" "+gameBoard[8]);
			
			} 
			catch(Exception e){System.out.println(e.getMessage());}
			
			if(turn == "X") {
				turn = "O";
			}
			else {
				turn = "X";
			}
		}
		ex.shutdown();
	}
}


class MyCall implements Callable<Integer>{

	String[] board;
	ArrayList<Integer> movesList = new ArrayList<Integer>();
	String move;
	
	MyCall(String[] game, String move, ArrayList<Integer> moveslist){
		this.board = game; // board
		this.move = move; // x or o
		this.movesList = moveslist;
	}
	
	@Override
	public Integer call() throws Exception {
		Random r = new Random(); 
		Integer move =  movesList.get(r.nextInt(movesList.size()));
		
		Thread.sleep(1000);
		System.out.println("\n" + "player: " + move + " chooses index: "+move);
		return move-1; //index of move
	}
	
}