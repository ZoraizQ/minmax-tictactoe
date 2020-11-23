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
public class AI_MinMax extends Application  {
	
	private String[] init_board;
	
	private ArrayList<Node> movesList;
	
	private Button b1;
	
	private TextField t1;
	
	private MenuBar menu;
	
	AI_MinMax()
	{
		init_board = getBoard();
		
		if(init_board.length != 9)
		{
			System.out.println("You have entered an invalid state for tic tac toe, exiting......");
			System.exit(-1);
		}
		
		MinMax sendIn_InitState = new MinMax(init_board);
		
		movesList = sendIn_InitState.findMoves();
		
		printBestMoves();
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
	private void printBestMoves()
	{
		System.out.print("\n\nThe moves list is: < ");
		
		for(int x = 0; x < movesList.size(); x++)
		{
			Node temp = movesList.get(x);
			
			if(temp.getMinMax() == 10 || temp.getMinMax() == 0)
			{
				System.out.print(temp.getMovedTo() + " ");
			}
		}
		
		System.out.print(">");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AI_MinMax startThis = new AI_MinMax();

		primaryStage.setTitle("AI TicTacToe");
		
		b1 = new Button("button 1");
		t1 = new TextField();
	
		
		//use a lambda expression to attach the event handler to a button
		b1.setOnAction(e->t1.setText("I love this syntax!!!!"));
		
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mOne = new Menu("option 1"); //a menu goes inside a menu bar
		Menu mTwo = new Menu("option 2");
		
		MenuItem iOne = new MenuItem("click me"); //menu items go inside a menu
		
		//event handler for menu item
		iOne.setOnAction(e->t1.setText("menu item was clicked")); 
		
		mOne.getItems().add(iOne); //add menu item to first menu
		
		menu.getMenus().addAll(mOne, mTwo); //add two menus to the menu bar
		
		
		//new scene with root node
		Scene scene = new Scene(new VBox(20,menu,b1,t1), 700,700);
		primaryStage.setScene(scene); //set the scene in the stage
		primaryStage.show(); //make visible to the user
		
		// TODO Auto-generated method stub

//		
//		ArrayList<Character> gameBoard = new ArrayList<>(Arrays.asList('-','-','-','-','-','-','-','-','-'));
//		
//		ExecutorService ex = Executors.newFixedThreadPool(5);
//		
//		Character turn = 'x';
//		
//		for(int iter = 0; iter < 9; iter++) {
//			
//			Future<Integer> future = ex.submit(new MyCall(gameBoard, turn));
//		
//			try {
//			Integer index = future.get();
//			gameBoard.set(index, turn);
//			System.out.println(gameBoard.get(0)+ " "+gameBoard.get(1)+" "+gameBoard.get(2));
//			System.out.println(gameBoard.get(3)+ " "+gameBoard.get(4)+" "+gameBoard.get(5));
//			System.out.println(gameBoard.get(6)+ " "+gameBoard.get(7)+" "+gameBoard.get(8));
//			
//			}catch(Exception e){System.out.println(e.getMessage());}
//			
//			if(turn == 'x') {
//				turn = 'o';
//			}
//			else {
//				turn = 'x';
//			}
//		}
//		ex.shutdown();
	}
}
//
//
//class MyCall implements Callable<Integer>{
//
//	ArrayList<Character> board = new ArrayList<Character>();
//	Character move;
//	
//	MyCall(ArrayList<Character> game, Character move){
//		board = game;
//		this.move = move;
//	}
//	@Override
//	public Integer call() throws Exception {
//		// TODO Auto-generated method stub
//		boolean bool = true;
//		Integer val = 0;
//		
//		
//		while(bool) {
//			
//		Random r = new Random();
//		val = r.nextInt(9);
//		
//		if(board.get(val) == 'x' || board.get(val) == 'o') {
//				bool = true;
//				
//			}
//		else {bool = false;}	
//		}
//		
//		Thread.sleep(1000);
//		System.out.println("\n" + "player: " + move + " chooses index: "+val);
//		return val;
//	}
//	
//}